
package Controlador;

import Modelo.EditarPropiedadDAO;
import Vista.App;
import Vista.EditarPropiedad;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Samlml
 */
public class ControladorEditarPropiedad implements ActionListener{

    
    private final EditarPropiedad jf;
    private final EditarPropiedadDAO dao;
    private final App app;
    
    public ControladorEditarPropiedad ( EditarPropiedad jf,  EditarPropiedadDAO dao,App app){
        this.jf=jf;
        this.dao=dao;
        this.app=app;
        jf.btnGuardarCambiosDeEdicionDePropiedades.addActionListener((ActionListener)this);
        mostrar();
        setComboBoxes();
        getCity(jf.cmbCiudad.getSelectedItem()+"");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCambiosDeEdicionDePropiedades==e.getSource()) {
            //HttpRequest request = PeticionHTTP.
            
            app.setVisible(false);
        }
    }
    
    private void mostrar(){
        jf.txtNumero.setText(dao.getEstate().get("id").toString().replaceAll(".0", ""));
        jf.txtNombre.setText(dao.getEstate().get("name").toString());
        jf.txtDueno.setText(dao.getEstate().get("owner_id").toString().replaceAll(".0", ""));
        jf.txtDireccion.setText(dao.getEstate().get("address").toString());
        jf.txtDescripcion.setText(dao.getEstate().get("description").toString());
        jf.txtArea.setText(dao.getEstate().get("surface_area").toString().replaceAll(".0", ""));
        
    }
    
    private void setComboBoxes(){
           ArrayList cities = new ArrayList(dao.getCities().values());
           String[] citiesList = new String[cities.size()];
           int selectCity = 0;
           HashMap city = BYRN.gson.fromJson(BYRN.gson.toJson(dao.getEstate().get("city")), HashMap.class);
           for (int i = 0; i < cities.size(); i++) {
               citiesList[i] = cities.get(i).toString();
               
               if (cities.get(i).equals(city.get("name"))) {
                   selectCity = i;
               }
           }
           jf.cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel(citiesList));
           jf.cmbCiudad.setSelectedIndex(selectCity);
           
           String[] typesList = new String[dao.getTypes().length]; 
           int SelectType = 0;
           HashMap types = BYRN.gson.fromJson(BYRN.gson.toJson(dao.getEstate().get("estate_type")), HashMap.class);
           for (int i = 0; i < dao.getTypes().length; i++) {
               typesList[i] = dao.getTypes()[i].get("name").toString();
               
               if (types.get("name").equals(dao.getTypes()[i].get("name"))) {
                   SelectType = i;
               }
           }
           jf.cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(typesList));
           jf.cmbTipo.setSelectedIndex(SelectType);
           
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
       
       
       private int getCity(String name){
           //System.out.println(dao.getCities());
           String n = dao.getCities().toString().substring(dao.getCities().toString().indexOf("="+name)-3, dao.getCities().toString().indexOf("="+name)).replaceAll(" ", "");
           int id = Integer.parseInt(n);
           return id;
       }
    
    
}
