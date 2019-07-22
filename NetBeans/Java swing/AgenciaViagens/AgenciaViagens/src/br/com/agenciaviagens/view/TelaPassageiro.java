package br.com.agenciaviagens.view;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.dao.PassageiroDao;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.domain.Passageiro;
import br.com.agenciaviagens.model.ModeloTabela;
import br.com.agenciaviagens.relatorio.Contrato;
import br.com.agenciaviagens.relatorio.ListaPassageiro;
import br.com.agenciaviagens.relatorio.RelatorioGeralVendas;
import br.com.agenciaviagens.relatorio.Voucher;
import br.com.agenciaviagens.util.Carregar;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class TelaPassageiro extends javax.swing.JFrame {

    Grupo grupo;
    Empresa empresa;
    UtilitarioDao util = new UtilitarioDao();
    Carregar carregar = new Carregar();
    PassageiroDao daoCliente = new PassageiroDao();

    public TelaPassageiro(Grupo g, Empresa e) {
        initComponents();
        grupo = g;
        empresa = e;
        jLabel1.setText("Tela de passageiros grupo: " + g.getNome_grupo());
        preencherTabelaVazia();
    }

    private TelaPassageiro() {

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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
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
        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/alterar.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/remover.png"))); // NOI18N
        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton4.setText("Lista");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton6.setText("Contrato");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton7.setText("Voucher");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoLocalizar.png"))); // NOI18N
        jButton8.setText("Pesquisar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisa");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton9.setText("Somar pax");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/imprimir.png"))); // NOI18N
        jButton12.setText("Gerar carne");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/localizar.gif"))); // NOI18N
        jButton10.setText("Ver boletos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
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
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9)))
                        .addGap(0, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton4)
                    .addComponent(jButton12)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de passageiros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaPassageiroNovo dialog = new TelaPassageiroNovo(new javax.swing.JFrame(), true, grupo, empresa);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        pesquisar();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para poder remove-lo");
        } else {
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o passageiro?");
            if (resposta == JOptionPane.YES_OPTION) {
                PassageiroDao dao = new PassageiroDao();
                dao.excluir((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), empresa);
            }
            pesquisar();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
        pesquisar();
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para poder altera-lo");
        } else {
            TelaPassageiroAlterar dialog = new TelaPassageiroAlterar(new javax.swing.JFrame(), true, grupo, (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), empresa);
            dialog.setVisible(true);
            pesquisar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                if (jTablePadrao.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para gerar o contrato");
                } else {
                    carregar.setVisible(true);
                    PassageiroDao dao = new PassageiroDao();
                    Passageiro pax = dao.buscarCodigo((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), empresa);
                    Contrato contrato = new Contrato();
                    String acompanhantes = pax.getCliente().getNome();
                    int num = 1;
                    double valor = pax.getValor();
                    for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                        if (pax.getCliente().getNome().equals((String) jTablePadrao.getValueAt(i, 6))) {
                            acompanhantes += ", " + (String) jTablePadrao.getValueAt(i, 1);
                            valor += (double) jTablePadrao.getValueAt(i, 3);
                            num++;
                        }
                    }
                    String ter = " o(a) qual terá";
                    if (num > 1) {
                        ter = "os quais terão";
                    }
                    contrato.setContratado("A empresa " + empresa.getNome()
                            + " portadora do CNPJ: " + empresa.getCnpj() + " estará realizando"
                            + " na data " + util.ArrrumaData(grupo.getData())
                            + " o passeio denominado " + grupo.getNome_grupo()
                            + " com valor de " + util.DecimalFormat(valor)
                            + " referênte ao numero de " + num + " passageiro(s) (" + acompanhantes + ") "
                            + ter + " embarque realizado na seguinte localidade: " + pax.getLocalEmbarque());
                    contrato.setContratente("Eu " + pax.getCliente().getNome()
                            + " portador(a) do CPF: " + pax.getCliente().getCpf()
                            + " e RG: " + pax.getCliente().getRg() + " me declaro titular da reserva e confirmo a compra do serviço acima citado estando ciente de todas as cláusulas contidas neste contrato.");
                    contrato.setAtividades(grupo.getAtividades());
                    ArrayList<Contrato> lista = new ArrayList<>();
                    lista.add(contrato);
                    InputStream fonte = RelatorioGeralVendas.class.getResourceAsStream("Contrato.jrxml");
                    try {
                        JasperReport report = JasperCompileManager.compileReport(fonte);
                        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                        JasperViewer.viewReport(print, false);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    carregar.dispose();
                    pesquisar();
                }
            }
        };
        t.start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                if (jTablePadrao.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para poder imprimir o voucher");
                } else {
                    carregar.setVisible(true);
                    String pax = (String) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 1);
                    String acompanhantes = "";
                    int num = 0;
                    for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                        if (pax.equals((String) jTablePadrao.getValueAt(i, 6))) {
                            acompanhantes += (String) jTablePadrao.getValueAt(i, 1) + ", ";
                            num++;
                        }
                    }
                    Voucher voucher = new Voucher();
                    voucher.setCnpj("CNPJ: " + empresa.getCnpj());
                    voucher.setData(util.ArrrumaData(grupo.getData()));
                    voucher.setEmpresa(empresa.getNome());
                    voucher.setPasseio(grupo.getNome_grupo());
                    voucher.setPassageiro(pax);
                    voucher.setTelefone(empresa.getTelefone());
                    voucher.setAtividades(grupo.getAtividades());                   
                    switch (num) {
                        case 0:
                            voucher.setTexto("Este documento permite ao passageiro titular acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                            break;
                        case 1:
                            voucher.setTexto("Este documento permite ao passageiro titular e seu dependente " + acompanhantes + " acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                            break;
                        default:
                            voucher.setTexto("Este documento permite ao passageiro titular e seus dependentes " + acompanhantes + " acesso a viagem permitindo assim acesso a todas as atividades declaradas em contrato.");
                            break;
                    }
                    ArrayList<Voucher> lista = new ArrayList<>();
                    lista.add(voucher);
                    InputStream fonte = RelatorioGeralVendas.class.getResourceAsStream("Voucher.jrxml");
                    try {
                        JasperReport report = JasperCompileManager.compileReport(fonte);
                        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                        JasperViewer.viewReport(print, false);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    carregar.dispose();
                    pesquisar();
                }
            }
        };
        t.start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Estão confirmados: " + jTablePadrao.getRowCount() + " passageiros");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else {
            Thread t = new Thread() {
                @Override
                public void run() {
                    carregar.setVisible(true);
                    ArrayList<ListaPassageiro> listaPax = new ArrayList<>();
                    for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                        Passageiro passageiro = daoCliente.buscarCodigo((int) jTablePadrao.getValueAt(i, 0), empresa);
                        ListaPassageiro pax = new ListaPassageiro();
                        pax.setEmbarque(passageiro.getLocalEmbarque());
                        pax.setNomePax(passageiro.getCliente().getNome());
                        pax.setRg(passageiro.getCliente().getRg());
                        pax.setTelefone(passageiro.getCliente().getTelefone());
                        pax.setNomeGrupo(grupo.getNome_grupo());
                        pax.setData("Data da viagem: " + util.ArrrumaData(grupo.getData()));
                        pax.setNum(i + 1);
                        listaPax.add(pax);
                    }
                    InputStream fonte = RelatorioGeralVendas.class.getResourceAsStream("listaPassageiro.jrxml");
                    try {
                        JasperReport report = JasperCompileManager.compileReport(fonte);
                        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaPax));
                        JasperViewer.viewReport(print, false);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    carregar.dispose();
                }
            };
            t.start();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para ver seus boletos");
        } else {
            String pagamento = (String) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 4);
            if (!pagamento.equals("Boleto")) {
                JOptionPane.showMessageDialog(rootPane, "Esse passageiro não escolheu boleto como forma de pagamento");
            } else {
                PassageiroDao dao = new PassageiroDao();
                Passageiro pax = dao.buscarCodigo((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), empresa);
                double valor = pax.getValor();
                for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                    if (pax.getCliente().getNome().equals((String) jTablePadrao.getValueAt(i, 6))) {
                        valor += (double) jTablePadrao.getValueAt(i, 3);
                    }
                }
                NovoBoleto tela = new NovoBoleto(new javax.swing.JFrame(), true, pax, empresa, valor);
                tela.setVisible(true);
            }
            pesquisar();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um passageiro para ver seus boletos");
        } else {
            String pagamento = (String) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 4);
            if (!pagamento.equals("Boleto")) {
                JOptionPane.showMessageDialog(rootPane, "Esse passageiro não escolheu boleto como forma de pagamento");
            } else {
                BoletoCliente dialog = new BoletoCliente(new javax.swing.JFrame(), true, (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), empresa);
                dialog.setVisible(true);
            }
            pesquisar();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void pesquisar() {
        carregar.setVisible(true);
        new Thread() {
            @Override
            public void run() {
                preencherTabela("select * from passageiro inner join grupo on grupo = codigo_grupo inner join cliente on cliente = codigo_cliente where grupo = " + grupo.getCodigo() + " and nome ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
                carregar.dispose();
            }
        }.start();
    }

    public void preencherTabela(String sql) {
        String[] colunas = new String[]{"ID", "Nome", "Telefone", "Valor cobrado", "Forma de pagamento", "Parcelas", "Titular", "Embarque", "Status"};
        ArrayList dados = new ArrayList();
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getInt("codigo_passageiro"), resultado.getString("nome"), resultado.getString("cliente_telefone"), resultado.getDouble("valor_total"), resultado.getString("forma_pagamento"), resultado.getInt("total_parcelas"), resultado.getString("titular"), resultado.getString("local_embarque"), resultado.getString("status")});
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Passsageiro não encontrado" + ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ModeloTabela modelo = new ModeloTabela(dados, colunas);
                jTablePadrao.setModel(modelo);
                jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(250);
                jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(115);
                jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(100);
                jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(150);
                jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(100);
                jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(250);
                jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(7).setPreferredWidth(150);
                jTablePadrao.getColumnModel().getColumn(7).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(8).setPreferredWidth(80);
                jTablePadrao.getColumnModel().getColumn(8).setResizable(false);
                jTablePadrao.getTableHeader().setReorderingAllowed(false);
                jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });
    }

    private void preencherTabelaVazia() {
        String[] colunas = new String[]{"ID", "Nome", "Telefone", "Valor cobrado", "Forma de pagamento", "Parcelas", "Titular", "Embarque", "Status"};
        ArrayList dados = new ArrayList();
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(115);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(7).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(7).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTablePadrao.getColumnModel().getColumn(8).setResizable(false);
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
            java.util.logging.Logger.getLogger(TelaPassageiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPassageiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPassageiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPassageiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPassageiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
