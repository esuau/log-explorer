package controller

import model.Connection
import service.Service

import scala.io.Source

object Controller {

  def processFile(filename: String): Unit = {
    val connections: List[Connection] = Service.getHourConnections(Source.fromFile(filename))
    println("List of connections :")
    connections.foreach(println)

    val mostActive = Service.getMostActiveServer(connections)
    if (connections.nonEmpty) println("Most active server : " + mostActive._1 + " with " + mostActive._2 + " initiated connections.")
  }

}
