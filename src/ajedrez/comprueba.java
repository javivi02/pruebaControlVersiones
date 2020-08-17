package ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class comprueba {
    
    private intergfazGrafica interfazGrafica;
    private tablero tablero;
    private movimientos movimientos;
    
    public comprueba (tablero tablero, intergfazGrafica interfazGrafica, movimientos movimientos){
        
        this.tablero = tablero;
        this.interfazGrafica = interfazGrafica;
        this.movimientos = movimientos;
    }
    
    public void peonDamaBlanco(){
       
       HashMap <String, String> temporal = tablero.piezasTablero();
       
       Iterator recorre = temporal.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();

            if(clave.equalsIgnoreCase("p00") || clave.equalsIgnoreCase("p01") || clave.equalsIgnoreCase("p02")
                    || clave.equalsIgnoreCase("p03") || clave.equalsIgnoreCase("p04")
                    || clave.equalsIgnoreCase("p05") || clave.equalsIgnoreCase("p06")
                    || clave.equalsIgnoreCase("p07")){
                
                if(temporal.get(clave).equalsIgnoreCase(piezas.peonBlanco)){
                    
                    tablero.actualizarTableroReinaBlanca(clave);
                    interfazGrafica.actualizarIconoPeonReina(clave);
                    System.out.println("REINA");
                }
            }   
        }
    }
   
    public boolean isJaqueBlanca(String coordenadaFinal){
        
        String coordenadaRey = posicionRey();
        
        ArrayList<String> temporal = movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenadaFinal, piezas.torreNegra);
        
        for (int i = 0; i < temporal.size(); i++) {
            if(temporal.get(i).equalsIgnoreCase(coordenadaRey)) return true;
            
        }
        return false;
    }
    
    private String posicionRey(){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        String resultado = "";
        
        Iterator recorre = temporal.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();

            if(temporal.get(clave).equalsIgnoreCase(piezas.reyBlanco)){
                resultado = clave;
            }

        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        
        
        
        
    }
    
   
}
