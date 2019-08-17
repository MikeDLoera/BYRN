
package Controlador;

import Modelo.InicioSesionDAO;
import Modelo.PeticionHTTP;
import Vista.Login;
import byrn.BYRN;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        start();
    }
    
    private void start(){
        try{
            HttpResponse request = PeticionHTTP.get("/", null);
        }catch(UnirestException ue){
            
        }
        
    }
    
    public void guardarToken(String token){
        File auth = new File(BYRN.fileAuth());
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(auth);
            pw = new PrintWriter(fichero);
            pw.println(token);

        } catch (IOException e) {
            
        }
        if (null != fichero){
            try {
                fichero.close();
            } catch (IOException ex) {
            }
        }
        try {
            auth.createNewFile();
        } catch (IOException ex) {
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAcceder==e.getSource()) {
           this.login();
        }
        if (jf.btnCerrar==e.getSource()) {
            BYRN.cerrar();
        }
    }
    
    public void login(){
        try {
            BYRN.getSesion().setEmail(jf.txtUsuario.getText());
            BYRN.getSesion().setPassword(String.valueOf(jf.txtPass.getPassword()));
            
            HttpResponse request = dao.request();
            
            if (request.getStatus()==200) {
                String json = request.getBody().toString();
                BYRN.setAuth(json);
                if (jf.cbxRecuerdame.isSelected()) {
                    guardarToken(BYRN.getAuth().getToken());
                }
                BYRN.fadeOut();
                BYRN.dashboard();
            }else {
                jf.labelExcepcion.setText("¡Datos Incorrectos!");
            }
        
        } catch (UnirestException ex) {
            System.out.println("No hay conexion :v");
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
