package visao.Controle;

import visao.Consulta.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansNotasMercadoria;
import modeloBeans.BeansProdutos;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoNotasMercadoria;
import modeloDao.DaoProdutos;



public class ControleNotas extends javax.swing.JFrame {
 ConexaoBD conex = new ConexaoBD();
 BeansNotasMercadoria mod = new BeansNotasMercadoria();
 DaoNotasMercadoria control = new DaoNotasMercadoria();
 BeansProdutos modProdutos = new BeansProdutos();
  DaoProdutos Produtos = new DaoProdutos();
  
   
    public ControleNotas() {
        initComponents();
        
         PreencherDescricao();    
    }

     public void PreencherDescricao(){
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

        Produto = new javax.swing.JTextField();
        jTextFieldVazio = new javax.swing.JTextField();
        jTextFieldCheio = new javax.swing.JTextField();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jTextFieldCasco = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNota = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonPesquisar1 = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldhegada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldVencimento = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        Produto.setEnabled(false);

        jTextFieldVazio.setEnabled(false);

        jTextFieldCheio.setEnabled(false);

        jTextFieldCodProduto.setEnabled(false);

        jTextFieldCasco.setEnabled(false);

        jTextFieldQuantidade.setEnabled(false);

        jTextFieldCodigo.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNota);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseClicked(evt);
            }
        });

        jButtonPesquisar1.setText("Pesquisar");
        jButtonPesquisar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar1))
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonExcluir.setText("Excluir nota");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar nota");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Edições da nota");

        jLabel3.setText("Descrição");

        jTextFieldDescricao.setEnabled(false);

        jLabel4.setText("Chegada");

        jTextFieldhegada.setEnabled(false);

        jLabel5.setText("Vencimento");

        jTextFieldVencimento.setEnabled(false);

        jTextFieldValor.setEnabled(false);

        jLabel6.setText("Valor");

        jLabel7.setText("Situação");

        jButtonSalvar.setText("Salvar");
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

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberta", "Fechada" }));
        jComboBoxSituacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxSituacao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(56, 56, 56))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(jTextFieldhegada)
                                    .addComponent(jTextFieldVencimento)
                                    .addComponent(jComboBoxSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldhegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonEditar))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Editar/Excluir/Notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisar1ActionPerformed
       if(jComboBoxProduto.getSelectedItem() == null){
             JOptionPane.showMessageDialog(null,"Não há produtos cadastrados para pesquisar");
       }else{

        mod.setPesquisar(jFormattedTextFieldData.getText());
        String Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento");
       }
      
        
    }//GEN-LAST:event_jButtonPesquisar1ActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if(jTextFieldCodigo.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane,"Selecione uma nota para excluir");
         }else{             
               
                String produto = Produto.getText();
        conex.Conexao();
         try {
               conex.executaSql("select * from produtos where nome_produto='"+produto+"'");
               conex.rs.first();
               jTextFieldVazio.setText(conex.rs.getString("vazio"));
               jTextFieldCheio.setText(conex.rs.getString("cheio"));
               jTextFieldCodProduto.setText(conex.rs.getString("cod_produto"));
       
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir a nota com codigo " +  jTextFieldCodigo.getText()+" ?" );
         
       switch (resposta) {
        case JOptionPane.NO_OPTION:
            jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            Produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");  
            jTextFieldDescricao.setText(""); 
            jTextFieldhegada.setText(""); 
            jTextFieldVencimento.setText("");
            jTextFieldValor.setText("");
            jButtonExcluir.setEnabled(false);
            jButtonEditar.setEnabled(false);
             mod.setPesquisar(jFormattedTextFieldData.getText());
        String Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento");
            break;
        case JOptionPane.CANCEL_OPTION:
             jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            Produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");  
            jTextFieldDescricao.setText(""); 
            jTextFieldhegada.setText(""); 
            jTextFieldVencimento.setText("");
            jTextFieldValor.setText("");
            jButtonExcluir.setEnabled(false);
            jButtonEditar.setEnabled(false);
             mod.setPesquisar(jFormattedTextFieldData.getText());
         Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento");
            break;
        case JOptionPane.YES_OPTION:
           mod.setCodigoNota(Integer.parseInt(jTextFieldCodigo.getText()));
            control.Excluir(mod);
           if(jTextFieldCasco.getText().equals ("Sem casco")){     
              
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int vazio =(Integer.parseInt (jTextFieldVazio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldQuantidade.getText()));
           int resultado = cheio - quantidade;
           int resultado2 = vazio + quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(resultado2);
           Produtos.EditarQ(modProdutos); 
             jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            Produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");
            jTextFieldDescricao.setText(""); 
            jTextFieldhegada.setText(""); 
            jTextFieldVencimento.setText("");
            jTextFieldValor.setText("");
            jButtonExcluir.setEnabled(false);
            jButtonEditar.setEnabled(false);            
                     
           }else{
                
           int cheio =(Integer.parseInt (jTextFieldCheio.getText()));
           int quantidade =(Integer.parseInt (jTextFieldQuantidade.getText()));
           int resultado = cheio - quantidade;
           modProdutos.setCodProduto(Integer.parseInt(jTextFieldCodProduto.getText()));
           modProdutos.setCheo(resultado);
           modProdutos.setVazio(Integer.parseInt(jTextFieldVazio.getText()));
           Produtos.EditarQ(modProdutos);
           jTextFieldCodProduto.setText("");
            jTextFieldVazio.setText("");
            jTextFieldCheio.setText("");
            jTextFieldCodigo.setText("");
            Produto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldCasco.setText("");                         
           }  
           jTextFieldDescricao.setEnabled(false);
       jTextFieldhegada.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jComboBoxSituacao.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldDescricao.setText("");
       jTextFieldhegada.setText("");
       jTextFieldVencimento.setText("");
       jTextFieldValor.setText("");
        jTextFieldCodigo.setText("");
        Produto.setText("");
        jTextFieldQuantidade.setText("");
        jTextFieldCasco.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCheio.setText("");
        jTextFieldCodProduto.setText("");
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
            mod.setPesquisar(jFormattedTextFieldData.getText());
         Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento"); 
        
        }
            } catch  (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Produto não cadastrado"); 
               jTextFieldCodigo.setText("");
         }
          
              
         } 
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNotaMouseClicked
 String cliente_nome =""+jTableNota.getValueAt(jTableNota.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from notasmercadoria where codigo='"+ cliente_nome +"'");
           try {
               conex.rs.first(); 
               jComboBoxSituacao.setSelectedItem(conex.rs.getString("situacao"));
               jTextFieldCodigo.setText(conex.rs.getString("codigo"));
               jTextFieldDescricao.setText(conex.rs.getString("descricao_nota"));
               jTextFieldhegada.setText(conex.rs.getString("data"));
               jTextFieldVencimento.setText(conex.rs.getString("vencimento"));
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("valor")));
               Produto.setText(conex.rs.getString("produto"));  
               jTextFieldQuantidade.setText(conex.rs.getString("quantidade"));
               jTextFieldCasco.setText(conex.rs.getString("casco"));
               jButtonExcluir.setEnabled(true);
               jButtonEditar.setEnabled(true); 
               
                } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
                     
    }//GEN-LAST:event_jTableNotaMouseClicked

    private void jComboBoxProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseClicked
      PreencherDescricao(); 
    }//GEN-LAST:event_jComboBoxProdutoMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
            
       jTextFieldDescricao.setEnabled(true);
       jTextFieldhegada.setEnabled(true);
       jTextFieldVencimento.setEnabled(true);
       jTextFieldValor.setEnabled(true);
       jComboBoxSituacao.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       jTextFieldDescricao.setEnabled(false);
       jTextFieldhegada.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jComboBoxSituacao.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldDescricao.setText("");
       jTextFieldhegada.setText("");
       jTextFieldVencimento.setText("");
       jTextFieldValor.setText("");
        jTextFieldCodigo.setText("");
        Produto.setText("");
        jTextFieldQuantidade.setText("");
        jTextFieldCasco.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCheio.setText("");
        jTextFieldCodProduto.setText("");
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        mod.setPesquisar(jFormattedTextFieldData.getText());
        String Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento");
               
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        mod.setCodigoNota(Integer.parseInt( jTextFieldCodigo.getText()));
        mod.setDescricaoNota(jTextFieldDescricao.getText());
        mod.setData(jTextFieldhegada.getText());
        mod.setVencimento(jTextFieldVencimento.getText());
        mod.setValor(Double.parseDouble(jTextFieldValor.getText()));
        mod.setSituacao((String) jComboBoxSituacao.getSelectedItem());
        control.Editar(mod);
        jTextFieldDescricao.setEnabled(false);
       jTextFieldhegada.setEnabled(false);
       jTextFieldVencimento.setEnabled(false);
       jTextFieldValor.setEnabled(false);
       jComboBoxSituacao.setEnabled(false);
       jButtonSalvar.setEnabled(false);
       jButtonCancelar.setEnabled(false);
       jTextFieldDescricao.setText("");
       jTextFieldhegada.setText("");
       jTextFieldVencimento.setText("");
       jTextFieldValor.setText("");
        jTextFieldCodigo.setText("");
        Produto.setText("");
        jTextFieldQuantidade.setText("");
        jTextFieldCasco.setText("");
        jTextFieldVazio.setText("");
        jTextFieldCheio.setText("");
        jTextFieldCodProduto.setText("");
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
         mod.setPesquisar(jFormattedTextFieldData.getText());
        String Produtoo =(String) jComboBoxProduto.getSelectedItem();
        preencherTabela("select *from notasmercadoria where  produto='"+Produtoo+"' and vencimento like'%" + mod.getPesquisar()+"%'order by vencimento");
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseEntered
        try {  
    Double.parseDouble(jTextFieldValor.getText()); 
    } catch (NumberFormatException e) { 
        if(!"".equals(jTextFieldValor.getText())){
    JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31");  
    jTextFieldValor.setText("");
    jTextFieldValor.requestFocus(); 
        }
    }
    }//GEN-LAST:event_jButtonSalvarMouseEntered

    
    
     public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Cod","Descrição da nota","Produto","Data de chegada","Valor","Quantidade","C/S Casco","Vencimento","Situação"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("codigo"),conex.rs.getString("descricao_nota"),conex.rs.getString("produto"),conex.rs.getString("data"),conex.rs.getDouble("valor"),conex.rs.getString("quantidade"),conex.rs.getString("casco"),conex.rs.getString("vencimento"),conex.rs.getString("situacao")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"Não foram encontradas notas com esse perfil");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableNota.setModel(modelo);
           jTableNota.getColumnModel ().getColumn(0).setPreferredWidth(40);
           jTableNota.getColumnModel().getColumn(0).setResizable(false);
           jTableNota.getColumnModel ().getColumn(1).setPreferredWidth(120);
           jTableNota.getColumnModel().getColumn(1).setResizable(false);
           jTableNota.getColumnModel ().getColumn(2).setPreferredWidth(95);
           jTableNota.getColumnModel().getColumn(2).setResizable(false);
           jTableNota.getColumnModel ().getColumn(3).setPreferredWidth(110);
           jTableNota.getColumnModel().getColumn(3).setResizable(false);
           jTableNota.getColumnModel ().getColumn(4).setPreferredWidth(70);
           jTableNota.getColumnModel().getColumn(4).setResizable(false);
           jTableNota.getColumnModel ().getColumn(5).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(5).setResizable(false);
           jTableNota.getColumnModel ().getColumn(6).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(6).setResizable(false);
           jTableNota.getColumnModel ().getColumn(7).setPreferredWidth(80);
           jTableNota.getColumnModel().getColumn(7).setResizable(false);
           jTableNota.getColumnModel ().getColumn(8).setPreferredWidth(70);
           jTableNota.getColumnModel().getColumn(8).setResizable(false);
          jTableNota.getTableHeader().setReorderingAllowed(false);
           jTableNota.setAutoResizeMode(jTableNota.AUTO_RESIZE_OFF);
           jTableNota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        conex.Desconecta();
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
            java.util.logging.Logger.getLogger(ControleNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Produto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar1;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNota;
    private javax.swing.JTextField jTextFieldCasco;
    private javax.swing.JTextField jTextFieldCheio;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldVazio;
    private javax.swing.JTextField jTextFieldVencimento;
    private javax.swing.JTextField jTextFieldhegada;
    // End of variables declaration//GEN-END:variables
}
