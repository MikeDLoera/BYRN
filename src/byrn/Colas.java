package byrn;

public class Colas<T>{
    //Declaración de atributos
    private NodoC<T> inicio;
    private NodoC<T> termino;
 
    //Constructor sin parametros
    public Colas(){
        inicio=null;
        termino=null;
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
 
}

class NodoC<T>{
    public NodoC siguiente;
    public T valor;
    
    public NodoC(T v){
        valor = v;
        siguiente=null;
    }
}