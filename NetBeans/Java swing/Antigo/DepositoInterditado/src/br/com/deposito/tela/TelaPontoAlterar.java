package br.com.deposito.tela;

import br.com.deposito.dao.FuncionarioDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaPontoAlterar extends javax.swing.JDialog {

    int codigoAlterar;

    public TelaPontoAlterar(java.awt.Frame parent, boolean modal, int codigo) {
        super(parent, modal);
        initComponents();
        codigoAlterar = codigo;
    }

    private TelaPontoAlterar(JFrame jFrame, boolean b) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jTextFieldMes = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jTextFieldHora = new javax.swing.JTextField();
        jTextFieldMinuto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Dia");

        jLabel3.setText("Mês");

        jLabel4.setText("Ano");

        jLabel5.setText("Hora");

        jLabel6.setText("Minuto");

        jButton1.setText("Confirmar alteração");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alteração do horario do ponto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            int dia = Integer.parseInt(jTextFieldDia.getText());
            if (dia < 1 || dia > 31) {
                JOptionPane.showMessageDialog(null, "O campo dia não aceita valores menores que 1 e maiores que 31");
                jTextFieldDia.setText("");
                jTextFieldDia.requestFocus();
            }
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldDia.getText())) {
                JOptionPane.showMessageDialog(null, "O campo dia somente aceita numeros inteiros ex: 10");
                jTextFieldDia.setText("");
                jTextFieldDia.requestFocus();
            }
        }
        try {
            int mes = Integer.parseInt(jTextFieldMes.getText());
            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "O campo mês não aceita valores menores que 1 ou maiores que 12");
                jTextFieldMes.setText("");
                jTextFieldMes.requestFocus();
            }
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldMes.getText())) {
                JOptionPane.showMessageDialog(null, "O campo mês somente pode receber numeros inteiros ex: 12");
                jTextFieldMes.setText("");
                jTextFieldMes.requestFocus();
            }
        }
        try {
            Integer.parseInt(jTextFieldAno.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldAno.getText())) {
                JOptionPane.showMessageDialog(null, "O campo ano somente pode receber numeros inteiros ex: 2018");
                jTextFieldAno.setText("");
                jTextFieldAno.requestFocus();
            }
        }
        try {
            int hora = Integer.parseInt(jTextFieldHora.getText());
            if (hora < 0 || hora > 24) {
                JOptionPane.showMessageDialog(null, "O campo hora não aceita valores menores que 0 ou maiores que 24");
                jTextFieldHora.setText("");
                jTextFieldHora.requestFocus();
            }
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldHora.getText())) {
                JOptionPane.showMessageDialog(null, "O campo hora somente pode receber numeros inteiros ex: 18");
                jTextFieldHora.setText("");
                jTextFieldHora.requestFocus();
            }
        }
        try {
            int minuto = Integer.parseInt(jTextFieldMinuto.getText());
            if (minuto < 0 || minuto > 60) {
                JOptionPane.showMessageDialog(null, "O campo minuto não aceita valores menores que 0 ou maiores que 60");
                jTextFieldMinuto.setText("");
                jTextFieldMinuto.requestFocus();
            }
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldMinuto.getText())) {
                JOptionPane.showMessageDialog(null, "O campo minuto somente pode receber numeros inteiros ex: 59");
                jTextFieldMinuto.setText("");
                jTextFieldMinuto.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextFieldDia.getText().length() < 2 || jTextFieldDia.getText().length() > 2) {
            JOptionPane.showMessageDialog(rootPane, "O campo dia necessita ter 2 digitos");
        } else if (jTextFieldMes.getText().length() < 2 || jTextFieldMes.getText().length() > 2) {
            JOptionPane.showMessageDialog(rootPane, "O campo mês necessita ter 2 digitos");
        } else if (jTextFieldAno.getText().length() < 4 || jTextFieldAno.getText().length() > 4) {
            JOptionPane.showMessageDialog(rootPane, "O campo ano necessita ter 4 digitos");
        } else if (jTextFieldHora.getText().length() < 2 || jTextFieldHora.getText().length() > 2) {
            JOptionPane.showMessageDialog(rootPane, "O campo hora necessita ter 2 digitos");
        } else if (jTextFieldMinuto.getText().length() < 2 || jTextFieldMinuto.getText().length() > 2) {
            JOptionPane.showMessageDialog(rootPane, "O campo minuto necessita ter 2 digitos");
        } else {
            String data = jTextFieldDia.getText() + "/" + jTextFieldMes.getText() + "/" + jTextFieldAno.getText() + " " + jTextFieldHora.getText() + ":" + jTextFieldMinuto.getText();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            FuncionarioDao dao = new FuncionarioDao();
            try {
                Date NovaData = (Date) formatter.parse(data);
                dao.AlterarPonto(NovaData, codigoAlterar);
                dispose();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
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
            java.util.logging.Logger.getLogger(TelaPontoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPontoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPontoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPontoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPontoAlterar dialog = new TelaPontoAlterar(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldMinuto;
    // End of variables declaration//GEN-END:variables
}
