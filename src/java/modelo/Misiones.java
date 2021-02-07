/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Misiones {
    int id;
    String descripcion, dificultad, shinobi, rango, estado, resultado;

    public Misiones() {
    }

    public Misiones(int id, String descripcion, String dificultad, String shinobi, String rango, String estado, String resultado) {
        this.id = id;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.shinobi = shinobi;
        this.rango = rango;
        this.estado = estado;
        this.resultado = resultado;
    }

    public String getShinobi() {
        return shinobi;
    }

    public void setShinobi(String shinobi) {
        this.shinobi = shinobi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
}
