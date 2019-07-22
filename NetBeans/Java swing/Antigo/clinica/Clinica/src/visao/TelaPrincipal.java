package visao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloConection.ConexaoBD;


public class TelaPrincipal extends javax.swing.JFrame {
    ConexaoBD conecta = new ConexaoBD();
    FormMedico tela = new FormMedico();
    FormUsuario tela2 = new FormUsuario();
    FormPaciente tela3 = new FormPaciente();
    FormAgendamento tela4 = new FormAgendamento();
    FormAgenda tela5 = new FormAgenda();
    agenda_medico tela6 = new agenda_medico();
    
    
        public TelaPrincipal(String usuario) {
            initComponents();
            jLabeluser.setText(usuario);
            conecta.Conexao();
        
    }

    private TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabeluser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelFundoPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadMedicos = new javax.swing.JMenuItem();
        jMenuItemCadPacientes = new javax.swing.JMenuItem();
        jMenuItemCadEnfermeiras = new javax.swing.JMenuItem();
        jMenuItemCadUsuarios = new javax.swing.JMenuItem();
        jMenuItemAgendamentos = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuFerramentas = new javax.swing.JMenu();
        jMenuItemBemVindo = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabeluser.setText("jLabel5");
        getContentPane().add(jLabeluser);
        jLabeluser.setBounds(70, 410, 150, 14);

        jLabel4.setText("Usuário:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 410, 50, 14);

        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, 0, 740, 440);

        jMenuCadastros.setText("Cadastros");

        jMenuItemCadMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-Doutor em medicina-48.png"))); // NOI18N
        jMenuItemCadMedicos.setText("Medicos");
        jMenuItemCadMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadMedicosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadMedicos);

        jMenuItemCadPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-Estar doente-48.png"))); // NOI18N
        jMenuItemCadPacientes.setText("Pacientes");
        jMenuItemCadPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadPacientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadPacientes);

        jMenuItemCadEnfermeiras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-Médica-48.png"))); // NOI18N
        jMenuItemCadEnfermeiras.setText("enfermeiras");
        jMenuCadastros.add(jMenuItemCadEnfermeiras);

        jMenuItemCadUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-Adicionar grupo de usuários homem homem-48.png"))); // NOI18N
        jMenuItemCadUsuarios.setText("Usuarios");
        jMenuItemCadUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadUsuarios);

        jMenuItemAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/agenda.gif"))); // NOI18N
        jMenuItemAgendamentos.setText("Agendamentos");
        jMenuItemAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendamentosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemAgendamentos);

        jMenuBar1.add(jMenuCadastros);

        jMenuRelatorios.setText("Relatorios");
        jMenuBar1.add(jMenuRelatorios);

        jMenuFerramentas.setText("Ferramentas");

        jMenuItemBemVindo.setText("Tela Bem vindo");
        jMenuItemBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBemVindoActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemBemVindo);

        jMenuBar1.add(jMenuFerramentas);

        jMenu1.setText("Agenda");

        jMenuItem2.setText("Agenda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Agenda medico");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItem1);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(757, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        conecta.Desconecta();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBemVindoActionPerformed
       // jInternalFrameBemVindo.setVisible(true);
       //TelaPrincipal  tela = new TelaPrincipal();
        //tela.setVisible(true);
       // dispose();
    }//GEN-LAST:event_jMenuItemBemVindoActionPerformed

    private void jMenuItemCadMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadMedicosActionPerformed
        try {
             conecta.executaSql("select * from usuarios where usu_nome='"+ jLabeluser.getText()+"'");
            conecta.rs.first();
            if(conecta.rs.getString("usu_tipo").equals("Administrador")){
                if(tela==null){
                    tela = new FormMedico();
                    tela.setVisible(true);
                    tela.setResizable(false);
                }else{
                    tela.setVisible(true);
                    tela.setResizable(false);
                }
               }else{
                JOptionPane.showMessageDialog(null,"Somente o administrador pode entrar nesta pagina");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Somente o administrador pode entrar nesta pagina\n"+ ex.getMessage());
        }      
    }//GEN-LAST:event_jMenuItemCadMedicosActionPerformed

    private void jMenuItemCadUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadUsuariosActionPerformed
        try {
             conecta.executaSql("select * from usuarios where usu_nome='"+ jLabeluser.getText()+"'");
            conecta.rs.first();
            if(conecta.rs.getString("usu_tipo").equals("Administrador")){
                if(tela2==null){
                    tela2 = new FormUsuario();
                    tela2.setVisible(true);
                    tela2.setResizable(false);
                }else{
                    tela2.setVisible(true);
                    tela2.setResizable(false);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Somente o administrador pode entrar nesta pagina");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Somente o administrador pode entrar nesta pagina\n"+ ex.getMessage());
        }      
    }//GEN-LAST:event_jMenuItemCadUsuariosActionPerformed

    private void jMenuItemAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendamentosActionPerformed
        if(tela4==null){
                    tela4 = new FormAgendamento();
                    tela4.setVisible(true);
                    tela4.setResizable(false);
                }else{
                    tela4.setVisible(true);
                    tela4.setResizable(false);
                } 
    }//GEN-LAST:event_jMenuItemAgendamentosActionPerformed

    private void jMenuItemCadPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadPacientesActionPerformed
        if(tela3==null){
            tela3 = new FormPaciente();
            tela3.setVisible(true);
            tela3.setResizable(false);
        }else{
            tela3.setVisible(true);
            tela3.setResizable(false);
        }

    }//GEN-LAST:event_jMenuItemCadPacientesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(tela5==null){
            tela5 = new FormAgenda();
            tela5.setVisible(true);
            tela5.setResizable(false);
        }else{
            tela5.setVisible(true);
            tela5.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       if(tela6==null){
            tela6 = new agenda_medico();
            tela6.setVisible(true);
            tela6.setResizable(false);
        }else{
            tela6.setVisible(true);
            tela6.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

   
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFundoPrincipal;
    private javax.swing.JLabel jLabeluser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuFerramentas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAgendamentos;
    private javax.swing.JMenuItem jMenuItemBemVindo;
    private javax.swing.JMenuItem jMenuItemCadEnfermeiras;
    private javax.swing.JMenuItem jMenuItemCadMedicos;
    private javax.swing.JMenuItem jMenuItemCadPacientes;
    private javax.swing.JMenuItem jMenuItemCadUsuarios;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSair;
    // End of variables declaration//GEN-END:variables

    private void PreencherMedicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
