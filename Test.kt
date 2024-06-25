
open class Animal (var color : String = "Red", var size : String = "P"){
   
   open fun Walk()
   {
      println("Walk walk walk!")
   }

   open fun Sleep()
   {
      println("Zzzz zzzz zzzz!")
   }
}

class Dog: Animal() {
   
   companion object {
      const val DIMENSION="2D"

      fun print_DIMENSION()
      {
         println("DIMESION: $DIMENSION")
      }
   }
   override fun Walk()
   {
      super.Walk()
      println("Lobo walk walk!")
   }
   
}

fun main ()
{
   Dog.print_DIMENSION()
   
}