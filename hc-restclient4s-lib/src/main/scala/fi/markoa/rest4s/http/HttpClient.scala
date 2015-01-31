package fi.markoa.rest4s.http

import scala.concurrent.{CancellationException, Promise}
import scala.util.Success

import org.apache.http.concurrent.FutureCallback
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient
import org.apache.http.impl.nio.client.HttpAsyncClients
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.HttpResponse


class HttpClient(hc: CloseableHttpAsyncClient) {

  def execute(rq: HttpUriRequest) = {
    val p = Promise[HttpResponse]
    hc.execute(rq, new FutureCallback[HttpResponse] {
      def cancelled = p.failure(new CancellationException("cancelled"))
      def completed(r: HttpResponse) = p.complete(Success(r))
      def failed(ex: Exception) = p.failure(ex)
    })
    p.future
  }

  def start = { hc.start; this }

  def close = hc.close
}

object HttpClient {
  def apply(hc: CloseableHttpAsyncClient) = new HttpClient(hc)
  def apply() = new HttpClient(HttpAsyncClients.createDefault)
}