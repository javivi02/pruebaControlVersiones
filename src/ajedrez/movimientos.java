package ajedrez;

import java.util.ArrayList;

/**
 * @author Javier García Arranz
 */
public class movimientos {
    
    private tablero tablero;
    
//    public movimientos(tablero tablero){
//        
//        this.tablero = tablero;
//    }
    
    public ArrayList <String> moverCaballo(String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        if(fila == 0 && columna == 0){
            resultado.add("p" + (fila + 2) + (columna + 1));
            resultado.add("p" + (fila + 1) + (columna + 2));
        }
        else if(fila == 0 && columna == 1){
            resultado.add("p" + (fila + 2) + (columna + 1));
            resultado.add("p" + (fila + 2) + (columna - 1));
        }
        else if(fila == 0 && columna == 2){
            resultado.add("p" + (fila + 2) + (columna - 1));
            resultado.add("p" + (fila + 1) + (columna - 2));
        }
        else if(fila == 1 && columna == 0){
            resultado.add("p" + (fila - 1) + (columna + 2));
            resultado.add("p" + (fila + 1) + (columna + 2));
        }
        else if(fila == 1 && columna == 2){
            resultado.add("p" + (fila - 1) + (columna - 2));
            resultado.add("p" + (fila + 1) + (columna - 2));
        }
        else if(fila == 2 && columna == 0){
            resultado.add("p" + (fila - 2) + (columna + 1));
            resultado.add("p" + (fila - 1) + (columna + 2));
        }
        else if(fila == 2 && columna == 1){
            resultado.add("p" + (fila - 2) + (columna + 1));
            resultado.add("p" + (fila - 2) + (columna - 1));
        }
        else if(fila == 2 && columna == 2){
            resultado.add("p" + (fila - 2) + (columna - 1));
            resultado.add("p" + (fila - 1) + (columna - 2));
        }
        
        return resultado;
    }
    
        
    
    public static void main(String[] args) {
        
        movimientos movimientos = new movimientos();
        
        ArrayList <String> listar = movimientos.moverCaballo("p00");
        
        for (int i = 0; i < listar.size(); i++) {
            System.out.print(listar.get(i) + " ");
        }
        
    }
}
