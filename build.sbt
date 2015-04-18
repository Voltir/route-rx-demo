// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

resolvers += "local-link github repo" at "http://voltir.github.io/local-link/"

libraryDependencies ++= Seq(
    "com.stabletech" %%% "local-link" % "0.0.4-SNAPSHOT",
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "com.lihaoyi" %%% "scalatags" % "0.5.1",
    "com.lihaoyi" %%% "scalarx" % "0.2.8",
    "com.lihaoyi" %%% "upickle" % "0.2.7",
    "com.lihaoyi" %%% "utest" % "0.3.1" 
)
