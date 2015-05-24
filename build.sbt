import play.PlayScala
import play.PlayJava

name := """circulo"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

// Module settings
val common = (project in file("modules/common"))

val http = (project in file("modules/http")).enablePlugins(PlayScala, PlayJava).settings(
).dependsOn(common)

val root = (project in file(".")).enablePlugins(PlayScala, PlayJava).aggregate(common, http)