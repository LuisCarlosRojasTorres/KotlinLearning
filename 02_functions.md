<!-- vscode-markdown-toc -->
* 1. [Calling functions](#Callingfunctions)
	* 1.1. [Without parameters](#Withoutparameters)
	* 1.2. [With parameters](#Withparameters)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->
##  1. <a name='Callingfunctions'></a>Calling functions

- The general form is `fun nameOfFunction(nameOfVar1: Type1 = defaultValue1, ...): TypeOfReturn`
  
###  1.1. <a name='Withoutparameters'></a>Without parameters

``` kt
fun main() {
   f1()
   f2()
}

fun f1() {
   println(" - Called f1")
}
fun f2() {
   println(" - Called f2")
}
```

###  1.2. <a name='Withparameters'></a>With parameters

``` kt
fun main() {
   f1("Rufo", 12)
   println(f2("Rufa", 11))
}

// Multiple parameters
fun f1(fname: String, age: Int) {
   var ans : String = fname + " is " + age.toString()
   println(ans)
}

//Returning values: specify the return type after the function's parantheses
fun f2(fname: String, age: Int): String {
   var ans : String = fname + " is " + age.toString()
   return (ans)
}

//Returning values: using defult values
fun f3(fname: String = "rufo", age: Int = 10): String {
   var ans : String = fname + " is " + age.toString()
   return (ans)
}
```

### Lambda expressions

- Full version: `val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }`
- Short version: `val sum = { x: Int, y: Int -> x + y }`
 
``` kt
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
print(sum(3,4)) // returns 7
```

### Anonymous function
The lambda expression syntax above is missing one thing – the ability to specify the function's return type. 

- For the lambda example: `fun(x: Int, y: Int): Int = x + y`
