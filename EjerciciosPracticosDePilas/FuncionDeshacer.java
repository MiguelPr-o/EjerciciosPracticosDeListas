/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDePilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 * Ejercicio: Simular función Deshacer (Undo)
 * Programa que simula la función de deshacer
 * 
 */
public class FuncionDeshacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> acciones = new Stack<>();
        
        // Se ejecuta el while hasta que se escriba FIN
        while (true) {
            System.out.print("Acción (UNDO/FIN): ");
            String act = sc.nextLine();
            if (act.equalsIgnoreCase("FIN")) break;
            // Si se escribe UNDO se elimina el último elemento de la pila
            if (act.equalsIgnoreCase("UNDO")) {
            if (!acciones.isEmpty()) acciones.pop();
            } else {
                acciones.push(act);
            }
                System.out.println("Actual: " + acciones);
            }
    }
}
