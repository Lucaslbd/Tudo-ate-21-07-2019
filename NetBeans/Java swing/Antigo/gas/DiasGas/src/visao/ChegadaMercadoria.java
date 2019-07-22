package visao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansNotasMercadoria;
import modeloBeans.BeansProdutos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoNotasMercadoria;
import modeloDao.DaoProdutos;


public class ChegadaMercadoria extends javax.swing.JFrame {
     ConexaoBD conex = new ConexaoBD(); 
     BeansNotasMercadoria mod = new BeansNotasMercadoria();
     BeansProdutos modprod = new BeansProdutos();
     DaoNotasMercadoria control = new DaoNotasMercadoria();
     DaoProdutos controlprod = new DaoProdutos();
     
     
    public ChegadaMercadoria() {
        initComponents();
        
       
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
        jTextFieldCodProduto = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegistrarAberta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegistrarFechada = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDescricaoNota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldReceber = new javax.swing.JTextField();
        jTextFieldValorNota = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVencimento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButtonCalcularnota = new javax.swing.JButton();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jRadioButtonGarrafas = new javax.swing.JRadioButton();
        jButtonNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCusto.setEnabled(false);

        jTextFieldCodProduto.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonRegistrarAberta.setText("Registrar como aberta");
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

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonRegistrarFechada.setText("Registrar como fechada");
        jButtonRegistrarFechada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistrarFechada.setEnabled(false);
        jButtonRegistrarFechada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegistrarFechadaMouseEntered(evt);
            }
        });
        jButtonRegistrarFechada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarFechadaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações da nota"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel3.setText("Produto");

        jLabel9.setText("Quantidade a receber");

        jTextFieldDescricaoNota.setEnabled(false);

        jLabel2.setText("Descrição da nota");

        jTextFieldReceber.setEnabled(false);

        jTextFieldValorNota.setEnabled(false);

        jLabel7.setText("Valor da nota");

        jTextFieldData.setEnabled(false);

        jLabel8.setText("Data do recebimento");

        jTextFieldVencimento.setEnabled(false);

        jLabel10.setText("Vencimento da nota");

        jButtonCalcularnota.setText("Calcular nota");
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

        jRadioButtonGarrafas.setText("Chegada sem devolução de vazilhames ");
        jRadioButtonGarrafas.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValorNota, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldDescricaoNota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCalcularnota))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonGarrafas)
                        .addGap(101, 101, 101)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonGarrafas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButtonCalcularnota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRegistrarFechada, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButtonRegistrarAberta, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRegistrarAberta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRegistrarFechada)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Entrada Mercadoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularnotaActionPerformed
  if(jComboBoxProduto.getSelectedItem()== null){
         JOptionPane.showMessageDialog(null,"Ainda não existem produtos cadastrados");
 }else if(jTextFieldReceber.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a quantidade a receber");
         jTextFieldReceber.requestFocus();
 }else{
   //aqui começa o codigo
String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
    conex.Conexao();
    try {
         conex.executaSql("select * from produtos where nome_produto='"+cliente_nome+"'");
         conex.rs.first();
         jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
   } catch  (SQLException ex) {
                 JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro\n"+ ex.getMessage());               
             }
    conex.Desconecta();
    
    conex.Conexao();
        conex.executaSql("select * from produtos where cod_produto='"+ jTextFieldCodProduto.getText()+"'");
           try {
               conex.rs.first();                            
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));                           
               jTextFieldCusto.setText(conex.rs.getString("preco_custo"));
         } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
