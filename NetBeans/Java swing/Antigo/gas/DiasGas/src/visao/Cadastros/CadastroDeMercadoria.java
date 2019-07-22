package visao.Cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansProdutos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoProdutos;

public class CadastroDeMercadoria extends javax.swing.JFrame {

    BeansProdutos mod = new BeansProdutos();
    DaoProdutos control = new DaoProdutos();
    ConexaoBD conex = new ConexaoBD();
    int flag = 0;

    public CadastroDeMercadoria() {
        initComponents();
  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldtele = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValorPortaria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCasco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCusto = new javax.swing.JTextField();
        jTextFieldCustoCasco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCheio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldVazio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldID.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseEntered(evt);
            }
        });
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro de valores"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel10.setText("Valor tele entrega");

        jTextFieldtele.setEnabled(false);

        jLabel3.setText("Valor portaria");

        jTextFieldValorPortaria.setEnabled(false);
        jTextFieldValorPortaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldValorPortariaMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextFieldValorPortariaMouseReleased(evt);
            }
        });

        jLabel8.setText("Valor com casco");

        jTextFieldCasco.setEnabled(false);

        jLabel5.setText("Preço de custo");

        jTextFieldCusto.setEnabled(false);

        jTextFieldCustoCasco.setEnabled(false);

        jLabel11.setText("Preço de custo do casco");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCustoCasco)
                    .addComponent(jTextFieldValorPortaria)
                    .addComponent(jTextFieldtele)
                    .addComponent(jTextFieldCasco)
                    .addComponent(jTextFieldCusto, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldValorPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldtele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCasco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCustoCasco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTextFieldNomeProduto.setEnabled(false);

        jLabel2.setText("Nome");

        jLabel6.setText("Quantidade Cheio");

        jTextFieldCheio.setEnabled(false);

        jLabel7.setText("Quantidade Vazio");

        jTextFieldVazio.setEnabled(false);
        jTextFieldVazio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVazioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(62, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCheio, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jTextFieldVazio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCheio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldVazio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       if (jTextFieldNomeProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o nome do produto");
            jTextFieldNomeProduto.requestFocus();
      } else if (jTextFieldCheio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a quatidade de garrafas cheias");
            jTextFieldCheio.requestFocus();
     } else if (jTextFieldVazio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a quantidade de garrasfas vazias");
            jTextFieldVazio.requestFocus();
        } else if (jTextFieldValorPortaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor do produto na portaria");
            jTextFieldValorPortaria.requestFocus();
        } else if (jTextFieldtele.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor do produto na tele-entrega");
            jTextFieldtele.requestFocus();
       } else if (jTextFieldCasco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor de venda do produto com o casco");
            jTextFieldCasco.requestFocus();
       } else if (jTextFieldCusto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor de custo do produto");
            jTextFieldCusto.requestFocus();
      } else if (jTextFieldCustoCasco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o valor de custo do produto com o casco");
            jTextFieldCustoCasco.requestFocus();     
        } else if (flag == 1) {
            mod.setNomeProduto(jTextFieldNomeProduto.getText());
            mod.setPrecoProduto(Double.parseDouble(jTextFieldValorPortaria.getText()));
            mod.setCheo(Integer.parseInt(jTextFieldCheio.getText()));
            mod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
            mod.setValorCasco(jTextFieldCasco.getText());
            mod.setValorTele(Double.parseDouble(jTextFieldtele.getText()));
            mod.setPrecocusto(Double.parseDouble(jTextFieldCusto.getText()));
            mod.setCustoCasco(Double.parseDouble(jTextFieldCustoCasco.getText()));
            control.Salvar(mod);
             mod.setPesquisa(jTextFieldNomeProduto.getText());
             preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa() + "%'");
            jTextFieldNomeProduto.setEnabled(false);
            jTextFieldValorPortaria.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jTextFieldPesquisar.setEnabled(true);
            jButtonPesquisar.setEnabled(true);
            jTextFieldCheio.setEnabled(false);
            jTextFieldVazio.setEnabled(false);
            jTextFieldCasco.setEnabled(false);
            jTextFieldtele.setEnabled(false);
            jTextFieldCusto.setEnabled(false);
            jTextFieldCustoCasco.setEnabled(false);
        jTextFieldCustoCasco.setText("");
            jTextFieldtele.setText("");
            jTextFieldCasco.setText("");
            jTextFieldCheio.setText("");
            jTextFieldVazio.setText("");
            jTextFieldValorPortaria.setText("");
            jTextFieldPesquisar.setText("");
            jTextFieldID.setText("");
            jTextFieldCusto.setText("");
            jTextFieldNomeProduto.setText("");
            
        } else {
            mod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
            mod.setNomeProduto(jTextFieldNomeProduto.getText());
            mod.setPrecoProduto(Double.parseDouble(jTextFieldValorPortaria.getText()));
            mod.setCheo(Integer.parseInt(jTextFieldCheio.getText()));
            mod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
            mod.setValorCasco(jTextFieldCasco.getText());
            mod.setValorTele(Double.parseDouble(jTextFieldtele.getText()));
            mod.setPrecocusto(Double.parseDouble(jTextFieldCusto.getText()));
            mod.setCustoCasco(Double.parseDouble(jTextFieldCustoCasco.getText()));
            control.Editar(mod);
             mod.setPesquisa(jTextFieldNomeProduto.getText());
             preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa() + "%'");
            jTextFieldNomeProduto.setEnabled(false);
            jTextFieldValorPortaria.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jTextFieldPesquisar.setEnabled(true);
            jButtonPesquisar.setEnabled(true);
            jTextFieldCheio.setEnabled(false);
            jTextFieldVazio.setEnabled(false);
            jTextFieldCasco.setEnabled(false);
            jTextFieldtele.setEnabled(false);
            jTextFieldCusto.setEnabled(false);
            jTextFieldCustoCasco.setEnabled(false);
            jTextFieldCustoCasco.setText("");
            jTextFieldtele.setText("");
            jTextFieldCasco.setText("");
            jTextFieldCheio.setText("");
            jTextFieldVazio.setText("");
            jTextFieldValorPortaria.setText("");
            jTextFieldPesquisar.setText("");
            jTextFieldID.setText("");
            jTextFieldNomeProduto.setText("");
            jTextFieldCusto.setText("");
          
        }
       
        
    
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        jTextFieldNomeProduto.setEnabled(true);
        jTextFieldValorPortaria.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        jTextFieldCheio.setEnabled(true);
        jTextFieldVazio.setEnabled(true);
        jTextFieldCasco.setEnabled(true);
        jTextFieldtele.setEnabled(true);
        jTextFieldCusto.setEnabled(true);
        jTextFieldCustoCasco.setEnabled(true);
        jTextFieldPesquisar.setText("");
        jTextFieldNomeProduto.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldNomeProduto.setEnabled(false);
        jTextFieldValorPortaria.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jTextFieldCheio.setEnabled(false);
        jTextFieldVazio.setEnabled(false);
        jTextFieldCasco.setEnabled(false);
        jTextFieldtele.setEnabled(false);
        jTextFieldtele.setEnabled(false);
        jTextFieldCusto.setEnabled(false);
        jTextFieldCusto.setEnabled(false);
        jTextFieldCustoCasco.setEnabled(false);
        jTextFieldCustoCasco.setText("");
        jTextFieldtele.setText("");
        jTextFieldtele.setText("");
        jTextFieldCasco.setText("");
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldValorPortaria.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldID.setText("");
        jTextFieldNomeProduto.setText("");
        jTextFieldCusto.setText("");
        jTextFieldCusto.setText("");
       

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        mod.setPesquisa(jTextFieldPesquisar.getText());
         preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa() + "%'");
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
         BeansProdutos model = control.PesquisarProduto(mod); 
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
        String cliente_nome = "" + jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from produtos where nome_produto='" + cliente_nome + "'");
        try {
            conex.rs.first();
            jTextFieldID.setText(String.valueOf(conex.rs.getInt("cod_produto")));
            jTextFieldNomeProduto.setText(conex.rs.getString("nome_produto"));
            jTextFieldValorPortaria.setText(conex.rs.getString("valor_produtoc"));
            jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
            jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
            jTextFieldCasco.setText(String.valueOf(conex.rs.getDouble("valor_casco")));
            jTextFieldtele.setText(String.valueOf(conex.rs.getDouble("valor_tele")));
            jTextFieldCusto.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
            jTextFieldCustoCasco.setText(String.valueOf(conex.rs.getDouble("custo_casco")));
            jTextFieldNomeProduto.setEnabled(false);
        jTextFieldValorPortaria.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        jTextFieldCheio.setEnabled(false);
        jTextFieldVazio.setEnabled(false);
        jTextFieldCasco.setEnabled(false);
        jTextFieldtele.setEnabled(false);
        jTextFieldtele.setEnabled(false);
        jTextFieldCusto.setEnabled(false);
        jTextFieldCusto.setEnabled(false);
        jTextFieldCustoCasco.setEnabled(false);

            jTextFieldPesquisar.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
        }
        conex.Desconecta();
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir da lista de produtos o produto " + jTextFieldNomeProduto.getText());
        if (resposta == JOptionPane.YES_OPTION) {
            mod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
            control.Excluir(mod);
             mod.setPesquisa(jTextFieldNomeProduto.getText());
             preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa() + "%'");
            jTextFieldNomeProduto.setText("");
            jTextFieldID.setText("");
            jTextFieldValorPortaria.setText("");
            jTextFieldCheio.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCasco.setText("");
            jTextFieldtele.setEnabled(false);
            jTextFieldtele.setText("");
            jTextFieldCustoCasco.setEnabled(false);
        jTextFieldCustoCasco.setText("");
            jButtonCancelar.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jTextFieldPesquisar.setEnabled(true);
            jButtonPesquisar.setEnabled(true);
            jTextFieldPesquisar.setText("");
            jTextFieldCusto.setText("");
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag = 2;
        jTextFieldNomeProduto.setEnabled(true);
        jTextFieldValorPortaria.setEnabled(true);
        jTextFieldCheio.setEnabled(true);
        jTextFieldVazio.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        jTextFieldCasco.setEnabled(true);
        jTextFieldtele.setEnabled(true);
        jTextFieldCusto.setEnabled(true);
        jTextFieldCustoCasco.setEnabled(true);       
        jTextFieldPesquisar.setText("");
       
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldVazioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVazioActionPerformed

    }//GEN-LAST:event_jTextFieldVazioActionPerformed

    private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseEntered
  try {  
    Integer.parseInt(jTextFieldCheio.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldCheio.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade cheia somente pode receber numeros inteiros ex: 50");  
    jTextFieldCheio.setText("");
    jTextFieldCheio.requestFocus(); 
        }
    }
  try {  
    Integer.parseInt(jTextFieldVazio.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldVazio.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade vazia somente pode receber numeros inteiros ex: 50");  
    jTextFieldVazio.setText("");
    jTextFieldVazio.requestFocus(); 
        }
    }
 try {  
    Double.parseDouble(jTextFieldValorPortaria.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldValorPortaria.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor portaria somente pode receber numeros reais ex: 50.31");  
    jTextFieldValorPortaria.setText("");
    jTextFieldValorPortaria.requestFocus(); 
        }
    }
 try {  
    Double.parseDouble(jTextFieldtele.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldtele.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor tele-entrega somente pode receber numeros reais ex: 50.31");  
    jTextFieldtele.setText("");
    jTextFieldtele.requestFocus(); 
        }
    }
 try {  
    Double.parseDouble(jTextFieldCasco.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldCasco.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor com casco somente pode receber numeros reais ex: 50.31");  
    jTextFieldCasco.setText("");
    jTextFieldCasco.requestFocus(); 
        }
    }
 try {  
    Double.parseDouble(jTextFieldCusto.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldCusto.getText())){
    JOptionPane.showMessageDialog(null, "O campo preço de custo somente pode receber numeros reais ex: 50.31");  
    jTextFieldCusto.setText("");
    jTextFieldCusto.requestFocus(); 
        }
    }
  try {  
    Double.parseDouble(jTextFieldCustoCasco.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldCustoCasco.getText())){
    JOptionPane.showMessageDialog(null, "O campo custo do casco somente pode receber numeros reais ex: 50.31");  
    jTextFieldCustoCasco.setText("");
    jTextFieldCustoCasco.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonSalvarMouseEntered

    private void jTextFieldValorPortariaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldValorPortariaMouseExited
    
    }//GEN-LAST:event_jTextFieldValorPortariaMouseExited

    private void jTextFieldValorPortariaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldValorPortariaMouseReleased
      
    }//GEN-LAST:event_jTextFieldValorPortariaMouseReleased

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
  
    }//GEN-LAST:event_jPanel2MouseEntered

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Produto", "Valor", "Valor tele", "Valor do casco", "Preço de custo","Custo do casco", "Cheios", "Vazios"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("cod_produto"), conex.rs.getString("nome_produto"), conex.rs.getString("valor_produtoc"), conex.rs.getString("valor_tele"), conex.rs.getString("valor_casco"), conex.rs.getDouble("preco_custo"),conex.rs.getDouble("custo_casco"), conex.rs.getString("cheio"), conex.rs.getString("vazio")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
           
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableProdutos.setModel(modelo);
        jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTableProdutos.getColumnModel().getColumn(3).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableProdutos.getColumnModel().getColumn(4).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableProdutos.getColumnModel().getColumn(5).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTableProdutos.getColumnModel().getColumn(6).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTableProdutos.getColumnModel().getColumn(7).setResizable(false);
        jTableProdutos.getColumnModel().getColumn(8).setPreferredWidth(70);
        jTableProdutos.getColumnModel().getColumn(8).setResizable(false);
        jTableProdutos.getTableHeader().setReorderingAllowed(false);
        jTableProdutos.setAutoResizeMode(jTableProdutos.AUTO_RESIZE_OFF);
        jTableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDeMercadoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCusto;
    private javax.swing.JTextField jTextFieldCustoCasco;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldValorPortaria;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField jTextFieldtele;
    // End of variables declaration//GEN-END:variables
}
