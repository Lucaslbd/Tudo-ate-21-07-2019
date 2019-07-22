package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoGrupos;
import TableModel.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class AlterarInformacoesPassageiros extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansGrupos grupos = new BeansGrupos();
    DaoGrupos control = new DaoGrupos();
    String tabelaSalvar;
    int codigo;
    ArrayList<String> NomeGrupo = new ArrayList();

    public AlterarInformacoesPassageiros() {
        initComponents();
        PreencherGrupos();
        
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonNome = new javax.swing.JButton();
        jButtonInformacoes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Selecione o grupo");

        jComboBoxGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseReleased(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

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

        jButtonNome.setText("Alterar beneficiario");
        jButtonNome.setEnabled(false);
        jButtonNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNomeActionPerformed(evt);
            }
        });

        jButtonInformacoes.setText("Alterar informações");
        jButtonInformacoes.setEnabled(false);
        jButtonInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInformacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNome, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNome)
                    .addComponent(jButtonInformacoes))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Alterar dados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxGruposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseEntered
       

    }//GEN-LAST:event_jComboBoxGruposMouseEntered

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
           int posicao = jComboBoxGrupos.getSelectedIndex();
           String tabela = NomeGrupo.get(posicao);
            preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo order by nome");
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        codigo = (int) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        int posicao = jComboBoxGrupos.getSelectedIndex();
        tabelaSalvar = NomeGrupo.get(posicao);
        jButtonNome.setEnabled(true);
        jButtonInformacoes.setEnabled(true);
       
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jComboBoxGruposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseExited
       
    }//GEN-LAST:event_jComboBoxGruposMouseExited

    private void jComboBoxGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMousePressed
       
    }//GEN-LAST:event_jComboBoxGruposMousePressed

    private void jComboBoxGruposMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseReleased
     
    }//GEN-LAST:event_jComboBoxGruposMouseReleased

    private void jButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNomeActionPerformed
   AlterarNomePax dialog = new AlterarNomePax(new javax.swing.JFrame(), true,codigo,tabelaSalvar);
   dialog.setVisible(true);
  
    int posicao = jComboBoxGrupos.getSelectedIndex();
    String tabela = NomeGrupo.get(posicao);
    preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo order by nome");
   jButtonNome.setEnabled(false);
   jButtonInformacoes.setEnabled(false);
    }//GEN-LAST:event_jButtonNomeActionPerformed

    private void jComboBoxGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseClicked
     
    }//GEN-LAST:event_jComboBoxGruposMouseClicked

    private void jButtonInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInformacoesActionPerformed
       AlterarDadosGrupos dialog = new AlterarDadosGrupos(new javax.swing.JFrame(), true,codigo,tabelaSalvar);
       dialog.setVisible(true);
        int posicao = jComboBoxGrupos.getSelectedIndex();
    String tabela = NomeGrupo.get(posicao);
    preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo order by nome");
   jButtonNome.setEnabled(false);
   jButtonInformacoes.setEnabled(false);
    }//GEN-LAST:event_jButtonInformacoesActionPerformed

   
    
    

    public void PreencherGrupos() {
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes  where situacao='Aberto' order by nomemelhorado");
        try {
            conex.rs.first();
            jComboBoxGrupos.removeAllItems();
            do {
                jComboBoxGrupos.addItem(conex.rs.getString("nomemelhorado"));
                NomeGrupo.add(conex.rs.getString("nome"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Cliente", "Pagamento", "Valor", "Parcelas","Parcelas pagas","Valor pago","Embarque"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("codigo"), conex.rs.getString("nome"), conex.rs.getString("forma_pagamento"), conex.rs.getDouble("valor"), conex.rs.getInt("numero_parcelas"), conex.rs.getInt("parcelas_pagas"),conex.rs.getDouble("valor_pago"),conex.rs.getString("embarque")});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);  
        jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(6).setResizable(false); 
        jTableClientes.getColumnModel().getColumn(7).setPreferredWidth(130);
        jTableClientes.getColumnModel().getColumn(7).setResizable(false); 
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //    jTableClientes.setSelectionBackground(Color.RED);
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
            java.util.logging.Logger.getLogger(AlterarInformacoesPassageiros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarInformacoesPassageiros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarInformacoesPassageiros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarInformacoesPassageiros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarInformacoesPassageiros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonInformacoes;
    private javax.swing.JButton jButtonNome;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
