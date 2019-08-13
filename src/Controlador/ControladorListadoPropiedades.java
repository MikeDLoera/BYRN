
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Modelo.InformacionPropiedadesDAO;
import Modelo.ListadoPropiedadesDAO;
import Modelo.PeticionHTTP;
import Vista.AnadirPropiedad;
import Vista.App;
import Vista.EditarPropiedad;
import Vista.InformacionDePropiedades;
import Vista.ListadoPropiedades;
import byrn.BYRN;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CST-UTJ
 */
public class ControladorListadoPropiedades implements ActionListener{
    private ListadoPropiedades jf;
    private ListadoPropiedadesDAO dao;

    public ControladorListadoPropiedades(ListadoPropiedades jf, ListadoPropiedadesDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAnadirPropiedad.addActionListener((ActionListener)this);
        jf.btnAnterior.addActionListener((ActionListener)this);
        jf.btnEditarPropiedad.addActionListener((ActionListener)this);
        jf.btnEliminarPropiedad.addActionListener((ActionListener)this);
        jf.btnExcel.addActionListener((ActionListener)this);
        jf.btnMasInformacion.addActionListener((ActionListener)this);
        jf.btnSiguente.addActionListener((ActionListener)this);

        jf.btnBusqueda.addActionListener((ActionListener)this);
        jf.ComboBox.addActionListener((ActionListener)this);
        


        try {
            
            tabla(false);
            //getTypes();
        } catch (UnirestException ex) {
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAnadirPropiedad==e.getSource()) {
            AnadirPropiedad ap = new AnadirPropiedad();
            AnadirPropiedadDAO apDAO = new AnadirPropiedadDAO();
            ControladorAnadirPropiedad cap = new ControladorAnadirPropiedad(ap, apDAO);
            BYRN.nuevaVentana("Añadir propiedad", ap);
        }
        if (jf.btnEliminarPropiedad==e.getSource()) {
            String id = getIdSelect();
            if (id!=null) {
                try {
                    String path = "/estates/"+id;
                    PeticionHTTP.delete(path,BYRN.getAuth().getToken());
                    BYRN.notificacion("La propiedad se elimino correctamente");
                    tabla(false);
                } catch (UnirestException ex) {
                    
                }
            }
        }
        if (jf.btnEditarPropiedad==e.getSource()) {
            String id = getIdSelect();
            if (id!=null) {
                EditarPropiedad ed = new EditarPropiedad();
                App app = BYRN.nuevaVentana("Editar Propiedad", ed);
                //EditarPropiedadDAO edDAO = new EditarPropiedadDAO(getState(id));
                //ControladorEditarPropiedad con = new ControladorEditarPropiedad(ed, edDAO,app);
            }else{
                BYRN.notificacion("Seleccione una fila de la tabla");
            }
        }
        if (jf.btnMasInformacion==e.getSource()) {
            String id = getIdSelect();
            if (id!=null) {
                InformacionDePropiedades inf = new InformacionDePropiedades();
                //InformacionPropiedadesDAO infDAO = new InformacionPropiedadesDAO(getState(id));
                App app = BYRN.nuevaVentana("Más Información", inf);
                //ControladorInformacionPropiedades con = new ControladorInformacionPropiedades(inf,infDAO);
            }else{
                BYRN.notificacion("Seleccione una fila de la tabla");
            }
           
        }
        if (jf.btnExcel==e.getSource()) {
            
        }
        if (jf.btnAnterior==e.getSource()) {
            
        }
        if (jf.btnSiguente==e.getSource()) {
            
        }
        if (jf.ComboBox==e.getSource()) {
            if (jf.ComboBox.getSelectedIndex()>0) {
                /*int length = dao.getTypes().length;
                for (int i=0;i<length;i++) {
                    if (dao.getTypes()[i].get("name").equals(jf.ComboBox.getSelectedItem())) {
                        String auxId = dao.getTypes()[i].get("id").toString();
                        int id = Integer.parseInt(auxId.substring(0,auxId.indexOf(".0")));
                        filtrado(id);
                        break;
                    }
                }*/
            }else{
                if (jf.ComboBox.getSelectedIndex()==0) {
                    try {
                        tabla(true);
                    } catch (UnirestException ex) {
                        
                    }
                }else{
                    
                }
            }
        }
        if (jf.btnBusqueda==e.getSource()) {
            
        }
    }
    
