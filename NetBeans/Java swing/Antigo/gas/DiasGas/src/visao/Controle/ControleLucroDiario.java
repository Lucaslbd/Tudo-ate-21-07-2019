package visao.Controle;

import visao.Consulta.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.reflect.Array.set;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansProdutos;
import modeloBeans.BeansVendas;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoProdutos;
import modeloDao.DaoVenda;

public class ControleLucroDiario extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansVendas mod = new BeansVendas();
    DaoVenda control = new DaoVenda();
    BeansProdutos modProdutos = new BeansProdutos();
    DaoProdutos Produtos = new DaoProdutos();
    DecimalFormat df = new DecimalFormat("0.##");

    public ControleLucroDiario() {
        initComponents();
        PreencherProdutos();

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextField1.setText(dtHoje);
        jTextFieldData.setText(dtHoje);
    }

    public void PreencherProdutos() {
        conex.Conexao();
        conex.executaSql("select * from produtos order by nome_produto");
        try {
            conex.rs.first();
            jComboBoxProduto.removeAllItems();
            jComboBox1.removeAllItems();
            do {
                jComboBoxProduto.addItem(conex.rs.getString("nome_produto"));
                jComboBox1.addItem(conex.rs.getString("nome_produto"));
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCod = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldCasco = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jTextFieldData = new javax.swing.JTextField();
        jButtonPesquisarData = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxMetodo = new javax.swing.JComboBox<>();
        jButtonMetodo = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPesquisarTudo = new javax.swing.JTextField();
        jButtonPesquisarTudo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonApurado = new javax.swing.JButton();
        jButtonLucro = new javax.swing.JButton();
        jButtonContarData = new javax.swing.JButton();
        jButtonPercentualLucro = new javax.swing.JButton();
        jButtonPrecoMedio = new javax.swing.JButton();
        jButtonQTDMedia = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCod.setEnabled(false);

        jTextFieldQuantidade.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldCasco.setEnabled(false);

        jTextFieldID.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendas);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisa por produto"));

        jLabel12.setText("Escolha um Produto");

        jLabel2.setText("Escolha a data");

        jComboBoxProduto.setToolTipText("");
        jComboBoxProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseClicked(evt);
            }
        });

        jButtonPesquisarData.setText("Pesquisar");
        jButtonPesquisarData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisarData))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarData)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisa por metodo"));

        jLabel8.setText("Escolha o metodo");

        jLabel9.setText("Escolha a data");

        jComboBoxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portaria", "Tele entrega" }));
        jComboBoxMetodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonMetodo.setText("Pesquisar");
        jButtonMetodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMetodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMetodo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButtonMetodo)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisar tudo"));

        jLabel14.setText("Data");

        jButtonPesquisarTudo.setText("Pesquisar");
        jButtonPesquisarTudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPesquisarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldPesquisarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarTudo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Calculos importantes"));

        jButtonApurado.setText("Somar apurado");
        jButtonApurado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonApurado.setEnabled(false);
        jButtonApurado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApuradoActionPerformed(evt);
            }
        });

        jButtonLucro.setText("Somar lucro");
        jButtonLucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLucro.setEnabled(false);
        jButtonLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLucroActionPerformed(evt);
            }
        });

        jButtonContarData.setText("Contar registros");
        jButtonContarData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonContarData.setEnabled(false);
        jButtonContarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContarDataActionPerformed(evt);
            }
        });

        jButtonPercentualLucro.setText("Percentual de lucro");
        jButtonPercentualLucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPercentualLucro.setEnabled(false);
        jButtonPercentualLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPercentualLucroActionPerformed(evt);
            }
        });

        jButtonPrecoMedio.setText("Preço médio de venda");
        jButtonPrecoMedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPrecoMedio.setEnabled(false);
        jButtonPrecoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecoMedioActionPerformed(evt);
            }
        });

        jButtonQTDMedia.setText("Qtd Média de venda");
        jButtonQTDMedia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonQTDMedia.setEnabled(false);
        jButtonQTDMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQTDMediaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonApurado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonContarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPercentualLucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPrecoMedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonQTDMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonApurado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLucro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonContarData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPercentualLucro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPrecoMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonQTDMedia)
                .addGap(45, 45, 45))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisa personalizada"));

        jLabel3.setText("Escolha o produto");

        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setText("Escolha o metodo");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portaria", "Tele entrega" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setText("Data");

        jButton4.setText("Pesquisar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Atualizar.setText("Atualizar hoje");
        Atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Imprimir consulta");
        jButtonImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImprimir.setEnabled(false);
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Atualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonImprimir))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Controle de lucro diário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDataActionPerformed
        if (jTextFieldData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a data da busca");
            jTextFieldData.requestFocus();
        } else {
            mod.setPesquisar(jTextFieldData.getText());
            String Produto = (String) jComboBoxProduto.getSelectedItem();
            preencherTabela("select *from vendas where  descricao_venda='" + Produto + "' and data_venda like'%" + mod.getPesquisar() + "%' order by data_venda");

            jButtonContarData.setEnabled(true);
            jButtonApurado.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonLucro.setEnabled(true);
            jButtonPercentualLucro.setEnabled(true);
            jButtonPrecoMedio.setEnabled(true);
            jButtonQTDMedia.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonPesquisarDataActionPerformed

    private void jTableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendasMouseClicked


    }//GEN-LAST:event_jTableVendasMouseClicked

    private void jButtonContarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContarDataActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            int cont = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                cont += Integer.parseInt(jTableVendas.getValueAt(i, 4).toString());
            }
            JOptionPane.showMessageDialog(null, "O numero de vendas é " + cont);
        }
    }//GEN-LAST:event_jButtonContarDataActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        preencherTabela("select * from vendas where data_venda ='" + dtHoje + "' order by codigo_Venda");

        jButtonPercentualLucro.setEnabled(true);
        jButtonPrecoMedio.setEnabled(false);
        jButtonLucro.setEnabled(true);
        jButtonContarData.setEnabled(true);
        jButtonApurado.setEnabled(true);
        jButtonImprimir.setEnabled(true);
        jButtonQTDMedia.setEnabled(false);
    }//GEN-LAST:event_AtualizarActionPerformed

    private void jButtonMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMetodoActionPerformed
        if (jFormattedTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a data da busca");
            jFormattedTextField1.requestFocus();
        } else {
            mod.setPesquisar(jFormattedTextField1.getText());

            jButtonContarData.setEnabled(true);
            jButtonApurado.setEnabled(true);
            jButtonLucro.setEnabled(true);
            jButtonPercentualLucro.setEnabled(true);
            jButtonPrecoMedio.setEnabled(false);
            jButtonImprimir.setEnabled(true);
            jButtonQTDMedia.setEnabled(false);
            String Produto = (String) jComboBoxMetodo.getSelectedItem();
            preencherTabela("select *from vendas where  metodo='" + Produto + "' and data_venda like'%" + mod.getPesquisar() + "%' order by data_venda");
        }
    }//GEN-LAST:event_jButtonMetodoActionPerformed

    private void jButtonApuradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApuradoActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            double count = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                count += Double.parseDouble(jTableVendas.getValueAt(i, 7).toString());
            }
            String dx = df.format(count);
            JOptionPane.showMessageDialog(null, "O valor do apurado é R$ " + dx + " reais");
        }
    }//GEN-LAST:event_jButtonApuradoActionPerformed

    private void jButtonPesquisarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarTudoActionPerformed
        if (jTextFieldPesquisarTudo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira sua pesquisa");
            jTextFieldPesquisarTudo.requestFocus();
        } else {
            mod.setPesquisar(jTextFieldPesquisarTudo.getText());
            preencherTabela("select *from vendas where data_venda like'%" + mod.getPesquisar() + "%' order by codigo_venda");

            jButtonContarData.setEnabled(true);
            jButtonApurado.setEnabled(true);
            jButtonImprimir.setEnabled(true);
            jButtonLucro.setEnabled(true);
            jButtonPercentualLucro.setEnabled(true);
            jButtonPrecoMedio.setEnabled(false);
            jButtonQTDMedia.setEnabled(false);
        }

    }//GEN-LAST:event_jButtonPesquisarTudoActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        //Aqui começa o codigo de impressão anteriror
        // PrinterJob job = PrinterJob.getPrinterJob();
        //  job.setPrintable(jTableVendas.getPrintable(PrintMode.FIT_WIDTH, null, null));
