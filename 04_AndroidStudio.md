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
### Recursos
- el directorio res/ contiene todos los recursos de los subdirectorios, que incluyen un directorio drawable/ para un recurso de imagen, un directorio mipmap/ para los íconos de selector y un directorio values/ para recursos de strings.
- Jetpack Compose puede acceder a los recursos definidos en tu proyecto de Android. Se puede acceder a los recursos con los ID de recursos que se generan en la clase `R` de tu proyecto.
  - Una clase `R` es una clase que Android genera automáticamente y que contiene los ID de todos los recursos en el proyecto. En la mayoría de los casos, el ID del recurso es el mismo que el nombre del archivo e.g. `R.drawable.dummyResourceID`
- Un ejemplo: La función painterResource() carga un recurso de imagen de elemento de diseño y toma el ID de recurso (en este caso, R.drawable.androidparty) como argumento.
``` kt
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
   val image = painterResource(id = R.drawable.androidparty)
   Image(
    painter = image
    contentDescription = null
   )
}
```
- el diseño `Box` para apilar elementos uno sobre el otro. El diseño Box también te permite configurar la alineación específica de los elementos que contiene.
- Para ajustar a imagem mantendo a escala se utiliza 
``` kt
Image(
    painter = image,
    contentDescription = null,
    contentScale = ContentScale.Crop
)
```

### Modificadores
- Los modificadores se usan para decorar o agregar comportamiento a los elementos de IU de Jetpack Compose. Por ejemplo, puedes agregar fondos, padding o comportamiento a filas, texto o botones. Para configurarlos, un elemento componible o un diseño debe aceptar un modificador como parámetro.
- Por ejemplo, este elemento Text componible tiene un argumento Modifier que cambia el color de fondo a verde.

``` kt
// Example
Text(
    text = "Hello, World!",
    // Solid element background color
    modifier = Modifier.background(color = Color.Green)
)
```

- Para establecer la posición de los elementos secundarios dentro de un `Row`, configura los argumentos `horizontalArrangement` y `verticalAlignment`. Para una `Column`, configura los argumentos `verticalArrangement` y `horizontalAlignment`.

#### Padding
- Es el espacio entre el margen de un elemento y su contenido.
``` kt
Modifier.padding(
    start = 16.dp,
    top = 16.dp,
    end = 16.dp,
    bottom = 16.dp
)
```

### Traduccion
- Una string codificada es una que se escribe directamente en el código de tu app. Las strings codificadas hacen que sea más difícil traducir tu app a otros idiomas y dificultan la reutilización de una string en diferentes lugares de la app. Puedes extraer strings en un archivo de recursos para resolver estos problemas. En lugar de codificar strings en tu código, colócalas en un archivo, asígnales un nombre a los recursos de strings y usa los nombres cuando desees usar las strings. El nombre seguirá siendo el mismo, incluso si cambias la string o la traduces a otro idioma.
- Selecciona un string 
- Da click na lampada que aparece ao lado
- click em `Extract string resource`
- Android Studio abrirá el diálogo Extract Resource. En él, podrás personalizar cómo se llamará tu recurso de strings y algunos detalles sobre cómo almacenarlo. En el campo Resource name, introduce el nombre que le asignarás a la string. En el campo Resource Value, se introduce la string real.
  - Los recursos de strings deben tener nombres en minúscula y, si hay más de una palabra, estas deben estar separadas por un guión bajo. Deja las otras opciones de configuración con sus valores predeterminados.
- En el panel Project, abre el archivo `strings.xml` de la ruta `app > res > values > strings.xml` 
  - El archivo strings.xml tiene una lista de cadenas que el usuario verá en la app. Ten en cuenta que el nombre de tu app también es un recurso de cadenas. Si colocas todas las strings en un solo lugar, podrás traducir de manera sencilla todo el texto de tu app y volver a usar más fácilmente una string en diferentes partes de tu app.


``` kt
// String antes de adicionar ao strings.xml file
GreetingImage(message= "Happy Birthday Rufo", from="from Rufa", modifier = Modifier.padding(8.dp))
// String substituido 
GreetingImage(message= stringResource(R.string.happy_birthday_rufo), from="from Rufa", modifier = Modifier.padding(8.dp))

```