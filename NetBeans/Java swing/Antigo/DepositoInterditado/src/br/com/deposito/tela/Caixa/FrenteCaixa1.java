package br.com.deposito.tela.Caixa;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.dao.AutonomiaDao;
import br.com.deposito.dao.ClienteDao;
import br.com.deposito.dao.ItemDao;
import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.dao.VendaDao;
import br.com.deposito.domain.Autonomia;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.Crediario;
import br.com.deposito.domain.FormaPagamento;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.HistoricoCliente;
import br.com.deposito.domain.Item;
import br.com.deposito.domain.PagamentoCartao;
import br.com.deposito.domain.Produto;
import br.com.deposito.domain.Usuario;
import br.com.deposito.domain.Veiculos;
import br.com.deposito.domain.Venda;
import br.com.deposito.tela.cadastros.TelaClienteNovo;
import br.com.deposito.util.ModeloTabela;
import br.com.deposito.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class FrenteCaixa1 extends javax.swing.JFrame {

    Usuario usuario;
    ArrayList<Item> listaItem = new ArrayList<>();
    ArrayList<FormaPagamento> listaPagamento = new ArrayList<>();
    ArrayList<Produto> listaProduto = new ArrayList<>();
    ArrayList<Veiculos> listaVeiculo = new ArrayList<>();
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    ArrayList<Cliente> listaClienteFiltrado = new ArrayList<>();
    UtilitarioDao util = new UtilitarioDao();
    DefaultListModel Modelo;
    int selecionado = -1;
    boolean crediario = false;

    public FrenteCaixa1(Usuario f) {
        initComponents();
        usuario = f;
        Modelo = new DefaultListModel();
        jList1.setModel(Modelo);
        jList1.setVisible(false);
        PreencherProduto();
        PreencherFormaPagamento();
        PreencherVeiculos();
        PreencherCliente();
        jRadioButtonSemEntrega.setSelected(true);
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
        jLabelValor = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jPanelLista = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonComEntrega = new javax.swing.JRadioButton();
        jRadioButtonSemEntrega = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxVeiculo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jTablePadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePadraoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePadrao);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelValor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelValor.setForeground(new java.awt.Color(0, 0, 255));
        jLabelValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValor.setText("Total R$ 00,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelValor, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonEditar.setText("Alterar valor");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Cancelar item");
        jButtonExcluir.setEnabled(false);
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

        jPanelLista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Produto");

        jLabel10.setText("Quantidade");

        jTextFieldQuantidade.setText("1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem casco", "Com casco" }));

        jLabel11.setText("Casco");

        javax.swing.GroupLayout jPanelListaLayout = new javax.swing.GroupLayout(jPanelLista);
        jPanelLista.setLayout(jPanelListaLayout);
        jPanelListaLayout.setHorizontalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelListaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 179, Short.MAX_VALUE)
                            .addComponent(jTextFieldQuantidade))))
                .addGap(13, 13, 13))
        );
        jPanelListaLayout.setVerticalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton1.setText("Add item");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Entrega:");

        jRadioButtonComEntrega.setText("Sim");
        jRadioButtonComEntrega.setEnabled(false);
        jRadioButtonComEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonComEntregaActionPerformed(evt);
            }
        });

        jRadioButtonSemEntrega.setText("Não");
        jRadioButtonSemEntrega.setEnabled(false);
        jRadioButtonSemEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSemEntregaActionPerformed(evt);
            }
        });

        jLabel7.setText("Veiculo");

        jComboBoxVeiculo.setEnabled(false);

        jLabel9.setText("Pagamento");

        jComboBoxPagamento.setEnabled(false);
        jComboBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagamentoActionPerformed(evt);
            }
        });

        jLabel12.setText("Cliente");

        jButtonFinalizar.setText("Finalizar venda");
        jButtonFinalizar.setEnabled(false);
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar venda");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jComboBoxCliente.setEnabled(false);
        jComboBoxCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxClienteMouseClicked(evt);
            }
        });

        jTextFieldPesquisa.setEnabled(false);
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jScrollPane2.setBorder(null);

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jDateChooser1.setEnabled(false);

        jButton3.setText("Add cliente");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPesquisa)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonComEntrega)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonSemEntrega))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButtonComEntrega)
                    .addComponent(jRadioButtonSemEntrega)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        jButton2.setText("Finalizar lista");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jPanelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Frente de caixa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (selecionado > - 1) {
            for (int i = 0; i < listaItem.size() || i == selecionado - 1; i++) {
                if (i == selecionado - 1) {
                    listaItem.remove(selecionado - 1);
                    preencherTabela();
                    jButtonExcluir.setEnabled(false);
                    jButtonEditar.setEnabled(false);
                    break;
                }
            }
            preencherTabela();
            selecionado = -1;
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (selecionado > - 1) {
            try {
                for (int i = 0; i < listaItem.size() || i == selecionado - 1; i++) {
                    if (i == selecionado - 1) {
                        Item item = listaItem.get(i);
                        String valore = JOptionPane.showInputDialog("Digite o valor total do item");
                        if (valore == null || valore.equals("null")) {
                            preencherTabela();
                            jButtonExcluir.setEnabled(false);
                            jButtonEditar.setEnabled(false);
                        } else {
                            double Total = Double.parseDouble(valore);
                            item.setValor(Total);
                            listaItem.set(i, item);
                            preencherTabela();
                            jButtonExcluir.setEnabled(false);
                            jButtonEditar.setEnabled(false);
                            break;
                        }
                    }
                }
                selecionado = -1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Somente são aceitos numeros");
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        iniciar();
        listaItem = new ArrayList<>();
        preencherTabela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        if (jComboBoxPagamento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem formas de pagamento disponiveis");
        } else if (jComboBoxPagamento.getSelectedItem().equals("Crediário") && jComboBoxCliente.getSelectedItem().equals("Escolha um cliente")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um cliente para pode finalizar a venda");
        } else if (jComboBoxPagamento.getSelectedItem().equals("Crediário") && jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha a data de pagamento do crediário para pode finalizar a venda");
        } else if (jRadioButtonComEntrega.isSelected() && jComboBoxVeiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existema veiculos de entrega cadastrados");
        } else {
            double custo = 0;
            double valor = 0;
            for (Item i : listaItem) {
                custo += i.getCusto();
                valor += i.getValor();
            }
            VendaDao vendaDao = new VendaDao();
            int index1 = jComboBoxPagamento.getSelectedIndex();
            int index2 = jComboBoxVeiculo.getSelectedIndex();
            Venda venda = new Venda();
            venda.setData(new Date());
            venda.setFormaPagamento((String) jComboBoxPagamento.getSelectedItem());
            venda.setDeposito(usuario.getDeposito());
            venda.setCusto(custo);
            venda.setValor(valor);
            venda.setDesconto(listaPagamento.get(index1).getDesconto());
            if (jRadioButtonSemEntrega.isSelected()) {
                venda.setEntrega("Sem entrega");
            } else {
                venda.setEntrega("Com entrega");
                AutonomiaDao autoDao = new AutonomiaDao();
                Autonomia autonomia = autoDao.Ultimoregistro(listaVeiculo.get(index2).getCodigo());
                if (autonomia == null) {

                } else {
                    autonomia.setEntregas(autonomia.getEntregas() + 1);
                    autoDao.fazerAutonomia(autonomia);
                }
            }
            vendaDao.Salvar(venda);
            Venda ultimaVenda = vendaDao.Ultimoregistro(usuario.getDeposito().getCodigo());
            PagamentoDao dao = new PagamentoDao();
            ItemDao itemDao = new ItemDao();
            for (Item i : listaItem) {
                i.setVenda(ultimaVenda);
                itemDao.Salvar(i);
            }
            if (jComboBoxPagamento.getSelectedItem().equals("Cartão de débito") || jComboBoxPagamento.getSelectedItem().equals("Cartão de crédito")) {
                PagamentoCartao cartao = new PagamentoCartao();
                cartao.setDescricao((String) jComboBoxPagamento.getSelectedItem());
                cartao.setSituacao("A receber");
                cartao.setVenda(ultimaVenda);
                dao.SalvarPagamentoCartao(cartao);
            } else if (jComboBoxPagamento.getSelectedItem().equals("Crediário")) {
                Crediario credi = new Crediario();
                credi.setSituacao("A receber");
                credi.setCliente(listaCliente.get(jComboBoxCliente.getSelectedIndex() - 1));
                credi.setVenda(ultimaVenda);
                credi.setData(jDateChooser1.getDate());
                dao.SalvarCrediario(credi);
            }
            if (!jComboBoxCliente.getSelectedItem().equals("Escolha um cliente")) {
                ClienteDao hist = new ClienteDao();
                HistoricoCliente historico = new HistoricoCliente();
                historico.setCliente(listaCliente.get(jComboBoxCliente.getSelectedIndex() - 1));
                historico.setVenda(ultimaVenda);
                hist.SalvarHistorico(historico);
            }
            listaItem = new ArrayList<>();
            preencherTabela();
            iniciar();
            JOptionPane.showMessageDialog(rootPane, "Venda finalizada com sucesso");
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonExcluirCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jButtonExcluirCaretPositionChanged

    }//GEN-LAST:event_jButtonExcluirCaretPositionChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (listaProduto.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não existem produtos cadastrados");
        } else {
            if (jTextFieldQuantidade.getText().isEmpty()) {
                jTextFieldQuantidade.setText("1");
            }
            int i = jComboBoxProduto.getSelectedIndex();
            Produto produto = listaProduto.get(i);
            int estoque = 0;
            for (Item l : listaItem) {
                if (produto.equals(l.getProduto())) {
                    estoque += l.getQuantdade();
                }
            }
            if (produto.getEstoqueCheio() - estoque - Integer.parseInt(jTextFieldQuantidade.getText()) < 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existe mais estoque do produto");
            } else {
                Item item = new Item();
                item.setCasco((String) jComboBox1.getSelectedItem());
                item.setProduto(produto);
                item.setQuantdade(Integer.parseInt(jTextFieldQuantidade.getText()));
                if (jComboBox1.getSelectedItem().equals("Sem casco")) {
                    item.setValor(produto.getValorPortaria() * Integer.parseInt(jTextFieldQuantidade.getText()));
                    item.setCusto(produto.getCustoProduto() * Integer.parseInt(jTextFieldQuantidade.getText()));
                } else {
                    item.setValor((produto.getValorPortaria() + produto.getValorCasco()) * Integer.parseInt(jTextFieldQuantidade.getText()));
                    item.setCusto((produto.getCustoProduto() + produto.getCustoCasco()) * Integer.parseInt(jTextFieldQuantidade.getText()));
                }
                listaItem.add(item);
                preencherTabela();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonComEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonComEntregaActionPerformed
        if (jComboBoxVeiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existem veiculos cadastrados");
            jRadioButtonComEntrega.setSelected(false);
            jRadioButtonSemEntrega.setSelected(true);
        } else {
            jRadioButtonComEntrega.setSelected(true);
            jRadioButtonSemEntrega.setSelected(false);
            jRadioButtonComEntrega.setEnabled(false);
            jRadioButtonSemEntrega.setEnabled(true);
            jComboBoxVeiculo.setEnabled(true);
            for (int i = 0; i < listaItem.size(); i++) {
                Item item = listaItem.get(i);
                item.setValor(item.getValor() + item.getProduto().getValorEntrega());
                listaItem.set(i, item);
            }
            preencherTabela();
        }
    }//GEN-LAST:event_jRadioButtonComEntregaActionPerformed

    private void jRadioButtonSemEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemEntregaActionPerformed
        jRadioButtonComEntrega.setSelected(false);
        jRadioButtonSemEntrega.setSelected(true);
        jRadioButtonComEntrega.setEnabled(true);
        jRadioButtonSemEntrega.setEnabled(false);
        jComboBoxVeiculo.setEnabled(false);
        for (int i = 0; i < listaItem.size(); i++) {
            Item item = listaItem.get(i);
            item.setValor(item.getValor() - item.getProduto().getValorEntrega());
            listaItem.set(i, item);
        }
        preencherTabela();
    }//GEN-LAST:event_jRadioButtonSemEntregaActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            int i = Integer.parseInt(jTextFieldQuantidade.getText());
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "O campo quantidade não pode ter valores menores que 1");
                jTextFieldQuantidade.setText("1");
                jTextFieldQuantidade.requestFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo quantidade somente pode receber numeros inteiros ex: 50");
            jTextFieldQuantidade.setText("1");
            jTextFieldQuantidade.requestFocus();
        }

    }//GEN-LAST:event_jButton1MouseEntered

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        selecionado = (int) jTablePadrao.getValueAt(jTablePadrao.getSelectedRow(), 0);
        jButtonExcluir.setEnabled(true);
        jButtonEditar.setEnabled(true);
    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
        preencherLista();
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    private void jComboBoxClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxClienteMouseClicked

    }//GEN-LAST:event_jComboBoxClienteMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jComboBoxCliente.setSelectedItem(jList1.getSelectedValue());
        jList1.setVisible(false);
        jTextFieldPesquisa.setText("");
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        liberaFinalizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagamentoActionPerformed
        if (jRadioButtonComEntrega.isSelected()) {
            for (int i = 0; i < listaItem.size(); i++) {
                Item item = listaItem.get(i);
                if (item.getCasco().equals("Com casco")) {
                    item.setValor(item.getProduto().getValorPortaria() + item.getProduto().getValorCasco() + item.getProduto().getValorEntrega() + listaPagamento.get(jComboBoxPagamento.getSelectedIndex()).getAcrescimo());
                    listaItem.set(i, item);
                } else {
                    item.setValor(item.getProduto().getValorPortaria() + item.getProduto().getValorEntrega() + listaPagamento.get(jComboBoxPagamento.getSelectedIndex()).getAcrescimo());
                    listaItem.set(i, item);
                }
            }
            preencherTabela();
        } else {
            for (int i = 0; i < listaItem.size(); i++) {
                Item item = listaItem.get(i);
                if (item.getCasco().equals("Com casco")) {
                    item.setValor(item.getProduto().getValorPortaria() + item.getProduto().getValorCasco() + listaPagamento.get(jComboBoxPagamento.getSelectedIndex()).getAcrescimo());
                    listaItem.set(i, item);
                } else {
                    item.setValor(item.getProduto().getValorPortaria() + listaPagamento.get(jComboBoxPagamento.getSelectedIndex()).getAcrescimo());
                    listaItem.set(i, item);
                }
            }
            preencherTabela();
        }
        if (jComboBoxPagamento.getSelectedItem().equals("Crediário")) {
            jDateChooser1.setEnabled(true);
        } else {
            jDateChooser1.setDate(null);
            jDateChooser1.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxPagamentoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TelaClienteNovo dialog = new TelaClienteNovo(new javax.swing.JFrame(), true, usuario.getDeposito());
        dialog.setVisible(true);
        PreencherCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void liberaFinalizar() {
        jComboBoxProduto.setEnabled(false);
        jTextFieldQuantidade.setEnabled(false);
        jComboBox1.setEnabled(false);
        jButton1.setEnabled(false);
        jRadioButtonComEntrega.setEnabled(true);
        jComboBoxPagamento.setEnabled(true);
        jComboBoxCliente.setEnabled(true);
        jTextFieldPesquisa.setEnabled(true);       
        jButtonFinalizar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButton3.setEnabled(true);
    }

    private void iniciar() {
        jComboBoxProduto.setEnabled(true);
        jTextFieldQuantidade.setEnabled(true);
        jComboBox1.setEnabled(true);
        jButton1.setEnabled(true);
        jRadioButtonComEntrega.setEnabled(false);
        jRadioButtonSemEntrega.setEnabled(false);
        jComboBoxPagamento.setEnabled(false);
        jComboBoxCliente.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jButtonFinalizar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jComboBoxVeiculo.setEnabled(false);
        jTextFieldPesquisa.setText("");
        jComboBoxCliente.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        jDateChooser1.setEnabled(false);
        jRadioButtonComEntrega.setSelected(false);
        jRadioButtonSemEntrega.setSelected(true);
        jComboBoxPagamento.setSelectedIndex(0);
        jButton3.setEnabled(false);
    }

    private void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"N°", "Produto", "Casco", "Quantidade", "Valor"};
        int i = 1;
        double valor = 0;
        for (Item g : listaItem) {
            dados.add(new Object[]{i, g.getProduto().getNome(), g.getCasco(), g.getQuantdade(), util.DecimalFormat(g.getValor())});
            i++;
            valor += g.getValor();
        }
        if (valor > 0) {
            jButton2.setEnabled(true);
        } else {
            jButton2.setEnabled(false);
        }
        jLabelValor.setText("Total " + util.DecimalFormat(valor));
        jTextFieldQuantidade.setText("1");
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(115);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void preencherLista() {
        if (jTextFieldPesquisa.getText().isEmpty()) {
            jList1.removeAll();
            Modelo.removeAllElements();
            jList1.setVisible(false);
        } else {
            jList1.setVisible(true);
            StringBuilder sql = new StringBuilder();
            sql.append("select * from cliente inner join empresa on empresa = codigo_empresa where empresa = ").append(usuario.getDeposito().getCodigo()).append(" and nome ilike'%").append(jTextFieldPesquisa.getText()).append("%' order by nome");
            try {
                Connection conexao;
                conexao = ConexaoBD.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql.toString());
                ResultSet resultado = comando.executeQuery();
                jList1.removeAll();
                Modelo.removeAllElements();
                listaClienteFiltrado = new ArrayList<>();
                while (resultado.next()) {
                    Cliente c = new Cliente();
                    Modelo.addElement(resultado.getString("nome"));
                    c.setCodigo(resultado.getInt("codigo_cliente"));
                    c.setNome(resultado.getString("nome"));
                    c.setCpf(resultado.getString("cpf"));
                    c.setRg(resultado.getString("rg"));
                    c.setCidade(resultado.getString("cliente_cidade"));
                    c.setBairro(resultado.getString("cliente_bairro"));
                    c.setRua(resultado.getString("cliente_rua"));
                    c.setNumero(resultado.getString("cliente_numero"));
                    c.setEmail(resultado.getString("cliente_email"));
                    c.setTelefone(resultado.getString("cliente_telefone"));
                    c.setDeposito(usuario.getDeposito());
                    listaClienteFiltrado.add(c);
                }
                conexao.close();
                int i = jList1.getModel().getSize();
                if (i == 0) {
                    jList1.setVisible(false);
                } else {
                    jList1.setVisible(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }

    private void PreencherProduto() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor ");
        sql.append("where codigo_empresa=?");
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, usuario.getDeposito().getCodigo());
            ResultSet resultado = comando.executeQuery();
            jComboBoxProduto.removeAllItems();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(usuario.getDeposito());
                Produto produto = new Produto();
                produto.setCodigo(resultado.getInt("codigo_produto"));
                produto.setNome(resultado.getString("nome_produto"));
                produto.setValorPortaria(resultado.getDouble("valor_portaria"));
                produto.setValorCasco(resultado.getDouble("valor_casco"));
                produto.setCustoProduto(resultado.getDouble("custo_produto"));
                produto.setCustoCasco(resultado.getDouble("custo_casco"));
                produto.setEstoqueCheio(resultado.getInt("estoque_cheio"));
                produto.setEstoqueVazio(resultado.getInt("estoque_vazio"));
                produto.setValorEntrega(resultado.getDouble("valor_entrega"));
                produto.setFornecedor(fornecedor);
                listaProduto.add(produto);
                jComboBoxProduto.addItem(resultado.getString("nome_produto"));
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void PreencherFormaPagamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from forma_pagamento inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_empresa=? order by posicao");
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, usuario.getDeposito().getCodigo());
            ResultSet resultado = comando.executeQuery();
            jComboBoxPagamento.removeAllItems();
            while (resultado.next()) {
                FormaPagamento forma = new FormaPagamento();
                forma.setCodigo(resultado.getInt("codigo_forma"));
                forma.setTipo(resultado.getString("tipo"));
                forma.setDesconto(resultado.getDouble("desconto"));
                forma.setAcrescimo(resultado.getDouble("acrescimo"));
                forma.setDeposito(usuario.getDeposito());
                listaPagamento.add(forma);
                jComboBoxPagamento.addItem(resultado.getString("tipo"));
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void PreencherCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_empresa=? order by nome");
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, usuario.getDeposito().getCodigo());
            ResultSet resultado = comando.executeQuery();
            listaCliente = new ArrayList<>();
            jComboBoxCliente.removeAllItems();
            jComboBoxCliente.addItem("Escolha um cliente");
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setCodigo(resultado.getInt("codigo_cliente"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setRg(resultado.getString("rg"));
                c.setCidade(resultado.getString("cliente_cidade"));
                c.setBairro(resultado.getString("cliente_bairro"));
                c.setRua(resultado.getString("cliente_rua"));
                c.setNumero(resultado.getString("cliente_numero"));
                c.setEmail(resultado.getString("cliente_email"));
                c.setTelefone(resultado.getString("cliente_telefone"));
                c.setDeposito(usuario.getDeposito());
                listaCliente.add(c);
                jComboBoxCliente.addItem(resultado.getString("nome"));
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void PreencherVeiculos() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from veiculo inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_empresa=?");
        try {
            Connection conexao;
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, usuario.getDeposito().getCodigo());
            ResultSet resultado = comando.executeQuery();
            jComboBoxVeiculo.removeAllItems();
            while (resultado.next()) {
                Veiculos veiculo = new Veiculos();
                veiculo.setCodigo(resultado.getInt("codigo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setDeposito(usuario.getDeposito());
                listaVeiculo.add(veiculo);
                jComboBoxVeiculo.addItem(resultado.getString("placa"));
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
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
            java.util.logging.Logger.getLogger(FrenteCaixa1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa1.class
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JComboBox<String> jComboBoxVeiculo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JRadioButton jRadioButtonComEntrega;
    private javax.swing.JRadioButton jRadioButtonSemEntrega;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
