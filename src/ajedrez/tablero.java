package ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Javier García Arranz
 */
public class tablero {
    
    private static HashMap <String, String> piezasTablero = new HashMap<>();

    private ArrayList <String> coordenadasPiezasBlancas = new ArrayList<>();
    private ArrayList <String> coordenadasPiezasNegras = new ArrayList<>();

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
        rellenarCoordenadasPiezasBlancas();
//        movimientos = new movimientos(this);
        
    }
    
    private void inicioPiezas(){
        
        piezasTablero.put(cooredanda00, piezas.caballoBlanco);
        piezasTablero.put(cooredanda01, "-");
        piezasTablero.put(cooredanda02, "-");
        piezasTablero.put(cooredanda10, "-");
        piezasTablero.put(cooredanda11, "-");
        piezasTablero.put(cooredanda12, "-");
        piezasTablero.put(cooredanda20, piezas.caballoBlanco);
        piezasTablero.put(cooredanda21, piezas.torreBlanca);
        piezasTablero.put(cooredanda22, piezas.peonBlanco);

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
    
    public void rellenarCoordenadasPiezasBlancas(){
        
        Iterator recorre = piezasTablero.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();
            if(!piezasTablero.get(clave).equalsIgnoreCase("-"))coordenadasPiezasBlancas.add(clave);
        }
    }
    
    public void actualizarCoordenadasPiezasBlancas(String coordenadaInicio, String coordenadaFinal){
        
        coordenadasPiezasBlancas.remove(coordenadaInicio);
        coordenadasPiezasBlancas.add(coordenadaFinal);
        
    }
    
    public ArrayList<String> getCoordenadasPiezasBlancas() {
        return coordenadasPiezasBlancas;
    }
    
    
    public static void main(String[] args) {
        
        tablero tablero = new tablero();
        
        System.out.println(tablero.contenidoCoordenada("p00"));
        System.out.println(tablero.contenidoCoordenada("p12"));
        System.out.println(tablero.contenidoCoordenada("p20"));
        System.out.println(tablero.contenidoCoordenada("p22"));
        
        tablero.inicioPiezas();

        tablero.mostrarTablero();
        
        ArrayList <String> listar = tablero.getCoordenadasPiezasBlancas();
        
        for (int i = 0; i < listar.size(); i++) {
            System.out.println(listar.get(i));
        }
 
    }
    
    

}
