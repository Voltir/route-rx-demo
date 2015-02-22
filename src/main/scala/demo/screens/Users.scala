package demo.screens

import demo.screens.Common._

import scalatags.JsDom.all._

object Users {

  val listUsers = ul(demo.Users.data.map { case (uid,user) =>
    li(s"Name: ${user.name} Age: ${user.age}: ")(v("View Profile", onclick:={() => demo.Demo.router.goto(demo.ProfileScreen(user))}))
  }.toSeq)

  def screen(): HtmlTag = {
    page(
      row(columns("twelve")(h3("View Users"))),
      row(columns("tweleve")(listUsers))
    )
  }

}
