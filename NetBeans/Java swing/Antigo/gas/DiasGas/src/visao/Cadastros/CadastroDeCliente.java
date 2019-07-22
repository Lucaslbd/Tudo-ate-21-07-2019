package visao.Cadastros;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansClientes;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoClientes;
import static sun.util.calendar.CalendarUtils.mod;


public class CadastroDeCliente extends javax.swing.JFrame {
       BeansClientes mod = new BeansClientes();
       DaoClientes control = new DaoClientes();
       ConexaoBD conex = new ConexaoBD();
        int flag =0;
        
    public CadastroDeCliente() {
        initComponents();        
        PreencherBairro();
        PreencherRua();
        
    }   
    
     public void PreencherBairro(){
        conex.Conexao();
        conex.executaSql("SELECT DISTINCT cliente_bairro  from clientes order by cliente_bairro");
    try {
        conex.rs.first();
        jComboBoxBairro.removeAllItems();
        do{
            jComboBoxBairro.addItem(conex.rs.getString("cliente_bairro"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
          
    }
        conex.Desconecta();
    }
     public void PreencherRua(){
         String Produto = jTextFieldBairro.getText(); 
        conex.Conexao();
        conex.executaSql("SELECT DISTINCT cliente_rua  from clientes where cliente_bairro='"+Produto+"'  order by cliente_rua");
    try {
        conex.rs.first();
        jComboBoxRua.removeAllItems();
        do{
            jComboBoxRua.addItem(conex.rs.getString("cliente_rua"));
        }while(conex.rs.next());
    } catch (SQLException ex) {
          
    }
        conex.Desconecta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldFone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jComboBoxBairro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldBairro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jComboBoxRua = new javax.swing.JComboBox<>();
        jButtonRua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldCod.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações do cliente"));

        jLabel3.setText("Telefone");

        try {
            jFormattedTextFieldFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldFone.setEnabled(false);

        jLabel2.setText("Nome:");

        jTextFieldNome.setEnabled(false);

        jLabel4.setText("Rua");

        jTextFieldRua.setEnabled(false);

        jComboBoxBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxBairro.setEnabled(false);
        jComboBoxBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxBairroMouseClicked(evt);
            }
        });

        jLabel6.setText("Bairro");

        jButtonNovo.setText("Novo");
        jButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
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

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTextFieldBairro.setEnabled(false);

        jButton1.setText("Inserir bairro");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("N° da casa");

        jTextFieldNumero.setEnabled(false);

        jComboBoxRua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxRua.setEnabled(false);
        jComboBoxRua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxRuaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxRuaMouseEntered(evt);
            }
        });

        jButtonRua.setText("Inserir rua");
        jButtonRua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRua.setEnabled(false);
        jButtonRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldRua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBairro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldFone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxRua, 0, 195, Short.MAX_VALUE)
                                    .addComponent(jComboBoxBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jButtonRua, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextFieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       if(jTextFieldNome.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do cliente");
         jTextFieldNome.requestFocus();
     }else if(jTextFieldRua.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a rua do cliente");
         jTextFieldRua.requestFocus();
     }else if(jTextFieldNumero.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira a numero da casa do cliente");
         jTextFieldNumero.requestFocus();
    }else if(jTextFieldBairro.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o bairro da casa do cliente");
         jTextFieldBairro.requestFocus();
     }else

        if(flag==1){
        mod.setNome(jTextFieldNome.getText());
        mod.setFone(jFormattedTextFieldFone.getText());
        mod.setRua(jTextFieldRua.getText());
        mod.setNumero(jTextFieldNumero.getText());
        mod.setBairro(jTextFieldBairro.getText());
       
        control.Salvar(mod);
         mod.setPesquisa(jTextFieldNome.getText());
         preencherTabela("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%' order by cliente_nome");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jFormattedTextFieldFone.setText("");
        jTextFieldNumero.setText("");
        jTextFieldCod.setText("");
        PreencherBairro();
    
        jTextFieldNome.setEnabled(false);
        jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisa.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jComboBoxRua.setEnabled(false);
         jTextFieldBairro.setEnabled(false);
        jButton1.setEnabled(false);
        jButtonRua.setEnabled(false);
        jTextFieldBairro.setText("");
        }else{
        mod.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
        mod.setNome(jTextFieldNome.getText());
        mod.setFone(jFormattedTextFieldFone.getText());
        mod.setRua(jTextFieldRua.getText());
        mod.setNumero(jTextFieldNumero.getText());
        mod.setBairro(jTextFieldBairro.getText());       
        control.Editar(mod);        
        mod.setPesquisa(jTextFieldNome.getText());
         preencherTabela("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%' order by cliente_nome");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldCod.setText("");
        PreencherBairro();
        jFormattedTextFieldFone.setText("");
        jTextFieldNumero.setText("");
        jTextFieldNome.setEnabled(false);
        jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jTextFieldPesquisa.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonPesquisar.setEnabled(true);
        jComboBoxRua.setEnabled(false);
         jTextFieldBairro.setEnabled(false);
        jButton1.setEnabled(false);
        jButtonRua.setEnabled(false);
        jTextFieldBairro.setText("");
            
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        jTextFieldNome.setEnabled(true);
        jTextFieldRua.setEnabled(true);
         jComboBoxBairro.setEnabled(true);
        jFormattedTextFieldFone.setEnabled(true);
        jTextFieldNumero.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
       
        jTextFieldBairro.setEnabled(true);
        jButton1.setEnabled(true);
        jTextFieldNome.requestFocus();
        jComboBoxRua.setEnabled(true);
        jButtonRua.setEnabled(true);
        jTextFieldNome.requestFocus();
       
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jFormattedTextFieldFone.setText("");
        jTextFieldNumero.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldCod.setText("");        
        jTextFieldBairro.setText("");
        jTextFieldNome.setEnabled(false);
        jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldPesquisa.setEnabled(true);
        jButtonPesquisar.setEnabled(true);      
        jTextFieldBairro.setEnabled(false);
        jButton1.setEnabled(false);
         jComboBoxRua.setEnabled(false);
        jButtonRua.setEnabled(false);
       
      
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
     mod.setPesquisa(jTextFieldPesquisa.getText());
     preencherTabela("select *from clientes where cliente_nome ilike'%" + mod.getPesquisa()+"%' order by cliente_nome");
    
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir o cliente "+jTextFieldNome.getText());
   switch (resposta) {
        case JOptionPane.NO_OPTION:
         mod.setPesquisa(jTextFieldPesquisa.getText());
     preencherTabela("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%' order by cliente_nome");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldPesquisa.setEnabled(true);
       jButtonPesquisar.setEnabled(true);
        jFormattedTextFieldFone.setText("");
       jTextFieldNumero.setText("");
      jTextFieldBairro.setText("");
        jTextFieldCod.setText("");
        jTextFieldBairro.setText("");
       jTextFieldNome.setEnabled(false);
       jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);    
       jTextFieldBairro.setEnabled(false);
        jButton1.setEnabled(false);
        jComboBoxRua.setEnabled(false);
        jButtonRua.setEnabled(false);
            break;
        case JOptionPane.CANCEL_OPTION:
        mod.setPesquisa(jTextFieldPesquisa.getText());
     preencherTabela("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%' order by cliente_nome");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldBairro.setText("");
        jTextFieldPesquisa.setEnabled(true);
       jButtonPesquisar.setEnabled(true);
        jFormattedTextFieldFone.setText("");
       jTextFieldNumero.setText("");
       jTextFieldPesquisa.setText("");
        jTextFieldCod.setText("");
       jTextFieldNome.setEnabled(false);
       jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);   
       jComboBoxRua.setEnabled(false);
        jButtonRua.setEnabled(false);
            break;
        case JOptionPane.YES_OPTION:
        mod.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
       control.Excluir(mod);
     mod.setPesquisa(jTextFieldPesquisa.getText());
     preencherTabela("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%' order by cliente_nome");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldPesquisa.setEnabled(true);
       jButtonPesquisar.setEnabled(true);
        jFormattedTextFieldFone.setText("");
       jTextFieldNumero.setText("");
       jTextFieldPesquisa.setText("");
        jTextFieldCod.setText("");
        jTextFieldBairro.setText("");
       jTextFieldNome.setEnabled(false);
       jTextFieldRua.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jFormattedTextFieldFone.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
       jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
       
       jComboBoxRua.setEnabled(false);
        jButtonRua.setEnabled(false);
       break;
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        String cliente_nome =""+jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        conex.Conexao();
        conex.executaSql("select * from clientes where cliente_nome='"+ cliente_nome +"'");
           try {
               conex.rs.first();
               jTextFieldCod.setText(String.valueOf(conex.rs.getInt("cliente_codigo")));
               jTextFieldNome.setText(conex.rs.getString("cliente_nome"));
               jFormattedTextFieldFone.setText(conex.rs.getString("cliente_fone"));
               jTextFieldRua.setText(conex.rs.getString("cliente_rua"));
               jTextFieldNumero.setText(conex.rs.getString("cliente_numero"));
               jTextFieldBairro.setText(conex.rs.getString("cliente_bairro"));
              
               jTextFieldNome.setEnabled(false);
               jTextFieldRua.setEnabled(false);
               jButtonPesquisar.setEnabled(false);
               jFormattedTextFieldFone.setEnabled(false);
               jTextFieldBairro.setEnabled(false);
               jButton1.setEnabled(false);              
               jTextFieldNumero.setEnabled(false);
               jTextFieldPesquisa.setEnabled(false);
               jTextFieldCod.setEnabled(false);
               jButtonNovo.setEnabled(false);
               jButtonSalvar.setEnabled(false);
               jButtonEditar.setEnabled(true);
               jButtonExcluir.setEnabled(true);
               jButtonCancelar.setEnabled(true);
              
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
      
           
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag =2;
        jTextFieldNome.setEnabled(true);
        jTextFieldRua.setEnabled(true);
        jComboBoxBairro.setEnabled(true);
       
        jFormattedTextFieldFone.setEnabled(true);
        jTextFieldNumero.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldBairro.setEnabled(true);
        jButton1.setEnabled(true);
        jComboBoxRua.setEnabled(true);
        jButtonRua.setEnabled(true);
          PreencherBairro();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jComboBoxBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxBairroMouseClicked
      
    }//GEN-LAST:event_jComboBoxBairroMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String referencia = (String) jComboBoxBairro.getSelectedItem();
        jTextFieldBairro.setText(referencia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRuaActionPerformed
       String referencia = (String) jComboBoxRua.getSelectedItem();
        jTextFieldRua.setText(referencia);
    }//GEN-LAST:event_jButtonRuaActionPerformed

    private void jComboBoxRuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxRuaMouseClicked
    
    }//GEN-LAST:event_jComboBoxRuaMouseClicked

    private void jComboBoxRuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxRuaMouseEntered
         PreencherRua();
    }//GEN-LAST:event_jComboBoxRuaMouseEntered
