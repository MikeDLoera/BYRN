
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class InicioSesionDAO {
    
    public HttpResponse request() throws UnirestException{
        HttpResponse request = PeticionHTTP.post("/login", BYRN.gson.toJson(BYRN.getSesion()),null);
        return request;
    }
}
