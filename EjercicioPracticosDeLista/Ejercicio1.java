/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPracticosDeLista;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 */
import java.util.Random;
import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    // 1️⃣ Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo aux = cabeza;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

    public void eliminarMayoresQue(int limite) {
        while (cabeza != null && cabeza.dato > limite) {
            cabeza = cabeza.siguiente;
        }

        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.dato > limite) {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ListaEnlazada lista = new ListaEnlazada();

        System.out.print("¿Cuántos números deseas generar? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = random.nextInt(100) + 1; 
            lista.insertarAlFinal(num);
        }

        System.out.println("\nLista generada:");
        lista.mostrarLista();

        System.out.print("\nIngresa un valor límite: ");
        int limite = sc.nextInt();
        lista.eliminarMayoresQue(limite);

        System.out.println("\nLista después de eliminar mayores a " + limite + ":");
        lista.mostrarLista();

        sc.close();
    }
}
