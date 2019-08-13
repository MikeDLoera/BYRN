
package Modelo;

import java.util.HashMap;

/**
 *
 * @author Samlml
 */
public class EditarPropiedadDAO {
    private HashMap<String , Object> estate;

    public EditarPropiedadDAO(HashMap<String, Object> estate) {
        this.estate = estate;
    }

    public HashMap<String, Object> getEstate() {
        return estate;
    }

    public void setEstate(HashMap<String, Object> estate) {
        this.estate = estate;
    }
    
    
    
}
