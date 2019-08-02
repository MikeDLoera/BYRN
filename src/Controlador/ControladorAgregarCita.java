
package Controlador;

import Modelo.AgregarCitaDAO;
import Vista.AgregarCita;
import Vista.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CST-UTJ
 */
public class ControladorAgregarCita implements ActionListener{
    private AgregarCita jf;
    private AgregarCitaDAO dao;
    private App app;

    public ControladorAgregarCita(AgregarCita jf, AgregarCitaDAO dao,App app) {
        this.jf = jf;
        this.dao = dao;
        this.app=app;
        jf.btnGuardarCita.addActionListener((ActionListener)this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCita==e.getSource()) {
            
            app.setVisible(false);
     
        }
    }
}
