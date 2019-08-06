/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class DecodedToken {
    private String iss;
    private long iat;
    private long exp;
    private long nbf;
    private String jti;
    private int sub;
    private String prv;

    public DecodedToken() {
    }

    public DecodedToken(String iss, long iat, long exp, long nbf, String jti, int sub, String prv) {
        this.iss = iss;
        this.iat = iat;
        this.exp = exp;
        this.nbf = nbf;
        this.jti = jti;
        this.sub = sub;
        this.prv = prv;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getNbf() {
        return nbf;
    }

    public void setNbf(long nbf) {
        this.nbf = nbf;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public String getPrv() {
        return prv;
    }

    public void setPrv(String prv) {
        this.prv = prv;
    }
}
