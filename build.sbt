name := "Hello-Akka"

version := "1.0"

scalaVersion :="2.12.1"

libraryDependencies ++= {
  val akkaVersion = "2.4.14"
  val akkaHttpVersion = "10.0.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.6",

    "com.typesafe.akka" %%  "akka-testkit" % akkaVersion   % "test",
    "org.scalatest"     %%  "scalatest"    % "3.0.0"       % "test"
  )
}