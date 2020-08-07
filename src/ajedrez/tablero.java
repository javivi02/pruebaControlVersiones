package ajedrez;

import java.util.HashMap;

/**
 * @author Javier García Arranz
 */
public class tablero {
    
    public HashMap <String, String> piezasTablero = new HashMap<>();

    private static final String cooredanda00 = "p00";
    private static final String cooredanda01 = "p01";
    private static final String cooredanda02 = "p02";
    private static final String cooredanda10 = "p10";
    private static final String cooredanda11 = "p11";
    private static final String cooredanda12 = "p12";
    private static final String cooredanda20 = "p20";
    private static final String cooredanda21 = "p21";
    private static final String cooredanda22 = "p22";
    
    private movimientos movimientos;
    
    public tablero(){
        
        inicioPiezas();
//        movimientos = new movimientos(this);
        
    }
    
    private void inicioPiezas(){
        
        piezasTablero.put(cooredanda00, piezas.caballo);
        piezasTablero.put(cooredanda01, null);
        piezasTablero.put(cooredanda02, null);
        piezasTablero.put(cooredanda10, null);
        piezasTablero.put(cooredanda11, null);
        piezasTablero.put(cooredanda12, null);
        piezasTablero.put(cooredanda20, piezas.caballo);
        piezasTablero.put(cooredanda21, null);
        piezasTablero.put(cooredanda22, null);

    }
    
    
    public String contenidoCoordenada(String coordenada){
        
        String resultado = null;
        
        if(piezasTablero.containsKey(coordenada)) return piezasTablero.get(coordenada);
        else return resultado;
       
    }
    
    public void actualizarCoordenada(){
        
        
    }
    
    
    public static void main(String[] args) {
        
        tablero tablero = new tablero();
        
        System.out.println(tablero.contenidoCoordenada("p00"));
        
    }
    
    

}
