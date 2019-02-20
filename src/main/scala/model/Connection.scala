package model

import java.util.Date

class Connection(var time: Date, var sourceHost: String, var targetHost: String) {
  override def toString = s"date: $time, source host: $sourceHost, target host: $targetHost"
}
