package Visao.Caixa;

import Visao.Caixa.FrenteCaixa;
import Beans.BeansVenda;
import Dao.DaoVenda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Troco extends javax.swing.JFrame {
   DecimalFormat df = new DecimalFormat("0.##");
   DaoVenda control = new DaoVenda();
   BeansVenda mod = new BeansVenda();
  
  
 double receberei;
    
    public Troco() {
        initComponents();  
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelTotalCompra = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTroco = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldRecebido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total R$");

        jLabelTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTotalCompra.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Troco R$");

        jLabelTroco.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelTroco.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTroco.setText("0.00");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRecebidoKeyPressed(evt);
            }
        });

        jLabel3.setText("Valor recebido");

        jButtonFinalizar.setText("Finalizar atendimento");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });
        jButtonFinalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonFinalizarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonFinalizar))
                    .addComponent(jTextFieldRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFinalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalCompra))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTroco)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTotalCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelTroco))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jTextFieldRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRecebidoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        if(jTextFieldRecebido.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o valor recebido");
       }else{   
        
            double recebido = (Double.parseDouble(jTextFieldRecebido.getText()));
            double total = receberei;
            double troco = recebido - total;
             String dx = df.format(troco);
            jLabelTroco.setText(String.valueOf(dx)); 
            jButtonFinalizar.requestFocus();
        
        }
          
        }
        
    }//GEN-LAST:event_jTextFieldRecebidoKeyPressed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
       if(jTextFieldRecebido.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o valor recebido");
}else{
        jTextFieldRecebido.requestFocus();        
        jLabelTotalCompra.setText("0,00");    
         jTextFieldRecebido.setText("");
         jLabelTroco.setText("0,00"); 
         control.ExcluirTudo(mod);
         ExecutaMetodo();
         dispose();
         
          
}
    }//GEN-LAST:event_jButtonFinalizarActionPerformed
     
    private void jButtonFinalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonFinalizarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        if(jTextFieldRecebido.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o valor recebido");
}else{ 
        
         jLabelTotalCompra.setText("0,00");    
         jTextFieldRecebido.setText("");
         jLabelTroco.setText("0,00");
         control.TransferirDados(mod);
         control.ExcluirTudo(mod);
        ExecutaMetodo();
         dispose();
           }
        }
    }//GEN-LAST:event_jButtonFinalizarKeyPressed

    private FrenteCaixa princip;
     public void MostrarTelaTroco(FrenteCaixa caixa){
         this.princip = caixa;
         setVisible(true);
     }
   public void ExecutaMetodo(){
       princip.executEmOutroFinaliza();
   }
    
    
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
            java.util.logging.Logger.getLogger(Troco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Troco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Troco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Troco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Troco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTotalCompra;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldRecebido;
    // End of variables declaration//GEN-END:variables
public void recebendo (Double recebe){
    receberei = recebe;
     String dx = df.format(recebe);
            jLabelTotalCompra.setText(String.valueOf(dx)); 
   
    
}
}
