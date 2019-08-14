
package Modelo;


import byrn.BYRN;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class CitasDAO {
     private HashMap[] cit;

    public HashMap[] getCit() {
        return cit;
    }

    public void setCit(HashMap[] cit) {
        this.cit = cit;
    }
     
    public CitasDAO() {
         try {
             obtener();
         } catch (UnirestException ex) {
         }
    }
    
      private void obtener() throws UnirestException{
         HttpResponse aux = PeticionHTTP.get("/appoiments", BYRN.getAuth().getToken());
         cit = BYRN.gson.fromJson(aux.getBody().toString(), HashMap[].class);
     }
     
}
