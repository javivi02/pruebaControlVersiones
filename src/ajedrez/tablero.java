package ajedrez;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Javier García Arranz
 */
public class tablero {
    
    public static HashMap <String, String> piezasTablero = new HashMap<>();

    private static final String cooredanda00 = "p00";
    private static final String cooredanda01 = "p01";
    private static final String cooredanda02 = "p02";
    private static final String cooredanda10 = "p10";
    private static final String cooredanda11 = "p11";
    private static final String cooredanda12 = "p12";
    private static final String cooredanda20 = "p20";
    private static final String cooredanda21 = "p21";
    private static final String cooredanda22 = "p22";
    
    public static final int FILAS = 3;
    public static final int COLUMNAS = 3;
    
    private movimientos movimientos;
    
    public tablero(){
        
        inicioPiezas();
//        movimientos = new movimientos(this);
        
    }
    
    private void inicioPiezas(){
        
        piezasTablero.put(cooredanda00, piezas.caballo);
        piezasTablero.put(cooredanda01, "-");
        piezasTablero.put(cooredanda02, "-");
        piezasTablero.put(cooredanda10, "-");
        piezasTablero.put(cooredanda11, "-");
        piezasTablero.put(cooredanda12, "-");
        piezasTablero.put(cooredanda20, piezas.caballo);
        piezasTablero.put(cooredanda21, piezas.torre);
        piezasTablero.put(cooredanda22, piezas.peon);

    }
    
    
    public String contenidoCoordenada(String coordenada){
        
        String resultado = "-";
        
        if(piezasTablero.containsKey(coordenada)) return piezasTablero.get(coordenada);
        else return resultado;
       
    }
    
    public void actualizarCoordenada(String coordenadaIncio, String coordenadaFinal){
          
        String piezaCoordenada = piezasTablero.get(coordenadaIncio);
        
        piezasTablero.put(coordenadaIncio, "-");
        piezasTablero.put(coordenadaFinal, piezaCoordenada);
        
    }
    
    public void mostrarTablero(){
        
        //Muestra el tablero, hashMap piezasTablero, pero lo ordenado por la clave
        
        Map<String, String> treeMap = new TreeMap<String, String>(piezasTablero);
        
        Set s = treeMap.entrySet();
        Iterator it = s.iterator();
        
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("Coordenada: " + key + " -> Pieza: " + value);
        }
        System.out.println("--------------------");
    }
    
    
    public static void main(String[] args) {
        
        tablero tablero = new tablero();
        
        System.out.println(tablero.contenidoCoordenada("p00"));
        System.out.println(tablero.contenidoCoordenada("p12"));
        System.out.println(tablero.contenidoCoordenada("p20"));
        System.out.println(tablero.contenidoCoordenada("p22"));
        
        tablero.inicioPiezas();

        tablero.mostrarTablero();
        
    }
    
    

}
