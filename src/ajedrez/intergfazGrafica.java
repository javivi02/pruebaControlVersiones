package ajedrez;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jgarciaa
 */
public class intergfazGrafica extends javax.swing.JFrame {

    private tablero tablero = new tablero();
    private movimientos movimientos = new movimientos();
    
    private String coordenadaIncio;
    private String coordenadaDestino;

    private boolean clickJButton = true;
    private boolean mover = false;

    /**
     * Creates new form NewJFrame
     */
    public intergfazGrafica() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    private String piezaCoordenadaTablero(String coordenada){
          
        return tablero.contenidoCoordenada(coordenada);
    }
    
    private void marcaMovimientoTablero(String coordenada){

        String tipoFicha = piezaCoordenadaTablero(coordenada);
        
        switch (tipoFicha) {
            case "CB": marcaCasillasCaballo(coordenada);break;
            case "PB": marcaCasillasPeon(coordenada); break;
            case "TB": marcaCasillasTorre(coordenada); break;
            case "AB": break;              
            case "DB": break;
            case "RB": break;
            case "-": System.out.println("NADA") ;break;
        }
    }
    
    private void marcaCasillasCaballo(String coordenada){
        
        ArrayList<String> temporal = new ArrayList<>();

        temporal = filtroCoordenadasPiezasBlancas(movimientos.moverCaballo(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }
        
    }
    
    private void marcaCasillasPeon(String coordenada){

        ArrayList<String> temporal = new ArrayList<>();
        temporal = filtroCoordenadasPiezasBlancas(movimientos.moverPeon(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }
  
    }
    
    private void marcaCasillasTorre(String coordenada){
        
        ArrayList<String> temporal = new ArrayList<>();
        
        temporal = filtroCoordenadasPiezasBlancas(movimientos.moverTorre(coordenada), tablero.getCoordenadasPiezasBlancas());
        
        for (int i = 0; i < temporal.size(); i++) {

            coordenadaJButton(temporal.get(i)).setBackground(Color.red);
        }

    }
    
    private ArrayList <String> filtroCoordenadasPiezasBlancas(ArrayList <String> movimientos, ArrayList <String> piezas){
        
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
    
    private JButton coordenadaJButton(String valor){
        
        JButton resultado = null;
        
        String opcion = valor;
        
        switch (opcion) {
            case "p00":  return p00;
            case "p01":  return p01;
            case "p02":  return p02;
            case "p10":  return p10;
            case "p11":  return p11;
            case "p12":  return p12;
            case "p20":  return p20;
            case "p21":  return p21;
            case "p22":  return p22;
            default:     return resultado;
                          
        }
    }
    
    private void resetearBackgroud(){
        
        p00.setBackground(null);
        p01.setBackground(null);
        p02.setBackground(null);
        p10.setBackground(null);
        p11.setBackground(null);
        p12.setBackground(null);
        p20.setBackground(null);
        p21.setBackground(null);
        p22.setBackground(null);
        
    }
    
    private void mover(String coordenadaInicio, String coordenadaFinal){
        
        if (mover){
            
            String tipoFicha = piezaCoordenadaTablero(coordenadaInicio);
        
            switch (tipoFicha) {
                
                case "CB": moverCaballo(coordenadaInicio, coordenadaFinal); break;
                case "PB": moverPeon(coordenadaInicio, coordenadaFinal); break;
                case "TB": moverTorre(coordenadaInicio, coordenadaFinal); break;
                case "AB": break;              
                case "DB": break;
                case "RB": break;               
            }
        }
    }
    
    private void moverCaballo(String coordenadaInicio, String coordenadaFinal) {

        ArrayList<String> temporal = filtroCoordenadasPiezasBlancas(movimientos.moverCaballo(coordenadaInicio), tablero.getCoordenadasPiezasBlancas());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png")));
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                tablero.mostrarTablero();

            }
        }
    }
    
    private void moverPeon(String coordenadaInicio, String coordenadaFinal){
        
        ArrayList<String> temporal = filtroCoordenadasPiezasBlancas(movimientos.moverPeon(coordenadaInicio), tablero.getCoordenadasPiezasBlancas());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png")));
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                tablero.mostrarTablero();

            }
        }


    }
    
    private void moverTorre(String coordenadaInicio, String coordenadaFinal) {

        ArrayList<String> temporal = filtroCoordenadasPiezasBlancas(movimientos.moverTorre(coordenadaInicio), tablero.getCoordenadasPiezasBlancas());

        for (int i = 0; i < temporal.size(); i++) {
            if (coordenadaFinal.equalsIgnoreCase(temporal.get(i))) {

                coordenadaJButton(coordenadaIncio).setIcon(null);
                coordenadaJButton(coordenadaFinal).setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png")));
                tablero.actualizarCoordenada(coordenadaIncio, coordenadaFinal);
                tablero.actualizarCoordenadasPiezasBlancas(coordenadaInicio, coordenadaFinal);
                tablero.mostrarTablero();

            }
        }
    }
    
    private void pasosAlHacerClick(String coordenada){
        
        mover(coordenadaIncio, coordenada);
        coordenadaIncio = coordenada;
        marcaMovimientoTablero(coordenada);
        seleccionarJButton();
        
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
        p10 = new javax.swing.JButton();
        p11 = new javax.swing.JButton();
        p12 = new javax.swing.JButton();
        p20 = new javax.swing.JButton();
        p21 = new javax.swing.JButton();
        p22 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        p00.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png"))); // NOI18N
        p00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p00ActionPerformed(evt);
            }
        });
        jPanel1.add(p00);

        p01.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p01ActionPerformed(evt);
            }
        });
        jPanel1.add(p01);

        p02.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p02ActionPerformed(evt);
            }
        });
        jPanel1.add(p02);

        p10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p10ActionPerformed(evt);
            }
        });
        jPanel1.add(p10);

        p11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p11ActionPerformed(evt);
            }
        });
        jPanel1.add(p11);

        p12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p12ActionPerformed(evt);
            }
        });
        jPanel1.add(p12);

        p20.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png"))); // NOI18N
        p20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p20ActionPerformed(evt);
            }
        });
        jPanel1.add(p20);

        p21.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wr.png"))); // NOI18N
        p21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p21ActionPerformed(evt);
            }
        });
        jPanel1.add(p21);

        p22.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        p22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p22ActionPerformed(evt);
            }
        });
        jPanel1.add(p22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p20ActionPerformed

        String coordenada = "p20";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p20ActionPerformed

    private void p00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p00ActionPerformed
      
        String coordenada = "p00";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p00ActionPerformed

    private void p22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p22ActionPerformed

        String coordenada = "p22";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p22ActionPerformed

    private void p12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p12ActionPerformed

        String coordenada = "p12";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p12ActionPerformed

    private void p21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p21ActionPerformed

        String coordenada = "p21";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p21ActionPerformed

    private void p01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p01ActionPerformed

        String coordenada = "p01";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p01ActionPerformed

    private void p02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p02ActionPerformed

        String coordenada = "p02";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p02ActionPerformed

    private void p10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p10ActionPerformed

        String coordenada = "p10";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p10ActionPerformed

    private void p11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p11ActionPerformed

        String coordenada = "p11";
        pasosAlHacerClick(coordenada);
    }//GEN-LAST:event_p11ActionPerformed

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
            java.util.logging.Logger.getLogger(intergfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(intergfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(intergfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(intergfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new intergfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton p00;
    private javax.swing.JButton p01;
    private javax.swing.JButton p02;
    private javax.swing.JButton p10;
    private javax.swing.JButton p11;
    private javax.swing.JButton p12;
    private javax.swing.JButton p20;
    private javax.swing.JButton p21;
    private javax.swing.JButton p22;
    // End of variables declaration//GEN-END:variables
}
