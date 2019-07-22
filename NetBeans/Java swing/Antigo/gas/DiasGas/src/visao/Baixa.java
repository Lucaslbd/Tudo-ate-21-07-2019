package visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

import modeloBeans.BeansBaixa;
import modeloBeans.BeansProdutos;

import modeloConection.ConexaoBD;
import modeloDao.DaoBaixa;
import modeloDao.DaoProdutos;


public class Baixa extends javax.swing.JFrame {
    ConexaoBD conex = new ConexaoBD();
     BeansProdutos mod = new BeansProdutos();
     BeansBaixa baixa = new BeansBaixa();
       DaoProdutos control = new DaoProdutos();
       DaoBaixa baixar = new DaoBaixa();

  
    public Baixa() {
        initComponents();       
        
         Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
        String dtHoje;
         dtHoje = dateFormat.format(d); 
         jTextFieldData.setText(dtHoje);
    }
    public void PreencherDescricao(){
        conex.Conexao();
        conex.executaSql("SELECT DISTINCT motivo_baixa FROM baixas order by motivo_baixa");
    try {
        conex.rs.first();
        jComboBoxDescricao.removeAllItems();
        do{
            jComboBoxDescricao.addItem(conex.rs.getString("motivo_baixa"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
         
    }
        conex.Desconecta();
    }
 public void PreencherProdutos(){
        conex.Conexao();
        conex.executaSql("select * from produtos order by nome_produto");
    try {
        conex.rs.first();
        jComboBoxProduto.removeAllItems();
       
        do{
            jComboBoxProduto.addItem(conex.rs.getString("nome_produto"));
       }while(conex.rs.next());
    } catch (SQLException ex) {
          
    }
        conex.Desconecta();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldID = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldMotivoBaixa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jRadioButtonCasco = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDescricao = new javax.swing.JComboBox<>();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTextFieldID.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldValor.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSalvar.setText("Dar baixa");
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

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Descrição da baixa"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jTextFieldMotivoBaixa.setEnabled(false);
        jTextFieldMotivoBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMotivoBaixaActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir motivo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantidade");

        jTextFieldQuantidade.setEnabled(false);

        jLabel8.setText("Data");

        jTextFieldData.setEnabled(false);
        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        jRadioButtonCasco.setText("Baixa com casco");
        jRadioButtonCasco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonCasco.setEnabled(false);
        jRadioButtonCasco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCascoActionPerformed(evt);
            }
        });

        jLabel5.setText("Motivo");

        jLabel1.setText("Produto ");

        jComboBoxDescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxDescricao.setEnabled(false);
        jComboBoxDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxDescricaoMouseClicked(evt);
            }
        });

        jComboBoxProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxProduto.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMotivoBaixa)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jTextFieldData)
                    .addComponent(jComboBoxProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonCasco)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxDescricao, 0, 173, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonCasco)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMotivoBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBoxDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonNovo))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Baixa de mercadoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(215, 215, 215))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
