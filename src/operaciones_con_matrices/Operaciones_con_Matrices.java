
package operaciones_con_matrices;
import java.util.Scanner; // Importa la clase Scanner
import java.util.Random; // Importa la clase Random

public class Operaciones_con_Matrices {
     public static void main(String[] args) { // Método de ejecución principal
        Scanner sc = new Scanner(System.in); // Instancia Scanner
        Random rnd = new Random(); // Instancia Random
        
        System.out.print("Ingrese el número de filas (M): "); // Pide filas
        int m = sc.nextInt(); // Lee filas
        System.out.print("Ingrese el número de columnas (N): "); // Pide columnas
        int n = sc.nextInt(); // Lee columnas
        
        int[][] matA = new int[m][n]; // Crea Matriz A
        int[][] matB = new int[m][n]; // Crea Matriz B
        
        // Llenar matrices
        for(int i = 0; i < m; i++) { // Recorre filas
            for(int j = 0; j < n; j++) { // Recorre columnas
                matA[i][j] = rnd.nextInt(10); // Asigna aleatorio a A
                matB[i][j] = rnd.nextInt(10); // Asigna aleatorio a B
            }
        }
        
        System.out.println("\nMatriz A:"); imprimirMatriz(matA); // Imprime matriz A
        System.out.println("Matriz B:"); imprimirMatriz(matB); // Imprime matriz B
        
        System.out.println("\nOperaciones disponibles:"); // Menú
        System.out.println("1. Sumar"); // Opción 1
        System.out.println("2. Restar"); // Opción 2
        System.out.println("3. Multiplicar"); // Opción 3
        System.out.println("4. Trasponer matriz A"); // Opción 4
        System.out.print("Seleccione una opción: "); // Pide opción
        int op = sc.nextInt(); // Lee opción
        
        switch(op) { // Estructura condicional múltiple
            case 1: // Suma
                int[][] suma = new int[m][n]; // Matriz resultado
                for(int i=0; i<m; i++) for(int j=0; j<n; j++) suma[i][j] = matA[i][j] + matB[i][j]; // Suma
                System.out.println("Resultado Suma:"); imprimirMatriz(suma); // Imprime suma
                break;
            case 2: // Resta
                int[][] resta = new int[m][n]; // Matriz resultado
                for(int i=0; i<m; i++) for(int j=0; j<n; j++) resta[i][j] = matA[i][j] - matB[i][j]; // Resta
                System.out.println("Resultado Resta:"); imprimirMatriz(resta); // Imprime resta
                break;
            case 3: // Multiplicación 
                if (m == n) { // Verificamos si son multiplicables clásicamente
                    int[][] mult = new int[m][n]; // Resultado
                    for(int i=0; i<m; i++) { // Fila A
                        for(int j=0; j<n; j++) { // Columna B
                            for(int k=0; k<n; k++) { // Elemento a elemento
                                mult[i][j] += matA[i][k] * matB[k][j]; // Suma de productos
                            }
                        }
                    }
                    System.out.println("Resultado Multiplicación:"); imprimirMatriz(mult); // Imprime mult
                } else {
                    System.out.println("Para multiplicar, deben ser cuadradas o M=N (en este ejercicio simple)."); // Aviso
                }
                break;
            case 4: // Traspuesta
                int[][] trasp = new int[n][m]; // Matriz invertida (NxM)
                for(int i=0; i<m; i++) { // Filas
                    for(int j=0; j<n; j++) { // Columnas
                        trasp[j][i] = matA[i][j]; // Intercambia fila por columna
                    }
                }
                System.out.println("Resultado Traspuesta (Matriz A):"); imprimirMatriz(trasp); // Imprime traspuesta
                break;
            default: // Opción no válida
                System.out.println("Opción incorrecta"); // Mensaje de error
        }
    }
    
    // Método auxiliar para imprimir matrices
    public static void imprimirMatriz(int[][] matriz) { // Recibe matriz por parámetro
        for(int i = 0; i < matriz.length; i++) { // Itera filas
            for(int j = 0; j < matriz[i].length; j++) { // Itera columnas
                System.out.print(matriz[i][j] + "\t"); // Imprime elemento
            }
            System.out.println(); // Salto de línea por fila
        }
    }
}
