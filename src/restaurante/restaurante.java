
/*
 Un restaurante registra los pedidos realizados por sus clientes. Por cada pedido se debe ingresar el nombre del cliente, plato solicitado, cantidad y precio unitario.

Elabore un programa que permita:

a.       Registrar pedidos en una lista

b.       Calcular el total a pagar por cada pedido

c.       Aplicar un descuento del 10% si el pedido supera los 50 USD

d.       Calcular el ingreso total del restaurante

e.       Mostrar el pedido de mayor valor.
*/
package restaurante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Restaurante { // Inicia la clase principal del sistema

    static class Pedido { // Molde interno para almacenar cada pedido

        String cliente; // Variable para el nombre del cliente
        String plato; // Variable para el plato solicitado
        int cantidad; // Variable para la cantidad ordenada
        double precioUnitario; // Variable para el precio individual
        double totalAPagar; // Variable para el monto final calculado

        public Pedido(String cliente, String plato, int cantidad, double precioUnitario) { // Constructor para configurar el objeto al nacer
            this.cliente = cliente; // Asigna el parámetro al atributo cliente
            this.plato = plato; // Asigna el parámetro al atributo plato
            this.cantidad = cantidad; // Asigna el parámetro al atributo cantidad
            this.precioUnitario = precioUnitario; // Asigna el parámetro al atributo de precio
            double subtotal = cantidad * precioUnitario; // Calcula el subtotal multiplicando cantidad por precio

            if (subtotal > 50.0) { // Evalúa si el monto supera los 50 USD
                this.totalAPagar = subtotal * 0.90; // Aplica el descuento neto del 10%
            } else { // Si no supera el umbral establecido
                this.totalAPagar = subtotal; // Asigna el subtotal directo sin descuento
            }
        }
    }

    public static void main(String[] args) { // Punto de inicio obligatorio de la aplicación
        Scanner scanner = new Scanner(System.in); // Crea la instancia del lector de consola

        List<Pedido> listaPedidos = new ArrayList<>(); // Inicializa la lista dinámica para guardar pedidos
        System.out.println("=== SISTEMA DE REGISTRO DE PEDIDOS - RESTAURANTE ==="); // Imprime título estético de bienvenida
        System.out.print("Cuantos pedidos desea registrar en esta sesion?: "); // Solicita el número de registros
        int numeroPedidos = scanner.nextInt(); // Lee la cantidad de órdenes a procesar
        scanner.nextLine(); // Limpia el salto de línea residual del teclado

        for (int i = 1; i <= numeroPedidos; i++) { // Bucle para capturar los datos de forma secuencial
            System.out.println("\n--- REGISTRO DEL PEDIDO #" + i + " ---"); // Muestra la etiqueta de la orden actual

            System.out.print("Nombre del cliente: "); // Solicita la identificación del comensal
            String cliente = scanner.nextLine(); // Lee el nombre completo del cliente
            System.out.print("Plato solicitado: "); // Solicita el nombre del alimento
            String plato = scanner.nextLine(); // Lee la descripción del platillo
            System.out.print("Cantidad: "); // Solicita el volumen de la orden
            int cantidad = scanner.nextInt(); // Lee la cantidad de porciones en entero

            System.out.print("Precio unitario ($): "); // Solicita el costo individual
            double precioUnitario = scanner.nextDouble(); // Lee el precio decimal de la ración
            scanner.nextLine(); // Limpia el buffer de datos del teclado
            Pedido nuevoPedido = new Pedido(cliente, plato, cantidad, precioUnitario); // Instancia el objeto calculando su total
            listaPedidos.add(nuevoPedido); // Almacena el pedido en el ArrayList dinámico
            System.out.println(">> Pedido registrado. Total de este cliente a pagar: $" + nuevoPedido.totalAPagar); // Muestra el total inmediato en la consola
        }

        if (!listaPedidos.isEmpty()) { // Valida si la lista contiene elementos registrados
            double ingresoTotalRestaurante = 0; // Inicializa el acumulador contable del negocio
            Pedido pedidoMayorValor = listaPedidos.get(0); // Enlaza el primer pedido como el mayor provisional
            System.out.println("\n========================================================"); // Imprime separador para el informe
            System.out.println("              RESUMEN GENERAL DE VENTAS                 "); // Imprime cabecera del reporte final
            System.out.println("========================================================"); // Imprime separador horizontal de tabla

            for (Pedido p : listaPedidos) { // Recorre la lista de forma lineal (for-each)
                ingresoTotalRestaurante += p.totalAPagar; // Acumula el dinero recaudado de forma consecutiva

                if (p.totalAPagar > pedidoMayorValor.totalAPagar) { // Evalúa si la orden actual supera al máximo guardado
                    pedidoMayorValor = p; // Intercambia el puntero hacia la nueva orden más cara
                }
            }

            System.out.println("d. Ingreso total acumulado por el restaurante: $" + ingresoTotalRestaurante); // Muestra las ganancias netas de la sesión
            System.out.println("--------------------------------------------------------"); // Imprime divisor intermedio
            System.out.println("e. DETALLE DEL PEDIDO DE MAYOR VALOR:"); // Imprime etiqueta informativa del literal E
            System.out.println("   * Cliente: " + pedidoMayorValor.cliente); // Muestra el cliente que hizo el gasto más alto
            System.out.println("   * Plato: " + pedidoMayorValor.plato); // Muestra el platillo de la orden más cara
            System.out.println("   * Cantidad total: " + pedidoMayorValor.cantidad); // Muestra el volumen de porciones adquiridas
            System.out.println("   * Monto final cobrado (con descuento si aplica): $" + pedidoMayorValor.totalAPagar); // Muestra el cobro neto del boleto líder
            System.out.println("========================================================"); // Cierra la estructura visual de la tabla
        } else { // Si la lista de memoria se encuentra vacía
            System.out.println("\nNo se registraron pedidos en el sistema."); // Avisa de la ausencia de información en bodega
        }

        scanner.close(); // Libera los recursos del lector físico del sistema operativo
    }
}
