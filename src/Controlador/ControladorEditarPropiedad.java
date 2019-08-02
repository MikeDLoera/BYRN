/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EditarPropiedadDAO;
import Vista.App;
import Vista.EditarPropiedad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samlml
 */
public class ControladorEditarPropiedad implements ActionListener{

    
      private EditarPropiedad jf;
    private EditarPropiedadDAO dao;
    private App app;
    
       public ControladorEditarPropiedad ( EditarPropiedad jf,  EditarPropiedadDAO dao,App app){
           this.jf=jf;
           this.dao=dao;
           this.app=app;
           jf.btnGuardarCambiosDeEdicionDePropiedades.addActionListener(this);
       }
    
    
    
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCambiosDeEdicionDePropiedades==e.getSource()) {
            app.setVisible(false);
        }
    }
    
}
