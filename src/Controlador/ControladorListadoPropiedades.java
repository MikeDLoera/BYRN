
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Modelo.InformacionPropiedadesDAO;
import Modelo.ListadoPropiedadesDAO;
import Vista.AnadirPropiedad;
import Vista.EditarPropiedad;
import Vista.InformacionDePropiedades;
import Vista.ListadoPropiedades;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            EditarPropiedadDAO edDAO = new EditarPropiedadDAO();
            ControladorEditarPropiedad con = new ControladorEditarPropiedad(ed, edDAO);
            BYRN.nuevaVentana("Editar Propiedad", ed);
 
        }
        if (jf.btnMasInformacion==e.getSource()) {
           InformacionDePropiedades inf = new InformacionDePropiedades();
           InformacionPropiedadesDAO infDAO = new InformacionPropiedadesDAO();
           ControladorInformacionPropiedades con = new ControladorInformacionPropiedades(inf,infDAO);
          BYRN.nuevaVentana("Más Información", inf);

           
        }
        if (jf.btnExcel==e.getSource()) {
            
        }
        if (jf.btnAnterior==e.getSource()) {
            
        }
        if (jf.btnSiguente==e.getSource()) {
            
        }
    }
    
}
