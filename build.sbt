name := """quill-embedded-insert"""

version := "1.0-SNAPSHOT"

organization := "com.example"

scalaVersion := "2.11.10"

libraryDependencies ++= Seq(
  "io.getquill"       %% "quill" % "1.1.0",
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP5" % Test
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

wartremoverErrors in (Compile, compile) ++= Warts.unsafe