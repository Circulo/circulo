name := """circulo"""

version := "1.0-SNAPSHOT"

lazy val core = RootProject(uri("https://github.com/Circulo/circulo-core.git"))

lazy val root = (project in file("."))
	.enablePlugins(PlayJava)
	.dependsOn(core)
	.aggregate(core)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
