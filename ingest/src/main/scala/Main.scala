package io.tweetwatch.ingest

import services.TweetService

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {
  val service = new TweetService()
  println("Starting stream")
  val stream = service.run()
  println("Awaiting stream result")
  val r = Await.result(stream, Duration.Inf)
  println(r)
  Thread.sleep(10000)
}
