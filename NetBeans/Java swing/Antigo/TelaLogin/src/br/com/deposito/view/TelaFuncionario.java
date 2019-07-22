package br.com.deposito.view;

import br.com.deposito.dao.FuncionarioDao;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.model.ModeloTabela;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaFuncionario extends javax.swing.JFrame {

    private final FuncionarioDao dao = new FuncionarioDao();

    public TelaFuncionario() {
        initComponents();
        preencherTabela2();
        jTextFieldPesquisar.requestFocus();
    }

    private List<Funcionario> lista;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelbg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanelNovo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelNovo1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelNovo2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelNovo5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonRg = new javax.swing.JRadioButton();
        jRadioButtonCpf = new javax.swing.JRadioButton();
        jRadioButtonTelefone = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de clientes");
        setResizable(false);

        jPanelbg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(54, 33, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de funcionários");

        jPanelNovo.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovoMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/gravar_registro.gif"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar funcionário");

        javax.swing.GroupLayout jPanelNovoLayout = new javax.swing.GroupLayout(jPanelNovo);
        jPanelNovo.setLayout(jPanelNovoLayout);
        jPanelNovoLayout.setHorizontalGroup(
            jPanelNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovoLayout.setVerticalGroup(
            jPanelNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );

        jPanelNovo1.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo1MouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/alterar_registro.gif"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alterar funcionário");

        javax.swing.GroupLayout jPanelNovo1Layout = new javax.swing.GroupLayout(jPanelNovo1);
        jPanelNovo1.setLayout(jPanelNovo1Layout);
        jPanelNovo1Layout.setHorizontalGroup(
            jPanelNovo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo1Layout.setVerticalGroup(
            jPanelNovo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        jPanelNovo2.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo2MouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/delete.gif"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Remover funcionário");

        javax.swing.GroupLayout jPanelNovo2Layout = new javax.swing.GroupLayout(jPanelNovo2);
        jPanelNovo2.setLayout(jPanelNovo2Layout);
        jPanelNovo2Layout.setHorizontalGroup(
            jPanelNovo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo2Layout.setVerticalGroup(
            jPanelNovo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );

        jPanelNovo5.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo5MouseExited(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/address_book.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Histórico de vendas");

        javax.swing.GroupLayout jPanelNovo5Layout = new javax.swing.GroupLayout(jPanelNovo5);
        jPanelNovo5.setLayout(jPanelNovo5Layout);
        jPanelNovo5Layout.setHorizontalGroup(
            jPanelNovo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo5Layout.setVerticalGroup(
            jPanelNovo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanelNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(122, 72, 221));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/pesquisar.png"))); // NOI18N

        jTextFieldPesquisar.setBackground(new java.awt.Color(122, 72, 221));
        jTextFieldPesquisar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jTextFieldPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPesquisar.setToolTipText("Sua pesquisa");
        jTextFieldPesquisar.setBorder(null);
        jTextFieldPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldPesquisarMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextFieldPesquisarMouseReleased(evt);
            }
        });
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jRadioButtonNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonNome.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNome.setSelected(true);
        jRadioButtonNome.setText("Busca por nome");
        jRadioButtonNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNomeActionPerformed(evt);
            }
        });

        jRadioButtonRg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonRg.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRg.setText("Busca por rg");
        jRadioButtonRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRgActionPerformed(evt);
            }
        });

        jRadioButtonCpf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonCpf.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCpf.setText("Busca por cpf");
        jRadioButtonCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCpfActionPerformed(evt);
            }
        });

        jRadioButtonTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonTelefone.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonTelefone.setText("Busca por telefone");
        jRadioButtonTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(380, 380, 380))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jRadioButtonNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonRg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonTelefone)
                .addGap(305, 305, 305))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonNome)
                    .addComponent(jRadioButtonRg)
                    .addComponent(jRadioButtonCpf)
                    .addComponent(jRadioButtonTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

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
        jTablePadrao.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTablePadrao);

        javax.swing.GroupLayout jPanelbgLayout = new javax.swing.GroupLayout(jPanelbg);
        jPanelbg.setLayout(jPanelbgLayout);
        jPanelbgLayout.setHorizontalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelbgLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelbgLayout.setVerticalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addGroup(jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelbgLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarMouseReleased

    }//GEN-LAST:event_jTextFieldPesquisarMouseReleased

    private void jTextFieldPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarMouseEntered

    }//GEN-LAST:event_jTextFieldPesquisarMouseEntered

    private void jTextFieldPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyReleased
        pesquisar();
    }//GEN-LAST:event_jTextFieldPesquisarKeyReleased

    private void jPanelNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseEntered
        jPanelNovo.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovoMouseEntered

    private void jPanelNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseExited
        jPanelNovo.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovoMouseExited

    private void jPanelNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseClicked
        TelaFuncionarioCadastro dialog = new TelaFuncionarioCadastro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jPanelNovoMouseClicked

    private void jPanelNovo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para altera-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            TelaFuncionarioCadastro dialog = new TelaFuncionarioCadastro(new javax.swing.JFrame(), true, lista.get(jTablePadrao.getSelectedRow()));
            dialog.setVisible(true);
            pesquisar();
            jTextFieldPesquisar.requestFocus();
        }
    }//GEN-LAST:event_jPanelNovo1MouseClicked

    private void jPanelNovo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseEntered
        jPanelNovo1.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo1MouseEntered

    private void jPanelNovo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseExited
        jPanelNovo1.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo1MouseExited

    private void jPanelNovo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para remove-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente remover " + lista.get(jTablePadrao.getSelectedRow()).getNome());
            if (resposta == JOptionPane.YES_OPTION) {
                dao.excluir(lista.get(jTablePadrao.getSelectedRow()));               
                jTextFieldPesquisar.requestFocus();
            }
             pesquisar();
        }
    }//GEN-LAST:event_jPanelNovo2MouseClicked

    private void jPanelNovo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseEntered
        jPanelNovo2.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo2MouseEntered

    private void jPanelNovo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo2MouseExited
        jPanelNovo2.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo2MouseExited

    private void jPanelNovo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para ter acesso a seu histórico", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jPanelNovo5MouseClicked

    private void jPanelNovo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseEntered
        jPanelNovo5.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo5MouseEntered

    private void jPanelNovo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseExited
        jPanelNovo5.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo5MouseExited

    private void jRadioButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNomeActionPerformed
        jRadioButtonNome.setSelected(true);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);        
        jRadioButtonTelefone.setSelected(false);        
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonNomeActionPerformed

    private void jRadioButtonRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRgActionPerformed
        jRadioButtonRg.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonCpf.setSelected(false);        
        jRadioButtonTelefone.setSelected(false);        
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonRgActionPerformed

    private void jRadioButtonCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCpfActionPerformed
        jRadioButtonCpf.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);       
        jRadioButtonTelefone.setSelected(false);     
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonCpfActionPerformed

    private void jRadioButtonTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTelefoneActionPerformed
        jRadioButtonTelefone.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);       
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonTelefoneActionPerformed

    private void pesquisar() {
        if (jRadioButtonNome.isSelected()) {
            lista = dao.listar("Funcionarios.listarNome", "nome", jTextFieldPesquisar.getText());
        } else if (jRadioButtonRg.isSelected()) {
            lista = dao.listar("Funcionarios.listarRg", "rg", jTextFieldPesquisar.getText());
        } else if (jRadioButtonRg.isSelected()) {
            lista = dao.listar("Funcionarios.listarCpf", "cpf", jTextFieldPesquisar.getText());        
        } else {
            lista = dao.listar("Funcionarios.listarTelefone", "telefone", jTextFieldPesquisar.getText());
        }
        preencherTabela(lista);
    }

    private void preencherTabela(List<Funcionario> ls) {
        String[] colunas = new String[]{"Nome", "Rg", "Cpf", "Telefone", "Função", "Nascimento"};
        ArrayList dados = new ArrayList();
        if (ls == null || ls.size() < 1) {
            dados.add(new Object[]{"Nenhum registro encontrado", "", "", "", "", ""});
        } else {
            for (Funcionario c : ls) {
                dados.add(new Object[]{c.getNome(), c.getRg(), c.getCpf(), c.getTelefone(), c.getFuncao(), c.getNascimento()});
            }
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(215);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(190);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(160);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(155);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void preencherTabela2() {
        String[] colunas = new String[]{"Nome", "Rg", "Cpf", "Telefone", "Função", "Nascimento"};
        ArrayList dados = new ArrayList();
        dados.add(new Object[]{"Nenhum registro encontrado", "", "", "", "", ""});
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(215);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(190);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTablePadrao.getColumnModel().getColumn(3).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(160);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(155);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNovo;
    private javax.swing.JPanel jPanelNovo1;
    private javax.swing.JPanel jPanelNovo2;
    private javax.swing.JPanel jPanelNovo5;
    private javax.swing.JPanel jPanelbg;
    private javax.swing.JRadioButton jRadioButtonCpf;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JRadioButton jRadioButtonRg;
    private javax.swing.JRadioButton jRadioButtonTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
