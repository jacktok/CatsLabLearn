package chapter1.meetcats

import chapter1.anatomytypeclass.printable.Cat

object EqEx {
  import cats.Eq

  import cats.instances.int._
  val eqInt: Eq[Int] = Eq[Int]

  eqInt.eqv(12, 12)

  import cats.syntax.eq._
  123 === 123
  123 =!= 1234

  import cats.instances.option._



  (Some(1):Option[Int]) === (Some(2):Option[Int])

  import java.util.Date
  import cats.instances.long._

  implicit val dateEq: Eq[Date] = Eq.instance[Date]{ (d1, d2) => d1.getTime === d2.getTime }
  val x = new Date()
  val y = new Date()

  println(x === y)

  import cats.instances.string._

  implicit val cateEq: Eq[Cat] = Eq.instance[Cat]{ (c1, c2) => c1.name === c2.name && c1.age === c2.age && c1.color === c2.color }

  val cat1 = Cat("Garfield", 35, "orange and black")
  val cat2 = Cat("HeathCliff", 30, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  cat1 === cat2
  optionCat1 === optionCat2

}
