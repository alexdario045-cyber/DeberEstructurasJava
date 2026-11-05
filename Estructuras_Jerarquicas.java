/*Estructura Dinámica Jerárquica No Lineal (Árbol Binario de Búsqueda / Clasificación):
1 Con los totales semanales calculados, el sistema construirá un Árbol Binario donde cada nodo almacenará el código 
del producto, su total y referencias a su hijo izquierdo y derecho.
2 Se debe implementar el método estático recursivo recorrerInorden para mostrar en consola el reporte consolidado de 
productos ordenados de menor a mayor venta acumulada.

*/
package estructuras_datos;

import java.util.Scanner; 

// Se cambió el nombre a ProductoJerarquico para evitar duplicados en el paquete estructuras_datos
class ProductoJerarquico { 
    int id; 
    String nombre; 

    // Constructor de la clase que inicializa de forma directa los atributos del objeto Producto
    public ProductoJerarquico(int id, String nombre) { 
        this.id = id; // Vincula el parámetro id con el atributo de la instancia que se está creando
        this.nombre = nombre; // Vincula el parámetro nombre con el atributo textual de la instancia actual
    } 
} 

// Clase NodoArbol que representa la unidad jerárquica con enlaces ramificados múltiples en memoria
class NodoArbol { 
    int idProducto; // Atributo entero para registrar el código identificador del producto en este nodo
    double totalVentas; // Atributo numérico decimal para guardar la sumatoria total de las ventas semanales
    NodoArbol izquierdo; // Puntero o referencia jerárquica hacia el nodo hijo ubicado a la izquierda
    NodoArbol derecho; // Puntero o referencia jerárquica hacia el nodo hijo ubicado a la derecha

    // Constructor que inicializa un nodo del árbol binario con sus datos correspondientes
    public NodoArbol(int idProducto, double totalVentas) { 
        this.idProducto = idProducto; // Asigna el identificador del artículo al campo idProducto del nodo
        this.totalVentas = totalVentas; // Guarda el cálculo acumulado en el atributo interno totalVentas
        this.izquierdo = null; // Establece la referencia izquierda en nulo al crearse originalmente aislado
        this.derecho = null; // Establece la referencia derecha en nulo al carecer inicialmente de ramificaciones
    } 
} 

// Clase encargada de estructurar el Árbol Binario de Búsqueda para la clasificación de totales
class ArbolBinarioBusqueda { 
    NodoArbol raiz; // Variable de referencia principal que apunta al nodo superior o raíz del árbol

    // Constructor que inicializa el árbol binario de búsqueda en un estado totalmente vacío
    public ArbolBinarioBusqueda() { 
        this.raiz = null; // Asigna el valor nulo a la raíz indicando que no contiene ramificaciones todavía
    }

    // Método público para gestionar de forma ordenada la inserción de un nuevo registro numérico
    public void insertar(int id, double total) { 
        raiz = insertarRecursivo(raiz, id, total); // Llama al método privado recursivo actualizando la raíz
    } 

    // Función auxiliar recursiva para construir y enlazar el árbol de menor a mayor
    private NodoArbol insertarRecursivo(NodoArbol actual, int id, double total) { 
        // Caso base de la recursividad: si la posición actual está libre, crea el nodo en ese espacio
        if (actual == null) { 
            return new NodoArbol(id, total); // Retorna la instancia del nuevo nodo estructurado en memoria
        } 
        
        // Aplica el criterio de búsqueda binaria: si el total es menor, se desplaza hacia la rama izquierda
        if (total < actual.totalVentas) { 
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, total); // Se ramifica recursivamente a la izquierda
        } else { // Si el total es mayor o igual, se desplaza por diseño hacia la rama de la derecha
            actual.derecho = insertarRecursivo(actual.derecho, id, total); // Se ramifica recursivamente a la derecha
        } 
        
