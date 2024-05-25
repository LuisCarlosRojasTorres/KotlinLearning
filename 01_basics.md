<!-- vscode-markdown-toc -->
* 1. [TO Compile](#TOCompile)
* 2. [Output](#Output)
* 3. [Comments](#Comments)
* 4. [Declaring variables](#Declaringvariables)
	* 4.1. [Declaring and assigning](#Declaringandassigning)
	* 4.2. [Declaring then assigning](#Declaringthenassigning)
* 5. [Data Types](#DataTypes)
	* 5.1. [Numbers](#Numbers)
	* 5.2. [No numbers](#Nonumbers)
	* 5.3. [Variable conversion](#Variableconversion)
* 6. [Operators](#Operators)
	* 6.1. [Asignment](#Asignment)
	* 6.2. [Comparison](#Comparison)
	* 6.3. [Logical](#Logical)
* 7. [Strings](#Strings)
* 8. [Booleans](#Booleans)
* 9. [Control Sentences](#ControlSentences)
	* 9.1. [If-Else](#If-Else)
	* 9.2. [When (case)](#Whencase)
	* 9.3. [While loop](#Whileloop)
	* 9.4. [Do-while](#Do-while)
	* 9.5. [break and continue](#breakandcontinue)
	* 9.6. [arrays](#arrays)
	* 9.7. [FOR LOOP](#FORLOOP)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->

##  1. <a name='TOCompile'></a>TO Compile
``` kt
kotlinc dummy.kt -include-runtime -d dummy.jar
java -jar dummy.jar 
```
##  2. <a name='Output'></a>Output
- `print` and `println` functions. e.g. `println(3+3)` and `print("Rufo")`

##  3. <a name='Comments'></a>Comments 
- Single-line: `// Example`
- Multi-line: `/* Example */`

##  4. <a name='Declaringvariables'></a>Declaring variables
- Constants use `val`. e.g. `val PI = 3.1415`

###  4.1. <a name='Declaringandassigning'></a>Declaring and assigning
- It dont need to specify the type
``` kt
var name = "John"  
```
###  4.2. <a name='Declaringthenassigning'></a>Declaring then assigning
- You shall specify the type

``` kt
var name: String
name = "John"
```
##  5. <a name='DataTypes'></a>Data Types

###  5.1. <a name='Numbers'></a>Numbers

``` kt
val myNumByte: Byte = 0x10  // Integer
val myNumShort: Short = 5000 // Short
val myNumInt: Int = 100 // Int max number 2147483647
val myNum: Long = 15000000000L
val myNum: Float = 5.75F
val myNum: Double = 19.99
```

###  5.2. <a name='Nonumbers'></a>No numbers

``` kt
val dummyBool1: Boolean = true
val dummyBool2: Boolean = false
val myChar: Char = 'B'
val myString: String = "Hello Rufo"
```

###  5.3. <a name='Variableconversion'></a>Variable conversion

``` kt
val x: Int = 5
val y: Long = x.toLong()
```

##  6. <a name='Operators'></a>Operators

###  6.1. <a name='Asignment'></a>Asignment
- Same as many languages...
``` kt
var x = 10
x += 3
x -= 3
x *= 3
x /= 3
x %= 3
```

###  6.2. <a name='Comparison'></a>Comparison
- Same as many languages...
``` kt
var x = 10
var y = 12
x == y
x != y
x < y
x > y
x >= y
x <= y
```

###  6.3. <a name='Logical'></a>Logical
- Same as many languages...
``` kt
var x = 10
var y = 12
x < 5 &&  x < 10
x < 5 ||  x < 10
```

##  7. <a name='Strings'></a>Strings

``` kt
var greeting = "Hello"
var greeting: String = "Hello"

var txt = "Hello World"
println(txt[0]) // first element (H)
println(txt[2]) // third element (l)

var txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
println("The length of the txt string is: " + txt.length)

var txt = "Hello World"
println(txt.toUpperCase())   // Outputs "HELLO WORLD"
println(txt.toLowerCase())   // Outputs "hello world"

var txt1 = "Hello World"
var txt2 = "Hello World"
println(txt1.compareTo(txt2))  // Outputs 0 (they are equal) 1 otherwise

var txt = "Please locate where 'locate' occurs!"
println(txt.indexOf("locate"))  // Outputs 7 the index where locate is located

var txt2 = "That's great" //Quotes inside a string!

var firstName = "John"
var lastName = "Doe"

// Concatenation
println(firstName + " " + lastName)
println(firstName.plus(lastName))

// Interpolation
println("My name is $firstName $lastName")
```
##  8. <a name='Booleans'></a>Booleans
- Same as python `true`, `false`

##  9. <a name='ControlSentences'></a>Control Sentences

###  9.1. <a name='If-Else'></a>If-Else
- Same as Dotnet

###  9.2. <a name='Whencase'></a>When (case)

``` kt
val day = 1

val result = when (day) {
  1 -> "Monday"
  2 -> "Tuesday"
  3 -> "Wednesday"
  4 -> "Thursday"
  5 -> "Friday"
  6 -> "Saturday"
  7 -> "Sunday"
  else -> "Invalid day."
}
println(result)
```

###  9.3. <a name='Whileloop'></a>While loop
- Same as other languages

###  9.4. <a name='Do-while'></a>Do-while
- Same as other languages

###  9.5. <a name='breakandcontinue'></a>break and continue
- Same as other languages

###  9.6. <a name='arrays'></a>arrays

``` kt
fun main() {
   // Creating an array
   val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
   // Accessing an array element
   println(cars[0])
   // Modifying an array element
   cars[0] = "Opel"
   println(cars[0])
   // Array size:
   println(" Array size " + cars.size)
}
```

###  9.7. <a name='FORLOOP'></a>FOR LOOP
- THe traditional loop does not exist in kotlin.
- Same as python

``` kt
val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
for (x in cars) {
  println(x)
}
``` 

- Another way to use loops is using `ranges` (it used the `..`)

``` kt
fun main() {
   for (chars in 'a'..'d') {
     print(chars)
   }
   for (nums in 5..9) {
     print(nums)
   } 
}
```

- To check if a value exist

``` kt
fun main() {
   val nums = arrayOf(2, 4, 6, 8)
   if (2 in nums) {
     println("It exists!")
   } else {
     println("It does not exist.")
   }
}
```