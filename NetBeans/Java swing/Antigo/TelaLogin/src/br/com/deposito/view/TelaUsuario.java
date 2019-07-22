package br.com.deposito.view;

import br.com.deposito.dao.UsuarioDao;
import br.com.deposito.domain.Usuario;
import br.com.deposito.model.ModeloTabela;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaUsuario extends javax.swing.JFrame {

    private final UsuarioDao dao = new UsuarioDao();

    public TelaUsuario() {
        initComponents();
        lista = dao.listar("Usuario.listar");
        preencherTabela(lista);
    }

    private List<Usuario> lista;

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
        jPanelAlterar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelRemover = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelAcesso = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePadrao = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPesquisar1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de clientes");
        setResizable(false);

        jPanelbg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(54, 33, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de usuários");

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
        jLabel4.setText("Registrar usuário");

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

        jPanelAlterar.setBackground(new java.awt.Color(85, 65, 118));
        jPanelAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelAlterarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelAlterarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelAlterarMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/alterar_registro.gif"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alterar usuário");

        javax.swing.GroupLayout jPanelAlterarLayout = new javax.swing.GroupLayout(jPanelAlterar);
        jPanelAlterar.setLayout(jPanelAlterarLayout);
        jPanelAlterarLayout.setHorizontalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAlterarLayout.setVerticalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        jPanelRemover.setBackground(new java.awt.Color(85, 65, 118));
        jPanelRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRemoverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelRemoverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelRemoverMouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/delete.gif"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Remover usuário");

        javax.swing.GroupLayout jPanelRemoverLayout = new javax.swing.GroupLayout(jPanelRemover);
        jPanelRemover.setLayout(jPanelRemoverLayout);
        jPanelRemoverLayout.setHorizontalGroup(
            jPanelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRemoverLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRemoverLayout.setVerticalGroup(
            jPanelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRemoverLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );

        jPanelAcesso.setBackground(new java.awt.Color(85, 65, 118));
        jPanelAcesso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelAcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelAcessoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelAcessoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelAcessoMouseExited(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/control_panel (2).png"))); // NOI18N

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Controle de acesso");

        javax.swing.GroupLayout jPanelAcessoLayout = new javax.swing.GroupLayout(jPanelAcesso);
        jPanelAcesso.setLayout(jPanelAcessoLayout);
        jPanelAcessoLayout.setHorizontalGroup(
            jPanelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcessoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAcessoLayout.setVerticalGroup(
            jPanelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAcessoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanelAcesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanelAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel4.setBackground(new java.awt.Color(122, 72, 221));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/deposito/icones/pesquisar.png"))); // NOI18N

        jTextFieldPesquisar1.setBackground(new java.awt.Color(122, 72, 221));
        jTextFieldPesquisar1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jTextFieldPesquisar1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPesquisar1.setToolTipText("Sua pesquisa");
        jTextFieldPesquisar1.setBorder(null);
        jTextFieldPesquisar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldPesquisar1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextFieldPesquisar1MouseReleased(evt);
            }
        });
        jTextFieldPesquisar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisar1KeyReleased(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(317, 317, 317))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanelbgLayout = new javax.swing.GroupLayout(jPanelbg);
        jPanelbg.setLayout(jPanelbgLayout);
        jPanelbgLayout.setHorizontalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelbgLayout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanelbgLayout.setVerticalGroup(
            jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbgLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelbgLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseEntered
        jPanelNovo.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelNovoMouseEntered

    private void jPanelNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseExited
        jPanelNovo.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelNovoMouseExited

    private void jPanelNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNovoMouseClicked
        TelaUsuarioCadastro dialog = new TelaUsuarioCadastro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jPanelNovoMouseClicked

    private void jPanelAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlterarMouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para altera-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            TelaUsuarioCadastro dialog = new TelaUsuarioCadastro(new javax.swing.JFrame(), true, lista.get(jTablePadrao.getSelectedRow()));
            dialog.setVisible(true);
            pesquisar();
            jTextFieldPesquisar1.requestFocus();
        }
    }//GEN-LAST:event_jPanelAlterarMouseClicked

    private void jPanelAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlterarMouseEntered
        jPanelAlterar.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelAlterarMouseEntered

    private void jPanelAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlterarMouseExited
        jPanelAlterar.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelAlterarMouseExited

    private void jPanelRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRemoverMouseClicked
        if (lista == null || lista.size() < 1 || jTablePadrao.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para remove-lo", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente remover " + lista.get(jTablePadrao.getSelectedRow()).getNome());
            if (resposta == JOptionPane.YES_OPTION) {
                dao.excluir(lista.get(jTablePadrao.getSelectedRow()));
                jTextFieldPesquisar1.requestFocus();
            }
            pesquisar();
        }
    }//GEN-LAST:event_jPanelRemoverMouseClicked

    private void jPanelRemoverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRemoverMouseEntered
        jPanelRemover.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelRemoverMouseEntered

    private void jPanelRemoverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRemoverMouseExited
        jPanelRemover.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelRemoverMouseExited

    private void jTextFieldPesquisar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPesquisar1MouseEntered

    }//GEN-LAST:event_jTextFieldPesquisar1MouseEntered

    private void jTextFieldPesquisar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPesquisar1MouseReleased

    }//GEN-LAST:event_jTextFieldPesquisar1MouseReleased

    private void jTextFieldPesquisar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisar1KeyReleased
        pesquisar();
    }//GEN-LAST:event_jTextFieldPesquisar1KeyReleased

    private void jPanelAcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAcessoMouseClicked

    }//GEN-LAST:event_jPanelAcessoMouseClicked

    private void jPanelAcessoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAcessoMouseEntered
        jPanelAcesso.setBackground(new Color(58, 100, 100));
    }//GEN-LAST:event_jPanelAcessoMouseEntered

    private void jPanelAcessoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAcessoMouseExited
        jPanelAcesso.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jPanelAcessoMouseExited

    private void pesquisar() {
        lista = dao.listar("Usuario.listarNome", "nome", jTextFieldPesquisar1.getText());
        preencherTabela(lista);
    }

    private void preencherTabela(List<Usuario> ls) {
        String[] colunas = new String[]{"Codigo", "Nome", "Email", "Tipo"};
        ArrayList dados = new ArrayList();
        if (ls == null || ls.size() < 1) {
            dados.add(new Object[]{"Nenhum registro encontrado", "", "", ""});
        } else {
            for (Usuario c : ls) {
                dados.add(new Object[]{c.getCodigo(), c.getNome(), c.getEmail(), c.getTipo()});
            }
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePadrao.setModel(modelo);
        jTablePadrao.getColumnModel().getColumn(0).setPreferredWidth(170);
        jTablePadrao.getColumnModel().getColumn(0).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(1).setPreferredWidth(260);
        jTablePadrao.getColumnModel().getColumn(1).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(2).setPreferredWidth(260);
        jTablePadrao.getColumnModel().getColumn(2).setResizable(false);
        jTablePadrao.getColumnModel().getColumn(3).setPreferredWidth(210);
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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelAcesso;
    private javax.swing.JPanel jPanelAlterar;
    private javax.swing.JPanel jPanelNovo;
    private javax.swing.JPanel jPanelRemover;
    private javax.swing.JPanel jPanelbg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePadrao;
    private javax.swing.JTextField jTextFieldPesquisar1;
    // End of variables declaration//GEN-END:variables
}
