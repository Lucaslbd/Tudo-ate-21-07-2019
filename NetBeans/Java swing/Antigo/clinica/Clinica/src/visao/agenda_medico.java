/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoAgenda;

/**
 *
 * @author Lucas
 */
public class agenda_medico extends javax.swing.JFrame {
ConexaoBD conex = new ConexaoBD();
 String status;
 String dtHoje;
 DaoAgenda Agenda = new DaoAgenda();
   
    public agenda_medico() {
        initComponents();
         Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
         dtHoje = dateFormat.format(d); 
         
         
         status = "Atendimento";
         PreencherMedicos();
        
    }
 public void PreencherMedicos(){
        conex.Conexao();
        conex.executaSql("select * from medicos order by nome_medico");
    try {
        conex.rs.first();
        jComboBoxMedicos.removeAllItems();
        do{
            jComboBoxMedicos.addItem(conex.rs.getString("nome_medico"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jComboBoxMedicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTableAgenda);

        jLabel1.setText("Medico");

        jLabel2.setText("Tabela em atendimento");

        jButton1.setText("Atender");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Agenda Medico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(349, 349, 349))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int cod = Agenda.BuscaCodMedico((String) jComboBoxMedicos.getSelectedItem());
       String codigo = String.valueOf(cod);
        preencherTabela("select * from agenda inner join pacientes on agenda_codpac = pac_cod inner join medicos on agenda_codmedico = cod_medico where agenda_codmedico='"+codigo+"' and agenda_data='"+dtHoje+"' and agenda_status='"+status+"'");
    }//GEN-LAST:event_jButton2ActionPerformed

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
               JOptionPane.showMessageDialog(rootPane,"Não há pacientes para atendimento no momento");
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
            java.util.logging.Logger.getLogger(agenda_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agenda_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agenda_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agenda_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agenda_medico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxMedicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    // End of variables declaration//GEN-END:variables
}
