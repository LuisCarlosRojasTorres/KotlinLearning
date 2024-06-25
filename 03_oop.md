
## Classes

``` kt
class Player {
   var kart = ""
   var pneu = ""

   fun acelerar(aceleracao : Int = 0){
      println("aceleraration: $aceleracao")
   }
}

fun main ()
{
   var player = Player()
   
   player.kart = "Novo"
   player.pneu = "Usado"
   player.acelerar()
   player.acelerar(5)
   player.acelerar(aceleracao = 4)

}
```

## Sobrecarga de métodos
- Polimorfismo: Mesmo método representa comportamentos diferentes:
  - Sobrecarga: mesmo método diferentes parâmetros 
  - Sobreposição: com herança

``` kt
class User {
   fun login(email: String, senha: String){
      println("Logado com email: $email e senha:'$senha'")
   }
   fun login(email: String){
      println("Logado com email: $email e senha default '1234'")
   }

}

fun main ()
{
   var user = User()
   
   user.login("rufo@gmail.com")
   user.login("rufo@gmail.com","ruforufa")

}
```

## Constructor
- `init`: método ou métodos executados em ordem ao longo da classe. Chamado depois que o constructor foi executado.
- se nao tiver modificadores de accesso nao precisa a palavra `constructor`
``` kt
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
```

Output:
```
Objeto Inicializado
Sou Rufo Von Rufinstein
```

A forma mais `kotlin` é definir as variaveis no construtor:

``` kt
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
```

- Um construtor secundario pode fazer referencia ao primario

``` kt
class User (var name : String = "Rufo", var sobrenome : String = "Von Rufinstein"){
   
   init{
      println("Objeto Inicializado")
   }

   fun dummy(){
      println("Sou $name $sobrenome")
   }

   // A ref ao construtor primario é atraves do this()
   constructor(name: String) : this(name, "Doe"){
      println ("Contrutor Secundario")
   }
}

fun main ()
{
   var user = User("Lobo")   
   user.dummy()  
}
```
- Output
``` kt
Objeto Inicializado
Contrutor Secundario
Sou Lobo Doe
```

### Heranca
- Seja o exemplo:
  - Animal: props (Cor, tamanho, Peso) Metodos (Correr, Dormir)
  - Dog: props (Cor, tamanho, Peso) Metodos (Correr, Dormir, **Morder**, **Talk**)
  - Bird: props (Cor, tamanho, Peso) Metodos (Correr, Dormir, **Voar**, **Talk**)
  
``` kt
// open is required to be a superclass otherwise is final
open class Animal (var color : String = "Red", var size : String = "P"){
   //open is required to be override otherwise is final
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
```

- Output
``` 
Walk walk walk!
Lobo walk walk!
Zzzz zzzz zzzz!
Red
```

## Companion object
- Similar as funções estaticas 
- Se pueden combinar con herencia:

``` kt
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
```
- output
``` 
DIMESION: 2D
```