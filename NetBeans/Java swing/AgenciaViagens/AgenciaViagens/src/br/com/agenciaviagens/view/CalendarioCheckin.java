package br.com.agenciaviagens.view;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.model.ModeloTabela;
import br.com.agenciaviagens.util.Carregar;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class CalendarioCheckin extends javax.swing.JFrame {

    UtilitarioDao dao = new UtilitarioDao();
    Empresa empresa;
    boolean pesquisou = false;
    int codigo = 0;
    final Carregar dialog = new Carregar();

    public CalendarioCheckin(Empresa e) {
        initComponents();
        empresa = e;
    }

    private CalendarioCheckin() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTablePadrao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePadraoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePadrao);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/email.png"))); // NOI18N
        jButton1.setText("Email");
        jButton1.setToolTipText("Enviar e-mail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/whatssap.png"))); // NOI18N
        jButton2.setText("Whatssap");
        jButton2.setToolTipText("Enviar whatsapp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Inicio");

        jLabel3.setText("Final");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoLocalizar.png"))); // NOI18N
        jButton3.setText("Pesquisar");
        jButton3.setToolTipText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 413, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agenda de check-in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos data");
        } else {
            dialog.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    preencherTabela("select * from checkin inner join venda inner join cliente on cliente = codigo_cliente on venda = codigo_venda inner join fornecedor on fornecedor = codigo_fornecedor where data_checkin between '" + jDateChooser1.getDate() + "' and '" + jDateChooser2.getDate() + "' order by data_checkin");
                    dialog.dispose();
                }
            };
            t.start();
            pesquisou = true;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!pesquisou || jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else {
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                String email = "" + jTablePadrao.getValueAt(i, 2);
                if (!email.equals("Não tem email")) {
                    lista.add(email);
                }
            }
            if (lista.size() < 1) {
                JOptionPane.showMessageDialog(rootPane, "Não existem emails validos");
            } else {
                Email2 email = new Email2(lista, empresa);
                email.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (codigo < 1) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para enviar whatssap");
        } else {
            String fone = "" + jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 1);
            char[] t = fone.toCharArray();
            char[] n = new char[13];
            n[0] = '5';
            n[1] = '5';
            n[2] = t[1];
            n[3] = t[2];
            n[4] = t[5];
            n[5] = t[7];
            n[6] = t[8];
            n[7] = t[9];
            n[8] = t[10];
            n[9] = t[12];
            n[10] = t[13];
            n[11] = t[14];
            n[12] = t[15];
            String whats = new String(n);
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("http://api.whatsapp.com/send?1=pt_BR&phone=" + whats));
            } catch (IOException | URISyntaxException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            codigo = 0;
            preencherTabela("select * from checkin inner join venda inner join cliente on cliente = codigo_cliente on venda = codigo_venda inner join fornecedor on fornecedor = codigo_fornecedor where data_checkin between '" + jDateChooser1.getDate() + "' and '" + jDateChooser2.getDate() + "' order by data_checkin");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        codigo = 1;
    }//GEN-LAST:event_jTablePadraoMouseClicked

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "Telefone", "Email", "Fornecedor", "Serviço", "Data"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getString("nome"), resultado.getString("cliente_telefone"), resultado.getString("cliente_email"), resultado.getString("nome_fornecedor"), resultado.getString("descricao"), dao.ArrrumaData(resultado.getDate("data_checkin")) + " " + resultado.getString("hora_checkin")});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado" + ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ModeloTabela modelo = new ModeloTabela(dados, colunas);
                jTablePadrao.setModel(modelo);
                jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(290);
                jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(118);
                jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(250);
                jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(200);
                jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(150);
                jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(120);
                jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
                jTablePadrao.getTableHeader().setReorderingAllowed(false);
                jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });
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
            java.util.logging.Logger.getLogger(CalendarioCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalendarioCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalendarioCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalendarioCheckin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalendarioCheckin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
