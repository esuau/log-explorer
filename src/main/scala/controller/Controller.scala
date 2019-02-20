package controller

import model.Connection
import service.Service

import scala.io.Source

object Controller {

  def processFile(filename: String): Unit = {
    val lastHourConnections: List[Connection] = Service.getHourConnections(Source.fromFile(filename))
    println("Last hour connections :")
    lastHourConnections.foreach(println)

    val mostActive = Service.getMostActiveServer(lastHourConnections)
    if (lastHourConnections.nonEmpty) println("Most active server : " + mostActive._1 + " with " + mostActive._2 + " initiated connections.")
  }

}
