package Visao;

import Beans.BeansProduto;
import Beans.ModeloTabela;
import Dao.DaoProdutos;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloConection.ConexaoBD;


public class CadastroProdutos extends javax.swing.JFrame {
    ConexaoBD conex = new ConexaoBD();
    BeansProduto mod = new BeansProduto();
    DaoProdutos control = new DaoProdutos();
   int flag =0;
    public CadastroProdutos() {
        initComponents();
         preencherTabela("select * from produtos order by produto_codigo");
         //getRootPane().setDefaultButton(jButtonPequisar);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jTextFieldEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSugestão = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPequisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jComboBoxPesquisas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Produto");

        jLabel3.setText("Codigo");

        jLabel4.setText("Fornecedor");

        jTextFieldNome.setEnabled(false);

        jTextFieldFornecedor.setEnabled(false);

        jTextFieldCodigo.setEnabled(false);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor");

        jTextFieldValor.setEnabled(false);

        jTextFieldEstoque.setEnabled(false);

        jLabel6.setText("Estoque");

        jTextFieldSugestão.setEnabled(false);

        jLabel7.setText("Categoria");

        jButtonPequisar.setText("Pesquisar");
        jButtonPequisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPequisarActionPerformed(evt);
            }
        });

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jComboBoxPesquisas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Fornecedor", "Codigo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(141, 141, 141)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSugestão, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBoxPesquisas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPequisar)
                                .addGap(96, 96, 96)))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNovo)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSugestão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPesquisas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPequisar))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de produtos");

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
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag = 1;
       jTextFieldNome.setEnabled(true);
       jTextFieldFornecedor.setEnabled(true);
       jTextFieldEstoque.setEnabled(true);
       jTextFieldCodigo.setEnabled(true);
       jTextFieldValor.setEnabled(true);
       jTextFieldSugestão.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jTextFieldPesquisar.setEnabled(false);
       jButtonPequisar.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonNovo.setEnabled(false);
       jTextFieldPesquisar.setText("");
       jComboBoxPesquisas.setEnabled(false);
       
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jTextFieldNome.setEnabled(false);
       jTextFieldFornecedor.setEnabled(false);
       jTextFieldEstoque.setEnabled(false);
       jTextFieldCodigo.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jTextFieldSugestão.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldPesquisar.setEnabled(true);
       jButtonPequisar.setEnabled(true);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jComboBoxPesquisas.setEnabled(true);
       jTextFieldNome.setText("");
       jTextFieldFornecedor.setText("");
       jTextFieldEstoque.setText("");
       jTextFieldCodigo.setText("");
       jTextFieldValor.setText("");
       jTextFieldSugestão.setText("");
       jTextFieldPesquisar.setText("");
      
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldNome.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do produto");
         jTextFieldNome.requestFocus();
     }else if(jTextFieldCodigo.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o codigo do produto");
         jTextFieldCodigo.requestFocus();
     }else if(jTextFieldFornecedor.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o fornecedor do produto");
         jTextFieldFornecedor.requestFocus();
     }else if(jTextFieldValor.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o valor do produto");
         jTextFieldValor.requestFocus();
      }else if(jTextFieldEstoque.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o valor do estoque");
         jTextFieldEstoque.requestFocus();
      }else if(jTextFieldSugestão.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira uma sugestão de pedido");
         jTextFieldSugestão.requestFocus();
                  
      }else if(flag==1){        
        mod.setCodProduto(jTextFieldCodigo.getText());
        mod.setNomeProduto(jTextFieldNome.getText());
        mod.setFornecedorProduto(jTextFieldFornecedor.getText());
        mod.setValorProduto(Double.parseDouble(jTextFieldValor.getText()));
        mod.setEstoqueProduto(Integer.parseInt(jTextFieldEstoque.getText()));
        mod.setCategoriaProduto(jTextFieldSugestão.getText());
        control.Salvar(mod);
       jTextFieldNome.setEnabled(false);
       jTextFieldFornecedor.setEnabled(false);
       jTextFieldEstoque.setEnabled(false);
       jTextFieldCodigo.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jTextFieldSugestão.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldPesquisar.setEnabled(true);
       jButtonPequisar.setEnabled(true);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jComboBoxPesquisas.setEnabled(true);
       jTextFieldNome.setText("");
       jTextFieldFornecedor.setText("");
       jTextFieldEstoque.setText("");
       jTextFieldCodigo.setText("");
       jTextFieldValor.setText("");
       jTextFieldSugestão.setText("");
       jTextFieldPesquisar.setText("");
      }else{
        mod.setCodProduto(jTextFieldCodigo.getText());
        mod.setNomeProduto(jTextFieldNome.getText());
        mod.setFornecedorProduto(jTextFieldFornecedor.getText());
        mod.setValorProduto(Double.parseDouble(jTextFieldValor.getText()));
        mod.setEstoqueProduto(Integer.parseInt(jTextFieldEstoque.getText()));
        mod.setCategoriaProduto(jTextFieldSugestão.getText());
        control.Editar(mod);
         jTextFieldNome.setEnabled(false);
       jTextFieldFornecedor.setEnabled(false);
       jTextFieldEstoque.setEnabled(false);
       jTextFieldCodigo.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jTextFieldSugestão.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldPesquisar.setEnabled(true);
       jButtonPequisar.setEnabled(true);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jComboBoxPesquisas.setEnabled(true);
       jTextFieldNome.setText("");
       jTextFieldFornecedor.setText("");
       jTextFieldEstoque.setText("");
       jTextFieldCodigo.setText("");
       jTextFieldValor.setText("");
       jTextFieldSugestão.setText("");
       jTextFieldPesquisar.setText("");
      }
      
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag =2;
       jTextFieldNome.setEnabled(true);
       jTextFieldFornecedor.setEnabled(true);
       jTextFieldEstoque.setEnabled(true);
       jTextFieldCodigo.setEnabled(true);
       jTextFieldValor.setEnabled(true);
       jTextFieldSugestão.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jTextFieldPesquisar.setEnabled(false);
       jButtonPequisar.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonNovo.setEnabled(false);
        jComboBoxPesquisas.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
          String cliente_nome =""+jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from produtos where produto_codigo='"+ cliente_nome +"'");
           try {
               conex.rs.first();
               jTextFieldCodigo.setText(conex.rs.getString("produto_codigo"));
               jTextFieldNome.setText(conex.rs.getString("nome_produto"));
               jTextFieldFornecedor.setText(conex.rs.getString("fornecedor_produto"));
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produto")));
               jTextFieldEstoque.setText(conex.rs.getString("estoque_produto"));
               jTextFieldSugestão.setText(conex.rs.getString("categoria"));
               jButtonNovo.setEnabled(false);
               jButtonEditar.setEnabled(true);
               jButtonExcluir.setEnabled(true);
               jButtonCancelar.setEnabled(true);
               jComboBoxPesquisas.setEnabled(false);
               jTextFieldPesquisar.setEnabled(false);
               jButtonPequisar.setEnabled(false);
                 } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
       int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta ==JOptionPane.YES_OPTION){
            mod.setCodProduto(jTextFieldCodigo.getText());
            control.Excluir(mod);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonPequisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPequisarActionPerformed
         mod.setPesquisa(jTextFieldPesquisar.getText());
         if(jComboBoxPesquisas.getSelectedItem() == "Nome"){
            preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa()+"%'"); 
            
         }else if (jComboBoxPesquisas.getSelectedItem() == "Fornecedor"){        
         preencherTabela("select *from produtos where fornecedor_produto like'%" + mod.getPesquisa()+"%'");
         
         }else if (jComboBoxPesquisas.getSelectedItem() == "Codigo"){
           preencherTabela("select *from produtos where produto_codigo like'%" + mod.getPesquisa()+"%'");   
         }     
    }//GEN-LAST:event_jButtonPequisarActionPerformed

    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Codigo","Produto","Fornecedor","valor","Estoque","Categoria"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("Produto_codigo"),conex.rs.getString("nome_produto"),conex.rs.getString("fornecedor_produto"),conex.rs.getDouble("valor_produto"),conex.rs.getString("estoque_produto"),conex.rs.getString("categoria")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Produto não encontrado"+ ex.getMessage());
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableProdutos.setModel(modelo);
           jTableProdutos.getColumnModel ().getColumn(0).setPreferredWidth(120);
           jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(1).setPreferredWidth(200);
           jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(2).setPreferredWidth(170);
           jTableProdutos.getColumnModel().getColumn(2).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(3).setPreferredWidth(60);
           jTableProdutos.getColumnModel().getColumn(3).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(4).setPreferredWidth(70);
           jTableProdutos.getColumnModel().getColumn(4).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(5).setPreferredWidth(120);
           jTableProdutos.getColumnModel().getColumn(5).setResizable(false);
           jTableProdutos.getTableHeader().setReorderingAllowed(false);
           jTableProdutos.setAutoResizeMode(jTableProdutos.AUTO_RESIZE_OFF);
           jTableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPequisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxPesquisas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldSugestão;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
