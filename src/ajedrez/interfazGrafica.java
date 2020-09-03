package ajedrez;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jgarciaa
 */
public class interfazGrafica extends javax.swing.JFrame {

    private tablero tablero;
    private movimientos movimientos;
    private comprueba comprueba;
    private turno turno;
    
    private String coordenadaIncio;

    private boolean clickJButton = true;
    private boolean mover = false;
    
    public static int numeroMovimientosReyBlanco;
    public static int numeroMovimientosReyNegro;
    

    /**
     * Creates new form NewJFrame
     */
    
    public interfazGrafica() {
        
        initComponents();
        
        tablero = new tablero();
        movimientos = new movimientos(tablero, this);
        turno = new turno();
        comprueba = new comprueba(tablero, this, movimientos);
        
        this.setLocationRelativeTo(null);
        
        numeroMovimientosReyBlanco = 0;
        numeroMovimientosReyNegro = 0;
        
        textInfo.setText(turno.turnoActual().toUpperCase());
        
//        this.p00.setEnabled(false);
    }
    
    /**
     * Devuelve el tipo de ficha en funcion de la coordenada pasada
     * 
     * @param coordenada
     * @return 
     */
    
    public String getPiezaCoordenadaTablero(String coordenada){
          
        return tablero.contenidoCoordenada(coordenada);
    }
    
    private void marcaMovimientoTablero(String coordenada){

        String tipoFicha = getPiezaCoordenadaTablero(coordenada);
        
        switch (tipoFicha) {
            case piezas.caballoBlanco: marcaCasillasCaballo(coordenada, tipoFicha);break;
            case piezas.peonBlanco: marcaCasillasPeonBlanco(coordenada); break;
            case piezas.torreBlanca: marcaCasillasTorre(coordenada, tipoFicha); break;
            case piezas.alfilBlanco: marcaCasillasAlfil(coordenada, tipoFicha); break;              
            case piezas.damaBlanca: marcaCasillasDama(coordenada, tipoFicha); break;
            case piezas.reyBlanco: marcaCasillasRey(coordenada, tipoFicha); break;
            
            case piezas.peonNegro: marcaCasillasPeonNegro(coordenada); break;
            case piezas.torreNegra: marcaCasillasTorre(coordenada, tipoFicha); break;
            case piezas.alfilNegro: marcaCasillasAlfil(coordenada, tipoFicha); break;              
            case piezas.damaNegra: marcaCasillasDama(coordenada, tipoFicha); break;
            case piezas.reyNegro: marcaCasillasRey(coordenada, tipoFicha); break;
            case piezas.caballoNegro: marcaCasillasCaballo(coordenada, tipoFicha);break;
            
            case "-": System.out.println("NADA") ;break;
        }
    }
    
