package demo.screens

import org.scalajs.dom
import rx._
import demo.Users.User
import demo.screens.Common._
import demo.Framework._

import scalatags.JsDom.all._
object Test {

  val thing: Var[String] = Var("")

  val tick: Var[Int] = Var(0)

  dom.setInterval(() => tick() = tick.now + 1,1000)

  def nested()(implicit ctx: RxCtx): Rx[HtmlTag] = Rx {
    println("RX FIRED!")
    h4(if(tick() % 2 == 0) "EVEN" else "ODD")
  }


  //In scala.rx 0.2.x, code similar to this would leak like crazy and basically halt the browser.
  object ExampleLotsOfRx {
    val a = Var(10)
    def x()(implicit ctx: RxCtx) = Rx { a(); for (i <- 0 until 100) yield y() }
    def y()(implicit ctx: RxCtx) = Rx{ println("Rxing!") ; a() }
  }

  //def screen(inp: String): Rx[HtmlTag] = Rx { //this would leak
  def screen(inp: String)(implicit ctx: RxCtx): Rx[HtmlTag] = Rx {
    ExampleLotsOfRx.a() = ExampleLotsOfRx.a.now + 1
    println(ExampleLotsOfRx.x.now)
    page(
      row(columns("twelve")(h3("Rx? " + inp))),
      row(columns("twelve")(h3(thing()))),
      row(columns("twelve")(h3(tick()))),
      row(columns("twelve")(h3(nested())))
    )
  }
}
