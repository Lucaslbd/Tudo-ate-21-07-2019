package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansPaciente;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoPacientes;


public class FormPaciente extends javax.swing.JFrame {
    BeansPaciente mod = new BeansPaciente();
    DaoPacientes control = new DaoPacientes();
    ConexaoBD conex = new ConexaoBD();
    int flag = 0;
    
    public FormPaciente() {
        initComponents();
       preencherTabela("select * from pacientes order by pac_nome");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldRg = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jLabel3.setText("Nascimento");

        jlabel3.setText("RG");

        jlabel4.setText("Telefone");

        jTextFieldNome.setEnabled(false);

        try {
            jFormattedTextFieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldNascimento.setEnabled(false);

        jFormattedTextFieldRg.setEnabled(false);

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefone.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Cidade");

        jTextFieldCidade.setEnabled(false);

        jLabel6.setText("Bairro");

        jTextFieldBairro.setEnabled(false);

        jLabel7.setText("Rua");

        jTextFieldRua.setEnabled(false);

        jLabel8.setText("Numero");

        jTextFieldNumero.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCidade)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Endereço");

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78)
                                                .addComponent(jlabel4))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(109, 109, 109)
                                                .addComponent(jlabel3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jFormattedTextFieldRg)
                                            .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 17, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNovo)
                            .addComponent(jLabel9)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlabel3)
                                    .addComponent(jFormattedTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel4)
                            .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de pacientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(736, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
      if(jTextFieldNome.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nome do Paciente");
         jTextFieldNome.requestFocus();
     }else if(jFormattedTextFieldNascimento.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o nascimento do paciente");
         jFormattedTextFieldNascimento.requestFocus();
     }else if(jFormattedTextFieldRg.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o rg do paciente");
         jFormattedTextFieldRg.requestFocus();
     }else if(jFormattedTextFieldTelefone.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Insira o telefone do paciente");
         jFormattedTextFieldTelefone.requestFocus();
         
     }else
        
      if(flag==1){
      mod.setNomePac(jTextFieldNome.getText());
      mod.setRg(jFormattedTextFieldRg.getText());
      mod.setTelefone(jFormattedTextFieldTelefone.getText());
      mod.setCidade(jTextFieldCidade.getText());
      mod.setBairro(jTextFieldBairro.getText());
      mod.setRua(jTextFieldRua.getText());
      mod.setNumero(jTextFieldNumero.getText());
      mod.setNascimento(jFormattedTextFieldNascimento.getText());
      control.Salvar(mod);
      jTextFieldNome.setText("");
      jFormattedTextFieldNascimento.setText("");
      jFormattedTextFieldTelefone.setText("");
      jFormattedTextFieldRg.setText("");
      jTextFieldCidade.setText("");
      jTextFieldBairro.setText("");
      jTextFieldRua.setText("");
      jTextFieldNumero.setText("");
      jTextFieldNome.setEnabled(false);
      jFormattedTextFieldNascimento.setEnabled(false);
      jFormattedTextFieldTelefone.setEnabled(false);
      jFormattedTextFieldRg.setEnabled(false);
      jTextFieldCidade.setEnabled(false);
      jTextFieldBairro.setEnabled(false);
      jTextFieldRua.setEnabled(false);
      jTextFieldNumero.setEnabled(false);  
      jButtonCancelar.setEnabled(false);
      jButtonSalvar.setEnabled(false); 
      jButtonNovo.setEnabled(true);
       preencherTabela("select * from pacientes order by pac_nome");
      }else{
        mod.setNomePac(jTextFieldNome.getText());
      mod.setRg(jFormattedTextFieldRg.getText());
      mod.setTelefone(jFormattedTextFieldTelefone.getText());
      mod.setCidade(jTextFieldCidade.getText());
      mod.setBairro(jTextFieldBairro.getText());
      mod.setRua(jTextFieldRua.getText());
      mod.setNumero(jTextFieldNumero.getText());
      mod.setNascimento(jFormattedTextFieldNascimento.getText());
      control.Editar(mod);
      jTextField1.setText("");
      jTextFieldNome.setText("");
      jFormattedTextFieldNascimento.setText("");
      jFormattedTextFieldTelefone.setText("");
      jFormattedTextFieldRg.setText("");
      jTextFieldCidade.setText("");
      jTextFieldBairro.setText("");
      jTextFieldRua.setText("");
      jTextFieldNumero.setText("");
      jTextFieldPesquisar.setText("");
      jTextFieldNome.setEnabled(false);
      jFormattedTextFieldNascimento.setEnabled(false);
      jFormattedTextFieldTelefone.setEnabled(false);
      jFormattedTextFieldRg.setEnabled(false);
      jTextFieldCidade.setEnabled(false);
      jTextFieldBairro.setEnabled(false);
      jTextFieldRua.setEnabled(false);
      jTextFieldNumero.setEnabled(false);  
      jButtonCancelar.setEnabled(false);
      jButtonSalvar.setEnabled(false); 
      jButtonNovo.setEnabled(true); 
       preencherTabela("select * from pacientes order by pac_nome");
      }      
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag =1;
      jTextFieldNome.setEnabled(true);
      jFormattedTextFieldNascimento.setEnabled(true);
      jFormattedTextFieldTelefone.setEnabled(true);
      jFormattedTextFieldRg.setEnabled(true);
      jTextFieldCidade.setEnabled(true);
      jTextFieldBairro.setEnabled(true);
      jTextFieldRua.setEnabled(true);
      jTextFieldNumero.setEnabled(true);
      jButtonCancelar.setEnabled(true);
      jButtonSalvar.setEnabled(true);
      jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
      jTextField1.setText("");
      jTextFieldNome.setText("");
      jFormattedTextFieldNascimento.setText("");
      jFormattedTextFieldTelefone.setText("");
      jFormattedTextFieldRg.setText("");
      jTextFieldCidade.setText("");
      jTextFieldBairro.setText("");
      jTextFieldRua.setText("");
      jTextFieldNumero.setText("");
      jTextFieldPesquisar.setText("");
      jTextFieldNome.setEnabled(false);
      jFormattedTextFieldNascimento.setEnabled(false);
      jFormattedTextFieldTelefone.setEnabled(false);
      jFormattedTextFieldRg.setEnabled(false);
      jTextFieldCidade.setEnabled(false);
      jTextFieldBairro.setEnabled(false);
      jTextFieldRua.setEnabled(false);
      jTextFieldNumero.setEnabled(false);
      jButtonCancelar.setEnabled(false);
      jButtonEditar.setEnabled(false);
      jButtonExcluir.setEnabled(false);
      jButtonNovo.setEnabled(true); 
      jButtonSalvar.setEnabled(false);
      preencherTabela("select * from pacientes order by pac_nome");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
      mod.setPesquisar(jTextFieldPesquisar.getText());
       BeansPaciente model = control.buscaPaciente(mod);
       jTextFieldNome.setText(model.getNomePac());
       jTextField1.setText(String.valueOf(model.getCodPac()));
       jFormattedTextFieldNascimento.setText(String.valueOf(model.getNascimento()));
       jFormattedTextFieldRg.setText(String.valueOf(model.getRg()));
       jFormattedTextFieldTelefone.setText(String.valueOf(model.getTelefone()));
       jTextFieldCidade.setText(String.valueOf(model.getCidade()));
       jTextFieldBairro.setText(String.valueOf(model.getBairro()));
       jTextFieldRua.setText(String.valueOf(model.getRua()));
       jTextFieldNumero.setText(String.valueOf(model.getNumero()));
       jTextFieldNome.setEnabled(false);
       jFormattedTextFieldNascimento.setEnabled(false);
       jFormattedTextFieldRg.setEnabled(false);
       jFormattedTextFieldTelefone.setEnabled(false);
       jTextFieldCidade.setEnabled(false);
       jTextFieldBairro.setEnabled(false);
       jTextFieldRua.setEnabled(false);
       jTextFieldNumero.setEnabled(false);
       jButtonEditar.setEnabled(true);
       jButtonExcluir.setEnabled(true);
       jButtonNovo.setEnabled(false);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(false);
       preencherTabela("select *from pacientes where pac_nome like'%" + mod.getPesquisar()+"%'");
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta ==JOptionPane.YES_OPTION){
        mod.setCodPac(Integer.parseInt(jTextField1.getText()));
        control.Excluir(mod);
       jTextField1.setText("");
       jTextFieldNome.setText("");
       jFormattedTextFieldNascimento.setText("");
       jFormattedTextFieldRg.setText("");
       jFormattedTextFieldTelefone.setText("");
       jTextFieldCidade.setText("");
       jTextFieldBairro.setText("");
       jTextFieldRua.setText("");
       jTextFieldNumero.setText("");
       jTextFieldPesquisar.setText("");
       jButtonNovo.setEnabled(true);
       jButtonCancelar.setEnabled(false);
       jButtonEditar.setEnabled(false);
       jButtonExcluir.setEnabled(false);
        preencherTabela("select * from pacientes order by pac_nome");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       flag =2;
       jTextFieldNome.setEnabled(true);
       jFormattedTextFieldNascimento.setEnabled(true);
       jFormattedTextFieldRg.setEnabled(true);
       jFormattedTextFieldRg.setEnabled(true);
       jFormattedTextFieldTelefone.setEnabled(true);
       jTextFieldCidade.setEnabled(true);
       jTextFieldBairro.setEnabled(true);
       jTextFieldRua.setEnabled(true);
       jTextFieldNumero.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonExcluir.setEnabled(false);
       jButtonEditar.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked
       String pac_nome =""+jTablePacientes.getValueAt(jTablePacientes.getSelectedRow(), 1);
        conex.Conexao();
        conex.executaSql("select * from pacientes where pac_nome='"+ pac_nome +"'");
           try {
               conex.rs.first();
               jTextField1.setText(String.valueOf(conex.rs.getInt("pac_cod")));
               jTextFieldNome.setText(conex.rs.getString("pac_nome"));
               jFormattedTextFieldNascimento.setText(conex.rs.getString("pac_nascimento"));
               jFormattedTextFieldRg.setText(conex.rs.getString("pac_rg"));
               jFormattedTextFieldTelefone.setText(conex.rs.getString("pac_fone"));
               jTextFieldCidade.setText(conex.rs.getString("pac_cidade"));
               jTextFieldBairro.setText(conex.rs.getString("pac_bairro"));
               jTextFieldRua.setText(conex.rs.getString("pac_rua"));
               jTextFieldNumero.setText(conex.rs.getString("pac_numero"));
                jButtonEditar.setEnabled(true);
                jButtonExcluir.setEnabled(true);
                jButtonNovo.setEnabled(false);
                jButtonCancelar.setEnabled(true);
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao selecionar itens\n"+ ex.getMessage());
           }
        conex.Desconecta();
    }//GEN-LAST:event_jTablePacientesMouseClicked
