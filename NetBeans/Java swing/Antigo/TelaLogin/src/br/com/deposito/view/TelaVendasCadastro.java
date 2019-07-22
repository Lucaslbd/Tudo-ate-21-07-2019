package br.com.deposito.view;

import br.com.deposito.dao.ClienteDao;
import br.com.deposito.dao.ItemDao;
import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.dao.PrecoDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.dao.VendaDao;
import br.com.deposito.domain.Item;
import br.com.deposito.domain.Pagamento;
import br.com.deposito.domain.Preco;
import br.com.deposito.domain.Produto;
import br.com.deposito.domain.Venda;
import br.com.deposito.model.ModeloComboBox;
import br.com.deposito.model.ModeloTabela;
import br.com.deposito.util.Utilitario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaVendasCadastro extends javax.swing.JDialog {
    
    private final List<Item> lista = new ArrayList<>();
    private Produto produto;
    private int corrigir = 0;
    private final Utilitario util = new Utilitario();
    
    public TelaVendasCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherCampos();
        preencherTabela();
    }
    
    private void preencherCampos() {
        ProdutoDao daoProduto = new ProdutoDao();
        ModeloComboBox comboProduto = new ModeloComboBox();
        comboProduto.recebeLista((ArrayList<Object>) (Object) daoProduto.listar("produtos.listar"));
        jComboBoxProduto.setModel(comboProduto);
        if (jComboBoxProduto.getModel().getSize() > 0) {
            jComboBoxProduto.setSelectedIndex(0);
        }
        produto = (Produto) jComboBoxProduto.getSelectedItem();
        PrecoDao daoPreco = new PrecoDao();
        ModeloComboBox comboPreco = new ModeloComboBox();
        comboPreco.recebeLista((ArrayList<Object>) (Object) daoPreco.listarPorCodigo("precos.listar", "codigo", produto.getCodigo()));
        jComboBoxPreco.setModel(comboPreco);
        if (jComboBoxPreco.getModel().getSize() > 0) {
            jComboBoxPreco.setSelectedIndex(0);
        }
        if (produto.getRetornavel().equals("Sim")) {
            jRadioButtonComCasco.setVisible(true);
            jRadioButtonSemCasco.setVisible(true);
            jRadioButtonSemCasco.setSelected(true);
        } else {
            jRadioButtonComCasco.setVisible(false);
            jRadioButtonSemCasco.setVisible(false);
            jRadioButtonSemCasco.setSelected(false);
            jRadioButtonComCasco.setSelected(false);
        }
        PagamentoDao daoPagamento = new PagamentoDao();
        ModeloComboBox comboPagamento = new ModeloComboBox();
        comboPagamento.recebeLista((ArrayList<Object>) (Object) daoPagamento.listar("Pagamentos.listar"));
        jComboBoxPagamento.setModel(comboPagamento);
        if (jComboBoxPagamento.getModel().getSize() > 0) {
            jComboBoxPagamento.setSelectedIndex(0);
        }
        VeiculoDao daoVeiculo = new VeiculoDao();
        ModeloComboBox comboVeiculo = new ModeloComboBox();
        comboVeiculo.recebeLista((ArrayList<Object>) (Object) daoVeiculo.listar("veiculos.listar"));
        jComboBoxVeiculos.setModel(comboVeiculo);
        if (jComboBoxVeiculos.getModel().getSize() > 0) {
            jComboBoxVeiculos.setSelectedIndex(0);
        }
        ClienteDao daoCliente = new ClienteDao();
        ModeloComboBox comboCliente = new ModeloComboBox();
        comboCliente.recebeLista((ArrayList<Object>) (Object) daoCliente.listar("Clientes.listar"));
        jComboBoxCliente.setModel(comboCliente);
        if (jComboBoxCliente.getModel().getSize() > 0) {
            jComboBoxCliente.setSelectedIndex(0);
            //AutoCompleteDecorator.decorate(jComboBoxCliente);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxPreco = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jRadioButtonSemEntrega = new javax.swing.JRadioButton();
        jRadioButtonComEntrega = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxVeiculos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jRadioButtonComCasco = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButtonSemCasco = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(54, 33, 80));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Adicionar produtos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produto");

        jComboBoxProduto.setBackground(new java.awt.Color(255, 255, 0));
        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Valor");

        jComboBoxPreco.setBackground(new java.awt.Color(255, 255, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/shopcartadd (2).png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Finalizar venda");

        jRadioButtonSemEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonSemEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonSemEntrega.setSelected(true);
        jRadioButtonSemEntrega.setText("Sem entrega");
        jRadioButtonSemEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSemEntregaActionPerformed(evt);
            }
        });

        jRadioButtonComEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonComEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonComEntrega.setText("Com entrega");
        jRadioButtonComEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonComEntregaActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Identificar cliente");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Veiculo");

        jComboBoxVeiculos.setBackground(new java.awt.Color(255, 255, 0));
        jComboBoxVeiculos.setEnabled(false);
        jComboBoxVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVeiculosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Forma de pagamento");

        jComboBoxPagamento.setBackground(new java.awt.Color(255, 255, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente");

        jComboBoxCliente.setBackground(new java.awt.Color(255, 255, 0));
        jComboBoxCliente.setEnabled(false);
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/shopcartexclude (2).png"))); // NOI18N
        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jRadioButtonComCasco.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jRadioButtonComCasco.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonComCasco.setText("Com casco");
        jRadioButtonComCasco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonComCascoActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/botaoCancelar.png"))); // NOI18N
        jButton3.setText("Cancelar venda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/botaoConfirmar.png"))); // NOI18N
        jButtonFinalizarVenda.setText("Finalizar venda");
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tela de vendas");

        jRadioButtonSemCasco.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jRadioButtonSemCasco.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonSemCasco.setText("Sem casco");
        jRadioButtonSemCasco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSemCascoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxVeiculos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jButtonFinalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBoxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jRadioButtonSemCasco)
                                                .addGap(10, 10, 10)
                                                .addComponent(jRadioButtonComCasco)
                                                .addGap(12, 12, 12)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonSemEntrega)
                                .addGap(6, 6, 6)
                                .addComponent(jRadioButtonComEntrega)
                                .addGap(6, 6, 6)
                                .addComponent(jRadioButton3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonSemCasco)
                        .addComponent(jRadioButtonComCasco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSemEntrega)
                    .addComponent(jRadioButtonComEntrega)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

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

        jPanel6.setBackground(new java.awt.Color(122, 72, 221));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total R$ 00,00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGap(8, 8, 8))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonComEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonComEntregaActionPerformed
        jRadioButtonSemEntrega.setSelected(false);
        jRadioButtonComEntrega.setSelected(true);
        jComboBoxVeiculos.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonComEntregaActionPerformed

    private void jComboBoxVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVeiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVeiculosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jComboBoxCliente.isEnabled()) {
            jComboBoxCliente.setEnabled(false);
        } else {
            jComboBoxCliente.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed
        if (corrigir == 0) {
            corrigir = 1;
        } else {
            produto = (Produto) jComboBoxProduto.getSelectedItem();
            PrecoDao daoPreco = new PrecoDao();
            ModeloComboBox comboPreco = new ModeloComboBox();
            comboPreco.recebeLista((ArrayList<Object>) (Object) daoPreco.listarPorCodigo("precos.listar", "codigo", produto.getCodigo()));
            jComboBoxPreco.setModel(comboPreco);
            if (jComboBoxPreco.getModel().getSize() > 0) {
                jComboBoxPreco.setSelectedIndex(0);
            }
            if (produto.getRetornavel().equals("Sim")) {
                jRadioButtonComCasco.setVisible(true);
                jRadioButtonSemCasco.setVisible(true);
                jRadioButtonSemCasco.setSelected(true);
                jRadioButtonComCasco.setSelected(false);
            } else {
                jRadioButtonComCasco.setVisible(false);
                jRadioButtonSemCasco.setVisible(false);
                jRadioButtonSemCasco.setSelected(false);
                jRadioButtonComCasco.setSelected(false);
            }
        }
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adiconarItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked

    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para remove-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            lista.remove(jTablePadrao.getSelectedRow());
            preencherTabela(lista);
            double valor = 0;
            for (Item i : lista) {
                valor += i.getValor();
            }
            jLabel7.setText("Total " + util.decimalFormatComCifrao(valor));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButtonSemEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemEntregaActionPerformed
        jRadioButtonSemEntrega.setSelected(true);
        jRadioButtonComEntrega.setSelected(false);
        jComboBoxVeiculos.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonSemEntregaActionPerformed

    private void jRadioButtonComCascoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonComCascoActionPerformed
        jRadioButtonComCasco.setSelected(true);
        jRadioButtonSemCasco.setSelected(false);
    }//GEN-LAST:event_jRadioButtonComCascoActionPerformed

    private void jRadioButtonSemCascoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemCascoActionPerformed
        jRadioButtonComCasco.setSelected(false);
        jRadioButtonSemCasco.setSelected(true);
    }//GEN-LAST:event_jRadioButtonSemCascoActionPerformed

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed
        if (lista == null || lista.size() < 1 || jTablePadrao.getRowCount() < 0) {
            JOptionPane.showMessageDialog(this, "Não é possivel finalizar a venda", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Venda venda = new Venda();
            double custo = 0;
            double valor = 0;
            for (Item i : lista) {
                custo += i.getCusto();
                valor += i.getValor();
            }
            Pagamento pagamento = (Pagamento) jComboBoxPagamento.getSelectedItem();
            venda.setPagamento(pagamento.toString());
            venda.setData(new Date());
            venda.setCusto(custo);
            venda.setValor(valor);
            venda.setItens(lista.size());
            if (jRadioButtonSemEntrega.isSelected()) {
                venda.setEntrega("Não");
            } else {
                venda.setEntrega("Sim");
            }
            if (pagamento.getDesconto() > 0) {
                if (pagamento.getEstrategia().equals("R$")) {
                    venda.setDesconto(pagamento.getDesconto());
                } else {
                    venda.setDesconto(valor * (pagamento.getDesconto() / 100));
                }
            } else {
                venda.setDesconto(0);
            }
            VendaDao vendaDao = new VendaDao();
            ItemDao itemDao = new ItemDao();
            int cdVenda = vendaDao.salvar(venda);
            venda.setCodigo(cdVenda);
            for (Item i : lista) {
                i.setVenda(venda);
                itemDao.salvarSemMensagem(i);
            }
        }
    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed
    
    private void adiconarItem() {
        Preco preco = (Preco) jComboBoxPreco.getSelectedItem();
        Item item = new Item();
        item.setProduto(produto);        
        item.setValor(preco.getValor());
        if (produto.getRetornavel().equals("Não")) {
            item.setCasco("Sem casco");
            item.setCusto(produto.getCusto());
        } else {
            if (jRadioButtonSemCasco.isSelected()) {
                item.setCasco("Sem casco");
                item.setCusto(produto.getCusto());
            } else {
                item.setCasco("Com casco");
                item.setCusto(produto.getCusto() + produto.getEstoque().getCustoCasco());
            }
        }
        lista.add(item);
        preencherTabela(lista);
        double valor = 0;
        for (Item i : lista) {
            valor += i.getValor();
        }
        jLabel7.setText("Total " + util.decimalFormatComCifrao(valor));
    }
    
    private void preencherTabela(List<Item> ls) {
        String[] colunas = new String[]{"Produto", "Fornecedor", "Casco", "Valor"};
        ArrayList dados = new ArrayList();
        if (ls == null || ls.size() < 1) {
            dados.add(new Object[]{"Nenhum registro encontrado", "", "", ""});
        } else {
            for (Item c : ls) {
                dados.add(new Object[]{c.getProduto().getNome(), c.getProduto().getFornecedor().getNome(), c.getCasco(), util.decimalFormatComCifrao(c.getValor())});
            }
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(285);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(285);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(175);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(175);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);      
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void preencherTabela() {
        String[] colunas = new String[]{"Produto", "Fornecedor", "Casco", "Total"};
        ArrayList dados = new ArrayList();
        dados.add(new Object[]{"Adicione itens na lista", "", "", ""});
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(285);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(285);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(175);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(175);
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
            java.util.logging.Logger.getLogger(TelaVendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaVendasCadastro dialog = new TelaVendasCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JComboBox<String> jComboBoxPreco;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JComboBox<String> jComboBoxVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButtonComCasco;
    private javax.swing.JRadioButton jRadioButtonComEntrega;
    private javax.swing.JRadioButton jRadioButtonSemCasco;
    private javax.swing.JRadioButton jRadioButtonSemEntrega;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTablePadrao;
    // End of variables declaration//GEN-END:variables
}