public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Nome","Telefone","Rua","Numero","Bairro"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("cliente_nome"),conex.rs.getString("cliente_fone"),conex.rs.getString("cliente_rua"),conex.rs.getString("cliente_numero"),conex.rs.getString("cliente_bairro")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTableClientes.setModel(modelo);
           jTableClientes.getColumnModel ().getColumn(0).setPreferredWidth(200);
           jTableClientes.getColumnModel().getColumn(0).setResizable(false);
           jTableClientes.getColumnModel ().getColumn(1).setPreferredWidth(120);
           jTableClientes.getColumnModel().getColumn(1).setResizable(false);
           jTableClientes.getColumnModel ().getColumn(2).setPreferredWidth(180);
           jTableClientes.getColumnModel().getColumn(2).setResizable(false);
           jTableClientes.getColumnModel ().getColumn(3).setPreferredWidth(100);
           jTableClientes.getColumnModel().getColumn(3).setResizable(false);
           jTableClientes.getColumnModel ().getColumn(4).setPreferredWidth(110);
           jTableClientes.getColumnModel().getColumn(4).setResizable(false);
           jTableClientes.getTableHeader().setReorderingAllowed(false);
           jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
           jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       //    jTableClientes.setSelectionBackground(Color.RED);
          
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
            java.util.logging.Logger.getLogger(CadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDeCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRua;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxBairro;
    private javax.swing.JComboBox<String> jComboBoxRua;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldRua;
    // End of variables declaration//GEN-END:variables
}
