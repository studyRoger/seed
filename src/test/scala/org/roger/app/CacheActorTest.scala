package org.roger.app

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.roger.app.CacheActor.{Get, GetCache, Merge}
import org.roger.app.CacheActorTest._
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

import scala.collection.mutable


/**
  * Created by roger on 2017/7/18.
  */
class CacheActorTest extends TestKit(testSystem)
  with WordSpecLike
  with ImplicitSender
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "CacheActor" should {
    "update cache with the given key-value" in {
      val cacheActor = testSystem.actorOf(CacheActor.props())
      cacheActor ! Merge("key1", "value1")
      cacheActor ! Merge("key2", "value2")
      cacheActor ! Merge("key2", "value22")
      expectNoMsg()

      cacheActor ! GetCache
      val cache = expectMsgType[mutable.Map[String, String]]

      assert(cache.size === 2)
      assert(cache.get("key1").nonEmpty)
      assert(cache.get("key1") === Some("value1"))
      assert(cache.get("key2").nonEmpty)
      assert(cache.get("key2") === Some("value22"))
    }


    "return value for the given key" in {
      val cacheActor = testSystem.actorOf(CacheActor.props())
      cacheActor ! Merge("key1", "value1")
      expectNoMsg()

      cacheActor ! Get("key1")
      expectMsg(Some("value1"))

      cacheActor ! Get("keyx")
      expectMsg(None)

    }
  }
}


object CacheActorTest {
  val testSystem = {
    val config = ConfigFactory.parseString(
      """
         akka.loggers = [akka.testkit.TestEventListener]
      """)
    ActorSystem("HelloAkka", config)
  }
}
