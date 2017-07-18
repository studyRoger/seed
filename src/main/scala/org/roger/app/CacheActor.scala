package org.roger.app

import akka.actor.{Actor, ActorLogging, Props}

object CacheActor {

  def props() = Props(new CacheActor)

  sealed trait CacheEvent
  case class Merge(key: String, value: String) extends CacheEvent
  case class Get(key: String) extends CacheEvent
  case class GetCache() extends CacheEvent
}

class CacheActor extends Actor with ActorLogging {
  import scala.collection.mutable
  import org.roger.app.CacheActor._

  val cache = new mutable.HashMap[String, String]()

  override def receive: Receive = {
    case Merge(key, value) => merge(key, value)
    case Get(key) => sender() ! get(key)
    case GetCache => sender() ! cache
    case _ => log.info("unknown event is ignored! ")
  }

  private def merge(key: String, value: String) = {
    log.info(s"get key: $key, value: $value")
    cache.put(key, value)
  }

  private def get(key: String): Option[String] = {
    log.info(s"query key: $key")
    cache.get(key)
  }
}