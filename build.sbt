name := "slick_postgres_example"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "com.typesafe.slick" %% "slick" % "2.1.0", // for Main2 change version to 3.2.3
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)