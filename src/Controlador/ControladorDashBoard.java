/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ListadoPropiedadesDAO;
import Vista.Citas;
import Vista.DashBoard;
import Vista.ListadoPropiedades;
import Vista.Usuarios;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author miker
 */
public class ControladorDashBoard implements ActionListener{
    private DashBoard jf;
    
    public ControladorDashBoard(DashBoard jf){
        this.jf = jf;
        
        jf.dashPropiedades.addActionListener((ActionListener)this);
        jf.dashCitas.addActionListener((ActionListener)this);
        jf.dashUsuarios.addActionListener((ActionListener)this);
        jf.dashCerrarSesion.addActionListener((ActionListener)this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.dashPropiedades==e.getSource()) {
            ListadoPropiedades lp = new ListadoPropiedades();
            ListadoPropiedadesDAO propiedadesDAO = new ListadoPropiedadesDAO();
            ControladorListadoPropiedades clp = new ControladorListadoPropiedades(lp, propiedadesDAO);
            BYRN.saltoVentana("Propiedades", lp);
        }
        if (jf.dashCitas==e.getSource()) {
            Citas c = new Citas();
            BYRN.saltoVentana("Citas", c);
        }
        if (jf.dashUsuarios==e.getSource()) {
            Usuarios u = new Usuarios();
            BYRN.saltoVentana("Usuarios", u);
        }
        if (jf.dashCerrarSesion==e.getSource()) {
            BYRN.cerrarSesion();
        }
    }
    
    
}
