package ajedrez;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.util.ArrayList;

/**
 * @author Javier García Arranz
 */
public class movimientos {
    
//    private tablero tablero;
    
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
    
    public ArrayList <String> moverPeon (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        if(fila > 0) resultado.add("p" + (fila - 1) + columna);

        return resultado;
        
    }
    
    public ArrayList <String> moverTorre (String coordenada){
        
        ArrayList <String> resultado = new ArrayList<>();
        
        String temporal [] = coordenada.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        
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
    
    
    public static void main(String[] args) {
        
        movimientos movimientos = new movimientos();
        
        ArrayList <String> listar = movimientos.moverTorre("p21");
        
        for (int i = 0; i < listar.size(); i++) {
            System.out.print(listar.get(i) + " ");
        }
        
//        System.out.println(movimientos.moverPeon("p01"));
        
    }
}
