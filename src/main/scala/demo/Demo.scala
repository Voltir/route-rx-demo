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
case object DemoScreen extends Screen
case object AboutScreen extends Screen
case class ProfileScreen(user: User) extends Screen

object Demo extends js.JSApp {

  println(upickle.write(DemoScreen))

  val router = Router.generate[Screen](DemoScreen)
//
//
//  private lazy val current: Rx[HtmlTag] = Rx {
//    router.current() match {
//      case DemoScreen => div("DEMO")
//      case AboutScreen => div("ABOUT")
//      case ProfileScreen(user) => div("PROFILE")
//    }
//  }

  def main(): Unit = {
    val paragraph = dom.document.createElement("p")
    paragraph.innerHTML = "<strong>WIP!</strong>"


    dom.document.getElementById("playground").appendChild(paragraph)
  }
}
