package br.com.deposito.tela.cadastros;

import br.com.deposito.tela.cadastros.TelaClienteAlterar;
import br.com.deposito.tela.cadastros.TelaClienteHistoricoVenda;
import br.com.deposito.tela.cadastros.TelaClienteNovo;
import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.dao.ClienteDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.Produto;
import br.com.deposito.domain.Usuario;
import br.com.deposito.util.ModeloTabela;
import br.com.deposito.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaProduto extends javax.swing.JFrame {

    private Usuario usuario;
    DefaultListModel Modelo;
    int selecionado = 0;

    public TelaProduto(Usuario u) {
        initComponents();
        usuario = u;
        jList2.setVisible(false);
        Modelo = new DefaultListModel();
        jList2.setModel(Modelo);
    }

    private TelaProduto() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBorder(null);

        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

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

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Fornecedor" }));

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("+ Informações");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisar))
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        pesquisar();
        jList2.removeAll();
        Modelo.removeAllElements();
        jList2.setVisible(false);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
        PreencherLista();
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        String pesquisa = null;
        if (jComboBoxTipoPesquisa.getSelectedItem().equals("Nome")) {
            pesquisa = "nome_produto";
        } else if (jComboBoxTipoPesquisa.getSelectedItem().equals("Fornecedor")) {
            pesquisa = "nome";
        }
        String item = jList2.getSelectedValue();
        preencherTabela("select * from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor where empresa = " + usuario.getDeposito().getCodigo() + " and " + pesquisa + " ='" + item + "'");
        jTextFieldPesquisa.setText(item);
        jList2.setVisible(false);
    }//GEN-LAST:event_jList2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaProdutoNovo dialog = new TelaProdutoNovo(new javax.swing.JFrame(), true, usuario.getDeposito().getCodigo());
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (selecionado == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto para poder excluir");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ao remover um produto também serão removidos seus respectivos registros");
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o produto?");
            if (resposta == JOptionPane.YES_OPTION) {
                ProdutoDao dao = new ProdutoDao();
                dao.excluir(selecionado);
            }
            selecionado = 0;
            pesquisar();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        selecionado = (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0);
    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (selecionado == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto para poder alterar");
        } else {
            TelaProdutoAlterar dialog = new TelaProdutoAlterar(new javax.swing.JFrame(), true, usuario.getDeposito().getCodigo(), selecionado);
            dialog.setVisible(true);
            pesquisar();
            selecionado = 0;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (selecionado == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto para ter acesso as suas informações");
        } else {
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.buscarCodigo(selecionado);
            JOptionPane.showMessageDialog(rootPane,
                    "Nome: " + produto.getNome() + "\n"
                    + "Estoque cheio: " + produto.getEstoqueCheio() + "\n"
                    + "Estoque vazio: " + produto.getEstoqueVazio() + "\n"
                    + "Preço de venda: " + produto.getValorPortaria() + "\n"
                    + "Valor entrega: " + produto.getValorEntrega() + "\n"
                    + "Valor do casco: " + produto.getValorCasco() + "\n"                    
                    + "Custo do produto: " + produto.getCustoProduto() + "\n"
                    + "Custo do casco: " + produto.getCustoCasco() + "\n"
                    + "Fornecedor: " + produto.getFornecedor().getNome() + "\n");
            selecionado = 0;
            pesquisar();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void PreencherLista() {
        String pesquisa = null;
        if (jComboBoxTipoPesquisa.getSelectedItem().equals("Nome")) {
            pesquisa = "nome_produto";
        } else if (jComboBoxTipoPesquisa.getSelectedItem().equals("Fornecedor")) {
            pesquisa = "nome";
        }
        if (jTextFieldPesquisa.getText().isEmpty()) {
            jList2.removeAll();
            Modelo.removeAllElements();
            jList2.setVisible(false);
        } else {
            jList2.setVisible(true);
            StringBuilder sql = new StringBuilder();
            sql.append("select * from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor where empresa = ").append(usuario.getDeposito().getCodigo()).append(" and ").append(pesquisa).append(" ilike'%").append(jTextFieldPesquisa.getText()).append("%' order by ").append(pesquisa).append("");
            try {
                Connection conexao;
                conexao = ConexaoBD.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql.toString());
                ResultSet resultado = comando.executeQuery();
                jList2.removeAll();
                Modelo.removeAllElements();
                while (resultado.next()) {
                    Modelo.addElement(resultado.getString(pesquisa));
                }
                conexao.close();
                int i = jList2.getModel().getSize();
                if (i == 0) {
                    jList2.setVisible(false);
                } else {
                    jList2.setVisible(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }

    private void pesquisar() {
        if (jComboBoxTipoPesquisa.getSelectedItem().equals("Nome")) {
            preencherTabela("select * from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor where empresa = " + usuario.getDeposito().getCodigo() + " and nome_produto ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome_produto");
        } else if (jComboBoxTipoPesquisa.getSelectedItem().equals("Forneceor")) {
            preencherTabela("select * from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor where empresa = " + usuario.getDeposito().getCodigo() + " and nome ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
        }
    }

    public void preencherTabela(String sql) {
        UtilitarioDao util = new UtilitarioDao();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Produto", "Preço do produto", "Preço do casco", "Preço da entrega", "Estoque cheio", "Estoque vazio"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getInt("codigo_produto"), resultado.getString("nome_produto"), util.DecimalFormat(resultado.getDouble("valor_portaria")), util.DecimalFormat(resultado.getDouble("valor_casco")), util.DecimalFormat(resultado.getDouble("valor_entrega")), resultado.getInt("estoque_cheio"), resultado.getInt("estoque_vazio")});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(230);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaProduto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
