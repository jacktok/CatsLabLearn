package chapter1.anatomytypeclass.json

object JsonCaller {

  val data = Person(name = "jack tok", email = "jacktok2@gmail.com")
  /**
    * call by Interface object
    */
  import JsonWriterInstance._
  Json.toJson(data)

  /**
    * call by Interface syntax
    */
  import JsonSyntax._
  data.toJson

}
