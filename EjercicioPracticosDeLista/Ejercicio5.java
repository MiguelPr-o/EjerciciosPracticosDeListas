/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPracticosDeLista;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 */

import java.util.Scanner;

class NodoDoble {
    char dato;
    NodoDoble anterior;
    NodoDoble siguiente;

    public NodoDoble(char dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

class ListaDoble {
    private NodoDoble cabeza;

    public void insertarFinal(char c) {
        NodoDoble nuevo = new NodoDoble(c);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoDoble actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }

    public void mostrar() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void mostrarInverso() {
        if (cabeza == null) return;

        NodoDoble actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    public void ordenar() {
        if (cabeza == null) return;

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            NodoDoble actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    char temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    huboIntercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (huboIntercambio);
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

        System.out.println("Ingrese una cadena de texto:");
        String cadena = sc.nextLine();

        for (char c : cadena.toCharArray()) {
            lista.insertarFinal(c);
        }

        System.out.println("\nLista original:");
        lista.mostrar();

        lista.ordenar();

        System.out.println("\nLista ordenada alfabéticamente:");
        lista.mostrar();

        System.out.println("\nLista en orden inverso:");
        lista.mostrarInverso();
    }
}
