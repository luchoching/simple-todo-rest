name := """todo-REST"""

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val akkaVersion = "2.4.1"
  val sprayVersion = "1.3.3"

  Seq(
    "io.spray"            %%  "spray-can"     % sprayVersion,
    "io.spray"            %%  "spray-routing" % sprayVersion,
    "io.spray"            %%  "spray-testkit" % sprayVersion  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaVersion
  )
}
