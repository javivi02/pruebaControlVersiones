package ajedrez;

import java.util.ArrayList;

/**
 * @author Javier García Arranz
 */
public class movimientos {
    
    private tablero tablero;
    
    public movimientos(){
        
        tablero = new tablero();
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
    
    public ArrayList <String> moverPeonBlanco (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
//        if(fila > 0) resultado.add("p" + (fila - 1) + columna);

        //posible movimiento arriba
        if (fila - 1 >= 0) {
            resultado.add("p" + (fila - 1) + columna);
        }

        return resultado;
        
    }
    
    public ArrayList <String> moverPeonNegro (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posible movimientos abajo
        if (fila + 1 < tablero.COLUMNAS) {
            resultado.add("p" + (fila + 1) + columna);
        }

        return resultado;
        
    }
    
    public ArrayList <String> moverTorre (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if(filtroPiezasBlancas("p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos derecha
        for (int i = columna + 1 ; i < tablero.FILAS; i++) {
            if(filtroPiezasBlancas("p" + fila + i)) break;
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            if(filtroPiezasBlancas("p" + fila + i)) break;
            resultado.add("p" + i + columna);
        }
        
        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
            if(filtroPiezasBlancas("p" + fila + i)) break;
            resultado.add("p" + i + columna);
        }

        return resultado;
    }
    
    public ArrayList <String> moverAlfil (String coordenada){

        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        return resultado;
        
    }
    
    public ArrayList <String> moverDama (String coordenada){

        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);

        //posibles movimientos derecha abajo
        for (int i = 1; fila + i < tablero.FILAS && columna - i >= 0; i++) {
            resultado.add("p" + (fila + i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda abajo
        for (int i = 1; fila + i < tablero.FILAS && columna + i < tablero.COLUMNAS; i++) {
            resultado.add("p" + (fila + i) + (columna + i)); 
        }
        
        //posibles movimientos derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < tablero.COLUMNAS; i++) {
            resultado.add("p" + (fila - i) + (columna + i)); 
        }
        
        //posibles movimientos izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            resultado.add("p" + (fila - i) + (columna - i)); 
        }
        
        //posibles movimientos izquierda
        for (int i = columna - 1; i >= 0; i--) {
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos derecha
        for (int i = columna + 1 ; i < tablero.FILAS; i++) {
            resultado.add("p" + fila + i);
        }
        
        //posibles movimientos arriba
        for (int i = fila - 1; i >= 0; i--) {
            resultado.add("p" + i + columna);
        }
        
        //posibles movimientos abajo
        for (int i = fila + 1; i < tablero.COLUMNAS; i++) {
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
    
    private boolean filtroPiezasBlancas(String valorCoordenada){
        
        ArrayList <String> temporal = tablero.getCoordenadasPiezasBlancas();
        
        for (int i = 0; i < temporal.size(); i++) {
            if(temporal.get(i).equalsIgnoreCase(valorCoordenada)) return true;
        }
        
        return false;
        
    }
    
    
    public static void main(String[] args) {
         
        movimientos movimientos = new movimientos();
        
        ArrayList <String> prueba = movimientos.moverTorre("p70");
        
        for (int i = 0; i < prueba.size(); i++) {
            System.out.print(prueba.get(i) + " ");
        }


        System.out.println("------------------------------");
        
        tablero tablero = new tablero();
        ArrayList <String> listar = tablero.getCoordenadasPiezasBlancas();

        for (int i = 0; i < listar.size(); i++) {
            System.out.println(listar.get(i));
        } 
    }
}
