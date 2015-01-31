
name := "hc-restclient4s"

lazy val commonSettings = Seq(
  organization := "fi.markoa",
  version := "0.0.1",
  scalaVersion := "2.11.5",
  libraryDependencies += "org.apache.httpcomponents" % "httpasyncclient" % "4.0.2"
)

lazy val root = project
  .settings(commonSettings: _*)
  .aggregate(examples, hcRestClient4sLib)

lazy val examples = project
  .settings(commonSettings: _*)
  .dependsOn(hcRestClient4sLib)

lazy val hcRestClient4sLib = project.in( file("hc-restclient4s-lib") )
  .settings(commonSettings: _*)

