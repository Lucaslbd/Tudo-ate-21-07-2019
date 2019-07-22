package visao;


import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansUsuario;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoUsuario;


public class FormUsuario extends javax.swing.JFrame {
    
    BeansUsuario mod = new BeansUsuario();
    DaoUsuario dao = new DaoUsuario();
    ConexaoBD conex = new ConexaoBD();
     int flag =0;
    
    public FormUsuario() {
        initComponents();
        preencherTabela("select * from usuarios order by usu_nome");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jPasswordFieldSenhaUsuario = new javax.swing.JPasswordField();
        jPasswordFieldConfiraSenhaUsuario = new javax.swing.JPasswordField();
        jButtonSalvarUsuario = new javax.swing.JButton();
        jComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        jButtonAlterarUsuario = new javax.swing.JButton();
        jButtonExcluirUsuario = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonNovoUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Usuário");

        jLabel4.setText("Senha");

        jLabel5.setText("Confirmar senha");

        jLabel6.setText("Tipo de usuário");

        Usuario.setEnabled(false);

        jPasswordFieldSenhaUsuario.setEnabled(false);

        jPasswordFieldConfiraSenhaUsuario.setEnabled(false);

        jButtonSalvarUsuario.setText("Salvar");
        jButtonSalvarUsuario.setEnabled(false);
        jButtonSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarUsuarioActionPerformed(evt);
            }
        });

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Medico", "Recepcionista", "Outros" }));
        jComboBoxTipoUsuario.setEnabled(false);

        jButtonAlterarUsuario.setText("Alterar");
        jButtonAlterarUsuario.setEnabled(false);
        jButtonAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarUsuarioActionPerformed(evt);
            }
        });

        jButtonExcluirUsuario.setText("Excluir");
        jButtonExcluirUsuario.setEnabled(false);
        jButtonExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirUsuarioActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Pesquisar");

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
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonNovoUsuario.setText("Novo");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jTextFieldCod.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordFieldSenhaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(Usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordFieldConfiraSenhaUsuario))
                            .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonNovoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAlterarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovoUsuario)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAlterarUsuario)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldConfiraSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonExcluirUsuario))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvarUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(258, 258, 258))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(671, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoUsuarioActionPerformed
       flag = 1;
       Usuario.setEnabled(true);
       jComboBoxTipoUsuario.setEnabled(true);
       jPasswordFieldSenhaUsuario.setEnabled(true);
       jPasswordFieldConfiraSenhaUsuario.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonSalvarUsuario.setEnabled(true);
       jButtonNovoUsuario.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoUsuarioActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       Usuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldSenhaUsuario.setEnabled(false);
       jPasswordFieldConfiraSenhaUsuario.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonSalvarUsuario.setEnabled(false);
       jButtonAlterarUsuario.setEnabled(false);
       jButtonNovoUsuario.setEnabled(true);
       jButtonExcluirUsuario.setEnabled(false);
       Usuario.setText("");
       jComboBoxTipoUsuario.setSelectedItem("");
       jPasswordFieldSenhaUsuario.setText("");
       jPasswordFieldConfiraSenhaUsuario.setText("");
       jTextFieldPesquisa.setText("");
       jTextFieldCod.setText("");
       
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarUsuarioActionPerformed
      if(Usuario.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do Usuário");
         Usuario.requestFocus();
     }else if(jPasswordFieldSenhaUsuario.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a senha");
         jPasswordFieldSenhaUsuario.requestFocus();
     }else if (jPasswordFieldConfiraSenhaUsuario.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira confirme a senha");
         jPasswordFieldConfiraSenhaUsuario.requestFocus();
         }else if(jPasswordFieldSenhaUsuario.getText().equals(jPasswordFieldConfiraSenhaUsuario.getText())){
         if(flag==1){
        mod.setUsuNome(Usuario.getText());
        mod.setUsuTipo((String)jComboBoxTipoUsuario.getSelectedItem());
        mod.setUsuSenha(jPasswordFieldSenhaUsuario.getText());
        dao.Salvar(mod);
        jPasswordFieldSenhaUsuario.setText("");
        jComboBoxTipoUsuario.setSelectedItem("");
        Usuario.setText("");         
        jPasswordFieldConfiraSenhaUsuario.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldCod.setText("");
        jPasswordFieldSenhaUsuario.setEnabled(false);
        jPasswordFieldConfiraSenhaUsuario.setEnabled(false);
        jComboBoxTipoUsuario.setEnabled(false);
        Usuario.setEnabled(false);
        jButtonCancelar.setEnabled(false); 
        jButtonExcluirUsuario.setEnabled(false); 
        jButtonAlterarUsuario.setEnabled(false); 
        jButtonSalvarUsuario .setEnabled(false); 
        preencherTabela("select * from usuarios order by usu_nome");
        }else{
        mod.setUsuCod(Integer.parseInt(jTextFieldCod.getText()));
        mod.setUsuNome(Usuario.getText());
        mod.setUsuTipo((String)jComboBoxTipoUsuario.getSelectedItem());
        mod.setUsuSenha(jPasswordFieldSenhaUsuario.getText());
        dao.Editar(mod);
        
        jPasswordFieldSenhaUsuario.setText("");
        jComboBoxTipoUsuario.setSelectedItem("");
        Usuario.setText("");         
        jPasswordFieldConfiraSenhaUsuario.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldCod.setText("");
        jPasswordFieldSenhaUsuario.setEnabled(false);
        jPasswordFieldConfiraSenhaUsuario.setEnabled(false);
        jComboBoxTipoUsuario.setEnabled(false);
        Usuario.setEnabled(false);
        jButtonCancelar.setEnabled(false); 
        jButtonExcluirUsuario.setEnabled(false); 
        jButtonAlterarUsuario.setEnabled(false); 
        jButtonSalvarUsuario .setEnabled(false);
        jButtonNovoUsuario.setEnabled(true);
         preencherTabela("select * from usuarios order by usu_nome");   
        }
         }else{
             JOptionPane.showMessageDialog(null,"As senhas não correspondem");
         }
    }//GEN-LAST:event_jButtonSalvarUsuarioActionPerformed
    
    private void jButtonAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarUsuarioActionPerformed
       flag =2;
       Usuario.setEnabled(true);
       jComboBoxTipoUsuario.setEnabled(true);
       jPasswordFieldSenhaUsuario.setEnabled(true);
       jPasswordFieldConfiraSenhaUsuario.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonSalvarUsuario.setEnabled(true);
         jButtonExcluirUsuario.setEnabled(false);
      
       
    }//GEN-LAST:event_jButtonAlterarUsuarioActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       mod.setUsupesquisa(jTextFieldPesquisa.getText());
       BeansUsuario model = dao.buscaUsuario(mod);
       jTextFieldCod.setText(String.valueOf(model.getUsuCod()));
       Usuario.setText(model.getUsuNome());
       jPasswordFieldSenhaUsuario.setText(model.getUsuSenha());
       jPasswordFieldConfiraSenhaUsuario.setText(model.getUsuSenha());
       jComboBoxTipoUsuario.setSelectedItem(model.getUsuTipo());
       jButtonAlterarUsuario.setEnabled(true);
       jButtonExcluirUsuario.setEnabled(true);
       jButtonNovoUsuario.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonSalvarUsuario .setEnabled(false);
       Usuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldSenhaUsuario.setEnabled(false);
       jPasswordFieldConfiraSenhaUsuario.setEnabled(false);
         preencherTabela("select *from usuarios where usu_nome like'%" + mod.getUsupesquisa()+"%'");
        
       
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirUsuarioActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta ==JOptionPane.YES_OPTION){
       mod.setUsuCod(Integer.parseInt(jTextFieldCod.getText()));
       dao.Excluir(mod);
      
       Usuario.setText("");
       jPasswordFieldSenhaUsuario.setText("");
       jTextFieldPesquisa.setText("");
       jPasswordFieldConfiraSenhaUsuario.setText("");
       jTextFieldCod.setText("");
       jButtonNovoUsuario.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonAlterarUsuario.setEnabled(false);
       jButtonExcluirUsuario.setEnabled(false);
       preencherTabela("select * from usuarios order by usu_nome");
       
    }                                    
    }//GEN-LAST:event_jButtonExcluirUsuarioActionPerformed

    private void jTableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioMouseClicked
        String usu_nome =""+jTableUsuario.getValueAt(jTableUsuario.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from usuarios where usu_nome='"+usu_nome+"'");
           try {
               conex.rs.first();
               jTextFieldCod.setText(String.valueOf(conex.rs.getInt("usu_cod")));
               Usuario.setText(conex.rs.getString("usu_nome"));
               jComboBoxTipoUsuario.setSelectedItem(conex.rs.getString("usu_tipo"));
               jPasswordFieldSenhaUsuario.setText(conex.rs.getString("usu_senha"));
               jPasswordFieldConfiraSenhaUsuario.setText(conex.rs.getString("usu_senha"));
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
        Usuario.setEnabled(false);
       jComboBoxTipoUsuario.setEnabled(false);
       jPasswordFieldSenhaUsuario.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonAlterarUsuario.setEnabled(true);
       jButtonExcluirUsuario.setEnabled(true);
       jButtonNovoUsuario.setEnabled(false);
       jButtonSalvarUsuario.setEnabled(false);
    }//GEN-LAST:event_jTableUsuarioMouseClicked
public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Tipo","Senha"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getInt("usu_cod"),conex.rs.getString("usu_nome"),conex.rs.getString("usu_tipo"), conex.rs.getInt("usu_senha")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Usuario inexistente");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableUsuario.setModel(modelo);
           jTableUsuario.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTableUsuario.getColumnModel().getColumn(0).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(1).setPreferredWidth(220);
           jTableUsuario.getColumnModel().getColumn(1).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(2).setPreferredWidth(180);
           jTableUsuario.getColumnModel().getColumn(2).setResizable(false);
           jTableUsuario.getColumnModel ().getColumn(3).setPreferredWidth(100);
           jTableUsuario.getColumnModel().getColumn(3).setResizable(false);
           jTableUsuario.getTableHeader().setReorderingAllowed(false);
           jTableUsuario.setAutoResizeMode(jTableUsuario.AUTO_RESIZE_OFF);
           jTableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        conex.Desconecta();
    }
    
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
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButtonAlterarUsuario;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluirUsuario;
    private javax.swing.JButton jButtonNovoUsuario;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvarUsuario;
    private javax.swing.JComboBox<String> jComboBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldConfiraSenhaUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenhaUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
