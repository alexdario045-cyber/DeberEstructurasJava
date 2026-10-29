/*
En una universidad, se tiene un grupo de N estudiantes; cada uno de ellos toma 8 materias; semestralmente el profesor de cada materia reporta a secretaría general el código del estudiante, el número de la materia y la calificación final. Elaborar un algoritmo que obtenga.

a.       El promedio de las calificaciones obtenidas por cada estudiante.

b.       El promedio de la calificación por cada materia

c.       El estudiante con mayor promedio

d.       El número de estudiantes aprobados (nota final >= 7 y <= 10) por cada materia.

e.       El número de estudiantes reprobados (nota final < 7) por cada materia.
*/

package controlacademico; 
import java.util.Scanner; 
public class ControlAcademico { 
    public static void main(String[] args) { // Punto de inicio obligatorio del programa
        Scanner scanner = new Scanner(System.in); // Instancia el objeto para capturar datos
        System.out.print("Ingrese la cantidad de estudiantes (N): "); // Pide el número de alumnos
        int nEstudiantes = scanner.nextInt(); // Almacena el total de estudiantes ingresados
        final int MATERIAS = 8; // Define el límite fijo de 8 asignaturas
        double[][] notas = new double[nEstudiantes][MATERIAS]; // Declara la matriz para notas (N x 8)
        double[] promediosEstudiantes = new double[nEstudiantes]; // Declara el vector para promedios de alumnos
        System.out.println("\n--- INGRESO DE CALIFICACIONES (Notas de 0 a 10) ---"); // Muestra título en consola
        for (int i = 0; i < nEstudiantes; i++) { // Bucle externo: recorre estudiante por estudiante
            System.out.println("Estudiante " + (i + 1) + ":"); // Imprime la etiqueta del alumno actual
            for (int j = 0; j < MATERIAS; j++) { // Bucle interno: recorre las 8 materias del alumno
                System.out.print("  Materia " + (j + 1) + ": "); // Solicita la nota de la asignatura actual
                notas[i][j] = scanner.nextDouble(); // Guarda la calificación en la celda [i][j]
            } 
        } 
        System.out.println("\n--- a. PROMEDIO DE CALIFICACIONES POR ESTUDIANTE ---"); // Muestra encabezado del reporte A
        for (int i = 0; i < nEstudiantes; i++) { // Recorre secuencialmente a cada estudiante (filas)
            double sumaNotas = 0; // Inicializa el acumulador de notas del alumno en 0
            for (int j = 0; j < MATERIAS; j++) { // Se mueve por las columnas de materias del alumno
                sumaNotas += notas[i][j]; // Suma de forma consecutiva la nota actual
            } 
            promediosEstudiantes[i] = sumaNotas / MATERIAS; // Calcula y guarda el promedio neto del alumno
            System.out.println("Estudiante " + (i + 1) + ": Promedio = " + promediosEstudiantes[i]); // Imprime el promedio en pantalla
        } 
        System.out.println("\n--- b, d, e. REPORTE POR MATERIAS ---"); // Muestra encabezado del reporte B, D y E
        for (int j = 0; j < MATERIAS; j++) { // Inversión de ciclos: recorre de forma fija cada columna (materia)
            double sumaMateria = 0; // Inicializa el acumulador de notas de la materia en 0
            int aprobados = 0; // Inicializa el contador de aprobados en 0
            int reprobados = 0; // Inicializa el contador de reprobados en 0
            for (int i = 0; i < nEstudiantes; i++) { // Bucle interno: desciende verticalmente por los alumnos
                double notaActual = notas[i][j]; // Extrae la nota del estudiante 'i' en la materia 'j'
                sumaMateria += notaActual; // Acumula la nota para el promedio general de la materia
                if (notaActual >= 7.0 && notaActual <= 10.0) { // Evalúa si la calificación es aprobatoria
                    aprobados++; // Incrementa en 1 el contador de aprobados
                } 
                else if (notaActual < 7.0) { // Evalúa si la calificación es reprobatoria
                    reprobados++; // Incrementa en 1 el contador de reprobados
                } 
            } 
            double promedioMateria = sumaMateria / nEstudiantes; // Calcula el promedio final de la asignatura analizada
            System.out.println("Materia " + (j + 1) + ":"); // Imprime el nombre de la asignatura procesada
            System.out.println("  • Promedio general: " + promedioMateria); // Imprime el promedio grupal de la materia
            System.out.println("  • Estudiantes aprobados: " + aprobados); // Imprime la cantidad total de aprobados
            System.out.println("  • Estudiantes reprobados: " + reprobados); // Imprime la cantidad total de reprobados
        } 

        System.out.println("\n--- c. ESTUDIANTE CON MAYOR PROMEDIO ---"); // Muestra encabezado del reporte C
        double mayorPromedio = promediosEstudiantes[0]; // Asume temporalmente que el primer promedio es el mayor
        int indiceMejorEstudiante = 0; // Inicializa la posición del mejor alumno en 0

        for (int i = 1; i < nEstudiantes; i++) { // Recorre el vector partiendo desde el segundo estudiante
            if (promediosEstudiantes[i] > mayorPromedio) { // Evalúa si el promedio actual supera al valor máximo registrado
                mayorPromedio = promediosEstudiantes[i]; // Actualiza la variable con el nuevo promedio más alto
                indiceMejorEstudiante = i; // Registra el índice del nuevo estudiante líder en la lista
            } 
        } 
        System.out.println("El mejor estudiante es el Estudiante " + (indiceMejorEstudiante + 1)
                + " con un promedio de: " + mayorPromedio); // Imprime al ganador y su promedio correspondiente
        scanner.close(); // Cierra el flujo del teclado para liberar recursos del sistema
    } 
} 