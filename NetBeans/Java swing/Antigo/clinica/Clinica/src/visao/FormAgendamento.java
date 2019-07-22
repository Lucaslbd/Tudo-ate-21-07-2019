/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoAgenda;

/**
 *
 * @author Lucas
 */
public class FormAgendamento extends javax.swing.JFrame {
ConexaoBD conex = new ConexaoBD();
BeansAgenda agenda = new BeansAgenda();
DaoAgenda dao = new DaoAgenda();
 int flag =0;
    
    public FormAgendamento() {
       initComponents();
       PreencherMedicos();
         
       
    }

    public void PreencherMedicos(){
        conex.Conexao();
        conex.executaSql("select * from medicos order by nome_medico");
    try {
        conex.rs.first();
        jComboBoxMedico.removeAllItems();
        do{
            jComboBoxMedico.addItem(conex.rs.getString("nome_medico"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
          JOptionPane.showMessageDialog(rootPane,"Algo deu errado");
    }
        conex.Desconecta();
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
        jButtonFinalizar = new javax.swing.JButton();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        jTextFieldMotivo = new javax.swing.JTextField();
        jComboBoxMedico = new javax.swing.JComboBox<>();
        Cancelar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Atualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Paciente");

        jLabel3.setText("Medico");

        jLabel4.setText("Motivo");

        jLabel5.setText("Data");

        jLabel6.setText("Turno");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.setEnabled(false);
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manha", "Tarde", "Noite" }));
        jComboBoxTurno.setEnabled(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        jTextFieldMotivo.setEnabled(false);

        jComboBoxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMedico.setEnabled(false);

        Cancelar.setText("Cancelar");
        Cancelar.setEnabled(false);
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jDateChooser1.setEnabled(false);

        Atualizar.setText("Atualizar ");
        Atualizar.setEnabled(false);
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(Atualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(Cancelar)
                    .addComponent(Atualizar))
                .addGap(52, 52, 52))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );

        setSize(new java.awt.Dimension(669, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         preencherTabela("select *from pacientes where pac_nome like'%" + jTextFieldPaciente.getText()+"%'");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked
        String pac_nome =""+jTablePacientes.getValueAt(jTablePacientes.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from pacientes where pac_nome='"+pac_nome+"'");
           try {
               conex.rs.first();
               jTextFieldPaciente.setText(conex.rs.getString("pac_nome"));
          } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
        jComboBoxMedico.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTextFieldMotivo.setEnabled(true);
        jButtonFinalizar.setEnabled(true);
        Cancelar.setEnabled(true);
        Atualizar.setEnabled(true);
         
    }//GEN-LAST:event_jTablePacientesMouseClicked

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
      if(jTextFieldPaciente.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do paciente");
         jTextFieldPaciente.requestFocus();
     }else if(jTextFieldMotivo.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Diga o motivo da consulta");
         jTextFieldMotivo.requestFocus();
         }else if(jDateChooser1.getDate() == null){
         JOptionPane.showMessageDialog(null,"Diga a data da consulta");
         jDateChooser1.requestFocus();
      }else
        if(flag==0){
        
      agenda.setNomePac(jTextFieldPaciente.getText());
      agenda.setNomeMed((String) jComboBoxMedico.getSelectedItem());
      agenda.setTurno((String) jComboBoxTurno.getSelectedItem());
      agenda.setMotivo(jTextFieldMotivo.getText());
      agenda.setData(jDateChooser1.getDate());
      agenda.setStatus("Aberto");
      dao.Salvar(agenda);
      jTextFieldPaciente.setText("");
      jDateChooser1.setDate(null);
      jTextFieldMotivo.setText("");
      jComboBoxMedico.setEnabled(false);
      jComboBoxTurno.setEnabled(false);
      jDateChooser1.setEnabled(false);
      jTextFieldMotivo.setEnabled(false);
      jButtonFinalizar.setEnabled(false);
      Cancelar.setEnabled(false);
      Atualizar.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        FormAgendamento  tela = new FormAgendamento();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_AtualizarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        jTextFieldPaciente.setText("");
        jDateChooser1.setDate(null);
        jTextFieldMotivo.setText("");
        jComboBoxMedico.setEnabled(false);
        jComboBoxTurno.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jTextFieldMotivo.setEnabled(false);
        jButtonFinalizar.setEnabled(false);
        Cancelar.setEnabled(false);
        Atualizar.setEnabled(false);
    }//GEN-LAST:event_CancelarActionPerformed
public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Rg","Telefone","Cidade","Bairro","rua","numero","Nascimento"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("pac_cod"),conex.rs.getString("pac_nome"), conex.rs.getString("pac_rg"), conex.rs.getString("pac_fone"), conex.rs.getString("pac_cidade"), conex.rs.getString("pac_bairro"), conex.rs.getString("pac_rua"), conex.rs.getString("pac_numero"),conex.rs.getString("pac_nascimento")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Paciente inexistente");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTablePacientes.setModel(modelo);
           jTablePacientes.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTablePacientes.getColumnModel().getColumn(0).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(1).setPreferredWidth(200);
           jTablePacientes.getColumnModel().getColumn(1).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(2).setPreferredWidth(110);
           jTablePacientes.getColumnModel().getColumn(2).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(3).setPreferredWidth(120);
           jTablePacientes.getColumnModel().getColumn(3).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(4).setPreferredWidth(120);
           jTablePacientes.getColumnModel().getColumn(4).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(5).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(5).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(6).setPreferredWidth(180);
           jTablePacientes.getColumnModel().getColumn(6).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(7).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(7).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(8).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(8).setResizable(false);
           jTablePacientes.getTableHeader().setReorderingAllowed(false);
           jTablePacientes.setAutoResizeMode(jTablePacientes.AUTO_RESIZE_OFF);
           jTablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JComboBox<String> jComboBoxMedico;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacientes;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}
