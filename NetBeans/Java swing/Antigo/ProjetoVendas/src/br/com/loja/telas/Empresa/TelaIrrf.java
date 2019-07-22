package br.com.loja.telas.Empresa;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.dao.InssDao;
import br.com.loja.dao.IrrfDao;
import br.com.loja.domain.Inss;
import br.com.loja.domain.Irrf;
import br.com.loja.tabelas.ModeloTabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaIrrf extends javax.swing.JFrame {

    int flag;
    int codigo;

    public TelaIrrf() {
        initComponents();
        preencherTabela("select * from irrf order by valor_inicial");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldInicial = new javax.swing.JTextField();
        jTextFieldFinal = new javax.swing.JTextField();
        jTextFieldPorcentagem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDeduzir = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTablePadrao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePadraoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePadrao);

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salvar");
        jButton4.setEnabled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Valor inicial");

        jLabel3.setText("Valor final");

        jLabel4.setText("Porcentagem");

        jTextFieldInicial.setEnabled(false);

        jTextFieldFinal.setEnabled(false);

        jTextFieldPorcentagem.setEnabled(false);

        jLabel5.setText("Deduzir");

        jTextFieldDeduzir.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldInicial)
                    .addComponent(jTextFieldFinal)
                    .addComponent(jTextFieldPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jTextFieldDeduzir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDeduzir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Cancelar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tela IRRF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextFieldInicial.setEnabled(true);
        jTextFieldFinal.setEnabled(true);
        jTextFieldPorcentagem.setEnabled(true);
        jTextFieldDeduzir.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(false);
        jButton5.setEnabled(true);
        jButton5.setEnabled(true);
        flag = 1;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextFieldInicial.setEnabled(true);
        jTextFieldFinal.setEnabled(true);
        jTextFieldPorcentagem.setEnabled(true);
        jTextFieldDeduzir.setEnabled(true);
        flag = 2;
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTextFieldInicial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo valor inicial não pode estar vazio");
            jTextFieldInicial.requestFocus();
        } else if (jTextFieldFinal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo valor final não pode estar vazio");
            jTextFieldFinal.requestFocus();
        } else if (jTextFieldPorcentagem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo porcentagem não pode estar vazio");
            jTextFieldPorcentagem.requestFocus();
        } else if (jTextFieldDeduzir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo deduzir não pode estar vazio");
            jTextFieldDeduzir.requestFocus();
        } else {
            if (flag == 1) {
                Irrf irrf = new Irrf();
                irrf.setValorInicial(Double.parseDouble(jTextFieldInicial.getText()));
                irrf.setValorFinal(Double.parseDouble(jTextFieldFinal.getText()));
                irrf.setPorcentagem(Double.parseDouble(jTextFieldPorcentagem.getText()));
                irrf.setDevolver(Double.parseDouble(jTextFieldDeduzir.getText()));
                IrrfDao dao = new IrrfDao();
                dao.Salvar(irrf);
            } else {
                Irrf irrf = new Irrf();
                irrf.setValorInicial(Double.parseDouble(jTextFieldInicial.getText()));
                irrf.setValorFinal(Double.parseDouble(jTextFieldFinal.getText()));
                irrf.setPorcentagem(Double.parseDouble(jTextFieldPorcentagem.getText()));
                irrf.setDevolver(Double.parseDouble(jTextFieldDeduzir.getText()));
                irrf.setCodigo(codigo);
                IrrfDao dao = new IrrfDao();
                dao.Alterar(irrf);
            }
            jTextFieldInicial.setEnabled(false);
            jTextFieldInicial.setText("");
            jTextFieldFinal.setEnabled(false);
            jTextFieldFinal.setText("");
            jTextFieldPorcentagem.setEnabled(false);
            jTextFieldPorcentagem.setText("");
            jTextFieldDeduzir.setEnabled(false);
            jTextFieldDeduzir.setText("");
            jButton1.setEnabled(true);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            preencherTabela("select * from irrf order by valor_inicial");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        codigo = ((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0));
        jTextFieldInicial.setText(String.valueOf((Double) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 1)));
        jTextFieldFinal.setText(String.valueOf((Double) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 2)));
        jTextFieldPorcentagem.setText(String.valueOf((Double) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 3)));
        jTextFieldDeduzir.setText(String.valueOf((Double) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 4)));
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir a taxa?");
        if (resposta == JOptionPane.YES_OPTION) {
            IrrfDao dao = new IrrfDao();
            dao.excluir(codigo);
        }
        jTextFieldInicial.setEnabled(false);
        jTextFieldInicial.setText("");
        jTextFieldFinal.setEnabled(false);
        jTextFieldFinal.setText("");
        jTextFieldPorcentagem.setEnabled(false);
        jTextFieldPorcentagem.setText("");
        jTextFieldDeduzir.setEnabled(false);
        jTextFieldDeduzir.setText("");
        preencherTabela("select * from irrf order by valor_inicial");
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextFieldInicial.setEnabled(false);
        jTextFieldInicial.setText("");
        jTextFieldFinal.setEnabled(false);
        jTextFieldFinal.setText("");
        jTextFieldPorcentagem.setEnabled(false);
        jTextFieldPorcentagem.setText("");
        jTextFieldDeduzir.setEnabled(false);
        jTextFieldDeduzir.setText("");
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        preencherTabela("select * from irrf order by valor_inicial");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        try {
            Double.parseDouble(jTextFieldInicial.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldInicial.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor inicial somente pode receber numeros reais ex: 50.31");
                jTextFieldInicial.setText("");
                jTextFieldInicial.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldFinal.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldFinal.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor inicial somente pode receber numeros reais ex: 50.31");
                jTextFieldFinal.setText("");
                jTextFieldFinal.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldPorcentagem.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPorcentagem.getText())) {
                JOptionPane.showMessageDialog(null, "O campo porcentagem somente pode receber numeros reais ex: 50.31");
                jTextFieldPorcentagem.setText("");
                jTextFieldPorcentagem.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldDeduzir.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldDeduzir.getText())) {
                JOptionPane.showMessageDialog(null, "O campo deduzir somente pode receber numeros reais ex: 50.31");
                jTextFieldDeduzir.setText("");
                jTextFieldDeduzir.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton4MouseEntered

    private void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Valor inicial", "Valor final", "Porcentagem", "Deduzir"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getInt("codigo"), resultado.getDouble("valor_inicial"), resultado.getDouble("valor_final"), resultado.getDouble("porcentagem"), resultado.getDouble("devolver")});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Registro não encontrado " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            java.util.logging.Logger.getLogger(TelaIrrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaIrrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaIrrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaIrrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaIrrf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldDeduzir;
    private javax.swing.JTextField jTextFieldFinal;
    private javax.swing.JTextField jTextFieldInicial;
    private javax.swing.JTextField jTextFieldPorcentagem;
    // End of variables declaration//GEN-END:variables
}
