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
 * Ejercicio: Invertir una palabra
 * Programa que invierte una pila utilizando una pila
 */


public class InvertirPalabra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();
        // Se crea la pila en donde se guardará los caracteres de
        // la palabra
        Stack<Character> pila = new Stack<>();
        // Recorre cada caracter de la palabra y lo agrega a la pila
        for (char c : palabra.toCharArray()) pila.push(c);
        // Invierte la palabra invertida desapilando la pila
        System.out.print("Invertida: ");
        while (!pila.isEmpty()) System.out.print(pila.pop());
    }
}
