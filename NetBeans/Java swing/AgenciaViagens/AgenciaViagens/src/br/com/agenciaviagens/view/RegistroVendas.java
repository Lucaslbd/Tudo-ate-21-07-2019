package br.com.agenciaviagens.view;

import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.grafico.BarrasVendas;
import br.com.agenciaviagens.grafico.GraficoVendas;
import br.com.agenciaviagens.model.ModeloTabela;
import br.com.agenciaviagens.relatorio.RelatorioGeralVendas;
import br.com.agenciaviagens.util.Carregar;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.InputStream;
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

public class RegistroVendas extends javax.swing.JFrame {

    Empresa usuario;
    ArrayList<Venda> lista;
    VendaDao dao = new VendaDao();
    UtilitarioDao util = new UtilitarioDao();
    int pesquisa = 0;
    final Carregar carregar = new Carregar();

    public RegistroVendas(Empresa u) {
        initComponents();
        usuario = u;
    }

    private RegistroVendas() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/gravar.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setToolTipText("Registrar nova venda");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/alterar.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.setToolTipText("Alterar venda");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton3.setText("Somar vendas");
        jButton3.setToolTipText("Somar vendas");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/remover.png"))); // NOI18N
        jButton4.setText("Remover");
        jButton4.setToolTipText("Remover venda");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton5.setText("Somar lucro");
        jButton5.setToolTipText("Somar lucro");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton6.setText("Somar quantidade");
        jButton6.setToolTipText("Somar quantidade");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Pesquisa por data"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data da venda", "Data a receber" }));

        jLabel2.setText("Inicio");

        jLabel3.setText("Final");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoLocalizar.png"))); // NOI18N
        jButton7.setToolTipText("Pesquisar");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setText("Filtro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 156, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/localizar.gif"))); // NOI18N
        jButton9.setText("Listar comissões a receber");
        jButton9.setToolTipText("Listar comissões a receber");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/yes.png"))); // NOI18N
        jButton10.setText("Mudar status");
        jButton10.setToolTipText("Mudar status");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton12.setText("Gerar relatório");
        jButton12.setToolTipText("Gerar relatório");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/grafico.png"))); // NOI18N
        jButton11.setText("Grafico anual");
        jButton11.setToolTipText("Gerar gráfico de vendas anual");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addComponent(jButton5)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton2))
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistroVendasNovo dialog = new RegistroVendasNovo(new javax.swing.JFrame(), true, usuario);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                if (jDateChooser1.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo data de inicio");
                } else if (jDateChooser2.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo data final");
                } else {
                    carregar.setVisible(true);
                    if (jComboBox1.getSelectedItem().equals("Data da venda")) {
                        lista = dao.buscarDataVenda(jDateChooser1.getDate(), jDateChooser2.getDate(), usuario);
                    } else {
                        lista = dao.buscarDataComissao(jDateChooser1.getDate(), jDateChooser2.getDate(), usuario);
                    }
                    preencherTabela();
                    pesquisa = 1;
                    carregar.dispose();
                }
            }
        };
        t.start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma venda para alterar seu status");
        } else {
            carregar.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    String status = "" + jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 7);
                    dao.AlterarStatus((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), status, usuario);
                    ultimaPesquisa();
                    carregar.dispose();
                }
            };
            t.start();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        carregar.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                lista = dao.buscarPorStatus(usuario);
                preencherTabela();
                pesquisa = 3;
                carregar.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma venda para remover");
        } else {
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir a venda?");
            if (resposta == JOptionPane.YES_OPTION) {
                dao.excluir((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), usuario);
            }
            ultimaPesquisa();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (pesquisa < 1) {
            JOptionPane.showMessageDialog(rootPane, "Realize um pesquisa para poder calcular");
        } else {
            double valor = 0;
            for (Venda v : lista) {
                valor += v.getValorVenda();
            }
            JOptionPane.showMessageDialog(rootPane, "Valor total em vendas realizadas " + util.DecimalFormat(valor));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (pesquisa < 1) {
            JOptionPane.showMessageDialog(rootPane, "Realize um pesquisa para poder calcular");
        } else {
            double valor = 0;
            for (Venda v : lista) {
                valor += v.getValorReceber();
            }
            JOptionPane.showMessageDialog(rootPane, "Valor total em comissões " + util.DecimalFormat(valor));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (pesquisa < 1) {
            JOptionPane.showMessageDialog(rootPane, "Realize um pesquisa para poder calcular");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Total em vendas realizadas: " + jTablePadrao.getRowCount() + " vendas");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma venda para alterar");
        } else {
            RegistroVendasAlterar dialog = new RegistroVendasAlterar(new javax.swing.JFrame(), true, usuario, (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0));
            dialog.setVisible(true);
            ultimaPesquisa();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        carregar.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                String[] tipo = {"Gráfico de lucratividade", "Gráfico bruto", "Gráfico de quantidade"};
                String pagamento = String.valueOf(JOptionPane.showInputDialog(null, "Escolha um tipo de gráfico", "Escolha", JOptionPane.QUESTION_MESSAGE, null, tipo, tipo[0]));
                if (!pagamento.equals("null")) {
                    ArrayList<GraficoVendas> grafico;
                    BarrasVendas b;
                    ArrayList<String> anos = dao.listarAnosLucro(usuario);
                    String[] Data;
                    int tamanho = anos.size();
                    if (tamanho < 1) {
                        JOptionPane.showMessageDialog(rootPane, "Não existem registros");
                    } else {
                        String escolha;
                        switch (pagamento) {
                            case "Gráfico de lucratividade":
                                Data = new String[tamanho];
                                for (int i = 0; i < anos.size(); i++) {
                                    Data[i] = anos.get(i);
                                }
                                escolha = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o ano desejado", "Escolha", JOptionPane.INFORMATION_MESSAGE, null, Data, Data[0]));
                                if (escolha.equals("null")) {
                                    break;
                                } else {
                                    grafico = dao.listarGraficoComissao(escolha, usuario);
                                    b = new BarrasVendas(grafico);
                                    b.setVisible(true);
                                    break;
                                }
                            case "Gráfico bruto":
                                anos = dao.listarAnosVendas(usuario);
                                tamanho = anos.size();
                                Data = new String[tamanho];
                                for (int i = 0; i < anos.size(); i++) {
                                    Data[i] = anos.get(i);
                                }
                                escolha = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o ano desejado", "Escolha", JOptionPane.INFORMATION_MESSAGE, null, Data, Data[0]));
                                if (escolha.equals("null")) {
                                    break;
                                } else {
                                    grafico = dao.listarGraficoApurado(escolha, usuario);
                                    b = new BarrasVendas(grafico);
                                    b.setVisible(true);
                                    break;
                                }
                            case "Gráfico de quantidade":
                                anos = dao.listarAnosVendas(usuario);
                                tamanho = anos.size();
                                Data = new String[tamanho];
                                for (int i = 0; i < anos.size(); i++) {
                                    Data[i] = anos.get(i);
                                }
                                escolha = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o ano desejado", "Escolha", JOptionPane.INFORMATION_MESSAGE, null, Data, Data[0]));
                                if (escolha.equals("null")) {
                                    break;
                                } else {
                                    grafico = dao.listarGraficoQuantidade(escolha, usuario);
                                    b = new BarrasVendas(grafico);
                                    b.setVisible(true);
                                    break;
                                }
                            default:
                                break;
                        }
                    }
                }
                carregar.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                if (pesquisa < 1 || jTablePadrao.getRowCount() < 1) {
                    JOptionPane.showMessageDialog(rootPane, "Realize um pesquisa para gerar um relatório");
                } else {
                    carregar.setVisible(true);
                    ArrayList<RelatorioGeralVendas> rel = new ArrayList<>();
                    for (Venda v : lista) {
                        int PosicaoEncontrada = -1;
                        for (int i = 0; i < rel.size() && PosicaoEncontrada < 0; i++) {
                            if (v.getDescricao().equals(rel.get(i).getServico())) {
                                PosicaoEncontrada = i;
                            }
                        }
                        if (PosicaoEncontrada < 0) {
                            RelatorioGeralVendas rela = new RelatorioGeralVendas();
                            rela.setData(util.ArrrumaData(new Date()));
                            rela.setApurado(v.getValorVenda());
                            rela.setLucro(v.getValorReceber());
                            rela.setServico(v.getDescricao());
                            rela.setQuantidade(1);
                            switch (pesquisa) {
                                case 1:
                                    rela.setInicio(util.ArrrumaData(jDateChooser1.getDate()));
                                    rela.setFim(util.ArrrumaData(jDateChooser2.getDate()));
                                    break;
                                default:
                                    rela.setInicio("00/00/0000");
                                    rela.setFim("00/00/0000");
                                    break;
                            }
                            rel.add(rela);
                        } else {
                            RelatorioGeralVendas itemTemp = rel.get(PosicaoEncontrada);
                            itemTemp.setApurado(itemTemp.getApurado() + v.getValorVenda());
                            itemTemp.setLucro(itemTemp.getLucro() + v.getValorReceber());
                            itemTemp.setQuantidade(itemTemp.getQuantidade() + 1);
                            rel.set(PosicaoEncontrada, itemTemp);
                        }
                    }
                    InputStream fonte = RelatorioGeralVendas.class.getResourceAsStream("relatorioGeralVendas.jrxml");
                    try {
                        JasperReport report = JasperCompileManager.compileReport(fonte);
                        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(rel));
                        JasperViewer.viewReport(print, false);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    carregar.dispose();
                }
            }
        };
        t.start();
    }//GEN-LAST:event_jButton12ActionPerformed

    public void ultimaPesquisa() {
        carregar.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                switch (pesquisa) {
                    case 1:
                        if (jComboBox1.getSelectedItem().equals("Data da venda")) {
                            lista = dao.buscarDataVenda(jDateChooser1.getDate(), jDateChooser2.getDate(), usuario);
                        } else {
                            lista = dao.buscarDataComissao(jDateChooser1.getDate(), jDateChooser2.getDate(), usuario);
                        }
                        preencherTabela();
                        carregar.dispose();
                        break;
                    case 3:
                        lista = dao.buscarPorStatus(usuario);
                        preencherTabela();
                        carregar.dispose();
                        break;
                    case 4:
                        lista = dao.buscarPorStatus(usuario);
                        preencherTabela();
                        carregar.dispose();
                        break;
                    default:
                        carregar.dispose();
                        break;
                }
            }
        };
        t.start();
    }

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Data da venda", "Data a receber", "Fornecedor", "Descrição", "Valor da venda", "Comissão", "Status", "Cliente"};
        for (Venda v : lista) {
            dados.add(new Object[]{v.getCodigo(), util.ArrrumaData(v.getDataVenda()), util.ArrrumaData(v.getDataReceber()), v.getFornecedor().getNome(), v.getDescricao(), util.DecimalFormat(v.getValorVenda()), util.DecimalFormat(v.getValorReceber()), v.getStatus(), v.getCliente()});
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ModeloTabela modelo = new ModeloTabela(dados, colunas);
                jTablePadrao.setModel(modelo);
                jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(95);
                jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(95);
                jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(155);
                jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(155);
                jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(110);
                jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(90);
                jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(7).setPreferredWidth(75);
                jTablePadrao.getColumnModel().getColumn(7).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(8).setPreferredWidth(210);
                jTablePadrao.getColumnModel().getColumn(8).setResizable(false);
                jTablePadrao.getTableHeader().setReorderingAllowed(false);
                jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });
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
            java.util.logging.Logger.getLogger(RegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
