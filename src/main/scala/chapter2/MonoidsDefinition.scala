package chapter2

object MonoidsDefinition {
  trait Monoid[A] {
    def combine(x: A, y: A): A
    def empty: A
  }

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)
  }


  def identityLaw[A](x: A)(implicit m:Monoid[A]): Boolean = {
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
  }

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  trait Monoids[A] extends Semigroup[A] {
    def empty: A
  }

  object Monoids {
    def apply[A](implicit monoids: Monoids[A]): Monoids[A] = monoids
  }

  implicit val booleanAndMonoids: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = x && y

    override def empty: Boolean = true
  }

  implicit val booleanOrMonoides: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = x || y

    override def empty: Boolean = false
  }

  implicit val booleanEitherMonoids: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = (!x && y) || (x && !y)

    override def empty: Boolean = false
  }

  implicit val booleanXnorMonoids: Monoid[Boolean] = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = (!x || y) && (x || !y)

    override def empty: Boolean = true
  }

  implicit def setUnionMonoids[A]: Monoids[Set[A]] = new Monoids[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x union y

    override def empty: Set[A] = Set.empty[A]
  }
}
