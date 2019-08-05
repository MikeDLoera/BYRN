/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EditarUsuariosDAO;
import Vista.EditarUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorEditarUsuarios  implements ActionListener{
    private EditarUsuarios jf;
    private EditarUsuariosDAO ed;

    public ControladorEditarUsuarios(EditarUsuarios jf, EditarUsuariosDAO ed) {
        this.jf = jf;
        this.ed = ed;
        jf.btnGuardarCambiosEdicion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( jf.btnGuardarCambiosEdicion==ae.getSource()) {
            
            
        }
    }
    
    
}
