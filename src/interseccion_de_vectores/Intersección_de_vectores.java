
package interseccion_de_vectores;
import java.util.Scanner;

public class Intersección_de_vectores {
     public static void main(String[] args) { // Método principal que ejecuta el código
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para entrada de datos
        
        System.out.print("Ingrese N (cantidad de estudiantes): "); // Imprime mensaje
        int n = sc.nextInt(); // Lee el tamaño de los arreglos
        
        String[] mat = new String[n]; // Crea el arreglo para los reprobados en Matemáticas
        String[] ing = new String[n]; // Crea el arreglo para los reprobados en Inglés
        
        System.out.println("\n--- Estudiantes que reprobaron MATEMATICA ---"); // Imprime título
        for(int i = 0; i < n; i++) { // Bucle para pedir cada cédula
            System.out.print("Cédula estudiante " + (i+1) + ": "); // Pide la cédula
            mat[i] = sc.next(); // Guarda la cédula en el arreglo de matemáticas
        }
        
        System.out.println("\n--- Estudiantes que reprobaron INGLES ---"); // Imprime título
        for(int i = 0; i < n; i++) { // Bucle para pedir cada cédula
            System.out.print("Cédula estudiante " + (i+1) + ": "); // Pide la cédula
            ing[i] = sc.next(); // Guarda la cédula en el arreglo de inglés
        }
        
        String[] ambos = new String[n]; // Crea el arreglo para los reprobados en ambas materias
        int count = 0; // Inicializa el contador de coincidencias en cero
        
        for(int i = 0; i < n; i++) { // Recorre el arreglo de matemáticas
            for(int j = 0; j < n; j++) { // Recorre el arreglo de inglés
                if(mat[i].equals(ing[j])) { // Compara si la cédula es la misma en ambos
                    ambos[count] = mat[i]; // Guarda la cédula en el arreglo 'ambos'
                    count++; // Incrementa el contador de coincidencias
                    break; // Termina el bucle interno si ya encontró la coincidencia
                }
            }
        }
        
        System.out.println("\n=== RESULTADOS ==="); // Imprime título de resultados
        System.out.print("Reprobaron Matemática: "); // Imprime etiqueta
        for(String c : mat) System.out.print(c + " "); // Imprime todo el arreglo de matemática
        
        System.out.print("\nReprobaron Inglés: "); // Imprime etiqueta
        for(String c : ing) System.out.print(c + " "); // Imprime todo el arreglo de inglés
        
        System.out.print("\nReprobaron Ambas Materias: "); // Imprime etiqueta
        for(int i = 0; i < count; i++) { // Recorre el arreglo 'ambos' hasta los elementos encontrados
            System.out.print(ambos[i] + " "); // Imprime los elementos
        }
        System.out.println(); // Salto de línea final
    }
}
