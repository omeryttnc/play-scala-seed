name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.16"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
ThisBuild / scalaVersion := "2.13.16"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "5.5.0"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.45.1.0"
