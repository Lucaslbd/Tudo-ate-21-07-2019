package visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modeloBeans.BeansAutonomia;
import modeloBeans.BeansGastos;
import modeloConection.ConexaoBD;
import modeloDao.DaoAutonomia;
import modeloDao.DaoGastos;

public class Autonomia extends javax.swing.JFrame {

    BeansGastos mod = new BeansGastos();
    DaoGastos control = new DaoGastos();
    BeansAutonomia auto = new BeansAutonomia();
    DaoAutonomia controlauto = new DaoAutonomia();
    ConexaoBD conex = new ConexaoBD();

    public Autonomia() {
        initComponents();

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextFieldData.setText(dtHoje);
    }

    public void PreencherVeiculos() {
        conex.Conexao();
        conex.executaSql("select * from veiculos order by placa");
        try {
            conex.rs.first();
            jComboBoxVeiculo.removeAllItems();
            do {
                jComboBoxVeiculo.addItem(conex.rs.getString("placa"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonRegistrar = new javax.swing.JButton();
        jTextFieldValor = new javax.swing.JTextField();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxVeiculo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldKm = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLitros = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistrar.setEnabled(false);
        jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegistrarMouseEntered(evt);
            }
        });
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jTextFieldValor.setEnabled(false);

        jFormattedTextFieldData.setEnabled(false);

        jLabel2.setText("Veiculo");

        jComboBoxVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxVeiculo.setEnabled(false);
        jComboBoxVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxVeiculoMouseClicked(evt);
            }
        });

        jLabel3.setText("KM");

        jTextFieldKm.setEnabled(false);

        jLabel4.setText("Valor");

        jLabel5.setText("Data");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Litros");

        jTextFieldLitros.setEnabled(false);

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextFieldData)
                    .addComponent(jTextFieldKm)
                    .addComponent(jTextFieldValor)
                    .addComponent(jComboBoxVeiculo, 0, 131, Short.MAX_VALUE)
                    .addComponent(jTextFieldLitros))
                .addGap(44, 44, 44)
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonCancelar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro de autonomia dos veiculos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        if (jComboBoxVeiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Adicone um veiculo para podermos começar");
        } else if (jTextFieldKm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo KM");
            jTextFieldKm.requestFocus();
        } else if (jTextFieldLitros.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o numero de litros abastecidos");
            jTextFieldLitros.requestFocus();
        } else if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor");
            jTextFieldValor.requestFocus();
        } else if (jFormattedTextFieldData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a data");
            jFormattedTextFieldData.requestFocus();

        } else {
            String[] pagamentoaceito = {"Gastos", "Autonomia", "Gastos e autonomia"};
            String pagamento = String.valueOf(JOptionPane.showInputDialog(null,
                    "Escolha o que você deseja registrar", "Escolha", JOptionPane.QUESTION_MESSAGE, null, pagamentoaceito, pagamentoaceito[0]));
            switch (pagamento) {
                case "Gastos":
                    mod.setDescricaoGasto("Combustivel");
                    mod.setReferencia("Deposito");
                    mod.setValorGasto(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataGasto(jFormattedTextFieldData.getText());
                    control.Salvar(mod);
                    break;
                case "Autonomia":
                    auto.setVeiculo((String) jComboBoxVeiculo.getSelectedItem());
                    auto.setKm(jTextFieldKm.getText());
                    auto.setLitros(Double.parseDouble(jTextFieldLitros.getText()));
                    auto.setValor(Double.parseDouble(jTextFieldValor.getText()));
                    auto.setData(jFormattedTextFieldData.getText());
                    auto.setEntregas(0);
                    controlauto.Salvar(auto);
                    break;
                case "Gastos e autonomia":
                    mod.setDescricaoGasto("Combustivel");
                    mod.setReferencia("Deposito");
                    mod.setValorGasto(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataGasto(jFormattedTextFieldData.getText());
                    control.Salvar(mod);
                    
                    auto.setVeiculo((String) jComboBoxVeiculo.getSelectedItem());
                    auto.setKm(jTextFieldKm.getText());
                    auto.setLitros(Double.parseDouble(jTextFieldLitros.getText()));
                    auto.setValor(Double.parseDouble(jTextFieldValor.getText()));
                    auto.setData(jFormattedTextFieldData.getText());
                    auto.setEntregas(0);
                    controlauto.Salvar(auto);       
                 break;                
                    
            }
                    jTextFieldKm.setText("");
                    jTextFieldLitros.setText("");
                    jTextFieldValor.setText("");
                    jButtonNovo.setEnabled(true);
                    jButtonRegistrar.setEnabled(false);
                    jButtonCancelar.setEnabled(false);
                    jComboBoxVeiculo.setEnabled(false);
                    jTextFieldKm.setEnabled(false);
                    jTextFieldLitros.setEnabled(false);
                    jTextFieldValor.setEnabled(false);
                    jFormattedTextFieldData.setEnabled(false);
                    jButtonRegistrar.setEnabled(false);
            
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldKm.setText("");
        jTextFieldLitros.setText("");
        jTextFieldValor.setText("");
        jButtonNovo.setEnabled(true);
        jButtonRegistrar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jComboBoxVeiculo.setEnabled(false);
        jTextFieldKm.setEnabled(false);
        jTextFieldLitros.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jFormattedTextFieldData.setEnabled(false);
        jButtonRegistrar.setEnabled(false);

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoMouseClicked

    }//GEN-LAST:event_jComboBoxVeiculoMouseClicked

    private void jButtonRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarMouseEntered
        try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros do tipo real ex: 50.31");
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldLitros.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldLitros.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor em litros deve ser um valor do tipo real ex: 50.30");
                jTextFieldLitros.setText("");
                jTextFieldLitros.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonRegistrarMouseEntered

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        PreencherVeiculos();
        jButtonNovo.setEnabled(false);
        jButtonRegistrar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jComboBoxVeiculo.setEnabled(true);
        jTextFieldKm.setEnabled(true);
        jTextFieldLitros.setEnabled(true);
        jTextFieldValor.setEnabled(true);
        jFormattedTextFieldData.setEnabled(true);
        jTextFieldKm.requestFocus();

    }//GEN-LAST:event_jButtonNovoActionPerformed

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
            java.util.logging.Logger.getLogger(Autonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autonomia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboBoxVeiculo;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldKm;
    private javax.swing.JTextField jTextFieldLitros;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
