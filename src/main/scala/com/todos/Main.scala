package com.todos

import akka.actor.{Props, ActorSystem, Actor}
import akka.io.IO
import akka.util.Timeout
import spray.can.Http
import spray.routing.HttpService
import scala.concurrent.duration._
import akka.pattern.ask
import spray.http.MediaTypes._

class TodoServiceActor extends Actor with TodoService{

  def actorRefFactory = context

  def receive = runRoute(routes)
}

trait TodoService extends HttpService {

  val routes =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Hello!</h1>
              </body>
            </html>
          }
        }
      }
    }
}

object Boot extends App {

  implicit val system = ActorSystem("todo-service-system")
  val service = system.actorOf(Props[TodoServiceActor], "todo-service")

  implicit val timeout = Timeout(5 seconds)

  IO(Http) ? Http.Bind(service, interface = "localhost", port=5000)
}