name := """common"""

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.springframework" % "spring-oxm" % "4.0.7.RELEASE",
  "org.springframework" % "spring-orm" % "4.0.7.RELEASE",
  "org.springframework" % "spring-tx" % "4.0.7.RELEASE",
  "org.springframework" % "spring-test" % "4.0.7.RELEASE",
  "org.springframework.data" % "spring-data-jpa" % "1.7.1.RELEASE",
  "org.springframework.data" % "spring-data-mongodb" % "1.7.0.RELEASE",
  "org.mongodb" % "mongo-java-driver" % "3.0.1",
  "org.kubek2k" % "springockito" % "1.0.9",
  "org.kubek2k" % "springockito-annotations" % "1.0.9",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  "org.hibernate" % "hibernate-core" % "4.3.7.Final",
  "commons-dbcp" % "commons-dbcp" % "1.4"
)