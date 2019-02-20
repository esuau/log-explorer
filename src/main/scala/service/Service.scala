package service

import java.util.{Calendar, Date, TimeZone}

import model.Connection

import scala.io.BufferedSource

object Service {

  def getHourConnections(file: BufferedSource): List[Connection] = {
    var result = List[Connection]()
    file.getLines.foreach(s => {
      val line = s.split(' ')
      val logDate = new Date(line(0).toLong * 1000)
      if (isInLastHour(logDate)) result :+= new Connection(logDate, line(1), line(2))
    })
    result
  }

  def getMostActiveServer(connections: List[Connection]): (String, Int) = {
    connections.groupBy(_.sourceHost).mapValues(_.size).maxBy(_._2)
  }

  private def isInLastHour(date: Date): Boolean = {
    val dateMin = Calendar.getInstance()
    val dateMax = Calendar.getInstance()
    dateMin.set(Calendar.HOUR_OF_DAY, dateMin.get(Calendar.HOUR_OF_DAY) - 1)
    date.after(dateMin.getTime) && date.before(dateMax.getTime)
  }

}
