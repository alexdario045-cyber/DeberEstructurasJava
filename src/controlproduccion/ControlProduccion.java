/* 
Se desea obtener el grado de eficiencia de N operarios de una fábrica productora de pupitres, de acuerdo con las siguientes condiciones que se les impone para un periodo determinado.
a.       Ausencia del trabajo <= 3 horas
b.       Pupitres defectuosos < 300
c.       Pupitres producidos > 10000
Los grados de eficiencia del trabajador son asignados de la siguiente forma:
a.       Si no cumple ninguna condición: Grado = 5
b.       Si sólo cumple la primera condición: Grado = 7
c.       Si sólo cumple la segunda condición: Grado = 8
d.       Si sólo cumple la tercera condición: Grado = 9
e.       Si cumple la primera y la segunda: Grado = 12
f.        Si cumple la primera y la tercera: Grado = 13
g.       Si cumple la segunda y la tercera: Grado = 15
h.       Si cumple las tres condiciones: Grado = 20
Por cada trabajador se tiene un registro con los siguientes datos:
a.       Código del trabajador
b.       Horas de ausencia
c.       Pupitres defectuosos
d.       Pupitres producidos
Se desea obtener el grado de eficiencia de N operarios de una fábrica productora de pupitres, de acuerdo con las siguientes condiciones que se les impone para un periodo determinado.
a.       Ausencia del trabajo <= 3 horas
b.       Pupitres defectuosos < 300
c.       Pupitres producidos > 10000
Los grados de eficiencia del trabajador son asignados de la siguiente forma:
a.       Si no cumple ninguna condición: Grado = 5
b.       Si sólo cumple la primera condición: Grado = 7
c.       Si sólo cumple la segunda condición: Grado = 8
d.       Si sólo cumple la tercera condición: Grado = 9
e.       Si cumple la primera y la segunda: Grado = 12
f.        Si cumple la primera y la tercera: Grado = 13
g.       Si cumple la segunda y la tercera: Grado = 15
h.       Si cumple las tres condiciones: Grado = 20
Por cada trabajador se tiene un registro con los siguientes datos:
a.       Código del trabajador
b.       Horas de ausencia
c.       Pupitres defectuosos
d.       Pupitres producidos

*/

package controlproduccion; // Define el paquete del proyecto
import java.util.ArrayList; // Importa la clase ArrayList para listas dinámicas
import java.util.List; // Importa la interfaz List de Java
import java.util.Scanner; // Importa el lector de datos por teclado

public class ControlProduccion { // Inicia la clase principal del sistema

    static class Operario { // Molde interno para almacenar a cada trabajador

