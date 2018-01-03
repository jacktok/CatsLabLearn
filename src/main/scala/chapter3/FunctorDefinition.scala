package chapter3

object FunctorDefinition {
  import scala.language.higherKinds
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  //try override
  implicit val functorList = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.tail.map(f)
  }

  //create syntax
  implicit class ListSyntax[A](data: List[A]) {
    def mapx[B](f: A => B)(implicit ft: Functor[List]) = ft.map(data)(f)
  }

  val myList = List(1, 2, 3, 4)
  println(s"try to override map ${myList.mapx(_ + 5)}")

}
