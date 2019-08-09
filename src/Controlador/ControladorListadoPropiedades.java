
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Modelo.Estates;
import Modelo.InformacionPropiedadesDAO;
import Modelo.ListadoPropiedadesDAO;
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
        
        this.tabla();
        
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
            
        }
        if (jf.btnEditarPropiedad==e.getSource()) {
            
            EditarPropiedad ed = new EditarPropiedad();
            App app = BYRN.nuevaVentana("Editar Propiedad", ed);
            EditarPropiedadDAO edDAO = new EditarPropiedadDAO();
            ControladorEditarPropiedad con = new ControladorEditarPropiedad(ed, edDAO,app);
      
        }
        if (jf.btnMasInformacion==e.getSource()) {
            int id = getIdSelect();
            if (id>=0) {
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
            if (jf.ComboBox.getSelectedIndex()==0) {//todo
                int[] id = {1,2,3,4,5,6,7,8};
                filtrado(id);
            }
            if (jf.ComboBox.getSelectedIndex()==1) {//casa
                int[] id = {3,6,7};
                filtrado(id);
            }
            if (jf.ComboBox.getSelectedIndex()==2) {//terreno
                int[] id = {1,2};
                filtrado(id);
            }
        }
        if (jf.btnBusqueda==e.getSource()) {
            
        }
    }
    
    private void tabla(){
        try {
            dao.allEstates();
            dao.allUsers();
            DefaultTableModel modelotabla = new DefaultTableModel();
            modelotabla.addColumn("Número de Propiedad");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Dueño");
            modelotabla.addColumn("Tipo");
            jf.tblListadoDePropiedades.setModel(modelotabla);
            Object[] fila = new Object[4];
            int length = dao.getAllEstates().getData().length;
            for (int i = 0; i < length; i++) {
                fila[0] = dao.getAllEstates().getData()[i].getId();
                fila[1] = dao.getAllEstates().getData()[i].getName();
                fila[2] = dao.getOwnerName(dao.getAllEstates().getData()[i].getOwner_id());
                fila[3] = dao.getAllEstates().getData()[i].getEstate_type().getName();
                modelotabla.addRow(fila);
            }
        } catch (UnirestException ex) {
            System.out.println("Hola");
        }
    }
    
    private void filtrado(int[] id){
        DefaultTableModel modelotabla = new DefaultTableModel();
        modelotabla.addColumn("Número de Propiedad");
        modelotabla.addColumn("Nombre");
        modelotabla.addColumn("Dueño");
        modelotabla.addColumn("Tipo");
        jf.tblListadoDePropiedades.setModel(modelotabla);
        Object[] fila = new Object[4];
        ArrayList<Estates> filtro = new ArrayList();
        for (Estates data : dao.getAllEstates().getData()) {
            for (int i = 0; i < id.length; i++) {
                if (data.getEstate_type().getId()==id[i]) {
                    filtro.add(data);
                }
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
            if (rowSelect>=0) {
                numReturn = rowSelect;
            }else{
                numReturn = (int) jf.tblListadoDePropiedades.getValueAt(rowSelect, 0);
            }
        }else{
            numReturn = -1;
        }
        return numReturn;
    }
    
    private Estates getState(int id){
        Estates estates = null;
        int length = dao.getAllEstates().getData().length;
        for (int i = 0; i < length; i++) {
            if (dao.getAllEstates().getData()[i].getId()==id) {
                estates = dao.getAllEstates().getData()[i];
                break;
            }
        }
        return estates;
    }
    
}
