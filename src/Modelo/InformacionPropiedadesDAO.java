
package Modelo;

import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class InformacionPropiedadesDAO {
    private HashMap<String , Object> estate;

    public InformacionPropiedadesDAO(HashMap<String, Object> estate) {
        this.estate = estate;
    }

    public HashMap<String, Object> getEstate() {
        return estate;
    }

    public void setEstate(HashMap<String, Object> estate) {
        this.estate = estate;
    }
}
