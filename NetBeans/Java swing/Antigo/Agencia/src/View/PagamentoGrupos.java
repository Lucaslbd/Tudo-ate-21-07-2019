package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoGrupos;
import TableModel.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class PagamentoGrupos extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansGrupos grupos = new BeansGrupos();
    DaoGrupos control = new DaoGrupos();
    int corrigir =0;
    int parcelas;
    double valorPago;
    int parcelaAntiga;
    double valorTotal;
    String tabelaSalvar;
    int codigo;
    ArrayList<String> NomeGrupo = new ArrayList();

    public PagamentoGrupos() {
        initComponents();
        PreencherGrupos();
        if (jComboBoxGrupos.getSelectedItem() == null) {

        } else {
            PreencherPassageiro();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPassageiro = new javax.swing.JComboBox<>();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldParcelas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Selecione o grupo");

        jComboBoxGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseReleased(evt);
            }
        });
        jComboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGruposActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione o passageiro");

        jComboBoxPassageiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxPassageiroMouseEntered(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jLabel4.setText("Parcelas");

        jTextFieldParcelas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldParcelas.setEnabled(false);

        jLabel5.setText("Valor");

        jTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValor.setEnabled(false);

        jButtonConfirmar.setText("Confirmar pagamento");
        jButtonConfirmar.setEnabled(false);
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonConfirmarMouseEntered(evt);
            }
        });
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(485, 485, 485))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(493, 493, 493))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(43, 43, 43))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registrar pagamentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxGruposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseEntered
 
    }//GEN-LAST:event_jComboBoxGruposMouseEntered

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if (jComboBoxGrupos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem grupos no sistema");
        } else if (jComboBoxPassageiro.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Ainda não existe passageiros no grupo");
        } else {
            int posicao = jComboBoxGrupos.getSelectedIndex();
            tabelaSalvar = NomeGrupo.get(posicao);
            String cliente = (String) jComboBoxPassageiro.getSelectedItem();
            preencherTabela("select * from " + tabelaSalvar + " INNER JOIN clientes on codigo_cliente = clientes.codigo WHERE clientes.nome='" + cliente + "'");
            jTextFieldParcelas.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jButtonConfirmar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
             
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxPassageiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPassageiroMouseEntered
      
    }//GEN-LAST:event_jComboBoxPassageiroMouseEntered

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        parcelas = (int) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 6);
        valorPago = (double) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 7);
        parcelaAntiga = (int) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 4);
        valorTotal = (double) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3);
        codigo = (int) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);        

        jTextFieldParcelas.setEnabled(true);
        jTextFieldValor.setEnabled(true);
        jButtonConfirmar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jTextFieldParcelas.requestFocus();
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (jTextFieldParcelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo parcelas não pode estar vazio");
            jTextFieldParcelas.requestFocus();
        }else if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo valor não pode estar vazio");
            jTextFieldValor.requestFocus();
        }else if (Double.parseDouble(jTextFieldValor.getText()) <= 0){
            JOptionPane.showMessageDialog(rootPane, "O campo valor não pode ser 0 ou menor");
            jTextFieldValor.requestFocus();
        }else if (Integer.parseInt(jTextFieldParcelas.getText()) <= 0){
            JOptionPane.showMessageDialog(rootPane, "O campo parcelas não pode ser 0 ou menor");
            jTextFieldParcelas.requestFocus();
        } else {
            int novaParcela = parcelas + Integer.parseInt(jTextFieldParcelas.getText());
            double novoValor = valorPago + Double.parseDouble(jTextFieldValor.getText());
            if (novoValor > valorTotal) {
                JOptionPane.showMessageDialog(rootPane, "O valor pago pelo cliente não pode ser maior que o valor do pacote");
                 jTextFieldValor.requestFocus();
               }else if(novaParcela > parcelaAntiga){
                 JOptionPane.showMessageDialog(rootPane,"O numero de parcelas a serem pagas não pode ser maior que o parcelamento");
                 jTextFieldParcelas.requestFocus();
               }else if(novoValor < valorTotal && novaParcela == parcelaAntiga){
                  JOptionPane.showMessageDialog(rootPane,"O valor restante precisa ser pago nessa parcela, pois ela é a ultima");
                  jTextFieldValor.requestFocus();
                } else {

                grupos.setParcelasPagas(novaParcela);
                grupos.setValorPago(novoValor);
                grupos.setCodigo(codigo);
                control.EfetuarPagamento(grupos, tabelaSalvar);
                jTextFieldParcelas.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jButtonConfirmar.setEnabled(false);
                jButtonCancelar.setEnabled(false);
                jTextFieldParcelas.setText("");
                jTextFieldValor.setText("");
                PreencherPassageiro();
                preencherTabela2();
                /*String cliente =(String) jComboBoxPassageiro.getSelectedItem();
                *preencherTabela("select * from " + );*/
            }
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseEntered
        try {
            Double.parseDouble(jTextFieldParcelas.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldParcelas.getText())) {
                JOptionPane.showMessageDialog(null, "O campo parcelas somente pode receber numeros inteiros ex: 50");
                jTextFieldParcelas.setText("");
                jTextFieldParcelas.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31");
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonConfirmarMouseEntered

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldParcelas.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jButtonConfirmar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jTextFieldParcelas.setText("");
        jTextFieldValor.setText("");
        int posicao = jComboBoxGrupos.getSelectedIndex();
        String tabela = NomeGrupo.get(posicao);
        String cliente = (String) jComboBoxPassageiro.getSelectedItem();
        preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo WHERE clientes.nome='" + cliente + "'");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxGruposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseExited
       
    }//GEN-LAST:event_jComboBoxGruposMouseExited

    private void jComboBoxGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMousePressed
       
    }//GEN-LAST:event_jComboBoxGruposMousePressed

    private void jComboBoxGruposMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseReleased
     
    }//GEN-LAST:event_jComboBoxGruposMouseReleased

    private void jComboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGruposActionPerformed
   if(corrigir ==0){
     corrigir =1;
   }else{
    if (jComboBoxGrupos.getSelectedItem() == null) {

        } else {
            PreencherPassageiro();
        }   
   }
    }//GEN-LAST:event_jComboBoxGruposActionPerformed

    public void PreencherPassageiro() {
        try {
            int posicao = jComboBoxGrupos.getSelectedIndex();
            String tabela = NomeGrupo.get(posicao);
            conex.Conexao();
            conex.executaSql("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Passageiro' and valor != valor_pago order by clientes.nome");
            conex.rs.first();
            jComboBoxPassageiro.removeAllItems();
            do {
                jComboBoxPassageiro.addItem(conex.rs.getString("nome"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }   

    public void PreencherGrupos() {
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where situacao='Aberto' order by nomemelhorado");
        try {
            conex.rs.first();
            jComboBoxGrupos.removeAllItems();
            do {
                jComboBoxGrupos.addItem(conex.rs.getString("nomemelhorado"));
                NomeGrupo.add(conex.rs.getString("nome"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }
    public void preencherTabela2() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Cliente", "Pagamento", "Valor", "Parcelas", "Valor da parcela", "Parcelas pagas", "Valor pago","Restante"};
              
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(6).setResizable(false);
        jTableClientes.getColumnModel().getColumn(7).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(7).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //    jTableClientes.setSelectionBackground(Color.RED);
        conex.Desconecta();
    }


    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Cliente", "Pagamento", "Valor", "Parcelas", "Valor da parcela", "Parcelas pagas", "Valor pago","Restante"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("codigo"), conex.rs.getString("nome"), conex.rs.getString("forma_pagamento"), conex.rs.getDouble("valor"), conex.rs.getInt("numero_parcelas"),conex.rs.getDouble("valor") / conex.rs.getInt("numero_parcelas"), conex.rs.getInt("parcelas_pagas"), conex.rs.getDouble("valor_pago"),conex.rs.getDouble("valor")-conex.rs.getDouble("valor_pago")});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(6).setResizable(false);
        jTableClientes.getColumnModel().getColumn(7).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(7).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //    jTableClientes.setSelectionBackground(Color.RED);
        conex.Desconecta();
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
            java.util.logging.Logger.getLogger(PagamentoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagamentoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagamentoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagamentoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagamentoGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JComboBox<String> jComboBoxPassageiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
