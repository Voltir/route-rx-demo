package demo.screens

import rx._
import demo.screens.Common._
import framework.Framework._
import scala.scalajs.js
import scalatags.JsDom.all._
object Test {

  val thing: Var[String] = Var("")

  val tick: Var[Int] = Var(0)

  js.timers.setInterval(1000)(tick() = tick.now + 1)

  def nested()(implicit ctx: Ctx.Owner): Rx[HtmlTag] = Rx {
    println("RX FIRED!")
    h4(if(tick() % 2 == 0) "EVEN" else "ODD")
  }


  //In scala.rx 0.2.x, code similar to this would leak like crazy and basically halt the browser.
  object ExampleLotsOfRx {
    val a = Var(10)
    def x()(implicit ctx: Ctx.Owner) = Rx { a(); for (i <- 0 until 100) yield y() }
    def y()(implicit ctx: Ctx.Owner) = Rx{ println("Rxing!") ; a() }
  }

  //def screen(inp: String): Rx[HtmlTag] = Rx { //this would leak
  def screen(inp: String)(implicit ctx: Ctx.Owner): Rx[HtmlTag] = Rx {
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
