/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDeColas;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 */
public class Nodo<T> {
    private T dato;
    private Nodo siguiente;

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public Nodo(T data){
        dato = data;
        siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
    
    
    
}
