// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.5"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

resolvers += "local-link github repo" at "http://voltir.github.io/local-link/"

libraryDependencies ++= Seq(
    "com.stabletech" %%% "local-link" % "0.0.3-SNAPSHOT",
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "com.lihaoyi" %%% "scalatags" % "0.4.5",
    "com.lihaoyi" %%% "scalarx" % "0.2.7",
    "com.lihaoyi" %%% "upickle" % "0.2.6",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
)
