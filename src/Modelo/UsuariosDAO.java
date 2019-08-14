
package Modelo;

import byrn.BYRN;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class UsuariosDAO {
    
     private HashMap<String,Object>[] use;

    public HashMap<String, Object>[] getUse() {
        return use;
    }

    public void setUse(HashMap<String, Object>[] use) {
        this.use = use;
    }

    public UsuariosDAO() {
      
    }
     
     public void obtener() throws UnirestException{
         HttpResponse aux = PeticionHTTP.get("/users", BYRN.getAuth().getToken());
         use = BYRN.gson.fromJson(aux.getBody().toString(), HashMap[].class);
     }
    
    
    
    
    
    
}
