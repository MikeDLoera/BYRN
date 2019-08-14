
package Controlador;

import Modelo.AgregarUsuarioDAO;
import Modelo.EditarUsuariosDAO;
import Modelo.UsuariosDAO;
import Vista.AgregarUsuario;
import Vista.App;
import Vista.EditarUsuarios;
import Vista.Usuarios;
import byrn.BYRN;
import kong.unirest.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CST-UTJ
 */
public class ControladorUsuarios implements ActionListener {
       private Usuarios jf;
    private UsuariosDAO dao;

    public ControladorUsuarios(Usuarios jf, UsuariosDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAgregarUsuario.addActionListener((ActionListener)this);
        jf.btnEditarUsuario.addActionListener((ActionListener)this);
           try {
               tabla();
           } catch (UnirestException ex) {
               Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAgregarUsuario==e.getSource()) {
            AgregarUsuario a = new AgregarUsuario();
            App app = BYRN.nuevaVentana("Agregar Usuario", a);
            AgregarUsuarioDAO adao = new AgregarUsuarioDAO();
            ControladorAgregarUsuario con = new ControladorAgregarUsuario(a,adao,app);
        }
        
        
        if (jf.btnEditarUsuario==e.getSource()) {
            EditarUsuarios jf = new EditarUsuarios();
            App app = BYRN.nuevaVentana("Editar Usuario", jf);
            EditarUsuariosDAO edidao = new EditarUsuariosDAO();
            ControladorEditarUsuarios edi = new ControladorEditarUsuarios (jf,edidao,app);
        }
    }
    
    
    
    private void tabla() throws UnirestException{
        dao.obtener();
        
        DefaultTableModel modelotabla = new DefaultTableModel(){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
        modelotabla.addColumn("Nombre");
        modelotabla.addColumn("Apellidos");
        modelotabla.addColumn("Correo");
        modelotabla.addColumn("Callé y Número");
        modelotabla.addColumn("Celular");
        modelotabla.addColumn("Rol");
        jf.tlbUsuarios.setModel(modelotabla);
         
        Object[] fila = new Object[6];
           
        int length = dao.getUse().length; //cuantos usuarios existen
         for (int i = 0; i < length; i++) {
            fila[0] = dao.getUse()[i].get("name");
            fila[1] = dao.getUse()[i].get("last_name");
            fila[2] = dao.getUse()[i].get("email");
            fila[3] = dao.getUse()[i].get("address");
            fila[4] = dao.getUse()[i].get("cellphone");
            fila[5] = dao.getUse()[i].get("status");
            
            modelotabla.addRow(fila);
        }
         
    }
    
    
    
}
