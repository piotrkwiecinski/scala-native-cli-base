import scopt.OptionParser

object HelloWorld {
  def main(args: Array[String]): Unit = {
    case class Config(name: String = "anonymous")

    val parser = new OptionParser[Config]("helloworld") {
      head("helloworld", "0.1")

      arg[String]("name")
        .unbounded()
        .optional()
        .action( (x, c) => c.copy(name = x) ).text("Your name")
    }

    parser.parse(args, Config()) match {
      case Some(config) => println(s"Hello ${config.name}")

      case None =>
        println("Error")
    }
  }
}
