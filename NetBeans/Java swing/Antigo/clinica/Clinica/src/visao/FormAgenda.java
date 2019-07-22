package visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoAgenda;
import static sun.util.calendar.CalendarUtils.mod;
import static sun.util.calendar.CalendarUtils.mod;


public class FormAgenda extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansAgenda agenda = new BeansAgenda();
    DaoAgenda daoagenda =  new DaoAgenda();
     String status;
     String dtHoje;
    
    public FormAgenda() {
        initComponents();
        
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
         dtHoje = dateFormat.format(d); 
         
         
         status = "Aberto";
        
         preencherTabela("select * from agenda inner join pacientes on agenda_codpac = pac_cod inner join medicos on agenda_codmedico = cod_medico where agenda_data='"+dtHoje+"' and agenda_status='"+status+"' order by agenda_turno");
    }
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Turno","Data","Medico","Status"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getInt("agenda_cod"),conex.rs.getString("pac_nome"),conex.rs.getString("agenda_turno"), conex.rs.getString("agenda_data"), conex.rs.getString("nome_medico"), conex.rs.getString("agenda_status")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Não existe agendamentos para hoje");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableAgenda.setModel(modelo);
           jTableAgenda.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTableAgenda.getColumnModel().getColumn(0).setResizable(false);
           jTableAgenda.getColumnModel ().getColumn(1).setPreferredWidth(220);
           jTableAgenda.getColumnModel().getColumn(1).setResizable(false);
           jTableAgenda.getColumnModel ().getColumn(2).setPreferredWidth(160);
           jTableAgenda.getColumnModel().getColumn(2).setResizable(false);
           jTableAgenda.getColumnModel ().getColumn(3).setPreferredWidth(100);
           jTableAgenda.getColumnModel().getColumn(3).setResizable(false);
           jTableAgenda.getColumnModel ().getColumn(4).setPreferredWidth(120);
           jTableAgenda.getColumnModel().getColumn(4).setResizable(false);
           jTableAgenda.getColumnModel ().getColumn(5).setPreferredWidth(120);
           jTableAgenda.getColumnModel().getColumn(5).setResizable(false);
           jTableAgenda.getTableHeader().setReorderingAllowed(false);
           jTableAgenda.setAutoResizeMode(jTableAgenda.AUTO_RESIZE_OFF);
           jTableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        conex.Desconecta();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jButtonAtender = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgenda);

        jButtonAtender.setText("Atender Agendamento");
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar agenda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtender)
                    .addComponent(jButton1))
                .addGap(153, 153, 153))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );

        setSize(new java.awt.Dimension(889, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
       daoagenda.alterar(agenda);
       preencherTabela("select * from agenda inner join pacientes on agenda_codpac = pac_cod inner join medicos on agenda_codmedico = cod_medico where agenda_data='"+dtHoje+"' and agenda_status='"+status+"' order by agenda_turno");
    }//GEN-LAST:event_jButtonAtenderActionPerformed

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked
          String agenda_cod =""+jTableAgenda.getValueAt(jTableAgenda.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from agenda where agenda_cod='"+agenda_cod+"'");
           try {
               conex.rs.first();
               agenda.setStatus("Atendimento");
               agenda.setAgendaCod(conex.rs.getInt("agenda_cod"));
             } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
      
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       preencherTabela("select * from agenda inner join pacientes on agenda_codpac = pac_cod inner join medicos on agenda_codmedico = cod_medico where agenda_data='"+dtHoje+"' and agenda_status='"+status+"' order by agenda_turno");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    // End of variables declaration//GEN-END:variables
}
