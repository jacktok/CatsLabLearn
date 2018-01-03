package chapter3

object ContraMap {

  /**
    * F[A].contramap(A => B) = F[B]
    * if we have printable A and function A => B and contra map
    * we can create printable B
    * but some type no contra map i.e. option
    *
    */
  trait Printable[A] {
    def format(value: A): String

    def contramap[B](func: B => A): Printable[B] = {
      val self = this
      new Printable[B] {
        override def format(value: B): String = self.format(func(value))
      }
    }
  }

  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  implicit val stringPrintable =
    new Printable[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }
  implicit val booleanPrintable =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if(value) "yes" else "no"
    }
  println(s"format ${format("hello")} ")
  format(true)
  final case class Box[A](value: A)

  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] = p.contramap[Box[A]](_.value)

  println("contramap => " + format(Box(true)))

}
