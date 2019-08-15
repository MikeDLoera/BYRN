
package byrn;

import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class Ordenamiento {
    public static void quickSort(HashMap[] vector, int izquierda, int derecha) {
    
    HashMap pivote = vector[izquierda];
    
    int i = izquierda;
    int j = derecha;
    
    HashMap auxIntercambio;
    
    while (i < j) {
        
        int iaux = getId(vector[i]);
        while (iaux <= getId(pivote) && i < j) {
            iaux = getId(vector[++i]);
        }
        int auxj = getId(vector[j]);
        while (auxj > getId(pivote)) {
            auxj = getId(vector[--j]);
        }
        
        if (i < j) {
            
            auxIntercambio = vector[i];
            vector[i] = vector[j];
            vector[j] = auxIntercambio;
        }
    }
    
    vector[izquierda] = vector[j];
    vector[j] = pivote;
    
    if (izquierda < j - 1) {
        
        quickSort(vector, izquierda, j - 1);
    }
    if (j + 1 < derecha) {
        
        quickSort(vector, j + 1, derecha);
    }
}
    private static int getId(HashMap o){
        return Integer.parseInt(o.get("id").toString().replaceAll(".0", ""));
    }
}
