package visao.Controle;



import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansBaixa;
import modeloBeans.BeansProdutos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoBaixa;
import modeloDao.DaoProdutos;


public class ControleBaixas extends javax.swing.JFrame {
ConexaoBD conex = new ConexaoBD();
BeansBaixa mod = new BeansBaixa();
BeansProdutos modProdutos = new BeansProdutos();
DaoBaixa control = new DaoBaixa();
DaoProdutos ControlProdutos = new DaoProdutos();
   
    public ControleBaixas() {
     initComponents();
     
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldCasco = new javax.swing.JTextField();
        jTextFieldCodProduto = new javax.swing.JTextField();
        descricao = new javax.swing.JTextField();
        jTextFieldquantidade = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMotivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCodigo.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        jTextFieldCasco.setEnabled(false);

        jTextFieldCodProduto.setEnabled(false);

        descricao.setEnabled(false);

        jTextFieldquantidade.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Data");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(27, 27, 27))
        );

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Alterar baixa");

        jLabel3.setText("Motivo");

        jTextFieldMotivo.setEnabled(false);

        jLabel6.setText("Data");

        jTextFieldData.setEnabled(false);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonEditar))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Editar/Excluir/Baixas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(353, 353, 353))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       mod.setPesquisar(jFormattedTextFieldData.getText());
       preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
           

    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
if(jTextFieldCodigo.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane,"Selecione uma baixa para excluir");
   }else{
     String produto = descricao.getText();
        conex.Conexao();
         try {
               conex.executaSql("select * from produtos where nome_produto='"+produto+"'");
               conex.rs.first();
               jTextFieldVazio.setText(conex.rs.getString("vazio"));
               jTextFieldCheio.setText(conex.rs.getString("cheio"));
               jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
        } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Produto não cadastrado"); 
               jTextFieldCodigo.setText("");
         }      
       
       
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente desfazer a baixa com codigo " +  jTextFieldCodigo.getText()+" ?" );
         
       switch (resposta) {
        case JOptionPane.NO_OPTION:
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jTextFieldMotivo.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldCodigo.setText("");
       descricao.setText("");
       jTextFieldquantidade.setText("");
       jTextFieldCasco.setText("");
       jTextFieldVazio.setText("");
       jTextFieldCheio.setText("");
       jTextFieldCodProduto.setText("");
        jTextFieldMotivo.setText("");
       jTextFieldData.setText("");
       mod.setPesquisar(jFormattedTextFieldData.getText());
             preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
            break;
        case JOptionPane.CANCEL_OPTION:
            jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jTextFieldMotivo.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldCodigo.setText("");
       descricao.setText("");
       jTextFieldquantidade.setText("");
       jTextFieldCasco.setText("");
       jTextFieldVazio.setText("");
       jTextFieldCheio.setText("");
       jTextFieldCodProduto.setText("");
        jTextFieldMotivo.setText("");
       jTextFieldData.setText("");
       mod.setPesquisar(jFormattedTextFieldData.getText());
       
       preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
            break;
        case JOptionPane.YES_OPTION:
           mod.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
           control.Excluir(mod);
         
       preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
           
           if(jTextFieldCasco.getText().equals ("Sem casco")){     
              
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldquantidade.getText()));
           int resultado = cheio + quantidade;
           int resultado2 = vazio - quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(resultado2);
           ControlProdutos.EditarQ(modProdutos); 
             jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            descricao.setText("");
            jTextFieldquantidade.setText("");
            jTextFieldCasco.setText("");
            jTextFieldMotivo.setText("");
            jTextFieldData.setText("");
                     
           }else{
                
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldquantidade.getText()));
           int resultado = cheio + quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
           ControlProdutos.EditarQ(modProdutos);
           jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            descricao.setText("");
            jTextFieldquantidade.setText("");
            jTextFieldCasco.setText("");
            jTextFieldMotivo.setText("");
            jTextFieldData.setText("");
                          
           }       
            
        }
         
                      
                
         } 
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
       String codigo =""+jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0);
        conex.Conexao();
         try {
               conex.executaSql("select * from baixas where id_baixa='"+codigo+"'");
               conex.rs.first();
               jTextFieldCodigo.setText(conex.rs.getString("id_baixa"));
               descricao.setText(conex.rs.getString("produto_baixa"));
               jTextFieldquantidade.setText(conex.rs.getString("quatidade_baixa"));
               jTextFieldCasco.setText(conex.rs.getString("casco"));
               jTextFieldMotivo.setText(conex.rs.getString("motivo_baixa"));
               jTextFieldData.setText(conex.rs.getString("data_baixa"));
               jButtonExcluir.setEnabled(true);
               jButtonEditar.setEnabled(true);
               
         } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Codigo não cadastrado"); 
               jTextFieldCodigo.setText("");
            } 
               
               
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
      jTextFieldMotivo.setEnabled(true);
      jTextFieldData.setEnabled(true);
      jButtonSalvar.setEnabled(true);
      jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jTextFieldMotivo.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldMotivo.setText("");
       jTextFieldData.setText("");
       jTextFieldCodigo.setText("");
       descricao.setText("");
       jTextFieldquantidade.setText("");
       jTextFieldCasco.setText("");
       jTextFieldVazio.setText("");
       jTextFieldCheio.setText("");
       jTextFieldCodProduto.setText("");
       mod.setPesquisar(jFormattedTextFieldData.getText());
     
       preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        mod.setCodigo(Integer.parseInt( jTextFieldCodigo.getText()));
        mod.setMotivo(jTextFieldMotivo.getText());
        mod.setData(jTextFieldData.getText());
        control.Editar(mod);      
        jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jTextFieldMotivo.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldMotivo.setText("");
       jTextFieldData.setText("");
       jTextFieldCodigo.setText("");
       descricao.setText("");
       jTextFieldquantidade.setText("");
       jTextFieldCasco.setText("");
       jTextFieldVazio.setText("");
       jTextFieldCheio.setText("");
       jTextFieldCodProduto.setText("");
       mod.setPesquisar(jFormattedTextFieldData.getText());
      
       preencherTabela("select *from baixas where data_baixa like'%" + mod.getPesquisar()+"%' order by data_baixa");
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    
     
    
    
    
    
    
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Produto","Motivo","Quantidade","C/S Casco","Data"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("id_baixa"),conex.rs.getString("produto_baixa"),conex.rs.getString("motivo_baixa"),conex.rs.getString("quatidade_baixa"),conex.rs.getString("casco"),conex.rs.getString("data_baixa")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Baixa não encontrada");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableProdutos.setModel(modelo);
           jTableProdutos.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(1).setPreferredWidth(100);
           jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(2).setPreferredWidth(180);
           jTableProdutos.getColumnModel().getColumn(2).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(3).setPreferredWidth(75);
           jTableProdutos.getColumnModel().getColumn(3).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(4).setPreferredWidth(75);
           jTableProdutos.getColumnModel().getColumn(4).setResizable(false);
           jTableProdutos.getColumnModel ().getColumn(5).setPreferredWidth(75);
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
            java.util.logging.Logger.getLogger(ControleBaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleBaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleBaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleBaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleBaixas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descricao;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField jTextFieldquantidade;
    // End of variables declaration//GEN-END:variables
}
