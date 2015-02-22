package demo.screens

import scalatags.JsDom.all._
import Common._

object Index {

  val info =
    """
      |This is a demo application that demonstrates the use of the local-link library.
      |Navigating links should updated url properly, including the use of the forward and back buttons, even though this is still a "single page application".
    """.stripMargin

  def screen(): HtmlTag = {
    page(
      row(columns("twelve")(h3("Local Links Demo"))),
      row(columns("tweleve")(p(info)))
    )
  }
}
