/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDeColas;
import java.util.Random;

/**
 *
 * @author Miguel
 */

/**
 * Simulación de un supermercado con:
 * - 25 carritos de compra (cola de recursos compartidos)
 * - 3 cajas de pago (cada una con su propia cola de clientes)
 * - Clientes que:
 *      - Esperan si no hay carritos disponibles.
 *      - Se colocan en la caja con menos clientes.
 *      - Liberan el carrito al pagar.
 * 
 * Usa las clases personalizadas Cola<T> y Nodo<T>.
 * 
 * Autor: Miguel
 * Fecha: 2025
 */
public class SimulacionSupermercado {

    public static void main(String[] args) throws InterruptedException {
        // Cola de carritos disponibles
        Cola<Integer> carritos = new Cola<>();
        for (int i = 1; i <= 25; i++) {
            carritos.insertar(i);
        }

        // Tres colas de cajas (representan las líneas de clientes esperando)
        Cola<Integer> caja1 = new Cola<>();
        Cola<Integer> caja2 = new Cola<>();
        Cola<Integer> caja3 = new Cola<>();

        Random random = new Random();
        int clienteId = 1;

        // Simulamos un tiempo 
        for (int tiempo = 1; tiempo <= 5; tiempo++) {
            System.out.println("\n⏱️ Tiempo " + tiempo);

            // Cada ciclo puede llegar un nuevo cliente (probabilidad del 60%)
            if (random.nextInt(100) < 60) {
                if (!carritos.colaVacia()) {
                    int carrito = carritos.quitar();
                    System.out.println("Cliente " + clienteId + " tomó el carrito " + carrito);

                    // Elige la caja con menos clientes
                    int tam1 = caja1.getTamano();
                    int tam2 = caja2.getTamano();
                    int tam3 = caja3.getTamano();

                    if (tam1 <= tam2 && tam1 <= tam3) {
                        caja1.insertar(clienteId);
                        System.out.println("Cliente " + clienteId + " fue a la Caja 1");
                    } else if (tam2 <= tam1 && tam2 <= tam3) {
                        caja2.insertar(clienteId);
                        System.out.println("Cliente " + clienteId + " fue a la Caja 2");
                    } else {
                        caja3.insertar(clienteId);
                        System.out.println("Cliente " + clienteId + " fue a la Caja 3");
                    }

                    clienteId++;
                } else {
                    System.out.println("No hay carritos disponibles, el cliente espera.");
                }
            }

            // Simulamos atención de cajas (cada caja atiende 1 cliente con 50% de probabilidad)
            if (!caja1.colaVacia() && random.nextInt(100) < 50) {
                int cliente = caja1.quitar();
                System.out.println("✅ Caja 1 atendió al cliente " + cliente);
                carritos.insertar(cliente); // el cliente libera el carrito
            }

            if (!caja2.colaVacia() && random.nextInt(100) < 50) {
                int cliente = caja2.quitar();
                System.out.println("✅ Caja 2 atendió al cliente " + cliente);
                carritos.insertar(cliente); // el cliente libera el carrito
            }

            if (!caja3.colaVacia() && random.nextInt(100) < 50) {
                int cliente = caja3.quitar();
                System.out.println("Caja 3 atendió al cliente " + cliente);
                carritos.insertar(cliente); // el cliente libera el carrito
            }

            // Mostrar estado general
            System.out.println("Estado actual:");
            System.out.println("   Carritos disponibles: " + carritos.getTamano());
            System.out.println("   Caja 1: " + caja1.getTamano() + " clientes");
            System.out.println("   Caja 2: " + caja2.getTamano() + " clientes");
            System.out.println("   Caja 3: " + caja3.getTamano() + " clientes");

            // Pausa para ver la simulación paso a paso
            Thread.sleep(500);
        }

        System.out.println("\nFin de la simulación.");
        System.out.println("Carritos disponibles al final: " + carritos.getTamano());
    }
}

