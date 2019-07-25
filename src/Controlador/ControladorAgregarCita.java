/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AgregarCitaDAO;
import Vista.AgregarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author miker
 */
public class ControladorAgregarCita implements ActionListener{
    private AgregarCita jf;
    private AgregarCitaDAO dao;

    public ControladorAgregarCita(AgregarCita jf, AgregarCitaDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnGuardarCita.addActionListener((ActionListener)this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCita==e.getSource()) {
            
        }
    }

    
    
    
    
}
