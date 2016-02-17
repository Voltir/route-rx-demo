package demo

import locallink._
import scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import rx._
import scalatags.JsDom.all._
import org.scalajs.dom
import demo.Users._
import framework.Framework._

sealed trait Screen
case object IndexScreen extends Screen
case object AboutScreen extends Screen
case object UsersScreen extends Screen
case class TestScreen(inp: String) extends Screen
case class ProfileScreen(user: User) extends Screen

//Uses the default UrlParts provided in locallink.implicits
object Demo extends js.JSApp with locallink.implicits.Defaults {

  val router = Router.generateWithPrefix[Screen](IndexScreen, "local-link-demo")

  private lazy val current: Rx[HtmlTag] = Rx {
    router.current() match {
      case IndexScreen => screens.Index.screen()
      case AboutScreen => screens.About.screen()
      case UsersScreen => screens.Users.screen()
      case TestScreen(inp) => {
        val dynamicScreen = screens.Test.screen(inp)
        dynamicScreen()
      }
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
