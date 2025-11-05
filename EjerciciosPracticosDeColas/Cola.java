/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosPracticosDeColas;

/**
 *
 * @author Miguel
 */
public class Cola<T> {
    private Colas.Nodo<T> cabeza;
    private Colas.Nodo<T> cola;
    private int tamano;
    
    public Cola(){
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public Colas.Nodo<T> getCabeza() {
        return cabeza;
    }

    public Colas.Nodo<T> getCola() {
        return cola;
    }

    public int getTamaño() {
        return tamano;
    }

    public void setCabeza(Colas.Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Colas.Nodo<T> cola) {
        this.cola = cola;
    }

    public void setTamaño(int tamaño) {
        this.tamano = tamaño;
    }
    
      @Override
    public String toString() {
        return "Cola{" + "cabeza=" + cabeza + ", cola=" + cola + ", tama\u00f1o=" + tamano  + '}';
    }
    
    public boolean colaVacia(){
        return cabeza == null;
    }
    
    public void insertar(T elemento){
        Colas.Nodo<T> nuevoNodo = new Colas.Nodo<T>(elemento);
        if(colaVacia()){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // El nodo actual que era el 'final' ahora apunta al nuevo nodo 
            this.cola.setSiguiente(nuevoNodo);
            // El puntero 'cola' (final) se mueve al nuevo nodo
            this.cola = nuevoNodo;
        }
        tamano++;
        System.out.println("-> Insertado: " + elemento);
    }
    
    public T quitar(){
        if(colaVacia()){
            System.out.println("Error: La cola está vacía");
        }
        
        T datoQuitado = this.cabeza.getDato();
        this.cabeza = this.cabeza.getSiguiente();
        
        if(this.cabeza == null){
            this.cola = null;
        }
        
        tamano--;
        return datoQuitado;
    }
    
    /* Operación: Frente (peek)
    Devuelve el elemento del frente sin retirarlo
    */
    
    public T frente(){
        if(colaVacia()){
            System.out.println("Error: La cola está vacía");
        }
        return this.cabeza.getDato();
    }
    
    // Método auxiliar
    public int getTamano(){
        return tamano;
    }
}
