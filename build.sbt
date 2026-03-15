import sbtrelease._
import build._

ReleasePlugin.extraReleaseCommands

autoScalaLibrary := false

crossPaths := false

name := msgpack4zApiName

compile / javacOptions ++= Seq("-target", "6", "-source", "6")

Compile / doc / javacOptions ++= Seq("-locale", "en_US")

commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask)

organization := "com.github.xuwei-k"

homepage := Some(url("https://github.com/msgpack4z"))

licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php"))

scalacOptions ++= (
  "-deprecation" ::
  "-unchecked" ::
  "-Xlint" ::
  "-language:existentials" ::
  "-language:higherKinds" ::
  "-language:implicitConversions" ::
  Nil
) ::: unusedWarnings

scalaVersion := "2.12.8"

crossScalaVersions := scalaVersion.value :: Nil

pomExtra :=
  <developers>
    <developer>
      <id>xuwei-k</id>
      <name>Kenji Yoshida</name>
      <url>https://github.com/xuwei-k</url>
    </developer>
  </developers>
  <scm>
    <url>git@github.com:msgpack4z/msgpack4z-api.git</url>
    <connection>scm:git:git@github.com:msgpack4z/msgpack4z-api.git</connection>
    <tag>{if(isSnapshot.value) gitHash else { "v" + version.value }}</tag>
  </scm>

description := "msgpack4z api"

Seq(Compile, Test).flatMap(c =>
  c / console / scalacOptions --= unusedWarnings
)

publishTo := (if (isSnapshot.value) None else localStaging.value)
