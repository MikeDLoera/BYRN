
package Modelo;


import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class CitasDAO {
     private Appoiments[] cit;

    public Appoiments[] getCit() {
        return cit;
    }

    public void setCit(Appoiments[] cit) {
        this.cit = cit;
    }
     

    public CitasDAO() {
        
        
        
        
    }
    
      public void obtener() throws UnirestException{
         HttpResponse aux = PeticionHTTP.get("/appoiments", BYRN.getAuth().getToken());
         cit = BYRN.gson.fromJson(aux.getBody().toString(), Appoiments[].class);
     }
     
}
