
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class AnadirPropiedadDAO {

    
    public void añadir (String json) throws UnirestException{
        HttpResponse aux = PeticionHTTP.post("/estates",json , BYRN.getAuth().getToken());
        System.out.println(aux.getBody());
        
        
  
    }

}
