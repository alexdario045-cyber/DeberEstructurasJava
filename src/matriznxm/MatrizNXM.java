/*
Elaborar un programa que consolide una matriz de N x M elementos. Cada elemento de la matriz representa las ventas atribuibles a cada uno de los N vendedores de una empresa, para cada uno de los M años de operaciones que ha tenido la misma. Se debe calcular:

a.       El total de ventas de cada vendedor de los M años.

b.       El total de ventas en cada año

c.       El total de ventas de la empresa.
*/

package matriznxm;
import java.util.Scanner;
public class MatrizNXM {
    public static void main(String[] args) {
        // Inicialización de la herramienta Scanner para capturar datos desde la consola de comandos
        Scanner scanner = new Scanner(System.in);
        // 1. Configurar las dimensiones de la matriz (N vendedores x M años)
        System.out.print("Ingrese la cantidad de vendedores (N): ");
        int nVendedores = scanner.nextInt(); // Captura el número total de filas (vendedores)
        
        System.out.print("Ingrese la cantidad de anios de operacion (M): ");
        int nAnios = scanner.nextInt(); // Captura el número total de columnas (años)
        
        // Declaración e inicialización dinámica de la matriz bidimensional basada en los datos ingresados por el usuario
        double[][] ventas = new double[nVendedores][nAnios];
        // 2. Lectura y llenado de datos en la matriz mediante bucles anidados convencionales
        System.out.println("\n--- INGRESO DE DATOS DE VENTAS ---");
        for (int i = 0; i < nVendedores; i++) { // Bucle externo: controla la fila actual (vendedor)
            for (int j = 0; j < nAnios; j++) { // Bucle interno: controla la columna actual (año)
                System.out.print("Vendedor " + (i + 1) + " - Anio " + (j + 1) + ": $");
                // Almacena de forma exacta el valor ingresado en la coordenada fila [i] y columna [j]
                ventas[i][j] = scanner.nextDouble(); 
            }
        }
        // Variable acumuladora global para registrar el total consolidado de todas las ventas del negocio
        double totalEmpresa = 0;
        // ====================================================================
        // a. Calcular el total de ventas de cada vendedor de los M años (Filas)
        // ====================================================================
        System.out.println("\n--- a. TOTAL DE VENTAS POR VENDEDOR ---");
        for (int i = 0; i < nVendedores; i++) { // Bucle externo: recorre secuencialmente a cada vendedor
            double totalVendedor = 0; // Variable acumuladora local: se limpia en 0 al pasar a un nuevo vendedo
            for (int j = 0; j < nAnios; j++) { // Bucle interno: se desplaza horizontalmente sumando los años de ese vendedor
                totalVendedor += ventas[i][j]; // Suma acumulativa de las celdas pertenecientes a la fila [i]
            }
            // Imprime en consola el rendimiento financiero neto acumulado por el vendedor evaluado
            System.out.println("Vendedor " + (i + 1) + ": $" + totalVendedor);
        }
        // ====================================================================
        // b. Calcular el total de ventas en cada año (Columnas)
        // ====================================================================
        System.out.println("\n--- b. TOTAL DE VENTAS POR ANIO ---");
        // INVERSIÓN DE CICLOS: Pasamos la variable de las columnas 'j' al bucle externo para forzar la lectura vertical
        for (int j = 0; j < nAnios; j++) { // Bucle externo: se congela en un año específico
            double totalAnio = 0; // Variable acumuladora local: se limpia al cambiar de año
            for (int i = 0; i < nVendedores; i++) { // Bucle interno: desciende a través de todos los vendedores para ese año
                totalAnio += ventas[i][j]; // Suma acumulativa de las celdas pertenecientes a la columna [j]
            }
            System.out.println("ANIO " + (j + 1) + ": $" + totalAnio);
            // OPTIMIZACIÓN: Acumula el total anual directamente en el saldo de la empresa, evitando un tercer bucle extra
            totalEmpresa += totalAnio; 
        }
        // ====================================================================
        // c. Mostrar el total de ventas de la empresa
        // ====================================================================
        System.out.println("\n--- c. TOTAL DE VENTAS GENERAL DE LA EMPRESA ---");
        // Imprime el gran consolidado monetario acumulado a lo largo de toda la matriz de datos
        System.out.println("El total consolidado de la empresa es: $" + totalEmpresa);
        // Cierre del flujo del objeto Scanner para liberar los recursos de memoria del sistema operativo
        scanner.close();
    }
}