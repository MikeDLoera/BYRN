
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
    
    public static int busquedaBinaria(HashMap vector[], int dato){
        int n = vector.length;
        int centro,inf=0,sup=n-1;
        while(inf<=sup){
            centro=(sup+inf)/2;
            if(getId(vector[centro])==dato) return centro;
            else if(dato < getId(vector [centro]) ){
                sup=centro-1;
            }else{
                inf=centro+1;
            }
        }
        return -1;
    }
    
    private static int getId(HashMap map){
        String idAux = map.get("id").toString();
        return Integer.parseInt(idAux.substring(0,idAux.indexOf('.')));
    }
}
