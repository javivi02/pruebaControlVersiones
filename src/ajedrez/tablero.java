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

    private static ArrayList <String> coordenadasPiezasBlancas = new ArrayList<>();
    private static ArrayList <String> coordenadasPiezasNegras = new ArrayList<>();

    private static final String cooredanda00 = "p00";
    private static final String cooredanda01 = "p01";
    private static final String cooredanda02 = "p02";
    private static final String cooredanda03 = "p03";
    private static final String cooredanda04 = "p04";
    private static final String cooredanda05 = "p05";
    private static final String cooredanda06 = "p06";
    private static final String cooredanda07 = "p07";
    
    private static final String cooredanda10 = "p10";
    private static final String cooredanda11 = "p11";
    private static final String cooredanda12 = "p12";
    private static final String cooredanda13 = "p13";
    private static final String cooredanda14 = "p14";
    private static final String cooredanda15 = "p15";
    private static final String cooredanda16 = "p16";
    private static final String cooredanda17 = "p17";
    
    private static final String cooredanda20 = "p20";
    private static final String cooredanda21 = "p21";
    private static final String cooredanda22 = "p22";
    private static final String cooredanda23 = "p23";
    private static final String cooredanda24 = "p24";
    private static final String cooredanda25 = "p25";
    private static final String cooredanda26 = "p26";
    private static final String cooredanda27 = "p27";
    
    private static final String cooredanda30 = "p30";
    private static final String cooredanda31 = "p31";
    private static final String cooredanda32 = "p32";
    private static final String cooredanda33 = "p33";
    private static final String cooredanda34 = "p34";
    private static final String cooredanda35 = "p35";
    private static final String cooredanda36 = "p36";
    private static final String cooredanda37 = "p37";
    
    private static final String cooredanda40 = "p40";
    private static final String cooredanda41 = "p41";
    private static final String cooredanda42 = "p42";
    private static final String cooredanda43 = "p43";
    private static final String cooredanda44 = "p44";
    private static final String cooredanda45 = "p45";
    private static final String cooredanda46 = "p46";
    private static final String cooredanda47 = "p47";
    
    private static final String cooredanda50 = "p50";
    private static final String cooredanda51 = "p51";
    private static final String cooredanda52 = "p52";
    private static final String cooredanda53 = "p53";
    private static final String cooredanda54 = "p54";
    private static final String cooredanda55 = "p55";
    private static final String cooredanda56 = "p56";
    private static final String cooredanda57 = "p57";
    
    private static final String cooredanda60 = "p60";
    private static final String cooredanda61 = "p61";
    private static final String cooredanda62 = "p62";
    private static final String cooredanda63 = "p63";
    private static final String cooredanda64 = "p64";
    private static final String cooredanda65 = "p65";
    private static final String cooredanda66 = "p66";
    private static final String cooredanda67 = "p67";
    
    private static final String cooredanda70 = "p70";
    private static final String cooredanda71 = "p71";
    private static final String cooredanda72 = "p72";
    private static final String cooredanda73 = "p73";
    private static final String cooredanda74 = "p74";
    private static final String cooredanda75 = "p75";
    private static final String cooredanda76 = "p76";
    private static final String cooredanda77 = "p77";
    
    
    public static final int FILAS = 8;
    public static final int COLUMNAS = 8;
    
    public tablero(){
        
        inicioPiezas();
        rellenarCoordenadasPiezas();
        
    }
    
    private void inicioPiezas(){
        
        piezasTablero.put(cooredanda00, "-");
        piezasTablero.put(cooredanda01, "-");
        piezasTablero.put(cooredanda02, "-");
        piezasTablero.put(cooredanda03, "-");
        piezasTablero.put(cooredanda04, "-");
        piezasTablero.put(cooredanda05, "-");
        piezasTablero.put(cooredanda06, "-");
        piezasTablero.put(cooredanda07, "-");
        
        piezasTablero.put(cooredanda10, "-");
        piezasTablero.put(cooredanda11, "-");
        piezasTablero.put(cooredanda12, "-");
        piezasTablero.put(cooredanda13, piezas.peonNegro);
        piezasTablero.put(cooredanda14, "-");
        piezasTablero.put(cooredanda15, "-");
        piezasTablero.put(cooredanda16, "-");
        piezasTablero.put(cooredanda17, "-");
        
        piezasTablero.put(cooredanda20, "-");
        piezasTablero.put(cooredanda21, "-");
        piezasTablero.put(cooredanda22, "-");
        piezasTablero.put(cooredanda23, "-");
        piezasTablero.put(cooredanda24, "-");
        piezasTablero.put(cooredanda25, "-");
        piezasTablero.put(cooredanda26, "-");
        piezasTablero.put(cooredanda27, "-");
        
        piezasTablero.put(cooredanda30, "-");
        piezasTablero.put(cooredanda31, "-");
        piezasTablero.put(cooredanda32, "-");
        piezasTablero.put(cooredanda33, "-");
        piezasTablero.put(cooredanda34, "-");
        piezasTablero.put(cooredanda35, "-");
        piezasTablero.put(cooredanda36, "-");
        piezasTablero.put(cooredanda37, "-");
        
        piezasTablero.put(cooredanda40, "-");
        piezasTablero.put(cooredanda41, "-");
        piezasTablero.put(cooredanda42, "-");
        piezasTablero.put(cooredanda43, "-");
        piezasTablero.put(cooredanda44, "-");
        piezasTablero.put(cooredanda45, "-");
        piezasTablero.put(cooredanda46, "-");
        piezasTablero.put(cooredanda47, "-");
        
        piezasTablero.put(cooredanda50, "-");
        piezasTablero.put(cooredanda51, "-");
        piezasTablero.put(cooredanda52, "-");
        piezasTablero.put(cooredanda53, "-");
        piezasTablero.put(cooredanda54, "-");
        piezasTablero.put(cooredanda55, "-");
        piezasTablero.put(cooredanda56, "-");
        piezasTablero.put(cooredanda57, "-");
        
        piezasTablero.put(cooredanda60, piezas.peonBlanco);
        piezasTablero.put(cooredanda61, piezas.peonBlanco);
        piezasTablero.put(cooredanda62, piezas.peonBlanco);
        piezasTablero.put(cooredanda63, piezas.peonBlanco);
        piezasTablero.put(cooredanda64, piezas.peonBlanco);
        piezasTablero.put(cooredanda65, piezas.peonBlanco);
        piezasTablero.put(cooredanda66, piezas.peonBlanco);
        piezasTablero.put(cooredanda67, piezas.peonBlanco);
        
        piezasTablero.put(cooredanda70, piezas.torreBlanca);
        piezasTablero.put(cooredanda71, piezas.caballoBlanco);
        piezasTablero.put(cooredanda72, piezas.alfilBlanco);
        piezasTablero.put(cooredanda73, piezas.damaBlanca);
        piezasTablero.put(cooredanda74, piezas.reyBlanco);
        piezasTablero.put(cooredanda75, piezas.alfilBlanco);
        piezasTablero.put(cooredanda76, piezas.caballoBlanco);
        piezasTablero.put(cooredanda77, piezas.torreBlanca);

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
    
    public void rellenarCoordenadasPiezas(){
        
        Iterator recorre = piezasTablero.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();
            if(!piezasTablero.get(clave).equalsIgnoreCase("-") && piezasTablero.get(clave).contains("B"))coordenadasPiezasBlancas.add(clave);
            if(!piezasTablero.get(clave).equalsIgnoreCase("-") && piezasTablero.get(clave).contains("N"))coordenadasPiezasNegras.add(clave);
        }
    }
    
    public void actualizarCoordenadasPiezasBlancas(String coordenadaInicio, String coordenadaFinal){
        
        coordenadasPiezasBlancas.remove(coordenadaInicio);
        coordenadasPiezasBlancas.add(coordenadaFinal);
        
    }
    
    public ArrayList<String> getCoordenadasPiezasBlancas() {
        return coordenadasPiezasBlancas;
    }
    
    public void actualizarCoordenadasPiezasNegras(String coordenadaInicio, String coordenadaFinal){
        
        coordenadasPiezasNegras.remove(coordenadaInicio);
        coordenadasPiezasNegras.add(coordenadaFinal);
        
    }
    
    public ArrayList<String> getCoordenadasPiezasNegras() {
        return coordenadasPiezasNegras;
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
