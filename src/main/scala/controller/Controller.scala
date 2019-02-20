package controller

import model.Connection
import service.Service

import scala.io.Source

object Controller {

  def processFile(filename: String): Unit = {
    val lastHourConnections: List[Connection] = Service.getHourConnections(Source.fromFile(filename))

    if (lastHourConnections.nonEmpty) {
      println("Last hour connections:")
      lastHourConnections.foreach(println)

      val mostActive = Service.getMostActiveServer(lastHourConnections)
      println(s"Most active server: ${mostActive._1} with ${mostActive._2} initiated connections.")

      val mostRecentConnection = Service.getMostRecentConnection(lastHourConnections)
      println(s"Most recent connection: ${mostRecentConnection.sourceHost} to ${mostRecentConnection.targetHost} on ${mostRecentConnection.time}")
    } else {
      println("No connection performed during the last hour.")
    }
  }

}
