
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Modelo.StoreEstate;
import Vista.AnadirPropiedad;
import Vista.EditarPropiedad;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CST-UTJ
 */
public class ControladorAnadirPropiedad implements ActionListener{
    private AnadirPropiedad jf;
    private AnadirPropiedadDAO dao;
    private StoreEstate s;

    public ControladorAnadirPropiedad(AnadirPropiedad jf, AnadirPropiedadDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnGuardarNuevaPropiedad.addActionListener((ActionListener)this);
       
    }

    ControladorAnadirPropiedad(EditarPropiedad ed, EditarPropiedadDAO edDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarNuevaPropiedad==e.getSource()) {
          
  
             StoreEstate st = new StoreEstate();
             st.setName(jf.txtNombre.getText());
             st.setOwner_id(Integer.parseInt(jf.txtDueño.getText()));
             st.setEstate_type(Integer.parseInt(jf.txtTipo.getText()));
             st.setAddress(jf.txtDireccion.getText());
             st.setMeter_price(Integer.parseInt(jf.txtMetroPorPrecio.getText()));
             st.setDescription(jf.txtDescripcion.getText());
             
             
             Gson gson = new Gson();
             

             jf.txtNombre.setText(null);
             jf.txtDueño.setText(null);
             jf.txtTipo.setText(null);
             jf.txtDireccion.setText(null);
             jf.txtDescripcion.setText(null);
             jf.txtMetroPorPrecio.setText(null);
         
             
             String JSON = gson.toJson(st);
 
            try {
                dao.añadir(JSON);
            } catch (UnirestException ex) {
                Logger.getLogger(ControladorAnadirPropiedad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
        
        
       
    

   

    
    
}
