package test;

import modelo.ArbolPorNombre; 
import modelo.Persona;
import interfaces.INodo; 

public class TestPersonaPorNombre {
    public static void main(String[] args) {
        ArbolPorNombre<Persona> arbolPorNombre = new ArbolPorNombre<>();

        arbolPorNombre.insertar(new Persona(47122255, "Diego"));
        arbolPorNombre.insertar(new Persona(46585461, "Agustina"));
        arbolPorNombre.insertar(new Persona(47069222, "Gael"));
        arbolPorNombre.insertar(new Persona(47345528, "Ariana"));
        arbolPorNombre.insertar(new Persona(47297659, "Micaela"));
        arbolPorNombre.insertar(new Persona(53232244, "Sofía"));
        arbolPorNombre.insertar(new Persona(98776996, "Maria"));
        arbolPorNombre.insertar(new Persona(4323008, "Jose"));
        arbolPorNombre.insertar(new Persona(41800869, "Federica"));
        arbolPorNombre.insertar(new Persona(25618203, "Mercedes"));
        arbolPorNombre.insertar(new Persona(17623499, "Alfredo"));
        arbolPorNombre.insertar(new Persona(261862932, "Romina"));
        arbolPorNombre.insertar(new Persona(22706833, "Camila"));
        arbolPorNombre.insertar(new Persona(33765212, "Norma"));
        arbolPorNombre.insertar(new Persona(32329983, "Telma"));
        arbolPorNombre.insertar(new Persona(10000000, "ana")); 
        arbolPorNombre.insertar(new Persona(10000001, "ANA")); 
        arbolPorNombre.insertar(new Persona(10000002, "diego")); 

        System.out.println("\n--- RECORRIDO INORDEN (Ordenado Alfabéticamente por Nombre) ---");
        arbolPorNombre.recorridoInorden();

        System.out.println("\n--- RECORRIDO PREORDEN (Ordenado por Nombre) ---");
        arbolPorNombre.recorridoPreorden();

        System.out.println("\n--- RECORRIDO POSTORDEN (Ordenado por Nombre) ---");
        arbolPorNombre.recorridoPostorden();

        System.out.println("\n--- Buscando personas por nombre ---");

        Persona personaBuscada1 = new Persona(0, "Micaela"); 
        INodo<Persona> nodoEncontrado1 = arbolPorNombre.buscar(personaBuscada1);
        if (nodoEncontrado1 != null) {
            System.out.println("Encontrado: " + nodoEncontrado1.getDato());
        } else {
            System.out.println("No se encontró a Micaela.");
        }

        Persona personaBuscada2 = new Persona(0, "ana"); 
        INodo<Persona> nodoEncontrado2 = arbolPorNombre.buscar(personaBuscada2);
        if (nodoEncontrado2 != null) {
            System.out.println("Encontrado: " + nodoEncontrado2.getDato());
        } else {
            System.out.println("No se encontró a ana.");
        }

        Persona personaBuscada3 = new Persona(0, "Jose"); 
        INodo<Persona> nodoEncontrado3 = arbolPorNombre.buscar(personaBuscada3);
        if (nodoEncontrado3 != null) {
            System.out.println("Encontrado: " + nodoEncontrado3.getDato());
        } else {
            System.out.println("No se encontró a Jose.");
        }

        Persona personaNoExistente = new Persona(0, "Lautaro"); 
        INodo<Persona> nodoEncontrado4 = arbolPorNombre.buscar(personaNoExistente);
        if (nodoEncontrado4 != null) {
            System.out.println("Encontrado: " + nodoEncontrado4.getDato());
        } else {
            System.out.println("No se encontró a Lautaro.");
        }

        //implementamos el eliminar:
        System.out.println("\n--- Eliminando a 'Jose' ---");
        arbolPorNombre.eliminar(new Persona(0, "Jose"));
        arbolPorNombre.recorridoInorden();

        System.out.println("\n--- Eliminando a 'Romina' ---");
        arbolPorNombre.eliminar(new Persona(0, "Romina"));
        arbolPorNombre.recorridoInorden();

        System.out.println("\n--- Eliminando a 'Diego' ---");
        arbolPorNombre.eliminar(new Persona(0, "Diego"));
        arbolPorNombre.recorridoInorden();

        System.out.println("\n--- Eliminando a 'ANA' ---");
        arbolPorNombre.eliminar(new Persona(0, "ANA"));
        arbolPorNombre.recorridoInorden();
    }
}
