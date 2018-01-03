package chapter3

object ExampleFunctor {
  import cats.instances.function._
  import cats.syntax.functor._

  val func1: Int => Double = (x: Int)  => x.toDouble

  val func2: Double => Double = (y: Double) => y * 2

  val func3 = func1.map(func2)


  println(s"func3 => ${func3(1)}")


}
