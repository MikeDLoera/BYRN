
package Modelo;

import byrn.BYRN;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;

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
