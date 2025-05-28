package test;

import modelo.Arbol;
import modelo.Persona;

public class TestArbolPersona {
    public static void main(String[] args) {
        Arbol<Persona> arbol = new Arbol<>();

        arbol.insertar(new Persona(47122255, "Diego"));
        arbol.insertar(new Persona(46585461, "Agustina"));
        arbol.insertar(new Persona(47069222, "Gael"));
        arbol.insertar(new Persona(47345528, "Ariana"));
        arbol.insertar(new Persona(47297659, "Micaela"));
        arbol.insertar(new Persona(53232244, "Sofía"));
        arbol.insertar(new Persona(98776996, "Maria"));
        arbol.insertar(new Persona(4323008, "Jose"));
        arbol.insertar(new Persona(41800869, "Federica"));
        arbol.insertar(new Persona(25618203, "Mercedes"));
        arbol.insertar(new Persona(17623499, "Alfredo"));
        arbol.insertar(new Persona(261862932, "Romina"));
        arbol.insertar(new Persona(22706833, "Camila"));
        arbol.insertar(new Persona(33765212, "Norma"));
        arbol.insertar(new Persona(32329983, "Telma"));

        System.out.println("\nRECORRIDO INORDEN:");
        arbol.recorridoInorden();

        System.out.println("\nRECORRIDO PREORDEN:");
        arbol.recorridoPreorden();

        System.out.println("\nRECORRIDO POSTORDEN");
        arbol.recorridoPostorden();

        var nodo = arbol.buscar(new Persona(47297659, "Micaela"));
        if (nodo != null) {
            System.out.println(nodo.getDato());
        } else {
            System.out.println("Persona no encontrada en el árbol.");
        }

    }
}