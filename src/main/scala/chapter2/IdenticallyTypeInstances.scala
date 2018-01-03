package chapter2

object IdenticallyTypeInstances {
  /**
    * override |+| of int to *
    */

    import cats.Monoid

  implicit val multiplicationMonoidInt = new Monoid[Int]{
    override def empty: Int = 1

    override def combine(x: Int, y: Int): Int = x * y
  }


  import cats.syntax.semigroup._

  println(s"identically int 5 |+| 4 => ${5 |+| 4}")

}
