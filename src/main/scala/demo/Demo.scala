package demo

import routerx._
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
case object DebugScreen extends Screen
case class TestScreen(inp: String) extends Screen
case class ProfileScreen(user: User) extends Screen

//Uses the default UrlParts provided in locallink.implicits
object Demo extends js.JSApp with routerx.implicits.Defaults {

  val router = Router.generateWithPrefix[Screen](DebugScreen, "router-rx-demo")

  //Uses Rx[Frag] instead of Rx[HtmlTag] because while most of the screen() functions return a static HtmlTag
  //Test.screen(...) does not. It returns a Rx[HtmlTag]. Both HtmlTag and Rx[HtmlTag] are implicitly
  //convertible to a scalatags' Frag, but scalac can't figure that out without the explicit type
  //annotation on current.
  private lazy val current: Rx[Frag] = Rx {
    router.current() match {
      case IndexScreen => screens.Index.screen()
      case AboutScreen => screens.About.screen()
      case UsersScreen => screens.Users.screen()
      case TestScreen(inp) => screens.Test.screen(inp)
      case ProfileScreen(user) => screens.Profile.screen(user)
      case DebugScreen => screens.Debug.screen()
    }
  }

  lazy val view = {
    div(current)
  }

  def main(): Unit = {
    dom.document.body.appendChild(view.render)
  }
}
