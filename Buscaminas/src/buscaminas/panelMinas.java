/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author fimaz
 */
public class panelMinas extends javax.swing.JFrame  implements ActionListener{

   int gMinas, gFilas, gColumnas;
   
    JButton boton [][];
   
   
    
    public panelMinas() {
        initComponents();
    }
    
    public void mostrarMinas(){
        
        
        
    }
    
    public void llenarPanel(int minas, int filas, int columnas){
        
        int filaBomb, columnaBomb, alturaBtn, anchuraBtn;
        boton = new JButton[filas][columnas];
        
        anchuraBtn =500/filas;
        alturaBtn = 500/columnas;
        
        
        
        for(int i =0; i<filas; i++){
          for(int j=0; j<columnas; j++){
              
              boton[i][j]= new JButton();
              
                //SetBound(x, y, wigth, higth);
              boton[i][j].setBounds(j*(anchuraBtn-4), i*(alturaBtn-4), anchuraBtn, alturaBtn);
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
        
        
        
        //Agregamos un action listener
        for(int i =0; i<filas; i++){
          for(int j=0; j<columnas; j++){
                boton[i][j].addActionListener(this);
          }
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        pnlMinas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("00");

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       
        pnlMinas.removeAll();
        this.llenarPanel(gMinas,gFilas, gColumnas);
        
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlMinas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        String texto, contenido;
        int fila, columna;
        
        JButton boton = (JButton)e.getSource();
        texto = boton.getText();
        
        
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
            
            
            
            
        }
        
       
        
        
    }
}
