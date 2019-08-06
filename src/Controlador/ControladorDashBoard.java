
package Controlador;

import Modelo.CitasDAO;
import Modelo.ListadoPropiedadesDAO;
import Modelo.UsuariosDAO;
import Vista.Citas;
import Vista.DashBoard;
import Vista.ListadoPropiedades;
import Vista.Usuarios;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author CST-UTJ
 */
public class ControladorDashBoard implements ActionListener{
    private DashBoard jf;
    
    public ControladorDashBoard(DashBoard jf){
        this.jf = jf;
        
        jf.dashPropiedades.addActionListener((ActionListener)this);
        jf.dashCitas.addActionListener((ActionListener)this);
        jf.dashUsuarios.addActionListener((ActionListener)this);
        jf.dashCerrarSesion.addActionListener((ActionListener)this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.dashPropiedades==e.getSource()) {
          
            ListadoPropiedades lp = new ListadoPropiedades();
            ListadoPropiedadesDAO propiedadesDAO = new ListadoPropiedadesDAO();
            ControladorListadoPropiedades clp = new ControladorListadoPropiedades(lp, propiedadesDAO);
            BYRN.saltoVentana("Propiedades", lp);
        }
        if (jf.dashCitas==e.getSource()) {
            Citas c = new Citas();
            CitasDAO cdao = new CitasDAO();
            ControladorCitas cc = new ControladorCitas(c, cdao);
            BYRN.saltoVentana("Citas", c);
        }
        if (jf.dashUsuarios==e.getSource()) {
            Usuarios u = new Usuarios();
            UsuariosDAO udao = new UsuariosDAO();
            ControladorUsuarios cusu = new ControladorUsuarios(u,udao);
            BYRN.saltoVentana("Usuarios", u);
        }
        if (jf.dashCerrarSesion==e.getSource()) {
            BYRN.cerrarSesion();
        }
    }
    
}
