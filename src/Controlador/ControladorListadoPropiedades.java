
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Modelo.EstateType;
import Modelo.Estates;
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
            getTypes();
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
            int id = getIdSelect();
            if (id>0) {
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
            int id = getIdSelect();
            if (id>0) {
                EditarPropiedad ed = new EditarPropiedad();
                App app = BYRN.nuevaVentana("Editar Propiedad", ed);
                EditarPropiedadDAO edDAO = new EditarPropiedadDAO(getState(id));
                ControladorEditarPropiedad con = new ControladorEditarPropiedad(ed, edDAO,app);
            }else{
                BYRN.notificacion("Seleccione una fila de la tabla");
            }
        }
        if (jf.btnMasInformacion==e.getSource()) {
            int id = getIdSelect();
            if (id>0) {
                InformacionDePropiedades inf = new InformacionDePropiedades();
                InformacionPropiedadesDAO infDAO = new InformacionPropiedadesDAO(getState(id));
                App app = BYRN.nuevaVentana("Más Información", inf);
                ControladorInformacionPropiedades con = new ControladorInformacionPropiedades(inf,infDAO);
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
                for (EstateType allEstatesType : dao.getAllEstatesTypes()) {
                    if (allEstatesType.getName().equals(jf.ComboBox.getSelectedItem())) {
                        filtrado(allEstatesType.getId());
                        break;
                    }
                }
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
            dao.allEstates();
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
        int length = dao.getAllEstate().get("data").size();
        for (int i = 0; i < length; i++) {
            String json = BYRN.gson.toJson(dao.getAllEstate().get("data").get(i));
            HashMap<String, String> estate = BYRN.gson.fromJson(json, HashMap.class);
            fila[0] = estate.get("id");
            fila[1] = estate.get("name");
            //fila[2] = dao.getOwnerName(dao.getAllEstates().getData()[i].getOwner_id());
            //fila[3] = dao.getAllEstates().getData()[i].getEstate_type().getName();
            modelotabla.addRow(fila);
        }

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
        ArrayList<Estates> filtro = new ArrayList();
        for (Estates data : dao.getAllEstates().getData()) {
            if (data.getEstate_type().getId()==id) {
                filtro.add(data);
            }
        }
        
        int length = filtro.size();
        for (int i = 0; i < length; i++) {
            fila[0] = filtro.get(i).getId();
            fila[1] = filtro.get(i).getName();
            fila[2] = dao.getOwnerName(filtro.get(i).getOwner_id());
            fila[3] = filtro.get(i).getEstate_type().getName();
            modelotabla.addRow(fila);
        }
    }
    
    private int getIdSelect(){
        int numReturn;
        if (jf.tblListadoDePropiedades.getSelectedRowCount()==1) {
            int rowSelect = jf.tblListadoDePropiedades.getSelectedRow();
            numReturn = (int) jf.tblListadoDePropiedades.getValueAt(rowSelect, 0);
            
        }else{
            numReturn = -1;
        }
        return numReturn;
    }
    
    private Estates getState(int id){
        Estates estates = new Estates();
        int length = dao.getAllEstates().getData().length;
        for (int i = 0; i < length; i++)     {
            if (dao.getAllEstates().getData()[i].getId()==id) {
                estates = dao.getAllEstates().getData()[i];
                break;
            }
        }
        return estates;
    }
    
    private void getTypes() throws UnirestException{
        dao.allTypes();
        int length = dao.getAllEstatesTypes().length;
        String[] types = new String[length+1];
        types[0] = "Todos";
        for (int i = 1; i < length+1; i++) {
            types[i] = dao.getAllEstatesTypes()[i-1].getName();
        }
        jf.ComboBox.setModel(new javax.swing.DefaultComboBoxModel(types));
    }
    
}
