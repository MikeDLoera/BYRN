
package Modelo;


import byrn.BYRN;
import byrn.Pila;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class CitasDAO {
     private Pila<HashMap> citas;
     
    public CitasDAO() {
    }
    
    public void obtener() throws UnirestException{
        citas = new Pila<>();
        HttpResponse aux = PeticionHTTP.get("/appoiments", BYRN.getAuth().getToken());
        HashMap[] c = BYRN.gson.fromJson(aux.getBody().toString(), HashMap[].class);
        for (HashMap c1 : c) {
            citas.apilar(c1);
        }
    }

    public Pila<HashMap> getCitas() {
        return citas;
    }
     
}
