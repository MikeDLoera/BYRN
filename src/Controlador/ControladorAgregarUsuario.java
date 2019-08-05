/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgregarUsuarioDAO;
import Vista.AgregarUsuario;
import Vista.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorAgregarUsuario implements ActionListener{
    
    private AgregarUsuario jf;
    private AgregarUsuarioDAO jfDAO;
    private App app;

    public ControladorAgregarUsuario(AgregarUsuario jf, AgregarUsuarioDAO jfDAO, App app) {
        this.jf = jf;
        this.jfDAO = jfDAO;
        this.app = app;
             jf.btnGuardarCambiosUsuario.addActionListener(this);
    }
    


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (jf.btnGuardarCambiosUsuario==ae.getSource()) {
            
        }
    }
    
    
    
    
}
