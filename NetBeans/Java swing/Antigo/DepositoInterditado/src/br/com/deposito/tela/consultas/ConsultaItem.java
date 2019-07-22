package br.com.deposito.tela.consultas;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.dao.VendaDao;
import br.com.deposito.domain.Usuario;
import br.com.deposito.util.ModeloTabela;
import br.com.deposito.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ConsultaItem extends javax.swing.JFrame {

    DefaultListModel Modelo;
    int selecionado = 0;
    Usuario usuario;
    boolean pesquisou = false;

    public ConsultaItem(Usuario u) {
        initComponents();
        usuario = u;
        jList1.setVisible(false);
        Modelo = new DefaultListModel();
        jList1.setModel(Modelo);
    }

    private ConsultaItem() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxPesquisa = new javax.swing.JComboBox<>();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
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

        jLabel2.setText("Inicio");

        jLabel3.setText("Final");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Somar apurado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Somar lucro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setText("Filtro");

        jComboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produto", "Tipo da venda", "Forma pagamento", "Fornecedor" }));

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jScrollPane2.setBorder(null);

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton2.setText("Somar quantidade");
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
                .addGap(330, 330, 330)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextFieldPesquisa))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jDateChooser3.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos tipo data para poder realizar a pesquisa");
        } else {
            pesquisar();
            jList1.removeAll();
            Modelo.removeAllElements();
            jList1.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String pesquisa = null;
        if (jComboBoxPesquisa.getSelectedItem().equals("Tipo da venda")) {
            pesquisa = "tipo";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Forma pagamento")) {
            pesquisa = "forma_pagamento";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Produto")) {
            pesquisa = "nome_produto";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Fornecedor")) {
            pesquisa = "nome";
        }
        jTextFieldPesquisa.setText(jList1.getSelectedValue());
        if (jDateChooser3.getDate() == null || jDateChooser2.getDate() == null) {
            preencherTabela("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where codigo_empresa = " + usuario.getDeposito().getCodigo() + " and " + pesquisa + " ilike'%" + jTextFieldPesquisa.getText() + "%' order by data");
        } else {
            preencherTabela("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where data between '" + jDateChooser3.getDate() + "' and '" + jDateChooser2.getDate() + "' and codigo_empresa = " + usuario.getDeposito().getCodigo() + " and " + pesquisa + " ilike'%" + jTextFieldPesquisa.getText() + "%' order by data");
        }
        jList1.setVisible(false);
    }//GEN-LAST:event_jList1MouseClicked

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
        PreencherLista();
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!pesquisou) {
            JOptionPane.showMessageDialog(rootPane, "Faça um pesquisa para poder somar");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            double count = 0;
            for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
                count += Double.parseDouble(jTablePadrao.getValueAt(i, 5).toString());
            }
            JOptionPane.showMessageDialog(null, "O valor total em apurado é  " + util.DecimalFormat(count));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!pesquisou) {
            JOptionPane.showMessageDialog(rootPane, "Faça um pesquisa para poder somar");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            double count = 0;
            for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
                count += Double.parseDouble(jTablePadrao.getValueAt(i, 8).toString());
            }
            JOptionPane.showMessageDialog(null, "O valor total em lucro é  " + util.DecimalFormat(count));
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int cont = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            cont += Integer.parseInt(jTablePadrao.getValueAt(i, 4).toString());
        }
        JOptionPane.showMessageDialog(null, "O numero de itens vendidos é " + cont);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pesquisar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(jDateChooser2.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date data2 = calendar.getTime();
        String pesquisa = null;
        if (jComboBoxPesquisa.getSelectedItem().equals("Tipo da venda")) {
            pesquisa = "tipo";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Forma pagamento")) {
            pesquisa = "forma_pagamento";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Produto")) {
            pesquisa = "nome_produto";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Fornecedor")) {
            pesquisa = "nome";
        }
        jTextFieldPesquisa.setText(jList1.getSelectedValue());
        if (jDateChooser3.getDate() == null || jDateChooser2.getDate() == null) {
            preencherTabela("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where codigo_empresa = " + usuario.getDeposito().getCodigo() + " and " + pesquisa + " ilike'%" + jTextFieldPesquisa.getText() + "%' order by data");
        } else {
            preencherTabela("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where data between '" + jDateChooser3.getDate() + "' and '" + data2 + "' and codigo_empresa = " + usuario.getDeposito().getCodigo() + " and " + pesquisa + " ilike'%" + jTextFieldPesquisa.getText() + "%' order by data");
        }
        jList1.setVisible(false);
        pesquisou = true;
    }

    private void PreencherLista() {
        String pesquisa = null;
        if (jComboBoxPesquisa.getSelectedItem().equals("Tipo da venda")) {
            pesquisa = "tipo";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Forma pagamento")) {
            pesquisa = "forma_pagamento";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Produto")) {
            pesquisa = "nome_produto";
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Fornecedor")) {
            pesquisa = "nome";
        }
        if (jTextFieldPesquisa.getText().isEmpty()) {
            jList1.removeAll();
            Modelo.removeAllElements();
            jList1.setVisible(false);
        } else {
            jList1.setVisible(true);
            StringBuilder sql = new StringBuilder();
            sql.append("select DISTINCT ").append(pesquisa).append("  from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where codigo_empresa = ").append(usuario.getDeposito().getCodigo()).append(" and ").append(pesquisa).append(" ilike'%").append(jTextFieldPesquisa.getText()).append("%' order by ").append(pesquisa).append("");
            try {
                Connection conexao;
                conexao = ConexaoBD.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql.toString());
                ResultSet resultado = comando.executeQuery();
                jList1.removeAll();
                Modelo.removeAllElements();
                while (resultado.next()) {
                    Modelo.addElement(resultado.getString(pesquisa));
                }
                conexao.close();
                pesquisou = true;
                int i = jList1.getModel().getSize();
                if (i == 0) {
                    jList1.setVisible(false);
                } else {
                    jList1.setVisible(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }

    public void preencherTabela(String sql) {
        UtilitarioDao util = new UtilitarioDao();
        VendaDao dao = new VendaDao();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Data", "Produto", "Tipo", "Pagamento", "Qtd", "Valor", "Custo", "Desconto", "Lucro", "Porcentagem"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{util.ArrrumaTimeStamp(resultado.getTimestamp("data")), resultado.getString("nome_produto"), resultado.getString("tipo"), resultado.getString("forma_pagamento"), resultado.getInt("quantidade"), util.ArrumaDouble(resultado.getDouble("valor_item")), util.ArrumaDouble(resultado.getDouble("custo_item")), dao.calculaDesconto(resultado.getDouble("valor_item"), resultado.getDouble("desconto")), dao.calculaLucro(resultado.getDouble("valor_item"), resultado.getDouble("custo_item"), resultado.getDouble("desconto")), dao.calculaPorcetagem(resultado.getDouble("valor_item"), resultado.getDouble("custo_item"), resultado.getDouble("desconto"))});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Venda não encontrada" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(7).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(8).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(8).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(9).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(9).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
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
            java.util.logging.Logger.getLogger(ConsultaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConsultaItem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxPesquisa;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
