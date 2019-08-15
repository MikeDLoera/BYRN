
package Modelo;

import byrn.BYRN;
import byrn.Cola;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class UsuariosDAO {
    
    private Cola<HashMap> usuarios;

    public UsuariosDAO() {
    }
     
    public void obtener() throws UnirestException{
        usuarios = new Cola<>();
        HttpResponse aux = PeticionHTTP.get("/users", BYRN.getAuth().getToken());
        HashMap[] use = BYRN.gson.fromJson(aux.getBody().toString(), HashMap[].class);
        for (HashMap hashMap : use) {
            usuarios.insertar(hashMap);
        }
    }

    public Cola<HashMap> getUsuarios() {
        return usuarios;
    }
}
