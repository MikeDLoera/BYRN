
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    public void crearJson(String json, String authdir){
        File auth = new File(authdir);
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(auth);
            pw = new PrintWriter(fichero);
            pw.println(json);

        } catch (IOException e) {
            
        }
        if (null != fichero){
            try {
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(InicioSesionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            auth.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
