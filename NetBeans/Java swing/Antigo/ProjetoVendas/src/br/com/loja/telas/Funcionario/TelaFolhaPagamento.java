package br.com.loja.telas.Funcionario;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.dao.FuncionarioDao;
import br.com.loja.dao.InssDao;
import br.com.loja.dao.IrrfDao;
import br.com.loja.domain.ControleFolhaPagamento;
import br.com.loja.domain.FolhaPagamento;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Inss;
import br.com.loja.domain.Irrf;
import br.com.loja.tabelas.ModeloTabela;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class TelaFolhaPagamento extends javax.swing.JDialog {

    Funcionario funcionario;
    int flag = 0;
    ControleFolhaPagamento folha = new ControleFolhaPagamento();
    DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public TelaFolhaPagamento(java.awt.Frame parent, boolean modal, Funcionario f) {
        super(parent, modal);
        initComponents();
        funcionario = f;
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextFieldPesquisa.setText(dtHoje);
        pesquisar();
    }

    private TelaFolhaPagamento(JFrame jFrame, boolean b) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jFormattedTextFieldPesquisa = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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

        try {
            jFormattedTextFieldPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Novo registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alterar registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Excluir registro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Gerar folha");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Verificar Status");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jFormattedTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(108, 108, 108))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Folha de pagamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FolhaPagamentoNovo dialog = new FolhaPagamentoNovo(new javax.swing.JFrame(), true, funcionario);
        dialog.setVisible(true);
        pesquisar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (flag == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro");
        } else {
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o funcionario?");
            if (resposta == JOptionPane.YES_OPTION) {
                FuncionarioDao dao = new FuncionarioDao();
                dao.excluirPagamento(folha);
            }
            pesquisar();
            flag = 0;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        folha.setCodigo((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0));
        folha.setDescricao((String) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 2));
        folha.setData((String) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 3));
        folha.setValor((double) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 4));
        flag = 1;
    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (flag == 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro");
        } else {
            FolhaPagamentoAlterar dialog = new FolhaPagamentoAlterar(new javax.swing.JFrame(), true, funcionario, folha);
            dialog.setVisible(true);
            pesquisar();
            flag = 0;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InssDao inssdao = new InssDao();
        ArrayList<Inss> listaInss = inssdao.receberInss();
        IrrfDao irrfdao = new IrrfDao();
        ArrayList<Irrf> listaIrrf = irrfdao.receberIrrf();
        if (listaInss.isEmpty() || listaIrrf.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Verifique as taxas de inss e irrf na aba administração");
        } else {
            FolhaPagamento pagamento = new FolhaPagamento();
            ArrayList<FolhaPagamento> lista = new ArrayList<>();
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                String descricao = (String) jTablePadrao.getValueAt(i, 2);
                switch (descricao) {
                    case "Pagamento":
                        pagamento.setPagamento(pagamento.getPagamento() + (double) jTablePadrao.getValueAt(i, 4));
                        break;
                    case "Adiantamento":
                        pagamento.setAdiantamento(pagamento.getAdiantamento() + (double) jTablePadrao.getValueAt(i, 4));
                        break;
                }
            }
            boolean verificaInss = false;
            Inss inss = null;
            for (Inss i : listaInss) {
                if (funcionario.getSalario() > i.getValorInicial() && funcionario.getSalario() < i.getValorFinal()) {
                    pagamento.setPorinss(i.getPorcentagem());
                    pagamento.setInss(funcionario.getSalario() / 100 * i.getPorcentagem());
                    verificaInss = true;
                }
                inss = i;
                if (verificaInss) {
                    pagamento.setBaseinss(funcionario.getSalario());
                    break;
                }
            }
            if (!verificaInss) {
                pagamento.setBaseinss(inss.getValorFinal());
                pagamento.setPorinss(inss.getPorcentagem());
                pagamento.setInss(inss.getValorFinal() / 100 * inss.getPorcentagem());
            }
            double baseIrrf = funcionario.getSalario() - pagamento.getInss();           
            boolean verifica = false;
            for (Irrf i : listaIrrf) {               
                if (baseIrrf > i.getValorInicial() && baseIrrf < i.getValorFinal()) {
                    pagamento.setPorirrf(i.getPorcentagem());
                    pagamento.setIrrf(baseIrrf / 100 * i.getPorcentagem() - i.getDevolver());
                    verifica = true;                   
                }
                if (verifica) {
                    break;
                }
            }
            if (!verifica) {               
                pagamento.setPorirrf(0);
                pagamento.setIrrf(0);
            }
            pagamento.setBasefgts(funcionario.getSalario());
            pagamento.setBaseirrf(baseIrrf);
            pagamento.setTotal(funcionario.getSalario() - pagamento.getInss() - pagamento.getIrrf());
            pagamento.setNome(funcionario.getNome());
            pagamento.setSalario(funcionario.getSalario());
            pagamento.setFuncao(funcionario.getFuncao());
            pagamento.setPorfgts(funcionario.getFgts());
            pagamento.setFgts(funcionario.getSalario() / 100 * funcionario.getFgts());
            pagamento.setData(jFormattedTextFieldPesquisa.getText());
            lista.add(pagamento);
            InputStream fonte = TelaFolhaPagamento.class.getResourceAsStream("folha_pagamento.jrxml");
            try {
                JasperReport report = JasperCompileManager.compileReport(fonte);
                JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                JasperViewer.viewReport(print, false);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        double count = 0;
        for (int i = 0; i <= jTablePadrao.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTablePadrao.getValueAt(i, 4).toString());
        }
        String dx = df.format(count);
        double inss = 0;
        double porcentagem = 0;
        double valorFinal = 0;
        InssDao inssdao = new InssDao();
        ArrayList<Inss> listaInss = inssdao.receberInss();
        IrrfDao irrfdao = new IrrfDao();
        ArrayList<Irrf> listaIrrf = irrfdao.receberIrrf();
        if (listaInss.isEmpty() || listaIrrf.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Verifique as taxas de inss e irrf na aba administração");
        } else {
            boolean verificaInss = false;

            for (Inss i : listaInss) {
                if (funcionario.getSalario() > i.getValorInicial() && funcionario.getSalario() < i.getValorFinal()) {
                    inss = funcionario.getSalario() / 100 * i.getPorcentagem();
                    verificaInss = true;
                }
                porcentagem = i.getPorcentagem();
                valorFinal = i.getValorFinal();
                if (verificaInss) {
                    break;
                }
            }
            if (!verificaInss) {
                inss = valorFinal / 100 * porcentagem;
            }
            double baseIrrf = funcionario.getSalario() - inss;
            double irrf = 0;

            boolean verifica = false;
            for (Irrf i : listaIrrf) {
                if (baseIrrf > i.getValorInicial() && baseIrrf < i.getValorFinal()) {
                    irrf = (baseIrrf / 100 * i.getPorcentagem() - i.getDevolver());
                    verifica = true;
                }
                if (verifica) {
                    break;
                }
            }
            if (!verifica) {
                irrf = 0;
            }
            double valorAPagar = funcionario.getSalario() - inss - irrf;
            String dc = df.format(valorAPagar);
            double restante = valorAPagar - count;
            String dv = df.format(restante);
            JOptionPane.showMessageDialog(null, "Salário bruto R$ " + funcionario.getSalario() + "\nValor liquido a pagar R$ " + dc + "\nValor pago R$ " + dx + "\nValor restante R$ " + dv);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void pesquisar() {
        preencherTabela("select * from folha_pagamento inner join funcionario on funcionario = codigo_funcionario where data ilike'%" + jFormattedTextFieldPesquisa.getText() + "%' and funcionario=" + funcionario.getCodigo() + " order by codigo_salario");
    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Descrição", "Data", "Valor"};
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getInt("codigo_salario"), resultado.getString("nome"), resultado.getString("descricao"), resultado.getString("data"), resultado.getDouble("valor_salario")});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Registro não encontrado " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(230);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(105);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(185);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(130);
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
            java.util.logging.Logger.getLogger(TelaFolhaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFolhaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFolhaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFolhaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFolhaPagamento dialog = new TelaFolhaPagamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFormattedTextField jFormattedTextFieldPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
