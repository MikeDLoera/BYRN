/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InformacionPropiedadesDAO;
import Vista.InformacionDePropiedades;

/**
 *
 * @author Samlml
 */
public class ControladorInformacionPropiedades{
    
    private InformacionDePropiedades jf;
    private InformacionPropiedadesDAO dao;
   

    ControladorInformacionPropiedades(InformacionDePropiedades inf, InformacionPropiedadesDAO infDAO) {
        this.jf=inf;
        this.dao=infDAO;
        mostrar();
    }
    
    private void mostrar(){
        jf.lbDireccion.setText("Dirección: "+dao.getEstate().getAddress());
        jf.lbCiudad.setText("Ciudad: "+dao.getEstate().getCity().getName());
        jf.lbDescripcion.setText("Descipción: "+dao.getEstate().getDescription());
    }
    
}
