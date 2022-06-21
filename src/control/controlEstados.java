/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.StringTokenizer;
import modelo.Estados;


/**
 *
 * @author johand
 */
public class controlEstados {
    private Estados estId;
    private Estados estNum;
    StringTokenizer st;
    
    public controlEstados(){        
    }
    
    public String validarOracion(String oracion){
        String validacion="";        
        st=new StringTokenizer(oracion," ");
        int x=st.countTokens();        
        for(int i=0;i<x;i++){
            String cadena=st.nextToken();
            if(!(validarId(cadena) || validarNum(cadena))){
                validacion=cadena;                
                break;
            }
        }
        
        return validacion;
    }
    private boolean validarId(String cadena){
        estId=new Estados();
        estId.setCadena(cadena);
        boolean bandera=false;
        int i=0;       
        while(i<estId.getCadena().length()){
            if(Character.isLetter(estId.getCadena().charAt(i))){
                switch(estId.getEstadoActual()){
                    case "A":
                        estId.setEstadoActual("B");
                        estId.setValidacion(true);
                        i++;
                        break;
                    case "B":
                        i++;
                        break;
                    default:
                        estId.setValidacion(false);
                        estId.setPosLectura(i);              
                        i=estId.getCadena().length()+1;
                        break;
                }
            }else{
                if(estId.getCadena().charAt(i)==63){
                   if(estId.getEstadoActual().equals("B")){
                       estId.setEstadoActual("C");
                       estId.setValidacion(true);
                       i++;
                   }else{
                       estId.setValidacion(false);
                       estId.setPosLectura(i);
                       break;
                   } 
                }else{
                    estId.setValidacion(false);
                    estId.setPosLectura(i);
                    break;
                }
            }
                
        }
        if(estId.isValidacion()){
            bandera=true;
        }else{
            bandera=false;
        }
        return bandera;
    }

    private boolean validarNum(String cadena) {
        estNum=new Estados();
        estNum.setCadena(cadena);
        boolean bandera=false;
        int i=0;
        while(i<estNum.getCadena().length()){
            if(Character.isDigit(estNum.getCadena().charAt(i))){
                if(estNum.getEstadoActual().equals("A")){
                    estNum.setEstadoActual("B");
                    estNum.setValidacion(true);                    
                    i++;
                }else{
                    if(estNum.getEstadoActual().equals("B")){
                       estNum.setValidacion(true);
                        i++;
                    }else{
                        estNum.setValidacion(false);
                        estNum.setPosLectura(i);
                        break; 
                    }
                    
                }
            }else{
                estNum.setValidacion(false);
                estNum.setPosLectura(i);
                break;
            }
        }
        if(estNum.isValidacion()){
            bandera=true;            
        }else{
            bandera=false;
        }
        return bandera;
    }    
    
}
