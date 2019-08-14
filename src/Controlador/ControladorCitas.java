
package Controlador;

import Modelo.AgregarCitaDAO;
import Modelo.CitasDAO;
import Modelo.EditarCitaDAO;
import Vista.AgregarCita;
import Vista.App;
import Vista.Citas;
import Vista.EditarCita;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import kong.unirest.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class ControladorCitas implements ActionListener{
    private Citas jf;
    private CitasDAO dao;

    public ControladorCitas(Citas jf, CitasDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAgregarCita.addActionListener((ActionListener)this);
        jf.btnBorarCita.addActionListener((ActionListener)this);
        jf.btnEditarCita.addActionListener((ActionListener)this);
         try {
               tabla();
           } catch (UnirestException ex) {
               Logger.getLogger(ControladorCitas.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAgregarCita==e.getSource()) {
            AgregarCita ac = new AgregarCita();
            App app =  BYRN.nuevaVentana("Agregar cita", ac) ;
            AgregarCitaDAO acdao = new AgregarCitaDAO();
            ControladorAgregarCita cac = new ControladorAgregarCita(ac, acdao,app);
          
        }
        if (jf.btnBorarCita==e.getSource()) {
            
        }
        if (jf.btnEditarCita==e.getSource()) {
            EditarCita c = new EditarCita();
              App app = BYRN.nuevaVentana("Edición de Citas", c);
            EditarCitaDAO cDAO = new EditarCitaDAO();
            ControladorEditarCita cc = new ControladorEditarCita(c, cDAO,app);
                    
            
        }
        
    }
    

     private void tabla() throws UnirestException{
         
         DefaultTableModel modelotabla = new DefaultTableModel(){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
            modelotabla.addColumn("Número Cliente");
         modelotabla.addColumn("Fecha");
          modelotabla.addColumn("Hora de Inicio");
           modelotabla.addColumn("Ubicación");
           modelotabla.addColumn("Estatus de Cita");
           jf.tblCitas.setModel(modelotabla);
           
           Object[] fila = new Object[6];
           
           int length = dao.getCit().length; 
           
           for (int i = 0; i < length; i++) {
              fila[0] = dao.getCit()[i].get("id").toString().replaceAll(".0", "");
               fila[1] = dao.getCit()[i].get("date");
               fila[2] = dao.getCit()[i].get("start_time");
                fila[3] = dao.getCit()[i].get("location");
                 fila[4] = dao.getCit()[i].get("status");
                  
                   modelotabla.addRow(fila);
     
         }
     }
    
}
