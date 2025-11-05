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
public class SimulacionAtencionCliente {

    public static void main(String[] args) {
        Random random = new Random();

        // Fila única de clientes
        Cola<Cliente> fila = new Cola<>();

        // Tiempos restantes para cada caja (0 = libre)
        int[] tiempoCaja = new int[4];

        // Estado de la 4ta caja
        boolean cuartaCajaAbierta = false;
        int minutoAperturaCuarta = -1;

        // Variables de estadísticas
        int totalAtendidos = 0;
        int sumaTamFila = 0;
        int maxTamFila = 0;
        int tiempoMaxEspera = 0;

        // Simulación de 7 horas = 420 minutos
        for (int minuto = 1; minuto <= 420; minuto++) {
            System.out.println("\n Minuto " + minuto);

            // 1️⃣ Llega un cliente con probabilidad del 80%
            if (random.nextInt(100) < 80) {
                Cliente nuevo = new Cliente(minuto);
                fila.insertar(nuevo);
                System.out.println("Cliente " + nuevo.getId() + " llegó (esperando desde el minuto " + minuto + ")");
            }

            // Se revisa si se debe abrir la cuarta caja
            if (!cuartaCajaAbierta && fila.getTamano() > 20) {
                cuartaCajaAbierta = true;
                minutoAperturaCuarta = minuto;
                System.out.println("Se abrió la 4ª caja en el minuto " + minuto + " por alta demanda.");
            }

            // Atender clientes en cada caja activa
            int cajasActivas = cuartaCajaAbierta ? 4 : 3;
            for (int i = 0; i < cajasActivas; i++) {
                if (tiempoCaja[i] > 0) {
                    tiempoCaja[i]--; // sigue atendiendo al cliente actual
                } else {
                    // Si la caja está libre y hay clientes esperando
                    if (!fila.colaVacia()) {
                        Cliente atendido = fila.quitar();
                        int tiempoEspera = minuto - atendido.getMinutoLlegada();
                        tiempoMaxEspera = Math.max(tiempoMaxEspera, tiempoEspera);

                        // Tiempo de servicio aleatorio (3 a 6 min)
                        tiempoCaja[i] = random.nextInt(4) + 3;
                        totalAtendidos++;

                        System.out.println("Caja " + (i + 1) + " atendió al cliente " + atendido.getId()
                                + " (esperó " + tiempoEspera + " min, atención de " + tiempoCaja[i] + " min)");
                    }
                }
            }

            // Recolectar estadisticas de la fila
            int tamFila = fila.getTamano();
            sumaTamFila += tamFila;
            if (tamFila > maxTamFila) maxTamFila = tamFila;

            System.out.println("Tamaño actual de la fila: " + tamFila);
        }

        // Mostrar estadisticas
        System.out.println("\n----------------------------");
        System.out.println("FIN DE LA SIMULACIÓN");
        System.out.println("------------------------------");
        System.out.println("Total de clientes atendidos: " + totalAtendidos);
        System.out.println("Tamaño medio de la fila: " + (sumaTamFila / 420.0));
        System.out.println("Tamaño máximo de la fila: " + maxTamFila);
        System.out.println("Tiempo máximo de espera: " + tiempoMaxEspera + " minutos");
        if (cuartaCajaAbierta)
            System.out.println("La cuarta caja se abrió en el minuto: " + minutoAperturaCuarta);
        else
            System.out.println("No fue necesario abrir la cuarta caja.");
    }

    // Clase interna para representar a cada cliente
    static class Cliente {
        private static int contador = 1;
        private int id;
        private int minutoLlegada;

        public Cliente(int minutoLlegada) {
            this.id = contador++;
            this.minutoLlegada = minutoLlegada;
        }

        public int getId() {
            return id;
        }

        public int getMinutoLlegada() {
            return minutoLlegada;
        }

        @Override
        public String toString() {
            return "Cliente{" + "id=" + id + ", llegada=" + minutoLlegada + '}';
        }
    }
}