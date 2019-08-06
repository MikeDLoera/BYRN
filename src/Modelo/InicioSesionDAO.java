
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CST-UTJ
 */
public class InicioSesionDAO {
    
    public HttpResponse request(){
        try {
            HttpResponse request = PeticionHTTP.post("/login", BYRN.gson.toJson(BYRN.getSesion()),null);
            return request;
        } catch (UnirestException ex) {
            Logger.getLogger(InicioSesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
