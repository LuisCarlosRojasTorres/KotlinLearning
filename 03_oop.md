<!-- vscode-markdown-toc -->
* 1. [Classes](#Classes)
	* 1.1. [Sobrecarga de métodos](#Sobrecargademtodos)
	* 1.2. [Constructor](#Constructor)
* 2. [Heranca](#Heranca)
* 3. [Companion object](#Companionobject)
* 4. [Enum](#Enum)
* 5. [LateInit](#LateInit)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->
##  1. <a name='Classes'></a>Classes

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

###  1.1. <a name='Sobrecargademtodos'></a>Sobrecarga de métodos
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

###  1.2. <a name='Constructor'></a>Constructor
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

##  2. <a name='Heranca'></a>Heranca
- `open class BaseClass (var1: Type1)`: Superclass shall be `open`
- `class subClass(var1: Type1) : BaseClass(var1)`: baseclass is placed after `:`
   - If the derived class has a primary constructor, the base class can (and must) be initialized in that primary constructor according to its parameters.
- The `open` modifier is required for baseclass methods than can be redefined in subclass.
  - The `override` modifier is required for the subclass.
  - Even properties can be override

- Seja o exemplo:
  - Animal: props (Cor, tamanho, Peso) Metodos (Correr, Dormir)
    - Dog: props (Cor, tamanho, Peso) Metodos (Correr, Dormir, **Morder**, **Talk**)
    - Bird: props (Cor, tamanho, Peso) Metodos (Correr, Dormir, **Voar**, **Talk**)
  
``` kt
// open is required to be a superclass, (by default all classes are final) 
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

##  3. <a name='Companionobject'></a>Companion object
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
##  4. <a name='Enum'></a>Enum

``` kt
enum class StatusProcess {
ESTADO_1,
ESTADO_2,
ESTADO_N
}

class DummyProcess(var status: StatusProcess = StatusProcess.ESTADO_1)
{
//...
}

fun main()
{
	val process = DummyProcess()
	println(process.status)
	process.status = StatusProcess.ESTADO_2
    println(process.status)
    process.status = StatusProcess.ESTADO_N
    println(process.status)    
}
```
- Output

```
ESTADO_1
ESTADO_2
ESTADO_N
```


##  5. <a name='LateInit'></a>LateInit
- As variaveis declaradas como `nonnullable` de uma clase deven inicializadas no construtor.
- PORÉM as vezes são inicializadas posteriormente:
  - a travésde Dependency Injection
  - num método
  - num teste, ou seja FORA DO CONSTRUTOR
- Para tratar estes casos se utiliza `lateinit`, que permite nao definir no inicio a variavel e setar depois.
- WARNING: Se a variavel lateinit é utilizada antes de ser setada vai dar erro de compilação
``` kt
class ProductStandard{
   //nonnullable field is defined as an empty string
   var description: String = ""
   //nullable defined as null
   var description1: String? = null

   lateinit var description2: String   
}

fun main(){
   val pro = ProductStandard()
   pro.description2 = "Some dummy text"
   println(produto.descricao)
}
```