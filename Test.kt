
class User constructor(name : String = "Rufo", sobrenome : String = "Von Rufinstein"){
   var nome : String = ""
   var sobrenome : String = ""

   init{
      this.nome = name
      this.sobrenome = sobrenome
      println("Objeto Inicializado")
   }

   fun dummy(){
      println("Sou $nome $sobrenome")
   }
}

fun main ()
{
   var user = User()
   
   user.dummy()
   

}