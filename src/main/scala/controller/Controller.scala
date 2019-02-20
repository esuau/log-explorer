package controller

import model.Connection
import service.Service

import scala.io.Source

object Controller {

  def processFile(filename: String): List[Connection] = {
    val connections: List[Connection] = Service.getHourConnections(Source.fromFile(filename))
    connections
  }

}
