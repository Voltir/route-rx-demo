package demo.screens

import demo.screens.Common._

import scalatags.JsDom.all._

object About {

  val info =
    """
      |The Local Link library uses scala macros that turns a sealed trait into a set of valid internal links for the
      |application. It generates a mapping between the children of the sealed traits to url strings, as well as calls
      |triggers calls to the browsers History API, allowing the single page app behave more like a set of real web pages.
      |
      |This library only attempts to solve the issue from the browser side - appropriate steps must be taken by the
      |web server to handle routing from external links and generate the appropriate state for the scala.js client in order
      |for local-links to behave exactly as normal http urls.
    """.stripMargin

  def screen(): HtmlTag = {
    page(
      row(columns("twelve")(h3("About Page"))),
      row(columns("tweleve")(p(info)))
    )
  }
}
