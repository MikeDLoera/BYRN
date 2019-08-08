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
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



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
           try {
               tabla();
           } catch (UnirestException ex) {
               Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
           }
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
    
    
    
    public void tabla() throws UnirestException{
        dao.obtener();
        
        DefaultTableModel modelotabla = new DefaultTableModel();
        modelotabla.addColumn("Nombre");
         modelotabla.addColumn("Apellidos");
          modelotabla.addColumn("Correo");
           modelotabla.addColumn("Callé y Número");
           modelotabla.addColumn("Celular");
           modelotabla.addColumn("Rol");
           jf.tlbUsuarios.setModel(modelotabla);
           
           
           
           Object[] fila = new Object[6];
           
        int length = dao.getUse().length; //cuantos usuarios existen
         for (int i = 0; i < length; i++) {
            fila[0] = dao.getUse()[i].getName();
            fila[1] = dao.getUse()[i].getLast_name();
            fila[2] = dao.getUse()[i].getEmail();
            fila[3] = dao.getUse()[i].getStreet() + " " + dao.getUse()[i].getOutside_number();
            fila[4] = dao.getUse()[i].getCellphone();
            fila[5] = dao.getUse()[i].getStatus();
            
            modelotabla.addRow(fila);
        }
        
        
    
                   
    }
    
    
    
}
