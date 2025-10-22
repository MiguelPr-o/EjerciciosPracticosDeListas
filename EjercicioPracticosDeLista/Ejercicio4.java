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

class NodoPolinomioCircular {
    double coeficiente;
    int exponente;
    NodoPolinomioCircular siguiente;

    public NodoPolinomioCircular(double coef, int exp) {
        this.coeficiente = coef;
        this.exponente = exp;
        this.siguiente = null;
    }
}

class ListaPolinomioCircular {
    private NodoPolinomioCircular ultimo;

    public ListaPolinomioCircular() {
        ultimo = null;
    }

    public void insertarTermino(double coef, int exp) {
        NodoPolinomioCircular nuevo = new NodoPolinomioCircular(coef, exp);
        if (ultimo == null) {
            // Primer nodo: apunta a sí mismo
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            // Insertar después del último y actualizar referencia
            nuevo.siguiente = ultimo.siguiente; // el primero
            ultimo.siguiente = nuevo;
            ultimo = nuevo; // nuevo se convierte en el último
        }
    }

    public void mostrarPolinomio() {
        if (ultimo == null) {
            System.out.println("El polinomio está vacío.");
            return;
        }

        NodoPolinomioCircular actual = ultimo.siguiente; // empezar en el primero
        System.out.print("P(x) = ");
        boolean primero = true;

        do {
            if (!primero && actual.coeficiente >= 0) System.out.print("+ ");
            if (actual.exponente == 0)
                System.out.print(actual.coeficiente + " ");
            else if (actual.exponente == 1)
                System.out.print(actual.coeficiente + "x ");
            else
                System.out.print(actual.coeficiente + "x^" + actual.exponente + " ");

            actual = actual.siguiente;
            primero = false;
        } while (actual != ultimo.siguiente); // detener al regresar al inicio
        System.out.println();
    }

    public double evaluar(double x) {
        if (ultimo == null) return 0.0;

        double resultado = 0.0;
        NodoPolinomioCircular actual = ultimo.siguiente;
        do {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        return resultado;
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPolinomioCircular polinomio = new ListaPolinomioCircular();

        System.out.println("=== POLINOMIO CON LISTA ENLAZADA CIRCULAR ===");
        System.out.println("Introduce los términos del polinomio (coeficiente y exponente).");
        System.out.println("Ejemplo: 3x^4 -4x^2 + 11 → 3 4, -4 2, 11 0");
        System.out.println("Escribe 'fin' para terminar.\n");

        while (true) {
            System.out.print("Coeficiente (o 'fin'): ");
            String entrada = sc.next();
            if (entrada.equalsIgnoreCase("fin")) break;

            double coef = Double.parseDouble(entrada);
            System.out.print("Exponente: ");
            int exp = sc.nextInt();

            polinomio.insertarTermino(coef, exp);
        }

        System.out.println("\nPolinomio almacenado (lista circular):");
        polinomio.mostrarPolinomio();

        System.out.println("\n=== TABLA DE VALORES ===");
        System.out.printf("%8s | %10s%n", "x", "P(x)");
        System.out.println("---------------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double valor = polinomio.evaluar(x);
            System.out.printf("%8.2f | %10.4f%n", x, valor);
        }

        sc.close();
    }
}
