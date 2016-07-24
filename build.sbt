import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import build._

ReleasePlugin.extraReleaseCommands

sonatypeSettings

autoScalaLibrary := false

crossPaths := false

name := msgpack4zApiName

javacOptions in compile ++= Seq("-target", "6", "-source", "6")

javacOptions in (Compile, doc) ++= Seq("-locale", "en_US")

commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask)

credentials ++= PartialFunction.condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")){
  case (Some(user), Some(pass)) =>
    Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
}.toList

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

scalaVersion := "2.11.8"

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
  scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
)
