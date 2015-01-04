import sbt._, Keys._
import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys

object build extends Build {

  private def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  private val msgpack4zApiName = "msgpack4z-api"

  val modules = msgpack4zApiName :: Nil

  lazy val msgpack4zApi = Project("msgpack4z-api", file(".")).settings(
    ReleasePlugin.releaseSettings ++ ReleasePlugin.extraReleaseCommands ++  sonatypeSettings: _*
  ).settings(
    autoScalaLibrary := false,
    crossPaths := false,
    name := msgpack4zApiName,
    javacOptions in compile ++= Seq("-target", "6", "-source", "6"),
    commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask),
    credentials ++= PartialFunction.condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")){
      case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
    }.toList,
    organization := "com.github.xuwei-k",
    homepage := Some(url("https://github.com/msgpack4z")),
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    scalacOptions ++= (
      "-deprecation" ::
      "-unchecked" ::
      "-Xlint" ::
      "-language:existentials" ::
      "-language:higherKinds" ::
      "-language:implicitConversions" ::
      "-Ywarn-unused" ::
      "-Ywarn-unused-import" ::
      Nil
    ),
    scalaVersion := "2.11.4",
    crossScalaVersions := scalaVersion.value :: Nil,
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
    ,
    description := "msgpack4z api"
  )

}
