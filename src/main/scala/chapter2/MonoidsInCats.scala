package chapter2

object MonoidsInCats {

  import cats.Monoid
  import cats.instances.string._

  Monoid[String].combine("hello", " jack tok")

  Monoid[String].empty

  import cats.instances.int._
  import cats.instances.option._
  import cats.syntax.option._
  val opt1 = 22.some
  val opt2 = 44.some
  val optResult = Monoid[Option[Int]].combine(opt1, opt2)
  import cats.syntax.semigroup._
  val xxx =  "xxx " |+| "sds" |+| Monoid[String].empty


  1 |+| 2 |+| Monoid[Int].empty


  println(s"22.some + 44.some = $optResult")

  def add[A: Monoid](item: List[A]): A = item.foldLeft(Monoid[A].empty)(_ |+| _)

  val itemsOpts: List[Option[Int]] = List(123.some, 2323.some, 777.some)

  println(s"some of $itemsOpts = ${add(itemsOpts)}")

  case class Order(totalCost: Double, quantity: Double)

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order]{
    override def combine(x: Order, y: Order): Order = Order(
      x.totalCost + y.totalCost,
      y.quantity + y.quantity
    )

    override def empty: Order = Order(0, 0)
  }
  val orders = List(Order(10, 20), Order(22, 24), Order(11, 12))

  println(s"sum of order $orders = ${add(orders)}")





}
