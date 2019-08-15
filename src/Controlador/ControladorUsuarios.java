
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
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CST-UTJ
 */
public class ControladorUsuarios implements ActionListener {
    private final Usuarios jf;
    private final UsuariosDAO dao;

    public ControladorUsuarios(Usuarios jf, UsuariosDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAgregarUsuario.addActionListener((ActionListener)this);
        jf.btnEditarUsuario.addActionListener((ActionListener)this);
        
        start();
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
            EditarUsuarios eu = new EditarUsuarios();
            App app = BYRN.nuevaVentana("Editar Usuario", eu);
            EditarUsuariosDAO edidao = new EditarUsuariosDAO();
            ControladorEditarUsuarios edi = new ControladorEditarUsuarios (eu,edidao,app);
        }
    }
    
    private void start(){
        Thread hilo = new Thread(){
            @Override
            public void run() {
                tabla();
            }
        };
        hilo.start();
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
            
        HashMap aux = dao.getUsuarios().getValor();
            
        while(aux!=null){
            fila[0] = aux.get("name");
            fila[1] = aux.get("last_name");
            fila[2] = aux.get("email");
            fila[3] = aux.get("address");
            fila[4] = aux.get("cellphone");
            fila[5] = aux.get("status");
            
            modelotabla.addRow(fila);
            aux = dao.getUsuarios().getValor();
        }
        
         
    }
    
    
    
}
