package demo.screens

import demo.Users.User
import demo.screens.Common._

import scalatags.JsDom.all._

object Profile {

  val listUsers = ul(demo.Users.data.map { case (uid,user) =>
    li(s"Name: ${user.name} Age: ${user.age}: ")(v("View Profile", onclick:={() => demo.Demo.router.goto(demo.ProfileScreen(user))}))
  }.toSeq)

  def screen(user: User): HtmlTag = {
    page(
      row(columns("twelve")(h3(s"Profile: ${user.name}"))),
      row(columns("twelve")(img(src:=user.img))),
      row(columns("twelve")(p(user.quote))),
      row(columns("tweleve")(listUsers))
    )
  }
}
