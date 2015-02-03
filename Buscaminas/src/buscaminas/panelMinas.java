/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author fimaz
 */
public class panelMinas extends javax.swing.JFrame  implements ActionListener, Runnable{

    int gMinas, gFilas, gColumnas;
    JButton boton [][];
    
    //Variables para el hilo de contador de tiempo
    Thread timer;
    float time;
    
    
    
    public panelMinas() {
        //Metodo Principal
        initComponents();
        
        //Colocamos la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        
        //Colocamos un icono de aplicacion
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icono.png")));
        
        
        
        //iniciamos el contador y el metodo
        time=0;
        timer = new Thread(this);
        timer.start();

    }
    
    public void buscarMinas(int i, int j){
       //n= numero p=posicion
        
        int nBombas=0;
        String bomb=" ", pUno="", pDos="", pTres="", pCuatro="", pSeis="", pSiete="", pOcho="", pNueve="", nBombasFinal;
        
        System.out.println("ESTO "+gFilas+"  i"+i);
        System.out.println("ESTO "+gColumnas+"  j"+j);
        
        
        //1
        if((i-1) >= 0 && (j-1) >= 0){
        System.out.println("ENTRO1");
        pUno = this.boton[i-1][j-1].getText();
        
        }
        //2
        if((i-1) >= 0){
        System.out.println("ENTRO2");
        pDos = this.boton[i-1][j].getText();  
        
        }
        
        //3
        if((i-1) >= 0 && j+1 <= (gColumnas-1) ){
            System.out.println("ENTRO3 "+(gColumnas-1));
            pTres = this.boton[i-1][j+1].getText();
        }
        
        //4
        if((j-1) >= 0){
            System.out.println("ENTRO4");
            pCuatro = this.boton[i][j-1].getText();
        }
        
        //6
        if((j+1) <= (gColumnas-1) ){
            System.out.println("ENTRO6");
            pSeis = this.boton[i][j+1].getText();
        }
        
        //7
        if((i+1) <= (gFilas-1) && (j-1) >= 0){
            System.out.println("ENTRO7");
            pSiete = this.boton[i+1][j-1].getText();
        }
        
        
        //8
        if((i+1) <= (gFilas-1)){
            System.out.println("ENTRO9  gc"+(gFilas));
            pOcho = this.boton[i+1][j].getText();
           
        
        }
        
        //9
        if((j+1) <= (gColumnas-1) && (i+1) <= (gColumnas-1)){
            System.out.println("ENTRO9  gc"+(gColumnas));
            pNueve = this.boton[i+1][j+1].getText();
        
        }
        
        
        
        
        //Contamos las bombas
        if(pUno.equals(" ")){
            nBombas++;
        }
        if(pDos.equals(" ")){
            nBombas++;
        }
        if(pTres.equals(" ")){
            nBombas++;
        }
        if(pCuatro.equals(" ")){
            nBombas++;
        }
        if(pSeis.equals(" ")){
            nBombas++;
        }
        if(pSiete.equals(" ")){
            nBombas++;
        }
        if(pOcho.equals(" ")){
            nBombas++;
        }
        if(pNueve.equals(" ")){
            nBombas++;
        }
        
        nBombasFinal= String.valueOf(nBombas);
        this.boton[i][j].setText(nBombasFinal);
        
    }
    
    
    
