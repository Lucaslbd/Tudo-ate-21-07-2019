package br.com.loja.telas.Fornecedor;

import br.com.loja.dao.ItemDao;
import br.com.loja.domain.Fornecedor;
import br.com.loja.domain.Item;
import br.com.loja.domain.Produto;
import br.com.loja.tabelas.ModeloTabela;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class HistoricoFornecedor extends javax.swing.JDialog {

    Fornecedor fornecedor;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");//

    public HistoricoFornecedor(java.awt.Frame parent, boolean modal, Fornecedor f) {
        super(parent, modal);
        initComponents();
        fornecedor = f;
        jLabel1.setText(f.getNome());
    }

    private HistoricoFornecedor(JFrame jFrame, boolean b) {

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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        jScrollPane1.setViewportView(jTablePadrao);

        jLabel2.setText("Data inicio");

        jLabel3.setText("Data final");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Somar total de itens vendidos");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Somar valor vendido");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Somar lucro sob o fornecedor");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserData1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserData2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooserData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooserData2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            ItemDao dao = new ItemDao();
            ArrayList<Item> lista = dao.ListarPorFornecedor(dataFormatada1, dataFormatada2, fornecedor.getCnpj());
            preencherTabela(lista);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int count = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTablePadrao.getValueAt(i, 2).toString());
        }
        JOptionPane.showMessageDialog(null, "O total de itens vendidos é " + count + " unidades");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double count = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTablePadrao.getValueAt(i, 4).toString());
        }
        String dx = df.format(count);
        JOptionPane.showMessageDialog(null, "O valor vendido foi de R$ " + dx + " reais");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        double vendido = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            vendido += Double.parseDouble(jTablePadrao.getValueAt(i, 4).toString());
        }
        double custo = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            custo += Double.parseDouble(jTablePadrao.getValueAt(i, 2).toString());
        }
        double resultado = vendido - custo;
        String dx = df.format(resultado);
        JOptionPane.showMessageDialog(null, "O lucro sobre o fornecedor foi de R$ " + dx + " reais");
    }//GEN-LAST:event_jButton4ActionPerformed

    public String DecimalFortmat(double v) {
        String formatado = df.format(v);
        return formatado;
    }

    public double arrumaDouble(double v) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(v);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double resultado = Double.parseDouble(string2);
        return resultado;
    }

    public void preencherTabela(ArrayList<Item> l) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Data", "Quantidade", "Valor custo", "Valor unitario", "Valor total", "Lucro", "Percentual"};
        for (Item i : l) {
            Date data = i.getVenda().getData();
            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = formatoBrasileiro.format(data);
            String valorLucro = DecimalFortmat(i.getValorTotal() - i.getCusto());
            String Percentual = DecimalFortmat(((i.getValorTotal() - i.getCusto()) / i.getValorTotal()) * 100);
            String custo = DecimalFortmat(i.getCusto());
            String total = DecimalFortmat(i.getValorTotal());
            dados.add(new Object[]{dataFormatada, i.getQuantidade(), custo, i.getValorUnitario(), total, valorLucro, Percentual + "%"});
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(100);
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
            java.util.logging.Logger.getLogger(HistoricoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoricoFornecedor dialog = new HistoricoFornecedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
