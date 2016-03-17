name := "Raflix"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.sparkjava" % "spark-core" % "2.3",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "com.google.code.gson" % "gson" % "2.6.2",
  "com.sparkjava" % "spark-template-freemarker" % "2.3"
)
    