//aqui termina o codigo   
     
     
 int receber = (Integer.parseInt(jTextFieldReceber.getText()));
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
         JOptionPane.showMessageDialog(null,"Ainda não existem produtos cadastrados");
      }else if(jTextFieldDescricaoNota.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a descrição da nota");
         jTextFieldDescricaoNota.requestFocus();
        }else if(jTextFieldReceber.getText().isEmpty()){            
         JOptionPane.showMessageDialog(null,"Informe a quantidade");
         jTextFieldReceber.requestFocus();
        }else if(jTextFieldVencimento.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o vencimento da nota");
         jTextFieldVencimento.requestFocus();
     }else if(jTextFieldData.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a data de recebimento");
         jTextFieldData.requestFocus();
     }else if(jTextFieldValorNota.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o valor da nota");
         jTextFieldValorNota.requestFocus();
    
     }else{ 
         //aqui começa o codigo
     String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
    conex.Conexao();
    try {
         conex.executaSql("select * from produtos where nome_produto='"+cliente_nome+"'");
         conex.rs.first();
         jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
   } catch  (SQLException ex) {
                 JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro\n"+ ex.getMessage());               
             }
    conex.Desconecta();
    
    conex.Conexao();
        conex.executaSql("select * from produtos where cod_produto='"+ jTextFieldCodProduto.getText()+"'");
           try {
               conex.rs.first();                            
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));                           
               jTextFieldCusto.setText(conex.rs.getString("preco_custo"));
         } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
            
         //aqui termina o codigo         
       
        
         if (jRadioButtonGarrafas.isSelected()){ 
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldReceber.getText()));
        mod.setVencimento(jTextFieldVencimento.getText());
        mod.setSituacao("Aberta");
        mod.setDescricaoNota(jTextFieldDescricaoNota.getText());
        mod.setCasco("Com casco");
        control.Salvar(mod);
        int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
        int quantidade =(Integer.parseInt(jTextFieldReceber.getText()));
        int resultado = cheio + quantidade;
        modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
        modprod.setCheo(resultado);
        modprod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
        controlprod.EditarQ(modprod);
        
        jRadioButtonGarrafas.setEnabled(false);
       jComboBoxProduto.setEnabled(false);
       jTextFieldDescricaoNota.setEnabled(false);
       jTextFieldReceber.setEnabled(false);
       jTextFieldValorNota.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jButtonCalcularnota.setEnabled(false);      
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldReceber.setText("");
        jTextFieldVencimento.setText("");
        jTextFieldDescricaoNota.setText("");
        jRadioButtonGarrafas.setSelected(false);
        jButtonRegistrarAberta.setEnabled(false);
       jButtonRegistrarFechada.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jComboBoxProduto.removeAllItems();
        }else{  
              if(Integer.parseInt(jTextFieldReceber.getText()) >(Integer.parseInt(jTextFieldVazio.getText()))){
               JOptionPane.showMessageDialog(rootPane,"Operação não realizada, quantidade a receber é maior que a quantidade a ser devolvida");
             }else{
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldReceber.getText()));
        mod.setVencimento(jTextFieldVencimento.getText());
        mod.setSituacao("Aberta");
        mod.setDescricaoNota(jTextFieldDescricaoNota.getText());
        mod.setCasco("Sem casco");
        control.Salvar(mod);
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt(jTextFieldReceber.getText()));
           int resultado = cheio + quantidade;
           int resultado2 = vazio - quantidade;
           modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modprod.setCheo(resultado);
           modprod.setVazio(resultado2);
         controlprod.EditarQ(modprod);
        
      jRadioButtonGarrafas.setEnabled(false);
       jComboBoxProduto.setEnabled(false);
       jTextFieldDescricaoNota.setEnabled(false);
       jTextFieldReceber.setEnabled(false);
       jTextFieldValorNota.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jButtonCalcularnota.setEnabled(false);      
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldReceber.setText("");
        jTextFieldVencimento.setText("");
        jTextFieldDescricaoNota.setText("");
        jRadioButtonGarrafas.setSelected(false);
      jButtonRegistrarAberta.setEnabled(false);
       jButtonRegistrarFechada.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jComboBoxProduto.removeAllItems();
         }
        
     }
    }   
    }//GEN-LAST:event_jButtonRegistrarAbertaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jRadioButtonGarrafas.setEnabled(false);
       jComboBoxProduto.setEnabled(false);
       jTextFieldDescricaoNota.setEnabled(false);
       jTextFieldReceber.setEnabled(false);
       jTextFieldValorNota.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jButtonCalcularnota.setEnabled(false);      
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldReceber.setText("");
        jTextFieldVencimento.setText("");
        jTextFieldDescricaoNota.setText("");
        jRadioButtonGarrafas.setSelected(false);
        jButtonRegistrarAberta.setEnabled(false);
       jButtonRegistrarFechada.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jComboBoxProduto.removeAllItems();
        jButtonNovo.requestFocus();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarFechadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarFechadaActionPerformed
       if(jComboBoxProduto.getSelectedItem()== null){
         JOptionPane.showMessageDialog(null,"Ainda não existem produtos cadastrados");
        }else if(jTextFieldReceber.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a quantidade");
         jTextFieldReceber.requestFocus();
     }else if(jTextFieldVencimento.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o vencimento da nota");
         jTextFieldVencimento.requestFocus();
     }else if(jTextFieldData.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a data de recebimento");
         jTextFieldData.requestFocus();
     }else if(jTextFieldValorNota.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe o valor da nota");
         jTextFieldValorNota.requestFocus();
    }else if(jTextFieldDescricaoNota.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Informe a descrição da nota");
         jTextFieldDescricaoNota.requestFocus();         
     }else{   
        //aqui começa o codigo
        String cliente_nome =""+jComboBoxProduto.getItemAt(jComboBoxProduto.getSelectedIndex());
    conex.Conexao();
    try {
         conex.executaSql("select * from produtos where nome_produto='"+cliente_nome+"'");
         conex.rs.first();
         jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
   } catch  (SQLException ex) {
                 JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro\n"+ ex.getMessage());               
             }
    conex.Desconecta();
    
    conex.Conexao();
        conex.executaSql("select * from produtos where cod_produto='"+ jTextFieldCodProduto.getText()+"'");
           try {
               conex.rs.first();                            
               jTextFieldCheio.setText(String.valueOf(conex.rs.getInt("cheio")));
               jTextFieldVazio.setText(String.valueOf(conex.rs.getInt("vazio")));                           
               jTextFieldCusto.setText(conex.rs.getString("preco_custo"));
         } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
        //aqui termina o codigo
               
         if (jRadioButtonGarrafas.isSelected()){ 
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldReceber.getText()));
        mod.setVencimento(jTextFieldVencimento.getText());
        mod.setSituacao("Fechada");
        mod.setDescricaoNota(jTextFieldDescricaoNota.getText());
        mod.setCasco("Com casco");
        control.Salvar(mod);
        int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
        int quantidade =(Integer.parseInt(jTextFieldReceber.getText()));
        int resultado = cheio + quantidade;
        modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
        modprod.setCheo(resultado);
        modprod.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
        controlprod.EditarQ(modprod);
        
      jRadioButtonGarrafas.setEnabled(false);
       jComboBoxProduto.setEnabled(false);
       jTextFieldDescricaoNota.setEnabled(false);
       jTextFieldReceber.setEnabled(false);
       jTextFieldValorNota.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jButtonCalcularnota.setEnabled(false);      
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldReceber.setText("");
        jTextFieldVencimento.setText("");
        jTextFieldDescricaoNota.setText("");
        jRadioButtonGarrafas.setSelected(false);
        jButtonRegistrarAberta.setEnabled(false);
       jButtonRegistrarFechada.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jComboBoxProduto.removeAllItems();
        }else{
             
             if(Integer.parseInt(jTextFieldReceber.getText()) >(Integer.parseInt(jTextFieldVazio.getText()))){
               JOptionPane.showMessageDialog(rootPane,"Operação não realizada, quantidade a receber é maior que a quantidade a ser devolvida");
             }else{
        mod.setProduto((String) jComboBoxProduto.getSelectedItem());
        mod.setData(jTextFieldData.getText());
        mod.setValor(Double.parseDouble(jTextFieldValorNota.getText()));
        mod.setQuantidade(Integer.parseInt(jTextFieldReceber.getText()));
        mod.setVencimento(jTextFieldVencimento.getText());
        mod.setSituacao("Fechada");
        mod.setDescricaoNota(jTextFieldDescricaoNota.getText());
        mod.setCasco("Sem casco");
        control.Salvar(mod);
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt(jTextFieldReceber.getText()));
           int resultado = cheio + quantidade;
           int resultado2 = vazio - quantidade;
           modprod.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modprod.setCheo(resultado);
           modprod.setVazio(resultado2);
         controlprod.EditarQ(modprod);
        
      jRadioButtonGarrafas.setEnabled(false);
       jComboBoxProduto.setEnabled(false);
       jTextFieldDescricaoNota.setEnabled(false);
       jTextFieldReceber.setEnabled(false);
       jTextFieldValorNota.setEnabled(false);
       jTextFieldData.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jButtonCalcularnota.setEnabled(false);      
        jTextFieldCheio.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCusto.setText("");
        jTextFieldValorNota.setText("");
        jTextFieldCodProduto.setText("");
        jTextFieldReceber.setText("");
        jTextFieldVencimento.setText("");
        jTextFieldDescricaoNota.setText("");
        jRadioButtonGarrafas.setSelected(false);
      jButtonRegistrarAberta.setEnabled(false);
       jButtonRegistrarFechada.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jButtonNovo.setEnabled(true);
       jComboBoxProduto.removeAllItems();
         }
         
     }                
    }
    }//GEN-LAST:event_jButtonRegistrarFechadaActionPerformed

    private void jButtonRegistrarAbertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarAbertaMouseEntered
         try {  
    Integer.parseInt(jTextFieldReceber.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldReceber.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade a receber somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldReceber.setText("");
    jTextFieldReceber.requestFocus(); 
        }
    }
          try {  
    Double.parseDouble(jTextFieldValorNota.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldValorNota.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor da nota somente pode receber numeros do tipo real ex: 50.31");  
    jTextFieldValorNota.setText("");
    jTextFieldValorNota.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonRegistrarAbertaMouseEntered

    private void jButtonRegistrarFechadaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarFechadaMouseEntered
        try {  
    Integer.parseInt(jTextFieldReceber.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldReceber.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade a receber somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldReceber.setText("");
    jTextFieldReceber.requestFocus(); 
        }
    }
          try {  
    Double.parseDouble(jTextFieldValorNota.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldValorNota.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor da nota somente pode receber numeros do tipo real ex: 50.31");  
    jTextFieldValorNota.setText("");
    jTextFieldValorNota.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonRegistrarFechadaMouseEntered

    private void jButtonCalcularnotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalcularnotaMouseEntered
        try {  
    Integer.parseInt(jTextFieldReceber.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldReceber.getText())){
    JOptionPane.showMessageDialog(null, "O campo quantidade a receber somente pode receber numeros do tipo inteiro ex: 50");  
    jTextFieldReceber.setText("");
    jTextFieldReceber.requestFocus(); 
        }
    }

    }//GEN-LAST:event_jButtonCalcularnotaMouseEntered

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       PreencherProdutos();
       jRadioButtonGarrafas.setEnabled(true);
       jComboBoxProduto.setEnabled(true);
       jTextFieldDescricaoNota.setEnabled(true);
       jTextFieldReceber.setEnabled(true);
       jTextFieldValorNota.setEnabled(true);
       jTextFieldData.setEnabled(true);
       jTextFieldVencimento.setEnabled(true);
       jButtonCalcularnota.setEnabled(true);
       jButtonRegistrarAberta.setEnabled(true);
       jButtonRegistrarFechada.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonNovo.setEnabled(false);
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
            java.util.logging.Logger.getLogger(ChegadaMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChegadaMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChegadaMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChegadaMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChegadaMercadoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcularnota;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRegistrarAberta;
    private javax.swing.JButton jButtonRegistrarFechada;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextFieldDescricaoNota;
    private javax.swing.JTextField jTextFieldReceber;
    private javax.swing.JFormattedTextField jTextFieldValorNota;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField jTextFieldVencimento;
    // End of variables declaration//GEN-END:variables
}
