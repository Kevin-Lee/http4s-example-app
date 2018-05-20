package io.kevinlee.http4sexampleapp

import cats.effect.Effect
import io.circe.Json
import org.http4s.HttpService
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl

class HelloWorldService[F[_]: Effect] extends Http4sDsl[F] {

  val service: HttpService[F] = HttpService[F] {
      case GET -> Root =>
        Ok(Json.obj("message" -> Json.fromString("Hello, World")))

      case GET -> Root / name =>
        Ok(Json.obj("message" -> Json.fromString(s"Hello, $name")))

      case GET -> Root / "add" / IntVar(a) / IntVar(b) =>
        Ok(
        Json.obj("result" -> Json.fromLong(a.toLong + b.toLong))
        )
    }
}
