
package control_de_Inventario;
import java.util.Scanner; // Importa Scanner

public class Control_de_Inventario {
    public static void main(String[] args) { // Método principal
        Scanner sc = new Scanner(System.in); // Instancia de lectura
        
        System.out.print("Ingrese el número de artículos (N): "); // Pide artículos
        int n = sc.nextInt(); // Lee N (filas)
        System.out.print("Ingrese el número de sucursales (M): "); // Pide sucursales
        int m = sc.nextInt(); // Lee M (columnas)
        
        double[][] precios = new double[n][m]; // Matriz para registrar los precios (Articulo x Sucursal)
        int[][] cantidades = new int[n][m]; // Matriz para cantidades vendidas (Articulo x Sucursal)
        
        System.out.println("\n--- INGRESO DE PRECIOS ---"); // Título0
        for(int i = 0; i < n; i++) { // Recorre cada artículo
            for(int j = 0; j < m; j++) { // Recorre cada sucursal
                System.out.print("Precio Artículo " + (i+1) + " en Sucursal " + (j+1) + ": "); // Pide dato
                precios[i][j] = sc.nextDouble(); // Guarda el precio
            }
        }
        
        System.out.println("\n--- INGRESO DE CANTIDADES ---"); // Título
        for(int i = 0; i < n; i++) { // Recorre cada artículo
            for(int j = 0; j < m; j++) { // Recorre cada sucursal
                System.out.print("Cantidad Artículo " + (i+1) + " en Sucursal " + (j+1) + ": "); // Pide dato
                cantidades[i][j] = sc.nextInt(); // Guarda la cantidad
            }
        }
        
        System.out.println("\n=== TOTAL DE VENTAS POR ARTÍCULO ==="); // Reporte 1
        for(int i = 0; i < n; i++) { // Itera artículos
            double totalArticulo = 0; // Acumulador en cero
            for(int j = 0; j < m; j++) { // Itera sucursales
                totalArticulo += (precios[i][j] * cantidades[i][j]); // Calcula subtotal y suma
            }
            System.out.println("Artículo " + (i+1) + " total ventas: $" + totalArticulo); // Imprime
        }
        
        System.out.println("\n=== TOTAL DE VENTAS POR SUCURSAL ==="); // Reporte 2
        for(int j = 0; j < m; j++) { // Itera sucursales (columnas primero)
            double totalSucursal = 0; // Acumulador en cero
            for(int i = 0; i < n; i++) { // Itera artículos (filas)
                totalSucursal += (precios[i][j] * cantidades[i][j]); // Calcula subtotal y suma
            }
            System.out.println("Sucursal " + (j+1) + " total ventas: $" + totalSucursal); // Imprime
        }
    }
}
