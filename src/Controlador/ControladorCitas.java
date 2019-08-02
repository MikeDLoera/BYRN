
package Controlador;

import Modelo.AgregarCitaDAO;
import Modelo.CitasDAO;
import Modelo.EditarCitaDAO;
import Vista.AgregarCita;
import Vista.Citas;
import Vista.EditarCita;
import byrn.BYRN;
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
            AgregarCita ac = new AgregarCita();
            AgregarCitaDAO acdao = new AgregarCitaDAO();
            ControladorAgregarCita cac = new ControladorAgregarCita(ac, acdao);
            BYRN.nuevaVentana("Agregar cita", ac);
        }
        if (jf.btnBorarCita==e.getSource()) {
            
        }
        if (jf.btnEditarCita==e.getSource()) {
            EditarCita c = new EditarCita();
            EditarCitaDAO cDAO = new EditarCitaDAO();
            ControladorEditarCita cc = new ControladorEditarCita(c, cDAO);
                      BYRN.nuevaVentana("Edición de Citas", c);
            
        }
        
    }
    
}
