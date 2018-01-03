package chapter3

import chapter3.ContraMap.Box

import scala.util.Try

object Imap {

  trait Codec[A] {
    def encode(value: A): String
    def decode(value: String): Option[A]

    def imap[B](dec: A => B, enc: B => A): Codec[B] = {
      val self = this
      new  Codec[B] {
        override def encode(value: B): String = self.encode(enc(value))

        override def decode(value: String): Option[B] = self.decode(value).map(dec)
      }
    }
  }


  implicit val IntCodec = new Codec[Int] {
    override def encode(value: Int): String = value.toString

    override def decode(value: String): Option[Int] = Try(value.toInt).toOption
  }

  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] = c.imap(Box(_), _.value)

  def encode[A](value: A)(implicit c: Codec[A]): String = c.encode(value)


  def decode[A](value: String)(implicit c: Codec[A]): Option[A] = c.decode(value)

  val myBox = Box(123)

  println(encode(myBox))

  println(decode[Box[Int]]("123"))


}
