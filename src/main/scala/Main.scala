import controller.Controller

object Main {

  def main(args: Array[String]): Unit = {
    println(Controller.processFile(args(0)))
  }

}
