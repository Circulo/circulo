import play.PlayScala
import play.PlayJava

name := """circulo"""

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.4"

// Module settings
lazy val common = (project in file("./common"))

lazy val root = (project in file("."))
	.enablePlugins(PlayScala, PlayJava)
  	.settings(
    	aggregate in update := true
  	)
  	.aggregate(common)
  	.dependsOn(common)