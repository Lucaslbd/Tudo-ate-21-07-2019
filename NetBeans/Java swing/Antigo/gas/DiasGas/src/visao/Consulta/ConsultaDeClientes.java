package visao.Consulta;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansClientes;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoClientes;

public class ConsultaDeClientes extends javax.swing.JFrame {

    BeansClientes mod = new BeansClientes();
    DaoClientes control = new DaoClientes();
    ConexaoBD conex = new ConexaoBD();

    String nome ="";
    String telefone;
    String rua;
    String numero;
    String bairro;

    public ConsultaDeClientes() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonCapFone = new javax.swing.JButton();
        jButtonContar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxPesquisar = new javax.swing.JComboBox<>();
        jTextField1Pesquisar = new javax.swing.JTextField();
        jButtonPesquisaNome = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonCapFone.setText("Capturar Telefones");
        jButtonCapFone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCapFone.setEnabled(false);
        jButtonCapFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapFoneActionPerformed(evt);
            }
        });

        jButtonContar.setText("Contar clientes");
        jButtonContar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonContar.setEnabled(false);
        jButtonContar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContarActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Imprimir pesquisa");
        jButtonImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImprimir.setEnabled(false);
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir entrega");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCapFone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonContar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonContar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCapFone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxPesquisar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesquisar por nome", "Pesquisar por rua", "Pesquisar por bairro", "Pesquisar por telefone" }));
        jComboBoxPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonPesquisaNome.setText("Pesquisar");
        jButtonPesquisaNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonPesquisaNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPesquisar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1Pesquisar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisaNome)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Consulta de clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(355, 355, 355))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(973, 505));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaNomeActionPerformed
        if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por nome") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_nome ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por rua") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_rua ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por bairro") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_bairro ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por telefone") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_fone ilike'%" + mod.getPesquisa() + "%'");
            jTextField1Pesquisar.setText("");
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        }
    }//GEN-LAST:event_jButtonPesquisaNomeActionPerformed

    private void jButtonContarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContarActionPerformed
        int cont = jTableClientes.getRowCount();
        JOptionPane.showMessageDialog(null, "O numero de clientes é " + cont);
    }//GEN-LAST:event_jButtonContarActionPerformed

    private void jButtonCapFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapFoneActionPerformed
        int contador = jTableClientes.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            List<String> fones;
            fones = new ArrayList<String>();

            for (int i = 0; i <= jTableClientes.getRowCount() - 1; i++) {
                fones.add(jTableClientes.getValueAt(i, 0).toString() + "\r\n" + jTableClientes.getValueAt(i, 1).toString() + "\r\n");

                Path caminho = Paths.get("C:Telefones.xml");
                String todosFones = "";
                for (String f : fones) {

                    todosFones += f + "\r\n";
                }
                byte[] textoEMByte = todosFones.getBytes();

                try {
                    Files.write(caminho, textoEMByte);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Nenhum numero na lista");
                }
            }

            try {
                java.awt.Desktop.getDesktop().open(new File("C:Telefones.txt"));
            } catch (IOException ex) {

            }
        }
    }//GEN-LAST:event_jButtonCapFoneActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        int contador = jTableClientes.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            MessageFormat headerFormat = new MessageFormat("Pesquisa de clientes");
            MessageFormat footerFormat = new MessageFormat("");

            try {
                jTableClientes.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(rootPane, "erro" + ex);
            }
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (nome.equals("")) {
            int re = 0;
            re = JOptionPane.showConfirmDialog(rootPane, "Deseja imprimir o cadastro de cliente?");
            if (re == JOptionPane.YES_OPTION) {

                Path caminho = Paths.get("C:imprimir.txt");
                String texto = "Cadastro de clientes\r\n"
                        + "Nome:\r\n\r\n"
                        + "---------------------\r\n"
                        + "Telefone:\r\n\r\n"
                        + "---------------------\r\n"
                        + "Rua:\r\n\r\n"
                        + "---------------------\r\n"
                        + "Numero:\r\n\r\n"
                        + "---------------------\r\n"
                        + "Bairro:\r\n\r\n"
                        + "---------------------\r\n"
                        + "Assinatura do cliente\r\n\r\n"
                        + "---------------------";

                byte[] textoEMByte = texto.getBytes();

                try {
                    Files.write(caminho, textoEMByte);
                    imprimir("C:imprimir.txt");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro verifique a impressora");
                }
            }
        } else {
            int re = 0;
            re = JOptionPane.showConfirmDialog(rootPane, "Deseja imprimir o endereço de entrega?");
            if (re == JOptionPane.YES_OPTION) {

                Path caminho = Paths.get("C:imprimir.txt");
                String texto = "Endereço para entrega\r\n" +
                                "\r\nNome\r\n"+
                                nome +"\r\n"+
                                "---------------------"+
                                "\r\nTelefone\r\n"+
                                telefone+"\r\n"+
                                "---------------------"+
                                "\r\nBairro\r\n"+
                                bairro +"\r\n"+
                                "---------------------"+
                                "\r\nRua\r\n"+
                                rua +"\r\n"+
                                "---------------------"+
                                "\r\nNumero\r\n"+
                                numero+"\r\n"+
                                "---------------------\r\n"+
                         "Assinatura do cliente\r\n\r\n"
                        + "---------------------";

                byte[] textoEMByte = texto.getBytes();

                try {
                    Files.write(caminho, textoEMByte);
                    imprimir("C:imprimir.txt");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro verifique a impressora");
                }
            }

        }
         nome ="";
         if(jTextField1Pesquisar.getText().isEmpty()){
             
         }else{
         
         if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por nome") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_nome ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por rua") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_rua ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por bairro") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_bairro ilike'%" + mod.getPesquisa() + "%'");
            
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        } else if (jComboBoxPesquisar.getSelectedItem() == "Pesquisar por telefone") {
            mod.setPesquisa(jTextField1Pesquisar.getText());
            preencherTabela("select *from clientes where cliente_fone like'%" + mod.getPesquisa() + "%'");
            jTextField1Pesquisar.setText("");
            jButtonContar.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonCapFone.setEnabled(true);

        }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        nome = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        telefone = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1);
        rua = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 2);
        numero = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3);
        bairro = "" + jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 4);
        
    }//GEN-LAST:event_jTableClientesMouseClicked

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "Telefone", "Rua", "Numero", "Bairro"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("cliente_nome"), conex.rs.getString("cliente_fone"), conex.rs.getString("cliente_rua"), conex.rs.getString("cliente_numero"), conex.rs.getString("cliente_bairro")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    public void imprimir(String caminho) {
        Desktop desktop = Desktop.getDesktop();
        try {
            File arquivoImprimir = new File(caminho);
            desktop.print(arquivoImprimir);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
        }
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
            java.util.logging.Logger.getLogger(ConsultaDeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDeClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCapFone;
    private javax.swing.JButton jButtonContar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonPesquisaNome;
    private javax.swing.JComboBox<String> jComboBoxPesquisar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextField1Pesquisar;
    // End of variables declaration//GEN-END:variables
}
