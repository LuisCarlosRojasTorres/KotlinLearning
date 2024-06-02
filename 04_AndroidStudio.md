## Basics in MainActivity.kt
NOTA: Paa otimizar os imports do arquivo `ctrl+alt+o` 
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

### Jetpack Compose
- kit de herramientas moderno para crear IUs de Android. 
- Compose simplifica y acelera el desarrollo de IUs en Android con menos código, herramientas potentes y capacidades intuitivas de Kotlin
- Compose, puedes compilar tu IU a partir de la definición de un conjunto de funciones, llamadas funciones de componibilidad, que toman datos y describen elementos de la IU.
  
#### Funciones de Componibilidad 
- Describe alguna parte de tu IU.
- No `return` nada .
- Toma información y genera lo que se muestra en la pantalla.

#### Anotaciones
- son una forma de adjuntar información adicional al código. Esta información ayuda a herramientas como el compilador de Jetpack Compose y a otros desarrolladores a comprender el código de la app.
``` kt
@anotation
fun nameOfMethod(parameter: Type)
```

- pueden tomar parametros 
``` kt
@anotation(
    someVar = true
    otherVar = "someString")
fun nameOfMethod(parameter: Type)
```

#### Ejemplo de funcion de compose
- Tem a anotação `@Composable` (que informa al compilador de Compose que esta función está diseñada para convertir datos en IU).
- Jetpack Compose se basa en funciones de componibilidad. Estas funciones te permiten definir la IU de tu app de manera programática describiendo cómo debería verse, en lugar de enfocarse en el proceso de construcción de la IU. Para crear una función de componibilidad, agrega la anotación `@Composable` al nombre de la función.

#### Style
- Tem anotação `Composable`
- Nao tem `return`
- Deve ter nome com letra maiuscula inicial (pascal case)
- Deve ser um sustantivo
   -  pode ter um adjetivo ao inicio do sustantivo

#### Pixeles escalaveis  
- Los píxeles escalables (SP) son una unidad de medida para el tamaño de fuente (pero cambia según el tamaño de texto que prefiera el usuario en la configuración del teléfono.)
   - Precisa do pacote `androidx.compose.ui.unit.sp`
``` kt
Text(
    text = message,
    fontSize = 100.sp
)
```

#### Organizar os elementos em fila ou columnas
- Ao utilizar dois composable Text o android poderia organizar de uma forma que a gente nao queira. Para botar uma ordem nisso a gente utiliza `Column` ou `Row`
``` kt
Text(
    text = message1,
    fontSize = 100.sp
)
Text(
    text = message2,
    fontSize = 100.sp
)
```
- Ficaria assim:

``` kt`
Column{
Text(
    text = message1,
    fontSize = 100.sp
)
Text(
    text = message2,
    fontSize = 100.sp
)
}
```
- Pq usar `{}` em Column? Esto se llama sintaxis de expresión lambda final. Más adelante en el curso, aprenderás sobre las lambdas y la sintaxis de expresión lambda final en detalle. Por ahora, familiarízate con esta sintaxis de Compose de uso general.
   - Kotlin ofrece una sintaxis especial para pasar funciones como parámetros a funciones cuando el último parámetro es una función.
   - Cuando pasas una función como ese parámetro, puedes usar la sintaxis de expresión lambda final. En lugar de colocar la función dentro de los paréntesis, puedes colocarla fuera de los paréntesis y entre llaves. Esta práctica es recomendada y común en Compose, por lo que debes familiarizarte con la apariencia del código.
   - Por ejemplo, el último parámetro en la función de componibilidad Row() es el parámetro content, una función que describe los elementos secundarios de la IU. Supongamos que deseas crear una fila que contenga tres elementos de texto. Este código funcionaría, pero es muy engorroso usar el parámetro con nombre para la expresión lambda final:
   ``` kt
   Row(
    content = {
        Text("Some text")
        Text("Some more text")
        Text("Last text")
    }
   )
   ```
   - Como el parámetro content es el último de la firma de la función y pasas su valor como una expresión lambda (por ahora, no hay problema si no sabes qué es una lambda; solo familiarízate con la sintaxis), puedes quitar el parámetro content y los paréntesis de la siguiente manera:
   ``` kt
   Row(    
        Text("Some text")
        Text("Some more text")
        Text("Last text")    
   )
   ``` 
- Nota: Recuerda que debes pasar el parámetro modificador al elemento secundario en los elementos componibles. Eso significa que debes pasar el parámetro modificador al elemento Column componible.
``` kt
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
        )
        Text(
            text = from,
            fontSize = 36.sp
        )
    }
}
```