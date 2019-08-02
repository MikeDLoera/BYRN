
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
public class ListadoPropiedadesDAO {
    private AllEstates allEstates;
    
    public ListadoPropiedadesDAO() {
        allEstates();
    }
    
    private void allEstates(){
        try {
            HttpResponse request = null;
            String path = "/estates?email="+BYRN.getSesion().getEmail()+"&password="+BYRN.getSesion().getPassword();
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            this.allEstates = BYRN.gson.fromJson(request.getBody().toString(), AllEstates.class);
            System.out.println(BYRN.getSesion().getEmail());
            System.out.println(BYRN.getSesion().getPassword());
            System.out.println(path);
            System.out.println(token);
            System.out.println(request.getBody().toString());
        } catch (UnirestException ex) {
            Logger.getLogger(ListadoPropiedadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AllEstates getAllEstates() {
        return allEstates;
    }

    public void setAllEstates(AllEstates allEstates) {
        this.allEstates = allEstates;
    }
}