//Começa o codigo de preenchimento
     
             String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
        conex.Conexao();
        conex.executaSql("select * from produtos where nome_produto='"+ cliente_nome +"'");
         if(jRadioButtonCasco.isSelected()){

           try {
               conex.rs.first();
               jTextFieldID.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("custo_casco")));
                         
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
        }else{
        try {
               conex.rs.first();
               jTextFieldID.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
                           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
    }     
    //aqui termina o codigo de preenchimento  
        
        
     if(jComboBoxProduto.getSelectedItem()== null){
         JOptionPane.showMessageDialog(null,"Ainda não existem produtos cadastrados");
    }else if(jTextFieldMotivoBaixa.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o motivo da baixa");
         jTextFieldMotivoBaixa.requestFocus();
     }else if(jTextFieldQuantidade.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a quatidade da baixa");
         jTextFieldQuantidade.requestFocus();
     }else if (jTextFieldData.getText().isEmpty()){
         jTextFieldData.requestFocus();
         JOptionPane.showMessageDialog(null,"Insira a data da baixa");
        }else if(Integer.parseInt(jTextFieldQuantidade.getText()) >(Integer.parseInt(jTextFieldCheio.getText()))){
               JOptionPane.showMessageDialog(rootPane,"Operação não realizada, a quantidade da baixa é maior que a quantidade em estoque");
             }else{         
          int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente fazer a baixa de " +jTextFieldQuantidade.getText()+" unidades do produto "+jComboBoxProduto.getSelectedItem()+"?" );
      
       switch (resposta) {
        case JOptionPane.NO_OPTION:
          jTextFieldCheio.setText("");
          jTextFieldVazio.setText("");
          jTextFieldQuantidade.setText("");
          
          jTextFieldID.setText("");
          jTextFieldMotivoBaixa.setText("");
          jTextFieldMotivoBaixa.setEnabled(false);
          jTextFieldQuantidade.setEnabled(false);
          jButtonSalvar.setEnabled(false);
          jTextFieldData.setEnabled(false);
          jButton1.setEnabled(false);
          jButtonCancelar.setEnabled(false);
          jRadioButtonCasco.setEnabled(false);
          jComboBoxDescricao.setEnabled(false);
          jComboBoxProduto.setEnabled(false); 
          jButtonNovo.setEnabled(true); 
          jComboBoxDescricao.removeAllItems();
          jComboBoxProduto.removeAllItems();
            break;
        case JOptionPane.CANCEL_OPTION:
           jTextFieldCheio.setText("");
          jTextFieldVazio.setText("");
          jTextFieldQuantidade.setText("");
          
          jTextFieldID.setText("");
          jTextFieldMotivoBaixa.setText("");
          jTextFieldMotivoBaixa.setEnabled(false);
          jTextFieldQuantidade.setEnabled(false);
          jButtonSalvar.setEnabled(false);
          jTextFieldData.setEnabled(false);
          jButton1.setEnabled(false);
          jButtonCancelar.setEnabled(false);
          jRadioButtonCasco.setEnabled(false);
          jComboBoxDescricao.setEnabled(false);
          jComboBoxProduto.setEnabled(false); 
          jButtonNovo.setEnabled(true); 
          jComboBoxDescricao.removeAllItems();
          jComboBoxProduto.removeAllItems();
            break;
        case JOptionPane.YES_OPTION:         
         if (jRadioButtonCasco.isSelected()){                 
          baixa.setMotivo(jTextFieldMotivoBaixa.getText());
          baixa.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
          baixa.setData(jTextFieldData.getText());
          baixa.setProduto((String) jComboBoxProduto.getSelectedItem());
          baixa.setCasco("Com casco");
          baixa.setValor(Double.parseDouble(jTextFieldValor.getText()));
          baixar.Salvar(baixa);
                 
           int estoque =(Integer.parseInt (jTextFieldCheio.getText()));
           int quantidade =(Integer.parseInt(jTextFieldQuantidade.getText()));
           int resultado = estoque - quantidade;          
          mod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
          mod.setCheo(resultado);
          mod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
          control.EditarQ(mod);
          jTextFieldCheio.setText("");
          jTextFieldVazio.setText("");
          jTextFieldQuantidade.setText("");
        
          jTextFieldID.setText("");
          jTextFieldMotivoBaixa.setText("");
          jTextFieldMotivoBaixa.setEnabled(false);
          jTextFieldQuantidade.setEnabled(false);
          jButtonSalvar.setEnabled(false);
          jTextFieldData.setEnabled(false);
          jButton1.setEnabled(false);
          jButtonCancelar.setEnabled(false);
          jRadioButtonCasco.setEnabled(false);
          jComboBoxDescricao.setEnabled(false);
          jComboBoxProduto.setEnabled(false); 
          jButtonNovo.setEnabled(true); 
          jComboBoxDescricao.removeAllItems();
          jComboBoxProduto.removeAllItems();
           }else{       
            
          baixa.setMotivo(jTextFieldMotivoBaixa.getText());
          baixa.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
          baixa.setData(jTextFieldData.getText());
          baixa.setProduto((String) jComboBoxProduto.getSelectedItem());
          baixa.setCasco("Sem casco");
          baixa.setValor(Double.parseDouble(jTextFieldValor.getText()));
          baixar.Salvar(baixa);
                
           int estoque =(Integer.parseInt (jTextFieldCheio.getText()));
           int estoque1 =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt(jTextFieldQuantidade.getText()));
           int resultado = estoque - quantidade;
           int resultado2 = estoque1 + quantidade;
          mod.setCodProduto(Integer.parseInt(jTextFieldID.getText()));
          mod.setCheo(resultado);
          mod.setVazio(resultado2);
          control.EditarQ(mod);
          jTextFieldCheio.setText("");
          jTextFieldVazio.setText("");
          jTextFieldQuantidade.setText("");
          jTextFieldID.setText("");
          jTextFieldMotivoBaixa.setText("");
          jTextFieldMotivoBaixa.setEnabled(false);
          jTextFieldQuantidade.setEnabled(false);
          jButtonSalvar.setEnabled(false);
          jTextFieldData.setEnabled(false);
          jButton1.setEnabled(false);
          jComboBoxDescricao.setEnabled(false);
          jButtonCancelar.setEnabled(false);
          jRadioButtonCasco.setEnabled(false);
          jComboBoxProduto.setEnabled(false);
          jButtonNovo.setEnabled(true); 
          jComboBoxDescricao.removeAllItems();
          jComboBoxProduto.removeAllItems();
         }
       } 
         
     }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
          jTextFieldCheio.setText("");
          jTextFieldVazio.setText("");
          jTextFieldQuantidade.setText("");
          jTextFieldID.setText("");
          jTextFieldQuantidade.setEnabled(false);
          jButtonSalvar.setEnabled(false);
          jTextFieldMotivoBaixa.setEnabled(false);
          jTextFieldData.setEnabled(false);
          jButton1.setEnabled(false);
          jComboBoxDescricao.setEnabled(false);
          jButtonCancelar.setEnabled(false);
          jRadioButtonCasco.setEnabled(false);
          jButtonNovo.setEnabled(true); 
          jTextFieldMotivoBaixa.setText("");
          jComboBoxProduto.setEnabled(false); 
          jComboBoxDescricao.removeAllItems();
          jComboBoxProduto.removeAllItems();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String referencia = (String) jComboBoxDescricao.getSelectedItem();
        jTextFieldMotivoBaixa.setText(referencia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoMouseClicked
      
    }//GEN-LAST:event_jComboBoxDescricaoMouseClicked

    private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseEntered
          try {  
    Integer.parseInt(jTextFieldQuantidade.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldQuantidade.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldQuantidade.setText("");
    jTextFieldQuantidade.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonSalvarMouseEntered

    private void jRadioButtonCascoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCascoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCascoActionPerformed

    private void jTextFieldMotivoBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMotivoBaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMotivoBaixaActionPerformed

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
   
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
               jTextFieldQuantidade.setEnabled(true);
               jButtonSalvar.setEnabled(true);
               jTextFieldMotivoBaixa.setEnabled(true);
               jTextFieldData.setEnabled(true);
               jButton1.setEnabled(true);
               jComboBoxDescricao.setEnabled(true);
               jButtonCancelar.setEnabled(true);
               jRadioButtonCasco.setEnabled(true);   
               jComboBoxProduto.setEnabled(true); 
               jButtonNovo.setEnabled(false); 
                PreencherDescricao();
                PreencherProdutos();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    
    
    
    
  
    
    
    
    
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
            java.util.logging.Logger.getLogger(Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Baixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Baixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxDescricao;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldMotivoBaixa;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldVazio;
    // End of variables declaration//GEN-END:variables
}
