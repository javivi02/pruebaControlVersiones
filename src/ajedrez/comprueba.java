package ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class comprueba {
    
    private interfazGrafica interfazGrafica;
    private tablero tablero;
    private movimientos movimientos;
    
    private int contadorPeonNegro;
    private int contadorCaballoNegro;
    private int contadorAlfilNegro;
    private int contadorTorreNegro;
    
    private int contadorPeonBlanco;
    private int contadorCaballoBlanco;
    private int contadorAlfilBlanco;
    private int contadorTorreBlanco;
    
    private static boolean blancasJaque;
    private static boolean negrasJaque;
    
    public comprueba (tablero tablero, interfazGrafica interfazGrafica, movimientos movimientos){
        
        this.tablero = tablero;
        this.interfazGrafica = interfazGrafica;
        this.movimientos = movimientos;
        
        contadorPeonNegro = 0;
        contadorPeonBlanco = 0;
        contadorCaballoNegro = 0;
        contadorCaballoBlanco = 0;
        contadorAlfilNegro = 0;
        contadorAlfilBlanco = 0;
        contadorTorreNegro = 0;
        contadorTorreBlanco = 0;
        
        
        blancasJaque = false;
        negrasJaque = false;

    }
    
    public void peonDamaBlanco(){
       
       HashMap <String, String> temporal = tablero.piezasTablero();
       
       Iterator recorre = temporal.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();

            if(clave.equalsIgnoreCase("p00") || clave.equalsIgnoreCase("p01") || clave.equalsIgnoreCase("p02")
                    || clave.equalsIgnoreCase("p03") || clave.equalsIgnoreCase("p04")
                    || clave.equalsIgnoreCase("p05") || clave.equalsIgnoreCase("p06")
                    || clave.equalsIgnoreCase("p07")){
                
                if(temporal.get(clave).equalsIgnoreCase(piezas.peonBlanco)){
                    
                    tablero.actualizarTableroReinaBlanca(clave);
                    interfazGrafica.actualizarIconoPeonReinaBlanca(clave);
                    System.out.println("REINA");
                }
            }   
        }
    }
    
    public void peonDamaNegro(){
       
       HashMap <String, String> temporal = tablero.piezasTablero();
       
       Iterator recorre = temporal.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();

            if(clave.equalsIgnoreCase("p70") || clave.equalsIgnoreCase("p71") || clave.equalsIgnoreCase("p72")
                    || clave.equalsIgnoreCase("p73") || clave.equalsIgnoreCase("p74")
                    || clave.equalsIgnoreCase("p75") || clave.equalsIgnoreCase("p76")
                    || clave.equalsIgnoreCase("p77")){
                
                if(temporal.get(clave).equalsIgnoreCase(piezas.peonNegro)){
                    
                    tablero.actualizarTableroReinaNegra(clave);
                    interfazGrafica.actualizarIconoPeonReinaNegra(clave);
                    System.out.println("REINA");
                }
            }   
        }
    }
    
    public boolean finPartida(){
        
        HashMap<String, String> temporal = tablero.piezasTablero();
        
        int contador = 0;

        Iterator recorre = temporal.keySet().iterator();

        while (recorre.hasNext()) {

            String clave = (String) recorre.next();

            if (temporal.get(clave).equalsIgnoreCase(piezas.reyBlanco)) contador ++;
            if (temporal.get(clave).equalsIgnoreCase(piezas.reyNegro)) contador ++;
            
        }

        return contador < 2;
        
    }
    
    public boolean jaqueBlancas (){
        
        ArrayList <String> resultado = this.movimientosNegras();
        
        String coordenadaReyBlanco = this.posicionRey(piezas.reyBlanco);
        
        for (int i = 0; i < resultado.size(); i++) {
            if (resultado.get(i).equalsIgnoreCase(coordenadaReyBlanco)) return true;
        }
        
        return false;
    }
    
    public boolean jaqueNegras (){
        
        ArrayList <String> resultado = this.movimientosBlancas();
        
        String coordenadaReyNegro = this.posicionRey(piezas.reyNegro);
        
        for (int i = 0; i < resultado.size(); i++) {
            if (resultado.get(i).equalsIgnoreCase(coordenadaReyNegro)) return true;
        }
        
        return false;
    }
    
    public ArrayList <String> movimientosNegras(){
        
       ArrayList <String> movimientosNegras = new ArrayList<>();
       ArrayList <String> temporal = tablero.getCoordenadasPiezasNegras();
       String ficha = null;
        
        for (int i = 0; i < temporal.size(); i++) {
            
            ficha = interfazGrafica.getPiezaCoordenadaTablero(temporal.get(i));
            
            switch (ficha){
                
                case piezas.peonNegro: 
                    for (int j = 0; j < movimientos.moverPeonNegro(temporal.get(i), tablero.getCoordenadasPiezasBlancas()).size(); j++) {
                        movimientosNegras.add(movimientos.moverPeonNegro(temporal.get(i), tablero.getCoordenadasPiezasBlancas()).get(j));
                    }
                    break;
                    
                case piezas.torreNegra:
                    for (int j = 0; j < movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosNegras.add(movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;
                    
                case piezas.reyNegro:
                    for (int j = 0; j < movimientos.moverRey(temporal.get(i), piezas.reyBlanco).size(); j++) {
                        movimientosNegras.add(movimientos.moverRey(temporal.get(i), piezas.reyBlanco).get(j));
                    }
                    break;
                    
                case piezas.caballoNegro: 
                    for (int j = 0; j < movimientos.moverCaballo(temporal.get(i)).size(); j++) {
                        movimientosNegras.add(movimientos.moverCaballo(temporal.get(i)).get(j));
                    }
                    break;
                    
                case piezas.alfilNegro: 
                    for (int j = 0; j < movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosNegras.add(movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;
                    
                case piezas.damaNegra: 
                    for (int j = 0; j < movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosNegras.add(movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;   
            }
        }
        
        return movimientosNegras;
    }
    
    public ArrayList <String> movimientosBlancas(){
        
       ArrayList <String> movimientosBlancas = new ArrayList<>();
       ArrayList <String> temporal = tablero.getCoordenadasPiezasBlancas();
       String ficha = null;
        
        for (int i = 0; i < temporal.size(); i++) {
            
            ficha = interfazGrafica.getPiezaCoordenadaTablero(temporal.get(i));
            
            switch (ficha){
                
                case piezas.peonBlanco: 
                    for (int j = 0; j < movimientos.moverPeonBlanco(temporal.get(i), tablero.getCoordenadasPiezasBlancas()).size(); j++) {
                        movimientosBlancas.add(movimientos.moverPeonBlanco(temporal.get(i), tablero.getCoordenadasPiezasBlancas()).get(j));
                    }
                    break;
                    
                case piezas.torreBlanca:
                    for (int j = 0; j < movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosBlancas.add(movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;
                    
                case piezas.reyBlanco:
                    for (int j = 0; j < movimientos.moverRey(temporal.get(i), piezas.reyNegro).size(); j++) {
                        movimientosBlancas.add(movimientos.moverRey(temporal.get(i), piezas.reyNegro).get(j));
                    }
                    break;
                    
                case piezas.caballoBlanco: 
                    for (int j = 0; j < movimientos.moverCaballo(temporal.get(i)).size(); j++) {
                        movimientosBlancas.add(movimientos.moverCaballo(temporal.get(i)).get(j));
                    }
                    break;
                    
                case piezas.alfilBlanco: 
                    for (int j = 0; j < movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosBlancas.add(movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;
                    
                case piezas.damaBlanca: 
                    for (int j = 0; j < movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).size(); j++) {
                        movimientosBlancas.add(movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), temporal.get(i), ficha).get(j));
                    }
                    break;   
            }
        }
        
        return movimientosBlancas;
    }
    
    
    
    private String posicionRey(String tipoRey){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        String resultado = "";
        
        Iterator recorre = temporal.keySet().iterator();
        
        while(recorre.hasNext()){
            
            String clave = (String) recorre.next();

            if(temporal.get(clave).equalsIgnoreCase(tipoRey)){
                resultado = clave;
            }

        }
        
        return resultado;
    }
    
    public boolean coordenadaInicioMenorFinal(String coordenadaInicio, String coordenadaFinal){
        
        String temporal [] = coordenadaInicio.split("");
        
        int fila = Integer.parseInt(temporal[1]);
        int columna = Integer.parseInt(temporal[2]);
        
        int resultado = fila + columna;
        
        String temporal2 [] = coordenadaFinal.split("");
        
        int fila2 = Integer.parseInt(temporal2[1]);
        int columna2 = Integer.parseInt(temporal2[2]);
        
        int resultado2 = fila2 + columna2;
        
        return resultado < resultado2;
        
    }
    
    public boolean enrroqueCortoBlancas(){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        
        int contador = 0;

        Iterator recorre = temporal.keySet().iterator();

        while (recorre.hasNext()) {

            String clave = (String) recorre.next();
            if(clave.equalsIgnoreCase("p77")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.torreBlanca)) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p76")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p75")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p74")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.reyBlanco)) contador ++;
            }

        }
        
        return contador == 4;
        
        
    }
    
    public boolean enrroqueCortoNegras(){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        
        int contador = 0;

        Iterator recorre = temporal.keySet().iterator();

        while (recorre.hasNext()) {

            String clave = (String) recorre.next();
            if(clave.equalsIgnoreCase("p07")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.torreNegra)) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p06")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p05")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p04")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.reyNegro)) contador ++;
            }

        }
        
        return contador == 4;
    }
    
    public boolean enrroqueLargoNegras(){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        
        int contador = 0;

        Iterator recorre = temporal.keySet().iterator();

        while (recorre.hasNext()) {

            String clave = (String) recorre.next();
            if(clave.equalsIgnoreCase("p00")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.torreNegra)) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p01")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p02")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p03")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p04")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.reyNegro)) contador ++;
            }

        }
        
        return contador == 5;
    }
    
    public boolean enrroqueLargoBlancas(){
        
        HashMap <String, String> temporal = tablero.piezasTablero();
        
        int contador = 0;

        Iterator recorre = temporal.keySet().iterator();

        while (recorre.hasNext()) {

            String clave = (String) recorre.next();
            if(clave.equalsIgnoreCase("p70")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.torreBlanca)) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p71")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p72")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p73")){
                if (temporal.get(clave).equalsIgnoreCase("-")) contador ++;
            }
            
            if(clave.equalsIgnoreCase("p74")){
                if (temporal.get(clave).equalsIgnoreCase(piezas.reyBlanco)) contador ++;
            }

        }
        
        return contador == 5;
    }
    
    public void comerFicha(String coordenadaFinal){
        
        String tipoFicha = interfazGrafica.getPiezaCoordenadaTablero(coordenadaFinal);
        
        if(tipoFicha.contains("B")){
            if(!tablero.contenidoCoordenada(coordenadaFinal).equalsIgnoreCase("-")) tablero.eliminarCoordenadasPiezasBlancas(coordenadaFinal);
        }else{
            if(!tablero.contenidoCoordenada(coordenadaFinal).equalsIgnoreCase("-")) tablero.eliminarCoordenadasPiezasNegras(coordenadaFinal);
        }

        switch(tipoFicha){
            
            case piezas.peonNegro: peonUpdate(tipoFicha); break;
            case piezas.caballoNegro: caballoUpdate(tipoFicha); break; 
            case piezas.alfilNegro: alfilUpdate(tipoFicha); break;
            case piezas.torreNegra: torreUpdate(tipoFicha); break;
            case piezas.damaNegra: damaUpdate(tipoFicha); break;
            case piezas.reyNegro: reyUpdate(tipoFicha); break;
            
            case piezas.peonBlanco: peonUpdate(tipoFicha); break;
            case piezas.caballoBlanco: caballoUpdate(tipoFicha); break; 
            case piezas.alfilBlanco: alfilUpdate(tipoFicha); break;
            case piezas.torreBlanca: torreUpdate(tipoFicha); break;
            case piezas.damaBlanca: damaUpdate(tipoFicha); break;
            case piezas.reyBlanco: reyUpdate(tipoFicha); break;
        }
    }
    
    private void peonUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B")){
            
            contadorPeonBlanco++;
        
            interfazGrafica.labelPeonBlanco.setEnabled(true);
            interfazGrafica.textPeonBlanco.setText("X" + contadorPeonBlanco);
            
        } else {
            
            contadorPeonNegro++;
        
            interfazGrafica.labelPeonNegro.setEnabled(true);
            interfazGrafica.textPeonNegro.setText("X" + contadorPeonNegro);
            
        }
    }
    
    private void caballoUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B")){
            
            contadorCaballoBlanco++;
        
            interfazGrafica.labelCaballoBlanco.setEnabled(true);
            interfazGrafica.textCaballoBlanco.setText("X" + contadorCaballoBlanco);
            
        } else {
            
            contadorCaballoNegro++;
        
            interfazGrafica.labelCaballoNegro.setEnabled(true);
            interfazGrafica.textCaballoNegro.setText("X" + contadorCaballoNegro);
            
        }

    }
    
    private void alfilUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B")){
            
            contadorAlfilBlanco++;
        
            interfazGrafica.labelAlfilBlanco.setEnabled(true);
            interfazGrafica.textAlfilBlanco.setText("X" + contadorAlfilBlanco);
            
        } else {
            
            contadorAlfilNegro++;
        
            interfazGrafica.labelAlfilNegro.setEnabled(true);
            interfazGrafica.textAlfilNegro.setText("X" + contadorAlfilNegro);
            
        }

    }
    
    private void torreUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B")){
            
            contadorTorreBlanco++;
        
            interfazGrafica.labelTorreBlanco.setEnabled(true);
            interfazGrafica.textTorreBlanco.setText("X" + contadorTorreBlanco);
            
        } else {
            
            contadorTorreNegro++;
        
            interfazGrafica.labelTorreNegro.setEnabled(true);
            interfazGrafica.textTorreNegro.setText("X" + contadorTorreNegro);
            
        }

    }
    
    private void damaUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B"))  interfazGrafica.labelDamaBlanco.setEnabled(true);
        else interfazGrafica.labelDamaNegro.setEnabled(true);

    }
    
    private void reyUpdate(String tipoFicha){
        
        if(tipoFicha.contains("B"))  interfazGrafica.labelReyBlanco.setEnabled(true);
        else interfazGrafica.labelReyNegro.setEnabled(true);

    }

    public static boolean isBlancasJaque() {
        return blancasJaque;
    }

    public static void setBlancasJaque(boolean jaqueBlancas) {
        comprueba.blancasJaque = jaqueBlancas;
    }

    public static boolean isNegrasJaque() {
        return negrasJaque;
    }

    public static void setNegrasJaque(boolean negrasJaque) {
        comprueba.negrasJaque = negrasJaque;
    }
    
}
