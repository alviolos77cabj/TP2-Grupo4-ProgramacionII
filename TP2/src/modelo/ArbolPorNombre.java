package modelo;

import interfaces.IArbol;
import interfaces.INodo;

public class ArbolPorNombre<T> implements IArbol<T> {

    private INodo<T> raiz;

    public ArbolPorNombre() {
        this.raiz = null;
    }

    private int comparar(T a, T b) {
        Persona personaA = (Persona) a;
        Persona personaB = (Persona) b;
        String nombreA = personaA.getNombre();
        String nombreB = personaB.getNombre();
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
        raiz = eliminarRec(raiz, dato);
    }

    private INodo<T> eliminarRec(INodo<T> nodo, T dato) {
        if (nodo == null) return null;

        int comparacion = comparar(dato, nodo.getDato());

        if (comparacion < 0) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), dato));
        } else if (comparacion > 0) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), dato));
        } else {
            // nodo encontrado
            // Caso 1: sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: un hijo derecho
            else if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            // Caso 3: un hijo izquierdo
            else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // Caso 4: dos hijos
            INodo<T> sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato()));
        }

        return nodo;
    }

    private INodo<T> encontrarMinimo(INodo<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
}
