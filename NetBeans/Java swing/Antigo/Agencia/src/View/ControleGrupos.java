package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import TableModel.ModeloTabela;
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


public class ControleGrupos extends javax.swing.JFrame {
     ConexaoBD conex = new ConexaoBD();
     BeansGrupos grupos = new BeansGrupos();    
     int codigo=0;
     DecimalFormat df = new DecimalFormat("###,###,##0.00");
    
    ArrayList<String> NomeGrupo = new ArrayList();
    public ControleGrupos() {
        initComponents();
        PreencherGrupos();
    }
    public void preencherDados(){
       int posicao = jComboBoxGrupos.getSelectedIndex();
       String tabela = NomeGrupo.get(posicao); 
       preencherTabela("select * from "+tabela+" INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Tripulação' order by nome");
       int tripulacao = jTableClientes.getRowCount();
       preencherTabela("select * from "+tabela+" INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Passageiro' order by nome ");
      int qtd = jTableClientes.getRowCount();
      double valor=0;
      for(int i=0; i<qtd; i++){
        valor+=Double.parseDouble(jTableClientes.getValueAt(i, 3).toString());
      }
      String cliente_nome = (String) jComboBoxGrupos.getSelectedItem();
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where nomemelhorado='"+ cliente_nome +"'");
           try {
               conex.rs.first();
               double valorOscilante =(conex.rs.getDouble("valores_oscilantes"));
               double valorFixo=(conex.rs.getDouble("valores_fixos")); 
               double preco = (conex.rs.getDouble("preco_venda"));
               int maximoPX = (conex.rs.getInt("vagas"));
               double totalOscilante = qtd * valorOscilante;
               double faltante = (valor - totalOscilante)-valorFixo;
               double transforma = faltante - faltante - faltante;
               double cobrir = preco - valorOscilante;
               int pxFaltante =1;
               int vagas = maximoPX -qtd - tripulacao;
               for(double i= cobrir;i<=transforma; i+=cobrir){                  
                //  JOptionPane.showMessageDialog(rootPane, i+"-"+pxFaltante);
                  pxFaltante++; 
               }               
               if(faltante<=0){
               JOptionPane.showMessageDialog(rootPane,"*Valores fixos do grupo R$ "+valorFixo+"\n"
                                                     +"*valores oscilantes do grupo R$ "+ valorOscilante+"\n"
                                                     +"*valor de venda R$ "+ preco+"\n"
                                                     +"*Valor faltante para cobrir os custos fixos do grupo R$ " +faltante+"\n"
                                                     +"*O numero de passageiros faltantes para cobrir os gastos fixos é de " + pxFaltante+" passageiros\n"
                                                     +"*Numero maximo de vagas " +maximoPX+"\n"
                                                     +"*Passageiros confirmados "+ qtd+"\n"//
                                                     +"*Tripulação "+tripulacao+"\n"
                                                     +"*Vagas em aberto "+ vagas);   
             }else{
               JOptionPane.showMessageDialog(rootPane,"*Valores fixos do grupo R$ "+valorFixo+"\n"
                                                     +"*valores oscilantes do grupo R$ "+ valorOscilante+"\n"
                                                     +"*valor de venda R$ "+ preco+"\n"
                                                     +"*Valor lucrado com o grupo até o momento R$ " +faltante+"\n"
                                                     +"*Numero maximo de vagas " +maximoPX+"\n"
                                                     +"*Passageiros confirmados "+ qtd+"\n"
                                                     +"*Tripulação "+tripulacao+"\n"
                                                     +"*Vagas em aberto "+ vagas);     
           }              
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonValorTotal = new javax.swing.JButton();
        jButtonValorRecebido = new javax.swing.JButton();
        jButtonValorAReceber = new javax.swing.JButton();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTableClientes);

        jButtonValorTotal.setText("Valor total");
        jButtonValorTotal.setEnabled(false);
        jButtonValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorTotalActionPerformed(evt);
            }
        });

        jButtonValorRecebido.setText("Valor recebido");
        jButtonValorRecebido.setEnabled(false);
        jButtonValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorRecebidoActionPerformed(evt);
            }
        });

        jButtonValorAReceber.setText("Valor a receber");
        jButtonValorAReceber.setEnabled(false);
        jButtonValorAReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorAReceberActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Informações do grupo");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir dados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "Fechado" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonValorAReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValorTotal)
                    .addComponent(jButtonValorRecebido)
                    .addComponent(jButtonValorAReceber)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Status dos passageiros");

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
                        .addGap(489, 489, 489)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(jComboBoxGrupos.getSelectedItem()== null){
          JOptionPane.showMessageDialog(rootPane,"Não existem grupos no sistema");
      }else{
       int posicao = jComboBoxGrupos.getSelectedIndex();
       String tabela = NomeGrupo.get(posicao); 
       preencherTabela("select * from "+tabela+" INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Passageiro' order by nome");
       jButtonValorTotal.setEnabled(true);
       jButtonValorRecebido.setEnabled(true);
       jButtonValorAReceber.setEnabled(true);
       jButton2.setEnabled(true);
       codigo=1;
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorTotalActionPerformed
        int contador = jTableClientes.getRowCount();
   if(contador ==0){
       JOptionPane.showMessageDialog(rootPane,"Operação não pode ser realizada pois a tabela está vazia.");
   }else{
        
        double count=0;
    for (int i=0; i<=jTableClientes.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableClientes.getValueAt(i, 3).toString());
}
    String dx = df.format(count);
    JOptionPane.showMessageDialog(null,"O valor maximo do grupo no momento é R$ "+ dx + " reais");
   }
    }//GEN-LAST:event_jButtonValorTotalActionPerformed

    private void jButtonValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorRecebidoActionPerformed
          int contador = jTableClientes.getRowCount();
   if(contador ==0){
       JOptionPane.showMessageDialog(rootPane,"Operação não pode ser realizada pois a tabela está vazia.");
   }else{
        
        double count=0;
    for (int i=0; i<=jTableClientes.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableClientes.getValueAt(i, 6).toString());
}
    String dx = df.format(count);
    JOptionPane.showMessageDialog(null,"O valor recebido até o momento é R$ "+ dx + " reais");
   }
    }//GEN-LAST:event_jButtonValorRecebidoActionPerformed

    private void jButtonValorAReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorAReceberActionPerformed
            int contador = jTableClientes.getRowCount();
   if(contador ==0){
       JOptionPane.showMessageDialog(rootPane,"Operação não pode ser realizada pois a tabela está vazia.");
   }else{
        
        double count=0;
    for (int i=0; i<=jTableClientes.getRowCount()-1;i++) {
    count+=Double.parseDouble(jTableClientes.getValueAt(i, 7).toString());
}
    String dx = df.format(count);
    JOptionPane.showMessageDialog(null,"O valor a ser recebido é R$ "+ dx + " reais");
   }

    }//GEN-LAST:event_jButtonValorAReceberActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 if(jComboBoxGrupos.getSelectedItem()== null){
          JOptionPane.showMessageDialog(rootPane,"Não existem grupos no sistema");
      }else{
       
       preencherDados();
      
       jButtonValorTotal.setEnabled(true);
       jButtonValorRecebido.setEnabled(true);
       jButtonValorAReceber.setEnabled(true);
      }     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int contador = jTableClientes.getRowCount();
        if(contador ==0 || codigo ==0){
            JOptionPane.showMessageDialog(rootPane,"Operação não pode ser realizada pois a tabela está vazia.");
        }else{            
            Calendar data = Calendar.getInstance();
            Date d = data.getTime();
            SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.format(d);
            String dtHoje;
            dtHoje = dateFormat.format(d);
            String imprimir = (String) jComboBoxGrupos.getSelectedItem();
            String nova = imprimir.toUpperCase();
            MessageFormat headerFormat = new MessageFormat(nova);
            MessageFormat footerFormat = new MessageFormat("Data da impressão "+ dtHoje);
            try {
                jTableClientes.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(rootPane,"erro"+ ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      PreencherGrupos();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public void PreencherGrupos() {
        String tipo = (String) jComboBox1.getSelectedItem();
        NomeGrupo = new ArrayList();
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes  where situacao='"+tipo+"' order by nomemelhorado");
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
        String[] colunas = new String[]{"ID","Cliente","Pagamento","Valor total","Total de parcelas","Parcelas pagas","Valor pago","Valor restante","Parcelas restantes","Situação"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            int numero=1;
            do {
                 String situacao;
                if(conex.rs.getDouble("valor_pago")>=conex.rs.getDouble("valor")){
                    situacao ="Fechada";
                }else{
                    situacao ="Aberta";
                }
                dados.add(new Object[]{numero, conex.rs.getString("nome"), conex.rs.getString("forma_pagamento"), conex.rs.getDouble("valor"), conex.rs.getInt("numero_parcelas"),conex.rs.getInt("parcelas_pagas"),conex.rs.getDouble("valor_pago"),conex.rs.getDouble("valor")-conex.rs.getDouble("valor_pago"),conex.rs.getInt("numero_parcelas")-conex.rs.getInt("parcelas_pagas"),situacao });
             numero++;
            } while (conex.rs.next());
        } catch (SQLException ex) {
         
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(6).setResizable(false);
        jTableClientes.getColumnModel().getColumn(7).setPreferredWidth(110);
        jTableClientes.getColumnModel().getColumn(7).setResizable(false);
        jTableClientes.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(8).setResizable(false);
        jTableClientes.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTableClientes.getColumnModel().getColumn(9).setResizable(false);
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
            java.util.logging.Logger.getLogger(ControleGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonValorAReceber;
    private javax.swing.JButton jButtonValorRecebido;
    private javax.swing.JButton jButtonValorTotal;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
