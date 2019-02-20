package controller

import model.Connection
import service.Service

import scala.io.Source

object Controller {

  def processFile(filename: String): Unit = {
    val lastHourConnections: List[Connection] = Service.getHourConnections(Source.fromFile(filename))
    println("Last hour connections:")
    lastHourConnections.foreach(println)

    if (lastHourConnections.nonEmpty) {
      val mostActive = Service.getMostActiveServer(lastHourConnections)
      println(s"Most active server: ${mostActive._1} with ${mostActive._2} initiated connections.")

      val mostRecentConnection = Service.getMostRecentConnection(lastHourConnections)
      println(s"Most recent connection: ${mostRecentConnection.sourceHost} to ${mostRecentConnection.targetHost} on ${mostRecentConnection.time}")
    }
  }

}
