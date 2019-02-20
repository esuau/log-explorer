import java.util.{Timer, TimerTask}
import controller.Controller

object Main {

  def main(args: Array[String]): Unit = {
    val timer = new Timer()
    val hourlyTask = new TimerTask() {
      override def run(): Unit = {
        Controller.processFile(args(0))
      }
    }
    timer.schedule(hourlyTask, 1, 3600000)
  }

}
