
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
           InformacionDePropiedades inf = new InformacionDePropiedades();
             App app = BYRN.nuevaVentana("Más Información", inf);
           InformacionPropiedadesDAO infDAO = new InformacionPropiedadesDAO();
           ControladorInformacionPropiedades con = new ControladorInformacionPropiedades(inf,infDAO);
        
          
           
        }
        if (jf.btnExcel==e.getSource()) {
            
        }
        if (jf.btnAnterior==e.getSource()) {
            
        }
        if (jf.btnSiguente==e.getSource()) {
            
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
            Logger.getLogger(ControladorListadoPropiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
