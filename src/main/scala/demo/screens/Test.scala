package demo.screens

import org.scalajs.dom
import rx._
import demo.Users.User
import demo.screens.Common._
import demo.Framework._

import scalatags.JsDom.all._
object Test {

  val thing: Var[String] = Var("")

  val otherThing: Var[Int] = Var(0)

  dom.setInterval(() => otherThing() = otherThing.now + 1,1000)

  //def nested()(implicit ctx: RxCtx): Rx[HtmlTag] = Rx {
  //  println("RX FIRED!")
  //  h4(if(otherThing() % 2 == 0) "EVEN" else "ODD")
  //}


  object Foo{
    val a = Var(10)
    val x = Rx{ a(); for (i <- 0 until 100) yield y() }
    def y() = Rx{ println("OMG Y") ; a() }
    a() = 1
    a() = 12
  }

  def screen(inp: String): Rx[HtmlTag] = Rx { // goal: Make this a compile time error
  //def screen(inp: String)(implicit ctx: RxCtx): Rx[HtmlTag] = Rx {
    //Foo.a() = Foo.a.now + 1
    //println(Foo.x.now)
    page(
      row(columns("twelve")(h3("Test?"))),
      row(columns("twelve")(h3(thing()))),
      row(columns("twelve")(h3(otherThing())))
      //row(columns("twelve")(h3(nested())))
    )
  }
}
