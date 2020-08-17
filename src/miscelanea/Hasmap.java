package miscelanea;

import java.util.HashMap;
import java.util.Iterator;

public class Hasmap {
    
    public static void hasmapPrueba(){
        
        HashMap<Integer, String> almacen = new HashMap<>();
        
        almacen.put(1, "Paula");
        almacen.put(2, "Shiva");
        almacen.put(3, "Cocos");
        almacen.put(4, "Coco");
        

//        Iterator recorre = almacen.keySet().iterator();
//        
//        while(recorre.hasNext()){
//            
//            int clave = (int) recorre.next();
//            System.out.println("Clave : " + clave + " / Valor : " + almacen.get(clave));
//            
//        }
//        
//        if (almacen.containsKey(4)) System.out.println("yes");
//        
//        System.out.println("AQUI");

        int resultado = 0;
        
        Iterator recorre = almacen.keySet().iterator();
        
        while(recorre.hasNext()){
            
            int clave = (int) recorre.next();

            if(almacen.get(clave).equalsIgnoreCase("Coco")) resultado = clave;
        }
        
        System.out.println(resultado);
        
        
    }
    
    public static void main(String[] args) {
        hasmapPrueba();
    }

}
