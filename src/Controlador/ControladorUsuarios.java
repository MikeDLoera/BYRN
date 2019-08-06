/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgregarUsuarioDAO;
import Modelo.EditarUsuariosDAO;
import Modelo.UsuariosDAO;
import Vista.AgregarUsuario;
import Vista.App;
import Vista.EditarUsuarios;
import Vista.Usuarios;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author User
 */
public class ControladorUsuarios implements ActionListener {
       private Usuarios jf;
    private UsuariosDAO dao;

    public ControladorUsuarios(Usuarios jf, UsuariosDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAgregarUsuario.addActionListener((ActionListener)this);
        jf.btnEditarUsuario.addActionListener((ActionListener)this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAgregarUsuario==e.getSource()) {
            AgregarUsuario a = new AgregarUsuario();
            App app = BYRN.nuevaVentana("Agregar Usuario", a);
            AgregarUsuarioDAO adao = new AgregarUsuarioDAO();
            ControladorAgregarUsuario con = new ControladorAgregarUsuario(a,adao,app);
        }
        
        
        if (jf.btnEditarUsuario==e.getSource()) {
            EditarUsuarios jf = new EditarUsuarios();
            App app = BYRN.nuevaVentana("Editar Usuario", jf);
            EditarUsuariosDAO edidao = new EditarUsuariosDAO();
            ControladorEditarUsuarios edi = new ControladorEditarUsuarios (jf,edidao,app);
            
            
        }
    }
    
    
}
