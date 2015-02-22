package demo

//Fake Data to represent a "User" type that might be common in many projects

import locallink._

import scala.concurrent.{Future, ExecutionContext}

object Users {

  case class User(name: String, age: Int, quote: String, img: String)


  val data = Map("bob" -> User("Bob",42,"I am groot.", "http://placekitten.com/200/300"))

  implicit object UserUrlPart extends UrlPart[User] {
    override val size = 1
    override def toParts(u: User) = List(u.name.toLowerCase)
    def fromParts(parts: List[String])(implicit ec : ExecutionContext): Future[User] = parts match {
      case name :: Nil => {
        parts.headOption.flatMap(data.get).map(Future.successful).getOrElse(Future.failed(new Throwable("Unknown User")))
      }
      case _ => Future.failed(new Throwable("Invalid User URL!"))
    }
  }
}
