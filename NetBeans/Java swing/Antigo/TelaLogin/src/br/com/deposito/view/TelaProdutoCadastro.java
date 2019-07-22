package br.com.deposito.view;

import br.com.deposito.dao.EstoqueDao;
import br.com.deposito.dao.FornecedorDao;
import br.com.deposito.dao.PrecoDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Estoque;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Preco;
import br.com.deposito.domain.Produto;
import br.com.deposito.model.ModeloComboBox;
import br.com.deposito.model.ModeloTabela;
import br.com.deposito.util.Utilitario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaProdutoCadastro extends javax.swing.JDialog {

    private int codigo = 0;
    private Produto product;
    private List<Preco> lista = new ArrayList<>();
    private final PrecoDao precoDao = new PrecoDao();
    private final Utilitario util = new Utilitario();
    private final ProdutoDao dao = new ProdutoDao();
    private final EstoqueDao daoEstoque = new EstoqueDao();

    public TelaProdutoCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherTabela();
        preencherComboBox();
    }

    public TelaProdutoCadastro(java.awt.Frame parent, boolean modal, Produto produto) {
        super(parent, modal);
        initComponents();
        preencherComboBox();
        preencherCampos(produto);
    }

    private void preencherCampos(Produto produto) {        
        jTextFieldNome.setText(produto.getNome());
        jComboBoxEstoqueVazio.getModel().setSelectedItem(produto.getEstoque());
        jComboBoxFornecedor.getModel().setSelectedItem(produto.getFornecedor());
        jComboBoxRetornavel.setSelectedItem(produto.getRetornavel());
        jTextFieldCusto.setText(String.valueOf(produto.getCusto()));       
        jTextFieldEstoqueEmLoja.setText(String.valueOf(produto.getCheio()));       
        codigo = produto.getCodigo();
        jLabel1.setText("Alteração de cadastro");
        lista = precoDao.listarPorCodigo("precos.listar", "codigo", codigo);
        preencherTabela(lista);
        product = produto;
    }

    private void preencherComboBox() {
        FornecedorDao daoFornecedor = new FornecedorDao();
        ModeloComboBox comboFornecedor = new ModeloComboBox();
        comboFornecedor.recebeLista((ArrayList<Object>) (Object) daoFornecedor.listar("fornecedor.listar"));
        jComboBoxFornecedor.setModel(comboFornecedor);
        if (jComboBoxFornecedor.getModel().getSize() > 0) {
            jComboBoxFornecedor.setSelectedIndex(0);
        }
        ModeloComboBox comboEstoque = new ModeloComboBox();
        comboEstoque.recebeLista((ArrayList<Object>) (Object) daoEstoque.listarComWhere("Estoque.listar", "nome", "Padrão"));
        jComboBoxEstoqueVazio.setModel(comboEstoque);
        if (jComboBoxEstoqueVazio.getModel().getSize() > 0) {
            jComboBoxEstoqueVazio.setSelectedIndex(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jComboBoxRetornavel = new javax.swing.JComboBox<>();
        jTextFieldCusto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxEstoqueVazio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEstoqueEmLoja = new javax.swing.JTextField();
        jButtonaddEstoque = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), null));

        jPanel3.setBackground(new java.awt.Color(54, 33, 80));

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/botaoConfirmar.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(85, 65, 118));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/botaoCancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informações do produto"));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel2.setText("Nome");

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel4.setText("Fornecedor");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel5.setText("Retornável");

        jComboBoxFornecedor.setBackground(new java.awt.Color(255, 204, 51));

        jComboBoxRetornavel.setBackground(new java.awt.Color(255, 204, 51));
        jComboBoxRetornavel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        jComboBoxRetornavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRetornavelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel3.setText("Custo");

        jComboBoxEstoqueVazio.setBackground(new java.awt.Color(255, 204, 51));
        jComboBoxEstoqueVazio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstoqueVazioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel7.setText("Estoque retornavel");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel8.setText("Estoque em loja");

        jButtonaddEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/control_panel (2).png"))); // NOI18N
        jButtonaddEstoque.setText("Configurar estoque");
        jButtonaddEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRetornavel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEstoqueEmLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEstoqueVazio, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonaddEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRetornavel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxEstoqueVazio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldEstoqueEmLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonaddEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valores do produto"));

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

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel10.setText("Descrição do preço");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel11.setText("Valor");

        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyPressed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/mais.png"))); // NOI18N
        jButton3.setText("Adiciona preço");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescricao)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextFieldValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jTextFieldValor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de produtos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            Double.parseDouble(jTextFieldCusto.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldCusto.getText())) {
                JOptionPane.showMessageDialog(null, "O campo custo somente pode receber numeros reais ex: 50.31", "Aviso", JOptionPane.WARNING_MESSAGE);
                jTextFieldCusto.setText("");
                jTextFieldCusto.requestFocus();
            }
        }      

        try {
            Integer.parseInt(jTextFieldEstoqueEmLoja.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldEstoqueEmLoja.getText())) {
                JOptionPane.showMessageDialog(null, "O campo estoque em loja somente pode receber numeros inteiros ex: 50", "Aviso", JOptionPane.WARNING_MESSAGE);
                jTextFieldEstoqueEmLoja.setText("");
                jTextFieldEstoqueEmLoja.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBoxFornecedor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Não existem fornecedores cadastrados", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo nome", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldNome.requestFocus();
        } else if (jTextFieldCusto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo custo do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldCusto.requestFocus();        
        } else if (jTextFieldEstoqueEmLoja.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo estoque em loja", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldEstoqueEmLoja.requestFocus();
        } else if (jComboBoxRetornavel.getSelectedItem().equals("Sim") && jComboBoxEstoqueVazio.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um estoque", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (lista.size() < 1) {
            JOptionPane.showMessageDialog(this, "Adicione valores de venda para o produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldDescricao.requestFocus();
        } else {
            Estoque estoque;
            Produto produto = new Produto();
            produto.setCodigo(codigo);
            produto.setNome(jTextFieldNome.getText());
            produto.setFornecedor((Fornecedor) jComboBoxFornecedor.getSelectedItem());
            produto.setRetornavel((String) jComboBoxRetornavel.getSelectedItem());
            produto.setCusto(Double.parseDouble(jTextFieldCusto.getText()));       
            produto.setCheio(Integer.parseInt(jTextFieldEstoqueEmLoja.getText()));
            if (jComboBoxRetornavel.getSelectedItem().equals("Sim")) {
                estoque = (Estoque) jComboBoxEstoqueVazio.getSelectedItem();
            } else {
                EstoqueDao eDao = new EstoqueDao();
                estoque = eDao.buscarCampo("Estoque.listarPorNome", "nome", "Padrão");
                if (estoque == null) {
                    estoque = new Estoque();
                    estoque.setNome("Padrão");
                    estoque.setVazio(0);
                    int c = eDao.salvarSemMensagem(estoque);
                    estoque.setCodigo(c);
                }
            }
            produto.setEstoque(estoque);
            if (codigo == 0) {
                int cd = dao.salvar(produto);
                produto.setCodigo(cd);
                for (Preco p : lista) {
                    p.setProduto(produto);
                    precoDao.salvarSemMensagem(p);
                }
            } else {
                dao.alterar(produto);
            }
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (jTextFieldNome.getText().length() > 59) {
            jTextFieldNome.setText(jTextFieldNome.getText().substring(0, 59));
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
        if (jTextFieldDescricao.getText().length() > 59) {
            jTextFieldDescricao.setText(jTextFieldDescricao.getText().substring(0, 59));
        }
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed

    private void jTextFieldValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyPressed
        if (jTextFieldValor.getText().length() > 8) {
            jTextFieldValor.setText(jTextFieldValor.getText().substring(0, 8));
        }
    }//GEN-LAST:event_jTextFieldValorKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTextFieldDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo descrição", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldDescricao.requestFocus();
        } else if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo valor", "Aviso", JOptionPane.WARNING_MESSAGE);
            jTextFieldValor.requestFocus();
        } else {
            Preco preco = new Preco();
            preco.setDescricao(jTextFieldDescricao.getText());
            preco.setValor(Double.parseDouble(jTextFieldValor.getText()));
            lista.add(preco);
            preencherTabela(lista);
            jTextFieldDescricao.setText("");
            jTextFieldValor.setText("");
            jTextFieldDescricao.requestFocus();
            if (codigo > 0) {
                preco.setProduto(product);
                precoDao.salvarSemMensagem(preco);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31", "Aviso", JOptionPane.WARNING_MESSAGE);
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton3MouseEntered

    private void jTablePadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePadraoMouseClicked
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente remover " + lista.get(jTablePadrao.getSelectedRow()).getDescricao());
        if (resposta == JOptionPane.YES_OPTION) {
            if (codigo > 0) {
                precoDao.excluirSemMensagem(lista.get(jTablePadrao.getSelectedRow()));
            }
            lista.remove(jTablePadrao.getSelectedRow());
        }
        preencherTabela(lista);
        jTextFieldDescricao.requestFocus();
    }//GEN-LAST:event_jTablePadraoMouseClicked

    private void jComboBoxRetornavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRetornavelActionPerformed
        if (jComboBoxRetornavel.getSelectedItem().equals("Não")) {        
            jComboBoxEstoqueVazio.setEnabled(false);
            jButtonaddEstoque.setEnabled(false);
        } else {        
            jComboBoxEstoqueVazio.setEnabled(true);
            jButtonaddEstoque.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxRetornavelActionPerformed

    private void jComboBoxEstoqueVazioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueVazioActionPerformed

    }//GEN-LAST:event_jComboBoxEstoqueVazioActionPerformed

    private void jButtonaddEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddEstoqueActionPerformed
        TelaEstoque dialog = new TelaEstoque(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        ModeloComboBox comboEstoque = new ModeloComboBox();
        comboEstoque.recebeLista((ArrayList<Object>) (Object) daoEstoque.listarComWhere("Estoque.listar", "nome", "Padrão"));
        jComboBoxEstoqueVazio.setModel(comboEstoque);
        if (jComboBoxEstoqueVazio.getModel().getSize() > 0) {
            jComboBoxEstoqueVazio.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButtonaddEstoqueActionPerformed

    private void preencherTabela(List<Preco> ls) {
        String[] colunas = new String[]{"Descrição", "Valor"};
        ArrayList dados = new ArrayList();
        for (Preco c : ls) {
            dados.add(new Object[]{c.getDescricao(), util.decimalFormatComCifrao(c.getValor())});
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void preencherTabela() {
        String[] colunas = new String[]{"Descrição", "Valor"};
        ArrayList dados = new ArrayList();
        dados.add(new Object[]{"Adicione valores", ""});
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
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
            java.util.logging.Logger.getLogger(TelaProdutoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProdutoCadastro dialog = new TelaProdutoCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonaddEstoque;
    private javax.swing.JComboBox<String> jComboBoxEstoqueVazio;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JComboBox<String> jComboBoxRetornavel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldCusto;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEstoqueEmLoja;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

}
