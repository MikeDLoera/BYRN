
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
     private HashMap[] c;
     
    public CitasDAO() {
    }
    
    public void obtener() throws UnirestException{
        citas = new Pila<>();
        HttpResponse aux = PeticionHTTP.get("/appoiments", BYRN.getAuth().getToken());
        c = BYRN.gson.fromJson(aux.getBody().toString(), HashMap[].class);
        for (HashMap c1 : c) {
            citas.apilar(c1);
        }
    }

    public Pila<HashMap> getCitas() {
        return citas;
    }

    public HashMap[] getC() {
        return c;
    }
    
    public void actualizar(int id, int status){
        System.out.println("id: "+id+"\nstatus: "+status);
        String json = "{\"status\": \""+status+"\"}";
        HttpResponse aux = PeticionHTTP.put("/appoiments/"+id, json, BYRN.getAuth().getToken());
    }
     
}
