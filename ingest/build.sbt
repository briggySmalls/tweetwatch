ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"

lazy val root = (project in file("."))
  .settings(
    name := "ingest",
    idePackagePrefix := Some("io.tweetwatch.ingest")
  )

val elastic4sVersion = "8.4.2"

libraryDependencies ++= Seq(
  "com.danielasfregola" %% "twitter4s" % "8.0",
  "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % elastic4sVersion,
  "com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.4.1"
)
