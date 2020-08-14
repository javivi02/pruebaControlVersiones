package ajedrez;

import java.util.ArrayList;

/**
 * @author Javier García Arranz
 */
public class movimientos {
    
    private tablero tablero;
    
//    public movimientos(){
//        
//        tablero = new tablero();
//    }
    
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
    
    public ArrayList <String> moverPeonBlanco (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        if(coordenada.equalsIgnoreCase("p60") || coordenada.equalsIgnoreCase("p61") || coordenada.equalsIgnoreCase("p62") 
                || coordenada.equalsIgnoreCase("p63")|| coordenada.equalsIgnoreCase("p64") || coordenada.equalsIgnoreCase("p65") 
                || coordenada.equalsIgnoreCase("p66")|| coordenada.equalsIgnoreCase("p67")){
            
            
            String temporal [] = coordenada.split("");
        
            int fila = Integer.parseInt(temporal[1]);
            int columna = Integer.parseInt(temporal[2]);

            resultado.add("p" + (fila - 1) + columna);
            resultado.add("p" + (fila - 2) + columna);
            
        }else{
            
            String temporal2 [] = coordenada.split("");
        
            int fila2 = Integer.parseInt(temporal2[1]);
            int columna2 = Integer.parseInt(temporal2[2]);

            //posible movimiento arriba
            if (fila2 - 1 >= 0) {
                resultado.add("p" + (fila2 - 1) + columna2);
            }   
        }

        return resultado;        
    }
    
    public ArrayList <String> moverPeonNegro (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        if(coordenada.equalsIgnoreCase("p10") || coordenada.equalsIgnoreCase("p11") || coordenada.equalsIgnoreCase("p12") 
                || coordenada.equalsIgnoreCase("p13")|| coordenada.equalsIgnoreCase("p14") || coordenada.equalsIgnoreCase("p15") 
                || coordenada.equalsIgnoreCase("p16")|| coordenada.equalsIgnoreCase("p17")){
            
            
            String temporal [] = coordenada.split("");
        
            int fila = Integer.parseInt(temporal[1]);
            int columna = Integer.parseInt(temporal[2]);

            resultado.add("p" + (fila + 1) + columna);
            resultado.add("p" + (fila + 2) + columna);
            
        }else{
            
            String temporal2 [] = coordenada.split("");
        
            int fila2 = Integer.parseInt(temporal2[1]);
            int columna2 = Integer.parseInt(temporal2[2]);

            //posible movimiento arriba
            if (fila2 + 1 < tablero.COLUMNAS) {
                resultado.add("p" + (fila2 + 1) + columna2);
            }   
        }

        return resultado;
        
    }
    
    public ArrayList <String> moverTorre (ArrayList <String> piezasBlancas, String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos derecha
        for (int i = columna + 1 ; i < tablero.FILAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + i + columna)) break;
            resultado.add("p" + i + columna);
        }
        
        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + i + columna)) break;
            resultado.add("p" + i + columna);
        }

        return resultado;
    }
    
    public ArrayList <String> moverAlfil (ArrayList <String> piezasBlancas, String coordenada){

        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila + i) + (columna - i))) break;
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila + i) + (columna + i))) break;
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila - i) + (columna + i))) break;
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila - i) + (columna - i))) break;
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        return resultado;
        
    }
    
    public ArrayList <String> moverDama (ArrayList <String> piezasBlancas, String coordenada){

        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila + i) + (columna - i))) break;
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila + i) + (columna + i))) break;
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila - i) + (columna + i))) break;
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + (fila - i) + (columna - i))) break;
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos derecha
        for (int i = columna + 1 ; i < tablero.FILAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + i + columna)) break;
            resultado.add("p" + i + columna);
        }
        
        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas(piezasBlancas, "p" + i + columna)) break;
            resultado.add("p" + i + columna);
        }
        
        return resultado;
        
    }
    
    public ArrayList <String> moverRey (String coordenada){

        ArrayList <String> resultado = new ArrayList<>();
        
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
        
        return resultado;
        
    }
    
    private boolean filtroPiezasBlancas(ArrayList <String> piezasBlancas, String valorCoordenada){
        
        ArrayList <String> temporal = piezasBlancas;
        
        for (int i = 0; i < temporal.size(); i++) {
            if(temporal.get(i).equalsIgnoreCase(valorCoordenada)) return true;
        }
        
        return false;
        
    }
    
    
    public static void main(String[] args) {
         
        movimientos movimientos = new movimientos();
        
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
        
        ArrayList <String> prueba1 = movimientos.moverTorre(listar, "p70");

        for (int i = 0; i < prueba1.size(); i++) {
            System.out.println(prueba1.get(i));
        } 

    }
}
