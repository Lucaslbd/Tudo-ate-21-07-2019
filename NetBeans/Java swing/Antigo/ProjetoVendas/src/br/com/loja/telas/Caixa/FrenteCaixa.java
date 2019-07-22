package br.com.loja.telas.Caixa;

import br.com.loja.dao.FormaPagamentoDao;
import br.com.loja.dao.ItemDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.dao.VendaDao;
import br.com.loja.domain.FormaPagamento;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Item;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;
import br.com.loja.tabelas.ModeloTabela;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class FrenteCaixa extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    Funcionario funcionario;
    ArrayList<Item> ListaItem = new ArrayList();
    ArrayList<FormaPagamento> listaPagamento = new ArrayList<>();
    double ValorTotal;
    double valorOriginal;
    String valor;

    public FrenteCaixa(Funcionario f) {
        initComponents();
        jLabel5.setText(f.getNome());
        jTextFieldCodProduto.requestFocus();
        jButtonFinalizar.setMnemonic(KeyEvent.VK_A);
        jButtonEditar.setMnemonic(KeyEvent.VK_B);
        jButtonExcluir.setMnemonic(KeyEvent.VK_C);
        jButtonCancelar.setMnemonic(KeyEvent.VK_D);
        funcionario = f;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldEstoque = new javax.swing.JTextField();
        jTextFieldCategoria = new javax.swing.JTextField();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelRecebido = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabelTroco = new javax.swing.JLabel();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldDescricao.setEnabled(false);

        jTextFieldEstoque.setEnabled(false);

        jTextFieldCategoria.setEnabled(false);

        jTextFieldFornecedor.setEnabled(false);

        jTextFieldValor.setEnabled(false);

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
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePadrao);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelTotal.setBackground(new java.awt.Color(0, 0, 204));
        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTotal.setText("Total R$");

        jLabelValor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelValor.setForeground(new java.awt.Color(51, 0, 204));
        jLabelValor.setText("00,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelValor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nome do operador:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("jLabel5");

        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldQuantidade.setText("1");
        jTextFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyPressed(evt);
            }
        });

        jLabel6.setText("Quantidade");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Recebido R$");

        jLabelRecebido.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelRecebido.setForeground(new java.awt.Color(0, 153, 51));
        jLabelRecebido.setText("00,00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelRecebido))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Troco R$");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelTroco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTroco.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTroco.setText("00,00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelTroco))
                .addGap(23, 23, 23))
        );

        jTextFieldCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProdutoActionPerformed(evt);
            }
        });
        jTextFieldCodProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodProdutoKeyPressed(evt);
            }
        });

        jLabel7.setText("Codigo");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Alterar valor");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Cancelar item");
        jButtonExcluir.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jButtonExcluirCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uploads/livre.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldQuantidade)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFinalizar)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonCancelar))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Frente de caixa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(550, 550, 550))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (ListaItem.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para serem cancelados");
            jTextFieldCodProduto.requestFocus();
        } else {
            String remover = JOptionPane.showInputDialog("Digite o numero do item a remover da lista");
            int Remover;
            try {
                Remover = Integer.parseInt(remover) - 1;
                int tamanhoLista = ListaItem.size();
                if (Remover < 0 || Remover >= tamanhoLista) {
                    JOptionPane.showMessageDialog(rootPane, "Digite um numero valido para remoção do item");
                } else {
                    for (int i = 0; i < ListaItem.size() || i == Remover; i++) {
                        if (i == Remover) {
                            ListaItem.remove(Remover);
                            preencherTabela();
                            JOptionPane.showMessageDialog(rootPane, "Item removido com sucesso");
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Somente são aceitos numeros inteiros");
            }
            jTextFieldCodProduto.setText("");
            jTextFieldQuantidade.setText("1");
            jTextFieldCodProduto.requestFocus();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (ListaItem.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para serem alterados");
            jTextFieldCodProduto.requestFocus();
        } else {
            String alterar = JOptionPane.showInputDialog("Digite o numero do item a alterar");
            int Alterar;
            try {
                Alterar = Integer.parseInt(alterar) - 1;
                int tamanhoLista = ListaItem.size();
                if (Alterar < 0 || Alterar >= tamanhoLista) {
                    JOptionPane.showMessageDialog(rootPane, "Digite um numero valido para alteração do item");
                } else {
                    for (int i = 0; i < ListaItem.size() || i == Alterar; i++) {
                        if (i == Alterar) {
                            Item item = ListaItem.get(i);
                            String valore = JOptionPane.showInputDialog("Digite o valor total do item");
                            double Total = Double.parseDouble(valore);
                            item.setValorTotal(Total);
                            ListaItem.set(i, item);
                            preencherTabela();
                            JOptionPane.showMessageDialog(rootPane, "Item alterado com sucesso");
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Somente são aceitos numeros");
            }
            jTextFieldCodProduto.setText("");
            jTextFieldQuantidade.setText("1");
            jTextFieldCodProduto.requestFocus();
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (ListaItem.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para serem cancelados");
            jTextFieldCodProduto.requestFocus();
        } else {
            int resposta;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente cancelar a venda?");
            if (resposta == JOptionPane.YES_OPTION) {
                ListaItem = new ArrayList<>();
                Limpaimagem();
                preencherTabela();
            }
            jTextFieldCodProduto.setText("");
            jTextFieldQuantidade.setText("1");
            jTextFieldCodProduto.requestFocus();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProdutoActionPerformed

    }//GEN-LAST:event_jTextFieldCodProdutoActionPerformed

    private void jTextFieldCodProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Produto produto;

            ProdutoDao dao = new ProdutoDao();
            produto = dao.buscarCodigo(jTextFieldCodProduto.getText());
            if (produto == null) {
                JOptionPane.showMessageDialog(rootPane, "Produto não cadastrado");
            } else {
                int PosicaoEncontrada = -1;
                for (int i = 0; i < ListaItem.size() && PosicaoEncontrada < 0; i++) {
                    Item comparacao = ListaItem.get(i);
                    if (comparacao.getProduto().getCodigo().equals(produto.getCodigo())) {
                        PosicaoEncontrada = i;
                    }
                }
                Item item = new Item();
                item.setProduto(produto);
                item.setValorUnitario(produto.getValor());
                if (PosicaoEncontrada < 0) {
                    item.setCusto(produto.getValorCusto() * Double.parseDouble(jTextFieldQuantidade.getText()));
                    item.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
                    item.setValorTotal(produto.getValor() * (Integer.parseInt(jTextFieldQuantidade.getText())));
                    ListaItem.add(item);
                } else {
                    Item itemTemp = ListaItem.get(PosicaoEncontrada);
                    item.setCusto(itemTemp.getCusto() + (produto.getValorCusto() * (Integer.parseInt(jTextFieldQuantidade.getText()))));
                    item.setQuantidade(itemTemp.getQuantidade() + (Integer.parseInt(jTextFieldQuantidade.getText())));
                    item.setValorTotal(itemTemp.getValorTotal() + (produto.getValor() * (Integer.parseInt(jTextFieldQuantidade.getText()))));
                    ListaItem.set(PosicaoEncontrada, item);
                }
                jLabel2.setText(produto.getDescricao());
                Inseriimagem();
                preencherTabela();
                jTextFieldCodProduto.setText("");
                jTextFieldQuantidade.setText("1");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            jTextFieldQuantidade.requestFocus();
        }
        jTablePadrao.clearSelection();
        jTablePadrao.changeSelection(jTablePadrao.getRowCount() - 1, 0, false, false);
    }//GEN-LAST:event_jTextFieldCodProdutoKeyPressed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        if (ListaItem.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem itens para finalizar a venda");
            jTextFieldCodProduto.requestFocus();
        } else {
            valorOriginal = ValorTotal;
            boolean continua;
            do {
                continua = Finaliza();
                if (valor == null) {
                    break;
                }
            } while (!continua);

            if (valor == null) {
                ValorTotal = valorOriginal;
                String dx3 = df.format(ValorTotal);
                jLabelValor.setText(dx3);
                jLabelRecebido.setText("00,00");
                jLabelTroco.setText("00,00");
                jLabelTotal.setText("Total R$");
                jTextFieldCodProduto.setText("");
                jTextFieldQuantidade.setText("1");
                jTextFieldCodProduto.requestFocus();
            } else {
                double valore = 0;
                double custo = 0;
                for (Item t : ListaItem) {
                    valore += t.getValorTotal();
                    custo += t.getCusto();
                }
                Venda venda = new Venda();
                venda.setValor(valore);
                venda.setData(new Date());
                venda.setFuncionario(funcionario);
                venda.setLucro(valorOriginal - custo);
                VendaDao dao = new VendaDao();
                ItemDao daoItem = new ItemDao();
                dao.Salvar(venda);
                Venda ultima = dao.Ultimoregistro();
                for (Item t : ListaItem) {
                    t.setVenda(ultima);
                    daoItem.SalvarItem(t);
                }
                FormaPagamentoDao daof = new FormaPagamentoDao();
                for (FormaPagamento p : listaPagamento) {
                    p.setVenda(ultima);
                    daof.SalvarPagamento(p);
                }
                ListaItem = new ArrayList<>();
                Limpaimagem();
                preencherTabela();
                jLabelRecebido.setText("00,00");
                jLabelTroco.setText("00,00");
                jLabelTotal.setText("Total R$");
                jTextFieldCodProduto.setText("");
                jTextFieldQuantidade.setText("1");
                jTextFieldCodProduto.requestFocus();
                listaPagamento = new ArrayList<>();
            }
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jTextFieldQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldCodProduto.requestFocus();
            try {
                Integer.parseInt(jTextFieldQuantidade.getText());
            } catch (NumberFormatException e) {
                if (!"".equals(jTextFieldQuantidade.getText())) {
                    JOptionPane.showMessageDialog(null, "O campo quantidade somente pode receber numeros inteiros ex: 10");
                    jTextFieldQuantidade.setText("1");
                    jTextFieldQuantidade.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_jTextFieldQuantidadeKeyPressed

    private void jButtonExcluirCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jButtonExcluirCaretPositionChanged

    }//GEN-LAST:event_jButtonExcluirCaretPositionChanged
    public boolean Finaliza() {
        String[] pagamentoaceito = {"Dinheiro", "Credito", "Debito", "Crediário"};
        String pagamento = String.valueOf(JOptionPane.showInputDialog(null,
                "Escolha a forma de pagamento", "Escolha", JOptionPane.QUESTION_MESSAGE, null, pagamentoaceito, pagamentoaceito[0]));

        if (pagamento == null || pagamento.equals("null")) {
            JOptionPane.showMessageDialog(rootPane, "Finalização cancelada com sucesso pois pagamento é " + pagamento);
            listaPagamento = new ArrayList<>();
            valor = null;
            return false;
        } else {
            valor = JOptionPane.showInputDialog("Digite o valor recebido pelo cliente");
            if (valor == null) {
                JOptionPane.showMessageDialog(rootPane, "Finalização cancelada com sucesso");
                listaPagamento = new ArrayList<>();
                return false;
            } else {
                try {
                    double Recebido = Double.parseDouble(valor);
                    String dx1 = df.format(Recebido);
                    jLabelRecebido.setText(dx1);
                    double troco = ValorTotal - Recebido;
                    String dx2 = df.format(troco);
                    jLabelTroco.setText(dx2);
                    if (troco <= 0.01) {
                        FormaPagamento pag = new FormaPagamento();
                        pag.setFormaPagamento(pagamento);
                        pag.setValorPagamento(ValorTotal);
                        listaPagamento.add(pag);
                        String dx = df.format(troco);
                        JOptionPane.showMessageDialog(rootPane, "Operação finalizada com sucesso troco para o cliente R$ " + dx);
                        return true;
                    } else {
                        FormaPagamento pag = new FormaPagamento();
                        pag.setFormaPagamento(pagamento);
                        pag.setValorPagamento(Recebido);
                        listaPagamento.add(pag);
                        jLabelRecebido.setText(dx1);
                        jLabelTroco.setText(dx2);
                        ValorTotal = troco;
                        String dx = df.format(troco);
                        JOptionPane.showMessageDialog(rootPane, "Ainda falta pagar R$ " + dx);
                        String dx3 = df.format(troco);
                        jLabelTotal.setText("Restante R$");
                        jLabelValor.setText(dx3);
                        jLabelRecebido.setText("00,00");
                        jLabelTroco.setText("00,00");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Valor invalido");
                    return false;
                }
            }
        }
    }

    public double ArrumaDouble(double d) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(d);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double Final = Double.parseDouble(string2);
        return Final;
    }

    public void Inseriimagem() {
        String caminho = "C:\\Users\\Lucas\\Desktop\\projetos em java\\ProjetoVendas\\src\\uploads\\" + jTextFieldCodProduto.getText() + ".jpg";
        ImageIcon imagem = new ImageIcon(caminho);
        jLabelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_DEFAULT)));
    }

    public void Limpaimagem() {
        ImageIcon imagem = new ImageIcon("C:\\Users\\Lucas\\Desktop\\projetos em java\\ProjetoVendas\\src\\uploads\\livre.jpg");
        jLabelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_DEFAULT)));
        jLabel2.setText("");
    }

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"N°", "Codigo", "Descrição", "Qtd", "Valor unitario", "Valor total"};
        ValorTotal = 0;
        jLabelValor.setText("00,00");
        int i = 0;
        for (Item t : ListaItem) {
            ValorTotal += t.getValorTotal();
            String dx1 = df.format(t.getValorTotal());
            String dx2 = df.format(t.getValorUnitario());
            String dx3 = df.format(ValorTotal);
            jLabelValor.setText(dx3);
            i++;
            dados.add(new Object[]{i, t.getProduto().getCodigo(), t.getProduto().getDescricao(), t.getQuantidade(), dx2, dx1});
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(325);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(105);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(jTablePadrao.AUTO_RESIZE_OFF);
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
            java.util.logging.Logger.getLogger(FrenteCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                //  new FrenteCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelRecebido;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
