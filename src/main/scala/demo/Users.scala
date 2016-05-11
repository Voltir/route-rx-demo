package demo

//Fake Data to represent a "User" type that might be common in many projects

import routerx._

import scala.concurrent.{Future, ExecutionContext}

object Users {

  case class User(name: String, age: Int, quote: String, img: String)

  val data = Map(
    "nick" -> User("Nick",51,"Well, I’m one of those fortunate people who like my job, sir. Got my first chemistry set when I was seven, blew my eyebrows off, we never saw the cat again, been into it ever since.", "http://www.placecage.com/200/300"),
    "fluffy" -> User("Fluffy",4,"meow.", "http://placekitten.com/g/200/300"),
    "groot" -> User("Groot",372,"I Am Groot", "http://i.imgur.com/Tt13gCE.png"),
    "bob" -> User("Bob",42,"Generic User Object.", "http://placehold.it/200x300")
  )

  implicit object UserUrlPart extends UrlPart[User] {
    override val size = 1
    override def toParts(u: User) = List(u.name.toLowerCase)
    def fromParts(parts: List[String])(implicit ec : ExecutionContext): Future[User] = parts match {
      case name :: Nil =>
        parts.headOption.flatMap(data.get).map(Future.successful).getOrElse(Future.failed(new Throwable("Unknown User")))
      case _ => Future.failed(new Throwable("Invalid User URL!"))
    }
  }
}
