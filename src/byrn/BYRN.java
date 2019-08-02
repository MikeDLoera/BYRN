
package byrn;

import Controlador.ControladorDashBoard;
import Controlador.ControladorInicioSesion;
import Controlador.ControladorListadoPropiedades;
import Modelo.AuthUser;
import Modelo.InicioSesionDAO;
import Modelo.InicioSesionMOD;
import Modelo.ListadoPropiedadesDAO;
import Vista.App;
import Vista.Dash;
import Vista.DashBoard;
import Vista.ListadoPropiedades;
import Vista.Load;
import Vista.Login;
import Vista.Start;
import com.google.gson.Gson;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author CST-UTJ
 */
public class BYRN {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException{
        runApp();
    }
    
    private static Start start = new Start();
    private static App app = new App();
    private static Dash dashboard = new Dash();
    private static AuthUser authUser = new AuthUser();
    private static InicioSesionMOD sesion = new InicioSesionMOD();
    public static Gson gson = new Gson();
    
    public static void runApp() throws InterruptedException, IOException{
        carga();
        //Se prepara archivo auth
        File auth = new File(fileAuth());
        //Si no existe se muestra login
        /*if (!auth.exists()) {
            //muestra login
            login();
        } else {
            //lee el archivo auth
            FileReader fr = new FileReader(auth);
            BufferedReader br = new BufferedReader(fr);
            //auth.json a un objeto auth_user
            setAuth(br.readLine());
            //obtener unix timestamp actual
            long unixTime = System.currentTimeMillis()/1000L;
            //Validar la expiration del token
            if (unixTime < authUser.getExpiration()) {
                dashboard();
            } else {
                cerrarSesion();
                app.setVisible(false);
            }
        }*/
        login();//este es de prueba
    }
    
    //agrega contenido de un panel dentro del frame
    public static void addPanelFull(JPanel nuevo,boolean isApp) {
        //obtiene dimención de nuevo panel
        Dimension tam = new Dimension(nuevo.getPreferredSize());
        //agrega dimension a nuevo
        nuevo.setSize(tam);
        //Condición si se usara app o start
        if (isApp) {
            //remueve el contenido de contenedor
            app.contenedor.removeAll();
            //añade el nuevo panel
            app.contenedor.add(nuevo);
            //revalida y pinta el nuevo panel
            app.contenedor.revalidate();
            app.contenedor.repaint();
        }else{
            //remueve el contenido de contenedor
            start.contenedor.removeAll();
            //añade el nuevo panel
            start.contenedor.add(nuevo);
            //revalida y pinta el nuevo panel
            start.contenedor.revalidate();
            start.contenedor.repaint();
            //nuevo tamaño a start y contenedor
            start.setSize(tam);
            start.contenedor.setSize(tam);
        }
    }
    
    //agrega contenido de un panel a otro 
    public static void addPanel(JPanel viejo, JPanel nuevo){
        //agrega tamaño al nuevo frame
        nuevo.setSize(viejo.getSize());
        //remueve el contenido de contenedor
        viejo.removeAll();
        //añade el nuevo panel
        viejo.add(nuevo);
        //revalida y pinta el nuevo panel
        viejo.validate();
        viejo.repaint();
    }
    
    public static void nuevaVentana(String titulo, JPanel contenido){
        App ventana = new App();
        //obtiene dimención de nuevo panel
        Dimension tam = new Dimension(contenido.getPreferredSize());
        //agrega dimension a nuevo
        contenido.setSize(tam);
        //remueve el contenido de contenedor
        ventana.contenedor.removeAll();
        //añade el nuevo panel
        ventana.contenedor.add(contenido);
        //revalida y pinta el nuevo panel
        ventana.contenedor.revalidate();
        ventana.contenedor.repaint();
        
        //ingresa titulo
        ventana.setTitle(titulo);
        //la pantalla no se pueda modificar tamaño
        ventana.setResizable(false);
        //oculte la ventana al dar al boton cerrar
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        
        //botiene el tamaño de la barra de titulo
        int h = ventana.getHeight()-ventana.contenedor.getHeight();
        //nuevo tamaño a la ventana
        ventana.setSize(tam.width, tam.height+h);
        //ventana centrada
        ventana.setLocationRelativeTo(null);
        //ventana visible
        ventana.setVisible(true);
    }
    
    public static void saltoVentana(String titulo,JPanel panel){
        //cambia titulo de app
        app.setTitle("BYRN - "+titulo);
        //se muestra nuevo contenido
        addPanel(dashboard.contenido, panel);
    }
    
