val akkaVer = "2.4.0"
val assertjVer = "3.0.0"
val junitVer = "0.11"
val logbackVer = "1.1.3"
val quavaVer = "18.0"
val scalaVer = "2.11.7"
val scalaParsersVer= "1.0.4"

lazy val compileOptions = Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

lazy val commonDependencies = Seq(
  "com.google.guava"         %  "guava"                      % quavaVer,
  "com.typesafe.akka"        %% "akka-actor"                 % akkaVer,
  "com.typesafe.akka"        %% "akka-slf4j"                 % akkaVer,
  "ch.qos.logback"           %  "logback-classic"            % logbackVer,
  "org.scala-lang.modules"   %% "scala-parser-combinators"   % scalaParsersVer,
  "com.typesafe.akka"        %% "akka-testkit"               % akkaVer            % Test,
  "com.novocode"             %  "junit-interface"            % junitVer           % Test,
  "org.assertj"              %  "assertj-core"               % assertjVer         % Test
)

lazy val exercise_three = project in file(".")
name := "coffee-house"
organization := "com.typesafe.training"
version := "1.0.0"
scalaVersion := scalaVer
scalacOptions ++= compileOptions
unmanagedSourceDirectories in Compile := List((javaSource in Compile).value)
unmanagedSourceDirectories in Test := List((javaSource in Test).value)
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")
EclipseKeys.withSource := true
parallelExecution in Test := false
logBuffered in Test := false
parallelExecution in ThisBuild := false
javacOptions += "-Xlint:unchecked"
libraryDependencies ++= commonDependencies
