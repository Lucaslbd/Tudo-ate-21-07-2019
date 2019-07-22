package br.com.loja.telas.Vendas;

import br.com.loja.dao.VendaDao;
import br.com.loja.domain.Venda;
import br.com.loja.tabelas.ModeloTabela;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class ConsultaVendas extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    ArrayList<Venda> lista;
    int flag = 0;

    public ConsultaVendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserData1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserData2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButtonItensVenda = new javax.swing.JButton();
        jButtonSomarApurado = new javax.swing.JButton();
        jButtonSomarLucro = new javax.swing.JButton();
        jButtonFormasPagamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        jLabel2.setText("Data Inicio");

        jLabel3.setText("Data final");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonItensVenda.setText("Ver itens da venda");
        jButtonItensVenda.setEnabled(false);
        jButtonItensVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItensVendaActionPerformed(evt);
            }
        });

        jButtonSomarApurado.setText("Somar apurado");
        jButtonSomarApurado.setEnabled(false);
        jButtonSomarApurado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomarApuradoActionPerformed(evt);
            }
        });

        jButtonSomarLucro.setText("Somar lucro");
        jButtonSomarLucro.setEnabled(false);
        jButtonSomarLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomarLucroActionPerformed(evt);
            }
        });

        jButtonFormasPagamento.setText("Forma de pagamento");
        jButtonFormasPagamento.setEnabled(false);
        jButtonFormasPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormasPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserData1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserData2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonItensVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFormasPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSomarApurado, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSomarLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooserData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooserData2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonItensVenda)
                    .addComponent(jButtonSomarApurado)
                    .addComponent(jButtonSomarLucro)
                    .addComponent(jButtonFormasPagamento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonItensVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItensVendaActionPerformed
        if (flag == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma venda");
        } else {
            ItensVenda dialog = new ItensVenda(new javax.swing.JFrame(), true, flag);
            dialog.setVisible(true);
            flag = 0;
            pesquisar();
        }
    }//GEN-LAST:event_jButtonItensVendaActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        flag = ((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0));

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButtonSomarApuradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomarApuradoActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para somar");
        } else {
            double valor = 0;
            for (Venda v : lista) {
                valor += v.getValor();
            }
            String formatado = df.format(valor);
            JOptionPane.showMessageDialog(rootPane, "Valor total em apurado R$ " + formatado);
        }
    }//GEN-LAST:event_jButtonSomarApuradoActionPerformed

    private void jButtonSomarLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomarLucroActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para somar");
        } else {
            double lucro = 0;
            for (Venda i : lista) {
                lucro += i.getLucro();
            }
            String formatado = df.format(lucro);
            JOptionPane.showMessageDialog(rootPane, "Valor total em lucro R$ " + formatado);
        }
    }//GEN-LAST:event_jButtonSomarLucroActionPerformed

    private void jButtonFormasPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormasPagamentoActionPerformed
        if (flag == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma venda");
        } else {
            FormasPagamento dialog = new FormasPagamento(new javax.swing.JFrame(), true, flag);
            dialog.setVisible(true);
            flag =0;
            pesquisar();
        }
    }//GEN-LAST:event_jButtonFormasPagamentoActionPerformed

    

    public void pesquisar() {
        if (jDateChooserData1.getDate() == null || jDateChooserData2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos tipo data");
        } else {
            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jDateChooserData2.getDate());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date data1 = jDateChooserData1.getDate();
            Date data2 = calendar.getTime();
            String dataFormatada1 = formatoBrasileiro.format(data1);
            String dataFormatada2 = formatoBrasileiro.format(data2);
            VendaDao dao = new VendaDao();
            lista = new ArrayList<>();
            lista = dao.BuscarPorData(dataFormatada1, dataFormatada2);
            preencherTabela(lista);
            jButtonSomarApurado.setEnabled(true);
            jButtonSomarLucro.setEnabled(true);
            jButtonItensVenda.setEnabled(true);
            jButtonFormasPagamento.setEnabled(true);

        }
    }

    public void preencherTabela(ArrayList<Venda> l) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Data", "Funcionario", "Valor", "Lucro", "Percentual"};
        for (Venda i : l) {
            Date data = i.getData();
            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = formatoBrasileiro.format(data);
            String total = df.format(i.getValor());
            String lucro = df.format(i.getLucro());
            String Percentual = df.format(i.getLucro() / i.getValor() * 100);
            dados.add(new Object[]{i.getCodigo(), dataFormatada, i.getFuncionario().getNome(), total, lucro, Percentual + "%"});
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(145);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(90);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(jTablePadrao.AUTO_RESIZE_OFF);
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
            java.util.logging.Logger.getLogger(ConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFormasPagamento;
    private javax.swing.JButton jButtonItensVenda;
    private javax.swing.JButton jButtonSomarApurado;
    private javax.swing.JButton jButtonSomarLucro;
    private com.toedter.calendar.JDateChooser jDateChooserData1;
    private com.toedter.calendar.JDateChooser jDateChooserData2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