    //tiempo de duracion(en milisegundos) de las animaciones
    private static int tiempoAnimacion = 200;
    //animacion de entrada
    public static void fadeIn(){
        //frame invisible
        start.setOpacity(0f);
        //frame visible
        start.setVisible(true);
        for (float i = 0; i <= 10; i++) {
            //actualiza opacidad de frame
            start.setOpacity(i/10);
            try {
                //tiempo de pausa
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(tiempoAnimacion/10);
            } catch (InterruptedException ex) {
                Logger.getLogger(BYRN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //animacion de salida
    public static void fadeOut(){
        for (float i = 10; i >= 0; i--) {
            //actualiza opacidad de frame
            start.setOpacity(i/10);
            try {
                //tiempo de pausa
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(tiempoAnimacion/10);
            } catch (InterruptedException ex) {
                Logger.getLogger(BYRN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //abrir login 
    public static void login(){
        //se crea nuevo login
        Login iniciosesion = new Login();
        InicioSesionDAO iniciosesiondao = new InicioSesionDAO();
        ControladorInicioSesion control = new ControladorInicioSesion(iniciosesiondao, iniciosesion);
        //se añade login al frame start
        addPanelFull(iniciosesion,false);
        start.setLocationRelativeTo(null);
        //se visualiza login
        fadeIn();
    }

    public static InicioSesionMOD getSesion() {
        return sesion;
    }

    public static void setSesion(InicioSesionMOD sesion) {
        BYRN.sesion = sesion;
    }
    
    //carga app
    public static void carga(){
        //se crea nuevo panel de carga
        Load load = new Load();
        //se añade panel al frame
        addPanelFull(load,false);
        start.setLocationRelativeTo(null);
        //se visualiza load
        fadeIn();
        //simulacion de carga
        for (int i = 0; i <= 100; i++) {
            load.porcentaje(i);
            try {
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(8);
            } catch (InterruptedException ex) {
                Logger.getLogger(BYRN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //abre panel de la app
    public static void dashboard(){
        //no visualizar frame start
        start.setVisible(false);
        //se añade dashboard al frame app
        addPanelFull(dashboard,true);
        //se crea nuevo menu
        DashBoard dashMenu = new DashBoard();
        ControladorDashBoard cd = new ControladorDashBoard(dashMenu);
        //se crea la vista principal
        ListadoPropiedades propiedades = new ListadoPropiedades();
        ListadoPropiedadesDAO propiedadesDAO = new ListadoPropiedadesDAO();
        ControladorListadoPropiedades clp = new ControladorListadoPropiedades(propiedades, propiedadesDAO);
        
        //se añade menu y propiedades a la app
        addPanel(dashboard.menu, dashMenu);
        addPanel(dashboard.contenido, propiedades);
        
        //se maximiza la ventana
        app.setExtendedState(MAXIMIZED_BOTH);
        app.setLocation(0,0);
        //se visualiza la ventana
        app.setVisible(true);
        //tamaño minimo igual al tamaño actual
        app.setMinimumSize(app.getSize());
        
        //obtiene altura de la ventana app
        int h = app.getHeight();
        int wm = (app.getWidth()*15)/100;
        int wc = app.getWidth()-wm;
        
        dashboard.menu.setSize(wm, h);
        dashboard.contenido.setBounds(wm, 0, wc, h);
        
    }
    
    public static String carpetaLocal(){
        return System.getProperty("java.io.tmpdir");
    }
    
    public static String fileAuth(){
        return carpetaLocal()+"authBYRN.json";
    }
    
    public static void setAuth(String json){
        authUser = gson.fromJson(json, AuthUser.class);
    }
    
    public static AuthUser getAuth(){
        return authUser;
    }
    
    public static void cerrarSesion(){
        authUser = new AuthUser();
        /*File auth = new File(fileAuth());
        if (auth.exists()) {
            authUser.setToken("");
            authUser.setExpiration(0);
            FileWriter fichero = null;
            PrintWriter pw = null;
            try{
                fichero = new FileWriter(auth);
                pw = new PrintWriter(fichero);
                pw.println(gson.toJson(authUser));
            } catch (IOException e) {
            }
            if (null != fichero){
                try {
                    fichero.close();
                } catch (IOException ex) {
                    Logger.getLogger(BYRN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                auth.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(BYRN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        app.setVisible(false);
        login();
    }
    
    public static void noConexion(){
        start.setEnabled(false);
    }
    
    //cerrar aplicacion
    public static void cerrar(){
        fadeOut();
        System.exit(0);
    }
  
    
}
