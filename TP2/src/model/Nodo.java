package model;

public class Nodo {
    int dato;
    Nodo izquierda;
    Nodo derecha;
    public Nodo(int dato){
        super();
        this.dato=dato;
        this.izquierda=null;
        this.derecha=null;
    }
    public int getDato() {
        return dato;
    }
    public Nodo getDerecha() {
        return derecha;
    }
    public Nodo getIzquierda() {
        return izquierda;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

}
