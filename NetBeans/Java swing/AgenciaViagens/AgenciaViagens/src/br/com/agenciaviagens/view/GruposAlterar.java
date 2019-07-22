package br.com.agenciaviagens.view;

import br.com.agenciaviagens.dao.GrupoDao;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.util.UtilitarioDao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GruposAlterar extends javax.swing.JDialog {

    int codigo;
    Empresa empresa;

    public GruposAlterar(java.awt.Frame parent, boolean modal, int e,Empresa p) {
        super(parent, modal);
        initComponents();
        codigo = e;
        empresa = p;
        preencherCampos();
    }

    private void preencherCampos() {
        GrupoDao dao = new GrupoDao();
        Grupo grupo = dao.buscarCodigo(codigo,empresa);
        jTextField1.setText(grupo.getNome_grupo());
        jDateChooser1.setDate(grupo.getData());
        jTextFieldPax.setText(String.valueOf(grupo.getPax()));
        jTextFieldFixos.setText(String.valueOf(grupo.getCusto_fixo()));
        jTextFieldRelativo.setText(String.valueOf(grupo.getCusto_relativo()));
        jTextFieldValorVenda.setText(String.valueOf(grupo.getValor_venda()));
        jTextFieldTripulacao.setText(String.valueOf(grupo.getTripulacao()));
        jTextFieldAgregados.setText(String.valueOf(grupo.getAgregados()));
        jTextAreaAtividades.setText(grupo.getAtividades());
    }

    private GruposAlterar(JFrame jFrame, boolean b) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFixos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRelativo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldValorVenda = new javax.swing.JTextField();
        jTextFieldTripulacao = new javax.swing.JTextField();
        jTextFieldAgregados = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAtividades = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Nome");

        jLabel3.setText("Data");

        jLabel4.setText("Numero de passageiros");

        jLabel5.setText("Valores fixos");

        jLabel6.setText("Valores relativos");

        jLabel7.setText("Valor de venda");

        jLabel8.setText("Tripulação");

        jLabel9.setText("Passageiros agregados");

        jTextAreaAtividades.setColumns(20);
        jTextAreaAtividades.setLineWrap(true);
        jTextAreaAtividades.setRows(5);
        jTextAreaAtividades.setBorder(javax.swing.BorderFactory.createTitledBorder("Atividades previstas no grupo"));
        jScrollPane1.setViewportView(jTextAreaAtividades);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPax, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jTextFieldFixos)
                            .addComponent(jTextFieldRelativo)
                            .addComponent(jTextFieldValorVenda)
                            .addComponent(jTextFieldTripulacao)
                            .addComponent(jTextFieldAgregados))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTripulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFixos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoConfirmar.png"))); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.setToolTipText("Criar novo grupo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/botaoCancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setToolTipText("Cancelar grupo");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenciaviagens/imagens/calculadora.png"))); // NOI18N
        jButton3.setText("Calcular possibilidade de lucro");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criação de grupos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            Integer.parseInt(jTextFieldPax.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPax.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de passageiros somente pode receber numeros inteiros ex: 50");
                jTextFieldPax.setText("");
                jTextFieldPax.requestFocus();
            }
        }

        try {
            Integer.parseInt(jTextFieldTripulacao.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldTripulacao.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de trupulantes somente pode receber numeros inteiros ex: 50");
                jTextFieldTripulacao.setText("");
                jTextFieldTripulacao.requestFocus();
            }
        }

        try {
            Integer.parseInt(jTextFieldAgregados.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldAgregados.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de passageiros agregados somente pode receber numeros inteiros ex: 50");
                jTextFieldAgregados.setText("");
                jTextFieldAgregados.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldFixos.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldFixos.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor fixo somente pode receber numeros reais ex: 50.50");
                jTextFieldFixos.setText("");
                jTextFieldFixos.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldRelativo.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldRelativo.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor relativo somente pode receber numeros reais ex: 50.50");
                jTextFieldRelativo.setText("");
                jTextFieldRelativo.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldValorVenda.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValorVenda.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor de venda somente pode receber numeros reais ex: 50.50");
                jTextFieldValorVenda.setText("");
                jTextFieldValorVenda.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTextFieldPax.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo numero de passageiros");
            jTextFieldPax.requestFocus();
        } else if (jTextFieldFixos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo valor fixo");
            jTextFieldFixos.requestFocus();
        } else if (jTextFieldRelativo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo valor relativo");
            jTextFieldRelativo.requestFocus();
        } else if (jTextFieldValorVenda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo valor de venda");
            jTextFieldValorVenda.requestFocus();
        } else if (jTextFieldTripulacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo numero de tripulação");
            jTextFieldTripulacao.requestFocus();
        } else if (jTextFieldAgregados.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo passageiros agregados");
            jTextFieldAgregados.requestFocus();

        } else {
            UtilitarioDao util = new UtilitarioDao();
            double Apurado = Double.parseDouble(jTextFieldValorVenda.getText()) * (Integer.parseInt(jTextFieldPax.getText()) - (Integer.parseInt(jTextFieldTripulacao.getText()) + Integer.parseInt(jTextFieldAgregados.getText())));
            double custo = (Double.parseDouble(jTextFieldRelativo.getText()) * (Integer.parseInt(jTextFieldPax.getText()) - Integer.parseInt(jTextFieldTripulacao.getText()))) + Double.parseDouble(jTextFieldFixos.getText());
            JOptionPane.showMessageDialog(rootPane, "A possibilidade de lucro neste grupo é de " + util.DecimalFormat(Apurado - custo));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo nome do grupo");
            jTextField1.requestFocus();
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo data");
        } else if (jTextFieldPax.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo numero de passageiros");
            jTextFieldPax.requestFocus();
        } else if (jTextFieldFixos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o compo valor fixo");
            jTextFieldFixos.requestFocus();
        } else if (jTextFieldRelativo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o compo valor relativo");
            jTextFieldRelativo.requestFocus();
        } else if (jTextFieldValorVenda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o compo valor de venda");
            jTextFieldValorVenda.requestFocus();
        } else if (jTextFieldTripulacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo numero de tripulação");
            jTextFieldTripulacao.requestFocus();
        } else if (jTextFieldAgregados.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo passageiros agregados");
            jTextFieldAgregados.requestFocus();
        } else if (jTextAreaAtividades.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo atividades previstas");
            jTextAreaAtividades.requestFocus();
        } else {
            Grupo grupo = new Grupo();
            grupo.setCusto_fixo(Double.parseDouble(jTextFieldFixos.getText()));
            grupo.setCusto_relativo(Double.parseDouble(jTextFieldRelativo.getText()));
            grupo.setData(jDateChooser1.getDate());
            grupo.setNome_grupo(jTextField1.getText());
            grupo.setPax(Integer.parseInt(jTextFieldPax.getText()));
            grupo.setSituacao("Andamento");
            grupo.setValor_venda(Double.parseDouble(jTextFieldValorVenda.getText()));
            grupo.setAtividades(jTextAreaAtividades.getText());
            grupo.setAgregados(Integer.parseInt(jTextFieldAgregados.getText()));
            grupo.setTripulacao(Integer.parseInt(jTextFieldTripulacao.getText()));
            grupo.setCodigo(codigo);
            GrupoDao dao = new GrupoDao();
            dao.Alterar(grupo,empresa);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        try {
            Integer.parseInt(jTextFieldPax.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldPax.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de passageiros somente pode receber numeros inteiros ex: 50");
                jTextFieldPax.setText("");
                jTextFieldPax.requestFocus();
            }
        }

        try {
            Integer.parseInt(jTextFieldTripulacao.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldTripulacao.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de trupulantes somente pode receber numeros inteiros ex: 50");
                jTextFieldTripulacao.setText("");
                jTextFieldTripulacao.requestFocus();
            }
        }

        try {
            Integer.parseInt(jTextFieldAgregados.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldAgregados.getText())) {
                JOptionPane.showMessageDialog(null, "O campo numero de passageiros agregados somente pode receber numeros inteiros ex: 50");
                jTextFieldAgregados.setText("");
                jTextFieldAgregados.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldFixos.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldFixos.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor fixo somente pode receber numeros reais ex: 50.50");
                jTextFieldFixos.setText("");
                jTextFieldFixos.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldRelativo.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldRelativo.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor relativo somente pode receber numeros reais ex: 50.50");
                jTextFieldRelativo.setText("");
                jTextFieldRelativo.requestFocus();
            }
        }
        try {
            Double.parseDouble(jTextFieldValorVenda.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValorVenda.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor de venda somente pode receber numeros reais ex: 50.50");
                jTextFieldValorVenda.setText("");
                jTextFieldValorVenda.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton3MouseEntered

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
            java.util.logging.Logger.getLogger(GruposAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GruposAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GruposAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GruposAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GruposAlterar dialog = new GruposAlterar(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAtividades;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAgregados;
    private javax.swing.JTextField jTextFieldFixos;
    private javax.swing.JTextField jTextFieldPax;
    private javax.swing.JTextField jTextFieldRelativo;
    private javax.swing.JTextField jTextFieldTripulacao;
    private javax.swing.JTextField jTextFieldValorVenda;
    // End of variables declaration//GEN-END:variables
}
