package demo.screens

import demo.screens.Common._

import scalatags.JsDom.all._

object About {

  val info =
    """
      |The Local Link library uses scala macros to take a sealed trait that describes all the possible "screens" in the
      |application, and generates a mapping from them to urls, as well as calls to the browsers History API, making
      |the single page app behave more like a "real" web page.
    """.stripMargin

  def screen(): HtmlTag = {
    page(
      row(columns("twelve")(h3("About Page"))),
      row(columns("tweleve")(p(info)))
    )
  }
}
