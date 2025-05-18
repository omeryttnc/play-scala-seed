
name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"
scalaVersion := "2.13.16"


lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.slick" %% "slick" % "3.6.1",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.6.1",
  "org.xerial" % "sqlite-jdbc" % "3.49.1.0"
)