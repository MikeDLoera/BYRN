
package Controlador;

import Modelo.InformacionPropiedadesDAO;
import Modelo.ListadoPropiedadesDAO;
import Modelo.PeticionHTTP;
import Vista.App;
import Vista.InformacionDePropiedades;
import Vista.ListadoPropiedades;
import byrn.BYRN;
import byrn.ListaLigadaDobleCircular;
import kong.unirest.UnirestException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author CST-UTJ
 */
public class ControladorListadoPropiedades implements ActionListener, MouseListener{
    private ListadoPropiedades jf;
    private ListadoPropiedadesDAO dao;
    private ListaLigadaDobleCircular<ImageIcon> lista;

    public ControladorListadoPropiedades(ListadoPropiedades jf, ListadoPropiedadesDAO dao) {
        this.jf = jf;
        this.dao = dao;
        
        jf.btnAnadirPropiedad.addActionListener((ActionListener)this);
        jf.btnEditarPropiedad.addActionListener((ActionListener)this);
        jf.btnEliminarPropiedad.addActionListener((ActionListener)this);
        jf.btnPdf.addActionListener((ActionListener)this);
        jf.btnMasInformacion.addActionListener((ActionListener)this);

        jf.btnBusqueda.addActionListener((ActionListener)this);
        jf.ComboBox.addActionListener((ActionListener)this);
        
        jf.tblListadoDePropiedades.addMouseListener((MouseListener)this);
        
        start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jf.btnAnadirPropiedad==e.getSource()) {
            /*AnadirPropiedad ap = new AnadirPropiedad();
            AnadirPropiedadDAO apDAO = new AnadirPropiedadDAO(dao.getTypes(),dao.getCities(),dao.getNegocio());
            ControladorAnadirPropiedad cap = new ControladorAnadirPropiedad(ap, apDAO);
            BYRN.nuevaVentana("Añadir propiedad", ap);*/
            Thread hilo = new Thread(){
                @Override
                public void run(){
                    com.byrn.ByrnEstateForm.newEstateForm(PeticionHTTP.getBaseurl(), BYRN.getAuth().getToken());
                    for(;;){
                        if (com.byrn.ByrnEstateForm.saved) {
                            com.byrn.ByrnEstateForm.saved = false;
                            BYRN.notificacion("Propiedad guardada con éxito.");
                            break;
                        }
                        try { Thread.sleep(100);} catch (InterruptedException ex) {}
                    }
                }
            };
            hilo.start();
        }
        if (jf.btnEliminarPropiedad==e.getSource()) {
            int id = getIdSelect();
            int selected = jf.tblListadoDePropiedades.getSelectedRow();
            if (id>0) {
                try {
                    
                    
                    Thread hilo = new Thread(){
                        @Override
                        public void run() {
                            String path = "/estates/"+id;
                            PeticionHTTP.delete(path,BYRN.getAuth().getToken());
                            BYRN.notificacion("La propiedad se elimino correctamente");
                            DefaultTableModel model = (DefaultTableModel)jf.tblListadoDePropiedades.getModel();
                            model.removeRow(selected);
                            jf.tblListadoDePropiedades.setModel(model);
                            jf.btnAnterior.setEnabled(false);
                            jf.btnSiguente.setEnabled(false);
                            jf.txtImage.setIcon(null);
                        }
                    };
                    hilo.start();
                } catch (UnirestException ex) {
                    
                }
            }else{
                BYRN.notificacion(mensaje);
            }
        }
        if (jf.btnEditarPropiedad==e.getSource()) {
            int id = getIdSelect();
            if (id>0) {
                /*EditarPropiedad ed = new EditarPropiedad();
                App app = BYRN.nuevaVentana("Editar Propiedad", ed);
                EditarPropiedadDAO edDAO = new EditarPropiedadDAO(getState(id),dao.getCities(),dao.getTypes());
                ControladorEditarPropiedad con = new ControladorEditarPropiedad(ed, edDAO,app);*/
                Thread hilo = new Thread(){
                    @Override
                    public void run(){
                        com.byrn.ByrnEstateForm.newEstateForm(PeticionHTTP.getBaseurl(), BYRN.getAuth().getToken(),id);
                        for(;;){
                            if (com.byrn.ByrnEstateForm.saved) {
                                com.byrn.ByrnEstateForm.saved = false;
                                BYRN.notificacion("Propiedad guardada con éxito.");
                                break;
                            }
                            try{Thread.sleep(100);}catch(InterruptedException ex){}
                        }
                    }
                };
                hilo.start();
                
            }else{
                BYRN.notificacion(mensaje);
            }
        }
        if (jf.btnMasInformacion==e.getSource()) {
            int id = getIdSelect();
            if (id>0) {
                InformacionDePropiedades inf = new InformacionDePropiedades();
                InformacionPropiedadesDAO infDAO = new InformacionPropiedadesDAO(getState(id));
                App app = BYRN.nuevaVentana("Más Información", inf);
                ControladorInformacionPropiedades con = new ControladorInformacionPropiedades(inf,infDAO);
            }else{
                BYRN.notificacion(mensaje);
            }
           
        }
        if (jf.btnPdf==e.getSource()) {
            int id = getIdSelect();
            if (id>0) {
                //aqui el reporte 
                
            }else{
                BYRN.notificacion(mensaje);
            }
        }
        if (jf.ComboBox==e.getSource()) {
            if (jf.ComboBox.getSelectedIndex()>0) {
                int length = dao.getTypes().length;
                for (int i=0;i<length;i++) {
                    if (dao.getTypes()[i].get("name").equals(jf.ComboBox.getSelectedItem())) {
                        String idAux = dao.getTypes()[i].get("id").toString();
                        int id = Integer.parseInt(idAux.substring(0,idAux.indexOf('.')));
                        filtrado(id);
                        break;
                    }
                }
            }else{
                if (jf.ComboBox.getSelectedIndex()==0) {
                    try {
                        tabla(dao.getAllEstates());
                    } catch (UnirestException ex) {
                    }
                }
            }
        }
        if (jf.btnBusqueda==e.getSource()) {
            Thread hilo = new Thread(){
                @Override
                public void run() {
                    busqueda();
                }
            };
            hilo.start();
        }
    }
    
    private void start(){
        Thread hilo = new Thread(){
            @Override
            public void run() {
                dao.estatesList();
                dao.allUsers();
                tabla(dao.getAllEstates());
            }
        };
        hilo.start();
        Thread hilo2 = new Thread(){
            @Override
            public void run() {
                getTypes();
            }
        };
        hilo2.start();
    }
    
    private String mensaje = "Seleccione una fila de la tabla";
    
    private void tabla(ArrayList<HashMap> lista){
        DefaultTableModel modelotabla = new DefaultTableModel(){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
        modelotabla.addColumn("Número de Propiedad");
        modelotabla.addColumn("Nombre");
        modelotabla.addColumn("Dueño");
        modelotabla.addColumn("Tipo");
        jf.tblListadoDePropiedades.setModel(modelotabla);
        Object[] fila = new Object[4];
        int l = lista.size();
        for (int i = 0; i < l; i++) {
            HashMap estate = lista.get(i);
            String id = estate.get("id")+"";
            fila[0] = id.substring(0, id.indexOf(".0"));
            fila[1] = estate.get("name");
            fila[2] = dao.getOwnerName(estate.get("owner_id").toString()); 
            fila[3] = BYRN.gson.fromJson(BYRN.gson.toJson(estate.get("estate_type")), HashMap.class).get("name");
            //System.out.println(estate.get("estate_type"));
            modelotabla.addRow(fila);
        }

    }
    
    private void filtrado(int id){
        ArrayList<HashMap> filtro = new ArrayList<>();
        int l = dao.getAllEstates().size();
        for (int i = 0; i < l; i++) {
            HashMap estate = dao.getAllEstates().get(i);
            HashMap type = BYRN.gson.fromJson(BYRN.gson.toJson(estate.get("estate_type")), HashMap.class);
            String idAux = type.get("id").toString();
            int estateId = Integer.parseInt(idAux.substring(0,idAux.indexOf('.')));
            if (id==estateId) {
                filtro.add(estate);
            }
        }
        tabla(filtro);
    }
    
    private void busqueda(){
        String name = jf.txtBuscador.getText();
        name = name.toLowerCase();
        ArrayList<HashMap> busqueda = new ArrayList<>();
            
        int l = dao.getAllEstates().size();
        for (int i = 0; i < l; i++) {
            if (dao.getAllEstates().get(i).get("name").toString().toLowerCase().contains(name)) {
                busqueda.add(dao.getAllEstates().get(i));
            }
        }
        tabla(busqueda);
    }
    
    
    
    private HashMap getState(int id){
        HashMap estate = null;
        int l = dao.getAllEstates().size();
        for (int i = 0; i < l; i++){
            HashMap auxEstate = dao.getAllEstates().get(i);
            String n = auxEstate.get("id").toString();
            int idAux = Integer.parseInt(n.substring(0, n.indexOf(".0")));
            if (id==idAux) {
                estate = auxEstate;
                break;
            }
        }
        return estate;
    }
    
    private int getIdSelect(){
        if (jf.tblListadoDePropiedades.getSelectedRowCount()==1) {
            int rowSelect = jf.tblListadoDePropiedades.getSelectedRow();
            return Integer.parseInt(jf.tblListadoDePropiedades.getValueAt(rowSelect, 0)+"");
        }else{
            return -1;
        }
    }
    
    private void getTypes() throws UnirestException{
        dao.allTypes();
        int length = dao.getTypes().length;
        String[] types = new String[length+1];
        types[0] = "Todos";
        for (int i = 1; i < length+1; i++) {
            types[i] = (String) dao.getTypes()[i-1].get("name");
        }
        jf.ComboBox.setModel(new javax.swing.DefaultComboBoxModel(types));
        jf.ComboBox.setOpaque(true);
    }
    
    public void setImages(){
        CarouselController cc;
        jf.btnAnterior.setEnabled(false);
        jf.btnSiguente.setEnabled(false);
        jf.txtImage.setIcon(null);
        int id = getIdSelect();
        if (id>0) {
            HashMap estate = BYRN.gson.fromJson(PeticionHTTP.get("/estates/"+id, BYRN.getAuth().getToken()).getBody().toString(), HashMap.class);
            HashMap[] images = BYRN.gson.fromJson(BYRN.gson.toJson(estate.get("images")), HashMap[].class);
            int l = images.length;
            String urls = "";
            for (int i = 0; i < l; i++) {
                urls+=images[i].get("url");
                if (i<l-1) {
                    urls+=",\n";
                }
            }
            if (images.length>0) {
                cc = new CarouselController(urls,this);        
                if (lista.getLargo()>1) {
                    jf.btnAnterior.setEnabled(true);
                    jf.btnSiguente.setEnabled(true);
                }
            }
        }
    }
        

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==jf.tblListadoDePropiedades) {
            Thread hilo = new Thread(){
                @Override
                public void run() {
                    setImages();
                }
            };
            hilo.start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public ListaLigadaDobleCircular getLista() {
        return lista;
    }

    public void setLista(ListaLigadaDobleCircular lista) {
        this.lista = lista;
    }

    public ListadoPropiedades getJf() {
        return jf;
    }
    
}