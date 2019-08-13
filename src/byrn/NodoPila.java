package byrn;

import java.util.HashMap;

/**
 * Clase que define los elementos que debe tener un Nodo de la lista.
 * @author xavier
 */
public class NodoPila {
    // Variable en la cual se va a guardar el valor.
    private HashMap valor;
    // Variable para enlazar los nodos.
    private NodoPila siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void Nodo(){
        this.valor = null;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public HashMap getValor() {
        return valor;
    }

    public void setValor(HashMap valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }   
}