package Visao.Caixa;

import Beans.BeansPreencheTableVenda;
import Beans.BeansVenda;
import Beans.ModeloTabela;
import Dao.DaoTableModelVenda;
import Dao.DaoVenda;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;                                
import modeloConection.ConexaoBD;

    //jTextFieldCodigo
    //jTextFieldDescricao
    //jTextFieldEstoque
    //jTextFieldFornecedor
    //jTextFieldValor
    //jTextFieldCategoria
    //jTextFieldQuantidade


public class FrenteCaixa extends javax.swing.JFrame {
    Troco troco = new Troco();
    
    
//DaoTableModelVenda tableModel = new DaoTableModelVenda();
 ConexaoBD conex = new ConexaoBD();
 DaoVenda control = new DaoVenda();
 BeansVenda mod = new BeansVenda();
 Troco recebe = new Troco();
 Remover remove = new Remover();
 DecimalFormat df = new DecimalFormat("0.##");
 
  
    public FrenteCaixa() {
        initComponents();
        atualizapreco();
        preencherTabela("select * from caixa1 order by cod_venda");         
         
         jButtonFinalizar.setMnemonic(KeyEvent.VK_A);
         jButtonRemover.setMnemonic(KeyEvent.VK_B);
         jButtonCancelar.setMnemonic(KeyEvent.VK_C);
         jTextFieldCodigo.requestFocus();
        
    
        
    
         //redimencionaColunas();        
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldFornecedor = new javax.swing.JTextField();
        jTextFieldEstoque = new javax.swing.JTextField();
        jTextFieldCodVenda = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jTextFieldCategoria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonRemover = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jTextFieldFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFornecedorActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Frente de caixa");

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProdutos.getTableHeader().setReorderingAllowed(false);
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTotal.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("R$");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Produto");

        jTextFieldCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCodigoMouseClicked(evt);
            }
        });
        jTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyPressed(evt);
            }
        });

        jLabel2.setText("Codigo");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });
        jButtonFinalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonFinalizarKeyPressed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Qtd");

        jTextFieldQuantidade.setText("1");
        jTextFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyPressed(evt);
            }
        });

        jButtonRemover.setText("Retirar item");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemover)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFinalizar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal)
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(418, 418, 418))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFornecedorActionPerformed
      
    }//GEN-LAST:event_jTextFieldFornecedorActionPerformed

    private void jTextFieldCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCodigoMouseClicked
       
    }//GEN-LAST:event_jTextFieldCodigoMouseClicked

    private void jTextFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           String codigo = jTextFieldCodigo.getText();
        conex.Conexao();
         try {
               conex.executaSql("select * from produtos where produto_codigo='"+codigo+"'");
               conex.rs.first();
               jTextFieldDescricao.setText(conex.rs.getString("nome_produto"));
               jTextFieldFornecedor.setText(conex.rs.getString("fornecedor_produto"));
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produto")));
               jTextFieldEstoque.setText(conex.rs.getString("estoque_produto"));
               jTextFieldCategoria.setText(conex.rs.getString("categoria"));
               
                if(jTextFieldCodigo.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o codigo do produto");
        jTextFieldCodigo.requestFocus();
     }else if(jTextFieldDescricao.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Coloque o codigo e aperte shift para preencher os campos");
         jTextFieldCodigo.requestFocus();
     }else if(jTextFieldQuantidade.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a quantidade da itens");
         jTextFieldQuantidade.requestFocus();
     }else if(jTextFieldFornecedor.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Coloque o codigo e aperte shift para preencher os campos");
         jTextFieldCodigo.requestFocus();
     }else if(jTextFieldValor.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Coloque o codigo e aperte shift para preencher os campos");
         jTextFieldCodigo.requestFocus();
     }else{  
            Double valor;
        valor = (Double.parseDouble( jTextFieldValor.getText())*Double.parseDouble(jTextFieldQuantidade.getText()));
         jTextFieldValor.setText(String.valueOf(valor));
         mod.setCodProduto(jTextFieldCodigo.getText());
         mod.setNomeProduto(jTextFieldDescricao.getText());
         mod.setQtdVenda(Integer.parseInt(jTextFieldQuantidade.getText()));
         mod.setValorVenda(valor);
         mod.setFornecedor(jTextFieldFornecedor.getText());
         mod.setCategoria(jTextFieldCategoria.getText());
         control.SalvarVenda(mod); 
       
         
        preencherTabela("select * from caixa1 order by cod_venda"); 
         atualizapreco();
    jTextFieldCodigo.setText("");
    jTextFieldDescricao.setText("");
    jTextFieldEstoque.setText("");
    jTextFieldFornecedor.setText("");
    jTextFieldValor.setText("");
    jTextFieldCategoria.setText("");
    jTextFieldQuantidade.setText("1");
     
     
      
     }           
    } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Codigo não cadastrado"); 
               jTextFieldCodigo.setText("");
                
         } 
        } 

    }//GEN-LAST:event_jTextFieldCodigoKeyPressed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
   double count=0;
    for (int i=0; i<=jTableProdutos.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableProdutos.getValueAt(i, 4).toString());
    jTextFieldCodigo.requestFocus();
 
 }
  
         if(recebe == null){
             recebe = new Troco();
             recebe.MostrarTelaTroco(this);
             recebe.recebendo(count);
         }else{
             recebe.MostrarTelaTroco(this);
             recebe.setState(Troco.NORMAL);
             recebe.recebendo(count);
         }
          
           preencherTabela("select * from caixa1 order by cod_venda"); 
           jTextFieldCodigo.requestFocus();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonFinalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonFinalizarKeyPressed
        
    }//GEN-LAST:event_jButtonFinalizarKeyPressed

    private void jTextFieldQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          
          jTextFieldCodigo.requestFocus();
        
        
       }
    }//GEN-LAST:event_jTextFieldQuantidadeKeyPressed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
        String codigo =""+jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from caixa1 where cod_venda='"+ codigo +"'");
           try {
               conex.rs.first();
               jTextFieldCodVenda.setText(String.valueOf(conex.rs.getString("cod_venda")));
               
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
       remove.MostrarTelaRemove(this);
      
        
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta ==JOptionPane.YES_OPTION){
            control.Cancelar(mod);
             preencherTabela("select * from caixa1 order by cod_venda"); 
             jTextFieldCodigo.requestFocus();
        }else{
             jTextFieldCodigo.requestFocus();
        }
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed
     
             
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Codigo venda","Codigo produto","Descrição","Quantidade","Valor","Fornecedor","Categoria"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("cod_venda"),conex.rs.getString("cod_produto"),conex.rs.getString("nome_produto"),conex.rs.getInt("quantidade_venda"),conex.rs.getDouble("valor_venda"),conex.rs.getString("fornecedor_produto"),conex.rs.getString("categoria_produto")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               jLabelTotal.setText("0,00"); 
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableProdutos.setModel(modelo);
        jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTableProdutos.getColumnModel().getColumn(1).setPreferredWidth(155);
        jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTableProdutos.getColumnModel().getColumn(3).setPreferredWidth(85);
        jTableProdutos.getColumnModel().getColumn(4).setPreferredWidth(85);
        jTableProdutos.getColumnModel().getColumn(5).setPreferredWidth(155);
        jTableProdutos.getColumnModel().getColumn(6).setPreferredWidth(140);
        jTableProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}
   
    public void atualizapreco(){
        double count=0;
    for (int i=0; i<=jTableProdutos.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableProdutos.getValueAt(i, 4).toString());
   String dx = df.format(count);
   jLabelTotal.setText(String.valueOf(dx));
    }
    }    
    public void executEmOutroAtualiza(){
         preencherTabela("select * from caixa1 order by cod_venda"); 
         atualizapreco();   
         jTextFieldCodigo.requestFocus();
    }
     public void executEmOutroFinaliza(){
         preencherTabela("select * from caixa1 order by cod_venda"); 
          jLabelTotal.setText("0,00");
          jTextFieldCodigo.setText("");
         jTextFieldCodigo.requestFocus();
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
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrenteCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldCodVenda;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
