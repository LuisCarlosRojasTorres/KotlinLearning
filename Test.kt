
class User constructor(var name : String = "Rufo", var sobrenome : String = "Von Rufinstein"){
   
   init{
      println("Objeto Inicializado")
   }

   fun dummy(){
      println("Sou $name $sobrenome")
   }
}

fun main ()
{
   var user = User()   
   user.dummy()  
}