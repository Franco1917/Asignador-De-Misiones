/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



public class Shinobis {
    int id, misionf,misionc;
    String nomnrbre, cloan, rango, estado;

    public Shinobis() {
    }

    public Shinobis(int id, int misionf, int misionc, String nomnrbre, String cloan, String rango, String estado) {
        this.id = id;
        this.misionf = misionf;
        this.misionc = misionc;
        this.nomnrbre = nomnrbre;
        this.cloan = cloan;
        this.rango = rango;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMisionf() {
        return misionf;
    }

    public void setMisionf(int misionf) {
        this.misionf = misionf;
    }

    public int getMisionc() {
        return misionc;
    }

    public void setMisionc(int misionc) {
        this.misionc = misionc;
    }

    public String getNomnrbre() {
        return nomnrbre;
    }

    public void setNomnrbre(String nomnrbre) {
        this.nomnrbre = nomnrbre;
    }

    public String getCloan() {
        return cloan;
    }

    public void setCloan(String cloan) {
        this.cloan = cloan;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