    private void marcaCasillasCaballo(String coordenada, String tipoFicha){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        if(tipoFicha.contains("B")) temporal = filtroCoordenadasPiezas(movimientos.moverCaballo(coordenada), tablero.getCoordenadasPiezasBlancas());
        else temporal = filtroCoordenadasPiezas(movimientos.moverCaballo(coordenada), tablero.getCoordenadasPiezasNegras());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }
        
    }
    
    private void marcaCasillasPeonBlanco(String coordenada){

        ArrayList<String> temporal = new ArrayList<>();
        temporal = filtroCoordenadasPiezas(movimientos.moverPeonBlanco(coordenada, tablero.getCoordenadasPiezasNegras()), tablero.getCoordenadasPiezasBlancas());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }
  
    }
    
    private void marcaCasillasPeonNegro(String coordenada){

        ArrayList<String> temporal = new ArrayList<>();
        temporal = filtroCoordenadasPiezas(movimientos.moverPeonNegro(coordenada, tablero.getCoordenadasPiezasBlancas()), tablero.getCoordenadasPiezasNegras());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }
  
    }
    
    private void marcaCasillasTorre(String coordenada, String tipoFicha){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        //temporal = filtroCoordenadasPiezasBlancas(movimientos.moverTorre(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        temporal = movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenada, tipoFicha);
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }

    }
    
    private void marcaCasillasAlfil(String coordenada, String tipoFicha){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        //temporal = filtroCoordenadasPiezasBlancas(movimientos.moverAlfil(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        temporal = movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenada, tipoFicha);
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }

    }
    
    private void marcaCasillasDama(String coordenada, String tipoFicha){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        //temporal = filtroCoordenadasPiezasBlancas(movimientos.moverDama(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        temporal = movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenada, tipoFicha);
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }

    }
    
    private void marcaCasillasRey(String coordenada, String tipoFicha){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        if(tipoFicha.contains("B")) temporal = filtroCoordenadasPiezas(movimientos.moverRey(coordenada, tipoFicha), tablero.getCoordenadasPiezasBlancas());
        else temporal = filtroCoordenadasPiezas(movimientos.moverRey(coordenada, tipoFicha), tablero.getCoordenadasPiezasNegras());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }

    }
    
    public void actualizarIconoPeonReinaBlanca(String coordenada){
        
        coordenadaJButton(coordenada).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wq.png")));
    }
    
    public void actualizarIconoPeonReinaNegra(String coordenada){
        
        coordenadaJButton(coordenada).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bq.png")));
    }
    
    public void moverTorreBlancaEnrroqueCorto(){
        
        tablero.actualizarTorreBlancaEnrroqueCorto();
        tablero.actualizarCoordenadasPiezasBlancas("p77", "p75");
        tablero.actualizarCoordenada("p77", "p75");
        coordenadaJButton("p77").setIcon(null);
        coordenadaJButton("p75").setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); 
    }
    
    public void moverTorreNegraEnrroqueCorto(){
        
        tablero.actualizarTorreNegraEnrroqueCorto();
        tablero.actualizarCoordenadasPiezasNegras("p07", "p05");
        tablero.actualizarCoordenada("p07", "p05");
        coordenadaJButton("p07").setIcon(null);
        coordenadaJButton("p05").setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png"))); 
    }
    
    public void moverTorreBlancaEnrroqueLargo(){
        
        tablero.actualizarTorreBlancaEnrroqueLargo();
        tablero.actualizarCoordenadasPiezasBlancas("p70", "p73");
        tablero.actualizarCoordenada("p70", "p73");
        coordenadaJButton("p70").setIcon(null);
        coordenadaJButton("p73").setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); 
    }
    
    public void moverTorreNegraEnrroqueLargo(){
        
        tablero.actualizarTorreNegraEnrroqueLargo();
        tablero.actualizarCoordenadasPiezasNegras("p00", "p03");
        tablero.actualizarCoordenada("p00", "p03");
        coordenadaJButton("p00").setIcon(null);
        coordenadaJButton("p03").setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png"))); 
    }
    
    /**
     * Filtro los movimientos posibles en funcion de la ocupacion de las casillas del mismo color.
     * Solo para peon y caballo. Habria que llevarlo a la clase movimientos
     * 
     * @param movimientos Posibles de movimientos de la pieza a consultar
     * @param piezas Ocupacion de las piezas del mismo color para que haga la comparacion
     * @return 
     */
    
    private ArrayList <String> filtroCoordenadasPiezas(ArrayList <String> movimientos, ArrayList <String> piezas){
        
        ArrayList <String> resultado = new ArrayList<>();

        // Recorro ambos ArrayList, busco coincidencias y las elimino de movimientos. Agrego movimientos a resultado
        for (int i = 0; i < piezas.size(); i++) {
            for (int j = 0; j < movimientos.size(); j++) {
                if(piezas.get(i).equalsIgnoreCase(movimientos.get(j))){
                    movimientos.remove(j);
                }
            }
        }
        
        for (int i = 0; i < movimientos.size(); i++) {
            resultado.add(movimientos.get(i));
        }
        
        return resultado;
    }
    
    private void seleccionarJButton(){
        
        if (clickJButton) {

            clickJButton = false;
            mover = true;
            

        }else {
            
            resetearBackgroud();
            clickJButton = true;  
            mover = false;
            coordenadaIncio = null;
        }
        
    }
    
    public void cambiarTurno(){
        
        turno.cambiarTurno();
        indicaTurnoCasillaInfo();
        
    }
    
    private void indicaTurnoCasillaInfo(){
        
        String temporal = turno.turnoActual();
        
        if (temporal.equalsIgnoreCase("blancas"))this.textInfo.setText("BLANCAS");
        if (temporal.equalsIgnoreCase("negras"))this.textInfo.setText("NEGRAS");
        
    }

    /**
     * Compruebo si la coordenada marcada corresponde al turno actual
     * 
     * @param coordenada
     * @return 
     */
    
    public boolean compruebaTurno(String coordenada){
        
        String temporal = turno.turnoActual();
        String color = "";
        
        if (coordenadasTurnoBlanca(coordenada)) color = "blancas";
        else if (coordenadasTurnoNegra(coordenada)) color = "negras";
        
        
        return temporal.equalsIgnoreCase(color);
    }
    
    /**
     * Compruebo si la coordenada marcada pertenece a las piezas blancas
     * 
     * @param coordenada
     * @return 
     */
    
    private boolean coordenadasTurnoBlanca (String coordenada){
        
        ArrayList <String> resultado = tablero.getCoordenadasPiezasBlancas();
        
        for (int i = 0; i < resultado.size(); i++) {

            if (resultado.get(i).equalsIgnoreCase(coordenada)) return true;
        }
        
        return false;
    }
    
    /**
     * Compruebo si la coordenada marcada pertenece a las piezas negras
     * 
     * @param coordenada
     * @return 
     */
    
    private boolean coordenadasTurnoNegra (String coordenada){
        
        ArrayList <String> resultado = tablero.getCoordenadasPiezasNegras();
        
        for (int i = 0; i < resultado.size(); i++) {

            if (resultado.get(i).equalsIgnoreCase(coordenada)) return true;
        }
        
        return false;
    }
    
   
    private JButton coordenadaJButton(String valor){
        
        JButton resultado = null;
        
        String opcion = valor;
        
        switch (opcion) {
            case "p00":  return p00;
            case "p01":  return p01;
            case "p02":  return p02;
            case "p03":  return p03;
            case "p04":  return p04;
            case "p05":  return p05;
            case "p06":  return p06;
            case "p07":  return p07;
            
            case "p10":  return p10;
            case "p11":  return p11;
            case "p12":  return p12;
            case "p13":  return p13;
            case "p14":  return p14;
            case "p15":  return p15;
            case "p16":  return p16;
            case "p17":  return p17;
            
            case "p20":  return p20;
            case "p21":  return p21;
            case "p22":  return p22;
            case "p23":  return p23;
            case "p24":  return p24;
            case "p25":  return p25;
            case "p26":  return p26;
            case "p27":  return p27;
            
            case "p30":  return p30;
            case "p31":  return p31;
            case "p32":  return p32;
            case "p33":  return p33;
            case "p34":  return p34;
            case "p35":  return p35;
            case "p36":  return p36;
            case "p37":  return p37;
            
            case "p40":  return p40;
            case "p41":  return p41;
            case "p42":  return p42;
            case "p43":  return p43;
            case "p44":  return p44;
            case "p45":  return p45;
            case "p46":  return p46;
            case "p47":  return p47;
            
            case "p50":  return p50;
            case "p51":  return p51;
            case "p52":  return p52;
            case "p53":  return p53;
            case "p54":  return p54;
            case "p55":  return p55;
            case "p56":  return p56;
            case "p57":  return p57;
            
            case "p60":  return p60;
            case "p61":  return p61;
            case "p62":  return p62;
            case "p63":  return p63;
            case "p64":  return p64;
            case "p65":  return p65;
            case "p66":  return p66;
            case "p67":  return p67;
            
            case "p70":  return p70;
            case "p71":  return p71;
            case "p72":  return p72;
            case "p73":  return p73;
            case "p74":  return p74;
            case "p75":  return p75;
            case "p76":  return p76;
            case "p77":  return p77;
            
            default:     return resultado;
                          
        }
    }
    
    private void resetPanel(){
        
        this.textInfo.setText("");
    }
    
    private void resetearBackgroud(){
        
        p00.setBackground(null);
        p01.setBackground(null);
        p02.setBackground(null);
        p03.setBackground(null);
        p04.setBackground(null);
        p05.setBackground(null);
        p06.setBackground(null);
        p07.setBackground(null);
        
        p10.setBackground(null);
        p11.setBackground(null);
        p12.setBackground(null);
        p13.setBackground(null);
        p14.setBackground(null);
        p15.setBackground(null);
        p16.setBackground(null);
        p17.setBackground(null);
        
        p20.setBackground(null);
        p21.setBackground(null);
        p22.setBackground(null);
        p23.setBackground(null);
        p24.setBackground(null);
        p25.setBackground(null);
        p26.setBackground(null);
        p27.setBackground(null);
        
        p30.setBackground(null);
        p31.setBackground(null);
        p32.setBackground(null);
        p33.setBackground(null);
        p34.setBackground(null);
        p35.setBackground(null);
        p36.setBackground(null);
        p37.setBackground(null);
        
        p40.setBackground(null);
        p41.setBackground(null);
        p42.setBackground(null);
        p43.setBackground(null);
        p44.setBackground(null);
        p45.setBackground(null);
        p46.setBackground(null);
        p47.setBackground(null);
        
        p50.setBackground(null);
        p51.setBackground(null);
        p52.setBackground(null);
        p53.setBackground(null);
        p54.setBackground(null);
        p55.setBackground(null);
        p56.setBackground(null);
        p57.setBackground(null);
        
        p60.setBackground(null);
        p61.setBackground(null);
        p62.setBackground(null);
        p63.setBackground(null);
        p64.setBackground(null);
        p65.setBackground(null);
        p66.setBackground(null);
        p67.setBackground(null);
        
        p70.setBackground(null);
        p71.setBackground(null);
        p72.setBackground(null);
        p73.setBackground(null);
        p74.setBackground(null);
        p75.setBackground(null);
        p76.setBackground(null);
        p77.setBackground(null);
        
        
    }
    
    private void mover(String coordenadaInicio, String coordenadaFinal){
        
        if (mover){
            
            String tipoFicha = getPiezaCoordenadaTablero(coordenadaInicio);
        
            switch (tipoFicha) {
                
                case piezas.caballoBlanco: moverCaballo(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.peonBlanco: moverPeonBlanco(coordenadaInicio, coordenadaFinal); break;
                case piezas.torreBlanca: moverTorre(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.alfilBlanco: moverAlfil(coordenadaInicio, coordenadaFinal, tipoFicha); break;             
                case piezas.damaBlanca: moverDama(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.reyBlanco: moverRey(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                
                case piezas.peonNegro: moverPeonNegro(coordenadaInicio, coordenadaFinal); break;
                case piezas.torreNegra: moverTorre(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.reyNegro: moverRey(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.caballoNegro: moverCaballo(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.alfilNegro: moverAlfil(coordenadaInicio, coordenadaFinal, tipoFicha); break;
                case piezas.damaNegra: moverDama(coordenadaInicio, coordenadaFinal, tipoFicha); break;
            }
        }
        
    }
    
    private void moverCaballo(String coordenadaInicio, String coordenadaFinal, String tipoFicha) {

        ArrayList<String> temporal = new ArrayList<>();
        
        if(tipoFicha.contains("B")) temporal = filtroCoordenadasPiezas(movimientos.moverCaballo(coordenadaInicio), tablero.getCoordenadasPiezasBlancas());
        else temporal = filtroCoordenadasPiezas(movimientos.moverCaballo(coordenadaInicio), tablero.getCoordenadasPiezasNegras());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                
                if(tipoFicha.contains("B")){
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png")));
                    tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                    
                }else {
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bn.png")));
                    tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);
                }
                
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                
                cambiarTurno();


            }
        }
    }
    
    private void moverPeonBlanco(String coordenadaInicio, String coordenadaFinal){
        
        ArrayList<String> temporal = filtroCoordenadasPiezas(movimientos.moverPeonBlanco(coordenadaInicio, tablero.getCoordenadasPiezasNegras()), tablero.getCoordenadasPiezasBlancas());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                comprueba.comerFicha(coordenadaFinal);
                coordenadaJButton(coordenadaIncio).setIcon(null);
                coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png")));
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                comprueba.peonDamaBlanco();
                
                cambiarTurno();

            }
        }
    }
    
    private void moverPeonNegro(String coordenadaInicio, String coordenadaFinal){
        
        ArrayList<String> temporal = filtroCoordenadasPiezas(movimientos.moverPeonNegro(coordenadaInicio, tablero.getCoordenadasPiezasBlancas()), tablero.getCoordenadasPiezasNegras());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                comprueba.comerFicha(coordenadaFinal);
                coordenadaJButton(coordenadaIncio).setIcon(null);
                coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png")));
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                comprueba.peonDamaNegro();
                
                cambiarTurno();

            }
        }
    }
    
    private void moverTorre(String coordenadaInicio, String coordenadaFinal, String tipoFicha) {

        ArrayList<String> temporal = movimientos.moverTorre(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenadaInicio, tipoFicha);

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                
                if(tipoFicha.contains("B")){
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png")));
                    tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                    
                }else{
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png")));
                    tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);

                }
                
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                
                cambiarTurno();

            }
        }
    }
    
    private void moverAlfil(String coordenadaInicio, String coordenadaFinal, String tipoFicha) {

        ArrayList<String> temporal = movimientos.moverAlfil(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenadaInicio, tipoFicha);

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                
                if (tipoFicha.contains("B")){
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wb.png")));
                    tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                    
                }else{
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bb.png")));
                    tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);
                    
                }

                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                
                cambiarTurno();

            }
        }
    }
    
    private void moverDama(String coordenadaInicio, String coordenadaFinal, String tipoFicha) {

        ArrayList<String> temporal = movimientos.moverDama(tablero.getCoordenadasPiezasBlancas(), tablero.getCoordenadasPiezasNegras(), coordenadaInicio, tipoFicha);    
        
        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                
                if (tipoFicha.contains("B")){
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wq.png")));
                    tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                    
                }else{
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bq.png")));
                    tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);

                }
                
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                
                cambiarTurno();

            }
        }
    }
    
    private void moverRey(String coordenadaInicio, String coordenadaFinal, String tipoFicha) {
        
        System.out.println(coordenadaInicio);
        System.out.println(coordenadaFinal);

        ArrayList<String> temporal = new ArrayList<>();
        
        if(tipoFicha.contains("B")) temporal = filtroCoordenadasPiezas(movimientos.moverRey(coordenadaInicio, tipoFicha), tablero.getCoordenadasPiezasBlancas());
        else temporal = filtroCoordenadasPiezas(movimientos.moverRey(coordenadaInicio, tipoFicha), tablero.getCoordenadasPiezasNegras());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                
                if(tipoFicha.contains("B")){
                   
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wk.png")));
                    tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                    
                    // En el caso de que halla posible enroque largo y corto a la vez, para que entre en no u en otro
                    if(comprueba.coordenadaInicioMenorFinal(coordenadaInicio, coordenadaFinal)){
                        
                        if(movimientos.isEnrroqueCortoBlancas()) {
                            
                            moverTorreBlancaEnrroqueCorto();
                            movimientos.setEnrroqueCortoBlancas(false);
                            movimientos.setEnrroqueLargoBlancas(false);
                        }
                        
                    }else{
                        
                        if(movimientos.isEnrroqueLargoBlancas()){
                            
                            moverTorreBlancaEnrroqueLargo();
                            movimientos.setEnrroqueLargoBlancas(false);
                            movimientos.setEnrroqueCortoBlancas(false);
                        }
                        
                    }
                    
                    numeroMovimientosReyBlanco++;
  
                }else{
                    
                    comprueba.comerFicha(coordenadaFinal);
                    coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bk.png")));
                    tablero.actualizarCoordenadasPiezasNegras(coordenadaInicio, coordenadaFinal);

                    // En el caso de que halla posible enroque largo y corto a la vez, para que entre en no u en otro
                    if(comprueba.coordenadaInicioMenorFinal(coordenadaInicio, coordenadaFinal)){
                        
                        if (movimientos.isEnrroqueCortoNegras()) {
                            moverTorreNegraEnrroqueCorto();
                            movimientos.setEnrroqueCortoNegras(false);
                            movimientos.setEnrroqueLargoNegras(false);
                        }

                    } else {
                        
                        if (movimientos.isEnrroqueLargoNegras()) {
                            moverTorreNegraEnrroqueLargo();
                            movimientos.setEnrroqueLargoNegras(false);
                            movimientos.setEnrroqueCortoNegras(false);
                        }
                    }
                    
                    numeroMovimientosReyNegro++;
                }

                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.mostrarTableroConsola();
                
                cambiarTurno();

            }
        }
    }
    
    private void pasosAlHacerClick(String coordenada){
        
        mover(coordenadaIncio, coordenada);
        
        turnoToca(coordenada);
        
        compruebaJaque();
        
        finJuego();
        
    }
    
    private void turnoToca(String coordenada){
        
        
        if(compruebaTurno(coordenada)){
            
            coordenadaIncio = coordenada;
            marcaMovimientoTablero(coordenada);
            seleccionarJButton();
            
        }else{
            
            //Ajusto para cuando haga click en una casilla y tengo seleccionada una posicion marcada
            mover = false;
            clickJButton = true;
            resetearBackgroud();
            
            textInfo.setText(turno.turnoActual().toUpperCase());
        }
    }
    
    private void compruebaJaque(){
        
        if(comprueba.jaqueBlancas()){
            
            System.out.println("JAQUE REY BLANCO");
            textInfo1.setText("JAQUE !!! REY BLANCO");
            comprueba.setBlancasJaque(true); // Para activar o desactivar enrroque
            
        } else{
            
            comprueba.setBlancasJaque(false);
            textInfo1.setText("");
        }
        
        
        if(comprueba.jaqueNegras()){
            
            System.out.println("JAQUE REY NEGRO");
            textInfo1.setText("JAQUE !!! REY NEGRO");
            comprueba.setNegrasJaque(true); // Para activar o desactivar enrroque
            
        } else comprueba.setNegrasJaque(false);
        
    }
    
    private void finJuego(){
        
        if(comprueba.finPartida()){
            
            turno.cambiarTurno(); //Ajusto el turno tras el ultimo movimiento
            JOptionPane.showMessageDialog(this, "FIN DE JUEGO, GANAN : " + turno.turnoActual().toUpperCase());
            this.dispose();
        }
        
    }

    public int getNumeroMovimientosReyBlanco() {
        return numeroMovimientosReyBlanco;
    }

    public int getNumeroMovimientosReyNegro() {
        return numeroMovimientosReyNegro;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        p00 = new javax.swing.JButton();
        p01 = new javax.swing.JButton();
        p02 = new javax.swing.JButton();
        p03 = new javax.swing.JButton();
        p04 = new javax.swing.JButton();
        p05 = new javax.swing.JButton();
        p06 = new javax.swing.JButton();
        p07 = new javax.swing.JButton();
        p10 = new javax.swing.JButton();
        p11 = new javax.swing.JButton();
        p12 = new javax.swing.JButton();
        p13 = new javax.swing.JButton();
        p14 = new javax.swing.JButton();
        p15 = new javax.swing.JButton();
        p16 = new javax.swing.JButton();
        p17 = new javax.swing.JButton();
        p20 = new javax.swing.JButton();
        p21 = new javax.swing.JButton();
        p22 = new javax.swing.JButton();
        p23 = new javax.swing.JButton();
        p24 = new javax.swing.JButton();
        p25 = new javax.swing.JButton();
        p26 = new javax.swing.JButton();
        p27 = new javax.swing.JButton();
        p30 = new javax.swing.JButton();
        p31 = new javax.swing.JButton();
        p32 = new javax.swing.JButton();
        p33 = new javax.swing.JButton();
        p34 = new javax.swing.JButton();
        p35 = new javax.swing.JButton();
        p36 = new javax.swing.JButton();
        p37 = new javax.swing.JButton();
        p40 = new javax.swing.JButton();
        p41 = new javax.swing.JButton();
        p42 = new javax.swing.JButton();
        p43 = new javax.swing.JButton();
        p44 = new javax.swing.JButton();
        p45 = new javax.swing.JButton();
        p46 = new javax.swing.JButton();
        p47 = new javax.swing.JButton();
        p50 = new javax.swing.JButton();
        p51 = new javax.swing.JButton();
        p52 = new javax.swing.JButton();
        p53 = new javax.swing.JButton();
        p54 = new javax.swing.JButton();
        p55 = new javax.swing.JButton();
        p56 = new javax.swing.JButton();
        p57 = new javax.swing.JButton();
        p60 = new javax.swing.JButton();
        p61 = new javax.swing.JButton();
        p62 = new javax.swing.JButton();
        p63 = new javax.swing.JButton();
        p64 = new javax.swing.JButton();
        p65 = new javax.swing.JButton();
        p66 = new javax.swing.JButton();
        p67 = new javax.swing.JButton();
        p70 = new javax.swing.JButton();
        p71 = new javax.swing.JButton();
        p72 = new javax.swing.JButton();
        p73 = new javax.swing.JButton();
        p74 = new javax.swing.JButton();
        p75 = new javax.swing.JButton();
        p76 = new javax.swing.JButton();
        p77 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textInfo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        labelPeonNegro = new javax.swing.JLabel();
        textPeonNegro = new javax.swing.JTextField();
        labelCaballoNegro = new javax.swing.JLabel();
        textCaballoNegro = new javax.swing.JTextField();
        labelAlfilNegro = new javax.swing.JLabel();
        textAlfilNegro = new javax.swing.JTextField();
        labelTorreNegro = new javax.swing.JLabel();
        textTorreNegro = new javax.swing.JTextField();
        labelDamaNegro = new javax.swing.JLabel();
        textDamaNegro = new javax.swing.JTextField();
        labelReyNegro = new javax.swing.JLabel();
        textReyNegro = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        labelPeonBlanco = new javax.swing.JLabel();
        textPeonBlanco = new javax.swing.JTextField();
        labelCaballoBlanco = new javax.swing.JLabel();
        textCaballoBlanco = new javax.swing.JTextField();
        labelAlfilBlanco = new javax.swing.JLabel();
        textAlfilBlanco = new javax.swing.JTextField();
        labelTorreBlanco = new javax.swing.JLabel();
        textTorreBlanco = new javax.swing.JTextField();
        labelDamaBlanco = new javax.swing.JLabel();
        textDamaBlanco = new javax.swing.JTextField();
        labelReyBlanco = new javax.swing.JLabel();
        textReyBlanco = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        textInfo1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(8, 8));

        p00.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png"))); // NOI18N
        p00.setFocusable(false);
        p00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p00ActionPerformed(evt);
            }
        });
        jPanel1.add(p00);

        p01.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bn.png"))); // NOI18N
        p01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p01ActionPerformed(evt);
            }
        });
        jPanel1.add(p01);

        p02.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bb.png"))); // NOI18N
        p02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p02ActionPerformed(evt);
            }
        });
        jPanel1.add(p02);

        p03.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bq.png"))); // NOI18N
        p03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p03ActionPerformed(evt);
            }
        });
        jPanel1.add(p03);

        p04.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bk.png"))); // NOI18N
        p04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p04ActionPerformed(evt);
            }
        });
        jPanel1.add(p04);

        p05.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bb.png"))); // NOI18N
        p05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p05ActionPerformed(evt);
            }
        });
        jPanel1.add(p05);

        p06.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bn.png"))); // NOI18N
        p06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p06ActionPerformed(evt);
            }
        });
        jPanel1.add(p06);

        p07.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png"))); // NOI18N
        p07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p07ActionPerformed(evt);
            }
        });
        jPanel1.add(p07);

        p10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p10ActionPerformed(evt);
            }
        });
        jPanel1.add(p10);

        p11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p11ActionPerformed(evt);
            }
        });
        jPanel1.add(p11);

        p12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p12ActionPerformed(evt);
            }
        });
        jPanel1.add(p12);

        p13.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p13ActionPerformed(evt);
            }
        });
        jPanel1.add(p13);

        p14.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p14ActionPerformed(evt);
            }
        });
        jPanel1.add(p14);

        p15.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p15ActionPerformed(evt);
            }
        });
        jPanel1.add(p15);

        p16.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p16ActionPerformed(evt);
            }
        });
        jPanel1.add(p16);

        p17.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        p17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p17ActionPerformed(evt);
            }
        });
        jPanel1.add(p17);

        p20.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p20ActionPerformed(evt);
            }
        });
        jPanel1.add(p20);

        p21.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p21ActionPerformed(evt);
            }
        });
        jPanel1.add(p21);

        p22.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p22ActionPerformed(evt);
            }
        });
        jPanel1.add(p22);

        p23.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p23ActionPerformed(evt);
            }
        });
        jPanel1.add(p23);

        p24.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p24ActionPerformed(evt);
            }
        });
        jPanel1.add(p24);

        p25.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p25ActionPerformed(evt);
            }
        });
        jPanel1.add(p25);

        p26.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p26ActionPerformed(evt);
            }
        });
        jPanel1.add(p26);

        p27.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p27ActionPerformed(evt);
            }
        });
        jPanel1.add(p27);

        p30.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p30ActionPerformed(evt);
            }
        });
        jPanel1.add(p30);

        p31.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p31ActionPerformed(evt);
            }
        });
        jPanel1.add(p31);

        p32.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p32ActionPerformed(evt);
            }
        });
        jPanel1.add(p32);

        p33.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p33ActionPerformed(evt);
            }
        });
        jPanel1.add(p33);

        p34.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p34ActionPerformed(evt);
            }
        });
        jPanel1.add(p34);

        p35.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p35ActionPerformed(evt);
            }
        });
        jPanel1.add(p35);

        p36.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p36ActionPerformed(evt);
            }
        });
        jPanel1.add(p36);

        p37.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p37ActionPerformed(evt);
            }
        });
        jPanel1.add(p37);

        p40.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p40ActionPerformed(evt);
            }
        });
        jPanel1.add(p40);

        p41.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p41ActionPerformed(evt);
            }
        });
        jPanel1.add(p41);

        p42.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p42ActionPerformed(evt);
            }
        });
        jPanel1.add(p42);

        p43.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p43ActionPerformed(evt);
            }
        });
        jPanel1.add(p43);

        p44.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p44ActionPerformed(evt);
            }
        });
        jPanel1.add(p44);

        p45.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p45ActionPerformed(evt);
            }
        });
        jPanel1.add(p45);

        p46.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p46ActionPerformed(evt);
            }
        });
        jPanel1.add(p46);

        p47.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p47ActionPerformed(evt);
            }
        });
        jPanel1.add(p47);

        p50.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p50ActionPerformed(evt);
            }
        });
        jPanel1.add(p50);

        p51.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p51ActionPerformed(evt);
            }
        });
        jPanel1.add(p51);

        p52.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p52ActionPerformed(evt);
            }
        });
        jPanel1.add(p52);

        p53.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p53ActionPerformed(evt);
            }
        });
        jPanel1.add(p53);

        p54.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p54ActionPerformed(evt);
            }
        });
        jPanel1.add(p54);

        p55.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p55ActionPerformed(evt);
            }
        });
        jPanel1.add(p55);

        p56.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p56ActionPerformed(evt);
            }
        });
        jPanel1.add(p56);

        p57.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p57ActionPerformed(evt);
            }
        });
        jPanel1.add(p57);

        p60.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p60ActionPerformed(evt);
            }
        });
        jPanel1.add(p60);

        p61.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p61ActionPerformed(evt);
            }
        });
        jPanel1.add(p61);

        p62.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p62ActionPerformed(evt);
            }
        });
        jPanel1.add(p62);

        p63.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p63ActionPerformed(evt);
            }
        });
        jPanel1.add(p63);

        p64.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p64ActionPerformed(evt);
            }
        });
        jPanel1.add(p64);

        p65.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p65ActionPerformed(evt);
            }
        });
        jPanel1.add(p65);

        p66.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p66ActionPerformed(evt);
            }
        });
        jPanel1.add(p66);

        p67.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p67ActionPerformed(evt);
            }
        });
        jPanel1.add(p67);

        p70.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); // NOI18N
        p70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p70ActionPerformed(evt);
            }
        });
        jPanel1.add(p70);

        p71.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png"))); // NOI18N
        p71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p71ActionPerformed(evt);
            }
        });
        jPanel1.add(p71);

        p72.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wb.png"))); // NOI18N
        p72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p72ActionPerformed(evt);
            }
        });
        jPanel1.add(p72);

        p73.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wq.png"))); // NOI18N
        p73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p73ActionPerformed(evt);
            }
        });
        jPanel1.add(p73);

        p74.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wk.png"))); // NOI18N
        p74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p74ActionPerformed(evt);
            }
        });
        jPanel1.add(p74);

        p75.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wb.png"))); // NOI18N
        p75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p75ActionPerformed(evt);
            }
        });
        jPanel1.add(p75);

        p76.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png"))); // NOI18N
        p76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p76ActionPerformed(evt);
            }
        });
        jPanel1.add(p76);

        p77.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); // NOI18N
        p77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p77ActionPerformed(evt);
            }
        });
        jPanel1.add(p77);

        jPanel3.setLayout(new java.awt.GridLayout(8, 0));

        jPanel2.setLayout(new java.awt.GridLayout(1, 8));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("B");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("C");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("D");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("E");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("F");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("G");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("H");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("1");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("2");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("3");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("4");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("5");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("6");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("7");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("8");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textInfo.setBackground(new java.awt.Color(204, 204, 204));
        textInfo.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 16)); // NOI18N
        textInfo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 16)); // NOI18N
        jLabel9.setText("TURNO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(6, 2));

        labelPeonNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bp.png"))); // NOI18N
        labelPeonNegro.setEnabled(false);
        jPanel5.add(labelPeonNegro);

        textPeonNegro.setBackground(new java.awt.Color(204, 204, 204));
        textPeonNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textPeonNegro);

        labelCaballoNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bn.png"))); // NOI18N
        labelCaballoNegro.setEnabled(false);
        jPanel5.add(labelCaballoNegro);

        textCaballoNegro.setBackground(new java.awt.Color(204, 204, 204));
        textCaballoNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textCaballoNegro);

        labelAlfilNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bb.png"))); // NOI18N
        labelAlfilNegro.setEnabled(false);
        jPanel5.add(labelAlfilNegro);

        textAlfilNegro.setBackground(new java.awt.Color(204, 204, 204));
        textAlfilNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textAlfilNegro);

        labelTorreNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/br.png"))); // NOI18N
        labelTorreNegro.setEnabled(false);
        jPanel5.add(labelTorreNegro);

        textTorreNegro.setBackground(new java.awt.Color(204, 204, 204));
        textTorreNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textTorreNegro);

        labelDamaNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bq.png"))); // NOI18N
        labelDamaNegro.setEnabled(false);
        jPanel5.add(labelDamaNegro);

        textDamaNegro.setBackground(new java.awt.Color(204, 204, 204));
        textDamaNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textDamaNegro);

        labelReyNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bk.png"))); // NOI18N
        labelReyNegro.setEnabled(false);
        jPanel5.add(labelReyNegro);

        textReyNegro.setBackground(new java.awt.Color(204, 204, 204));
        textReyNegro.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel5.add(textReyNegro);

        jPanel6.add(jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new java.awt.GridLayout(6, 2));

        labelPeonBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        labelPeonBlanco.setEnabled(false);
        jPanel7.add(labelPeonBlanco);

        textPeonBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textPeonBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textPeonBlanco);

        labelCaballoBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png"))); // NOI18N
        labelCaballoBlanco.setEnabled(false);
        jPanel7.add(labelCaballoBlanco);

        textCaballoBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textCaballoBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textCaballoBlanco);

        labelAlfilBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wb.png"))); // NOI18N
        labelAlfilBlanco.setEnabled(false);
        jPanel7.add(labelAlfilBlanco);

        textAlfilBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textAlfilBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textAlfilBlanco);

        labelTorreBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); // NOI18N
        labelTorreBlanco.setEnabled(false);
        jPanel7.add(labelTorreBlanco);

        textTorreBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textTorreBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textTorreBlanco);

        labelDamaBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wq.png"))); // NOI18N
        labelDamaBlanco.setEnabled(false);
        jPanel7.add(labelDamaBlanco);

        textDamaBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textDamaBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textDamaBlanco);

        labelReyBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wk.png"))); // NOI18N
        labelReyBlanco.setEnabled(false);
        jPanel7.add(labelReyBlanco);

        textReyBlanco.setBackground(new java.awt.Color(204, 204, 204));
        textReyBlanco.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jPanel7.add(textReyBlanco);

        jPanel6.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textInfo1.setBackground(new java.awt.Color(204, 204, 204));
        textInfo1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 16)); // NOI18N
        textInfo1.setForeground(new java.awt.Color(255, 0, 51));
        textInfo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p06ActionPerformed

        String coordenada = "p06";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p06ActionPerformed

    private void p00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p00ActionPerformed
      
        String coordenada = "p00";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p00ActionPerformed

    private void p10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p10ActionPerformed

        String coordenada = "p10";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p10ActionPerformed

    private void p05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p05ActionPerformed

        String coordenada = "p05";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p05ActionPerformed

    private void p07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p07ActionPerformed

        String coordenada = "p07";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p07ActionPerformed

    private void p01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p01ActionPerformed

        String coordenada = "p01";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p01ActionPerformed

    private void p02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p02ActionPerformed

        String coordenada = "p02";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p02ActionPerformed

    private void p03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p03ActionPerformed

        String coordenada = "p03";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p03ActionPerformed

    private void p04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p04ActionPerformed

        String coordenada = "p04";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p04ActionPerformed

    private void p11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p11ActionPerformed

        String coordenada = "p11";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p11ActionPerformed

    private void p12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p12ActionPerformed

        String coordenada = "p12";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p12ActionPerformed

    private void p13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p13ActionPerformed

        String coordenada = "p13";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p13ActionPerformed

    private void p14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p14ActionPerformed

        String coordenada = "p14";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p14ActionPerformed

    private void p15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p15ActionPerformed

        String coordenada = "p15";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p15ActionPerformed

    private void p16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p16ActionPerformed

        String coordenada = "p16";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p16ActionPerformed

    private void p17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p17ActionPerformed

        String coordenada = "p17";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p17ActionPerformed

    private void p20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p20ActionPerformed

        String coordenada = "p20";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p20ActionPerformed

    private void p21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p21ActionPerformed

        String coordenada = "p21";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p21ActionPerformed

    private void p22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p22ActionPerformed

        String coordenada = "p22";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p22ActionPerformed

    private void p23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p23ActionPerformed

        String coordenada = "p23";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p23ActionPerformed

    private void p24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p24ActionPerformed

        String coordenada = "p24";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p24ActionPerformed

    private void p25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p25ActionPerformed

        String coordenada = "p25";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p25ActionPerformed

    private void p26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p26ActionPerformed

        String coordenada = "p26";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p26ActionPerformed

    private void p27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p27ActionPerformed

        String coordenada = "p27";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p27ActionPerformed

    private void p30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p30ActionPerformed

        String coordenada = "p30";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p30ActionPerformed

    private void p31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p31ActionPerformed

        String coordenada = "p31";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p31ActionPerformed

    private void p32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p32ActionPerformed

        String coordenada = "p32";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p32ActionPerformed

    private void p33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p33ActionPerformed

        String coordenada = "p33";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p33ActionPerformed

    private void p34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p34ActionPerformed

        String coordenada = "p34";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p34ActionPerformed

    private void p35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p35ActionPerformed

        String coordenada = "p35";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p35ActionPerformed

    private void p36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p36ActionPerformed

        String coordenada = "p36";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p36ActionPerformed

    private void p37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p37ActionPerformed

        String coordenada = "p37";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p37ActionPerformed

    private void p40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p40ActionPerformed

        String coordenada = "p40";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p40ActionPerformed

    private void p41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p41ActionPerformed

        String coordenada = "p41";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p41ActionPerformed

    private void p42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p42ActionPerformed

        String coordenada = "p42";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p42ActionPerformed

    private void p43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p43ActionPerformed

        String coordenada = "p43";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p43ActionPerformed

    private void p44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p44ActionPerformed

        String coordenada = "p44";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p44ActionPerformed

    private void p45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p45ActionPerformed

        String coordenada = "p45";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p45ActionPerformed

    private void p46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p46ActionPerformed

        String coordenada = "p46";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p46ActionPerformed

    private void p47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p47ActionPerformed

        String coordenada = "p47";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p47ActionPerformed

    private void p50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p50ActionPerformed

        String coordenada = "p50";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p50ActionPerformed

    private void p51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p51ActionPerformed

        String coordenada = "p51";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p51ActionPerformed

    private void p52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p52ActionPerformed

        String coordenada = "p52";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p52ActionPerformed

    private void p53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p53ActionPerformed

        String coordenada = "p53";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p53ActionPerformed

    private void p54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p54ActionPerformed

        String coordenada = "p54";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p54ActionPerformed

    private void p55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p55ActionPerformed

        String coordenada = "p55";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p55ActionPerformed

    private void p56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p56ActionPerformed

        String coordenada = "p56";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p56ActionPerformed

    private void p57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p57ActionPerformed

        String coordenada = "p57";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p57ActionPerformed

    private void p60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p60ActionPerformed

        String coordenada = "p60";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p60ActionPerformed

    private void p61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p61ActionPerformed

        String coordenada = "p61";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p61ActionPerformed

    private void p62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p62ActionPerformed

        String coordenada = "p62";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p62ActionPerformed

    private void p63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p63ActionPerformed

        String coordenada = "p63";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p63ActionPerformed

    private void p64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p64ActionPerformed

        String coordenada = "p64";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p64ActionPerformed

    private void p65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p65ActionPerformed

        String coordenada = "p65";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p65ActionPerformed

    private void p66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p66ActionPerformed

        String coordenada = "p66";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p66ActionPerformed

    private void p67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p67ActionPerformed

        String coordenada = "p67";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p67ActionPerformed

    private void p70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p70ActionPerformed

        String coordenada = "p70";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p70ActionPerformed

    private void p71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p71ActionPerformed

        String coordenada = "p71";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p71ActionPerformed

    private void p72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p72ActionPerformed

        String coordenada = "p72";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p72ActionPerformed

    private void p73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p73ActionPerformed

        String coordenada = "p73";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p73ActionPerformed

    private void p74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p74ActionPerformed

        String coordenada = "p74";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p74ActionPerformed

    private void p75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p75ActionPerformed

        String coordenada = "p75";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p75ActionPerformed

    private void p76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p76ActionPerformed

        String coordenada = "p76";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p76ActionPerformed

    private void p77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p77ActionPerformed

        String coordenada = "p77";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p77ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JLabel labelAlfilBlanco;
    public javax.swing.JLabel labelAlfilNegro;
    public javax.swing.JLabel labelCaballoBlanco;
    public javax.swing.JLabel labelCaballoNegro;
    public javax.swing.JLabel labelDamaBlanco;
    public javax.swing.JLabel labelDamaNegro;
    public javax.swing.JLabel labelPeonBlanco;
    public javax.swing.JLabel labelPeonNegro;
    public javax.swing.JLabel labelReyBlanco;
    public javax.swing.JLabel labelReyNegro;
    public javax.swing.JLabel labelTorreBlanco;
    public javax.swing.JLabel labelTorreNegro;
    private javax.swing.JButton p00;
    private javax.swing.JButton p01;
    private javax.swing.JButton p02;
    private javax.swing.JButton p03;
    private javax.swing.JButton p04;
    private javax.swing.JButton p05;
    private javax.swing.JButton p06;
    private javax.swing.JButton p07;
    private javax.swing.JButton p10;
    private javax.swing.JButton p11;
    private javax.swing.JButton p12;
    private javax.swing.JButton p13;
    private javax.swing.JButton p14;
    private javax.swing.JButton p15;
    private javax.swing.JButton p16;
    private javax.swing.JButton p17;
    private javax.swing.JButton p20;
    private javax.swing.JButton p21;
    private javax.swing.JButton p22;
    private javax.swing.JButton p23;
    private javax.swing.JButton p24;
    private javax.swing.JButton p25;
    private javax.swing.JButton p26;
    private javax.swing.JButton p27;
    private javax.swing.JButton p30;
    private javax.swing.JButton p31;
    private javax.swing.JButton p32;
    private javax.swing.JButton p33;
    private javax.swing.JButton p34;
    private javax.swing.JButton p35;
    private javax.swing.JButton p36;
    private javax.swing.JButton p37;
    private javax.swing.JButton p40;
    private javax.swing.JButton p41;
    private javax.swing.JButton p42;
    private javax.swing.JButton p43;
    private javax.swing.JButton p44;
    private javax.swing.JButton p45;
    private javax.swing.JButton p46;
    private javax.swing.JButton p47;
    private javax.swing.JButton p50;
    private javax.swing.JButton p51;
    private javax.swing.JButton p52;
    private javax.swing.JButton p53;
    private javax.swing.JButton p54;
    private javax.swing.JButton p55;
    private javax.swing.JButton p56;
    private javax.swing.JButton p57;
    private javax.swing.JButton p60;
    private javax.swing.JButton p61;
    private javax.swing.JButton p62;
    private javax.swing.JButton p63;
    private javax.swing.JButton p64;
    private javax.swing.JButton p65;
    private javax.swing.JButton p66;
    private javax.swing.JButton p67;
    private javax.swing.JButton p70;
    private javax.swing.JButton p71;
    private javax.swing.JButton p72;
    private javax.swing.JButton p73;
    private javax.swing.JButton p74;
    private javax.swing.JButton p75;
    private javax.swing.JButton p76;
    private javax.swing.JButton p77;
    public javax.swing.JTextField textAlfilBlanco;
    public javax.swing.JTextField textAlfilNegro;
    public javax.swing.JTextField textCaballoBlanco;
    public javax.swing.JTextField textCaballoNegro;
    public javax.swing.JTextField textDamaBlanco;
    public javax.swing.JTextField textDamaNegro;
    private javax.swing.JTextField textInfo;
    private javax.swing.JTextField textInfo1;
    public javax.swing.JTextField textPeonBlanco;
    public javax.swing.JTextField textPeonNegro;
    public javax.swing.JTextField textReyBlanco;
    public javax.swing.JTextField textReyNegro;
    public javax.swing.JTextField textTorreBlanco;
    public javax.swing.JTextField textTorreNegro;
    // End of variables declaration//GEN-END:variables
}
