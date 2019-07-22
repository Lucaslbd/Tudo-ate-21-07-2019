package br.com.deposito.tela.cadastros;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaProdutoAlterar extends javax.swing.JDialog {
    
    ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
      
    int cdProduto;
    public TelaProdutoAlterar(java.awt.Frame parent, boolean modal, int codigoDeposito,int codigoProduto) {
        super(parent, modal);
        initComponents();       
        PreencherFornecedores(codigoDeposito);
        preencherCampos(codigoProduto);
        cdProduto = codigoProduto;
    }

    private TelaProdutoAlterar(JFrame jFrame, boolean b) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldPrecoProduto = new javax.swing.JTextField();
        jTextFieldPrecoCasco = new javax.swing.JTextField();
        jTextFieldPrecoEntrega = new javax.swing.JTextField();
        jTextFieldEstoqueVazio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jTextFieldCustoProduto = new javax.swing.JTextField();
        jTextFieldCustoCasco = new javax.swing.JTextField();
        jTextFieldEstoqueCheio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jLabel3.setText("Preço do produto");

        jLabel4.setText("Preço do casco");

        jLabel5.setText("Preço da entrega");

        jLabel6.setText("Custo do produto");

        jLabel7.setText("Custo do casco");

        jLabel8.setText("Estoque cheio");

        jLabel9.setText("Estoque vazio");

        jButton1.setText("Alterar");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel11.setText("Fornecedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPrecoProduto)
                    .addComponent(jTextFieldPrecoCasco)
                    .addComponent(jTextFieldPrecoEntrega)
                    .addComponent(jTextFieldEstoqueVazio)
                    .addComponent(jTextFieldNome)
                    .addComponent(jComboBoxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustoProduto)
                    .addComponent(jTextFieldCustoCasco)
                    .addComponent(jTextFieldEstoqueCheio))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPrecoCasco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPrecoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCustoCasco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEstoqueCheio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEstoqueVazio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo nome não pode estar vazio");
            jTextFieldNome.requestFocus();
        } else if (jTextFieldPrecoProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo preço do produto não pode estar vazio");
            jTextFieldPrecoProduto.requestFocus();
        } else if (jTextFieldPrecoCasco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo preço do casco não pode estar vazio");
            jTextFieldPrecoCasco.requestFocus();
        } else if (jTextFieldPrecoEntrega.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo preço da entrega não pode estar vazio");
            jTextFieldPrecoEntrega.requestFocus();        
        } else if (jTextFieldCustoProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo custo do produto não pode estar vazio");
            jTextFieldCustoProduto.requestFocus();
        } else if (jTextFieldCustoCasco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo custo do casco não pode estar vazio");
            jTextFieldCustoCasco.requestFocus();
        } else if (jTextFieldEstoqueCheio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo estoque cheio não pode estar vazio");
            jTextFieldEstoqueCheio.requestFocus();
        } else if (jTextFieldEstoqueVazio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo estoque vazio não pode estar vazio");
            jTextFieldEstoqueVazio.requestFocus();
        } else {
            int i = jComboBoxFornecedor.getSelectedIndex();
            Fornecedor fornecedor = listaFornecedor.get(i);
            ProdutoDao dao = new ProdutoDao();
            Produto produto = new Produto();
            produto.setFornecedor(fornecedor);
            produto.setCustoCasco(Double.parseDouble(jTextFieldCustoCasco.getText()));
            produto.setCustoProduto(Double.parseDouble(jTextFieldCustoProduto.getText()));
            produto.setValorCasco(Double.parseDouble(jTextFieldPrecoCasco.getText()));
            produto.setValorEntrega(Double.parseDouble(jTextFieldPrecoEntrega.getText()));
            produto.setNome(jTextFieldNome.getText());
            produto.setEstoqueVazio(Integer.parseInt(jTextFieldEstoqueVazio.getText()));
            produto.setValorPortaria(Double.parseDouble(jTextFieldPrecoProduto.getText()));
            produto.setEstoqueCheio(Integer.parseInt(jTextFieldEstoqueCheio.getText()));           
            produto.setCodigo(cdProduto);
            dao.Alterar(produto);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            Double.parseDouble(jTextFieldPrecoProduto.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPrecoProduto.getText())) {
                JOptionPane.showMessageDialog(null, "O campo preço do produto somente pode receber numeros reais ex: 50.31");
                jTextFieldPrecoProduto.setText("");
                jTextFieldPrecoProduto.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldPrecoCasco.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPrecoCasco.getText())) {
                JOptionPane.showMessageDialog(null, "O campo preço de custo somente pode receber numeros reais ex: 50.31");
                jTextFieldPrecoCasco.setText("");
                jTextFieldPrecoCasco.requestFocus();
            }
        }
          try {
            Double.parseDouble(jTextFieldPrecoEntrega.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPrecoEntrega.getText())) {
                JOptionPane.showMessageDialog(null, "O campo preço da entrega somente pode receber numeros reais ex: 50.31");
                jTextFieldPrecoEntrega.setText("");
                jTextFieldPrecoEntrega.requestFocus();
            }
        }           
              try {
            Double.parseDouble(jTextFieldCustoProduto.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldCustoProduto.getText())) {
                JOptionPane.showMessageDialog(null, "O campo custo do produto somente pode receber numeros reais ex: 50.31");
                jTextFieldCustoProduto.setText("");
                jTextFieldCustoProduto.requestFocus();
            }
        }
                try {
            Double.parseDouble(jTextFieldCustoCasco.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldCustoCasco.getText())) {
                JOptionPane.showMessageDialog(null, "O campo custo do cascoo somente pode receber numeros reais ex: 50.31");
                jTextFieldCustoCasco.setText("");
                jTextFieldCustoCasco.requestFocus();
            }
        }
        try {
            Integer.parseInt(jTextFieldEstoqueCheio.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldEstoqueCheio.getText())) {
                JOptionPane.showMessageDialog(null, "O campo estoque cheio somente pode receber numeros inteiros ex: 50");
                jTextFieldEstoqueCheio.setText("");
                jTextFieldEstoqueCheio.requestFocus();
            }
        }
         try {
            Integer.parseInt(jTextFieldEstoqueVazio.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldEstoqueVazio.getText())) {
                JOptionPane.showMessageDialog(null, "O campo estoque vazio somente pode receber numeros inteiros ex: 50");
                jTextFieldEstoqueVazio.setText("");
                jTextFieldEstoqueVazio.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void PreencherFornecedores(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fornecedor inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_empresa=? order by nome");
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            jComboBoxFornecedor.removeAllItems();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));           
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(deposito);
                listaFornecedor.add(fornecedor);
                jComboBoxFornecedor.addItem(resultado.getString("nome"));
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }       
    }
    
    private void preencherCampos(int cd){
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(cd);
        jTextFieldNome.setText(produto.getNome());            
        jTextFieldPrecoProduto.setText(String.valueOf(produto.getValorPortaria()));            
        jTextFieldPrecoCasco.setText(String.valueOf(produto.getValorCasco()));            
        jTextFieldPrecoEntrega.setText(String.valueOf(produto.getValorEntrega()));            
        jTextFieldCustoProduto.setText(String.valueOf(produto.getCustoProduto()));            
        jTextFieldCustoCasco.setText(String.valueOf(produto.getCustoCasco()));           
        jTextFieldEstoqueCheio.setText(String.valueOf(produto.getEstoqueCheio()));           
        jTextFieldEstoqueVazio.setText(String.valueOf(produto.getEstoqueVazio()));
        jComboBoxFornecedor.setSelectedItem(produto.getFornecedor().getNome());
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
            java.util.logging.Logger.getLogger(TelaProdutoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProdutoAlterar dialog = new TelaProdutoAlterar(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCustoCasco;
    private javax.swing.JTextField jTextFieldCustoProduto;
    private javax.swing.JTextField jTextFieldEstoqueCheio;
    private javax.swing.JTextField jTextFieldEstoqueVazio;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPrecoCasco;
    private javax.swing.JTextField jTextFieldPrecoEntrega;
    private javax.swing.JTextField jTextFieldPrecoProduto;
    // End of variables declaration//GEN-END:variables
}
