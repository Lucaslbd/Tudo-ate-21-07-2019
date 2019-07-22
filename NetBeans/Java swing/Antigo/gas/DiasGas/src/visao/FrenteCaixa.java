package visao;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAutonomia;
import modeloBeans.BeansCartoes;
import modeloBeans.BeansFrenteCaixa;
import modeloBeans.BeansProdutos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoAutonomia;
import modeloDao.DaoCartoes;
import modeloDao.DaoFrenteCaixa;
import modeloDao.DaoProdutos;

public class FrenteCaixa extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansFrenteCaixa mod = new BeansFrenteCaixa();
    BeansProdutos prod = new BeansProdutos();
    BeansCartoes cart = new BeansCartoes();
    DaoFrenteCaixa control = new DaoFrenteCaixa();
    DaoProdutos controlProdutos = new DaoProdutos();
    DaoCartoes controlcart = new DaoCartoes();

    DecimalFormat df = new DecimalFormat("0.00");
    DaoAutonomia controlauto = new DaoAutonomia();
    BeansAutonomia auto = new BeansAutonomia();
    int resposta = 0;

    public FrenteCaixa() {
        initComponents();
        preencherTabela("select * from caixa1 order by cod_venda");

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jTextFieldData.setText(dtHoje);

        double count = 0;
        for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
            String dx = df.format(count);
            jLabelTotal.setText(String.valueOf(dx));
        }

    }

    public void PreencherProdutos() {
        conex.Conexao();
        conex.executaSql("select * from produtos order by nome_produto");
        try {
            conex.rs.first();
            jComboBoxProduto.removeAllItems();
            do {
                jComboBoxProduto.addItem(conex.rs.getString("nome_produto"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    public void PreencherVeiculos() {
        conex.Conexao();
        conex.executaSql("select * from veiculos order by placa");
        try {
            conex.rs.first();
            jComboBoxVeiculo.removeAllItems();
            do {
                jComboBoxVeiculo.addItem(conex.rs.getString("placa"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldProduto = new javax.swing.JTextField();
        jTextFieldCasco = new javax.swing.JTextField();
        jTextFieldEnviaTexto = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldCodProduto2 = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldcheio1 = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldTurno = new javax.swing.JTextField();
        jTextFieldvazio1 = new javax.swing.JTextField();
        jTextFieldCod = new javax.swing.JTextField();
        jTextFieldCodAutonomia = new javax.swing.JTextField();
        jTextFieldNEntregas = new javax.swing.JTextField();
        jTextFieldCustoCasco = new javax.swing.JTextField();
        jTextFieldEditarCartao = new javax.swing.JTextField();
        jTextFieldTaxa = new javax.swing.JTextField();
        jTextFieldTestecartoesDebito = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCaixa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxQuantidade = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonMetodo = new javax.swing.JRadioButton();
        jRadioButtonCasco = new javax.swing.JRadioButton();
        jComboBoxVeiculo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelarItem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jButtonNovaVenda = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();

        jTextFieldUsuario.setEnabled(false);

        jTextFieldTurno.setEnabled(false);

        jTextFieldCodAutonomia.setEnabled(false);

        jTextFieldNEntregas.setEnabled(false);

        jTextFieldCustoCasco.setEnabled(false);

        jTextFieldEditarCartao.setEnabled(false);

        jTextFieldTaxa.setEnabled(false);

        jTextFieldTestecartoesDebito.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jTableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCaixa.getTableHeader().setReorderingAllowed(false);
        jTableCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCaixa);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel2.setText(" Produto");

        jComboBoxProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxProduto.setEnabled(false);
        jComboBoxProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseEntered(evt);
            }
        });

        jTextFieldData.setEnabled(false);

        jTextFieldValor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldValor.setEnabled(false);

        jLabel3.setText("Quantidade");

        jComboBoxQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBoxQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxQuantidade.setEnabled(false);
        jComboBoxQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxQuantidadeMouseEntered(evt);
            }
        });

        jLabel6.setText("Valor");

        jLabel9.setText("Data");

        jRadioButtonMetodo.setText("Com Entrega");
        jRadioButtonMetodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonMetodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonMetodoMouseEntered(evt);
            }
        });

        jRadioButtonCasco.setText("Com casco");
        jRadioButtonCasco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonCasco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonCascoMouseEntered(evt);
            }
        });

        jComboBoxVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxVeiculo.setEnabled(false);
        jComboBoxVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxVeiculoMouseEntered(evt);
            }
        });

        jLabel4.setText("Veiculo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCasco))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProduto, 0, 139, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldData)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonCasco))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Vendas");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdicionar.setEnabled(false);
        jButtonAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAdicionarMouseEntered(evt);
            }
        });
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonCancelarItem.setText("Cancelar item");
        jButtonCancelarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarItem.setEnabled(false);
        jButtonCancelarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCancelarItemMouseEntered(evt);
            }
        });
        jButtonCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarItemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Valor R$");

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTotal.setText("0,00");

        jButtonNovaVenda.setText("Nova venda");
        jButtonNovaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendaActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar venda");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinalizar.setEnabled(false);
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovaVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelarItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabelTotal)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNovaVenda)
                                .addGap(11, 11, 11)
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCancelarItem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdicionar)
                        .addGap(15, 15, 15)
                        .addComponent(jButtonFinalizar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCaixaMouseClicked
        String nome_medico = "" + jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from caixa1 where cod_venda='" + nome_medico + "'");
        try {
            conex.rs.first();
            jTextFieldCod.setText(String.valueOf(conex.rs.getInt("cod_venda")));
            jTextFieldProduto.setText(conex.rs.getString("descricao_venda"));
            jTextFieldCasco.setText(conex.rs.getString("casco"));
            jTextFieldQuantidade.setText(conex.rs.getString("quantidade_venda"));
            jButtonCancelarItem.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
        }
        conex.Desconecta();
    }//GEN-LAST:event_jTableCaixaMouseClicked

    private void jComboBoxProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produtoc")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
            }
            Double valor;
            valor = (Double.parseDouble(jTextFieldValor.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldValor.setText(String.valueOf(valor));

        }
    }//GEN-LAST:event_jComboBoxProdutoMouseEntered

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o Valor");
            jTextFieldValor.requestFocus();
        } else if (Integer.parseInt((String) jComboBoxQuantidade.getSelectedItem()) > (Integer.parseInt(jTextFieldCheio.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "A venda não pode ser realizada pois não existe mais " + jComboBoxProduto.getSelectedItem() + " no estoque");
            jButtonFinalizar.setEnabled(false);
            jButtonAdicionar.setEnabled(true);
            jButtonNovaVenda.setEnabled(false);
        } else {
            jButtonCancelar.setEnabled(false);
            Calendar data = Calendar.getInstance();
            int hora = data.get(Calendar.HOUR_OF_DAY);
            int min = data.get(Calendar.MINUTE);
            int seg = data.get(Calendar.SECOND);
            if (hora <= 12) {
                jTextFieldTurno.setText("Manha");
            } else if (hora >= 13) {
                jTextFieldTurno.setText("Tarde");
            }
            if (jRadioButtonCasco.isSelected()) {
                if (jRadioButtonMetodo.isSelected()) {
                    mod.setDescricaoVenda((String) jComboBoxProduto.getSelectedItem());
                    mod.setQuantidadeVenda((String) jComboBoxQuantidade.getSelectedItem());
                    mod.setCasco("Venda com casco");
                    mod.setMetodoVenda("Tele entrega");
                    mod.setValorVenda(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataVenda(jTextFieldData.getText());
                    mod.setHora(String.valueOf(hora + ":" + min));
                    mod.setUsuario(jTextFieldUsuario.getText());
                    mod.setTurno(jTextFieldTurno.getText());
                    mod.setCusto(Double.parseDouble(jTextFieldCustoCasco.getText()));
                    control.Salvar(mod);

                    int cheio = (Integer.parseInt(jTextFieldCheio.getText()));
                    int quantidade = (Integer.parseInt((String) jComboBoxQuantidade.getSelectedItem()));
                    int resultado = cheio - quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
                    controlProdutos.EditarQ(prod);
                    preencherTabela("select * from caixa1 order by cod_venda");
                    jButtonFinalizar.setEnabled(true);
                } else {
                    mod.setDescricaoVenda((String) jComboBoxProduto.getSelectedItem());
                    mod.setQuantidadeVenda((String) jComboBoxQuantidade.getSelectedItem());
                    mod.setCasco("Venda com casco");
                    mod.setMetodoVenda("Portaria");
                    mod.setValorVenda(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataVenda(jTextFieldData.getText());
                    mod.setHora(String.valueOf(hora + ":" + min));
                    mod.setUsuario(jTextFieldUsuario.getText());
                    mod.setTurno(jTextFieldTurno.getText());
                    mod.setCusto(Double.parseDouble(jTextFieldCustoCasco.getText()));
                    control.Salvar(mod);

                    int cheio = (Integer.parseInt(jTextFieldCheio.getText()));
                    int quantidade = (Integer.parseInt((String) jComboBoxQuantidade.getSelectedItem()));
                    int resultado = cheio - quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
                    controlProdutos.EditarQ(prod);
                    preencherTabela("select * from caixa1 order by cod_venda");
                    jButtonFinalizar.setEnabled(true);
                }
            } else {
                if (jRadioButtonMetodo.isSelected()) {
                    mod.setDescricaoVenda((String) jComboBoxProduto.getSelectedItem());
                    mod.setQuantidadeVenda((String) jComboBoxQuantidade.getSelectedItem());
                    mod.setCasco("Venda sem casco");
                    mod.setMetodoVenda("Tele entrega");
                    mod.setValorVenda(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataVenda(jTextFieldData.getText());
                    mod.setHora(String.valueOf(hora + ":" + min));
                    mod.setUsuario(jTextFieldUsuario.getText());
                    mod.setTurno(jTextFieldTurno.getText());
                    mod.setCusto(Double.parseDouble(jTextFieldCustoCasco.getText()));
                    control.Salvar(mod);

                    int cheio = (Integer.parseInt(jTextFieldCheio.getText()));
                    int vazio = (Integer.parseInt(jTextFieldVazio.getText()));
                    int quantidade = (Integer.parseInt((String) jComboBoxQuantidade.getSelectedItem()));
                    int resultado = cheio - quantidade;
                    int resultado2 = vazio + quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(resultado2);
                    controlProdutos.EditarQ(prod);
                    preencherTabela("select * from caixa1 order by cod_venda");
                } else {
                    mod.setDescricaoVenda((String) jComboBoxProduto.getSelectedItem());
                    mod.setQuantidadeVenda((String) jComboBoxQuantidade.getSelectedItem());
                    mod.setCasco("Venda sem casco");
                    mod.setMetodoVenda("Portaria");
                    mod.setValorVenda(Double.parseDouble(jTextFieldValor.getText()));
                    mod.setDataVenda(jTextFieldData.getText());
                    mod.setHora(String.valueOf(hora + ":" + min));
                    mod.setUsuario(jTextFieldUsuario.getText());
                    mod.setTurno(jTextFieldTurno.getText());
                    mod.setCusto(Double.parseDouble(jTextFieldCustoCasco.getText()));
                    control.Salvar(mod);

                    int cheio = (Integer.parseInt(jTextFieldCheio.getText()));
                    int vazio = (Integer.parseInt(jTextFieldVazio.getText()));
                    int quantidade = (Integer.parseInt((String) jComboBoxQuantidade.getSelectedItem()));
                    int resultado = cheio - quantidade;
                    int resultado2 = vazio + quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(resultado2);
                    controlProdutos.EditarQ(prod);
                    preencherTabela("select * from caixa1 order by cod_venda");
                    jButtonFinalizar.setEnabled(true);
                }
            }
            jTextFieldValor.setText("");
            jTextFieldCheio.setText("");
            jTextFieldVazio.setText("");
            jTextFieldID.setText("");
            jTextFieldTurno.setText("");
            jTextFieldCustoCasco.setText("");
            jButtonFinalizar.setEnabled(true);
            atualizapreco();
            jRadioButtonMetodo.setEnabled(false);
        }


    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            if (jRadioButtonMetodo.isSelected()) {
                jComboBoxVeiculo.setEnabled(true);
            } else {
                jComboBoxVeiculo.setEnabled(false);
            }

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldCustoCasco.setText(String.valueOf(conex.rs.getDouble("custo_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());

                }
            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldCustoCasco.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());

                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldCustoCasco.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());

                }
            }
            double custo;
            custo = (Double.parseDouble(jTextFieldCustoCasco.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldCustoCasco.setText(String.valueOf(custo));

            double Lucro = Double.parseDouble(jTextFieldCustoCasco.getText());
            DecimalFormat fmt = new DecimalFormat("0.00");
            String string = fmt.format(Lucro);
            String[] part = string.split("[,]");
            String string2 = part[0] + "." + part[1];
            double preco = Double.parseDouble(string2);
            jTextFieldCustoCasco.setText(String.valueOf(preco));

        }
        // }
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButtonCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarItemActionPerformed
        int respostaaa = 0;
        respostaaa = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente tirar da lista de vendas o produto " + jTextFieldProduto.getText());
        switch (respostaaa) {
            case JOptionPane.NO_OPTION:
                jTextFieldCodProduto2.setText("");
                jTextFieldProduto.setText("");
                jTextFieldvazio1.setText("");
                jTextFieldcheio1.setText("");
                jTextFieldCasco.setText("");
                jTextFieldCodProduto2.setText("");
                jTextFieldQuantidade.setText("");
                jTextFieldCod.setText("");
                jTextFieldTurno.setText("");
                jTextFieldCustoCasco.setText("");
                preencherTabela("select * from caixa1 order by cod_venda");
                jButtonCancelarItem.setEnabled(false);
                break;
            case JOptionPane.CANCEL_OPTION:
                jTextFieldCodProduto2.setText("");
                jTextFieldProduto.setText("");
                jTextFieldvazio1.setText("");
                jTextFieldcheio1.setText("");
                jTextFieldCasco.setText("");
                jTextFieldCodProduto2.setText("");
                jTextFieldQuantidade.setText("");
                jTextFieldCod.setText("");
                jTextFieldTurno.setText("");
                jTextFieldCustoCasco.setText("");
                preencherTabela("select * from caixa1 order by cod_venda");
                jButtonCancelarItem.setEnabled(false);
                break;
            case JOptionPane.YES_OPTION:
                mod.setCodVenda(Integer.parseInt(jTextFieldCod.getText()));
                control.Excluir(mod);
                String produto_nome = jTextFieldProduto.getText();
                conex.Conexao();
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + produto_nome + "'");
                    conex.rs.first();
                    jTextFieldcheio1.setText(conex.rs.getString("cheio"));
                    jTextFieldvazio1.setText(conex.rs.getString("vazio"));
                    jTextFieldCodProduto2.setText(conex.rs.getString("cod_produto"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
                if (jTextFieldCasco.getText().equals("Venda sem casco")) {
                    int cheio = (Integer.parseInt(jTextFieldcheio1.getText()));
                    int vazio = (Integer.parseInt(jTextFieldvazio1.getText()));
                    int quantidade = (Integer.parseInt(jTextFieldQuantidade.getText()));
                    int resultado = cheio + quantidade;
                    int resultado2 = vazio - quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldCodProduto2.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(resultado2);
                    controlProdutos.EditarQ(prod);
                } else {
                    int cheio = (Integer.parseInt(jTextFieldcheio1.getText()));
                    int quantidade = (Integer.parseInt(jTextFieldQuantidade.getText()));
                    int resultado = cheio + quantidade;
                    prod.setCodProduto(Integer.parseInt(jTextFieldCodProduto2.getText()));
                    prod.setCheo(resultado);
                    prod.setVazio(Integer.parseInt(jTextFieldvazio1.getText()));
                    controlProdutos.EditarQ(prod);

                }
                jTextFieldCodProduto2.setText("");
                jTextFieldProduto.setText("");
                jTextFieldvazio1.setText("");
                jTextFieldcheio1.setText("");
                jTextFieldCasco.setText("");
                jTextFieldCodProduto2.setText("");
                jTextFieldQuantidade.setText("");
                jTextFieldCod.setText("");
                jTextFieldTurno.setText("");
                jTextFieldCustoCasco.setText("");
                preencherTabela("select * from caixa1 order by cod_venda");
                jButtonCancelarItem.setEnabled(false);
                atualizapreco();
                //jComboBoxProduto.setEnabled(false);
                //jComboBoxLocal.setEnabled(false);
                //jComboBoxCasco.setEnabled(false);
                //jComboBoxQuantidade.setEnabled(false);
                //jTextFieldValor.setEnabled(false);
                //jTextFieldData.setEnabled(false);

                break;

        }
    }//GEN-LAST:event_jButtonCancelarItemActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);

        String[] pagamentoaceito = {"Dinheiro", "Cartão"};
        String pagamento = String.valueOf(JOptionPane.showInputDialog(null,
                "Escolha a forma de pagamento", "Escolha", JOptionPane.QUESTION_MESSAGE, null, pagamentoaceito, pagamentoaceito[0]));
        switch (pagamento) {
            case "Dinheiro":

                imprimirCupom();

                if (jRadioButtonMetodo.isSelected()) {
                    aumentarEntrega();
                }

                int contadorar = 0;
                for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                    contadorar = Integer.parseInt(jTableCaixa.getValueAt(i, 0).toString());

                    conex.Conexao();

                    try {
                        conex.executaSql("select * from caixa1 where cod_venda='" + contadorar + "'");
                        conex.rs.first();
                        jTextFieldEditarCartao.setText(String.valueOf(conex.rs.getDouble("valor_vendac")));
                        conex.Desconecta();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());
                    }

                    mod.setValor_cobrado(Double.parseDouble(jTextFieldEditarCartao.getText()));
                    mod.setCodVenda(contadorar);
                    control.Editar2(mod);
                }
                double somar = 0;
                for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                    somar += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                }
                mod.setPagamento("Dinheiro");
                mod.setValorTotal(somar);
                mod.setTipoPagamento("Venda");
                control.fechamento(mod);

                control.TransferirDados(mod);
                control.Cancelar(mod);
                jButtonAdicionar.setEnabled(false);
                jButtonNovaVenda.setEnabled(true);
                jButtonFinalizar.setEnabled(false);
                jComboBoxProduto.setEnabled(false);
                jRadioButtonMetodo.setEnabled(false);
                jRadioButtonCasco.setEnabled(false);
                jComboBoxQuantidade.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jTextFieldData.setEnabled(false);
                jComboBoxVeiculo.setEnabled(false);
                preencherTabela("select * from caixa1 order by cod_venda");
                jLabelTotal.setText("0,00");
                jTextFieldEnviaTexto.setText("");
                jTextFieldCodAutonomia.setText("");
                jTextFieldNEntregas.setText("");
                jTextFieldCustoCasco.setText("");
                jTextFieldEditarCartao.setText("");
                jComboBoxQuantidade.setSelectedItem("1");
                jRadioButtonMetodo.setSelected(false);
                jRadioButtonCasco.setSelected(false);
                jComboBoxVeiculo.removeAllItems();
                jComboBoxProduto.removeAllItems();

                break;

            case "Cartão":
                String[] tipo = {"Credito", "Debito"};
                String cartao = String.valueOf(JOptionPane.showInputDialog(null,
                        "Escolha o tipo de cartão", "Escolha", JOptionPane.QUESTION_MESSAGE, null, tipo, tipo[0]));
                switch (cartao) {
                    case "Credito":
                        conex.Conexao();
                        try {
                            String tipoluca = "Credito";
                            conex.executaSql("select * from taxa_cartoes where tipo='" + tipoluca + "'");
                            conex.rs.first();
                            jTextFieldTestecartoesDebito.setText(String.valueOf(conex.rs.getDouble("taxa")));
                            conex.Desconecta();
                        } catch (SQLException ex) {

                        }
                        if (jTextFieldTestecartoesDebito.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Você  ainda não tem taxas de credito definidas");

                        } else {

                            int contador = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                contador = Integer.parseInt(jTableCaixa.getValueAt(i, 0).toString());

                                conex.Conexao();
                                try {
                                    conex.executaSql("select * from caixa1 where cod_venda='" + contador + "'");
                                    conex.rs.first();
                                    jTextFieldEditarCartao.setText(String.valueOf(conex.rs.getDouble("valor_vendac")));
                                    conex.Desconecta();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());
                                }
                                conex.Conexao();
                                try {
                                    String tip = "Credito";
                                    conex.executaSql("select * from taxa_cartoes where tipo='" + tip + "'");
                                    conex.rs.first();
                                    jTextFieldTaxa.setText(String.valueOf(conex.rs.getDouble("taxa")));
                                    conex.Desconecta();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                                }
                                double taxa = Double.parseDouble(jTextFieldTaxa.getText());
                                double taxa2 = taxa / 100;
                                double valorAntigo = Double.parseDouble(jTextFieldEditarCartao.getText());
                                double desconto = valorAntigo * taxa2;
                                /*0.0319 = 3.19%*/
                                double novo = valorAntigo - desconto;

                                DecimalFormat fmt = new DecimalFormat("0.00");
                                String string = fmt.format(novo);
                                String[] part = string.split("[,]");
                                String string2 = part[0] + "." + part[1];
                                double p = Double.parseDouble(string2);

                                mod.setValor_cobrado(Double.parseDouble(jTextFieldEditarCartao.getText()));
                                mod.setValorVenda(p);
                                mod.setCodVenda(contador);
                                control.Editar(mod);
                            }

                            imprimirCupom();

                            double somar2 = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                somar2 += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            mod.setPagamento("Cartão");
                            mod.setValorTotal(somar2);
                            mod.setTipoPagamento("Venda");
                            control.fechamento(mod);

                            if (jRadioButtonMetodo.isSelected()) {
                                aumentarEntrega();
                            }

                            double count = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                count += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            DecimalFormat fmt = new DecimalFormat("0.00");
                            String string = fmt.format(count);
                            String[] part = string.split("[,]");
                            String string2 = part[0] + "." + part[1];
                            double preco = Double.parseDouble(string2);

                            cart.setValor(preco);
                            preencherTabela("select * from caixa1 order by cod_venda");

                            double be = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                be += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            DecimalFormat fomt = new DecimalFormat("0.00");
                            String stringmt = fomt.format(be);
                            String[] partmt = stringmt.split("[,]");
                            String stringmt2 = partmt[0] + "." + partmt[1];
                            double precomt = Double.parseDouble(stringmt2);
                            cart.setReceber(precomt);
                            cart.setData(dtHoje);
                            cart.setHora(String.valueOf(hora + ":" + min));
                            cart.setSituacao("A receber");
                            cart.setTipoCartao("Credito");
                            controlcart.Salvar(cart);
                            control.TransferirDados(mod);
                            control.Cancelar(mod);

                            jButtonAdicionar.setEnabled(false);
                            jButtonNovaVenda.setEnabled(true);
                            jButtonFinalizar.setEnabled(false);
                            jComboBoxProduto.setEnabled(false);
                            jRadioButtonMetodo.setEnabled(false);
                            jRadioButtonCasco.setEnabled(false);
                            jComboBoxQuantidade.setEnabled(false);
                            jTextFieldValor.setEnabled(false);
                            jTextFieldData.setEnabled(false);
                            jComboBoxVeiculo.setEnabled(false);
                            preencherTabela("select * from caixa1 order by cod_venda");
                            jLabelTotal.setText("0,00");
                            jTextFieldEnviaTexto.setText("");
                            jTextFieldCodAutonomia.setText("");
                            jTextFieldNEntregas.setText("");
                            jTextFieldEditarCartao.setText("");
                            jTextFieldTaxa.setText("");
                            jComboBoxQuantidade.setSelectedItem("1");
                            jRadioButtonMetodo.setSelected(false);
                            jRadioButtonCasco.setSelected(false);
                            jComboBoxVeiculo.removeAllItems();
                            jComboBoxProduto.removeAllItems();
                        }
                        break;

                    case "Debito":
                        conex.Conexao();
                        try {
                            String tipoluc = "Debito";
                            conex.executaSql("select * from taxa_cartoes where tipo='" + tipoluc + "'");
                            conex.rs.first();
                            jTextFieldTestecartoesDebito.setText(String.valueOf(conex.rs.getDouble("taxa")));
                            conex.Desconecta();
                        } catch (SQLException ex) {

                        }
                        if (jTextFieldTestecartoesDebito.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Você ainda não tem taxas de debito definidas");

                        } else {

                            int contadore = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                contadore = Integer.parseInt(jTableCaixa.getValueAt(i, 0).toString());

                                conex.Conexao();
                                try {
                                    conex.executaSql("select * from caixa1 where cod_venda='" + contadore + "'");
                                    conex.rs.first();
                                    jTextFieldEditarCartao.setText(String.valueOf(conex.rs.getDouble("valor_vendac")));
                                    conex.Desconecta();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro\n" + ex.getMessage());
                                }
                                conex.Conexao();
                                try {
                                    String tipolu = "Debito";
                                    conex.executaSql("select * from taxa_cartoes where tipo='" + tipolu + "'");
                                    conex.rs.first();
                                    jTextFieldTaxa.setText(String.valueOf(conex.rs.getDouble("taxa")));
                                    conex.Desconecta();
                                } catch (SQLException ex) {

                                }
                                double taxaed = Double.parseDouble(jTextFieldTaxa.getText());
                                double taxaed2 = taxaed / 100;
                                double valorAntigor = Double.parseDouble(jTextFieldEditarCartao.getText());
                                double descontor = valorAntigor * taxaed2;
                                /*0.0319 = 3.19%*/
                                double novor = valorAntigor - descontor;

                                DecimalFormat fmtt = new DecimalFormat("0.00");
                                String stringt = fmtt.format(novor);
                                String[] partt = stringt.split("[,]");
                                String stringtt = partt[0] + "." + partt[1];
                                double pp = Double.parseDouble(stringtt);

                                mod.setValor_cobrado(Double.parseDouble(jTextFieldEditarCartao.getText()));
                                mod.setValorVenda(pp);
                                mod.setCodVenda(contadore);
                                control.Editar(mod);
                            }

                            imprimirCupom();

                            double somar2 = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                somar2 += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            mod.setPagamento("Cartão");
                            mod.setValorTotal(somar2);
                            mod.setTipoPagamento("Venda");
                            control.fechamento(mod);

                            if (jRadioButtonMetodo.isSelected()) {
                                aumentarEntrega();
                            }

                            double coun = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                coun += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            DecimalFormat fm = new DecimalFormat("0.00");
                            String strin = fm.format(coun);
                            String[] par = strin.split("[,]");
                            String stri = par[0] + "." + par[1];
                            double prec = Double.parseDouble(stri);

                            cart.setValor(prec);
                            preencherTabela("select * from caixa1 order by cod_venda");

                            double bec = 0;
                            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                                bec += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
                            }
                            DecimalFormat fomtc = new DecimalFormat("0.00");
                            String stringmtc = fomtc.format(bec);
                            String[] partmtc = stringmtc.split("[,]");
                            String stringmtc2 = partmtc[0] + "." + partmtc[1];
                            double precomtc = Double.parseDouble(stringmtc2);
                            cart.setReceber(precomtc);
                            cart.setData(dtHoje);
                            cart.setHora(String.valueOf(hora + ":" + min));
                            cart.setSituacao("A receber");
                            cart.setTipoCartao("Debito");
                            controlcart.Salvar(cart);

                            control.TransferirDados(mod);
                            control.Cancelar(mod);

                            jButtonAdicionar.setEnabled(false);
                            jButtonNovaVenda.setEnabled(true);
                            jButtonFinalizar.setEnabled(false);
                            jComboBoxProduto.setEnabled(false);
                            jRadioButtonMetodo.setEnabled(false);
                            jRadioButtonCasco.setEnabled(false);
                            jComboBoxQuantidade.setEnabled(false);
                            jTextFieldValor.setEnabled(false);
                            jTextFieldData.setEnabled(false);
                            preencherTabela("select * from caixa1 order by cod_venda");
                            jLabelTotal.setText("0,00");
                            jTextFieldEnviaTexto.setText("");
                            jTextFieldCodAutonomia.setText("");
                            jTextFieldNEntregas.setText("");
                            jTextFieldEditarCartao.setText("");
                            jTextFieldTaxa.setText("");
                            jComboBoxQuantidade.setSelectedItem("1");
                            jRadioButtonMetodo.setSelected(false);
                            jRadioButtonCasco.setSelected(false);
                            jComboBoxVeiculo.setEnabled(false);
                            jComboBoxVeiculo.removeAllItems();
                            jComboBoxProduto.removeAllItems();
                            break;

                        }
                }
        }
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja incluir esta venda no historico");
        if (resposta == JOptionPane.YES_OPTION) {
            AtualizaHistorico tela = new AtualizaHistorico();
            tela.setVisible(true);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonCancelarItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarItemMouseEntered

    }//GEN-LAST:event_jButtonCancelarItemMouseEntered

    private void jComboBoxQuantidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxQuantidadeMouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produtoc")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
            }
            Double valor;
            valor = (Double.parseDouble(jTextFieldValor.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldValor.setText(String.valueOf(valor));

        }

    }//GEN-LAST:event_jComboBoxQuantidadeMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered


    }//GEN-LAST:event_formMouseEntered

    private void jButtonNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVendaActionPerformed
        PreencherProdutos();
        PreencherVeiculos();
        if (jComboBoxProduto.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "A venda não pode ser concluida pois ainda não há produtos a venda");
        } else if (jComboBoxVeiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "A venda não pode ser concluida pois não há veiculos para entrega");
        } else {
            jComboBoxProduto.setEnabled(true);
            jButtonAdicionar.setEnabled(true);
            jButtonNovaVenda.setEnabled(false);
            jRadioButtonMetodo.setEnabled(true);
            jRadioButtonCasco.setEnabled(true);
            jComboBoxQuantidade.setEnabled(true);
            jTextFieldValor.setEnabled(true);
            jTextFieldData.setEnabled(true);
            jButtonCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonNovaVendaActionPerformed

    private void jComboBoxProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseClicked

    }//GEN-LAST:event_jComboBoxProdutoMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonAdicionar.setEnabled(false);
        jButtonNovaVenda.setEnabled(true);
        jComboBoxProduto.setEnabled(false);
        jRadioButtonMetodo.setEnabled(false);
        jRadioButtonCasco.setEnabled(false);
        jComboBoxQuantidade.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jTextFieldCodAutonomia.setText("");
        jTextFieldNEntregas.setText("");
        jTextFieldCustoCasco.setText("");
        jButtonCancelar.setEnabled(false);
        jComboBoxVeiculo.setEnabled(false);
        jComboBoxQuantidade.setSelectedItem("1");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonMetodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMetodoMouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produtoc")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
            }
            Double valor;
            valor = (Double.parseDouble(jTextFieldValor.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldValor.setText(String.valueOf(valor));

        }

    }//GEN-LAST:event_jRadioButtonMetodoMouseEntered

    private void jComboBoxVeiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoMouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produtoc")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
            }
            Double valor;
            valor = (Double.parseDouble(jTextFieldValor.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldValor.setText(String.valueOf(valor));

        }


    }//GEN-LAST:event_jComboBoxVeiculoMouseEntered

    private void jRadioButtonCascoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonCascoMouseEntered
        if (jComboBoxProduto.getSelectedItem() == null) {

        } else if (jComboBoxVeiculo.getSelectedItem() == null) {

        } else {

            String cliente_nome = "" + jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
            conex.Conexao();

            if (jRadioButtonCasco.isSelected()) {

                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else if (jRadioButtonMetodo.isSelected()) {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }

            } else {
                try {
                    conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
                    conex.rs.first();
                    jTextFieldID.setText(conex.rs.getString("cod_produto"));
                    jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor_produtoc")));
                    jTextFieldCheio.setText(conex.rs.getString("cheio"));
                    jTextFieldVazio.setText(conex.rs.getString("vazio"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
                }
            }
            Double valor;
            valor = (Double.parseDouble(jTextFieldValor.getText()) * Double.parseDouble((String) jComboBoxQuantidade.getSelectedItem()));
            jTextFieldValor.setText(String.valueOf(valor));

        }
    }//GEN-LAST:event_jRadioButtonCascoMouseEntered

    private void jButtonAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseEntered
        try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31");
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }

        if (jRadioButtonMetodo.isSelected()) {

            String teste = (String) jComboBoxVeiculo.getSelectedItem();
            conex.Conexao();
            conex.executaSql("SELECT * FROM autonomia where veiculo='" + teste + "' ORDER BY codigo DESC LIMIT 1");
            try {
                conex.rs.first();

                do {
                    jTextFieldCodAutonomia.setText(conex.rs.getString("codigo"));
                } while (conex.rs.next());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Ainda não é possivel fazer Tele-entrega. Informe o primeiro abastecimento do veiculo");
                jRadioButtonMetodo.setSelected(false);
                jComboBoxVeiculo.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonAdicionarMouseEntered

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Produto", "Quantidade", "C/S casco", "Local venda", "Valor", "Data", "Hora"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            jButtonFinalizar.setEnabled(true);
            jButtonNovaVenda.setEnabled(false);

            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("cod_venda"), conex.rs.getString("descricao_venda"), conex.rs.getString("quantidade_venda"), conex.rs.getString("casco"), conex.rs.getString("metodo"), conex.rs.getDouble("valor_vendac"), conex.rs.getString("data_venda"), conex.rs.getString("hora")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            jLabelTotal.setText("0,00");
            jButtonAdicionar.setEnabled(false);
            jButtonFinalizar.setEnabled(false);
            jButtonCancelarItem.setEnabled(false);
            jButtonNovaVenda.setEnabled(true);
            jComboBoxProduto.setEnabled(false);
            jRadioButtonMetodo.setEnabled(false);
            jRadioButtonCasco.setEnabled(false);
            jComboBoxQuantidade.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jTextFieldData.setEnabled(false);
            jRadioButtonMetodo.setSelected(false);

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableCaixa.setModel(modelo);
        jTableCaixa.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableCaixa.getColumnModel().getColumn(0).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(1).setPreferredWidth(170);
        jTableCaixa.getColumnModel().getColumn(1).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(2).setPreferredWidth(125);
        jTableCaixa.getColumnModel().getColumn(2).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTableCaixa.getColumnModel().getColumn(3).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(4).setPreferredWidth(110);
        jTableCaixa.getColumnModel().getColumn(4).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableCaixa.getColumnModel().getColumn(5).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(6).setPreferredWidth(110);
        jTableCaixa.getColumnModel().getColumn(6).setResizable(false);
        jTableCaixa.getColumnModel().getColumn(7).setPreferredWidth(110);
        jTableCaixa.getColumnModel().getColumn(7).setResizable(false);
        jTableCaixa.getTableHeader().setReorderingAllowed(false);
        jTableCaixa.setAutoResizeMode(jTableCaixa.AUTO_RESIZE_OFF);
        jTableCaixa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    public void atualizapreco() {
        double count = 0;
        for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTableCaixa.getValueAt(i, 5).toString());
            String dx = df.format(count);
            jLabelTotal.setText(String.valueOf(dx));
        }
    }

    public void imprimir(String caminho) {
        Desktop desktop = Desktop.getDesktop();
        try {
            File arquivoImprimir = new File(caminho);
            desktop.print(arquivoImprimir);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
        }
    }

    public void imprimirCupom() {
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);

        List<String> cupom;
        cupom = new ArrayList<String>();

        int re = 0;
        re = JOptionPane.showConfirmDialog(rootPane, "Deseja imprimir o cupom?");
        if (re == JOptionPane.YES_OPTION) {

            for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
                cupom.add(jTableCaixa.getValueAt(i, 1).toString() + "\r\nQuantidade " + jTableCaixa.getValueAt(i, 2).toString() + "\r\nValor R$ " + jTableCaixa.getValueAt(i, 5).toString());

            }
            String todosprodutos = "";
            for (String f : cupom) {
                todosprodutos += f + "\r\n\r\n";
            }
            Path caminho = Paths.get("C:imprimir.txt");
            String texto = "Comprovante de compra "
                    + "  " + dtHoje + "  " + hora + ":" + min + "\r\n\r\n"
                    + "    Agradecemos a\r\n"
                    + "     preferencia\r\n\r\n"
                    + " CopaGaz / Dias Gás\r\n"
                    + "Fone 051 9 9668-5564\r\n\r\n"
                    + "Descrição da venda"
                    + "\r\n" + todosprodutos + "Valor total R$ " + jLabelTotal.getText() + "\r\n\r\n"
                    + "R:Tristão Monteiro 397";

            byte[] textoEMByte = texto.getBytes();

            try {
                Files.write(caminho, textoEMByte);
                imprimir("C:imprimir.txt");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro verifique a impressora");
            }
        }
    }

    public void aumentarEntrega() {
        String veiculo = (String) jComboBoxVeiculo.getSelectedItem();
        conex.Conexao();
        conex.executaSql("SELECT * FROM autonomia where veiculo='" + veiculo + "' ORDER BY codigo DESC LIMIT 1");
        try {
            conex.rs.first();

            do {
                jTextFieldCodAutonomia.setText(conex.rs.getString("codigo"));
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não é possivel fazer media com o veiculo por ele ainda não foi abastecido");
        }

        String autonomia = "" + jTextFieldCodAutonomia.getText();
        conex.Conexao();
        try {
            conex.executaSql("select * from autonomia where codigo='" + autonomia + "'");
            conex.rs.first();
            jTextFieldNEntregas.setText(String.valueOf(conex.rs.getInt("entregas")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
        }
        int cont = 0;
        for (int i = 0; i <= jTableCaixa.getRowCount() - 1; i++) {
            cont += Integer.parseInt(jTableCaixa.getValueAt(i, 2).toString());
        }

        int entregado = Integer.parseInt(jTextFieldNEntregas.getText());
        int resultado = entregado + cont;
        auto.setEntregas(resultado);
        auto.setCodigo(Integer.parseInt(jTextFieldCodAutonomia.getText()));
        controlauto.aumentarEntrega(auto);

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
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrenteCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarItem;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonNovaVenda;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JComboBox<String> jComboBoxQuantidade;
    private javax.swing.JComboBox<String> jComboBoxVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCasco;
    private javax.swing.JRadioButton jRadioButtonMetodo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCaixa;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldCodAutonomia;
    private javax.swing.JTextField jTextFieldCodProduto2;
    private javax.swing.JTextField jTextFieldCustoCasco;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEditarCartao;
    private javax.swing.JTextField jTextFieldEnviaTexto;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNEntregas;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTaxa;
    private javax.swing.JTextField jTextFieldTestecartoesDebito;
    private javax.swing.JTextField jTextFieldTurno;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField jTextFieldcheio1;
    private javax.swing.JTextField jTextFieldvazio1;
    // End of variables declaration//GEN-END:variables
public void recebendo(String recebe) {
        jTextFieldUsuario.setText(recebe);
    }

    public void addItem(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
