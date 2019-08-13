
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.StoreEstate;
import Vista.AnadirPropiedad;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
          
            HashMap storeEstate = new HashMap();
            
            storeEstate.put("name", jf.txtNombre.getText());
            storeEstate.put("description",jf.txtDescripcion.getText());
            storeEstate.put("owner_id", jf.txtDueno.getText());
            storeEstate.put("estate_type",getType((String) jf.cmbTipo.getSelectedItem()));
            
            
             /*StoreEstate st = new StoreEstate();
             
             st.setOwner_id(Integer.parseInt(jf.txtDueno.getText()));
             //st.setEstate_type(Integer.parseInt(jf.txtTipo.getText()));
             st.setAddress(jf.txtDireccion.getText());
             st.setMeter_price(Integer.parseInt(jf.txtMetroPorPrecio.getText()));
             st.setDescription(jf.txtDescripcion.getText());
             
             Gson gson = new Gson();
             
             jf.txtNombre.setText(null);
             jf.txtDueno.setText(null);
             jf.txtTipo.setText(null);
             jf.txtDireccion.setText(null);
             jf.txtDescripcion.setText(null);
             jf.txtMetroPorPrecio.setText(null);
         
             String json = gson.toJson(st);
 
            try {
                dao.setEstate(json);
            } catch (UnirestException ex) {
                
            }*/
        }}
        
        
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
                   id = Integer.parseInt(dao.getNegocio()[i].get("id").toString());
                   break;
               }
           }
           return id;
       }
       
       /*private int gatCity(String name){
           int id = 0;
           
       }*/
    
    
}
