
package Controlador;

import Vista.Notificacion;
import byrn.BYRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CST-UTJ
 */
public class ControladorNotificacion implements ActionListener{
    private Notificacion jf;

    public ControladorNotificacion(String mensaje, Notificacion jf) {
        this.jf = jf;
        this.jf.txtMensaje.setText(mensaje);
        
        jf.btnClose.addActionListener((ActionListener)this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnClose==e.getSource()) {
            BYRN.fadeOut();
        }
    }
    
}
