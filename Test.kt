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