package br.com.deposito.tela.consultas;

import br.com.deposito.dao.BaixaDao;
import br.com.deposito.dao.GastoFuncionarioDao;
import br.com.deposito.dao.GastoVeiculoDao;
import br.com.deposito.dao.GastosEventuaisDao;
import br.com.deposito.domain.Baixa;
import br.com.deposito.domain.Gasto;
import br.com.deposito.domain.GastoFuncionario;
import br.com.deposito.domain.GastoVeiculo;
import br.com.deposito.domain.GastosEventuais;
import br.com.deposito.domain.Usuario;
import br.com.deposito.util.ModeloTabela;
import br.com.deposito.util.UtilitarioDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ConsultaGasto extends javax.swing.JFrame {

    private Usuario usuario;
    int selecionado = 0;
    boolean pesquisou = false;
    BaixaDao daoBaixa = new BaixaDao();
    GastoFuncionarioDao daoFuncionario = new GastoFuncionarioDao();
    GastoVeiculoDao daoVeiculo = new GastoVeiculoDao();
    GastosEventuaisDao daoEventuais = new GastosEventuaisDao();
    private ArrayList<GastoVeiculo> listaVeiculo;
    private ArrayList<GastoFuncionario> listaFuncionario;
    private ArrayList<Baixa> listaBaixa;
    private ArrayList<GastosEventuais> listaEventuais;
    private ArrayList<Gasto> lista;

    public ConsultaGasto(Usuario u) {
        initComponents();
        usuario = u;
    }

    private ConsultaGasto() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Inicio");

        jLabel3.setText("Final");

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

        jButton4.setText("Somar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Veiculo", "Funcionário", "Baixa", "Eventual" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jButton5)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de gastos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos tipo data para poder realizar a pesquisa");
        } else {
            Pesquisar();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!pesquisou) {
            JOptionPane.showMessageDialog(rootPane, "Faça um pesquisa para poder somar");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            double count = 0;
            for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
                count += Double.parseDouble(jTablePadrao.getValueAt(i, 3).toString());
            }
            JOptionPane.showMessageDialog(null, "O valor total em gastos é  " + util.DecimalFormat(count));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void Pesquisar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(jDateChooser2.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date data2 = calendar.getTime();
        listaBaixa = daoBaixa.Listar(usuario.getDeposito().getCodigo(), jDateChooser1.getDate(), data2);
        listaEventuais = daoEventuais.Listar(usuario.getDeposito().getCodigo(), jDateChooser1.getDate(), data2);
        listaFuncionario = daoFuncionario.Listar(usuario.getDeposito().getCodigo(), jDateChooser1.getDate(), data2);
        listaVeiculo = daoVeiculo.Listar(usuario.getDeposito().getCodigo(), jDateChooser1.getDate(), data2);
        preencherGasto();
        Collections.sort(lista);
        preencherTabela();
        pesquisou = true;
    }

    private void preencherGasto() {
        lista = new ArrayList<>();
        if (jComboBox1.getSelectedItem().equals("Todos")) {
            listaBaixa.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor() * b.getQuantidade());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Baixa");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
            listaFuncionario.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Funcionario");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
            listaVeiculo.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Veiculo");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
            listaEventuais.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Eventuais");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
        } else if (jComboBox1.getSelectedItem().equals("Veiculo")) {
            listaVeiculo.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Veiculo");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
        } else if (jComboBox1.getSelectedItem().equals("Funcionário")) {
            listaFuncionario.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Funcionario");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
        } else if (jComboBox1.getSelectedItem().equals("Baixa")) {
            listaBaixa.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor() * b.getQuantidade());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Baixa");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
        } else if (jComboBox1.getSelectedItem().equals("Eventual")) {
            listaEventuais.stream().map((b) -> {
                Gasto gasto = new Gasto();
                gasto.setData(b.getData());
                gasto.setDescricao(b.getDescricao());
                gasto.setValor(b.getValor());
                return gasto;
            }).map((gasto) -> {
                gasto.setResponsavel("Eventuais");
                return gasto;
            }).forEachOrdered((gasto) -> {
                lista.add(gasto);
            });
        }
    }

    private void preencherTabela() {
        UtilitarioDao util = new UtilitarioDao();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Data", "Responsavel", "Descrição", "Valor"};
        lista.forEach((g) -> {
            dados.add(new Object[]{util.ArrrumaData(g.getData()), g.getResponsavel(), g.getDescricao(), util.ArrumaDouble(g.getValor())});
        });
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(118);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(233);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
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
            java.util.logging.Logger.getLogger(ConsultaGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConsultaGasto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
