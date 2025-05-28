package modelo;

import interfaces.IArbol;
import interfaces.INodo;

public class ArbolPorNombre<T> implements IArbol<T> {

    private INodo<T> raiz;

    public ArbolPorNombre() {
        this.raiz = null;
    }

    private int comparar(T a, T b) {
        String nombreA = ((Persona) a).getNombre();
        String nombreB = ((Persona) b).getNombre();

        return nombreA.compareToIgnoreCase(nombreB);
    }

    @Override
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private INodo<T> insertarRec(INodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }

        if (comparar(dato, nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), dato));
        } else if (comparar(dato, nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), dato));
        }

        return nodo;
    }

    @Override
    public INodo<T> buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private INodo<T> buscarRec(INodo<T> nodo, T dato) {
        if (nodo == null) return null;

        int comparacion = comparar(dato, nodo.getDato());

        if (comparacion == 0) {
            return nodo;
        } else if (comparacion < 0) {
            return buscarRec(nodo.getIzquierdo(), dato);
        } else {
            return buscarRec(nodo.getDerecho(), dato);
        }
    }

    @Override
    public void recorridoInorden() {
        inordenRec(raiz);
    }

    private void inordenRec(INodo<T> nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            inordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
    }

    private void preordenRec(INodo<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());
            preordenRec(nodo.getIzquierdo());
            preordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
    }

    private void postordenRec(INodo<T> nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());
            postordenRec(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }

    @Override
    public void eliminar(T dato) {
        // no implementado
    }
}
