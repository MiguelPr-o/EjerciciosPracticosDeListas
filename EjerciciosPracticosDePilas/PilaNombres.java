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
 * 
 * Ejercicio: Pila de nombres
 * En este programa se inserta una palabra para 
 * que posteriormente se muestre en orden inverso
 */
public class PilaNombres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<>();
        String nombre;
        
        
        while (true) {
            // Se ingresan los elementos hasta que la entrada sea "FIN"
            System.out.print("Ingrese un nombre (FIN para salir): ");
            nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("FIN")) break;
                pila.push(nombre);
            }
        // Se muestran los elementos en orden inverso
            System.out.println("Nombres en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }

    }
}
