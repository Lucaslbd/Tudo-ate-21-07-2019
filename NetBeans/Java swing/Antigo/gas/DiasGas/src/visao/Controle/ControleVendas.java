package visao.Controle;



import java.sql.SQLException;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import modeloBeans.BeansFrenteCaixa;
import modeloBeans.BeansProdutos;
import modeloBeans.BeansVendas;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoFrenteCaixa;
import modeloDao.DaoProdutos;
import modeloDao.DaoVenda;




public class ControleVendas extends javax.swing.JFrame {
  ConexaoBD conex = new ConexaoBD();
  BeansVendas mod = new BeansVendas();  
  DaoVenda control = new DaoVenda();
  BeansProdutos modProdutos = new BeansProdutos();
  DaoProdutos Produtos = new DaoProdutos();
  DecimalFormat df = new DecimalFormat("0.##");
  BeansFrenteCaixa mod1 = new BeansFrenteCaixa();  
  DaoFrenteCaixa control1 = new DaoFrenteCaixa();
  
    public ControleVendas() {
        initComponents();          
        
    }   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldCodProduto = new javax.swing.JTextField();
        produto = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldCasco = new javax.swing.JTextField();
        jTextFieldTesteCartao = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        Atualizar = new javax.swing.JButton();
        jButtonDesfaer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPesquisarTudo = new javax.swing.JTextField();
        jButtonPesquisarTudo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCodigo.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldCodProduto.setEnabled(false);

        produto.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        jTextFieldCasco.setEnabled(false);

        jTextFieldTesteCartao.setEnabled(false);

        jTextFieldValor.setEnabled(false);

