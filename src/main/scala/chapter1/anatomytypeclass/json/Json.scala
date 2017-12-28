package chapter1.anatomytypeclass.json


/**
  * type class instance
  */
trait Json

final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json

trait JsonWriter[A] {
  def write(value: A): Json
}


/**
  * type class instance
  */
final case class Person(name: String, email: String)

object JsonWriterInstance {
  implicit val stringJsonWriter = new JsonWriter[String] {
    def write(value: String): Json = JsString(value)
  }

  implicit val personJsonWriter = new JsonWriter[Person] {
    def write(value: Person): Json = JsObject(Map(
      "name" -> JsString(value.name),
      "email" -> JsString(value.name)
    ))
  }

}

/**
  * Interface
  *   1. Interface object
  *   2. Interface Syntax
  */


/**
  * Interface object
  */
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}


/**
  * Interface Syntax
  */
object JsonSyntax {
  implicit class JsonWriteObject[A](value: A){
    def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
  }
}