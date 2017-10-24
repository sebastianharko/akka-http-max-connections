package app


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{complete, get, path, _}
import akka.stream.{ActorMaterializer}

object Hello extends App {

  implicit val system = ActorSystem("minimal")

  implicit val materializer: ActorMaterializer = ActorMaterializer()

  import system.dispatcher

  val route = path("ping") {
    get {
      complete {
        "pong"
      }
    }
  }

  val bindingFuture = Http().bindAndHandle(route, scala.sys.env.getOrElse("POD_IP", "0.0.0.0"), 8080)


}
