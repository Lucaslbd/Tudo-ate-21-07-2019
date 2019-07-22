package br.com.loja.telas.Empresa;

import br.com.loja.dao.EmpresaDao;
import br.com.loja.domain.Empresa;
import javax.swing.JOptionPane;

public class TelaEmpresa extends javax.swing.JFrame {

    Empresa empresa;

    public TelaEmpresa() {
        initComponents();
    }

    public TelaEmpresa(Empresa e) {
        initComponents();
        empresa = e;
        preencheCampos();
    }

    private boolean verificaModificacao() {
        boolean verifica = true;
        if (!jFormattedTextFieldCnpj.getText().equals(empresa.getCnpj())) {
            verifica = false;
        } else if (!jTextFieldcrt.getText().equals(empresa.getCrt())) {
            verifica = false;
        } else if (!jTextFieldCep.getText().equals(empresa.getCep())) {
            verifica = false;
        } else if (!jTextFieldRua.getText().equals(empresa.getRua())) {
            verifica = false;
        } else if (!jTextFieldNumero.getText().equals(empresa.getNumero())) {
            verifica = false;
        } else if (!jTextFieldInscricaoEstadual.getText().equals(empresa.getInscricaoEstadual())) {
            verifica = false;
        } else if (!jTextFieldRazaoSocial.getText().equals(empresa.getRazaoSocial())) {
            verifica = false;
        } else if (!jTextFieldFantasia.getText().equals(empresa.getNomeFantasia())) {
            verifica = false;
        } else if (!jTextFieldCidade.getText().equals(empresa.getCidade())) {
            verifica = false;
        } else if (!jTextFieldEmail.getText().equals(empresa.getEmail())) {
            verifica = false;
        } else if (!jTextFieldBairro.getText().equals(empresa.getBairro())) {
            verifica = false;
        } else if (!jTextFieldSenha.getText().equals(empresa.getSenha())) {
            verifica = false;
        }

        return verifica;
    }

    private void preencheCampos() {
        jFormattedTextFieldCnpj.setText(empresa.getCnpj());
        jTextFieldcrt.setText(empresa.getCrt());
        jTextFieldCep.setText(empresa.getCep());
        jTextFieldRua.setText(empresa.getRua());
        jTextFieldNumero.setText(empresa.getNumero());
        jTextFieldInscricaoEstadual.setText(empresa.getInscricaoEstadual());
        jTextFieldRazaoSocial.setText(empresa.getRazaoSocial());
        jTextFieldFantasia.setText(empresa.getNomeFantasia());
        jTextFieldCidade.setText(empresa.getCidade());
        jTextFieldEmail.setText(empresa.getEmail());
        jTextFieldBairro.setText(empresa.getBairro());
        jTextFieldSenha.setText(empresa.getSenha());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldCnpj = new javax.swing.JFormattedTextField();
        jTextFieldInscricaoEstadual = new javax.swing.JTextField();
        jTextFieldcrt = new javax.swing.JTextField();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldFantasia = new javax.swing.JTextField();
        jTextFieldCep = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Cnpj");

        jLabel3.setText("Inscrição estadual");

        jLabel4.setText("Crt");

        jLabel5.setText("Razão social");

        jLabel6.setText("Cep");

        jLabel7.setText("Cidade");

        jLabel8.setText("Email");

        jLabel9.setText("N°");

        jLabel13.setText("Nome fantasia");

        jLabel14.setText("Rua");

        jLabel10.setText("Bairro");

        jLabel11.setText("Senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldCep)
                    .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldcrt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRua)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextFieldEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldInscricaoEstadual)
                    .addComponent(jTextFieldBairro)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldcrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tela empresa");

        jButton1.setText("Alterar informações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean verifica = verificaModificacao();
        if (verifica) {
            JOptionPane.showMessageDialog(rootPane, "Não existem alterações no cadastro");
        } else {
            if (jFormattedTextFieldCnpj.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo cnpj não pode estar vazio");
            } else if (jTextFieldcrt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo crt não pode estar vazio");
            } else if (jTextFieldCep.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo cep não pode estar vazio");
            } else if (jTextFieldRua.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo rua não pode estar vazio");
            } else if (jTextFieldNumero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo numero não pode estar vazio");
            } else if (jTextFieldInscricaoEstadual.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo inscrição estadual não pode estar vazio");
            } else if (jTextFieldRazaoSocial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo razão social não pode estar vazio");
            } else if (jTextFieldFantasia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo nome fantasia não pode estar vazio");
            } else if (jTextFieldCidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo cidade não pode estar vazio");
            } else if (jTextFieldEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo email não pode estar vazio");
            } else if (jTextFieldBairro.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo bairro não pode estar vazio");
            } else if (jTextFieldSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo senha não pode estar vazio");
            } else {
                Empresa p = new Empresa();
                EmpresaDao dao = new EmpresaDao();
                p.setBairro(jTextFieldBairro.getText());
                p.setCep(jTextFieldCep.getText());
                p.setCidade(jTextFieldCidade.getText());
                p.setCnpj(jFormattedTextFieldCnpj.getText());
                p.setCrt(jTextFieldcrt.getText());
                p.setEmail(jTextFieldEmail.getText());
                p.setInscricaoEstadual(jTextFieldInscricaoEstadual.getText());
                p.setNomeFantasia(jTextFieldFantasia.getText());
                p.setNumero(jTextFieldNumero.getText());
                p.setRazaoSocial(jTextFieldRazaoSocial.getText());
                p.setRua(jTextFieldRua.getText());
                p.setSenha(jTextFieldSenha.getText());
                p.setCodigo(empresa.getCodigo());               
                dao.Alterar(p);
                JOptionPane.showMessageDialog(rootPane, "Após alterações no cadastro da empresa ou certificado digital o sistema deve ser reiniciado");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCnpj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFantasia;
    private javax.swing.JTextField jTextFieldInscricaoEstadual;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldcrt;
    // End of variables declaration//GEN-END:variables
}
