import chapter1.anatomytypeclass.printable.UsingLibrary
import chapter1.meetcats.{EqEx, ShowEx}
import chapter2.{IdenticallyTypeInstances, MonoidsInCats}
import chapter3._
import chapter4.writer.WritersEx

object MyMain {


  def main(args: Array[String]): Unit = {
    println("start adv scala")
//    chapter1
    UsingLibrary
    ShowEx
    EqEx

//    chapter2
    MonoidsInCats
    IdenticallyTypeInstances

//    chapter3
    ExampleFunctor
    FunctorDefinition
    FunctorTypeClass
    ContraMap
    Imap


//    chapter4
    WritersEx
  }
}
