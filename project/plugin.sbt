addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.4.0")

addSbtPlugin("com.github.sbt" % "sbt-release" % "1.6.0")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions",
)