//job.setJobName("Nome do Trabalho de impressão");
//if (job.printDialog()) {
        //  try {
        //    job.print();
        // } catch (PrinterException ex) {
        //   Logger.getLogger(ConsultaDeVendas.class.getName()).log(Level.SEVERE, null, ex);
        // }
//} aqui termina talves ele ainda seje importante
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {
            Calendar data = Calendar.getInstance();
            int hora = data.get(Calendar.HOUR_OF_DAY);
            int min = data.get(Calendar.MINUTE);
            int seg = data.get(Calendar.SECOND);

            Date d = data.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.format(d);
            String dtHoje;
            dtHoje = dateFormat.format(d);

            MessageFormat headerFormat = new MessageFormat("Relatorio de vendas");
            MessageFormat footerFormat = new MessageFormat("Data " + dtHoje + " Hora " + hora + ":" + min + ":" + seg);
            try {
                jTableVendas.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);

            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(rootPane, "erro" + ex);
            }
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jComboBoxProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseClicked
        PreencherProdutos();
    }//GEN-LAST:event_jComboBoxProdutoMouseClicked

    private void jButtonLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLucroActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            double count = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                count += Double.parseDouble(jTableVendas.getValueAt(i, 9).toString());
            }
            String dx = df.format(count);
            JOptionPane.showMessageDialog(null, "O valor do lucro é R$ " + dx + " reais");
        }
    }//GEN-LAST:event_jButtonLucroActionPerformed

    private void jButtonPercentualLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPercentualLucroActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            double lucro = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                lucro += Double.parseDouble(jTableVendas.getValueAt(i, 9).toString());
            }
            double custo = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                custo += Double.parseDouble(jTableVendas.getValueAt(i, 8).toString());
            }
            double resultado = lucro / custo * 100;
            String dx = df.format(resultado);
            JOptionPane.showMessageDialog(null, "O percentual de lucro geral sobre todas as vendas é de " + dx + " %");
        }
    }//GEN-LAST:event_jButtonPercentualLucroActionPerformed

    private void jButtonPrecoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecoMedioActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            double apurado = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                apurado += Double.parseDouble(jTableVendas.getValueAt(i, 7).toString());
            }
            int numeroVendas = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                numeroVendas += Integer.parseInt(jTableVendas.getValueAt(i, 4).toString());
            }

            double resultado = apurado / numeroVendas;
            String dx = df.format(resultado);
            JOptionPane.showMessageDialog(null, "O preço medio de venda é de é R$ " + dx + " reais");
        }
    }//GEN-LAST:event_jButtonPrecoMedioActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mod.setPesquisar(jTextField1.getText());
        String metodo = (String) jComboBox2.getSelectedItem();
        String produto = (String) jComboBox1.getSelectedItem();
        preencherTabela("select *from vendas where  metodo='" + metodo + "' and descricao_venda='" + produto + "' and data_venda like'%" + mod.getPesquisar() + "%' order by data_venda");
        jButtonContarData.setEnabled(true);
        jButtonApurado.setEnabled(true);
        jButtonImprimir.setEnabled(true);
        jButtonLucro.setEnabled(true);
        jButtonPercentualLucro.setEnabled(true);
        jButtonPrecoMedio.setEnabled(true);

        jButtonQTDMedia.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonQTDMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQTDMediaActionPerformed
        int contador = jTableVendas.getRowCount();
        if (contador == 0) {
            JOptionPane.showMessageDialog(rootPane, "Operação não pode ser realizada pois a tabela está vazia.");
        } else {

            int Quantidade = 0;
            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                Quantidade += Integer.parseInt(jTableVendas.getValueAt(i, 4).toString());
            }
            List<String> Dias;
            Dias = new ArrayList<String>();

            for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
                Dias.add(jTableVendas.getValueAt(i, 1).toString());
            }
            Set<String> semRepeticao = new LinkedHashSet<String>();
            for (String valor : Dias) {
                semRepeticao.add(valor);
            }
            double DiasTrabalhados = semRepeticao.size();

            double media = Quantidade / DiasTrabalhados;

            String dx = df.format(media);
            JOptionPane.showMessageDialog(null, "A média de vendas e de " + dx + " por dia em um periodo de " + DiasTrabalhados + " dias");
        }
    }//GEN-LAST:event_jButtonQTDMediaActionPerformed

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Produto", "Data", "Metodo", "Casco", "Quantidade", "Pagamento", "Cobrado", "recebido", "Custo", "Lucro", "% de lucro"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                double Lucro = conex.rs.getDouble("valor_vendac") - conex.rs.getDouble("valor_custo");
                DecimalFormat fmt = new DecimalFormat("0.00");
                String string = fmt.format(Lucro);
                String[] part = string.split("[,]");
                String string2 = part[0] + "." + part[1];
                double lucroDinheiro = Double.parseDouble(string2);

                double porcento = (lucroDinheiro / conex.rs.getDouble("valor_vendac")) * 100;
                String teste = fmt.format(porcento);
                String[] part2 = teste.split("[,]");
                String string3 = part2[0] + "." + part2[1];
                double preco2 = Double.parseDouble(string3);

                String forma;
                if (conex.rs.getDouble("valor_cobrado") == conex.rs.getDouble("valor_vendac")) {
                    forma = "Dinheiro";
                } else {
                    forma = "Cartão";
                }

                dados.add(new Object[]{conex.rs.getString("descricao_venda"), conex.rs.getString("data_venda"), conex.rs.getString("metodo"), conex.rs.getString("casco"), conex.rs.getString("quantidade_venda"), forma, conex.rs.getDouble("valor_cobrado"), conex.rs.getDouble("valor_vendac"), conex.rs.getDouble("valor_custo"), lucroDinheiro, preco2 + " %"});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Venda não encontrada");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableVendas.setModel(modelo);
        jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTableVendas.getColumnModel().getColumn(0).setResizable(false);
        jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(95);
        jTableVendas.getColumnModel().getColumn(1).setResizable(false);
        jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableVendas.getColumnModel().getColumn(2).setResizable(false);
        jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(125);
        jTableVendas.getColumnModel().getColumn(3).setResizable(false);
        jTableVendas.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(4).setResizable(false);
        jTableVendas.getColumnModel().getColumn(5).setPreferredWidth(90);
        jTableVendas.getColumnModel().getColumn(5).setResizable(false);
        jTableVendas.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(6).setResizable(false);
        jTableVendas.getColumnModel().getColumn(7).setPreferredWidth(72);
        jTableVendas.getColumnModel().getColumn(7).setResizable(false);
        jTableVendas.getColumnModel().getColumn(8).setPreferredWidth(71);
        jTableVendas.getColumnModel().getColumn(8).setResizable(false);
        jTableVendas.getColumnModel().getColumn(9).setPreferredWidth(71);
        jTableVendas.getColumnModel().getColumn(9).setResizable(false);
        jTableVendas.getColumnModel().getColumn(10).setPreferredWidth(75);
        jTableVendas.getColumnModel().getColumn(10).setResizable(false);
        jTableVendas.getTableHeader().setReorderingAllowed(false);
        jTableVendas.setAutoResizeMode(jTableVendas.AUTO_RESIZE_OFF);
        jTableVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
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
            java.util.logging.Logger.getLogger(ControleLucroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLucroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLucroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLucroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleLucroDiario().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonApurado;
    private javax.swing.JButton jButtonContarData;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonLucro;
    private javax.swing.JButton jButtonMetodo;
    private javax.swing.JButton jButtonPercentualLucro;
    private javax.swing.JButton jButtonPesquisarData;
    private javax.swing.JButton jButtonPesquisarTudo;
    private javax.swing.JButton jButtonPrecoMedio;
    private javax.swing.JButton jButtonQTDMedia;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxMetodo;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldPesquisarTudo;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldVazio;
    // End of variables declaration//GEN-END:variables
}
