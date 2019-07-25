/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AnadirPropiedadDAO;
import Modelo.ListadoPropiedadesDAO;
import Vista.AnadirPropiedad;
import Vista.ListadoPropiedades;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author miker
 */
public class ControladorListadoPropiedades implements ActionListener{
    ListadoPropiedades jf;
    ListadoPropiedadesDAO dao;

    public ControladorListadoPropiedades(ListadoPropiedades jf, ListadoPropiedadesDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAnadirPropiedad.addActionListener((ActionListener)this);
        jf.btnAnterior.addActionListener((ActionListener)this);
        jf.btnEditarPropiedad.addActionListener((ActionListener)this);
        jf.btnEliminarPropiedad.addActionListener((ActionListener)this);
        jf.btnExcel.addActionListener((ActionListener)this);
        jf.btnMasInformacion.addActionListener((ActionListener)this);
        jf.btnSiguente.addActionListener((ActionListener)this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAnadirPropiedad==e.getSource()) {
            AnadirPropiedad ap = new AnadirPropiedad();
            AnadirPropiedadDAO apDAO = new AnadirPropiedadDAO();
            ControladorAnadirPropiedad cap = new ControladorAnadirPropiedad(ap, apDAO);
            BYRN.nuevaVentana("Añadir propiedad", ap);
        }
        if (jf.btnEliminarPropiedad==e.getSource()) {
            
        }
        if (jf.btnEditarPropiedad==e.getSource()) {
            
        }
        if (jf.btnMasInformacion==e.getSource()) {
            
        }
        if (jf.btnExcel==e.getSource()) {
            
        }
        if (jf.btnAnterior==e.getSource()) {
            
        }
        if (jf.btnSiguente==e.getSource()) {
            
        }
    }
}
