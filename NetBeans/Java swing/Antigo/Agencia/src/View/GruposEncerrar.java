package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoGrupos;
import TableModel.ModeloTabela;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class GruposEncerrar extends javax.swing.JDialog {

    ConexaoBD conex = new ConexaoBD();
    BeansGrupos grupos = new BeansGrupos();
    ArrayList<String> NomeGrupo = new ArrayList();// 
    DaoGrupos control = new DaoGrupos();
    int codigo = 0;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public GruposEncerrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PreencherGrupos();
    }

    public void PreencherGrupos() {
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where situacao='Aberto' order by nomemelhorado");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        jLabel2.setText("Escolha o grupo");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Encerrar atividade com o grupo");
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Encerrar atividades com o grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(474, 474, 474))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBoxGrupos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem grupos no sistema");
        } else {
            int posicao = jComboBoxGrupos.getSelectedIndex();
            String tabela = NomeGrupo.get(posicao);
            preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Passageiro' order by nome");

            jButton2.setEnabled(true);
            codigo = 1;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jComboBoxGrupos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem grupos no sistema");
        } else {
            Calendar data = Calendar.getInstance();
            Date d = data.getTime();
            SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.format(d);
            String dtHoje;
            dtHoje = dateFormat.format(d);
            int posicao = jComboBoxGrupos.getSelectedIndex();
            String tabela = NomeGrupo.get(posicao);
            preencherTabela("select * from " + tabela + " INNER JOIN clientes on codigo_cliente = clientes.codigo where tipo_passageiro ='Passageiro' order by nome ");
            int qtd = jTableClientes.getRowCount();
            double valor = 0;
            for (int i = 0; i < qtd; i++) {
                valor += Double.parseDouble(jTableClientes.getValueAt(i, 3).toString());
            }
            conex.Conexao();
            conex.executaSql("select * from grupos_excursoes where nome='" + tabela + "'");
            try {
                conex.rs.first();
                int codigoTabela = (conex.rs.getInt("codigo"));
                double valorOscilante = (conex.rs.getDouble("valores_oscilantes"));
                double valorFixo = (conex.rs.getDouble("valores_fixos"));
                double totalOscilante = qtd * valorOscilante;
                double lucro = (valor - totalOscilante) - valorFixo;
                
                grupos.setNome((String) jComboBoxGrupos.getSelectedItem());
                grupos.setData_fechamento(dtHoje);
                grupos.setLucro(lucro);
                control.Encerrar(grupos, codigoTabela);
                PreencherGrupos();
                preencherTabela2();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
            }
            conex.Desconecta();

        }
    }//GEN-LAST:event_jButton2ActionPerformed
 public void preencherTabela2(){
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Cliente", "Pagamento", "Valor total", "Total de parcelas", "Parcelas pagas", "Valor pago", "Valor restante", "Parcelas restantes", "Situação"};
       
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
    
    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Cliente", "Pagamento", "Valor total", "Total de parcelas", "Parcelas pagas", "Valor pago", "Valor restante", "Parcelas restantes", "Situação"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            int numero = 1;
            do {
                String situacao;
                if (conex.rs.getDouble("valor_pago") >= conex.rs.getDouble("valor")) {
                    situacao = "Fechada";
                } else {
                    situacao = "Aberta";
                }
                dados.add(new Object[]{numero, conex.rs.getString("nome"), conex.rs.getString("forma_pagamento"), conex.rs.getDouble("valor"), conex.rs.getInt("numero_parcelas"), conex.rs.getInt("parcelas_pagas"), conex.rs.getDouble("valor_pago"), conex.rs.getDouble("valor") - conex.rs.getDouble("valor_pago"), conex.rs.getInt("numero_parcelas") - conex.rs.getInt("parcelas_pagas"), situacao});
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
            java.util.logging.Logger.getLogger(GruposEncerrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GruposEncerrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GruposEncerrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GruposEncerrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GruposEncerrar dialog = new GruposEncerrar(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
