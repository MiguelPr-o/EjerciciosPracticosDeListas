/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDePilas;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 * 
 * Ejercicio: Simulación simple de pila
 * Se añaden 4 elementos a la pila para posteriormente eliminar 2 
 * y mostrar los elementos que sobraron en la pila
 */

public class SimulacionSimpleLista {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        
        // Se añaden los elementos a la pila
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        
        // Se eliminan los elementos de la pila
        pila.pop();
        pila.pop();
        System.out.println("Contenido actual: " + pila);
    }
}
