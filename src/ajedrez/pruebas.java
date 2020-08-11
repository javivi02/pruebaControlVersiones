package ajedrez;

import java.util.ArrayList;

/**
 * @author Javier García Arranz
 */
public class pruebas {
    
    public static void main(String[] args) {
        
        ArrayList <pieza> movimiento = new ArrayList<>();
        
        caballo caballo = new caballo();
        torre torre = new torre();
        reina reina = new reina();
        
        movimiento.add(caballo);
        movimiento.add(torre);
        movimiento.add(reina);
        
        for (int i = 0; i < movimiento.size(); i++) {
             System.out.println(movimiento.get(i).movimiento());
        }
        
        
    }
    

}
