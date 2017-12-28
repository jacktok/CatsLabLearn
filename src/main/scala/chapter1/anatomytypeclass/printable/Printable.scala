package chapter1.anatomytypeclass.printable

/********************************
  *   define library printable  *
  ********************************/

/**
  * type class
  */
trait Printable[A] {
  def format(value: A): String
}

/**
  * object instances
  */
object PrintableInstance {
  implicit val stringPrintable = new Printable[String] {
    def format(value: String):String = value
  }

  implicit val IntPrintable = new Printable[Int] {
    def format(value: Int): String = value.toString
  }
}

/**
  * object with generic interface
  */
object Printable {
  def format[A](value: A)(implicit w: Printable[A]): String = w.format(value)

  def print[A](value: A)(implicit w: Printable[A]): Unit = println(w.format(value))
}


object PrintableSyntax {
  implicit class PrintOpe[A](value: A){
    def format(implicit w: Printable[A]): String = w.format(value)

    def print(implicit w: Printable[A]): Unit = println(w.format(value))
  }


}
