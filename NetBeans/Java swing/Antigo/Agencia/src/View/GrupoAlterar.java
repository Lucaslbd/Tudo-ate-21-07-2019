package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoGrupos;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GrupoAlterar extends javax.swing.JDialog {
    ConexaoBD conex = new ConexaoBD();  
    BeansGrupos grupos = new BeansGrupos();
    DaoGrupos dao = new DaoGrupos();
    int flag=0;
    int codigo2;
    
    public GrupoAlterar(java.awt.Frame parent, boolean modal,int codigo) {
        super(parent, modal);
        initComponents();
        preencherCadastro(codigo);
        codigo2=codigo;
    }     

    private GrupoAlterar(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void preencherCadastro(int codigo){
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where codigo='"+ codigo +"'");
           try {
               conex.rs.first();
               jTextFieldValoresFixos.setText(String.valueOf(conex.rs.getDouble("valores_fixos")));
               jTextFieldVagas.setText(String.valueOf(conex.rs.getInt("vagas")));
               jTextFieldOscilantes.setText(String.valueOf(conex.rs.getDouble("valores_oscilantes")));
               jTextFieldPreco.setText(String.valueOf(conex.rs.getDouble("preco_venda")));
              
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro"+ex.getMessage());
           }
        conex.Desconecta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldValoresFixos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldOscilantes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldVagas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Valores fixos");

        jLabel3.setText("Valores oscilantes");

        jLabel4.setText("Vagas");

        jLabel5.setText("Preço de venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldValoresFixos)
                    .addComponent(jTextFieldVagas, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldOscilantes)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldValoresFixos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldOscilantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Alterar Grupo");

        jButton1.setText("Confirmar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  
        if(jTextFieldValoresFixos.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane,"O campo valores fixos não pode estar vazio");
             jTextFieldValoresFixos.requestFocus();
        }else if(jTextFieldVagas.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane,"O campo vagas não pode estar vazio");
             jTextFieldVagas.requestFocus();
        }else if(jTextFieldOscilantes.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane,"O campo valores oscilantes não pode estar vazio");
             jTextFieldOscilantes.requestFocus();
        }else if(jTextFieldPreco.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane,"O campo preço não pode estar vazio");
             jTextFieldPreco.requestFocus();
        }else if(Double.parseDouble(jTextFieldOscilantes.getText())>= Double.parseDouble(jTextFieldPreco.getText())){
          JOptionPane.showMessageDialog(rootPane,"O campo valor oscilante não pode ser maior que o preço");
          jTextFieldPreco.requestFocus();
        }else{            
            grupos.setValoresFixos(Double.parseDouble(jTextFieldValoresFixos.getText()));
            grupos.setValoresOscilantes(Double.parseDouble(jTextFieldOscilantes.getText()));
            grupos.setVagas(Integer.parseInt(jTextFieldVagas.getText()));
            grupos.setPrecoVenda(Double.parseDouble(jTextFieldPreco.getText()));
            grupos.setCodigo(codigo2);
            dao.Editar(grupos);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
     try {
            Double.parseDouble(jTextFieldValoresFixos.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValoresFixos.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valores fixos somente pode receber numeros reais ex: 50.50");
                jTextFieldValoresFixos.setText("");
                jTextFieldValoresFixos.requestFocus();
            }
        }
     try{
          Double.parseDouble(jTextFieldOscilantes.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldOscilantes.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valores oscilantes somente pode receber numeros reais ex: 50.50");
                jTextFieldOscilantes.setText("");
                jTextFieldOscilantes.requestFocus();
            }
        }
     try{
          Double.parseDouble(jTextFieldPreco.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldPreco.getText())) {
                JOptionPane.showMessageDialog(null, "O campo Preço de venda somente pode receber numeros reais ex: 50.50");
                jTextFieldPreco.setText("");
                jTextFieldPreco.requestFocus();
            }
        }
     try{
          Integer.parseInt(jTextFieldVagas.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldVagas.getText())) {
                JOptionPane.showMessageDialog(null, "O campo vagas somente pode receber numeros inteiros ex: 50");
                jTextFieldVagas.setText("");
                jTextFieldVagas.requestFocus();
            }
        }
     
    }//GEN-LAST:event_jButton1MouseEntered

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
            java.util.logging.Logger.getLogger(GrupoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GrupoAlterar dialog = new GrupoAlterar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldOscilantes;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldVagas;
    private javax.swing.JTextField jTextFieldValoresFixos;
    // End of variables declaration//GEN-END:variables
}
