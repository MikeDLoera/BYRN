
package Modelo;

import byrn.BYRN;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class AnadirPropiedadDAO {
    private HashMap[] types;
    private HashMap cities;
    private HashMap[] negocio;

    public AnadirPropiedadDAO(HashMap[] types, HashMap cities,HashMap[] negocio) {
        this.types = types;
        this.cities = cities;
        this.negocio = negocio;
    }
    
    public void guardar(HashMap datos) throws UnirestException{
        
    }

    public HashMap[] getTypes() {
        return types;
    }

    public void setTypes(HashMap[] types) {
        this.types = types;
    }

    public HashMap getCities() {
        return cities;
    }

    public void setCities(HashMap cities) {
        this.cities = cities;
    }

    public HashMap[] getNegocio() {
        return negocio;
    }

    public void setNegocio(HashMap[] negocio) {
        this.negocio = negocio;
    }

}
