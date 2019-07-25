/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Vista.AnadirPropiedad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author miker
 */
public class ControladorAnadirPropiedad implements ActionListener{
    private AnadirPropiedad jf;
    private AnadirPropiedadDAO dao;

    public ControladorAnadirPropiedad(AnadirPropiedad jf, AnadirPropiedadDAO dao) {
        this.jf = jf;
        this.dao = dao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
}
