
package Controlador;

import Modelo.UsuariosDAO;
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
        
        jf.btnBusqueda.addActionListener((ActionListener)this);
        
        start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (jf.btnAgregarUsuario==e.getSource()) {
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
        }*/
        if (jf.btnBusqueda==e.getSource()) {
            String name = jf.txtBusqueda.getText();
            tabla(name);
        }
    }
    
    private void start(){
        Thread hilo = new Thread(){
            @Override
            public void run() {
                tabla(null);
            }
        };
        hilo.start();
    }
    
    private void tabla(String name) throws UnirestException{
        if (name==null) {
            dao.obtener();
        }
        
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
        
        if (name!=null) {
            while(aux!=null){
                String nameAux = aux.get("name").toString()+aux.get("last_name").toString();
                if (nameAux.toLowerCase().contains(name)) {
                    fila[0] = aux.get("name");
                    fila[1] = aux.get("last_name");
                    fila[2] = aux.get("email");
                    fila[3] = aux.get("address");
                    fila[4] = aux.get("cellphone");
                    fila[5] = getRoles(aux.get("roles"));
                    modelotabla.addRow(fila);
                }
                aux = dao.getUsuarios().getValor();
            }
        }else{
            while(aux!=null){
                fila[0] = aux.get("name");
                fila[1] = aux.get("last_name");
                fila[2] = aux.get("email");
                fila[3] = aux.get("address");
                fila[4] = aux.get("cellphone");
                fila[5] = getRoles(aux.get("roles"));
                modelotabla.addRow(fila);
                aux = dao.getUsuarios().getValor();
            }
        }
    }
    
    
    private String getRoles(Object value){
        HashMap[] roles = BYRN.gson.fromJson(BYRN.gson.toJson(value), HashMap[].class);
        int l = roles.length;
        if (l>0) {
            String rol = "";
            for (int i = 0; i < l; i++) {
                rol+=roles[i].get("display_name").toString();
                if (i<l-1) {
                    rol+=", ";
                }
            }
            return rol;
        }else{
            return "Predeterminado";
        }
    }
    
    
    
}
