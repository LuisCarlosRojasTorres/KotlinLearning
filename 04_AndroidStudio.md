## Basics in MainActivity.kt

- La función `onCreate()` es el punto de entrada a esta app y llama a otras funciones para compilar la interfaz de usuario. En los programas de Kotlin, la función main() es el lugar específico de tu código en el que se inicia el compilador de Kotlin. En las apps para Android, la función onCreate() realiza esa tarea.
- La función `setContent()` dentro de la función onCreate() se usa a fin de definir el diseño mediante funciones que admiten composición. Se puede llamar a todas las funciones marcadas con la anotación @Composable desde la función setContent() o desde otras que admitan composición.
- Una Surface es un contenedor que representa una sección de la IU en la que puedes modificar el aspecto, como el borde o el color de fondo.
- A continuación, observa la función `Greeting()`. La función Greeting() es una que corresponde a la componibilidad. Observa la anotación @Composable que se encuentra sobre ella. Una función de componibilidad toma alguna entrada y genera lo que se muestra en la pantalla.
``` kt

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           GreetingCardTheme {
               // A surface container using the 'background' color from the theme
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colors.background
               ) {
                   Greeting("Android")
               }
           }
       }
   }
}

@Composable
fun Greeting(name: String) {
   Text(text = "Hello $name!")
}
```
## Basic Layout