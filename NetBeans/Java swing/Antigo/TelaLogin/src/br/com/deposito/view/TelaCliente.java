package br.com.deposito.view;

import br.com.deposito.dao.ClienteDao;
import br.com.deposito.domain.Cliente;
import br.com.deposito.model.ModeloTabela;
import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaCliente extends javax.swing.JFrame {

    private final ClienteDao dao = new ClienteDao();

    public TelaCliente() {
        initComponents();
        preencherTabela2();
        jTextFieldPesquisar.requestFocus();
    }

    private List<Cliente> lista;

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
        jPanelNovo3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanelNovo4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelNovo5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanelNovo6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonRg = new javax.swing.JRadioButton();
        jRadioButtonCpf = new javax.swing.JRadioButton();
        jRadioButtonBairro = new javax.swing.JRadioButton();
        jRadioButtonTelefone = new javax.swing.JRadioButton();
        jRadioButtonCidade = new javax.swing.JRadioButton();
        jRadioButtonRua = new javax.swing.JRadioButton();
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
        jLabel1.setText("Tela de clientes");

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
        jLabel4.setText("Registrar cliente");

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
        jLabel6.setText("Alterar cliente");

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
        jLabel8.setText("Remover cliente");

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

        jPanelNovo3.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo3MouseExited(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/mail_unread (2).png"))); // NOI18N

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enviar e-mail");

        javax.swing.GroupLayout jPanelNovo3Layout = new javax.swing.GroupLayout(jPanelNovo3);
        jPanelNovo3.setLayout(jPanelNovo3Layout);
        jPanelNovo3Layout.setHorizontalGroup(
            jPanelNovo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo3Layout.setVerticalGroup(
            jPanelNovo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(15, 15, 15))
        );

        jPanelNovo4.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo4MouseExited(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/whatsapp_24_black.png"))); // NOI18N

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enviar whatsapp");

        javax.swing.GroupLayout jPanelNovo4Layout = new javax.swing.GroupLayout(jPanelNovo4);
        jPanelNovo4.setLayout(jPanelNovo4Layout);
        jPanelNovo4Layout.setHorizontalGroup(
            jPanelNovo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo4Layout.setVerticalGroup(
            jPanelNovo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel12)
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
        jLabel14.setText("Histórico de compras");

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

        jPanelNovo6.setBackground(new java.awt.Color(85, 65, 118));
        jPanelNovo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNovo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNovo6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelNovo6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelNovo6MouseExited(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/business_people_01 (2).png"))); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Detalhes do cliente");

        javax.swing.GroupLayout jPanelNovo6Layout = new javax.swing.GroupLayout(jPanelNovo6);
        jPanelNovo6.setLayout(jPanelNovo6Layout);
        jPanelNovo6Layout.setHorizontalGroup(
            jPanelNovo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNovo6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNovo6Layout.setVerticalGroup(
            jPanelNovo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNovo6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNovo6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanelNovo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNovo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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

        jRadioButtonBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonBairro.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonBairro.setText("Busca por bairro");
        jRadioButtonBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBairroActionPerformed(evt);
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

        jRadioButtonCidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonCidade.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCidade.setText("Busca por cidade");
        jRadioButtonCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCidadeActionPerformed(evt);
            }
        });

        jRadioButtonRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonRua.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRua.setText("Busca por rua");
        jRadioButtonRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(380, 380, 380))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jRadioButtonNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonRg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonCidade)
                .addGap(4, 4, 4)
                .addComponent(jRadioButtonBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonRua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonTelefone)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonNome)
                    .addComponent(jRadioButtonRg)
                    .addComponent(jRadioButtonCpf)
                    .addComponent(jRadioButtonCidade)
                    .addComponent(jRadioButtonRua)
                    .addComponent(jRadioButtonBairro)
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
                        .addComponent(jScrollPane1))
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
        TelaClienteCadastro dialog = new TelaClienteCadastro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jPanelNovoMouseClicked

    private void jPanelNovo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo1MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para altera-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            TelaClienteCadastro dialog = new TelaClienteCadastro(new javax.swing.JFrame(), true, lista.get(jTablePadrao.getSelectedRow()));
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

    private void jPanelNovo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo3MouseClicked
        if (lista == null || lista.size() < 1) {
            JOptionPane.showMessageDialog(this, "Não existem clientes na lista", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            ArrayList<String> emails = new ArrayList<>();
            for (Cliente c : lista) {
                if (!c.getEmail().equals("Não tem email")) {
                    emails.add(c.getEmail().toLowerCase());
                }
            }
            if (emails.size() > 0) {
                EnviarEmail dialog = new EnviarEmail(new javax.swing.JFrame(), true, emails);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Os clientes da lista não tem email cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jPanelNovo3MouseClicked

    private void jPanelNovo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo3MouseEntered
        jPanelNovo3.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo3MouseEntered

    private void jPanelNovo3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo3MouseExited
        jPanelNovo3.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo3MouseExited

    private void jPanelNovo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo4MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para falar pelo whatsapp", "Aviso", JOptionPane.WARNING_MESSAGE);
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
        }
    }//GEN-LAST:event_jPanelNovo4MouseClicked

    private void jPanelNovo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo4MouseEntered
        jPanelNovo4.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo4MouseEntered

    private void jPanelNovo4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo4MouseExited
        jPanelNovo4.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo4MouseExited

    private void jPanelNovo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para ter acesso a seu histórico", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jPanelNovo5MouseClicked

    private void jPanelNovo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseEntered
        jPanelNovo5.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo5MouseEntered

    private void jPanelNovo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo5MouseExited
        jPanelNovo5.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo5MouseExited

    private void jPanelNovo6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo6MouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para mais detalhes", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jPanelNovo6MouseClicked

    private void jPanelNovo6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo6MouseEntered
        jPanelNovo6.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovo6MouseEntered

    private void jPanelNovo6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovo6MouseExited
        jPanelNovo6.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovo6MouseExited

    private void jRadioButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNomeActionPerformed
        jRadioButtonNome.setSelected(true);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonNomeActionPerformed

    private void jRadioButtonRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRgActionPerformed
        jRadioButtonRg.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonRgActionPerformed

    private void jRadioButtonCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCpfActionPerformed
        jRadioButtonCpf.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonCpfActionPerformed

    private void jRadioButtonCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCidadeActionPerformed
        jRadioButtonCidade.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonCidadeActionPerformed

    private void jRadioButtonBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBairroActionPerformed
        jRadioButtonBairro.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonBairroActionPerformed

    private void jRadioButtonRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRuaActionPerformed
        jRadioButtonRua.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonTelefone.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonRuaActionPerformed

    private void jRadioButtonTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTelefoneActionPerformed
        jRadioButtonTelefone.setSelected(true);
        jRadioButtonNome.setSelected(false);
        jRadioButtonRg.setSelected(false);
        jRadioButtonCpf.setSelected(false);
        jRadioButtonBairro.setSelected(false);
        jRadioButtonCidade.setSelected(false);
        jRadioButtonRua.setSelected(false);
        jTextFieldPesquisar.requestFocus();
        jTextFieldPesquisar.setText("");
    }//GEN-LAST:event_jRadioButtonTelefoneActionPerformed

    private void pesquisar() {
        if (jRadioButtonNome.isSelected()) {
            lista = dao.listar("Clientes.listarNome", "nome", jTextFieldPesquisar.getText());
        } else if (jRadioButtonRg.isSelected()) {
            lista = dao.listar("Clientes.listarRg", "rg", jTextFieldPesquisar.getText());
        } else if (jRadioButtonRg.isSelected()) {
            lista = dao.listar("Clientes.listarCpf", "cpf", jTextFieldPesquisar.getText());
        } else if (jRadioButtonCidade.isSelected()) {
            lista = dao.listar("Clientes.listarCidade", "cidade", jTextFieldPesquisar.getText());
        } else if (jRadioButtonBairro.isSelected()) {
            lista = dao.listar("Clientes.listarBairro", "bairro", jTextFieldPesquisar.getText());
        } else if (jRadioButtonRua.isSelected()) {
            lista = dao.listar("Clientes.listarRua", "rua", jTextFieldPesquisar.getText());
        } else {
            lista = dao.listar("Clientes.listarTelefone", "telefone", jTextFieldPesquisar.getText());
        }
        preencherTabela(lista);
    }

    private void preencherTabela(List<Cliente> ls) {
        String[] colunas = new String[]{"Nome", "Rg", "Cpf", "Telefone", "Cidade", "Bairro"};
        ArrayList dados = new ArrayList();
        if (ls == null || ls.size() < 1) {
            dados.add(new Object[]{"Nenhum registro encontrado", "", "", "", "", ""});
        } else {
            for (Cliente c : ls) {
                dados.add(new Object[]{c.getNome(), c.getRg(), c.getCpf(), c.getTelefone(), c.getCidade(), c.getBairro()});
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
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTablePadrao.getColumnModel().getColumn(4).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(5).setPreferredWidth(155);
        jTablePadrao.getColumnModel().getColumn(5).setResizable(false);
        jTablePadrao.getTableHeader().setReorderingAllowed(false);
        jTablePadrao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTablePadrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void preencherTabela2() {
        String[] colunas = new String[]{"Nome", "Rg", "Cpf", "Telefone", "Cidade", "Bairro"};
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
        jTablePadrao.getColumnModel().getColumn(4).setPreferredWidth(150);
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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNovo;
    private javax.swing.JPanel jPanelNovo1;
    private javax.swing.JPanel jPanelNovo2;
    private javax.swing.JPanel jPanelNovo3;
    private javax.swing.JPanel jPanelNovo4;
    private javax.swing.JPanel jPanelNovo5;
    private javax.swing.JPanel jPanelNovo6;
    private javax.swing.JPanel jPanelbg;
    private javax.swing.JRadioButton jRadioButtonBairro;
    private javax.swing.JRadioButton jRadioButtonCidade;
    private javax.swing.JRadioButton jRadioButtonCpf;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JRadioButton jRadioButtonRg;
    private javax.swing.JRadioButton jRadioButtonRua;
    private javax.swing.JRadioButton jRadioButtonTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
