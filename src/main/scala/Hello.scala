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
  } ~ path("isalive") {
    get {
      complete {
        StatusCodes.OK
      }
    }
  }

  val bindingFuture = Http().bindAndHandle(route, "127.0.0.1", 9090)


}
