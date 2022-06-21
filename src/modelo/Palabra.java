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
public class Palabra {
    private String tipo;
    private String lexema;    
    private boolean palabraReservada;

    public Palabra(String tipo, String lexema, boolean palabraReservada) {
        this.tipo = tipo;
        this.lexema = lexema;        
        this.palabraReservada = palabraReservada;
    }

    public Palabra() {
    }
    

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(boolean palabraReservada) {
        this.palabraReservada = palabraReservada;
    }
    
}
