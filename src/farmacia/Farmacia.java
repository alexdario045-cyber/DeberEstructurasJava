
/*       Una farmacia necesita controlar el inventario de sus medicamentos. Por cada medicamento se debe registrar el nombre, stock actual, stock mínimo y precio unitario.

Elabore un programa que permita:

a.       Registrar varios medicamentos en una lista

b.       Mostrar los medicamentos cuyo stock esté por debajo del mínimo

c.       Calcular el valor económico total del inventario

d.       Actualizar el stock después de una venta

e.       Mostrar un reporte general del inventario
 */
package farmacia;

import java.util.ArrayList;
import java.util.Scanner;

public class Farmacia {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Medicamento> listaInventario = new ArrayList<>();
        int opcion;
        // Datos iniciales de prueba
        listaInventario.add(new Medicamento("Paracetamol", 150, 50, 0.10)); //inserta el medicamento "Paracetamol" con 150 unidades en bodega
        listaInventario.add(new Medicamento("Amoxicilina", 20, 30, 0.45)); //inserta el medicamento "Amoxicilina" con 20 unidades en bodega
        listaInventario.add(new Medicamento("Ibuprofeno", 12, 15, 0.25)); //inserta el medicamento "Ibuprofeno" con 12 unidades en bodega

        do {
            System.out.println("\n==========================================");
            System.out.println("      SISTEMA DE INVENTARIO - FARMACIA    ");
            System.out.println("==========================================");
            System.out.println("1. Registrar Medicamento");
            System.out.println("2. Mostrar Medicamentos Bajo Stock Minimo");
            System.out.println("3. Calcular Valor Economico Total");
            System.out.println("4. Registrar Venta (Actualizar Stock)");
            System.out.println("5. Mostrar Reporte General");
            System.out.println("6. Salir del Sistema");
            System.out.print("Seleccione una opcion: ");
            opcion = sn.nextInt();
            sn.nextLine(); // Limpiar buffer

            switch (opcion) { // Evalúa el número de opción ingresado
                case 1: // Bloque para el registro de medicamentos
                    System.out.println("\n--- A. REGISTRAR MEDICAMENTO ---"); // Imprime el título de la opción
                    System.out.print("Nombre del medicamento: "); // Solicita el nombre comercial
                    String nombre = sn.nextLine(); // Captura el texto completo ingresado
                    System.out.print("Stock actual en bodega: "); // Solicita las unidades iniciales
                    int stockAct = sn.nextInt(); // Captura la cantidad entera ingresada
                    System.out.print("Stock minimo de alerta: "); // Solicita el límite de control
                    int stockMin = sn.nextInt(); // Captura la meta mínima de alerta
                    System.out.print("Precio unitario ($): "); // Solicita el precio comercial
                    double precio = sn.nextDouble(); // Captura el valor decimal ingresado

                    listaInventario.add(new Medicamento(nombre, stockAct, stockMin, precio)); // Crea el objeto y lo inserta en la lista
                    System.out.println("Medicamento registrado con Exito!"); // Confirma la inserción correcta
                    break; // Detiene la ejecución de este caso
                case 2: // Bloque para control de escasez
                    System.out.println("\n--- B. MEDICAMENTOS BAJO EL MINIMO ---"); // Imprime título de alarmas logísticas
                    boolean hayAlertas = false; // Variable rastreadora de alertas críticas
                    for (Medicamento m : listaInventario) { // Recorre secuencialmente cada medicamento guardado
                        if (m.estaBajoMinimo()) { // Invoca el método auditor del objeto
                            System.out.println("⚠️ " + m.getNombre() + " -> Stock Actual: " + m.getStockActual() + " | Minimo requerido: " + m.getStockMinimo()); 
                                // Imprime el detalle del producto escaseado
                            hayAlertas = true; // Cambia el rastreador a verdadero
                        }
                    }
                    if (!hayAlertas) { // Evalúa si el almacén está saludable
                        System.out.println("Todo correcto. Ningún medicamento está bajo el minimo."); // Confirma que no hay desabastecimiento
                    }
                    break; // Detiene la ejecución de este caso
                case 3: // Bloque para la contabilidad neta
                    System.out.println("\n--- C. VALOR ECONOMICO DEL INVENTARIO ---"); // Imprime título del reporte financiero
                    double valorTotal = 0; // Acumulador local para centralizar el capital
                    for (Medicamento m : listaInventario) { // Camina de forma lineal por la lista
                        valorTotal += m.getValorInventario(); // Suma el patrimonio calculado por el objeto
                    }
                    System.out.printf("El valor total de la mercaderia en bodega es: $%.2f\n", valorTotal); // Muestra el dinero formateado en pantalla
                    break; // Detiene la ejecución de este caso
                case 4: // Bloque para despachar productos vendidos
                    System.out.println("\n--- D. ACTUALIZAR STOCK POR VENTA ---"); // Imprime título de ventas e inventario
                    System.out.print("Ingrese el nombre del medicamento vendido: "); // Solicita el término de búsqueda exacta
                    String buscar = sn.nextLine(); // Captura la cadena ingresada por el usuario
                    Medicamento encontrado = null; // Variable puntero para guardar la coincidencia

                    for (Medicamento m : listaInventario) { // Recorre los casilleros de almacenamiento dinámico
                        if (m.getNombre().equalsIgnoreCase(buscar)) { // Compara los nombres ignorando mayúsculas
                            encontrado = m; // Enlaza el objeto localizado en memoria
                            break; // Detiene el bucle por optimización del procesador
                        }
                    }
                    if (encontrado != null) { // Valida si la búsqueda arrojó un resultado
                        System.out.print("Cantidad a vender: "); // Pide el volumen de la transacción
                        int cant = sn.nextInt(); // Captura las unidades demandadas
                        encontrado.registrarVenta(cant); // Delega la reducción de stock al objeto guardián
                    } else { // Si el puntero permaneció en nulo
                        System.out.println("Error: El medicamento no existe en el catalogo."); // Avisa que el nombre no está registrado
                    }
                    break; // Detiene la ejecución de este caso
                case 5:
                    System.out.println("\n--- E. REPORTE GENERAL DE INVENTARIO ---");
                    System.out.printf("%-15s %-12s %-12s %-10s %-10s\n", "Nombre", "Stock Act.", "Stock Mín.", "Precio U.", "Total ($)");
                    System.out.println("------------------------------------------------------------------");
                    for (Medicamento m : listaInventario) {
                        System.out.printf("%-15s %-12d %-12d $%-9.2f $%-9.2f\n",
                                m.getNombre(), m.getStockActual(), m.getStockMinimo(), m.getPrecioUnitario(), m.getValorInventario());
                    }
                    break;
                case 6:
                    System.out.println("\n¡Gracias por utilizar el sistema de control farmacéutico!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sn.close();
    }
}
// CLASE MEDICAMENTO (Se coloca aquí abajo sin la palabra public)

class Medicamento { // Molde técnico del objeto Medicamento

    private String nombre; // Propiedad privada para el nombre
    private int stockActual; // Propiedad privada para existencias reales
    private int stockMinimo; // Propiedad privada para el límite de alerta
    private double precioUnitario; // Propiedad privada para el precio individual

    public Medicamento(String nombre, int stockActual, int stockMinimo, double precioUnitario) { // Constructor para configurar el objeto al nacer
        this.nombre = nombre; // Guarda el nombre en la propiedad interna
        this.stockActual = stockActual; // Guarda las existencias en la propiedad interna
        this.stockMinimo = stockMinimo; // Guarda el límite en la propiedad interna
        this.precioUnitario = precioUnitario; // Guarda el precio en la propiedad interna
    }

    public String getNombre() { // Método seguro para exportar el nombre
        return nombre; // Retorna el valor de la propiedad
    }

    public int getStockActual() { // Método seguro para consultar existencias
        return stockActual; // Retorna las unidades disponibles
    }

    public int getStockMinimo() { // Método seguro para conocer la alerta configurada
        return stockMinimo; // Retorna el umbral de seguridad
    }

    public double getPrecioUnitario() { // Método seguro para consultar el costo unitario
        return precioUnitario; // Retorna el valor asignado de venta
    }

    public void registrarVenta(int cantidadVendida) { // Método guardián para restar stock en ventas
        if (cantidadVendida <= this.stockActual) { // Valida si la demanda no supera el stock real
            this.stockActual -= cantidadVendida; // Resta las piezas vendidas de las existencias
            System.out.println("Venta procesada con éxito. Stock actualizado."); // Confirma la reducción física en consola
        } else { // Si se intenta vender más de lo que hay
            System.out.println("Error: No hay suficiente stock disponible para la venta."); // Bloquea la transacción para evitar descuadres
        }
    }

    public double getValorInventario() { // Método calculador del patrimonio en bodega
        return this.stockActual * this.precioUnitario; // Multiplica existencias reales por el precio unitario
    }

    public boolean estaBajoMinimo() { // Método auditor para revisar escasez
        return this.stockActual < this.stockMinimo; // Devuelve verdadero si el stock perforó el límite de seguridad
    }
}
