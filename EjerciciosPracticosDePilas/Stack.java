/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDePilas;

/**
 *
 * @author Miguel
 */
public class Stack<T> implements IStack<T>{
    private T[] elements;
    private int top;
    
    public Stack(){
        elements = (T[])new Object[30];
    }
    
    public Stack(int size){
        elements = (T[])new Object[size];
    }
    
    @Override
    public void push(T element) {
        if(top < elements.length - 1){
            top++;
            elements[top] = element;
        }else {
            System.out.println("Esta llena");
        }
    }

    @Override
    public void pop() {
        if(estaVacia()){
            System.out.println("Pila Vacia");
        }else {
            elements[top] = null;
            top--;
        }
    }

    @Override
    public T peek() {
        if (estaVacia()) {
            System.out.println("Pila Vacía");
        }
            System.out.println("Conociendo el último de la pila");
            return (T) elements[top - 1];
    }

    public boolean estaVacia() {
        if(elements.length == 0) {
            return true;
        }else {
            return false;
        }
    }
}
