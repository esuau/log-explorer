import controller.Controller

object Main {

  def main(args: Array[String]): Unit = {
    Controller.processFile(args(0))
  }

}
