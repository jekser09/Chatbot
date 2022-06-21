/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author johand
 */
public class Estados {
    private String cadena;
    private String estadoActual="A";
    private boolean validacion;
    private int posLectura;

    public Estados(String cadena, boolean validacion, int posLectura) {
        this.cadena = cadena;
        this.validacion = validacion;
        this.posLectura = posLectura;
    }

    public Estados() {
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

    public int getPosLectura() {
        return posLectura;
    }

    public void setPosLectura(int posLectura) {
        this.posLectura = posLectura;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    
}
