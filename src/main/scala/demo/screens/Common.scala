package demo.screens

import scalatags.JsDom.all._

object Common {

  val v: HtmlTag = a(href:="javascript:void(0)")

  def row: HtmlTag = div(cls:="row")

  def columns(classes: String) = div(cls:="columns " + classes)

  lazy val nav: HtmlTag = row(
    columns("two")(v("Index", onclick:={() => demo.Demo.router.goto(demo.IndexScreen)})),
    //columns("two")(v("Fizzle", onclick:={() => demo.Demo.router.goto(demo.TestScreen("Fizzle"))})),
    //columns("two")(v("Pop", onclick:={() => demo.Demo.router.goto(demo.TestScreen("Pop"))})),
    columns("two")(v("About", onclick:={() => demo.Demo.router.goto(demo.AboutScreen)})),
    columns("two")(v("Users", onclick:={() => demo.Demo.router.goto(demo.UsersScreen)}))
  )

  def page(rows: HtmlTag *): HtmlTag = div(cls:="container")(nav,rows)


}
