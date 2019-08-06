/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author miker
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
