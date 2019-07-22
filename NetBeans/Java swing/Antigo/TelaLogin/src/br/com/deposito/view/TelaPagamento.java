package br.com.deposito.view;

import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.domain.Pagamento;
import br.com.deposito.model.ModeloTabela;
import br.com.deposito.util.Utilitario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaPagamento extends javax.swing.JFrame {

    private final PagamentoDao dao = new PagamentoDao();
    private List<Pagamento> lista;
    private final Utilitario util = new Utilitario();

    public TelaPagamento() {
        initComponents();
        pesquisar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelbg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanelNovo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelNovo1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelNovo2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de clientes");
        setResizable(false);

        jPanelbg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(54, 33, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de pagamentos");

        jPanelNovo.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/gravar_registro.gif"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add forma de pagamento");

        javax.swing.GroupLayout jPanelNovoLayout = new javax.swing.GroupLayout(jPanelNovo);
        jPanelNovo.setLayout(jPanelNovoLayout);
        jPanelNovoLayout.setHorizontalGroup(
            jPanelNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovoLayout.setVerticalGroup(
            jPanelNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );

        jPanelNovo1.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/alterar_registro.gif"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alterar forma de pagamento");

        javax.swing.GroupLayout jPanelNovo1Layout = new javax.swing.GroupLayout(jPanelNovo1);
        jPanelNovo1.setLayout(jPanelNovo1Layout);
        jPanelNovo1Layout.setHorizontalGroup(
            jPanelNovo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo1Layout.setVerticalGroup(
            jPanelNovo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        jPanelNovo2.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/delete.gif"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Excluir forma de pagamento");

        javax.swing.GroupLayout jPanelNovo2Layout = new javax.swing.GroupLayout(jPanelNovo2);
        jPanelNovo2.setLayout(jPanelNovo2Layout);
        jPanelNovo2Layout.setHorizontalGroup(
            jPanelNovo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo2Layout.setVerticalGroup(
            jPanelNovo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanelNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

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
        jTablePadrao.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTablePadrao);

        javax.swing.GroupLayout jPanelbgLayout = new javax.swing.GroupLayout(jPanelbg);
        jPanelbg.setLayout(jPanelbgLayout);
        jPanelbgLayout.setHorizontalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelbgLayout.setVerticalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addGroup(jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelbgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseEntered
        jPanelNovo.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovoMouseEntered

    private void jPanelNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseExited
        jPanelNovo.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovoMouseExited

    private void jPanelNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseClicked
        TelaPagamentoCadastro dialog = new TelaPagamentoCadastro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        pesquisar();
    }//GEN-LAST:event_jPanelNovoMouseClicked

    private void jPanelNovo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para altera-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            TelaPagamentoCadastro dialog = new TelaPagamentoCadastro(new javax.swing.JFrame(), true, lista.get(jTablePadrao.getSelectedRow()));
            dialog.setVisible(true);
            pesquisar();
        }
    }//GEN-LAST:event_jPanelNovo1MouseClicked

    private void jPanelNovo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseEntered
        jPanelNovo1.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo1MouseEntered

    private void jPanelNovo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseExited
        jPanelNovo1.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo1MouseExited

    private void jPanelNovo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para remove-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente remover " + lista.get(jTablePadrao.getSelectedRow()).getTipo());
            if (resposta == JOptionPane.YES_OPTION) {
                dao.excluir(lista.get(jTablePadrao.getSelectedRow()));
            }
            pesquisar();
        }
    }//GEN-LAST:event_jPanelNovo2MouseClicked

    private void jPanelNovo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseEntered
        jPanelNovo2.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo2MouseEntered

    private void jPanelNovo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseExited
        jPanelNovo2.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo2MouseExited

    private void pesquisar() {
        lista = dao.listar("Pagamentos.listar");
        preencherTabela(lista);
    }

    private void preencherTabela(List<Pagamento> ls) {
        String[] colunas = new String[]{"Codigo", "Tipo", "Descrição", "Dias para receber", "Desconto"};
        ArrayList dados = new ArrayList();
        if (ls == null || ls.size() < 1) {
            dados.add(new Object[]{"Nenhum registro encontrado", "", "", "", ""});
        } else {
            for (Pagamento c : ls) {
                if (c.getEstrategia().equals("R$")) {
                    dados.add(new Object[]{c.getCodigo(), c.getTipo(), c.getDescricao(), c.getDiasReceber() + " dias", util.decimalFormatComCifrao(c.getDesconto()) + " por venda"});
                } else {
                    dados.add(new Object[]{c.getCodigo(), c.getTipo(), c.getDescricao(), c.getDiasReceber() + " dias", c.getDesconto() + " % por venda"});
                }
            }
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelNovo;
    private javax.swing.JPanel jPanelNovo1;
    private javax.swing.JPanel jPanelNovo2;
    private javax.swing.JPanel jPanelbg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
