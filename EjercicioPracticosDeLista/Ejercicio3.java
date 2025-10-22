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

class NodoPolinomio {
    double coeficiente;
    int exponente;
    NodoPolinomio siguiente;

    public NodoPolinomio(double coef, int exp) {
        this.coeficiente = coef;
        this.exponente = exp;
        this.siguiente = null;
    }
}

class ListaPolinomio {
    private NodoPolinomio cabeza;

    public ListaPolinomio() {
        cabeza = null;
    }

    public void insertarTermino(double coef, int exp) {
        NodoPolinomio nuevo = new NodoPolinomio(coef, exp);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPolinomio aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void mostrarPolinomio() {
        if (cabeza == null) {
            System.out.println("El polinomio está vacío.");
            return;
        }

        NodoPolinomio aux = cabeza;
        System.out.print("P(x) = ");
        boolean primero = true;

        while (aux != null) {
            if (!primero && aux.coeficiente >= 0) System.out.print("+ ");
            if (aux.exponente == 0)
                System.out.print(aux.coeficiente + " ");
            else if (aux.exponente == 1)
                System.out.print(aux.coeficiente + "x ");
            else
                System.out.print(aux.coeficiente + "x^" + aux.exponente + " ");

            primero = false;
            aux = aux.siguiente;
        }
        System.out.println();
    }

    public double evaluar(double x) {
        double resultado = 0.0;
        NodoPolinomio aux = cabeza;
        while (aux != null) {
            resultado += aux.coeficiente * Math.pow(x, aux.exponente);
            aux = aux.siguiente;
        }
        return resultado;
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPolinomio polinomio = new ListaPolinomio();

        System.out.println("=== REPRESENTACIÓN DE POLINOMIO CON LISTA ENLAZADA ===");
        System.out.println("Introduce los términos del polinomio (coeficiente y exponente).");
        System.out.println("Ejemplo: para 3x^4 -4x^2 + 11 → ingresa: 3 4, -4 2, 11 0");
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

        System.out.println("\nPolinomio ingresado:");
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

