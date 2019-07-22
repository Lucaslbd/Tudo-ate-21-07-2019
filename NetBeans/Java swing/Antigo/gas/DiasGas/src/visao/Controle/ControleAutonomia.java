package visao.Controle;

import visao.Consulta.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAutonomia;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoAutonomia;


public class ControleAutonomia extends javax.swing.JFrame {
    ConexaoBD conex = new ConexaoBD();
    BeansAutonomia mod = new BeansAutonomia();
    DaoAutonomia dao = new DaoAutonomia();
    DecimalFormat df = new DecimalFormat("0.##");
    int codigo;
    
    public ControleAutonomia() {
        initComponents();
         PreencherVeiculos();
    }
    public void conta(double s, double t){
        DecimalFormat fmt = new DecimalFormat("0.00");       
            String string = fmt.format(s);
            String[] part = string.split("[,]");
            String string2 = part[0]+"."+part[1];
            t = Double.parseDouble(string2); 
    }
     public void PreencherVeiculos(){
    conex.Conexao();
        conex.executaSql("select * from veiculos order by placa");
    try {
        conex.rs.first();
        jComboBoxVeiculo.removeAllItems();
        do{
            jComboBoxVeiculo.addItem(conex.rs.getString("placa"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
         
    }
        conex.Desconecta();
     }

    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Veiculo","Km","Litros","Valor","Data","Entregas","Gasto"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{               
                   double preco;                  
                   double valor = conex.rs.getDouble("valor");
                   int entregas = conex.rs.getInt("entregas");                   
                   if (entregas == 0){
                       preco = 0;                       
                   }else{              
            /*------------------------------------------*/
            double result = valor / entregas;       
            DecimalFormat fmt = new DecimalFormat("0.00");       
            String string = fmt.format(result);
            String[] part = string.split("[,]");
            String string2 = part[0]+"."+part[1];
             preco = Double.parseDouble(string2);
             /*--------------------------------------------*/
             
            }              
                 dados.add(new Object[]{conex.rs.getInt("codigo"),conex.rs.getString("veiculo"),conex.rs.getString("km"),conex.rs.getDouble("litros"),conex.rs.getDouble("valor"),conex.rs.getString("data"),conex.rs.getInt("entregas"),preco});
                }while(conex.rs.next());
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(rootPane,"Pesquisa não encontrada");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableAutonomia.setModel(modelo);
           jTableAutonomia.getColumnModel ().getColumn(0).setPreferredWidth(40);
           jTableAutonomia.getColumnModel().getColumn(0).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(1).setPreferredWidth(93);
           jTableAutonomia.getColumnModel().getColumn(1).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(2).setPreferredWidth(60);
           jTableAutonomia.getColumnModel().getColumn(2).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(3).setPreferredWidth(60);
           jTableAutonomia.getColumnModel().getColumn(3).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(4).setPreferredWidth(60);
           jTableAutonomia.getColumnModel().getColumn(4).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(5).setPreferredWidth(80);
           jTableAutonomia.getColumnModel().getColumn(5).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(6).setPreferredWidth(65);
           jTableAutonomia.getColumnModel().getColumn(6).setResizable(false);
           jTableAutonomia.getColumnModel ().getColumn(7).setPreferredWidth(55);
           jTableAutonomia.getColumnModel().getColumn(7).setResizable(false);
            jTableAutonomia.getTableHeader().setReorderingAllowed(false);
           jTableAutonomia.setAutoResizeMode(jTableAutonomia.AUTO_RESIZE_OFF);
           jTableAutonomia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        conex.Desconecta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAutonomia = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxVeiculo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAutonomia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAutonomia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAutonomiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAutonomia);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxVeiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxVeiculoMouseEntered(evt);
            }
        });

        jLabel1.setText("Veiculo");

        jLabel2.setText("Data");

        jButton1.setText("Pesquisar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldData)
                    .addComponent(jComboBoxVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Excluir");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Consulta de autonomia dos veiculos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(233, 233, 233))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mod.setPesquisar(jTextFieldData.getText());
        String Produto =(String) jComboBoxVeiculo.getSelectedItem();
        preencherTabela("select *from autonomia where  veiculo='"+Produto+"' and data like'%" + mod.getPesquisar()+"%' order by codigo");
        
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoMouseClicked
     
    }//GEN-LAST:event_jComboBoxVeiculoMouseClicked

    private void jComboBoxVeiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoMouseEntered
        PreencherVeiculos();
    }//GEN-LAST:event_jComboBoxVeiculoMouseEntered

    private void jTableAutonomiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAutonomiaMouseClicked
        codigo = (int) jTableAutonomia.getValueAt(jTableAutonomia.getSelectedRow(),0);
        jButton2.setEnabled(true);
        
    }//GEN-LAST:event_jTableAutonomiaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente desfazer?");
        if(resposta ==JOptionPane.YES_OPTION){
       mod.setCodigo(codigo);
       dao.Excluir(mod);
        }
        jButton2.setEnabled(false);
         mod.setPesquisar(jTextFieldData.getText());
        String Produto =(String) jComboBoxVeiculo.getSelectedItem();
        preencherTabela("select *from autonomia where  veiculo='"+Produto+"' and data like'%" + mod.getPesquisar()+"%' order by codigo");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ControleAutonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleAutonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleAutonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleAutonomia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleAutonomia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAutonomia;
    private javax.swing.JTextField jTextFieldData;
    // End of variables declaration//GEN-END:variables
}
