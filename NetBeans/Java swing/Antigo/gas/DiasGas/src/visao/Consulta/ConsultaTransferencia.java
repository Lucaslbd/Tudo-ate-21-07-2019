package visao.Consulta;

import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansTransferencia;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;


public class ConsultaTransferencia extends javax.swing.JFrame {
ConexaoBD conex = new ConexaoBD();
BeansTransferencia mod = new BeansTransferencia();
DecimalFormat df = new DecimalFormat("0.##");
  
public ConsultaTransferencia() {
        initComponents();
         
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransferencia = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonQuantidade = new javax.swing.JButton();
        jButtonValor = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTransferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTransferencia);

        jButton1.setText("Pesquisar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonQuantidade.setText("Quantidade");
        jButtonQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonQuantidade.setEnabled(false);
        jButtonQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuantidadeActionPerformed(evt);
            }
        });

        jButtonValor.setText("Valor");
        jButtonValor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonValor.setEnabled(false);
        jButtonValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setEnabled(false);
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonValor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonQuantidade)
                            .addComponent(jButtonValor))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonImprimir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de transferência");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(jTextFieldPesquisar.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane,"Insira a data de sua pesquisa");
       }else{
        mod.setPesquisar(jTextFieldPesquisar.getText());
         preencherTabela("select *from transferencia where data like'%" + mod.getPesquisar()+"%'");
         jButtonQuantidade.setEnabled(true);
         jButtonValor.setEnabled(true);
         jButtonImprimir.setEnabled(true);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuantidadeActionPerformed
         int cont=0;
    for (int i=0; i<=jTableTransferencia.getRowCount()-1;i++) {
    cont+=Integer.parseInt(jTableTransferencia.getValueAt(i, 2).toString());
}
         JOptionPane.showMessageDialog(null,"O numero de transferência é " + cont);
    }//GEN-LAST:event_jButtonQuantidadeActionPerformed

    private void jButtonValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorActionPerformed
        double count=0;
    for (int i=0; i<=jTableTransferencia.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableTransferencia.getValueAt(i, 3).toString());
}
    String dx = df.format(count);
    JOptionPane.showMessageDialog(null,"O valor em transferências é R$ "+ dx + " reais");
    }//GEN-LAST:event_jButtonValorActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
     int contador = jTableTransferencia.getRowCount();
   if(contador ==0){
       JOptionPane.showMessageDialog(rootPane,"Operação não pode ser realizada pois a tabela está vazia.");
   }else{

        // PrinterJob job = PrinterJob.getPrinterJob();
      //  job.setPrintable(jTableVendas.getPrintable(PrintMode.FIT_WIDTH, null, null));
//job.setJobName("Nome do Trabalho de impressão");
//if (job.printDialog()) {
          //  try {
            //    job.print();
           // } catch (PrinterException ex) {
             //   Logger.getLogger(ConsultaDeVendas.class.getName()).log(Level.SEVERE, null, ex);
           // }
//} aqui termina talves ele ainda seje importante
Calendar data = Calendar.getInstance();
     int hora = data.get(Calendar.HOUR_OF_DAY); 
     int min = data.get(Calendar.MINUTE);
     int seg = data.get(Calendar.SECOND);

        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
        String dtHoje;
         dtHoje = dateFormat.format(d);

    
    MessageFormat headerFormat = new MessageFormat("Relatorio de Transferência");
    MessageFormat footerFormat = new MessageFormat("Data "+ dtHoje + " Hora "+hora+":"+min+":"+seg);
      try {
          jTableTransferencia.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
      } catch (PrinterException ex) {
         JOptionPane.showMessageDialog(rootPane,"erro"+ ex);
      }
   }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Produto","Destinatario","Quantidade","Valor","Casco","Data"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("produto"),conex.rs.getString("destinatario"),conex.rs.getInt("quantidade"),conex.rs.getDouble("valor"),conex.rs.getString("casco"),conex.rs.getString("data")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(rootPane,"Pesquisa não encontrada");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableTransferencia.setModel(modelo);
           jTableTransferencia.getColumnModel ().getColumn(0).setPreferredWidth(110);
           jTableTransferencia.getColumnModel().getColumn(0).setResizable(false);
           jTableTransferencia.getColumnModel ().getColumn(1).setPreferredWidth(130);
           jTableTransferencia.getColumnModel().getColumn(1).setResizable(false);
           jTableTransferencia.getColumnModel ().getColumn(2).setPreferredWidth(80);
           jTableTransferencia.getColumnModel().getColumn(2).setResizable(false);
           jTableTransferencia.getColumnModel ().getColumn(3).setPreferredWidth(80);
           jTableTransferencia.getColumnModel().getColumn(3).setResizable(false);
           jTableTransferencia.getColumnModel ().getColumn(4).setPreferredWidth(80);
           jTableTransferencia.getColumnModel().getColumn(4).setResizable(false);
           jTableTransferencia.getColumnModel ().getColumn(5).setPreferredWidth(80);
           jTableTransferencia.getColumnModel().getColumn(5).setResizable(false);
           jTableTransferencia.getTableHeader().setReorderingAllowed(false);
           jTableTransferencia.setAutoResizeMode(jTableTransferencia.AUTO_RESIZE_OFF);
           jTableTransferencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(ConsultaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTransferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonQuantidade;
    private javax.swing.JButton jButtonValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransferencia;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
