package br.com.agenciaviagens.view;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.dao.FuncionarioDao;
import br.com.agenciaviagens.relatorio.FolhaPagamento;
import br.com.agenciaviagens.domain.Funcionario;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.model.ModeloTabela;
import br.com.agenciaviagens.util.Carregar;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class CadastroFuncionarioHistorico extends javax.swing.JFrame {

    UtilitarioDao util = new UtilitarioDao();
    Empresa empresa;
    int codigo;
    final Carregar dialog = new Carregar();

    public CadastroFuncionarioHistorico(Empresa e, int c) {
        initComponents();
        empresa = e;
        codigo = c;
    }

    private CadastroFuncionarioHistorico() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
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

        jLabel2.setText("Inicio");

        jLabel3.setText("Final");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoLocalizar.png"))); // NOI18N
        jButton3.setText("Pesquisar");
        jButton3.setToolTipText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton1.setText("Apurado");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton2.setText("Lucro");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton4.setText("Comissão funcionário");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton5.setText("Folha de pagamento");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Histórico de vendas do funcionário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos data");
        } else {
            dialog.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    preencherTabela("select * from venda inner join funcionario on funcionario = codigo_funcionario where codigo_funcionario = " + codigo + " and data_comissao between '" + jDateChooser1.getDate() + "' and '" + jDateChooser2.getDate() + "' order by data_comissao");
                    dialog.dispose();
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                    jButton4.setEnabled(true);
                    jButton5.setEnabled(true);
                }
            };
            t.start();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existe histórico a somar");
        } else {
            double valor = 0;
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                valor += (double) jTablePadrao.getValueAt(i, 1);
            }
            JOptionPane.showMessageDialog(rootPane, "O valor total em vendas é de " + util.DecimalFormat(valor));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existe histórico a somar");
        } else {
            double valor = 0;
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                valor += (double) jTablePadrao.getValueAt(i, 2);
            }
            JOptionPane.showMessageDialog(rootPane, "O lucro da agência é de " + util.DecimalFormat(valor));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existe histórico a somar");
        } else {
            double valor = 0;
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                valor += (double) jTablePadrao.getValueAt(i, 3);
            }
            JOptionPane.showMessageDialog(rootPane, "O comissionamento do funcionário é de " + util.DecimalFormat(valor));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FolhaPagamento folha = new FolhaPagamento();
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            folha.setData1(util.ArrrumaData4(new Date()) + " a " + util.ArrrumaData6(new Date()));
        } else {
            folha.setData1(util.ArrrumaData(jDateChooser1.getDate()) + " a " + util.ArrrumaData(jDateChooser2.getDate()));
        }
        dialog.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                FuncionarioDao dao = new FuncionarioDao();
                Funcionario func = dao.buscarCodigo(codigo, empresa);
                double comissao = 0;
                double salario = func.getSalario();
                double porcentagemInss = 0;
                double inss = 0;
                double irrf = 0;
                double porcentagemIrrf = 0;
                double baseIrrf;
                for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                    comissao += (double) jTablePadrao.getValueAt(i, 3);
                }
                double total = comissao + salario;
                double baseInss = 0;
                //calculo do inss        
                if (total < 1693.72) {
                    porcentagemInss = 8;
                    inss = total * (8. / 100.);
                    baseInss = comissao + salario;
                } else if (total > 1693.72 && total < 2822.90) {
                    porcentagemInss = 9;
                    inss = total * (9. / 100.);
                    baseInss = comissao + salario;
                } else if (total > 2822.90 && total < 5645.80) {
                    porcentagemInss = 11;
                    inss = total * (11. / 100.);
                    baseInss = comissao + salario;
                } else if (total > 5645.80) {
                    porcentagemInss = 11;
                    inss = 5645.80 * (11. / 100.);
                    baseInss = 5645.80;
                }
                //fim do calculo do inss
                //calculo irrf
                baseIrrf = total - inss;
                if (baseIrrf < 1903.98) {
                    irrf = 0;
                    porcentagemIrrf = 0;
                } else if (baseIrrf > 1903.98 && baseIrrf < 2826.65) {
                    irrf = (baseIrrf * (7.5 / 100.)) - 142.80;
                    porcentagemIrrf = 7.5;
                } else if (baseIrrf > 2826.65 && baseIrrf < 3751.05) {
                    irrf = (baseIrrf * (15. / 100.)) - 354.80;
                    porcentagemIrrf = 15;
                } else if (baseIrrf > 3751.05 && baseIrrf < 4664.68) {
                    irrf = (baseIrrf * (22.5 / 100.)) - 636.13;
                    porcentagemIrrf = 22.5;
                } else if (baseIrrf > 4664.68) {
                    irrf = (baseIrrf * (27.5 / 100.)) - 869.36;
                    porcentagemIrrf = 27.5;
                }
                //fim co calculo  de irrf;
                ArrayList<FolhaPagamento> lista = new ArrayList<>();
                folha.setBasefgts(func.getSalario());
                folha.setBaseinss(baseInss);
                folha.setBaseirrf(baseIrrf);
                folha.setComissao(comissao);
                folha.setFgts(total * (8. / 100.));
                folha.setFuncao(func.getCargo());
                folha.setInss(inss);
                folha.setIrrf(irrf);
                folha.setNome(func.getNome());
                folha.setPorfgts(8);
                folha.setPorinss(porcentagemInss);
                folha.setPorirrf(porcentagemIrrf);
                folha.setPagamento(salario);
                folha.setTotal(total - inss - irrf);
                folha.setCnpj(empresa.getCnpj());
                folha.setEmpresa(empresa.getNome());
                folha.setImpressao("Data de impressão: " + util.ArrrumaData(new Date()));
                folha.setTelefone(empresa.getTelefone());
                lista.add(folha);
                InputStream fonte = FolhaPagamento.class.getResourceAsStream("folha_pagamento.jrxml");
                try {
                    JasperReport report = JasperCompileManager.compileReport(fonte);
                    JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                    JasperViewer.viewReport(print, false);
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
                dialog.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Funcionario", "Valor da venda", "Comissão empresa", "Comissão funcionário", "Data da venda", "Data da comissão"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getString("nome_funcionario"), util.ArrumaDouble(resultado.getDouble("valor_venda")), util.ArrumaDouble(resultado.getDouble("valor_comissao")), util.ArrumaDouble(resultado.getDouble("comissao_func")), util.ArrrumaData(resultado.getDate("data_venda")), util.ArrrumaData(resultado.getDate("data_comissao"))});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado" + ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ModeloTabela modelo = new ModeloTabela(dados, colunas);
                jTablePadrao.setModel(modelo);
                jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(300);
                jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(130);
                jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(140);
                jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(145);
                jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(120);
                jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(120);
                jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
                jTablePadrao.getTableHeader().setReorderingAllowed(false);
                jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });
    }

    private void preencherTabelaVazia() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Funcionario", "Valor da venda", "Comissão empresa", "Comissão funcionário", "Data da venda", "Data da comissão"};
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(300);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(145);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
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
            java.util.logging.Logger.getLogger(CadastroFuncionarioHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionarioHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