        jTextFieldQuantidade.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendas);

        Atualizar.setText("Atualizar hoje");
        Atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        jButtonDesfaer.setText("Desfazer venda");
        jButtonDesfaer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDesfaer.setEnabled(false);
        jButtonDesfaer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesfaerActionPerformed(evt);
            }
        });

        jLabel14.setText("Data");

        jButtonPesquisarTudo.setText("Pesquisar");
        jButtonPesquisarTudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisarTudo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisarTudo)
                        .addGap(18, 18, 18)
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDesfaer)
                        .addGap(234, 234, 234)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atualizar)
                    .addComponent(jButtonDesfaer)
                    .addComponent(jButtonPesquisarTudo)
                    .addComponent(jTextFieldPesquisarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Excluir/Editar/Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDesfaerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesfaerActionPerformed
       if(jTextFieldCodigo.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane,"Selecione uma venda para excluir");
         }else{       
               
                String produ = produto.getText();
        conex.Conexao();
         try {
               conex.executaSql("select * from produtos where nome_produto='"+produ+"'");
               conex.rs.first();
               jTextFieldVazio.setText(conex.rs.getString("vazio"));
               jTextFieldCheio.setText(conex.rs.getString("cheio"));
               jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
        
       
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente desfazer a venda com codigo " +  jTextFieldCodigo.getText()+" ?" );
         
       switch (resposta) {
        case JOptionPane.NO_OPTION:
            jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");
        
        jTextFieldValor.setText("");
        jTextFieldValor.setEnabled(false);
       
        jTextFieldTesteCartao.setText("");
        
        jButtonDesfaer.setEnabled(false);
       
            break;
        case JOptionPane.CANCEL_OPTION:
            jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");   
           
        jTextFieldValor.setText("");
        jTextFieldValor.setEnabled(false);
       
        jTextFieldTesteCartao.setText("");
       
        jButtonDesfaer.setEnabled(false);
      
            break;
        case JOptionPane.YES_OPTION:
           mod.setCodVenda(Integer.parseInt(jTextFieldCodigo.getText()));
           control.Excluir(mod);
           
          double t = Double.parseDouble(jTextFieldValor.getText());
          double r = t-t-t;
          if( jTextFieldValor.getText().equals(jTextFieldTesteCartao.getText()) ){
          mod1.setPagamento("Dinheiro");
          mod1.setTipoPagamento("Cancelamento");
          mod1.setValorTotal(r);
          control1.fechamento(mod1);           
          }else{
          mod1.setPagamento("Cartão");
          mod1.setTipoPagamento("Cancelamento");
          mod1.setValorTotal(r);
          control1.fechamento(mod1); 
          }
           
           if(jTextFieldCasco.getText().equals ("Venda sem casco")){     
              
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldQuantidade.getText()));
           int resultado = cheio + quantidade;
           int resultado2 = vazio - quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(resultado2);
           Produtos.EditarQ(modProdutos); 
             jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");
         
        jTextFieldValor.setText("");
        jTextFieldValor.setEnabled(false);
        
        jButtonDesfaer.setEnabled(false);
         
                     
           }else{
                
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldQuantidade.getText()));
           int resultado = cheio + quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
           Produtos.EditarQ(modProdutos);
           jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");
           
        jTextFieldValor.setText("");
        jTextFieldValor.setEnabled(false);
        
        jTextFieldTesteCartao.setText("");
        
         jButtonDesfaer.setEnabled(false);
       
                          
           }       
            
        }
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
        String dtHoje;
         dtHoje = dateFormat.format(d);    
        preencherTabela("select * from vendas where data_venda ='"+dtHoje+"' order by codigo_Venda");
                      
          } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Produto não cadastrado"); 
              
         }       
         } 
    }//GEN-LAST:event_jButtonDesfaerActionPerformed

    private void jTableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendasMouseClicked
       String codigo =""+jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 0);
        conex.Conexao();
         try {
               conex.executaSql("select * from vendas where codigo_venda='"+codigo+"'");
               conex.rs.first();
               jTextFieldCodigo.setText(conex.rs.getString("codigo_venda"));
               produto.setText(conex.rs.getString("descricao_venda"));
               jTextFieldQuantidade.setText(conex.rs.getString("quantidade_venda"));
               jTextFieldCasco.setText(conex.rs.getString("casco"));
              
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_cobrado")));
               jTextFieldTesteCartao.setText(String.valueOf(conex.rs.getDouble("valor_vendac")));
              
               jButtonDesfaer.setEnabled(true);
        } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Codigo não cadastrado"); 
             }
        conex.Desconecta();
        
         
    }//GEN-LAST:event_jTableVendasMouseClicked

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
        String dtHoje;
         dtHoje = dateFormat.format(d);    
        preencherTabela("select * from vendas where data_venda ='"+dtHoje+"' order by codigo_Venda");
        
       
        
         
      
    }//GEN-LAST:event_AtualizarActionPerformed

    private void jButtonPesquisarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarTudoActionPerformed
         if(jTextFieldPesquisarTudo.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira sua pesquisa");
         jTextFieldPesquisarTudo.requestFocus();
  }else{
        mod.setPesquisar(jTextFieldPesquisarTudo.getText());
        preencherTabela("select *from vendas where data_venda like'%" + mod.getPesquisar()+"%' order by data_venda");
  
         
             
 
         }
 
    }//GEN-LAST:event_jButtonPesquisarTudoActionPerformed
 
    
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Descrição","Metodo","Valor R$","Casco","Quantidade","Data","Hora","Emissor"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("codigo_venda"),conex.rs.getString("descricao_venda"),conex.rs.getString("metodo"),conex.rs.getDouble("valor_cobrado"),conex.rs.getString("casco"),conex.rs.getString("quantidade_venda"),conex.rs.getString("data_venda"),conex.rs.getString("hora"),conex.rs.getString("usuario")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Venda não encontrada");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableVendas.setModel(modelo);
           jTableVendas.getColumnModel ().getColumn(0).setPreferredWidth(70);
           jTableVendas.getColumnModel().getColumn(0).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(1).setPreferredWidth(120);
           jTableVendas.getColumnModel().getColumn(1).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(2).setPreferredWidth(90);
           jTableVendas.getColumnModel().getColumn(2).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(3).setPreferredWidth(80);
           jTableVendas.getColumnModel().getColumn(3).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(4).setPreferredWidth(120);
           jTableVendas.getColumnModel().getColumn(4).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(5).setPreferredWidth(80);
           jTableVendas.getColumnModel().getColumn(5).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(6).setPreferredWidth(80);
           jTableVendas.getColumnModel().getColumn(6).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(7).setPreferredWidth(60);
           jTableVendas.getColumnModel().getColumn(7).setResizable(false);
           jTableVendas.getColumnModel ().getColumn(8).setPreferredWidth(85);
           jTableVendas.getColumnModel().getColumn(8).setResizable(false);
           jTableVendas.getTableHeader().setReorderingAllowed(false);
           jTableVendas.setAutoResizeMode(jTableVendas.AUTO_RESIZE_OFF);
           jTableVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(ControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleVendas().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton jButtonDesfaer;
    private javax.swing.JButton jButtonPesquisarTudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldPesquisarTudo;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTesteCartao;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField produto;
    // End of variables declaration//GEN-END:variables
}

