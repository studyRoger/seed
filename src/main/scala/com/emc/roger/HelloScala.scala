package com.emc.roger

/**
  * Created by cher5 on 2017/3/10.
  */
object HelloScala {
  def main(args: Array[String]):Unit = {
    args.foreach(sayHello)
  }

  def sayHello(name: String): String = {
    name + "! Hello from Scala"
  }
}
