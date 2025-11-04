/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDePilas;
import java.util.Stack;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 * 
 * Ejercicio: Verificar si una pila está vacía 
 * Esta clase realiza un ejercicio para saber
 * si una pila esta vacía
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        pila.push(1);
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
    }
}
