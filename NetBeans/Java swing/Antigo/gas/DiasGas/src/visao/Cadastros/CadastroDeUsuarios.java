package visao.Cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansUsuario;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoUsuario;


public class CadastroDeUsuarios extends javax.swing.JFrame {
    BeansUsuario mod = new BeansUsuario();
    DaoUsuario dao = new DaoUsuario();
    ConexaoBD conex = new ConexaoBD();
     int flag =0;
   
    public CadastroDeUsuarios() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldUsuarioSenha = new javax.swing.JPasswordField();
        jPasswordFieldConfirmaSenha = new javax.swing.JPasswordField();
        jButtonNovo = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCod.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Usuário");

        jLabel3.setText("Tipo de usuário");

        jLabel4.setText("Senha");

        jLabel5.setText("Confirmar senha");

        jTextFieldUsuario.setEnabled(false);

        jPasswordFieldUsuarioSenha.setEnabled(false);

        jPasswordFieldConfirmaSenha.setEnabled(false);

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
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

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuario);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregador", "Recepcionista", "Administrador" }));
        jComboBoxTipoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxTipoUsuario.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPasswordFieldConfirmaSenha))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPasswordFieldUsuarioSenha)
                                                .addComponent(jComboBoxTipoUsuario, 0, 173, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordFieldUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jPasswordFieldConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       if(jTextFieldUsuario.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do Usuário");
         jTextFieldUsuario.requestFocus();
     }else if(jPasswordFieldUsuarioSenha.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a senha");
         jPasswordFieldUsuarioSenha.requestFocus();
     }else if (jPasswordFieldConfirmaSenha.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira confirme a senha");
         jPasswordFieldConfirmaSenha.requestFocus();
     }else if(jPasswordFieldUsuarioSenha.getText().equals(jPasswordFieldConfirmaSenha.getText())){ 
   
      if(flag==1){        
      mod.setUsuNome(jTextFieldUsuario.getText());
      mod.setUsuTipo((String)jComboBoxTipoUsuario.getSelectedItem());
      mod.setUsuSenha(jPasswordFieldUsuarioSenha.getText());
      dao.Salvar(mod);
       jTextFieldUsuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldUsuarioSenha.setEnabled(false);
       jPasswordFieldConfirmaSenha.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jTextFieldPesquisa.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
       jTextFieldUsuario.setText("");
       jPasswordFieldUsuarioSenha.setText("");
       jPasswordFieldConfirmaSenha.setText("");  
       jTextFieldPesquisa.setText("");
       preencherTabela("select * from usuarios order by usuario_nome");
     }else{
        mod.setUsuCod(Integer.parseInt(jTextFieldCod.getText()));  
        mod.setUsuNome(jTextFieldUsuario.getText());
        mod.setUsuTipo((String)jComboBoxTipoUsuario.getSelectedItem());
        mod.setUsuSenha(jPasswordFieldUsuarioSenha.getText());
        dao.Editar(mod);
       jTextFieldUsuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldUsuarioSenha.setEnabled(false);
       jPasswordFieldConfirmaSenha.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jButtonAlterar.setEnabled(false);
       jTextFieldPesquisa.setEnabled(true);
       jButtonPesquisar.setEnabled(true);
       jTextFieldUsuario.setText("");
       jPasswordFieldUsuarioSenha.setText("");
       jPasswordFieldConfirmaSenha.setText("");  
       jTextFieldPesquisa.setText("");
       jTextFieldCod.setText("");
       preencherTabela("select * from usuarios order by usuario_nome");
     }
     }else{
             JOptionPane.showMessageDialog(null,"As senhas não correspondem");
     }        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag = 1;
       jTextFieldUsuario.setEnabled(true);
       jComboBoxTipoUsuario.setEnabled(true);
       jPasswordFieldUsuarioSenha.setEnabled(true);
       jPasswordFieldConfirmaSenha.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonPesquisar.setEnabled(false); 
       jTextFieldPesquisa.setEnabled(false);
       
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jTextFieldUsuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldUsuarioSenha.setEnabled(false);
       jPasswordFieldConfirmaSenha.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jButtonAlterar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
        jTextFieldPesquisa.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
       jTextFieldUsuario.setText("");
       jPasswordFieldUsuarioSenha.setText("");
       jPasswordFieldConfirmaSenha.setText("");  
       jTextFieldPesquisa.setText("");
       jTextFieldCod.setText("");
       preencherTabela("select * from usuarios order by usuario_nome");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
       flag =2;
       jTextFieldUsuario.setEnabled(true);
       jComboBoxTipoUsuario.setEnabled(true);
       jPasswordFieldUsuarioSenha.setEnabled(true);
       jPasswordFieldConfirmaSenha.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonExcluir.setEnabled(false);
       jButtonAlterar.setEnabled(false);
       
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
      mod.setUsupesquisa(jTextFieldPesquisa.getText());
     preencherTabela("select *from usuarios where usuario_nome like'%" + mod.getUsupesquisa()+"%' order by usuario_nome");
      BeansUsuario model = dao.buscaUsuario(mod);       
     

          
         
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioMouseClicked
       String usu_nome =""+jTableUsuario.getValueAt(jTableUsuario.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from usuarios where usuario_nome='"+usu_nome+"'");
           try {
               conex.rs.first();
               jTextFieldCod.setText(String.valueOf(conex.rs.getInt("usuario_cod")));
               jTextFieldUsuario.setText(conex.rs.getString("usuario_nome"));
               jComboBoxTipoUsuario.setSelectedItem(conex.rs.getString("usuario_tipo"));
               jPasswordFieldUsuarioSenha.setText(conex.rs.getString("usuario_senha"));
               jPasswordFieldConfirmaSenha.setText(conex.rs.getString("usuario_senha"));
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
        jTextFieldUsuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldUsuarioSenha.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonAlterar.setEnabled(true);
       jButtonExcluir.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jPasswordFieldConfirmaSenha.setEnabled(false);
       jTextFieldPesquisa.setEnabled(false);
       jButtonPesquisar.setEnabled(false);
        jTextFieldPesquisa.setText("");
    }//GEN-LAST:event_jTableUsuarioMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
         int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir o  usuário "+jTextFieldUsuario.getText());
        if(resposta ==JOptionPane.YES_OPTION){
       mod.setUsuCod(Integer.parseInt(jTextFieldCod.getText()));
       dao.Excluir(mod);
      
       jTextFieldUsuario.setText("");
       jPasswordFieldUsuarioSenha.setText("");
       jTextFieldPesquisa.setText("");
       jPasswordFieldConfirmaSenha.setText("");
       jTextFieldCod.setText("");
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonAlterar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jButtonPesquisar.setEnabled(true);
       jTextFieldPesquisa.setEnabled(true);
       preencherTabela("select * from usuarios order by usuario_nome");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Tipo","Senha"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getInt("usuario_cod"),conex.rs.getString("usuario_nome"),conex.rs.getString("usuario_tipo"), conex.rs.getString("usuario_senha")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableUsuario.setModel(modelo);
           jTableUsuario.getColumnModel ().getColumn(0).setPreferredWidth(50);
           jTableUsuario.getColumnModel().getColumn(0).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(1).setPreferredWidth(205);
           jTableUsuario.getColumnModel().getColumn(1).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(2).setPreferredWidth(180);
           jTableUsuario.getColumnModel().getColumn(2).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(3).setPreferredWidth(120);
           jTableUsuario.getColumnModel().getColumn(3).setResizable(false);
           jTableUsuario.getTableHeader().setReorderingAllowed(false);
           jTableUsuario.setAutoResizeMode(jTableUsuario.AUTO_RESIZE_OFF);
           jTableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(CadastroDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDeUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldConfirmaSenha;
    private javax.swing.JPasswordField jPasswordFieldUsuarioSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
