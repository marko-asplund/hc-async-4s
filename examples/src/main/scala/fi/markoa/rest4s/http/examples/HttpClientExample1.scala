package fi.markoa.rest4s.http.examples

import fi.markoa.rest4s.http.HttpClient
import org.apache.http.client.methods.HttpGet
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object HttpClientExample1 {

  def main(args: Array[String]) = {
    val hc = HttpClient().start
    val f = hc.execute(new HttpGet("http://www.apache.org/")) map { r => println(r.getStatusLine) }
    Await.ready(f, 1.second) // prevent JVM from exiting before response arrives
    hc.close
  }

}
