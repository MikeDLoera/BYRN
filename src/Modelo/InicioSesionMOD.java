
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class InicioSesionMOD {
    private String email;
    private String password;

    public InicioSesionMOD(){
        this.email=null;
        this.password=null;
    }
    
    public InicioSesionMOD(String user, String pass) {
        this.email = user;
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user) {
        this.email = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}
