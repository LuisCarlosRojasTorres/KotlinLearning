
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
  - Sobreposição:

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