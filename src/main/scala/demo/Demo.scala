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
case class ProfileScreen(user: User) extends Screen

object Demo extends js.JSApp {

  val router = Router.generate[Screen](IndexScreen)

  private lazy val current: Rx[HtmlTag] = Rx {
    router.current() match {
      case IndexScreen => screens.Index.screen()
      case AboutScreen => screens.About.screen()
      case UsersScreen => screens.Users.screen()
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
