import chapter1.anatomytypeclass.printable.UsingLibrary
import chapter1.meetcats.{EqEx, ShowEx}
import chapter2.MonoidsInCats
import chapter4.writer.WritersEx

object MyMain {


  def main(args: Array[String]): Unit = {
    println("start adv scala")
    UsingLibrary
    ShowEx
    EqEx
    WritersEx

    MonoidsInCats

  }
}
