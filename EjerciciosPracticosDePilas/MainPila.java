/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDePilas;

/**
 *
 * @author Miguel
 */
public class MainPila {
    public static void main(String[] args) {
        Stack pila = new Stack(10);
        pila.push("fas");
        pila.push(32);
        
        System.out.println(pila.peek());
    }
}
