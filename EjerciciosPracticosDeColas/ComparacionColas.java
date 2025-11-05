/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDeColas;
import Colas.Cola;

/**
 *
 * @author Miguel
 */
public class ComparacionColas {

    public static void main(String[] args) {
        // Crear dos colas y llenarlas con algunos datos
        Cola<Integer> cola1 = new Cola<>();
        Cola<Integer> cola2 = new Cola<>();

        cola1.insertar(10);
        cola1.insertar(20);
        cola1.insertar(30);

        cola2.insertar(10);
        cola2.insertar(20);
        cola2.insertar(30);

        // Comparar las colas
        boolean iguales = compararColas(cola1, cola2);

        System.out.println("\n¿Las colas son idénticas?: " + iguales);
        System.out.println("Cola 1 tamaño: " + cola1.getTamano());
        System.out.println("Cola 2 tamaño: " + cola2.getTamano());
    }

  
    // Método que compara dos colas del mismo tipo y determina si son idénticas.

    public static <T> boolean compararColas(Cola<T> cola1, Cola<T> cola2) {
        // Si tienen diferente tamaño, no pueden ser iguales
        if (cola1.getTamano() != cola2.getTamano()) {
            return false;
        }

        // Colas auxiliares para no modificar las originales
        Cola<T> aux1 = new Cola<>();
        Cola<T> aux2 = new Cola<>();

        boolean sonIguales = true;

        // Recorremos las colas comparando elemento por elemento
        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            T elemento1 = cola1.quitar();
            T elemento2 = cola2.quitar();

            // Se almacenan los elementos en colas auxiliares para luego restaurar
            aux1.insertar(elemento1);
            aux2.insertar(elemento2);

            if (!elemento1.equals(elemento2)) {
                sonIguales = false;
            }
        }

        // Restaurar las colas originales
        while (!aux1.colaVacia()) {
            cola1.insertar(aux1.quitar());
            cola2.insertar(aux2.quitar());
        }

        return sonIguales;
    }
}
