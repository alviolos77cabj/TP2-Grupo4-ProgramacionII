package model;


public class Arbol {
private Nodo raiz;
public Arbol(){
    this.raiz=null;
}
//usaremos funciones recursivas
public void insertar(int dato){//la normal
    raiz=insetarRec(raiz,dato);

}
private Nodo insetarRec(Nodo nodoraiz, int dato){//recursiva
    if (nodoraiz==null){
        return new Nodo(dato);
    }
    if (dato<nodoraiz.getDato()){
        nodoraiz.setIzquierda(insetarRec(nodoraiz.getIzquierda(), dato));
    }else
    if (dato>nodoraiz.getDato()){
        nodoraiz.setDerecha(insetarRec(nodoraiz.getDerecha(), dato));
    }
    return nodoraiz;
}
//buscar un numero
public Nodo buscar(int dato){//normal
    return buscarRec(raiz,dato);
}
private Nodo buscarRec(Nodo nodo, int dato){//recursiva
    if(nodo==null || nodo.getDato()==dato){
        return nodo;
    }
    if (dato <nodo.getDato()){
        return buscarRec(nodo.getIzquierda(),dato);
    }else{
        return buscarRec(nodo.getDerecha(),dato);
    }
}
//recorrido en preorden
//1 me paro en la raiz
//2 voy a la trama izquierda de la raiz
//3 voy a la trama derecha de la raiz
public void recorridoPreOrden(){
    PreOrdenRec(raiz);
}
private void PreOrdenRec(Nodo nodo){
    if(nodo!=null){
        System.out.println(nodo.getDato()+ " - ");
        PreOrdenRec(nodo.getIzquierda());
        PreOrdenRec(nodo.getDerecha());

    }
}
//recorrido en Inorder
//1 voy a la trama izquierda
//2 me paro en la raiz
//3 voy a la trama derecha de la raiz
public void recorridoInorder(){
    InorderRec(raiz);
}
private void InorderRec(Nodo nodo){
    if(nodo!=null){
        InorderRec(nodo.getIzquierda());
        System.out.println(nodo.getDato()+" - ");
        InorderRec(nodo.getDerecha());
    }
// recorrido en postorder
//1 voy a la trama izquierda de la raiz
//2 voy a la trama derecha de la raiz
//3 me paro en la raiz
}
public void recorridopostorder(){
    postOrderRec(raiz);
}
private void postOrderRec(Nodo nodo){
    if (nodo!=null){
        postOrderRec(nodo.getIzquierda());
        postOrderRec(nodo.getDerecha());
        System.out.println(nodo.getDato()+" - ");
    }
}
// eliminar
public void eliminar(int dato){//normal
raiz =  eliminarRec(raiz,dato);
}

private Nodo eliminarRec(Nodo nodo, int dato){//recursiva
    if (nodo==null) return null;
if (dato<nodo.getDato()){
    nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), dato));
}else
if(dato>nodo.getDato()){
    nodo.setDerecha(eliminarRec(nodo.getDerecha(), dato));
}else{
    //1 caso sin hijos
    if (nodo.getDerecha()==null && nodo.getIzquierda()==null){
        return null;
    }
    // 2 caso con un hijo
    if (nodo.getIzquierda()==null){
        return nodo.getDerecha();
    }
    if (nodo.getDerecha()==null){
        return nodo.getIzquierda();
    }
    // 3 caso con dos hijos
    Nodo sucesor=encontrarminimo( nodo.getDerecha());
    nodo.setDato(sucesor.getDato());
    nodo.setDerecha(eliminarRec(nodo.getDerecha(), sucesor.getDato()));

}
return nodo;
}
//encontrar el minimo(nos va servir cuando tengamos que elminar un elemento)
public Nodo encontrarminimo(Nodo nodo){
    while(nodo.getIzquierda()!=null){
        nodo=nodo.getIzquierda();
    }
return nodo;
}
}
 


