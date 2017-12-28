package chapter1.meetcats


import chapter1.anatomytypeclass.printable.Cat

object ShowEx {
  import cats.Show
  import cats.instances.int._
  import cats.instances.string._

  val showInt: Show[Int] = Show.apply[Int]
  val showString: Show[String] = Show.apply[String]

  val intAsString: String = showInt.show(123)
  val stringAsString: String = showString.show("myString")

  import cats.syntax.show._
  println(1234.show)
  println("test show".show)

  import java.util.Date

  implicit val dateShow: Show[Date] = Show.show(date => s"${date.getTime} ms since the epoch.")

  println(s"now time is => ${new Date().show}")


  val data = Cat(name = "showing", age = 8, color = "pink")
  implicit val catShow: Show[Cat] = Show.show{c =>
    val name = c.name.show
    val age = c.age.show
    val color = c.color.show
    s"$name is a $age year-odl $color cat."
  }

  println(s"my cat is => ${data.show}")
}
