package com.emc.roger

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by cher5 on 2017/3/10.
  */
@RunWith(classOf[JUnitRunner])
class HelloScala$Test extends FeatureSpec with GivenWhenThen {
  feature("hello from scala") {
    Given("any not empty name")
    val roger = "Roger"

    When("say hello")
    val greeting = HelloScala.sayHello(roger)

    Then("you should get a hello from scala")
    assert(greeting === s"$roger! Hello from Scala")
  }
}
