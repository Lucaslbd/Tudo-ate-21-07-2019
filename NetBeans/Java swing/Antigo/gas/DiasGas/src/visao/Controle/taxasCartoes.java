package visao.Controle;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansTaxas;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoTaxas;


public class taxasCartoes extends javax.swing.JFrame {
ConexaoBD conex = new ConexaoBD();
BeansTaxas mod = new BeansTaxas();
DaoTaxas control = new DaoTaxas();
   int flag =0; 
    public taxasCartoes() {
        initComponents();
        preencherTabela("select * from taxa_cartoes order by codigo");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldVerifica = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxModalidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTaxa = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCodigo.setEnabled(false);

        jTextFieldVerifica.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Modalidade");

        jComboBoxModalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credito", "Debito" }));
        jComboBoxModalidade.setEnabled(false);
        jComboBoxModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModalidadeActionPerformed(evt);
            }
        });

        jLabel3.setText("Taxa");

        jTextFieldTaxa.setEnabled(false);

        jButtonSalvar.setText("Salvar");
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
        jScrollPane2.setViewportView(jTableProdutos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNovo)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Taxas de cartões");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
         int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente retirar da lista");
        if(resposta ==JOptionPane.YES_OPTION){
        mod.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
        control.Excluir(mod);       
         jTextFieldCodigo.setText("");
        jTextFieldTaxa.setText("");
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
         preencherTabela("select * from taxa_cartoes order by codigo");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(flag==2){
                     mod.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
            mod.setTaxa(Double.parseDouble(jTextFieldTaxa.getText()));
            control.Editar(mod);
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);      
       jTextFieldTaxa.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);       
       jComboBoxModalidade.setEnabled(false);       
       jTextFieldTaxa.setText("");
       jTextFieldCodigo.setText("");
        preencherTabela("select * from taxa_cartoes order by codigo"); 
        }else{ 
        
        String codigo = (String) jComboBoxModalidade.getSelectedItem();
        conex.Conexao();
         try {
               conex.executaSql("select * from taxa_cartoes where tipo='"+codigo+"'");
               conex.rs.first();
               jTextFieldVerifica.setText(conex.rs.getString("tipo"));
               JOptionPane.showMessageDialog(null,"Você ja definiu taxas para "+ jTextFieldVerifica.getText());
                           
              } catch  (SQLException ex) {        
                           
              } 
         if(jTextFieldVerifica.getText().equals("")){
                    if( jTextFieldTaxa.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a taxa para o cartão");
          jTextFieldTaxa.requestFocus();
        }else if(flag==1){
        mod.setModalidade((String) jComboBoxModalidade.getSelectedItem());
        mod.setTaxa(Double.parseDouble(jTextFieldTaxa.getText()));
      control.Salvar(mod);
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);      
       jTextFieldTaxa.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);       
       jComboBoxModalidade.setEnabled(false);       
       jTextFieldTaxa.setText("");
        preencherTabela("select * from taxa_cartoes order by codigo");   
        }       
        
               }else{
             jTextFieldVerifica.setText("");
         }
        }     
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag = 1;
       jButtonNovo.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jComboBoxModalidade.setEnabled(true);
       jTextFieldTaxa.setEnabled(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       flag =2;
       jButtonNovo.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jComboBoxModalidade.setEnabled(false);
       jTextFieldTaxa.setEnabled(true);
       jButtonExcluir.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jComboBoxModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModalidadeActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
      String cliente_nome =""+jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from taxa_cartoes where codigo='"+ cliente_nome +"'");
           try {
               conex.rs.first();
               jTextFieldCodigo.setText(String.valueOf(conex.rs.getInt("codigo")));
               jTextFieldTaxa.setText(String.valueOf(conex.rs.getDouble("taxa")));
               jComboBoxModalidade.setSelectedItem(conex.rs.getString("tipo"));
               jButtonNovo.setEnabled(false);
               jButtonEditar.setEnabled(true);
               jButtonExcluir.setEnabled(true);
               jButtonCancelar.setEnabled(true);
               jTextFieldTaxa.setEnabled(false);
               jButtonSalvar.setEnabled(false);
         } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);      
       jTextFieldTaxa.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);       
       jComboBoxModalidade.setEnabled(false);       
       jTextFieldTaxa.setText("");
       jTextFieldCodigo.setText("");
        preencherTabela("select * from taxa_cartoes order by codigo");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseEntered
        try {  
    Double.parseDouble(jTextFieldTaxa.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldTaxa.getText())){
    JOptionPane.showMessageDialog(null, "O campo taxa somente pode receber numeros do tipo real ex: 50.31");  
    jTextFieldTaxa.setText("");
    jTextFieldTaxa.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonSalvarMouseEntered

   public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Codigo","Modalidade","Taxa"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("codigo"),conex.rs.getString("tipo"),conex.rs.getDouble("taxa")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableProdutos.setModel(modelo);
           jTableProdutos.getColumnModel ().getColumn(0).setPreferredWidth(60);
           jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(1).setPreferredWidth(150);
           jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(2).setPreferredWidth(150);
           jTableProdutos.getColumnModel().getColumn(2).setResizable(false);
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
            java.util.logging.Logger.getLogger(taxasCartoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(taxasCartoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(taxasCartoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(taxasCartoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new taxasCartoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldTaxa;
    private javax.swing.JTextField jTextFieldVerifica;
    // End of variables declaration//GEN-END:variables
}
