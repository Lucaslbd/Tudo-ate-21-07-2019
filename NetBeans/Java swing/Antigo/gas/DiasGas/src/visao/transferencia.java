package visao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansProdutos;
import modeloBeans.BeansTransferencia;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoProdutos;
import modeloDao.DaoTransferencia;


public class transferencia extends javax.swing.JFrame {
     ConexaoBD conex = new ConexaoBD();     
     BeansProdutos modprod = new BeansProdutos();
      DaoProdutos controlprod = new DaoProdutos();
     BeansTransferencia mod = new BeansTransferencia();
     DaoTransferencia control = new DaoTransferencia();
     
    public transferencia() {
        initComponents();
       
        PreencherProdutos();
         Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(d); 
        String dtHoje;
         dtHoje = dateFormat.format(d); 
         jTextFieldData.setText(dtHoje);
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

        jTextFieldCusto = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegistrarAberta = new javax.swing.JButton();
        jRadioButtonGarrafas = new javax.swing.JRadioButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDestinatario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorNota = new javax.swing.JFormattedTextField();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldTransferir = new javax.swing.JTextField();
        jButtonCalcularnota = new javax.swing.JButton();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCusto.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldCodProduto.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonRegistrarAberta.setText("Finalizar transferência");
        jButtonRegistrarAberta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistrarAberta.setEnabled(false);
        jButtonRegistrarAberta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegistrarAbertaMouseEntered(evt);
            }
        });
        jButtonRegistrarAberta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarAbertaActionPerformed(evt);
            }
        });

        jRadioButtonGarrafas.setText("Transferência com vasilhames");
        jRadioButtonGarrafas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonGarrafas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGarrafasActionPerformed(evt);
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações da transferência"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel9.setText("Quantidade a transferir");

        jLabel3.setText("Produto selecionado");

        jLabel2.setText("Destinatario");

        jTextFieldDestinatario.setEnabled(false);

        jLabel7.setText("Valor");

        jLabel8.setText("Data da transferencia");

        jTextFieldValorNota.setEnabled(false);

        jTextFieldData.setEnabled(false);

        jTextFieldTransferir.setEnabled(false);

        jButtonCalcularnota.setText("Calcular transferência");
        jButtonCalcularnota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCalcularnota.setEnabled(false);
        jButtonCalcularnota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCalcularnotaMouseEntered(evt);
            }
        });
        jButtonCalcularnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularnotaActionPerformed(evt);
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldValorNota, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCalcularnota))
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBoxProduto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldDestinatario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCalcularnota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldValorNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(61, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRegistrarAberta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonGarrafas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jRadioButtonGarrafas)
                        .addGap(24, 24, 24)
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRegistrarAberta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Transferência de mercadoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularnotaActionPerformed
  if(jComboBoxProduto.getSelectedItem()== null){
         JOptionPane.showMessageDialog(null,"Não existem produtos cadastrados");
 }else if(jTextFieldTransferir.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a quantidade a receber");
         jTextFieldTransferir.requestFocus();
 }else{
     //aqui começa meu codigo
      String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
        conex.Conexao();
        conex.executaSql("select * from produtos where nome_produto='"+ cliente_nome +"'");
         if(jRadioButtonGarrafas.isSelected()){

           try {
               conex.rs.first();
               jTextFieldCodProduto.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldCusto.setText(String.valueOf(conex.rs.getDouble("custo_casco")));
                         
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
        }else{
        try {
               conex.rs.first();
               jTextFieldCodProduto.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldCusto.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
                           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
    }
     
     //aqui termina meu codigo
      
 int receber = (Integer.parseInt(jTextFieldTransferir.getText()));
 double custo = (Double.parseDouble(jTextFieldCusto.getText()));
 double nota = receber * custo;  
  
    DecimalFormat fmt = new DecimalFormat("0.00");       
    String string = fmt.format(nota);
    String[] part = string.split("[,]");
    String string2 = part[0]+"."+part[1];
    double preco = Double.parseDouble(string2);
 
    jTextFieldValorNota.setText(String.valueOf(preco));
 }
    }//GEN-LAST:event_jButtonCalcularnotaActionPerformed

    private void jButtonRegistrarAbertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarAbertaActionPerformed
        if(jComboBoxProduto.getSelectedItem()== null){
         JOptionPane.showMessageDialog(null,"Não existem produtos cadastrados");
        }else if(jTextFieldTransferir.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a quantidade");
         jTextFieldTransferir.requestFocus();
         }else if(jTextFieldData.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a data da transferencia");
         jTextFieldData.requestFocus();
     }else if(jTextFieldValorNota.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o valor da transferencia");
         jTextFieldValorNota.requestFocus();
    }else if(jTextFieldDestinatario.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o destino da transferencia");
         jTextFieldDestinatario.requestFocus();
     }else{
        
        //aqui começa meu codigo
         String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
        conex.Conexao();
        conex.executaSql("select * from produtos where nome_produto='"+ cliente_nome +"'");
         if(jRadioButtonGarrafas.isSelected()){

           try {
               conex.rs.first();
               jTextFieldCodProduto.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldCusto.setText(String.valueOf(conex.rs.getDouble("custo_casco")));
                         
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
        }else{
        try {
               conex.rs.first();
               jTextFieldCodProduto.setText(String.valueOf(conex.rs.getInt("cod_produto")));
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));
               jTextFieldCusto.setText(String.valueOf(conex.rs.getDouble("preco_custo")));
                           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta(); 
    }
     
        //aqui termina meu codigo
        
         if (jRadioButtonGarrafas.isSelected()){ 
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldTransferir.getText()));       
        mod.setDestinatario(jTextFieldDestinatario.getText());
        mod.setCasco("Com casco");
        control.Salvar(mod);
        int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
        int quantidade =(Integer.parseInt(jTextFieldTransferir.getText()));
        int resultado = cheio - quantidade;
        modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
        modprod.setCheo(resultado);
        modprod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
        controlprod.EditarQ(modprod);
        
        jComboBoxProduto.setEnabled(false);
        jTextFieldDestinatario.setEnabled(false);
        jTextFieldTransferir.setEnabled(false);
        jTextFieldValorNota.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jButtonCalcularnota.setEnabled(false);
        jButtonRegistrarAberta.setEnabled(false);
        jButtonCancelar.setEnabled(false);       
        jButtonNovo.setEnabled(true);
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldTransferir.setText("");        
        jTextFieldDestinatario.setText("");
        jComboBoxProduto.removeAllItems();
        
        }else{  
              if(Integer.parseInt(jTextFieldTransferir.getText()) >(Integer.parseInt(jTextFieldCheio.getText()))){
               JOptionPane.showMessageDialog(rootPane,"Operação não realizada, quantidade a transferir é maior que a quantidade contida no estoque");
             }else{
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldTransferir.getText()));
        mod.setDestinatario(jTextFieldDestinatario.getText());
        mod.setCasco("Sem casco");
        control.Salvar(mod);
        
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt(jTextFieldTransferir.getText()));
           int resultado = cheio - quantidade;
           int resultado2 = vazio + quantidade;
           modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modprod.setCheo(resultado);
           modprod.setVazio(resultado2);
         controlprod.EditarQ(modprod);
         
        jComboBoxProduto.setEnabled(false);
        jTextFieldDestinatario.setEnabled(false);
        jTextFieldTransferir.setEnabled(false);
        jTextFieldValorNota.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jButtonCalcularnota.setEnabled(false);
        jButtonRegistrarAberta.setEnabled(false);
        jButtonCancelar.setEnabled(false);       
        jButtonNovo.setEnabled(true);
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldTransferir.setText("");        
        jTextFieldDestinatario.setText("");
        jComboBoxProduto.removeAllItems();
       
         }
        
     }
    }   
    }//GEN-LAST:event_jButtonRegistrarAbertaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jComboBoxProduto.setEnabled(false);
        jTextFieldDestinatario.setEnabled(false);
        jTextFieldTransferir.setEnabled(false);
        jTextFieldValorNota.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jButtonCalcularnota.setEnabled(false);
        jButtonRegistrarAberta.setEnabled(false);
        jButtonCancelar.setEnabled(false);       
        jButtonNovo.setEnabled(true);
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldTransferir.setText("");        
        jTextFieldDestinatario.setText("");
        jComboBoxProduto.removeAllItems();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarAbertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarAbertaMouseEntered
       try {  
    Integer.parseInt(jTextFieldTransferir.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldTransferir.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade a receber somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldTransferir.setText("");
    jTextFieldTransferir.requestFocus(); 
        }
    }
          try {  
    Double.parseDouble(jTextFieldValorNota.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldValorNota.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros do tipo real ex: 50.31");  
    jTextFieldValorNota.setText("");
    jTextFieldValorNota.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonRegistrarAbertaMouseEntered

    private void jRadioButtonGarrafasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGarrafasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonGarrafasActionPerformed

    private void jButtonCalcularnotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalcularnotaMouseEntered
         try {  
    Integer.parseInt(jTextFieldTransferir.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldTransferir.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade a transferir somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldTransferir.setText("");
    jTextFieldTransferir.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonCalcularnotaMouseEntered

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
   
     
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        jComboBoxProduto.setEnabled(true);
        jTextFieldDestinatario.setEnabled(true);
        jTextFieldTransferir.setEnabled(true);
        jTextFieldValorNota.setEnabled(true);
        jTextFieldData.setEnabled(true);
        jButtonCalcularnota.setEnabled(true);
        jButtonRegistrarAberta.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonNovo.setEnabled(false);
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
            java.util.logging.Logger.getLogger(transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcularnota;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRegistrarAberta;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonGarrafas;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldCusto;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldDestinatario;
    private javax.swing.JTextField jTextFieldTransferir;
    private javax.swing.JFormattedTextField jTextFieldValorNota;
    private javax.swing.JTextField jTextFieldVazio;
    // End of variables declaration//GEN-END:variables
}
