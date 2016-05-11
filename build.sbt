import com.lihaoyi.workbench.Plugin._

// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

workbenchSettings

//http://localhost:12345/index-fastopt.html
bootSnippet := "ScalaJSExample().main(document.getElementById('content'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "com.stabletechs" %%% "routerx" % "1.1.1",
  "com.stabletechs" %%% "frameworkrx" % "0.1.1-SNAPSHOT",
  "org.scala-js" %%% "scalajs-dom" % "0.9.0",
  "com.lihaoyi" %%% "scalatags" % "0.5.5",
  "com.lihaoyi" %%% "scalarx" % "0.3.1",
  "com.lihaoyi" %%% "upickle" % "0.3.7",
  "com.lihaoyi" %%% "utest" % "0.3.1"
)
