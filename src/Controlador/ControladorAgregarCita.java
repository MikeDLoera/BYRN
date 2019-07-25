
package Controlador;

import Modelo.AgregarCitaDAO;
import Vista.AgregarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CST-UTJ
 */
public class ControladorAgregarCita implements ActionListener{
    private AgregarCita jf;
    private AgregarCitaDAO dao;

    public ControladorAgregarCita(AgregarCita jf, AgregarCitaDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnGuardarCita.addActionListener((ActionListener)this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCita==e.getSource()) {
            
        }
    }
}
