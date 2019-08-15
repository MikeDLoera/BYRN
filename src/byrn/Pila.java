package byrn;

public class Pila<T> {
    private NodoP<T> inicio;
    private int tamanio;
    private NodoP<T> nodoActual;
    
    public void Pila(){
        inicio = null;
        tamanio = 0;
        nodoActual = null;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void apilar(T valor){
        NodoP nuevo = new NodoP(valor);
        if (esVacia()) {
            inicio = nuevo;
        }
        else{
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
        tamanio++;
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
class NodoP<T>{
    public NodoP siguiente;
    public T valor;
    
    public NodoP(T v){
        valor = v;
        siguiente = null;
    }
}