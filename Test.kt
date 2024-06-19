
class User (var name : String = "Rufo", var sobrenome : String = "Von Rufinstein"){
   
   init{
      println("Objeto Inicializado")
   }

   fun dummy(){
      println("Sou $name $sobrenome")
   }

   constructor(name: String) : this(name, "Doe"){
      println ("Contrutor Secundario")
   }
}

fun main ()
{
   var user = User("Lobo")   
   user.dummy()  
}