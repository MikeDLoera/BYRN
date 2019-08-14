
package Controlador;

import Modelo.InformacionPropiedadesDAO;
import Vista.InformacionDePropiedades;
import byrn.BYRN;
import java.util.HashMap;

/**
 *
 * @author Samlml
 */
public class ControladorInformacionPropiedades{
    
    private InformacionDePropiedades jf;
    private InformacionPropiedadesDAO dao;
   

    ControladorInformacionPropiedades(InformacionDePropiedades inf, InformacionPropiedadesDAO infDAO) {
        this.jf=inf;
        this.dao=infDAO;
        mostrar();
    }
    
    private void mostrar(){
        jf.lbDireccion.setText(dao.getEstate().get("address").toString());
        jf.lbCiudad.setText(""+BYRN.gson.fromJson(BYRN.gson.toJson(dao.getEstate().get("city")), HashMap.class).get("name"));
        jf.lbDescripcion.setText(""+dao.getEstate().get("description"));
    }
    
}
