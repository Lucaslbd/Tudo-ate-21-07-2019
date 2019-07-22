package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloConection.ConexaoBD;
import modeloDao.DaoMedico;
import modeloBeans.BeansMedico;
import modeloBeans.ModeloTabela;


public class FormMedico extends javax.swing.JFrame {

       BeansMedico mod = new BeansMedico();
       DaoMedico control = new DaoMedico();
       ConexaoBD conex = new ConexaoBD();
       int flag =0;
       
       
    public FormMedico() {
        initComponents();
        preencherTabela("select * from medicos order by nome_medico");
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BordaFormulario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEspecialista = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedicos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtCod = new javax.swing.JTextField();
        Atualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BordaFormulario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jLabel3.setText("Crm");

        jFormattedTextField2.setEnabled(false);

        jTextFieldNome.setEnabled(false);

        jLabel4.setText("Especialidade");

        jComboBoxEspecialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cirurgião", "Pediatra", "Ginecologista", "Clinico Geral", "Outros", " " }));
        jComboBoxEspecialista.setEnabled(false);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
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

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedicos);

        jLabel5.setText("ID");

        jtCod.setEnabled(false);

        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BordaFormularioLayout = new javax.swing.GroupLayout(BordaFormulario);
        BordaFormulario.setLayout(BordaFormularioLayout);
        BordaFormularioLayout.setHorizontalGroup(
            BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BordaFormularioLayout.createSequentialGroup()
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Atualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BordaFormularioLayout.createSequentialGroup()
                                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                                        .addComponent(jComboBoxEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BordaFormularioLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        BordaFormularioLayout.setVerticalGroup(
            BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BordaFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(BordaFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar)
                            .addComponent(Atualizar)))
                    .addGroup(BordaFormularioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de médicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(BordaFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BordaFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );

        setSize(new java.awt.Dimension(665, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
     if(jTextFieldNome.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do medico");
         jTextFieldNome.requestFocus();
     }else if(jFormattedTextField2.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o CRM do medico");
         jFormattedTextField2.requestFocus();
     }else

        if(flag==1){
        mod.setNome(jTextFieldNome.getText());
        mod.setEspecialidade((String) jComboBoxEspecialista.getSelectedItem());
        mod.setCrm(Integer.parseInt(jFormattedTextField2.getText()));
        control.Salvar(mod);
        jTextFieldNome.setText("");
        jFormattedTextField2.setText("");
        jComboBoxEspecialista.setSelectedItem("");
        jTextFieldPesquisa.setText("");
        jTextFieldNome.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        jComboBoxEspecialista.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
         preencherTabela("select * from medicos order by nome_medico");
        }else{
            mod.setCodigo(Integer.parseInt(jtCod.getText()));
            mod.setNome(jTextFieldNome.getText());
            mod.setEspecialidade((String)jComboBoxEspecialista.getSelectedItem());
            mod.setCrm(Integer.parseInt(jFormattedTextField2.getText()));
            control.Editar(mod);
            jtCod.setText("");
            jTextFieldNome.setText("");
            jFormattedTextField2.setText("");
            jTextFieldPesquisa.setText("");
        jTextFieldNome.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        jComboBoxEspecialista.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonCancelar.setEnabled(false);
        preencherTabela("select * from medicos order by nome_medico");
      
            
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag = 1;
       jTextFieldNome.setEnabled(true);
       jFormattedTextField2.setEnabled(true);
       jComboBoxEspecialista.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonEditar.setEnabled(true);
       // jButtonCancelar.setEnabled(true);
      //jButtonExcluir.setEnabled(true);
     
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       mod.setPesquisa(jTextFieldPesquisa.getText());
       BeansMedico model = control.buscaMedico(mod);
       jTextFieldNome.setText(model.getNome());
       jtCod.setText(String.valueOf(model.getCodigo()));
       jFormattedTextField2.setText(String.valueOf(model.getCrm()));
       jComboBoxEspecialista.setSelectedItem(model.getEspecialidade());
       jTextFieldNome.setEnabled(false);
       jFormattedTextField2.setEnabled(false);
       jComboBoxEspecialista.setEnabled(false);
       jButtonEditar.setEnabled(true);
       jButtonExcluir.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(false);
       preencherTabela("select *from medicos where nome_medico like'%" + mod.getPesquisa()+"%'");
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jTextFieldNome.setEnabled(!true);
       jFormattedTextField2.setEnabled(!true);
       jComboBoxEspecialista.setEnabled(!true);
       jButtonSalvar.setEnabled(!true);
       jButtonCancelar.setEnabled(!true);
       jButtonNovo.setEnabled(true);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       jtCod.setText("");
       jTextFieldNome.setText("");
       jFormattedTextField2.setText("");
       jTextFieldPesquisa.setText("");
       jComboBoxEspecialista.setSelectedItem("");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       flag =2;
       jTextFieldNome.setEnabled(true);
       jFormattedTextField2.setEnabled(true);
       jComboBoxEspecialista.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
      
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta ==JOptionPane.YES_OPTION){
        mod.setCodigo(Integer.parseInt(jtCod.getText()));
        control.Excluir(mod);
       jtCod.setText("");
       jTextFieldNome.setText("");
       jFormattedTextField2.setText("");
       jTextFieldPesquisa.setText("");
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
       preencherTabela("select * from medicos order by nome_medico");
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    }
    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
       FormMedico  j = new FormMedico();
        j.setVisible(true);
        dispose();
    }//GEN-LAST:event_AtualizarActionPerformed

    private void jTableMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicosMouseClicked
        String nome_medico =""+jTableMedicos.getValueAt(jTableMedicos.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from medicos where nome_medico='"+nome_medico+"'");
           try {
               conex.rs.first();
               jtCod.setText(String.valueOf(conex.rs.getInt("cod_medico")));
               jTextFieldNome.setText(conex.rs.getString("nome_medico"));
               jComboBoxEspecialista.setSelectedItem(conex.rs.getString("especialidade_medico"));
               jFormattedTextField2.setText(conex.rs.getString("crm_medico"));
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
        jTextFieldNome.setEnabled(false);
       jFormattedTextField2.setEnabled(false);
       jComboBoxEspecialista.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonEditar.setEnabled(true);
       jButtonExcluir.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonSalvar.setEnabled(false);
    }//GEN-LAST:event_jTableMedicosMouseClicked
    
    
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Especialidade","Crm"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getInt("cod_medico"),conex.rs.getString("nome_medico"),conex.rs.getString("especialidade_medico"), conex.rs.getInt("crm_medico")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
              
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableMedicos.setModel(modelo);
           jTableMedicos.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTableMedicos.getColumnModel().getColumn(0).setResizable(false);
           jTableMedicos.getColumnModel ().getColumn(1).setPreferredWidth(200);
           jTableMedicos.getColumnModel().getColumn(1).setResizable(false);
           jTableMedicos.getColumnModel ().getColumn(2).setPreferredWidth(180);
           jTableMedicos.getColumnModel().getColumn(2).setResizable(false);
           jTableMedicos.getColumnModel ().getColumn(3).setPreferredWidth(100);
           jTableMedicos.getColumnModel().getColumn(3).setResizable(false);
           jTableMedicos.getTableHeader().setReorderingAllowed(false);
           jTableMedicos.setAutoResizeMode(jTableMedicos.AUTO_RESIZE_OFF);
           jTableMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JPanel BordaFormulario;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEspecialista;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedicos;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jtCod;
    // End of variables declaration//GEN-END:variables
}
