
package Modelo;

import java.util.HashMap;
/**
 *
 * @author Samlml
 */
public class EditarPropiedadDAO {
    private HashMap estate;
    private HashMap cities;
    private HashMap[] types;

    public EditarPropiedadDAO(HashMap estate, HashMap cities, HashMap[] types) {
        this.estate = estate;
        this.cities = cities;
        this.types = types;
    }
    
    public HashMap getEstate() {
        return estate;
    }

    public void setEstate(HashMap estate) {
        this.estate = estate;
    }

    public HashMap getCities() {
        return cities;
    }

    public void setCities(HashMap cities) {
        this.cities = cities;
    }
    
}
