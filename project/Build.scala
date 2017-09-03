object build {

  def gitHash: String =
    sys.process.Process("git rev-parse HEAD").lineStream_!.head

  val msgpack4zApiName = "msgpack4z-api"

  val modules = msgpack4zApiName :: Nil

  val unusedWarnings = (
    "-Ywarn-unused" ::
    "-Ywarn-unused-import" ::
    Nil
  )
}
