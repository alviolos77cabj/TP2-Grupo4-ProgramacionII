package test;

import modelo.ArbolPorDni;
import modelo.Persona;
import interfaces.INodo;

public class TestPersonaPorDni {
    public static void main(String[] args) {
        ArbolPorDni<Persona> arbol = new ArbolPorDni<>();

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

        System.out.println("\nRECORRIDO INORDEN (Por DNI):");
        arbol.recorridoInorden();

        System.out.println("\nRECORRIDO PREORDEN (Por DNI):");
        arbol.recorridoPreorden();

        System.out.println("\nRECORRIDO POSTORDEN (Por DNI)");
        arbol.recorridoPostorden();

        System.out.println("\nBusco a la persona con DNI 47297659:");
        INodo<Persona> nodo = arbol.buscar(new Persona(47297659, "Micaela"));
        if (nodo != null) {
            System.out.println("Encontrado: " + nodo.getDato());
        } else {
            System.out.println("No encontrado");
        }
    }
}
