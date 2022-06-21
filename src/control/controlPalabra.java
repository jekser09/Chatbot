/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import modelo.Palabra;
import persistencia.Archivo;
/**
 *
 * @author johand
 */
public class controlPalabra {
    private Palabra cPalabra;
    private Archivo txt;
    private controlEstados cEstados;
    private StringTokenizer st1;
    private StringTokenizer st2;
    private String estadoOra="correcto";
    public controlPalabra(){        
    }
    
    public String buscarSimbolos(String cadena){        
        cPalabra=new Palabra();
        st1=new StringTokenizer(cadena," ");        
        String palabraTxt;
        String palabraGui;
        String tipos="";
        int x=st1.countTokens();
        for(int i=0;i<x;i++){
            txt=new Archivo();
            boolean stop=false;
            palabraGui=st1.nextToken();           
                while(stop!=true){
                    try{                       
                        st2=new StringTokenizer(txt.leerArchivo()," ");                        
                        palabraTxt=st2.nextToken();
                        if(palabraGui.equals(palabraTxt)){
                            cPalabra.setLexema(palabraGui);
                            cPalabra.setTipo(st2.nextToken());                            
                            stop=true;
                        }
                    }catch(NullPointerException nx){
                        cPalabra.setTipo("(sin dato)");
                        estadoOra="incorrecto";
                        stop=true;                        
                    }
                }                    
            tipos=tipos+cPalabra.getTipo()+" ";  
        }  
        return tipos;
    }

    public String getEstadoOra() {
        return estadoOra;
    }

    public void setEstadoOra(String estadoOra) {
        this.estadoOra = estadoOra;
    }
     
    
}