        String codigo; // Variable para el código del operario
        int horasAusencia; // Variable para las horas de ausencia
        int defectuosos; // Variable para los pupitres con fallas
        int producidos; // Variable para el total de pupitres hechos
        int gradoEficiencia; // Variable para almacenar el grado final calculado
        public Operario(String codigo, int horasAusencia, int defectuosos, int producidos) { // Constructor para configurar el objeto al nacer
            this.codigo = codigo; // Asigna el parámetro al atributo de código
            this.horasAusencia = horasAusencia; // Asigna el parámetro al atributo de ausencias
            this.defectuosos = defectuosos; // Asigna el parámetro al atributo de defectuosos
            this.producidos = producidos; // Asigna el parámetro al atributo de producidos

            boolean c1 = this.horasAusencia <= 3; // Evalúa la primera condición (Ausencia <= 3)
            boolean c2 = this.defectuosos < 300; // Evalúa la segunda condición (Defectuosos < 300)
            boolean c3 = this.producidos > 10000; // Evalúa la tercera condición (Producidos > 10000)
            if (c1 && c2 && c3) { // h. Si cumple las tres condiciones
                this.gradoEficiencia = 20; // Asigna grado de eficiencia igual a 20
            } else if (!c1 && c2 && c3) { // g. Si cumple la segunda y la tercera
                this.gradoEficiencia = 15; // Asigna grado de eficiencia igual a 15
            } else if (c1 && !c2 && c3) { // f. Si cumple la primera y la tercera
                this.gradoEficiencia = 13; // Asigna grado de eficiencia igual a 13
            } else if (c1 && c2 && !c3) { // e. Si cumple la primera y la segunda
                this.gradoEficiencia = 12; // Asigna grado de eficiencia igual a 12
            } else if (!c1 && !c2 && c3) { // d. Si sólo cumple la tercera condición
                this.gradoEficiencia = 9; // Asigna grado de eficiencia igual a 9
            } else if (!c1 && c2 && !c3) { // c. Si sólo cumple la segunda condición
                this.gradoEficiencia = 8; // Asigna grado de eficiencia igual a 8
            } else if (c1 && !c2 && !c3) { // b. Si sólo cumple la primera condición
                this.gradoEficiencia = 7; // Asigna grado de eficiencia igual a 7
            } else { // a. Si no cumple ninguna condición
                this.gradoEficiencia = 5; // Asigna grado de eficiencia igual a 5
            }
        }
    }
    public static void main(String[] args) { // Punto de inicio obligatorio de la aplicación
        Scanner scanner = new Scanner(System.in); // Crea la instancia del lector de consola

        List<Operario> listaOperarios = new ArrayList<>(); // Inicializa la lista dinámica para guardar operarios
        System.out.println("=== SISTEMA DE RENDIMIENTO Y EFICIENCIA DE OPERARIOS ==="); // Imprime título estético de bienvenida
        System.out.print("Cuantos operarios desea registrar en esta sesion: "); // Solicita el número de registros
        int nOperarios = scanner.nextInt(); // Lee la cantidad de trabajadores en entero
        scanner.nextLine(); // Limpia el salto de línea residual del teclado

        for (int i = 1; i <= nOperarios; i++) { // Bucle para capturar los datos de forma secuencial
            System.out.println("\n--- REGISTRO DEL OPERARIO #" + i + " ---"); // Muestra la etiqueta del operario actual

            System.out.print("Codigo del trabajador: "); // Solicita la identificación única
            String codigo = scanner.nextLine(); // Lee el código completo ingresado
            System.out.print("Horas de ausencia: "); // Solicita las horas no laboradas
            int horasAusencia = scanner.nextInt(); // Lee las ausencias en valor entero
            System.out.print("Pupitres defectuosos: "); // Solicita el conteo de fallas
            int defectuosos = scanner.nextInt(); // Lee los defectuosos en valor entero
            System.out.print("Pupitres producidos: "); // Solicita la producción total
            int producidos = scanner.nextInt(); // Lee los producidos en valor entero
            scanner.nextLine(); // Limpia el buffer de datos del teclado
            Operario nuevoOperario = new Operario(codigo, horasAusencia, defectuosos, producidos); // Instancia el objeto operario calculando su grado
            listaOperarios.add(nuevoOperario); // Almacena al operario en el ArrayList dinámico
        }

        if (!listaOperarios.isEmpty()) { // Valida si la lista contiene elementos registrados
            System.out.println("\n========================================================================="); // Imprime separador para el informe
            System.out.println("                 REPORTE DETALLADO DE EFICIENCIA                         "); // Imprime cabecera del reporte final
            System.out.println("========================================================================="); // Imprime otro separador horizontal
            System.out.printf("%-10s %-12s %-12s %-12s %-10s\n", "Codigo", "Ausencias", "Defectuosos", "Producidos", "Grado"); // Imprime las cabeceras formateadas de la tabla
            System.out.println("-------------------------------------------------------------------------"); // Imprime divisor intermedio textual

            for (Operario op : listaOperarios) { // Recorre la lista de forma lineal (for-each)
                System.out.printf("%-10s %-12d %-12d %-12d Grado %d\n",
                        op.codigo, op.horasAusencia, op.defectuosos, op.producidos, op.gradoEficiencia); // Imprime los datos tabulados y alineados perfectamente
            }
            System.out.println("========================================================================="); // Cierra la estructura visual de la tabla
        } else { // Si la lista de memoria se encuentra vacía
            System.out.println("\nNo se registraron operarios en el sistema."); // Avisa de la ausencia de información en bodega
        }

        scanner.close(); // Libera los recursos del lector físico del sistema operativo
    }
}