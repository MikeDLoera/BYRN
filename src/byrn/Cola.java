package byrn;

public class Cola<T>{
    private NodoC<T> inicio;
    private NodoC<T> termino;
    private NodoC<T> nodoActual;
 
    public Cola(){
        inicio=null;
        termino=null;
        nodoActual = null;
    }
  
    public void insertar(T dato){
        NodoC i=new NodoC(dato);
    
        i.siguiente=null;
    
        if(inicio==null && termino==null){
            inicio=i;
            termino=i;
        }else{
            termino.siguiente=i;
            termino=termino.siguiente;
        }
    }

    public boolean esVacia(){
        return inicio == null;
    }
    
    public T getValor() {
        if (esVacia()) {
            return null;
        }

        if (nodoActual == null) {
            nodoActual = inicio;
            return nodoActual.valor;
        }
        
        nodoActual = nodoActual.siguiente;
        if (nodoActual != null) {
            return nodoActual.valor;
        }else{
            return null;
        }
    }
 
}

class NodoC<T>{
    public NodoC siguiente;
    public T valor;
    
    public NodoC(T v){
        valor = v;
        siguiente=null;
    }
}