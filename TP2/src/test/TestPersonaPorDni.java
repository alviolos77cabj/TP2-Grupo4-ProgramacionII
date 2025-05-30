package test;

import modelo.ArbolPorDni;
import modelo.Persona;
import interfaces.INodo;

public class TestPersonaPorDni {
    public static void main(String[] args) {
        ArbolPorDni<Persona> arbolPorDni = new ArbolPorDni<>();

        arbolPorDni.insertar(new Persona(47122255, "Diego"));
        arbolPorDni.insertar(new Persona(46585461, "Agustina"));
        arbolPorDni.insertar(new Persona(47069222, "Gael"));
        arbolPorDni.insertar(new Persona(47345528, "Ariana"));
        arbolPorDni.insertar(new Persona(47297659, "Micaela"));
        arbolPorDni.insertar(new Persona(53232244, "Sofía"));
        arbolPorDni.insertar(new Persona(98776996, "Maria"));
        arbolPorDni.insertar(new Persona(4323008, "Jose"));
        arbolPorDni.insertar(new Persona(41800869, "Federica"));
        arbolPorDni.insertar(new Persona(25618203, "Mercedes"));
        arbolPorDni.insertar(new Persona(17623499, "Alfredo"));
        arbolPorDni.insertar(new Persona(261862932, "Romina"));
        arbolPorDni.insertar(new Persona(22706833, "Camila"));
        arbolPorDni.insertar(new Persona(33765212, "Norma"));
        arbolPorDni.insertar(new Persona(32329983, "Telma"));

        System.out.println("\nRECORRIDO INORDEN (Por DNI):");
        arbolPorDni.recorridoInorden();

        System.out.println("\nRECORRIDO PREORDEN (Por DNI):");
        arbolPorDni.recorridoPreorden();

        System.out.println("\nRECORRIDO POSTORDEN (Por DNI)");
        arbolPorDni.recorridoPostorden();

        System.out.println("\nBusco a la persona con DNI 47297659:");
        INodo<Persona> nodo = arbolPorDni.buscar(new Persona(47297659, "Micaela"));
        if (nodo != null) {
            System.out.println("Encontrado: " + nodo.getDato());
        } else {
            System.out.println("No encontrado");
        }
        
        System.out.println("\nElimino a 'Jose':");
        arbolPorDni.eliminar(new Persona(4323008, "Jose"));
        arbolPorDni.recorridoInorden();
        
        System.out.println("\nElimino a 'Romina':");
        arbolPorDni.eliminar(new Persona(261862932, "Romina"));
        arbolPorDni.recorridoInorden();
        
        System.out.println("\nElimino a 'Diego':");
        arbolPorDni.eliminar(new Persona(47122255, "Diego"));
        arbolPorDni.recorridoInorden();
    }
}
