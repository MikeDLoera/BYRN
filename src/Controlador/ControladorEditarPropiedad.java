/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EditarPropiedadDAO;
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
    
       public ControladorEditarPropiedad ( EditarPropiedad jf,  EditarPropiedadDAO dao){
           this.jf=jf;
           this.dao=dao;
           jf.btnGuardarCambiosDeEdicionDePropiedades.addActionListener(this);
       }
    
    
    
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCambiosDeEdicionDePropiedades==e.getSource()) {
            
        }
    }
    
}
