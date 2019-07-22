package View;

import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoGrupos;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class GrupoNovo extends javax.swing.JDialog {
 DaoGrupos dao = new DaoGrupos();
     ConexaoBD conex = new ConexaoBD();
     BeansGrupos grupos = new BeansGrupos();
     DecimalFormat df = new DecimalFormat("###,###,##0.00");
     int flag;
    
    public GrupoNovo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

     public void verificador(){
             try {
               String tabelaNome = jTextFieldNome.getText();
               String novo = tabelaNome.toUpperCase();
               conex.Conexao();
               conex.executaSql("select * from grupos_excursoes where nomemelhorado='"+ novo +"'");
               conex.rs.first();               
               String verifica =(conex.rs.getString("nomemelhorado"));                 
               flag =0;
              } catch (SQLException ex) {                    
               flag = 1;
          }
        conex.Desconecta();
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldvalorFixo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorOscilante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldVagas = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEstimado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome do grupo");

        jButton1.setText("Confirmar grupo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar grupo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Calculos de lucratividade"));

        jLabel3.setText("Valores fixos");

        jLabel4.setText("Valores oscilantes ");

        jLabel5.setText("Numero de vagas");

        jButton3.setText("Calcular informações do grupo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço estimado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldvalorFixo)
                    .addComponent(jTextFieldValorOscilante)
                    .addComponent(jTextFieldVagas)
                    .addComponent(jTextFieldEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldvalorFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldValorOscilante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Novo grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        try {
            Double.parseDouble(jTextFieldvalorFixo.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldvalorFixo.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valores fixos somente pode receber numeros reais ex: 50.50");
                jTextFieldvalorFixo.setText("");
                jTextFieldvalorFixo.requestFocus();
            }
        }
        try{
            Double.parseDouble(jTextFieldValorOscilante.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldValorOscilante.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valores oscilantes somente pode receber numeros reais ex: 50.50");
                jTextFieldValorOscilante.setText("");
                jTextFieldValorOscilante.requestFocus();
            }
        }
        try{
            Integer.parseInt(jTextFieldEstimado.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldEstimado.getText())) {
                JOptionPane.showMessageDialog(null, "O campo vagas somente pode receber numeros reais ex: 50.50");
                jTextFieldEstimado.setText("");
                jTextFieldEstimado.requestFocus();
            }
        }
        try{
            Integer.parseInt(jTextFieldVagas.getText());
        }catch (NumberFormatException e){
            if (!"".equals(jTextFieldVagas.getText())) {
                JOptionPane.showMessageDialog(null, "O campo vagas somente pode receber numeros inteiros ex: 50");
                jTextFieldVagas.setText("");
                jTextFieldVagas.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificador();
        if(jTextFieldNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"O campo nome do grupo não pode estar vazio");
            jTextFieldNome.requestFocus();
        }else if(jTextFieldvalorFixo.getText().isEmpty()|| Double.parseDouble(jTextFieldvalorFixo.getText())<0){
            JOptionPane.showMessageDialog(rootPane,"O campo valores fixos não pode esta vazio ou conter numeros menores que 0");
            jTextFieldvalorFixo.requestFocus();
        }else if(jTextFieldValorOscilante.getText().isEmpty()|| Double.parseDouble(jTextFieldValorOscilante.getText())<0){
            JOptionPane.showMessageDialog(rootPane,"O campo valores oscilantes não pode esta vazio ou conter numeros menores que 0");
            jTextFieldValorOscilante.requestFocus();
        }else if(jTextFieldVagas.getText().isEmpty()|| Double.parseDouble(jTextFieldVagas.getText())<1){
            JOptionPane.showMessageDialog(rootPane,"O campo numero de vagas não pode esta vazio ou conter numeros menores que 1");
            jTextFieldVagas.requestFocus();
        }else if(jTextFieldEstimado.getText().isEmpty()|| Double.parseDouble(jTextFieldEstimado.getText())<1){
            JOptionPane.showMessageDialog(rootPane,"O campo numero de vagas não pode esta vazio ou conter numeros menores que 1");
            jTextFieldEstimado.requestFocus();
        }else if(Double.parseDouble(jTextFieldValorOscilante.getText())>= Double.parseDouble(jTextFieldEstimado.getText())){
            JOptionPane.showMessageDialog(rootPane,"O campo valor oscilante não pode ser maior que o preço estimado");
            jTextFieldEstimado.requestFocus();
        }else if(flag == 0){
            JOptionPane.showMessageDialog(rootPane,"Este nome ja esta cadastrado em algum grupo");
        }else{
            String texto = jTextFieldNome.getText();
            String novo = texto.toUpperCase();
            grupos.setValoresFixos(Double.parseDouble(jTextFieldvalorFixo.getText()));
            grupos.setValoresOscilantes(Double.parseDouble(jTextFieldValorOscilante.getText()));
            grupos.setVagas(Integer.parseInt(jTextFieldVagas.getText()));
            grupos.setPrecoVenda(Double.parseDouble(jTextFieldEstimado.getText()));
            grupos.setNome(novo);
            dao.NovoGrupo(grupos);
            jTextFieldNome.setText("");
            jTextFieldvalorFixo.setText("");
            jTextFieldValorOscilante.setText("");
            jTextFieldVagas.setText("");
            jTextFieldEstimado.setText("");
            jTextFieldNome.requestFocus();
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTextFieldvalorFixo.getText().isEmpty()|| Double.parseDouble(jTextFieldvalorFixo.getText())<0){
            JOptionPane.showMessageDialog(rootPane,"O campo valores fixos não pode esta vazio ou conter numeros menores que 0");
            jTextFieldvalorFixo.requestFocus();
        }else if(jTextFieldValorOscilante.getText().isEmpty()|| Double.parseDouble(jTextFieldValorOscilante.getText())<0){
            JOptionPane.showMessageDialog(rootPane,"O campo valores oscilantes não pode esta vazio ou conter numeros menores que 0");
            jTextFieldValorOscilante.requestFocus();
        }else if(jTextFieldVagas.getText().isEmpty()|| Double.parseDouble(jTextFieldVagas.getText())<1){
            JOptionPane.showMessageDialog(rootPane,"O campo numero de vagas não pode esta vazio ou conter numeros menores que 1");
            jTextFieldVagas.requestFocus();
        }else if(jTextFieldEstimado.getText().isEmpty()|| Double.parseDouble(jTextFieldEstimado.getText())<1){
            JOptionPane.showMessageDialog(rootPane,"O campo numero de vagas não pode esta vazio ou conter numeros menores que 1");
            jTextFieldEstimado.requestFocus();
        }else if(Double.parseDouble(jTextFieldValorOscilante.getText())>= Double.parseDouble(jTextFieldEstimado.getText())){
            JOptionPane.showMessageDialog(rootPane,"O campo valor oscilante não pode ser maior que o preço estimado");
            jTextFieldEstimado.requestFocus();
        }else{
            double valorOscilante = Double.parseDouble(jTextFieldValorOscilante.getText());
            double valorFixo = Double.parseDouble(jTextFieldvalorFixo.getText());
            int lugares = Integer.parseInt(jTextFieldVagas.getText());
            double valorVenda = Double.parseDouble(jTextFieldEstimado.getText());

            double previa = (valorOscilante * lugares) + valorFixo;
            String d1 = df.format(previa);
            double ValorSemLucro = previa / lugares;
            String d2 = df.format(ValorSemLucro);
            double LucroIndividual = valorVenda - ValorSemLucro;
            String d3 = df.format(LucroIndividual);
            double lucro = LucroIndividual * lugares;
            String d4 = df.format(lucro);
            double calculoQtdNecessaria = valorVenda - valorOscilante;
            double apurado = valorVenda * lugares;
            String d5 = df.format(apurado);
            int numeroPagantes =1;
            for(double i=calculoQtdNecessaria; i<=valorFixo; i += calculoQtdNecessaria){
                ++numeroPagantes;
            }
            JOptionPane.showMessageDialog(rootPane,"*O custo do grupo é de R$ "+d1+"\n"
                +"*O preço de custo por passageiro é de R$ " +d2+"\n"
                +"*O lucro individual caso a venda seja realizada no valor de R$ "+jTextFieldEstimado.getText()+" é de R$ "+ d3+" por passageiro\n"
                +"*O numero minimo de passageiros para que os custos fixos sejam pagos é de "+numeroPagantes + " passageiros\n"
                +"*O valor apurado será de "+d5+"\n"
                +"*O lucro máximo que o grupo pode alcançar é de R$ "+d4);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(GrupoNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupoNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupoNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupoNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GrupoNovo dialog = new GrupoNovo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldEstimado;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldVagas;
    private javax.swing.JTextField jTextFieldValorOscilante;
    private javax.swing.JTextField jTextFieldvalorFixo;
    // End of variables declaration//GEN-END:variables
}
