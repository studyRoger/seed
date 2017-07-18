package org.roger.app

import akka.actor.{Actor, Props}
import akka.util.Timeout

object CacheActor {

  def props() = Props(new CacheActor)

  sealed trait CacheEvent
  case class Merge(key: String, value: String) extends CacheEvent
  case class Get(key: String) extends CacheEvent
}

class CacheActor extends Actor {
  import scala.collection.mutable
  import org.roger.app.CacheActor._

  val cache = new mutable.HashMap[String, String]()

  override def receive: Receive = {
    case Merge(key, value) => cache.put(key, value)
    case Get(key) => sender() ! cache.get(key)
    case _ => println("I don't know what are you talking about")
  }
}