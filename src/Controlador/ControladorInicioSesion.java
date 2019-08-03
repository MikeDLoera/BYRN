
package Controlador;

import Modelo.InicioSesionDAO;
import Vista.Login;
import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author CST-UTJ
 */
public class ControladorInicioSesion implements ActionListener,KeyListener{
    private InicioSesionDAO dao;
    private Login jf;
   
    
    public ControladorInicioSesion(InicioSesionDAO dao,Login jf){
        this.dao = dao;
        this.jf = jf;
        
        jf.btnAcceder.addActionListener((ActionListener)this);
        jf.btnCerrar.addActionListener((ActionListener)this);
        
        jf.txtPass.addKeyListener((KeyListener)this);
        jf.cbxRecuerdame.addKeyListener((KeyListener)this);
        jf.btnAcceder.addKeyListener((KeyListener)this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAcceder==e.getSource()) {
           login();
        }
        if (jf.btnCerrar==e.getSource()) {
            BYRN.cerrar();
        }
    }
    
    public void login(){
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
        }else {
            jf.labelExcepcion.setText("¡Datos Incorrectos!");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()==jf.txtPass) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                login();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