    private void tabla(boolean filtrado) throws UnirestException{
        if (!filtrado) {
            dao.getAllEstates();
            dao.allUsers();
        }
        DefaultTableModel modelotabla = new DefaultTableModel(){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
        modelotabla.addColumn("Número de Propiedad");
        modelotabla.addColumn("Nombre");
        modelotabla.addColumn("Dueño");
        modelotabla.addColumn("Tipo");
        jf.tblListadoDePropiedades.setModel(modelotabla);
        Object[] fila = new Object[4];
        /*int length = dao.
        for (int i = 0; i < length; i++) {
            String json = BYRN.gson.toJson(dao.getAllEstate().get("data").get(i));
            HashMap estate = BYRN.gson.fromJson(json, HashMap.class);
            String id = estate.get("id")+"";
            fila[0] = id.substring(0, id.indexOf(".0"));
            fila[1] = estate.get("name");
            fila[2] = dao.getOwnerName(estate.get("owner_id").toString()); 
            fila[3] = BYRN.gson.fromJson(BYRN.gson.toJson(estate.get("estate_type")), HashMap.class).get("name");
            modelotabla.addRow(fila);
        }*/

    }
    
    private void filtrado(int id){
        DefaultTableModel modelotabla = new DefaultTableModel(){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
        modelotabla.addColumn("Número de Propiedad");
        modelotabla.addColumn("Nombre");
        modelotabla.addColumn("Dueño");
        modelotabla.addColumn("Tipo");
        jf.tblListadoDePropiedades.setModel(modelotabla);
        Object[] fila = new Object[4];
        ArrayList<HashMap> filtro = new ArrayList<>();
        /*int length = dao.getAllEstate().get("data").size();
        for (int i=0;i<length;i++) {
            HashMap estate = BYRN.gson.fromJson(BYRN.gson.toJson(dao.getAllEstate().get("data").get(i)), HashMap.class);
            HashMap type = BYRN.gson.fromJson(BYRN.gson.toJson(estate.get("estate_type")), HashMap.class);
            String auxId = type.get("id").toString();
            int estateId = Integer.parseInt(auxId.substring(0,auxId.indexOf(".0")));
            if (id==estateId) {
                filtro.add(estate);
            }
        }*/
        
        int lengthFiltro = filtro.size();
        for (int i = 0; i < lengthFiltro; i++) {
            fila[0] = filtro.get(i).get("id");
            fila[1] = filtro.get(i).get("name");
            fila[2] = dao.getOwnerName(filtro.get(i).get("owner_id").toString());
            fila[3] = BYRN.gson.fromJson(BYRN.gson.toJson(filtro.get(i).get("estate_type")), HashMap.class).get("name");
            modelotabla.addRow(fila);
        }
    }
    
    private String getIdSelect(){
        String numReturn = null;
        if (jf.tblListadoDePropiedades.getSelectedRowCount()==1) {
            int rowSelect = jf.tblListadoDePropiedades.getSelectedRow();
            numReturn = jf.tblListadoDePropiedades.getValueAt(rowSelect, 0)+"";
            
        }
        return numReturn;
    }
    
    /*private HashMap getState(String id){
        HashMap estate = null;
        int length = dao.getAllEstate().get("data").size();
        for (int i = 0; i < length; i++){
            String json = BYRN.gson.toJson(dao.getAllEstate().get("data").get(i));
            HashMap auxEstate = BYRN.gson.fromJson(json, HashMap.class);
            if (auxEstate.get("id").equals(id)) {
                estate = auxEstate;
                break;
            }
        }
        return estate;
    }
    
    private void getTypes() throws UnirestException{
        dao.allTypes();
        int length = dao.getTypes().length;
        String[] types = new String[length+1];
        types[0] = "Todos";
        for (int i = 1; i < length+1; i++) {
            types[i] = (String) dao.getTypes()[i-1].get("name");
        }
        jf.ComboBox.setModel(new javax.swing.DefaultComboBoxModel(types));
    }*/
    
}