    public void llenarPanel(int minas, int filas, int columnas){
        //llenamos el label de minas
        System.out.println("ESTO: "+minas);
        lbMinas.setText(""+minas);
        
        //inicializamos variables
        int filaBomb, columnaBomb, alturaBtn, anchuraBtn;
        boton = new JButton[filas][columnas];
        
        anchuraBtn =500/filas;
        alturaBtn = 500/columnas;
        
        
        
        for(int i =0; i<filas; i++){
          for(int j=0; j<columnas; j++){
              
              boton[i][j]= new JButton();
              
                //SetBound(x, y, wigth, higth);
              boton[i][j].setBounds(j*(anchuraBtn), i*(alturaBtn), anchuraBtn, alturaBtn);
              boton[i][j].setContentAreaFilled(false);
              boton[i][j].setBorder(javax.swing.BorderFactory.createEtchedBorder());
              pnlMinas.add(boton[i][j]);
              
              
          }
            
        }
        
        
        //Agregamos bombas aleatoreamente
        for(int i=0; i<minas; i++){
            filaBomb = (int)(Math.random()* filas); 
            columnaBomb = (int)(Math.random()* columnas); 
             
            System.out.println("i= "+i+"   "+filaBomb+""
                    + "  "+columnaBomb);
             
            String valor = boton[filaBomb][columnaBomb].getText();
            
                if( valor.equals(" ") ){
                    i--;
                }else{
                        boton[filaBomb][columnaBomb].setText(" ");
             
                }
        }
        
        
        
        //Agregamos un action listener a cada boton
        for(int i =0; i<filas; i++){
          for(int j=0; j<columnas; j++){
                boton[i][j].addActionListener(this);
          }
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMinas = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        pnlMinas = new javax.swing.JPanel();
        lTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBack = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMinas.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbMinas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinas.setText("00");
        getContentPane().add(lbMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 188, 81));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset1.png"))); // NOI18N
        btnReset.setBorder(null);
        btnReset.setContentAreaFilled(false);
        btnReset.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset2.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 128, 128));

        javax.swing.GroupLayout pnlMinasLayout = new javax.swing.GroupLayout(pnlMinas);
        pnlMinas.setLayout(pnlMinasLayout);
        pnlMinasLayout.setHorizontalGroup(
            pnlMinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        pnlMinasLayout.setVerticalGroup(
            pnlMinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 156, -1, -1));

        lTime.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTime.setText("00:00");
        getContentPane().add(lTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 188, 76));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mines");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 188, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Time");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 46, 226, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FONDO.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -20, 630, 700));

        menuBack.setText("<- Back");
        menuBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuBackMousePressed(evt);
            }
        });
        menuBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuBack);

        menuAbout.setText("About");
        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        pnlMinas.removeAll();
        pnlMinas.repaint();
        System.out.println(""+gMinas+""+gFilas+""+gColumnas);
        this.llenarPanel(gMinas,gFilas, gColumnas);
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void menuBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBackActionPerformed
      
        mainMenu obj = new mainMenu();
        obj.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_menuBackActionPerformed

    private void menuBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBackMousePressed
        int salir = JOptionPane.showConfirmDialog(null,"Are you sure?.\nThe progress will be lost.","¿Do you want to leave?", JOptionPane.YES_NO_OPTION);
    
            if(salir==0){
             // Upps se quiere ir...
                mainMenu obj = new mainMenu();
                obj.setVisible(true);
                setVisible(false);
            }else{
                //No hacemos nada continuamos :D
            } 
    }//GEN-LAST:event_menuBackMousePressed

    /**
     * @param args the command line arguments
     */
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lTime;
    private javax.swing.JLabel lbMinas;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuBack;
    private javax.swing.JPanel pnlMinas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        String texto, contenido;
        int fila=0, columna=0;
        
        JButton boton = (JButton)e.getSource();
        texto = boton.getText();
        
        //Cuando es bomba
        if(texto.equals(" ")){
            //System.out.println("ENTRO");
            
            boton.setIcon(new ImageIcon(getClass().getResource("../images/bombtablero.png")));
            
            
                for(int i =0; i<gFilas; i++){
                  for(int j=0; j<gColumnas; j++){

                      contenido = this.boton[i][j].getText();

                      if(contenido.equals(" ")){
                          //System.out.println("ENTRO!");
                          this.boton[i][j].setIcon(new ImageIcon(getClass().getResource("../images/bombtablero.png")));
                          

                      }
                      this.boton[i][j].setEnabled(false);
                  }
                }
            
            
            JOptionPane.showMessageDialog(null, "Sorry, You lose!");
            
            
        }else{
            boton.setEnabled(false);
            
            
            for(int i =0; i<this.boton.length; i++){
            for(int j=0; j<this.boton.length; j++){
                if(boton == this.boton[i][j]){
                    fila=i;
                    columna=j;
                }
            }
        }
        this.buscarMinas(fila, columna);
            
            
            
        }
        
       
        
        
    }

    
    //Metodo principal de runnable
    @Override
    public void run() {
        int min, seg;
        
        while(true){
        
        time++;
        min=(int) (time / 60);
        seg=(int) (time % 60);
        lTime.setText(min+":"+seg);
        
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                
            }
        
        }
    }
}
