name := "akka-http-max-connections"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.10"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.6"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.6"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.5.6"

fork := true

enablePlugins(JavaAppPackaging)

dockerEntrypoint ++= Seq(
  "-Xms512m",
  "-Xmx4g"
)
