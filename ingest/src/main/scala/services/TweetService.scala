package io.tweetwatch.ingest
package services

import com.danielasfregola.twitter4s.TwitterStreamingClient
import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.enums.Language
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.danielasfregola.twitter4s.http.clients.streaming.TwitterStream

import scala.concurrent.Future

class TweetService {
  val client = TwitterStreamingClient()

  def run(): Future[TwitterStream] =
    client.filterStatuses(
      tracks = Seq("#brentford"),
      languages = Seq(Language.English)
    )(printTweetText)

  private def printTweetText: PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet => println(tweet.text)
  }
}
