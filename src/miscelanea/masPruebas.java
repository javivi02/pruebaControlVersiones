package miscelanea;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Javier García Arranz
 */
public class masPruebas {
    
    
    public static void main(String[] args) {
        
        ArrayList <String> uno = new ArrayList<>();
        ArrayList <String> dos = new ArrayList<>();
        ArrayList <String> total = new ArrayList<>();

        uno.add("01");
        uno.add("22");
        uno.add("20");
        uno.add("11");
        
        dos.add("20");
        dos.add("22");
        dos.add("11");
//        dos.add("01");
        
        for (int i = 0; i < uno.size(); i++) {
            for (int j = 0; j < dos.size(); j++) {
                if(uno.get(i).equalsIgnoreCase(dos.get(j))){
                    dos.remove(j);
                }
            }
        }
        
        
//        for (int i = 0; i < uno.size(); i++) {
//            total.add(uno.get(i));
//        }
        
        for (int i = 0; i < dos.size(); i++) {
            total.add(dos.get(i));
        }
        
        for (int i = 0; i < total.size(); i++) {
            System.out.println(total.get(i));
        }
        
        
//        
//        for (int i = 0; i < uno.size(); i++) {
//            total.add(uno.get(i));
//        }
//        
//        for (int i = 0; i < dos.size(); i++) {
//            total.add(dos.get(i));
//        }
//        
//        for (int i = 0; i < total.size(); i++) {
//            System.out.println(total.get(i));
//        }
//        
//        System.out.println("---------------------");
//        
//        int contador = 0;
//        String indice = "";
//        
//        for (int i = 0; i < total.size(); i++) {
//            for (int j = i + 1; j < total.size(); j++) {
//                if(total.get(i).equalsIgnoreCase(total.get(j))){
//                    indice += i + "" + j;
//                }
//            }
//        }
//        
//        System.out.println(indice);
//        
//        String temporal [] = indice.split("");
//        
//        for (int i = 0; i < temporal.length; i++) {
//            total.remove(Integer.parseInt(temporal[i]));
//        }
//        
//        
//        for (int i = 0; i < total.size(); i++) {
//            System.out.println(total.get(i));
//        }
//
//        //Creamos un objeto HashSet
//        HashSet hs = new HashSet();
//
//        //Lo cargamos con los valores del array, esto hace quite los repetidos
//        hs.addAll(total);
//
//        //Limpiamos el array
//        total.clear();
//
//        //Agregamos los valores sin repetir
//        total.addAll(hs);
//
//        //Imprimimos  el resultado
//        for (int i = 0; i < total.size(); i++) {
//            System.out.println(total.get(i));
//        }
        
    }

}
