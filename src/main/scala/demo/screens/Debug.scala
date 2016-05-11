package demo.screens

import demo.screens.Common._
import rx._
import framework.Framework._

import scalatags.JsDom.all._

object Debug {

  val foo = Var(0)

  val nope = row(
    Rx { println("Ok.."); p(id:="nope")(foo()*2) }
  )

  val works = Rx {
    row(p(foo()*2))
  }

  def anRx()(implicit ctx: Ctx.Owner) = row(
    Rx { p(foo()) },
    v(onclick:={() => foo() = foo.now + 1})("Inc...")
  )

  def screen()(implicit ctx: Ctx.Owner): HtmlTag = {
    page(
      row(columns("twelve")(h3("Debug"))),
      row(columns("tweleve")(p("Debug"))),
      anRx(),
      nope,
      works
    )
  }
}
