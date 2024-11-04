## Interfaces
- It can contain abstract methods and implementetions.
- It cannot store state.
- It can have properties.

``` kt
interface DummyInterface {

    val prop1: Int
    val prop2: Int

    fun DummyMethod1()
    fun DummyMethod2() {
      // optional body
    }
}
```

- To implement 
``` kt
class InterfaceImplemented : DummyInterface {
    override fun DummyMethod() {
        // body
        override val prop1: Int = 10
    }
}
```