        return actual; 
    } 
    
    // Método estático recursivo solicitado formalmente por la guía para imprimir el reporte final
    public static void recorrerInorden(NodoArbol nodo) { 
        // Condición de parada obligatoria para frenar la recursividad: evaluar si el nodo es diferente de nulo
        if (nodo != null) { 
            recorrerInorden(nodo.izquierdo); // Desplazamiento recursivo hacia el extremo del hijo izquierdo
            // Proyecta en la terminal de salida los datos procesados en el punto actual del recorrido
            System.out.println("ID Producto: " + nodo.idProducto 
                               + " | Total Ventas Acumuladas: " + nodo.totalVentas + " unidades"); 
            recorrerInorden(nodo.derecho); // Desplazamiento recursivo hacia el extremo del hijo derecho
        } 
    } 
}

// Clase principal que coincide exactamente con el nombre de tu archivo en NetBeans
public class Estructuras_Jerarquicas { 
    // Punto de partida y ejecución del hilo del programa principal
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // Instancia el lector de entrada para recuperar los datos escritos
        
        System.out.print("Ingrese la cantidad de productos a registrar (N): "); // Solicita el tamaño de muestra de control
        int N = Integer.parseInt(scanner.nextLine()); // Lee el valor numérico transformándolo de forma limpia a entero
        
        int diasSemana = 5; // Inicializa la variable de control fijando las 5 columnas semanales
        ProductoJerarquico[] listaProductos = new ProductoJerarquico[N]; // Instancia el arreglo estático con la clase adaptada
        double[][] matrizVentas = new double[N][diasSemana]; // Instancia la matriz homogénea bidimensional decimal de N x 5
        
        // Ciclo for para recolectar y almacenar la información del inventario de forma estática
        for (int i = 0; i < N; i++) { 
            System.out.println("\n[Registro del Producto " + (i + 1) + " de " + N + "]"); // Muestra la guía posicional
            System.out.print("Ingrese código (id): "); // Solicita la clave numérica identificadora
            int id = Integer.parseInt(scanner.nextLine()); // Captura el entero correspondiente al identificador
            System.out.print("Ingrese nombre: "); // Solicita la cadena del nombre
            String nombre = scanner.nextLine(); // Almacena la cadena capturada por teclado
            
            listaProductos[i] = new ProductoJerarquico(id, nombre); // Inserta el objeto ProductoJerarquico creado dentro del arreglo
            
            System.out.println("Ingrese las ventas de los 5 días:"); // Imprime el rótulo indicador de las columnas
            for (int j = 0; j < diasSemana; j++) { 
                System.out.print("  Día " + (j + 1) + ": "); // Rotula el número de día de forma incremental
                matrizVentas[i][j] = Double.parseDouble(scanner.nextLine()); // Guarda el valor decimal directamente en la matriz
            } 
        }
        
        ArbolBinarioBusqueda arbolClasificacion = new ArbolBinarioBusqueda(); // Instancia el objeto de la estructura jerárquica no lineal
        
        // Bucle para procesar las filas matemáticas y alimentar dinámicamente el árbol binario
        for (int i = 0; i < N; i++) { 
            double totalSumaProducto = 0; // Coloca en cero el sumador local para procesar el producto correspondiente
            for (int j = 0; j < diasSemana; j++) { 
                totalSumaProducto += matrizVentas[i][j]; // Ejecuta la sumatoria de las ventas diarias acumuladas en la matriz
            } 
            
            arbolClasificacion.insertar(listaProductos[i].id, totalSumaProducto); 
        } 
        
        System.out.println("\n--- REPORTE CONSOLIDADO EN ÁRBOL (Ordenado de Menor a Mayor Venta) ---"); // Título explicativo del reporte
        ArbolBinarioBusqueda.recorrerInorden(arbolClasificacion.raiz); // Ejecuta el método estático de recorrido recursivo inorden pasándole la raíz
        
        scanner.close(); 
    }
}