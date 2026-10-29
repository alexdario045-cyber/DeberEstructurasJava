
package busquedaarreglos;
import java.util.Scanner; // Importa clase Scanner

public class Busqueda_en_Arreglos_Paralelos {
    public static void main(String[] args) { // Método principal
        Scanner sc = new Scanner(System.in); // Crea instancia para leer por teclado
        
        System.out.print("Ingrese la cantidad de empleados (N): "); // Solicita la cantidad de empleados
        int n = sc.nextInt(); // Lee la cantidad N
        
        String[] codigos = new String[n]; // Arreglo para almacenar los códigos
        String[] nombres = new String[n]; // Arreglo paralelo para almacenar los nombres
        
        for(int i = 0; i < n; i++) { // Bucle para ingresar datos de cada empleado
            System.out.println("\nEmpleado " + (i+1)); // Muestra el número del empleado
            System.out.print("Código: "); // Pide el código
            codigos[i] = sc.next(); // Guarda el código
            sc.nextLine(); // Limpia el buffer
            System.out.print("Nombre: "); // Pide el nombre
            nombres[i] = sc.nextLine(); // Guarda el nombre (incluye espacios)
        }
        
        System.out.print("\nIngrese el código del empleado que desea buscar: "); // Pide el código a buscar
        String buscar = sc.next(); // Lee el código a buscar
        boolean hallado = false; // Variable para verificar si existe
        
        for(int i = 0; i < n; i++) { // Recorre el arreglo de códigos
            if(codigos[i].equals(buscar)) { // Verifica si el código actual es el buscado
                System.out.println("El empleado correspondiente es: " + nombres[i]); // Imprime el nombre
                hallado = true; // Marca como encontrado
                break; // Sale del ciclo al encontrarlo
            }
        }
        
        if(!hallado) { // Si no se encontró el empleado
            System.out.println("Código no encontrado."); // Muestra mensaje de error
        }
    }
}


