package visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansGastos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoGastos;

public class Gastos extends javax.swing.JFrame {

    BeansGastos mod = new BeansGastos();
    DaoGastos control = new DaoGastos();
    ConexaoBD conex = new ConexaoBD();

    int flag = 0;

    public Gastos() {
        initComponents();

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextFieldData.setText(dtHoje);
    }

    public void PreencherReferencia() {
        conex.Conexao();
        conex.executaSql("SELECT DISTINCT referente FROM gastos order by referente");
        try {
            conex.rs.first();
            jComboBoxreferente.removeAllItems();
            do {
                jComboBoxreferente.addItem(conex.rs.getString("referente"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    public void PreencherDescricao() {
        String Produto = (String) jComboBoxreferente.getSelectedItem();
        conex.Conexao();
        conex.executaSql("SELECT DISTINCT descricao_gasto FROM gastos where referente='" + Produto + "' order by descricao_gasto");
        try {
            conex.rs.first();
            jComboBoxDescricao.removeAllItems();
            do {
                jComboBoxDescricao.addItem(conex.rs.getString("descricao_gasto"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldId = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldReferencia = new javax.swing.JTextField();
        jComboBoxreferente = new javax.swing.JComboBox<>();
        jComboBoxDescricao = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldId.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Descrição do gasto");

        jTextFieldDescricao.setEnabled(false);

        jLabel3.setText("Valor");

        jTextFieldValor.setEnabled(false);

        jLabel4.setText("Data");

        jFormattedTextFieldData.setEnabled(false);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseEntered(evt);
            }
        });
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("R$");

        jLabel8.setText("Referência");

        jTextFieldReferencia.setEnabled(false);

        jComboBoxreferente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxreferente.setEnabled(false);
        jComboBoxreferente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxreferenteMouseClicked(evt);
            }
        });

        jComboBoxDescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxDescricao.setEnabled(false);
        jComboBoxDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxDescricaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxDescricaoMouseEntered(evt);
            }
        });

        jButton1.setText("Confirmar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirmar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jTextFieldValor)
                            .addComponent(jTextFieldReferencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxreferente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDescricao, 0, 113, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxreferente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gastos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(588, 347));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldReferencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a referencia do gasto");
            jTextFieldReferencia.requestFocus();
        } else if (jTextFieldDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a descricao do gasto");
            jTextFieldDescricao.requestFocus();
        } else if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor do gasto");
            jTextFieldValor.requestFocus();
        } else if (jFormattedTextFieldData.getText().isEmpty()) {
            jFormattedTextFieldData.requestFocus();
            JOptionPane.showMessageDialog(null, "Insira a data do gasto");

        } else if (flag == 1) {
            mod.setDescricaoGasto(jTextFieldDescricao.getText());
            mod.setValorGasto(Double.parseDouble(jTextFieldValor.getText()));
            mod.setDataGasto(jFormattedTextFieldData.getText());
            mod.setReferencia(jTextFieldReferencia.getText());
            control.Salvar(mod);

            PreencherReferencia();
            PreencherDescricao();
            jButtonNovo.setEnabled(true);

            jButtonCancelar.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jTextFieldDescricao.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jFormattedTextFieldData.setEnabled(false);
            jTextFieldReferencia.setEnabled(false);
            jComboBoxreferente.setEnabled(false);
            jComboBoxDescricao.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jTextFieldReferencia.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldValor.setText("");
            jTextFieldId.setText("");
        } else {
            mod.setCodigoGasto(Integer.parseInt(jTextFieldId.getText()));
            mod.setDescricaoGasto(jTextFieldDescricao.getText());
            mod.setValorGasto(Double.parseDouble(jTextFieldValor.getText()));
            mod.setDataGasto(jFormattedTextFieldData.getText());
            mod.setReferencia(jTextFieldReferencia.getText());
            control.Editar(mod);

            PreencherReferencia();
            PreencherDescricao();
            jButtonNovo.setEnabled(true);

            jButtonCancelar.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jTextFieldDescricao.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jFormattedTextFieldData.setEnabled(false);
            jTextFieldReferencia.setEnabled(false);
            jComboBoxreferente.setEnabled(false);
            jComboBoxDescricao.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jTextFieldReferencia.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldValor.setText("");
            jTextFieldId.setText("");

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jTextFieldReferencia.setEnabled(true);
        jTextFieldDescricao.setEnabled(true);
        jTextFieldValor.setEnabled(true);
        jFormattedTextFieldData.setEnabled(true);
        jComboBoxreferente.setEnabled(true);
        jComboBoxDescricao.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jTextFieldReferencia.requestFocus();
        PreencherReferencia();
        PreencherDescricao();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonNovo.setEnabled(true);

        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jTextFieldDescricao.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jFormattedTextFieldData.setEnabled(false);
        jTextFieldReferencia.setEnabled(false);
        jComboBoxreferente.setEnabled(false);
        jComboBoxDescricao.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);

        jTextFieldDescricao.setText("");
        jTextFieldValor.setText("");
        jTextFieldId.setText("");
        jTextFieldReferencia.setText("");

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String referencia = (String) jComboBoxreferente.getSelectedItem();
        jTextFieldReferencia.setText(referencia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String descricao = (String) jComboBoxDescricao.getSelectedItem();
        jTextFieldDescricao.setText(descricao);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxreferenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxreferenteMouseClicked

    }//GEN-LAST:event_jComboBoxreferenteMouseClicked

    private void jComboBoxDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoMouseClicked

    }//GEN-LAST:event_jComboBoxDescricaoMouseClicked

    private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseEntered
        try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31");
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonSalvarMouseEntered

    private void jComboBoxDescricaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoMouseEntered
        PreencherDescricao();
    }//GEN-LAST:event_jComboBoxDescricaoMouseEntered

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
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxDescricao;
    private javax.swing.JComboBox<String> jComboBoxreferente;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldReferencia;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
