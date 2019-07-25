
package Controlador;

import Modelo.CitasDAO;
import Vista.Citas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CST-UTJ
 */
public class ControladorCitas implements ActionListener{
    private Citas jf;
    private CitasDAO dao;

    public ControladorCitas(Citas jf, CitasDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAgregarCita.addActionListener((ActionListener)this);
        jf.btnBorarCita.addActionListener((ActionListener)this);
        jf.btnEditarCita.addActionListener((ActionListener)this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAgregarCita==e.getSource()) {
            
        }
        if (jf.btnBorarCita==e.getSource()) {
            
        }
        if (jf.btnEditarCita==e.getSource()) {
            
        }
        
    }
    
}
