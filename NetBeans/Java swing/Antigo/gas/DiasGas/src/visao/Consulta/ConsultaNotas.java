package visao.Consulta;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansNotasMercadoria;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoNotasMercadoria;

/**
 *
 * @author Lucas
 */
public class ConsultaNotas extends javax.swing.JFrame {
 ConexaoBD conex = new ConexaoBD();
 BeansNotasMercadoria mod = new BeansNotasMercadoria();
 DaoNotasMercadoria control = new DaoNotasMercadoria();
 DecimalFormat df = new DecimalFormat("0.00"); 
   
    public ConsultaNotas() {
        initComponents();
        
         PreencherDescricao();    
    }

     public void PreencherDescricao(){
        conex.Conexao();
        conex.executaSql("select * from produtos order by nome_produto");
    try {
        conex.rs.first();
        jComboBoxProduto.removeAllItems();
        do{
            jComboBoxProduto.addItem(conex.rs.getString("nome_produto"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
          
    }
        conex.Desconecta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNota = new javax.swing.JTable();
        jButtonSomaNotas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonPesquisar1 = new javax.swing.JButton();
        jButtonNaoPagas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCodigo.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNota);

        jButtonSomaNotas.setText("Somar Notas");
        jButtonSomaNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSomaNotas.setEnabled(false);
        jButtonSomaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomaNotasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseClicked(evt);
            }
        });

        jButtonPesquisar1.setText("Pesquisar");
        jButtonPesquisar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar1))
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonNaoPagas.setText("Buscar notas ainda não pagas");
        jButtonNaoPagas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNaoPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaoPagasActionPerformed(evt);
            }
        });

        jButton2.setText("Somar Qtd");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonNaoPagas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSomaNotas)))
                        .addGap(17, 17, 17)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNaoPagas)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSomaNotas)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSomaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomaNotasActionPerformed
    double countNotas=0;
    for (int i=0; i<=jTableNota.getRowCount()-1;i++) {
    countNotas+=Double.parseDouble(jTableNota.getValueAt(i, 4).toString());
}
     String dx = df.format(countNotas);
    JOptionPane.showMessageDialog(null,"O valor em notas é de R$ "+ dx + " reais");
    }//GEN-LAST:event_jButtonSomaNotasActionPerformed

    private void jButtonPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisar1ActionPerformed
     if(jFormattedTextFieldData.getText().isEmpty()){
         JOptionPane.showMessageDialog(rootPane,"Insira a data de sua pesquisa");
     }else{
        mod.setPesquisar(jFormattedTextFieldData.getText());
        String Produto =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produto+"' and data like'%" + mod.getPesquisar()+"%'order by codigo");
        jButtonSomaNotas.setEnabled(true);       
        jButton2.setEnabled(true);
     }
    }//GEN-LAST:event_jButtonPesquisar1ActionPerformed

    private void jButtonNaoPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNaoPagasActionPerformed
       preencherTabela("select * from notasmercadoria where situacao='"+"Aberta"+"' order by codigo");
      jButtonSomaNotas.setEnabled(true);
       
         jButton2.setEnabled(true);
    }//GEN-LAST:event_jButtonNaoPagasActionPerformed

    private void jTableNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNotaMouseClicked
        String cliente_nome =""+jTableNota.getValueAt(jTableNota.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from notasmercadoria where codigo='"+ cliente_nome +"'");
           try {
               conex.rs.first();              
               jTextFieldCodigo.setText(conex.rs.getString("codigo"));
               
                } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }//GEN-LAST:event_jTableNotaMouseClicked

    private void jComboBoxProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseClicked
      PreencherDescricao(); 
    }//GEN-LAST:event_jComboBoxProdutoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int countNotas=0;
    for (int i=0; i<=jTableNota.getRowCount()-1;i++) {
    countNotas+=Integer.parseInt(jTableNota.getValueAt(i, 5).toString());
}
    JOptionPane.showMessageDialog(null,"A quantidade é "+ countNotas);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
     public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Cod","Descrição da nota","Produto","Data de chegada","Valor","Quantidade","C/S Casco","Vencimento","Situação"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("codigo"),conex.rs.getString("descricao_nota"),conex.rs.getString("produto"),conex.rs.getString("data"),conex.rs.getDouble("valor"),conex.rs.getString("quantidade"),conex.rs.getString("casco"),conex.rs.getString("vencimento"),conex.rs.getString("situacao")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Não foram encontradas notas com esse perfil");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableNota.setModel(modelo);
           jTableNota.getColumnModel ().getColumn(0).setPreferredWidth(40);
           jTableNota.getColumnModel().getColumn(0).setResizable(false);
           jTableNota.getColumnModel ().getColumn(1).setPreferredWidth(120);
           jTableNota.getColumnModel().getColumn(1).setResizable(false);
           jTableNota.getColumnModel ().getColumn(2).setPreferredWidth(95);
           jTableNota.getColumnModel().getColumn(2).setResizable(false);
           jTableNota.getColumnModel ().getColumn(3).setPreferredWidth(110);
           jTableNota.getColumnModel().getColumn(3).setResizable(false);
           jTableNota.getColumnModel ().getColumn(4).setPreferredWidth(70);
           jTableNota.getColumnModel().getColumn(4).setResizable(false);
           jTableNota.getColumnModel ().getColumn(5).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(5).setResizable(false);
           jTableNota.getColumnModel ().getColumn(6).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(6).setResizable(false);
           jTableNota.getColumnModel ().getColumn(7).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(7).setResizable(false);
           jTableNota.getColumnModel ().getColumn(8).setPreferredWidth(70);
           jTableNota.getColumnModel().getColumn(8).setResizable(false);
          jTableNota.getTableHeader().setReorderingAllowed(false);
           jTableNota.setAutoResizeMode(jTableNota.AUTO_RESIZE_OFF);
           jTableNota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(ConsultaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonNaoPagas;
    private javax.swing.JButton jButtonPesquisar1;
    private javax.swing.JButton jButtonSomaNotas;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNota;
    private javax.swing.JTextField jTextFieldCodigo;
    // End of variables declaration//GEN-END:variables
}
