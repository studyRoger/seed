package org.roger.app

import akka.actor.ActorSystem
import akka.event.Logging
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by roger on 2017/3/10.
  */
object HelloAkkaActorSystem extends App {
  import CacheActor._
  implicit val timeout = Timeout(10 seconds)

  val config = ConfigFactory.load("application")
  val system = ActorSystem("HelloAkka", config)
  val log = Logging(system.eventStream, "hello-akka")
  val actor = system.actorOf(CacheActor.props())

  actor ! Merge("key", "value")
  val response = actor ? Get("key")
  response.mapTo[Option[String]].foreach(option => log.info(s"key: 'key', value: '${option.get}'"))

  Await.result(response, 10 second)
  system.terminate()
}
