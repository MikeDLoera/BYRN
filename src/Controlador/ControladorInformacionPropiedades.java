/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InformacionPropiedadesDAO;
import Vista.App;
import Vista.InformacionDePropiedades;

/**
 *
 * @author Samlml
 */
public class ControladorInformacionPropiedades {
    
    private InformacionDePropiedades inf;
    private InformacionPropiedadesDAO infDAO;
   

    ControladorInformacionPropiedades(InformacionDePropiedades inf, InformacionPropiedadesDAO infDAO) {
        this.inf=inf;
        this.infDAO=infDAO;
    }
    
}
