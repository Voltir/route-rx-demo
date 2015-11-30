package demo

import upickle._
import locallink._
import concurrent.{Future,ExecutionContext}
import scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import js.annotation.JSExport
import rx._
import scalatags.JsDom.all._
import org.scalajs.dom
import Framework._
import demo.Users._

sealed trait Screen
case object IndexScreen extends Screen
case object AboutScreen extends Screen
case object UsersScreen extends Screen
//case class TestScreen(inp: String) extends Screen todo: Scala.rx 3.1
case class ProfileScreen(user: User) extends Screen

object Demo extends js.JSApp {

  implicit object StringUrlPart extends UrlPart[String] {
    override val size = 1
    override def toParts(inp: String) = List(inp.toLowerCase)
    def fromParts(parts: List[String])(implicit ec : ExecutionContext): Future[String] = parts match {
      case name :: Nil => {
        Future.successful(name)
      }
      case _ => Future.failed(new Throwable("Invalid User URL!"))
    }
  }

  val router = Router.generateWithPrefix[Screen](IndexScreen, "local-link-demo")

  private lazy val current: Rx[HtmlTag] = Rx {
    router.current() match {
      case IndexScreen => screens.Index.screen()
      case AboutScreen => screens.About.screen()
      case UsersScreen => screens.Users.screen()
      //todo: Scala.rx 3.1 related
      //case TestScreen(inp) =>  screens.Test.screen(inp)(ctx)()
      //case TestScreen(inp) => { val meh = screens.Test.screen(inp) ; meh() }
      case ProfileScreen(user) => screens.Profile.screen(user)
    }
  }

  lazy val view = {
    div(current)
  }

  def main(): Unit = {
    dom.document.body.appendChild(view.render)
  }
}
