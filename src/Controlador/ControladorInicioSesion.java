
package Controlador;

import Modelo.InicioSesionDAO;
import Modelo.InicioSesionMOD;
import Modelo.PeticionHTTP;
import Vista.Login;
import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
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
            
            try {
                HttpResponse request = PeticionHTTP.post("/login", BYRN.gson.toJson(BYRN.getSesion()));
                System.out.println(request.getStatus());
                System.out.println(request.getBody());
                if (request.getStatus()==200) {
                   //BYRN.setAuth(request.getBody().toString());
                    if (jf.cbxRecuerdame.isSelected()) {
                        //InicioSesionDAO.crearJson(BYRN.getAuthJson(),BYRN.fileAuth());
                    }
                    BYRN.dashboard();
                }
                else {
                      jf.labelExcepcion.setVisible(true);
                }
                
            } catch (UnirestException ex) {
                System.out.println("No hay conexion");
            }
        }
        if (jf.btnCerrar==e.getSource()) {
            BYRN.cerrar();
        }
    }
    
}
