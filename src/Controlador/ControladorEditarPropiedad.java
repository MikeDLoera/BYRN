
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
        jf.btnGuardarCambiosDeEdicionDePropiedades.addActionListener((ActionListener)this);
        mostrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnGuardarCambiosDeEdicionDePropiedades==e.getSource()) {
            //HttpRequest request = PeticionHTTP.
            
            app.setVisible(false);
        }
    }
    
    private void mostrar(){
        jf.txtNumeroDePropiedadEdicion.setText(dao.getEstate().getId()+"");
        jf.txtNombreDePropiedadEdicion.setText(dao.getEstate().getName());
        jf.txtDueñoDePropiedadEdicion.setText(dao.getEstate().getOwner_id()+"");
        jf.txtTipoDePropiedadEdicion.setText(dao.getEstate().getEstate_type().getName());
        jf.txtDireccion.setText(dao.getEstate().getAddress());
        jf.txtDescripcionDePropiedadEdicion.setText(dao.getEstate().getDescription());
        jf.txtArea.setText(dao.getEstate().getSurface_area()+"");
        jf.txtCiudad.setText(dao.getEstate().getCity().getName());
        
    }
    
    
}
