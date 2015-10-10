/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eljuegodelavida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ozmarhumberto
 */
public class miJFrame extends javax.swing.JFrame {

    boolean tablero[][];  
    int limX,limY,genAct;    
    Timer timer = new Timer (1_000, new ActionListener () 
        {                                      
            @Override
            public void actionPerformed(ActionEvent e)
            {                   
                generacion();
                genAct++;                
                repaint();
                jLabel2.setText(String.valueOf(genAct));                
            }
        });
    
    public void dimencionarTablero(int x, int y){
        tablero=new boolean[x][y];
        tablero[22][25]=true;
        tablero[23][24]=true;
        tablero[25][25]=true;
        tablero[24][24]=true;
        tablero[24][26]=true;
        tablero[23][26]=true;
        tablero[26][24]=true;
        tablero[26][26]=true;
        tablero[27][24]=true;
        tablero[27][26]=true;
        tablero[28][25]=true;
        limX=x;
        limY=y;
        repaint();
    }
    //funcion para crear la nueva generacion de casillas
    public void generacion(){
        int cuentaVivos=0;
        for(int y=0;y<limY;y++)
        {
            for(int x=0;x<limX;x++)
            {                            
                //Revision de los lados izquierdo y superior
                if(x>0 && y>0 && x<(limX-1))
                {
                    if(tablero[x][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x+1][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    //check[x][y-1], check[x-1][y-1],check[x-1][y],check[x+1][y-1]
                }else if(x>0 && y==0){
                    if(tablero[x-1][y])
                    {
                        cuentaVivos++;
                    }
                    //check[x-1][y];
                }else if(y>0 && x==0){
                    if(tablero[x][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x+1][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    //check[x][y-1];check[x+1][y-1];
                }
                if (x<(limX-1)  && y<(limY-1) && x>0){
                    if(tablero[x+1][y]==true){
                        cuentaVivos++;
                    }
                    if(tablero[x+1][y+1]==true){
                        cuentaVivos++;
                    }
                    if(tablero[x][y+1]==true){
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y+1]==true){
                        cuentaVivos++;
                    }
                    //check[x+1][y];check[x+1][y+1];check[x][y+1];check[x-1][y+1];
                }else if(x<(limX-1) && y==limY){
                    if(tablero[x+1][y]==true)
                    {
                        cuentaVivos++;
                    }
                    //check[x+1][y];
                }else if(y<(limY-1) && x==(limX-1)){
                    if(tablero[x][y+1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y+1]==true)
                    {
                        cuentaVivos++;
                    }
                    //check[x][y+1];check[x-1][y+1];
                }
                if(x>0 && y>0 && x==(limX-1)){
                    if(tablero[x][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y-1]==true)
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x-1][y]==true)
                    {
                        cuentaVivos++;
                    }
                    //check[x][y-1];check[x-1][y-1];check[x-1][y];
                }
                if(x<(limX-1) && y<(limY-1) && x==0){                    
                    if(tablero[x+1][y])
                    {
                        cuentaVivos++;
                    }                    
                    if(tablero[x+1][y+1])
                    {
                        cuentaVivos++;
                    }
                    if(tablero[x][y+1])
                    {
                        cuentaVivos++;
                    }
                    //check[x+1][y];check[x+1][y+1];check[x][y+1];
                }
                //si la casilla tiene solo a 3 vecinos cerca vive
                if(cuentaVivos==3)
                {
                    tablero[x][y]=true;
                }
                else{
                    tablero[x][y]=false;
                }
                //se reinicia el contador
                cuentaVivos=0;
            }
        }        
    }
    /**
     * Creates new form miJFrame
     */
    
    public miJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El Juego de la vida");
        setPreferredSize(new java.awt.Dimension(900, 754));
        setSize(new java.awt.Dimension(1000, 1000));

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Generacion actual:");

        jLabel2.setText("0");
        jLabel2.setName("lblGenAct"); // NOI18N

        jLabel3.setText("Tablero X:");

        jTextField1.setText("50");
        jTextField1.setName("txtTableroX"); // NOI18N

        jLabel4.setText("Tamaño en Y:");

        jTextField2.setText("50");
        jTextField2.setName("txtTableroY"); // NOI18N

        jButton2.setText("Detener");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 581, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 731, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("El Juego de la vida");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            //se verifica que los datos en las cajas de texto sean correctos
            limX=Integer.parseInt(jTextField1.getText());
            limY=Integer.parseInt(jTextField2.getText());                   
        }catch(NumberFormatException nfe){
            //se lanza mensaje de error en caso de la introduccion de un valor incorrecto
            JOptionPane.showMessageDialog(null, "Los valores ingresados para el tamaño del tablero deben ser numeros y enteros","Error",JOptionPane.ERROR_MESSAGE);
            dimencionarTablero(50,50);      
        }finally
        {
            repaint();
            dimencionarTablero(limX,limY);
            genAct=0;
            timer.start();     
            jButton2.setEnabled(true);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        timer.stop();   
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed
     
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
            java.util.logging.Logger.getLogger(miJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(miJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(miJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(miJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new miJFrame().setVisible(true);
            }
        });
    }
    //funcion para pintar el tablero
    public void paint(Graphics g)
    {        
        int posActX,posActY;
        posActX=10;
        posActY=61;
        super.paint(g);              
        for(int i=0;i<limY;i++)
        {
            for(int e=0;e<limX;e++)
            {                
                if(tablero[e][i]==true)
                {
                    g.setColor(Color.blue);
                    g.fillRect(posActX,posActY, 10, 10);
                    posActX+=10;
                }else
                {
                    g.setColor(Color.black);
                    g.drawRect(posActX, posActY, 10, 10);
                    posActX+=10;
                }              
            }
            posActX=10;
            posActY+=10;
        }
//        g.setColor (Color.blue);         
//        g.drawRect (10,31,10,10);
//        g.setColor (Color.red);
//        g.fillRect (20,31,10,10);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
