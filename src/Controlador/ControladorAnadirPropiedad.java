
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Vista.AnadirPropiedad;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kong.unirest.UnirestException;
import org.json.JSONArray;

/**
 *
 * @author CST-UTJ
 */
public class ControladorAnadirPropiedad implements ActionListener{
    private AnadirPropiedad jf;
    private AnadirPropiedadDAO dao;

    public ControladorAnadirPropiedad(AnadirPropiedad jf, AnadirPropiedadDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
       jf.btnGuardarNuevaPropiedad.addActionListener((ActionListener)this);
       setComboBoxes();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarNuevaPropiedad==e.getSource()) {
          
            try {
                HashMap<String,Object> storeEstate = new HashMap<>();
                
                storeEstate.put("name", jf.txtNombre.getText());
                storeEstate.put("description",jf.txtDescripcion.getText());
                storeEstate.put("owner_id", jf.txtDueno.getText());
                storeEstate.put("estate_type",getType(jf.cmbTipo.getSelectedItem()+""));
                storeEstate.put("city_id",getCity(jf.cmbCiudad.getSelectedItem()+""));
                storeEstate.put("surface_area", Integer.parseInt(jf.txtMetrosCuadrados.getText()));
                storeEstate.put("meter_price", Integer.parseInt(jf.txtMetroPorPrecio.getText()));
                storeEstate.put("seller_price", Integer.parseInt(jf.txtPrecio.getText()));
                storeEstate.put("address", jf.txtDireccion.getText());
                storeEstate.put("business_type", getNegocio(jf.cmbNegocio.getSelectedItem()+""));
                
                storeEstate.put("commision_or_advertising", false);
                storeEstate.put("latitude", 20.62388600);
                storeEstate.put("longitude", -103.088528);
                // storeEstate.put("images", new JSONArray(new String[0]).toString());
                System.out.println(storeEstate.toString());
                
                
                dao.guardar(storeEstate);
                
            } catch (UnirestException ex) {
                Logger.getLogger(ControladorAnadirPropiedad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException nfe){
                Logger.getLogger(ControladorAnadirPropiedad.class.getName()).log(Level.SEVERE, null, nfe);
                BYRN.notificacion("Datos incorrectos");
            }
        }
    }
        
        
       private void setComboBoxes(){
           ArrayList cities = new ArrayList(dao.getCities().values());
           String[] citiesList = new String[cities.size()];
           for (int i = 0; i < cities.size(); i++) {
               citiesList[i] = cities.get(i).toString();
           }
           jf.cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel(citiesList));
           
           
           String[] typesList = new String[dao.getTypes().length]; 
           for (int i = 0; i < dao.getTypes().length; i++) {
               typesList[i] = dao.getTypes()[i].get("name").toString();
           }
           jf.cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(typesList));
           
           String[] negocioList = new String[dao.getNegocio().length];
           for (int i = 0; i < dao.getNegocio().length; i++) {
               negocioList[i] = dao.getNegocio()[i].get("name").toString();
           }
           jf.cmbNegocio.setModel(new javax.swing.DefaultComboBoxModel(negocioList));
       }
       
       private int getType(String name){
           int nameReturn = 0;
           for (int i = 0; i < dao.getTypes().length; i++) {
               if (name.equals(dao.getTypes()[i].get("name").toString())) {
                   nameReturn = Integer.parseInt(dao.getTypes()[i].get("id").toString().replaceAll(".0", ""));
                   break;
               }
           }
           return nameReturn;
       }
       
       private int getNegocio(String name){
           int id = 0;
           for (int i = 0; i < dao.getNegocio().length; i++) {
               if (name.equals(dao.getNegocio()[i].get("name").toString())) {
                   id = Integer.parseInt(dao.getNegocio()[i].get("id").toString().replaceAll(".0", ""));
                   break;
               }
           }
           return id;
       }
       
       private int getCity(String name){
           String n = dao.getCities().toString().substring(dao.getCities().toString().indexOf("="+name)-3, dao.getCities().toString().indexOf("="+name));
           int id = Integer.parseInt(n);
           return id;
       }
    
    
}
