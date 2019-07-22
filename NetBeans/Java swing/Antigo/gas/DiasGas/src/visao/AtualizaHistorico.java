package visao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansClientes;
import modeloBeans.BeansHistorico;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoHistorico;

public class AtualizaHistorico extends javax.swing.JFrame {

    BeansClientes mod = new BeansClientes();
    BeansHistorico hist = new BeansHistorico();
    DaoHistorico control = new DaoHistorico();
    ConexaoBD conex = new ConexaoBD();
    String cliente_nome;
    String rua;
    String numero;
    String telefone;
    String bairro;

    public AtualizaHistorico() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jComboBoxPesquisar = new javax.swing.JComboBox<>();
        jButtonConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jComboBoxPesquisar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesquisar por nome", "Pesquisar por rua", "Pesquisar por bairro", "Pesquisar por telefone" }));
        jComboBoxPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.setEnabled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableHistorico);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Historico do cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jComboBoxPesquisar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonConfirmar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar ao historico de venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por nome") {
            mod.setPesquisa(jTextFieldPesquisar.getText());
            preencherTabela("select *from clientes where cliente_nome ilike'%" + mod.getPesquisa() + "%'");

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por rua") {
            mod.setPesquisa(jTextFieldPesquisar.getText());
            preencherTabela("select *from clientes where cliente_rua ilike'%" + mod.getPesquisa() + "%'");

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por bairro") {
            mod.setPesquisa(jTextFieldPesquisar.getText());
            preencherTabela("select *from clientes where cliente_bairro ilike'%" + mod.getPesquisa() + "%'");

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por telefone") {
            mod.setPesquisa(jTextFieldPesquisar.getText());
            preencherTabela("select *from clientes where cliente_fone like'%" + mod.getPesquisa() + "%'");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        Calendar calendar = Calendar.getInstance();
        Date d = calendar.getTime();
        SimpleDateFormat conversao = new SimpleDateFormat("dd/MM/yyyy");
        conversao.format(d);
        String dtHoje;
        dtHoje = conversao.format(d);
        hist.setNome(cliente_nome);
        hist.setDataCompra(dtHoje);
        hist.setRua(rua);
        hist.setNumero(numero);
        hist.setTelefone(telefone);
        hist.setBairro(bairro);
        if (jTableHistorico.getRowCount() == 0) {
            hist.setPrevisao("00/00/0000");
            hist.setTempo(0);
        } else {
            dtHoje = conversao.format(d);
            String p1 = (jTableHistorico.getValueAt(0, 1).toString());
            
            int contalinha = jTableHistorico.getRowCount();
            try {
                Date data1 = conversao.parse(dtHoje);
                Date data2 = conversao.parse(p1);
                long diferencaMS = data1.getTime() - data2.getTime();
                long diferencaSegundos = diferencaMS / 1000;
                long diferencaMinutos = diferencaSegundos / 60;
                long diferencaHoras = diferencaMinutos / 60;
                long diferencaDias = diferencaHoras / 24;
                int resultado = (int) (diferencaDias / contalinha);                
                calendar.setTime(new java.util.Date());
                calendar.add(Calendar.DAY_OF_MONTH, resultado);
                String teste = conversao.format(calendar.getTime());
                Date data3 = conversao.parse(teste);
                String previsao = conversao.format(data3);
               // JOptionPane.showMessageDialog(rootPane,"Tempo de um gas para outro " +resultado+ " proxima data "+ previsao  );
                hist.setPrevisao(previsao);
                hist.setTempo(resultado);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro na conversão");
            }
        }
        control.Salvar(hist);
        dispose();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        cliente_nome = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        rua = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 2);
        numero = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3);
        telefone = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1);
        bairro = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 4);

        hist.setPesquisar(cliente_nome);
        preencherTabelaHistorico("select *from historico where nome like'%" + hist.getPesquisar() + "%' order by codigo");

        jButtonConfirmar.setEnabled(true);

    }//GEN-LAST:event_jTableClientesMouseClicked

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "Telefone", "Rua", "Numero", "Bairro"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("cliente_nome"), conex.rs.getString("cliente_fone"), conex.rs.getString("cliente_rua"), conex.rs.getString("cliente_numero"), conex.rs.getString("cliente_bairro")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    public void preencherTabelaHistorico(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "Ultima compra", "Previsão"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("nome"), conex.rs.getString("data_compra"), conex.rs.getString("previsao")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Este cliente ainda não tem historico");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableHistorico.setModel(modelo);
        jTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(165);
        jTableHistorico.getColumnModel().getColumn(0).setResizable(false);
        jTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTableHistorico.getColumnModel().getColumn(1).setResizable(false);
        jTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTableHistorico.getColumnModel().getColumn(2).setResizable(false);
        jTableHistorico.getTableHeader().setReorderingAllowed(false);
        jTableHistorico.setAutoResizeMode(jTableHistorico.AUTO_RESIZE_OFF);
        jTableHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            java.util.logging.Logger.getLogger(AtualizaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizaHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
