/* Estructura Dinámica Lineal (Lista Enlazada Simple):
1 Los productos cuyos acumulados semanales sean menores a un umbral mínimo (ejemplo: 500 unidades) deben insertarse
dinámicamente en una Lista Enlazada Simple de Alertas de Reposición.
2 Cada nodo de la lista debe almacenar la información del producto y el puntero al siguiente nodo.
3 El sistema debe recorrer la lista con un bucle while utilizando un puntero auxiliar actual para mostrar
los productos que requieren reabastecimiento.*/
package estructuras_datos;

import java.util.Scanner; 

// Se cambió el nombre a ProductoDinamico para evitar duplicados en el mismo paquete
class ProductoDinamico { 
    int id;
    String nombre; 

    public ProductoDinamico(int id, String nombre) { 
        this.id = id; 
        this.nombre = nombre; 
    } 
} 

class NodoLista { 
    ProductoDinamico producto; // Utiliza la clase adaptada
    double totalVentasAcumuladas; 
    NodoLista siguiente; 

    public NodoLista(ProductoDinamico producto, double totalVentasAcumuladas) { 
        this.producto = producto; 
        this.totalVentasAcumuladas = totalVentasAcumuladas; 
        this.siguiente = null; 
    } 
} 

class ListaEnlazadaSimple { 
    NodoLista head; 

    public ListaEnlazadaSimple() { 
        this.head = null; 
    } 

    public void insertarAlInicio(ProductoDinamico prod, double total) { 
        NodoLista nuevoNodo = new NodoLista(prod, total); 
        nuevoNodo.siguiente = head; 
        head = nuevoNodo; 
    } 

    public void mostrarListaAlertas() { 
        NodoLista actual = head; 
        
        if (actual == null) { 
            System.out.println("No hay productos que requieran alerta de reposición."); 
            return; 
        } 
        
        System.out.println("\n--- LISTA DE ALERTAS DE REPOSICIÓN (Ventas < 500 unidades) ---"); 
        
        while (actual != null) { 
            System.out.println("ID: " + actual.producto.id 
                               + " | Producto: " + actual.producto.nombre 
                               + " | Acumulado Semanal: " + actual.totalVentasAcumuladas + " unidades"); 
            actual = actual.siguiente; 
        } 
    } 
} 

// Coincide exactamente con el nombre de tu archivo en NetBeans
public class Estructuras_Dinamicas { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Ingrese la cantidad de productos a registrar (N): "); 
        int N = Integer.parseInt(scanner.nextLine()); 
        
        int diasSemana = 5;
        ProductoDinamico[] listaProductos = new ProductoDinamico[N]; 
        double[][] matrizVentas = new double[N][diasSemana]; 
        
        for (int i = 0; i < N; i++) { 
            System.out.println("\n[Registro del Producto " + (i + 1) + " de " + N + "]"); 
            System.out.print("Ingrese código (id): "); 
            int id = Integer.parseInt(scanner.nextLine()); 
            System.out.print("Ingrese nombre: "); 
            String nombre = scanner.nextLine(); 
            
            listaProductos[i] = new ProductoDinamico(id, nombre); 
            
            System.out.println("Ingrese las ventas de los 5 días:"); 
            for (int j = 0; j < diasSemana; j++) { 
                System.out.print("  Día " + (j + 1) + ": "); 
                matrizVentas[i][j] = Double.parseDouble(scanner.nextLine()); 
            } 
        } 
        
        ListaEnlazadaSimple listaAlertas = new ListaEnlazadaSimple(); 
        
        for (int i = 0; i < N; i++) { 
            double totalSumaProducto = 0; 
            for (int j = 0; j < diasSemana; j++) { 
                totalSumaProducto += matrizVentas[i][j]; 
            } 
            
            if (totalSumaProducto < 500) { 
                listaAlertas.insertarAlInicio(listaProductos[i], totalSumaProducto); 
            } 
        } 
        
        listaAlertas.mostrarListaAlertas(); 
        
        scanner.close(); 
    } 
}