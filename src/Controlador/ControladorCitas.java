
package Controlador;

import Modelo.CitasDAO;
import Vista.Citas;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import kong.unirest.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class ControladorCitas implements ActionListener{
    private final Citas jf;
    private final CitasDAO dao;

    public ControladorCitas(Citas jf, CitasDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAceptar.addActionListener((ActionListener)this);
        jf.btnCancelar.addActionListener((ActionListener)this);
        
        start();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jf.btnAceptar) {
            int id = getIdSelect();
            if (id>0) {
                dao.actualizar(id, 2);
                BYRN.notificacion("Cita aceptada");
                tabla();
            }
        }
        if (e.getSource()==jf.btnCancelar) {
            int id = getIdSelect();
            if (id>0) {
                dao.actualizar(id, 0);
                BYRN.notificacion("Cita rechazada");
                tabla();
            }
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
        modelotabla.addColumn("Número de cita");
        modelotabla.addColumn("Fecha");
        modelotabla.addColumn("Hora de Inicio");
        modelotabla.addColumn("Ubicación");
        modelotabla.addColumn("Estatus de Cita");
        jf.tblCitas.setModel(modelotabla);
           
        Object[] fila = new Object[6];
        
        HashMap aux = dao.getCitas().getValor();
        
        while(aux!=null){
            String idAux = aux.get("id").toString();
            fila[0] = idAux.substring(0,idAux.indexOf('.'));
            fila[1] = aux.get("date");
            fila[2] = aux.get("start_time");
            fila[3] = aux.get("location");
            fila[4] = getStatus(aux.get("status").toString());
            
            modelotabla.addRow(fila);
            aux = dao.getCitas().getValor();
        }
    }
    
    public String getStatus(String status){
        int estatus = Integer.parseInt(status);
        if(estatus==0){status="Rechazada";}
        if(estatus==1){status="Pendiente";}
        if(estatus==2){status="Aceptada";}
        return status;
    }
    
    private int getIdSelect(){
        if (jf.tblCitas.getSelectedRowCount()==1) {
            int rowSelect = jf.tblCitas.getSelectedRow();
            return Integer.parseInt(jf.tblCitas.getValueAt(rowSelect, 0)+"");
        }else{
            return -1;
        }
    }
    
}
