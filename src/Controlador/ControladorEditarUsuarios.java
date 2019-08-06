/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EditarUsuariosDAO;
import Vista.App;
import Vista.EditarUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorEditarUsuarios  implements ActionListener{
    private EditarUsuarios jf;
    private EditarUsuariosDAO jfDAO;
    private App app;

    public ControladorEditarUsuarios(EditarUsuarios jf, EditarUsuariosDAO jfDAO, App app) {
        this.jf = jf;
        this.jfDAO = jfDAO;
        this.app = app;
    }

   

  

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( jf.btnGuardarCambiosEdicion==ae.getSource()) {
            
            
        }
    }
    
    
}
