package chapter1.anatomytypeclass.printable

/**
  * using library
  */
final case class Cat(name: String, age: Int, color: String)


object UsingLibrary {
  import PrintableInstance._
  implicit val catPrintable: Printable[Cat] = (value: Cat) => s"${Printable.format(value.name)} is a " +
    s"${Printable.format(value.age)} year-old " +
    s"${Printable.format(value.color)} cat."


  val data = Cat(name = "morgan", age = 7, color = "black")

  Printable.format(data)

  Printable.print(data)


  import PrintableSyntax._

  data.format

  data.print

}