/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjerciciosPracticosDePilas;

/**
 *
 * @author Miguel
 */
public interface IStack<T> {
    T peek();
    void push(T element);
    void pop();
    boolean estaVacia();
}

