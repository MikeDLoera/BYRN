
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class AuthUser {
    private String token;
    private long expiration;

    public AuthUser() {
    }

    public AuthUser(String token, long expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
