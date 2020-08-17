package ajedrez;

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
                    
                    tablero.actualizarTableroReina(clave);
                    interfazGrafica.actualizarIconoPeonReina(clave);
                    System.out.println("REINA");
                }
                
            }   
        }
   }
   
}
