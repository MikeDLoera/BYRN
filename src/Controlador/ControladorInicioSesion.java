
package Controlador;

import Modelo.AuthUser;
import Modelo.InicioSesionDAO;
import Vista.Login;
import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author CST-UTJ
 */
public class ControladorInicioSesion implements ActionListener{
    private InicioSesionDAO dao;
    private Login jf;
   
    
    public ControladorInicioSesion(InicioSesionDAO dao,Login jf){
        this.dao = dao;
        this.jf = jf;
        
        jf.btnAcceder.addActionListener((ActionListener)this);
        jf.btnCerrar.addActionListener((ActionListener)this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAcceder==e.getSource()) {
           
            BYRN.getSesion().setEmail(jf.txtUsuario.getText());
            BYRN.getSesion().setPassword(String.valueOf(jf.txtPass.getPassword()));
            
            HttpResponse request = dao.request();
            if (request.getStatus() == 200) {
                String json = request.getBody().toString();
                BYRN.setAuth(json);
                if (jf.cbxRecuerdame.isSelected()) {
                    dao.crearJson(json,BYRN.fileAuth());
                }
                BYRN.dashboard();
            }
            else {
                jf.labelExcepcion.setVisible(true);
            }
        }
        if (jf.btnCerrar==e.getSource()) {
            BYRN.cerrar();
        }
    }
    
}
