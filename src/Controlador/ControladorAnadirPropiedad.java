
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.EditarPropiedadDAO;
import Vista.AnadirPropiedad;
import Vista.EditarPropiedad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        jf.btnInformacionExtra.addActionListener((ActionListener)this);
    }

    ControladorAnadirPropiedad(EditarPropiedad ed, EditarPropiedadDAO edDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarNuevaPropiedad==e.getSource()) {
            
        }
        if (jf.btnInformacionExtra==e.getSource()) {
            
        }
    }
    
}
