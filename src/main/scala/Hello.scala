package app


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.headers.Connection
import akka.http.scaladsl.server.Directives.{complete, get, path, _}
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}

object Hello extends App {

  implicit val system = ActorSystem("minimal")

  implicit val materializer: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(system))

  import system.dispatcher

  val route = path("ping") {
    get {
      respondWithHeader(Connection("close")) {
        complete {
          "pong"
        }
      }
    }
  }

  val bindingFuture = Http().bindAndHandle(route, sys.env("POD_IP"), 8080)


}
