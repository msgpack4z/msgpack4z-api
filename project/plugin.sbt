addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.3.1")

addSbtPlugin("com.github.sbt" % "sbt-release" % "1.5.0")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions",
)
