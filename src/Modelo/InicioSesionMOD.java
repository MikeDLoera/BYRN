
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

    public InicioSesionMOD(String email, String password) {
        this.email = email;
        this.password = password;
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
