/*Una empresa de logística requiere un sistema informático centralizado escrito en Java que integre tres niveles de organización de datos para sus productos:

Estructura Estática (Matriz Homogénea + Arreglo de Registros Heterogéneos):
1 Se requiere registrar la información de N productos. Para cada producto se almacenará su código (id de tipo int) y nombre (String) dentro de un arreglo de objetos de la clase simple Producto.
2 Las ventas/existencias semanales de estos productos durante 5 días (Lunes a Viernes) deben registrarse en una matriz de tipo double[][] de N x 5.
3 Mediante bucles anidados, el sistema debe recorrer la matriz para calcular el total de stock/ventas acumuladas de cada producto.*/



package estructuras_datos;

import java.util.Scanner; 

// Clase simple Producto para representar un registro con múltiples tipos de datos (Heterogéneo)
class Producto { 
    int id; // Declara un atributo de tipo entero para almacenar el código identificador del producto
    String nombre; // Declara un atributo de tipo cadena de texto para almacenar el nombre del producto

    // Constructor de la clase que inicializa los atributos al crear un nuevo objeto Producto
    public Producto(int id, String nombre) { 
        this.id = id; // Asigna el valor del parámetro 'id' al atributo 'id' de la instancia actual
        this.nombre = nombre; // Asigna el valor del parámetro 'nombre' al atributo 'nombre' de la instancia actual
    } 
} 

// Clase principal del programa (debe llamarse igual que el archivo)
public class Estructura_Estatica { 
    // Método principal 'main' que sirve como punto de partida y ejecución del programa
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        
        // Muestra en la pantalla el mensaje para solicitar al usuario la cantidad de registros
        System.out.print("Ingrese la cantidad de productos a registrar (N): "); 
        // Lee la línea escrita por el usuario y la convierte inmediatamente en un número entero asignado a 'N'
        int N = Integer.parseInt(scanner.nextLine()); 
        
        int diasSemana = 5; 
        
        // 1. ARREGLO DE OBJETOS DE TAMAÑO N (Estructura Estática Lineal Heterogénea)
        Producto[] listaProductos = new Producto[N]; // Declara e inicializa un arreglo para almacenar 'N' objetos de tipo Producto
        
        // 2. MATRIZ DE TIPO double[][] DE N x 5 (Estructura Estática Bidimensional Homogénea)
        double[][] matrizVentas = new double[N][diasSemana]; // Crea la matriz en memoria con 'N' filas y 5 columnas de números decimales
        
        // Muestra un encabezado decorativo en la consola antes de iniciar el ciclo de captura de información
        System.out.println("\n--- REGISTRO DE DATOS (N PRODUCTOS) ---"); 
        // Bucle 'for' principal que se repetirá desde 0 hasta N-1 para registrar secuencialmente cada producto
        for (int i = 0; i < N; i++) { 
            // Imprime visualmente el número de producto que se está procesando actualmente en el flujo
            System.out.println("\n[Producto " + (i + 1) + " de " + N + "]"); 
            // Solicita al usuario el ingreso del identificador numérico por pantalla
            System.out.print("Ingrese código (id de tipo int): "); 
            // Captura la línea escrita en consola y la transforma a un tipo de dato entero seguro asignado a 'id'
            int id = Integer.parseInt(scanner.nextLine()); 
            
            // Solicita al usuario que digite la cadena correspondiente al nombre del artículo
            System.out.print("Ingrese nombre (String): "); 
            // Captura la entrada de texto completa directamente del teclado y la guarda en la variable 'nombre'
            String nombre = scanner.nextLine(); 
            
            // Instancia un nuevo objeto de la clase Producto y lo almacena en la posición 'i' del arreglo estático
            listaProductos[i] = new Producto(id, nombre); 
            
            // Imprime una instrucción orientativa para que el usuario conozca qué valores numéricos debe colocar a continuación
            System.out.println("Ingrese las ventas de los 5 días (Lunes a Viernes):"); 
            // Bucle secundario anidado que recorre las 5 columnas asociadas a los días de la semana para el producto actual
            for (int j = 0; j < diasSemana; j++) { 
                // Imprime de forma ordenada una etiqueta numerada indicando el día específico que se está llenando
                System.out.print("  Día " + (j + 1) + ": "); 
                // Captura el valor decimal ingresado por teclado y lo almacena exactamente en la celda fila 'i', columna 'j'
                matrizVentas[i][j] = Double.parseDouble(scanner.nextLine()); 
            } 
        } 
        
        // 3. PROCESAMIENTO Y REPORTE MEDIANTE BUCLES ANIDADOS
        System.out.println("\n--- REPORTE FINAL CONSOLIDADOS ---"); // Muestra en consola el título del reporte consolidado de resultados
        
        // Bucle externo para el procesamiento: recorre de manera ordenada cada una de las filas (los N productos)
        for (int i = 0; i < N; i++) { 
            double totalVentasProducto = 0; // Inicializa en cero un acumulador decimal para calcular las ventas de cada artículo
            
            // Bucle interno anidado para el procesamiento: se desplaza por las 5 columnas de la fila actual 'i'
            for (int j = 0; j < diasSemana; j++) { 
                totalVentasProducto += matrizVentas[i][j]; // Suma el valor numérico de la celda actual al acumulador (Sumatoria horizontal)
            } 
            
            // Imprime una línea formateada extrayendo los datos del arreglo de objetos y vinculándolos con la sumatoria de la matriz
            System.out.println("Código ID: " + listaProductos[i].id 
                               + " | Producto: " + listaProductos[i].nombre 
                               + " | Ventas Totales: $" + totalVentasProducto); // Imprime los tres campos integrados en una sola fila
        } 
        
        scanner.close(); 
    } 
}