package ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Javier García Arranz
 */
public class movimientos {
    
    private tablero tablero;
    private interfazGrafica interfazGrafica;
    private comprueba comprueba;
    
    private boolean enrroqueCortoBlancas;
    private boolean enrroqueCortoNegras;
    private boolean enrroqueLargoBlancas;
    private boolean enrroqueLargoNegras;

    public movimientos(tablero tablero, interfazGrafica interfazGrafica){
        
        this.tablero = tablero; 
        comprueba = new comprueba(tablero, interfazGrafica, this);
        
        enrroqueCortoBlancas = false;
        enrroqueCortoNegras = false;
        enrroqueLargoBlancas = false;
        enrroqueLargoNegras = false;
        
        
    }
    
    public ArrayList <String> moverCaballo(String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        if ((fila - 2 >= 0 && fila - 2 < tablero.FILAS) && (columna - 1 >= 0 && columna - 1 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila - 2) + (columna - 1));
        }
        if ((fila - 2 >= 0 && fila - 2 < tablero.FILAS) && (columna + 1 >= 0 && columna + 1 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila - 2) + (columna + 1));
        }
        if ((fila - 1 >= 0 && fila - 1 < tablero.FILAS) && (columna + 2 >= 0 && columna + 2 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila - 1) + (columna + 2));
        }
        if ((fila + 1 >= 0 && fila + 1 < tablero.FILAS) && (columna + 1 >= 0 && columna + 2 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila + 1) + (columna + 2));
        }
        if ((fila + 2 >= 0 && fila + 2 < tablero.FILAS) && (columna + 1 >= 0 && columna + 1 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila + 2) + (columna + 1));
        }
        if ((fila + 2 >= 0 && fila + 2 < tablero.FILAS) && (columna - 1 >= 0 && columna - 1 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila + 2) + (columna - 1));
        }
        if ((fila + 1 >= 0 && fila + 1 < tablero.FILAS) && (columna - 2 >= 0 && columna - 2 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila + 1) + (columna - 2));
        }
        if ((fila - 1 >= 0 && fila - 1 < tablero.FILAS) && (columna - 2 >= 0 && columna - 2 < tablero.COLUMNAS)) {
            resultado.add("p" + (fila - 1) + (columna - 2));
        }

        return resultado;
    }
    
    public ArrayList <String> moverPeonBlanco (String coordenada, ArrayList <String> piezasNegras){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        if(coordenada.equalsIgnoreCase("p60") || coordenada.equalsIgnoreCase("p61") || coordenada.equalsIgnoreCase("p62") 
                || coordenada.equalsIgnoreCase("p63")|| coordenada.equalsIgnoreCase("p64") || coordenada.equalsIgnoreCase("p65") 
                || coordenada.equalsIgnoreCase("p66")|| coordenada.equalsIgnoreCase("p67")){

            if (fila - 1 >= 0 && !peonCaptura(piezasNegras, "p" + (fila - 1) + columna)) {
                resultado.add("p" + (fila - 1) + columna);
                
            }
            
            if (fila - 2 >= 0 && !peonCaptura(piezasNegras, "p" + (fila - 2) + columna)) {
                    resultado.add("p" + (fila - 2) + columna);
            }
            
        }else{
  
            //posible movimiento arriba, compruebo tambien si hay una pieza en la siguiente casilla del peon
            if (fila - 1 >= 0 && !peonCaptura(piezasNegras, "p" + (fila - 1) + columna)) {
                resultado.add("p" + (fila - 1) + columna);
            }   
        }
        
        if(peonCaptura(piezasNegras, "p" + (fila - 1) + (columna - 1))) resultado.add("p" + (fila - 1) + (columna - 1));
        if(peonCaptura(piezasNegras, "p" + (fila - 1) + (columna + 1))) resultado.add("p" + (fila - 1) + (columna + 1));
       
        return resultado;        
    }
    
    public ArrayList <String> moverPeonNegro (String coordenada, ArrayList <String> piezasBlancas){
        
        ArrayList <String> resultado = new ArrayList<>();

        String temporal [] = coordenada.split("");
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        if(coordenada.equalsIgnoreCase("p10") || coordenada.equalsIgnoreCase("p11") || coordenada.equalsIgnoreCase("p12") 
                || coordenada.equalsIgnoreCase("p13")|| coordenada.equalsIgnoreCase("p14") || coordenada.equalsIgnoreCase("p15") 
                || coordenada.equalsIgnoreCase("p16")|| coordenada.equalsIgnoreCase("p17")){


            if (fila + 1 >= 0 && !peonCaptura(piezasBlancas, "p" + (fila + 1) + columna)) {
                resultado.add("p" + (fila + 1) + columna);
                
            }
            
            if (fila + 2 >= 0 && !peonCaptura(piezasBlancas, "p" + (fila + 2) + columna)) {
                    resultado.add("p" + (fila + 2) + columna);
            }
            
        }else{

            //posible movimiento arriba
            if (fila + 1 < tablero.COLUMNAS && !peonCaptura(piezasBlancas, "p" + (fila + 1) + columna)) {
                resultado.add("p" + (fila + 1) + columna);
            }   
        }
        
        if(peonCaptura(piezasBlancas, "p" + (fila + 1) + (columna - 1))) resultado.add("p" + (fila + 1) + (columna - 1));
        if(peonCaptura(piezasBlancas, "p" + (fila + 1) + (columna + 1))) resultado.add("p" + (fila + 1) + (columna + 1));

        return resultado;
        
    }
    
     private boolean peonCaptura(ArrayList <String> piezasNegras, String coordenada){
        
        ArrayList <String> resultado = piezasNegras;
        
        for (int i = 0; i < resultado.size(); i++) {
            if(resultado.get(i).equalsIgnoreCase(coordenada)) return true;
        }
        
        return false;
    }
    
    /**
     * El metodo devolvera el listado coordenadas donde puedo mover la ficha pasada.
     * Tiene en cuenta las posicion de sus fichas y de las fichas negras para dar ese resultado.
     * 
     * @param piezasBlancas Coordenadas con las piezas blancas del tablero, en el momento actual
     * @param piezasNegras Coordenadas con las piezas negras del tablero, en el momento actual
     * @param coordenada Coordenada de la picha que quiero mover
     * @param tipoFicha Color de la ficha, si es blanca o negra
     * @return Listado de coordenadas donde puedo mover la ficha
     */
    
    public ArrayList <String> moverTorre (ArrayList <String> piezasBlancas, ArrayList <String> piezasNegras, String coordenada, String tipoFicha){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        ArrayList <String> variable, variable2;
        
        if(tipoFicha.contains("B")){
            
            variable = piezasBlancas;
            variable2 = piezasNegras;
            
        }else{
            
            variable = piezasNegras;
            variable2 = piezasBlancas;
        }
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if (filtroPiezas(variable, "p" + fila + i)) {
                break;
            }
            if (filtroPiezas(variable2, "p" + fila + i)) {
                resultado.add("p" + fila + i);
                break;
            }
            resultado.add("p" + fila + i);
        }

        //posibles movimientos derecha
        for (int i = columna + 1; i < tablero.FILAS; i++) {
            if (filtroPiezas(variable, "p" + fila + i)) {
                break;
            }
            if (filtroPiezas(variable2, "p" + fila + i)) {
                resultado.add("p" + fila + i);
                break;
            }
            resultado.add("p" + fila + i);
        }

        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            if (filtroPiezas(variable, "p" + i + columna)) {
                break;
            }
            if (filtroPiezas(variable2, "p" + i + columna)) {
                resultado.add("p" + i + columna);
                break;
            }
            resultado.add("p" + i + columna);
        }

        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
            if (filtroPiezas(variable, "p" + i + columna)) {
                break;
            }
            if (filtroPiezas(variable2, "p" + i + columna)) {
                resultado.add("p" + i + columna);
                break;
            }
            resultado.add("p" + i + columna);
        }
        
        
        
        return resultado;
    }
    
    public ArrayList <String> moverAlfil (ArrayList <String> piezasBlancas, ArrayList <String> piezasNegras, String coordenada, String tipoFicha){

        ArrayList <String> resultado = new ArrayList<>();
        
        ArrayList <String> variable, variable2;
        
        if(tipoFicha.contains("B")){
            
            variable = piezasBlancas;
            variable2 = piezasNegras;
            
        }else{
            
            variable = piezasNegras;
            variable2 = piezasBlancas;
        }
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            if(filtroPiezas(variable, "p" + (fila + i) + (columna - i))) break;
            if(filtroPiezas(variable2, "p" + (fila + i) + (columna - i))){
                resultado.add("p" + (fila + i) + (columna - i));
                break;
            }
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezas(variable, "p" + (fila + i) + (columna + i))) break;
            if(filtroPiezas(variable2, "p" + (fila + i) + (columna + i))){
                resultado.add("p" + (fila + i) + (columna + i));
                break;
            }
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezas(variable, "p" + (fila - i) + (columna + i))) break;
            if(filtroPiezas(variable2, "p" + (fila - i) + (columna + i))){
                resultado.add("p" + (fila - i) + (columna + i));
                break;
            }
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            if(filtroPiezas(variable, "p" + (fila - i) + (columna - i))) break;
            if(filtroPiezas(variable2, "p" + (fila - i) + (columna - i))){
                resultado.add("p" + (fila - i) + (columna - i));
                break;
            }
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        return resultado;
        
    }
    
    public ArrayList <String> moverDama (ArrayList <String> piezasBlancas, ArrayList <String> piezasNegras, String coordenada, String tipoFicha){

        ArrayList <String> resultado = new ArrayList<>();
        
        ArrayList <String> variable, variable2;
        
        if(tipoFicha.contains("B")){
            
            variable = piezasBlancas;
            variable2 = piezasNegras;
            
        }else{
            
            variable = piezasNegras;
            variable2 = piezasBlancas;
        }
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            if(filtroPiezas(variable, "p" + (fila + i) + (columna - i))) break;
            if(filtroPiezas(variable2, "p" + (fila + i) + (columna - i))){
                resultado.add("p" + (fila + i) + (columna - i));
                break;
            }
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezas(variable, "p" + (fila + i) + (columna + i))) break;
            if(filtroPiezas(variable2, "p" + (fila + i) + (columna + i))){
                resultado.add("p" + (fila + i) + (columna + i));
                break;
            }
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezas(variable, "p" + (fila - i) + (columna + i))) break;
            if(filtroPiezas(variable2, "p" + (fila - i) + (columna + i))){
                resultado.add("p" + (fila - i) + (columna + i));
                break;
            }
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            if(filtroPiezas(variable, "p" + (fila - i) + (columna - i))) break;
            if(filtroPiezas(variable2, "p" + (fila - i) + (columna - i))){
                resultado.add("p" + (fila - i) + (columna - i));
                break;
            }
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if(filtroPiezas(variable, "p" + fila + i)) break;
            if(filtroPiezas(variable2, "p" + fila + i)){
                resultado.add("p" + fila + i);
                break;
            }
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos derecha
        for (int i = columna + 1 ; i < tablero.FILAS; i++) {
            if(filtroPiezas(variable, "p" + fila + i)) break;
            if(filtroPiezas(variable2, "p" + fila + i)){
                resultado.add("p" + fila + i);
                break;
            }
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            if(filtroPiezas(variable, "p" + i + columna)) break;
            if(filtroPiezas(variable2, "p" + i + columna)){
                resultado.add("p" + i + columna);
                break;
            }
            resultado.add("p" + i + columna);
        }
        
        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
            if(filtroPiezas(variable, "p" + i + columna)) break;
            if(filtroPiezas(variable2, "p" + i + columna)){
                resultado.add("p" + i + columna);
                break;
            }
            resultado.add("p" + i + columna);
        }
        
        return resultado;
        
    }
    
    public ArrayList <String> moverRey (String coordenada, String tipoFicha){

        ArrayList <String> resultado = new ArrayList<>();
        
        boolean blanco = false, negro = false; // Para indicar si sumo movimientos en el enrroque a rey blanco o negro
        
        if(tipoFicha.contains("B")) blanco = true;
        else negro = true;
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posible movimientos derecha abajo
        if (fila + 1 < tablero.FILAS && columna - 1 >= 0) {
            resultado.add("p" + (fila + 1) + (columna - 1)); 
        }
        
        //posible movimientos izquierda abajo
        if(fila + 1 < tablero.FILAS && columna + 1 < tablero.COLUMNAS) {
            resultado.add("p" + (fila + 1) + (columna + 1)); 
        }
        
        //posible movimientos derecha arriba
        if(fila - 1 >= 0 && columna + 1 < tablero.COLUMNAS) {
            resultado.add("p" + (fila - 1) + (columna + 1)); 
        }
        
        //posible movimientos izquierda arriba
        if(fila - 1 >= 0 && columna - 1 >= 0) {
            resultado.add("p" + (fila - 1) + (columna - 1)); 
        }
        
        //posible movimientos izquierda
        if (columna - 1 >= 0) {
            resultado.add("p" + fila + (columna - 1));
        }
        
        //posible movimientos derecha
        if (columna + 1 < tablero.FILAS) {
            resultado.add("p" + fila + (columna + 1));
        }
        
        //posible movimientos arriba
        if (fila - 1 >= 0) {
            resultado.add("p" + (fila - 1) + columna);
        }
        
        //posible movimientos abajo
        if (fila + 1 < tablero.COLUMNAS) {
            resultado.add("p" + (fila + 1) + columna);
        }
        
        if (comprueba.enrroqueCortoBlancas() && interfazGrafica.numeroMovimientosReyBlanco == 0 
                && comprueba.isBlancasJaque() == false && blanco == true){
            resultado.add("p" + fila + (columna + 2));
            enrroqueCortoBlancas = true;
        } 
        
        if (comprueba.enrroqueLargoBlancas() && interfazGrafica.numeroMovimientosReyBlanco == 0
                && comprueba.isBlancasJaque() == false && blanco == true){
            resultado.add("p" + fila + (columna - 2));
            enrroqueLargoBlancas = true;
        }
        
        if (comprueba.enrroqueCortoNegras() && interfazGrafica.numeroMovimientosReyNegro == 0
                && comprueba.isNegrasJaque() == false && negro == true){
            resultado.add("p" + fila + (columna + 2));
            enrroqueCortoNegras = true;
        } 

        if (comprueba.enrroqueLargoNegras() && interfazGrafica.numeroMovimientosReyNegro == 0
                && comprueba.isNegrasJaque() == false && negro == true){
            resultado.add("p" + fila + (columna - 2));
            enrroqueLargoNegras = true;
        }
        
        return resultado;
        
    }
    
    /**
     * Nos indica si la coordenada generada por el movimiento coincide con alguna coordenada del ArrayList que le paso
     * Lo utilizado para parar el conteo en algua direccion al encontrar una ficha del mismo color o distinta
     * 
     * @param piezas ArrayList de piezas blancas o negras
     * @param valorCoordenada Valor de la coordenada a analizar
     * @return 
     */
    
    private boolean filtroPiezas(ArrayList <String> piezas, String valorCoordenada){
        
        ArrayList <String> temporal = piezas;
        
        for (int i = 0; i < temporal.size(); i++) {
            if(temporal.get(i).equalsIgnoreCase(valorCoordenada)) return true;
        }
        
        return false;
        
    }

    public boolean isEnrroqueCortoBlancas() {
        return enrroqueCortoBlancas;
    }

    public boolean isEnrroqueCortoNegras() {
        return enrroqueCortoNegras;
    }

    public boolean isEnrroqueLargoBlancas() {
        return enrroqueLargoBlancas;
    }

    public boolean isEnrroqueLargoNegras() {
        return enrroqueLargoNegras;
    }

    public void setEnrroqueCortoBlancas(boolean enrroqueCortoBlancas) {
        this.enrroqueCortoBlancas = enrroqueCortoBlancas;
    }

    public void setEnrroqueCortoNegras(boolean enrroqueCortoNegras) {
        this.enrroqueCortoNegras = enrroqueCortoNegras;
    }

    public void setEnrroqueLargoBlancas(boolean enrroqueLargoBlancas) {
        this.enrroqueLargoBlancas = enrroqueLargoBlancas;
    }

    public void setEnrroqueLargoNegras(boolean enrroqueLargoNegras) {
        this.enrroqueLargoNegras = enrroqueLargoNegras;
    }
    
    
    
    public static void main(String[] args) {
         
//        movimientos movimientos = new movimientos();
        
//        ArrayList <String> prueba = movimientos.moverTorre("p00");
//        ArrayList <String> prueba = movimientos.moverAlfil("p36");
//        ArrayList <String> prueba = movimientos.moverPeonBlanco("p00");
//        ArrayList <String> prueba = movimientos.moverCaballo("p00");
//        ArrayList <String> prueba = movimientos.moverDama("p00");
//        ArrayList <String> prueba = movimientos.moverRey("p00");
        
//        for (int i = 0; i < prueba.size(); i++) {
//            System.out.print(prueba.get(i) + " ");
//        }
//
//
        System.out.println("------------------------------");
        
        tablero tablero = new tablero();
        
        ArrayList <String> listar = tablero.getCoordenadasPiezasBlancas();
        
//        ArrayList <String> prueba1 = movimientos.moverTorre(listar, "p70");
//
//        for (int i = 0; i < prueba1.size(); i++) {
//            System.out.println(prueba1.get(i));
//        } 

    }
}
