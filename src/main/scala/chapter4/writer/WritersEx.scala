package chapter4.writer

import cats.Id
import cats.data.WriterT

import scala.concurrent.{Await, Future}

object WritersEx {

  import cats.data.Writer
  import cats.instances.vector._
  import cats.syntax.writer._
  import cats.syntax.option._

  val z ="".some

  Writer(Vector("", " ", ""), 5)

  import cats.syntax.applicative._

  //
  //  type Writer[W, A] = WriterT[Id, W, A]
  type Logged[A] = Writer[Vector[String], A]
  //  val log = Vector("123", "456").tell

  val result = 123
  result.writer(Vector("log1", "log2", "log3"))


  val xx = result.pure[Logged]


  println(xx.value)

  println(xx.written)


  val writerTest = for {
    a <- 10.pure[Logged]
    _ <- Vector("a", "b", "c").tell
  } yield a


  println(s"writer => $writerTest")

  def slowly[A](body: => A) =
    try body finally Thread.sleep(100)

  def factorial(n: Int): Logged[Int] =
    for {
      ans <- if (n == 0) {
        1.pure[Logged]
      } else {
        slowly(factorial(n - 1).map(_ * n))
      }
      _ <- Vector(s"fact $n $ans").tell
    } yield ans

  println(factorial(5))
}
