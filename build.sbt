
name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"
scalaVersion := "2.13.16"


lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  guice,
  guice,
  "com.typesafe.play" %% "play-slick" % "5.4.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.4.0",
  "org.xerial" % "sqlite-jdbc" % "3.49.1.0"
)