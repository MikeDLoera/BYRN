
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class InicioSesionMOD {
    private String user;
    private String pass;

    public InicioSesionMOD(){
        this.user=null;
        this.pass=null;
    }
    
    public InicioSesionMOD(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
