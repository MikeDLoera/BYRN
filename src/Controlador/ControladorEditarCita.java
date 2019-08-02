/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EditarCitaDAO;
import Vista.EditarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samlml
 */
public class ControladorEditarCita implements ActionListener {
    private EditarCita jf;
    private EditarCitaDAO DAO;
    
    ControladorEditarCita(EditarCita jf, EditarCitaDAO DAO) {
      this.jf=jf;
      this.DAO=DAO;
      jf.btnGuardarCambiosDeCitaEdicion.addActionListener(this);
    }
     
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCambiosDeCitaEdicion==e.getSource()) {
            
        }
    
    
}
}
