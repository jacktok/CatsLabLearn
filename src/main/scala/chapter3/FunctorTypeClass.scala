package chapter3

object FunctorTypeClass {

  /**
    * declare type constructors using underscores => F[_]
    *
    * constructor use for declare type
    *   => List[_] // constructor type
    *   => List[Int] // type
    *
    */

  import cats.instances.list._
  import cats.Functor


  val list1 = List(1, 2, 3)
  val list1Db: List[Int] = Functor[List].map(list1)(_ * 2)
  println(s"list functor map *2 => $list1Db")


  import cats.syntax.option._
  import cats.instances.option._

  val option1: Option[Int] =  123.some
  val option1ToString: Option[String] = Functor[Option].map(option1)(_.toString)
  println(s"option functor map to string $option1ToString")

  // exercise

  sealed trait Tree[+A]
  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  final case class Leaf[A](value: A) extends Tree[A]

  implicit val TreeFunctor = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
      case Leaf(value) => Leaf(f(value))
    }
  }
  import cats.syntax.functor._

  val branch: Tree[Int] = Branch(Leaf(10), Leaf(20))
  println(s"my branch double => ${branch.map(_ * 2)}")


}
