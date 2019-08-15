package byrn;

public class Pila<T> {
    private NodoP<T> inicio;
    private int tamanio;
    
    public void Pila(){
        inicio = null;
        tamanio = 0;
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
    
    
}
class NodoP<T>{
    public NodoP siguiente;
    public T valor;
    
    public NodoP(T v){
        valor = v;
        siguiente = null;
    }
}