
package Controlador;

import Modelo.InicioSesionDAO;
import Modelo.InicioSesionMOD;
import Modelo.PeticionHTTP;
import Vista.Login;
import byrn.BYRN;
import com.google.gson.Gson;
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
    private Gson gson = new Gson();
    
    public ControladorInicioSesion(InicioSesionDAO dao,Login jf){
        this.dao = dao;
        this.jf = jf;
        
        jf.btnAcceder.addActionListener((ActionListener)this);
        jf.btnCerrar.addActionListener((ActionListener)this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAcceder==e.getSource()) {
            InicioSesionMOD mod = new InicioSesionMOD();
            mod.setUser(jf.txtUsuario.getText());
            mod.setPass(String.valueOf(jf.txtPass.getPassword()));
            
            try {
                HttpResponse request = PeticionHTTP.post("/login", gson.toJson(mod));
                if (request.getStatus()==200) {
                    //System.out.println(request.getBody());
                    BYRN.setAuth(request.getBody().toString());
                    if (jf.cbxRecuerdame.isSelected()) {
                        InicioSesionDAO.crearJson(BYRN.getAuthJson(),BYRN.fileAuth());
                    }
                    BYRN.dashboard();
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
