package br.com.agenciaviagens.view;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.model.ModeloTabela;
import br.com.agenciaviagens.util.Carregar;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class CadastroClientes extends javax.swing.JFrame {

    Empresa usuarioLogado;

    Carregar dialog = new Carregar();

    public CadastroClientes(Empresa u) {
        initComponents();
        usuarioLogado = u;
        preencherTabelaVazia();
        jTextFieldPesquisa.requestFocus();
    }

    private CadastroClientes() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonHistorico = new javax.swing.JButton();
        jButtonEmail = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonDethales = new javax.swing.JButton();
        jButtonZap = new javax.swing.JButton();
        jButtonSomar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/gravar.png"))); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setToolTipText("Adicionar novo cliente");
        jButtonAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/alterar.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar cliente");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/remover.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.setToolTipText("Remover cliente");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/historico.png"))); // NOI18N
        jButtonHistorico.setText("Histórico");
        jButtonHistorico.setToolTipText("Ver histórico de compras");
        jButtonHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistoricoActionPerformed(evt);
            }
        });

        jButtonEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/email.png"))); // NOI18N
        jButtonEmail.setText("E-mail");
        jButtonEmail.setToolTipText("Enviar e-mail");
        jButtonEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmailActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

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

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoLocalizar.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setToolTipText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonDethales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/mais.png"))); // NOI18N
        jButtonDethales.setText("Detalhes");
        jButtonDethales.setToolTipText("Ver detalhes do cliente");
        jButtonDethales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDethales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDethalesActionPerformed(evt);
            }
        });

        jButtonZap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/whatssap.png"))); // NOI18N
        jButtonZap.setText("Whatsapp");
        jButtonZap.setToolTipText("Enviar whatsapp");
        jButtonZap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonZap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZapActionPerformed(evt);
            }
        });

        jButtonSomar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButtonSomar.setText("Somar clientes");
        jButtonSomar.setToolTipText("Somar clientes");
        jButtonSomar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Cpf", "Estado", "Cidade" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/proximo_registro.gif"))); // NOI18N
        jButton1.setToolTipText("Proximo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/registro_anterior.gif"))); // NOI18N
        jButton2.setToolTipText("Anterior");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonZap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDethales, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSomar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonHistorico)
                    .addComponent(jButtonEmail)
                    .addComponent(jButtonZap)
                    .addComponent(jButtonDethales)
                    .addComponent(jButtonSomar))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de clientes");

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
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        CadastroClienteNovo novo = new CadastroClienteNovo(new javax.swing.JFrame(), true, usuarioLogado);
        novo.setVisible(true);
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
        if (!jTextFieldPesquisa.getText().isEmpty()) {
            pesquisar();
        }
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButtonDethalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDethalesActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para ter acesso a seus dados");
        } else {
            ClienteDao dao = new ClienteDao();
            Cliente cliente = dao.buscarCodigo((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), usuarioLogado);
            JOptionPane.showMessageDialog(rootPane, "Nome: " + cliente.getNome() + "\n" + "Cpf: " + cliente.getCpf() + "\n" + "RG: " + cliente.getRg() + "\n" + "Email: " + cliente.getEmail() + "\n" + "Telefone: " + cliente.getTelefone() + "\n" + "Estado: " + cliente.getEstado() + "\n" + "Cidade: " + cliente.getCidade() + "\n" + "Bairro: " + cliente.getBairro() + "\n" + "Rua: " + cliente.getRua() + "\n" + "Numero: " + cliente.getNumero());
            pesquisar();
        }

    }//GEN-LAST:event_jButtonDethalesActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para poder altera-lo");
        } else {
            CadastroClienteAlterar alterar = new CadastroClienteAlterar(new javax.swing.JFrame(), true, (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), usuarioLogado);
            alterar.setVisible(true);
            pesquisar();
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para poder remove-lo");
        } else {
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o cliente?");
            if (resposta == JOptionPane.YES_OPTION) {
                ClienteDao dao = new ClienteDao();
                dao.excluir((int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), usuarioLogado);
            }
            pesquisar();
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonZapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para enviar whatssap");
        } else {
            String fone = "" + jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 3);
            char[] t = fone.toCharArray();
            char[] n = new char[13];
            n[0] = '5';
            n[1] = '5';
            n[2] = t[1];
            n[3] = t[2];
            n[4] = t[5];
            n[5] = t[7];
            n[6] = t[8];
            n[7] = t[9];
            n[8] = t[10];
            n[9] = t[12];
            n[10] = t[13];
            n[11] = t[14];
            n[12] = t[15];
            String whats = new String(n);
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("http://api.whatsapp.com/send?1=pt_BR&phone=" + whats));
            } catch (IOException | URISyntaxException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            pesquisar();
        }
    }//GEN-LAST:event_jButtonZapActionPerformed

    private void jButtonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmailActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else {
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < jTablePadrao.getRowCount(); i++) {
                String email = "" + jTablePadrao.getValueAt(i, 4);
                if (!email.equals("Não tem email")) {
                    lista.add(email);
                }
            }
            if (lista.size() < 1) {
                JOptionPane.showMessageDialog(rootPane, "Não existem emails validos");
            } else {
                Email2 email = new Email2(lista, usuarioLogado);
                email.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButtonEmailActionPerformed

    private void jButtonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistoricoActionPerformed
        if (jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona um cliente para ter acesso a seu histórico");
        } else {
            CadastroClienteHistorico historico = new CadastroClienteHistorico(new javax.swing.JFrame(), true, (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0), usuarioLogado);
            historico.setVisible(true);
            pesquisar();
        }
    }//GEN-LAST:event_jButtonHistoricoActionPerformed

    private void jButtonSomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomarActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Existem no momento " + jTablePadrao.getRowCount() + " clientes cadastrados");
        }
    }//GEN-LAST:event_jButtonSomarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else if (jTablePadrao.getSelectedRow() < 0) {
            jTablePadrao.setRowSelectionInterval(0, 0);
        } else if (jTablePadrao.getSelectedRow() + 1 < jTablePadrao.getRowCount()) {
            jTablePadrao.setRowSelectionInterval(0, jTablePadrao.getSelectedRow() + 1);
        } else {
            jTablePadrao.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTablePadrao.getRowCount() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Não existem clientes na lista");
        } else if (jTablePadrao.getSelectedRow() < 0) {
            jTablePadrao.setRowSelectionInterval(0, jTablePadrao.getRowCount() - 1);
        } else if (jTablePadrao.getSelectedRow() > 0) {
            jTablePadrao.setRowSelectionInterval(0, jTablePadrao.getSelectedRow() - 1);
        } else {
            jTablePadrao.setRowSelectionInterval(0, jTablePadrao.getRowCount() - 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pesquisar() {
        dialog.setVisible(true);
        new Thread() {
            @Override
            public void run() {
                if (jComboBox1.getSelectedItem().equals("Nome")) {
                    preencherTabela("select * from cliente where nome ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
                } else if (jComboBox1.getSelectedItem().equals("Cpf")) {
                    preencherTabela("select * from cliente where cpf ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
                } else if (jComboBox1.getSelectedItem().equals("Estado")) {
                    preencherTabela("select * from cliente where cliente_estado ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
                } else if (jComboBox1.getSelectedItem().equals("Cidade")) {
                    preencherTabela("select * from cliente where cliente_cidade ilike'%" + jTextFieldPesquisa.getText() + "%' order by nome");
                }
                dialog.dispose();
            }
        }.start();
    }

    public void preencherTabela(String sql) {
        String[] colunas = new String[]{"ID", "Nome", "Cpf", "Telefone", "Email", "Estado", "Cidade"};
        ArrayList dados = new ArrayList();
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar(usuarioLogado.getCaminho(), usuarioLogado.getBanco(), usuarioLogado.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                dados.add(new Object[]{resultado.getInt("codigo_cliente"), resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("cliente_telefone"), resultado.getString("cliente_email"), resultado.getString("cliente_estado"), resultado.getString("cliente_cidade")});
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
                jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(295);
                jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(118);
                jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(118);
                jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(250);
                jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(120);
                jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
                jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(200);
                jTablePadrao.getColumnModel().getColumn(6).setResizable(false);
                jTablePadrao.getTableHeader().setReorderingAllowed(false);
                jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });
    }

    private void preencherTabelaVazia() {
        String[] colunas = new String[]{"ID", "Nome", "Cpf", "Telefone", "Email", "Estado", "Cidade"};
        ArrayList dados = new ArrayList();
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(295);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(118);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(118);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(6).setResizable(false);       
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
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonDethales;
    private javax.swing.JButton jButtonEmail;
    private javax.swing.JButton jButtonHistorico;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSomar;
    private javax.swing.JButton jButtonZap;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
