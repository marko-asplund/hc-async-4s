
# JSON/HTTP experiments with Scala

Experimental code for using JSON/HTTP with Scala using different HTTP client and JSON libraries.

## HTTP

There are quite a few HTTP libraries for Scala and Java. Here's a list of evaluation criteria
* either Scala-based or Java-based, but relatively easy to use with Scala.
* pragmatism over functional purism
* support asynchronous communication
* full-featured HTTP support
* proven and widely used
* actively developed

A list HTTP client libraries that passed the criteria:

* Dispatch. Based on Java async-http-client
* ~~spray-client~~
  * requires Akka
* ~~Newman (from StackMob)~~
  * requires Akka
* ~~scalaj-http~~
  * Based on Java URLConnection API, no async support
* ~~Bee-Client~~
  * Based on Java URLConnection API, no async support
* Apache HttpAsyncClient (Java)
* Jetty HTTP Client (Java)


## JSON

Json4s API with Lift JSON (json4s-native)
