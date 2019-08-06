
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class TempAuth {
    private String token;
    private InicioSesionMOD user;

    public TempAuth() {
    }

    public TempAuth(String token, InicioSesionMOD user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InicioSesionMOD getUser() {
        return user;
    }

    public void setUser(InicioSesionMOD user) {
        this.user = user;
    }
}
