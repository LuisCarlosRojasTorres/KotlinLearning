
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
   
   override fun Walk()
   {
      super.Walk()
      println("Lobo walk walk!")
   }
   
}

fun main ()
{
   var user = Dog()   
   user.Walk()  
   user.Sleep()
   println(user.color)
}