object build {

  def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  val msgpack4zApiName = "msgpack4z-api"

  val modules = msgpack4zApiName :: Nil

  val unusedWarnings = (
    "-Ywarn-unused" ::
    "-Ywarn-unused-import" ::
    Nil
  )
}
