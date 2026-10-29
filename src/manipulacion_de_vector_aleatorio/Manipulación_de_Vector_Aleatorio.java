
package manipulacion_de_vector_aleatorio;
import java.util.Scanner; // Importa Scanner para entrada de datos
import java.util.Random; // Importa Random para generar números 

public class Manipulación_de_Vector_Aleatorio {
     public static void main(String[] args) { // Método principal
        Scanner sc = new Scanner(System.in); // Instancia el objeto Scanner
        Random rnd = new Random(); // Instancia el objeto Random
        
        int[] vector1 = new int[20]; // Declara el arreglo original de 20 elementos
        System.out.println("Vector Original:"); // Título
        for(int i = 0; i < vector1.length; i++) { // Bucle para llenar el arreglo
            vector1[i] = rnd.nextInt(50) + 1; // Genera números aleatorios del 1 al 50
            System.out.print(vector1[i] + " "); // Imprime el arreglo en la misma línea
        }
        
        System.out.print("\n\nIngrese un número a buscar: "); // Pide un número al usuario
        int num = sc.nextInt(); // Lee el número ingresado
        boolean encontrado = false; // Bandera para saber si se encontró
        
        for(int i = 0; i < vector1.length; i++) { // Recorre el arreglo para buscar el número
            if(vector1[i] == num) { // Si el elemento coincide con el número buscado
                System.out.println("El número " + num + " se encuentra en la posición del índice: " + i); // Imprime posición
                encontrado = true; // Cambia la bandera a true
            }
        }
        if(!encontrado) System.out.println("El número no está en el vector."); // Si no se encuentra, avisa
        
        int[] vector2 = new int[10]; // Crea el segundo vector para índices impares (la mitad de 20)
        int index = 0; // Inicializa índice para el segundo vector
        
        for(int i = 1; i < vector1.length; i += 2) { // Recorre índices impares (1, 3, 5, ...)
            vector2[index] = vector1[i]; // Asigna el valor al nuevo vector
            index++; // Aumenta el índice del nuevo vector
        }
        
        System.out.println("\nVector Resultante (elementos en posiciones impares):"); // Imprime título
        int mayoresA20 = 0; // Inicializa contador para mayores a 20
        for(int i = 0; i < vector2.length; i++) { // Recorre el segundo vector
            System.out.print(vector2[i] + " "); // Imprime el elemento
            if(vector2[i] > 20) { // Si el elemento es mayor a 20
                mayoresA20++; // Incrementa el contador
            }
        }
        
        System.out.println("\n\nCantidad de elementos mayores a 20 en el segundo vector: " + mayoresA20); // Imprime el resultado
    }
}
