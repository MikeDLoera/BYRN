
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Vista.AnadirPropiedad;
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
        jf.btnAnadirCita.addActionListener((ActionListener)this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarNuevaPropiedad==e.getSource()) {
            
        }
        if (jf.btnAnadirCita==e.getSource()) {
            
        }
    }

    
}
