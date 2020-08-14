package miscelanea;

import ajedrez.tablero;

/**
 * @author Javier García Arranz
 */
public class caballo extends pieza {

    @Override
    public String movimiento() {
        return "Me muevo como un caballo";
        
    }
    
    
    public static void main(String[] args) {
       
       int filas = 3;
       int columnas = 3;
                
        
        int fila = 0;
        int columna = 1;
        

        
        
        if ((fila - 2 >= 0 && fila - 2 < tablero.FILAS) && (columna - 1 >= 0 && columna - 1 < tablero.COLUMNAS)) {
            System.out.println((fila - 2) + " " + (columna - 1));
        }
        if ((fila - 2 >= 0 && fila - 2 < tablero.FILAS) && (columna + 1 >= 0 && columna + 1 < tablero.COLUMNAS)) {
            System.out.println((fila - 2) + " " + (columna + 1));
        }
        if ((fila - 1 >= 0 && fila - 1 < tablero.FILAS) && (columna + 2 >= 0 && columna + 2 < tablero.COLUMNAS)) {
            System.out.println((fila - 1) + " " + (columna + 2));
        }
        if ((fila + 1 >= 0 && fila + 1 < tablero.FILAS) && (columna + 1 >= 0 && columna + 2 < tablero.COLUMNAS)) {
            System.out.println((fila + 1) + " " + (columna + 2));
        }
        if ((fila + 2 >= 0 && fila + 2 < tablero.FILAS) && (columna + 1 >= 0 && columna + 1 < tablero.COLUMNAS)) {
            System.out.println((fila + 2) + " " + (columna + 1));
        }
        if ((fila + 2 >= 0 && fila + 2 < tablero.FILAS) && (columna - 1 >= 0 && columna - 1 < tablero.COLUMNAS)) {
            System.out.println((fila + 2) + " " + (columna - 1));
        }
        if ((fila + 1 >= 0 && fila + 1 < tablero.FILAS) && (columna - 2 >= 0 && columna - 2 < tablero.COLUMNAS)) {
            System.out.println((fila + 1) + " " + (columna - 2));
        }
        if ((fila - 1 >= 0 && fila - 1 < tablero.FILAS) && (columna - 2 >= 0 && columna - 2 < tablero.COLUMNAS)) {
            System.out.println((fila - 1) + " " + (columna - 2));
        }
        
        //        if(fila == 0 && columna == 0){
//            resultado.add("p" + (fila + 2) + (columna + 1));
//            resultado.add("p" + (fila + 1) + (columna + 2));
//        }
//        else if(fila == 0 && columna == 1){
//            resultado.add("p" + (fila + 2) + (columna + 1));
//            resultado.add("p" + (fila + 2) + (columna - 1));
//        }
//        else if(fila == 0 && columna == 2){
//            resultado.add("p" + (fila + 2) + (columna - 1));
//            resultado.add("p" + (fila + 1) + (columna - 2));
//        }
//        else if(fila == 1 && columna == 0){
//            resultado.add("p" + (fila - 1) + (columna + 2));
//            resultado.add("p" + (fila + 1) + (columna + 2));
//        }
//        else if(fila == 1 && columna == 2){
//            resultado.add("p" + (fila - 1) + (columna - 2));
//            resultado.add("p" + (fila + 1) + (columna - 2));
//        }
//        else if(fila == 2 && columna == 0){
//            resultado.add("p" + (fila - 2) + (columna + 1));
//            resultado.add("p" + (fila - 1) + (columna + 2));
//        }
//        else if(fila == 2 && columna == 1){
//            resultado.add("p" + (fila - 2) + (columna + 1));
//            resultado.add("p" + (fila - 2) + (columna - 1));
//        }
//        else if(fila == 2 && columna == 2){
//            resultado.add("p" + (fila - 2) + (columna - 1));
//            resultado.add("p" + (fila - 1) + (columna - 2));
//        }
        
        
    }

}
