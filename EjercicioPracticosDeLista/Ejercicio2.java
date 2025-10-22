    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPracticosDeLista;

/**
 *
 * @author Miguel Angel Hernandez Godinez
 */
import java.io.*;
import java.util.*;

class Nodo {
    String palabra;
    Nodo siguiente;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}

// Clase ListaEnlazadaPalabras
class ListaEnlazadaPalabras {
    private Nodo cabeza;

    public ListaEnlazadaPalabras() {
        cabeza = null;
    }

    // 1️⃣ Insertar palabra al final
    public void insertarAlFinal(String palabra) {
        Nodo nuevo = new Nodo(palabra);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo aux = cabeza;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print(aux.palabra + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

    public void eliminarPalabra(String palabra) {
        if (cabeza == null) return;

        while (cabeza != null && cabeza.palabra.equalsIgnoreCase(palabra)) {
            cabeza = cabeza.siguiente;
        }

        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.palabra.equalsIgnoreCase(palabra)) {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    }

    public void escribirEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Nodo aux = cabeza;
            while (aux != null) {
                bw.write(aux.palabra);
                if (aux.siguiente != null)
                    bw.write(" "); // separa con espacio
                aux = aux.siguiente;
            }
            System.out.println("\n✅ Archivo actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazadaPalabras lista = new ListaEnlazadaPalabras();

        System.out.print("Ingresa el nombre del archivo de texto: ");
        String nombreArchivo = sc.nextLine();

        // 1️⃣ Leer archivo y cargar palabras
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+"); 
                for (String p : palabras) {
                    if (!p.isEmpty()) {
                        lista.insertarAlFinal(p);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("\n📜 Palabras cargadas desde el archivo:");
        lista.mostrarLista();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Eliminar palabra");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Guardar y salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la palabra a agregar: ");
                    String nueva = sc.nextLine();
                    lista.insertarAlFinal(nueva);
                    break;
                case 2:
                    System.out.print("Ingresa la palabra a eliminar: ");
                    String eliminar = sc.nextLine();
                    lista.eliminarPalabra(eliminar);
                    break;
                case 3:
                    lista.mostrarLista();
                    break;
                case 4:
                    lista.escribirEnArchivo(nombreArchivo);
                    System.out.println("👋 Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