public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID","Nome","Rg","Telefone","Cidade","Bairro","rua","numero","Nascimento"};
        conex.Conexao();
        conex.executaSql(sql);
           try {
               conex.rs.first();
               do{
                 dados.add(new Object[]{conex.rs.getString("pac_cod"),conex.rs.getString("pac_nome"), conex.rs.getString("pac_rg"), conex.rs.getString("pac_fone"), conex.rs.getString("pac_cidade"), conex.rs.getString("pac_bairro"), conex.rs.getString("pac_rua"), conex.rs.getString("pac_numero"),conex.rs.getString("pac_nascimento")});
                }while(conex.rs.next());
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane,"erro"+ ex.getMessage());
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           jTablePacientes.setModel(modelo);
           jTablePacientes.getColumnModel ().getColumn(0).setPreferredWidth(30);
           jTablePacientes.getColumnModel().getColumn(0).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(1).setPreferredWidth(200);
           jTablePacientes.getColumnModel().getColumn(1).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(2).setPreferredWidth(110);
           jTablePacientes.getColumnModel().getColumn(2).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(3).setPreferredWidth(120);
           jTablePacientes.getColumnModel().getColumn(3).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(4).setPreferredWidth(120);
           jTablePacientes.getColumnModel().getColumn(4).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(5).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(5).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(6).setPreferredWidth(180);
           jTablePacientes.getColumnModel().getColumn(6).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(7).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(7).setResizable(false);
           jTablePacientes.getColumnModel ().getColumn(8).setPreferredWidth(100);
           jTablePacientes.getColumnModel().getColumn(8).setResizable(false);
           jTablePacientes.getTableHeader().setReorderingAllowed(false);
           jTablePacientes.setAutoResizeMode(jTablePacientes.AUTO_RESIZE_OFF);
           jTablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
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
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldRg;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
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
    private javax.swing.JTable jTablePacientes;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    // End of variables declaration//GEN-END:variables
}
