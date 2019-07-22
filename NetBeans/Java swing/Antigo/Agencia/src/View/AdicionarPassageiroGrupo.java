package View;

import Beans.BeansAgencia;
import Beans.BeansClientes;
import Beans.BeansGrupos;
import Conection.ConexaoBD;
import Dao.DaoAgencia;
import Dao.DaoGrupos;
import TableModel.ModeloTabela;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class AdicionarPassageiroGrupo extends javax.swing.JFrame {
    int corrigir=0;
    ConexaoBD conex = new ConexaoBD();
    BeansClientes clientes = new BeansClientes();
    BeansGrupos grupos = new BeansGrupos();
    DaoGrupos control = new DaoGrupos();
    BeansAgencia agencia = new BeansAgencia();
    DaoAgencia control2 = new DaoAgencia();
    int codigo =0;
    int numeroPax;
    int numeroVagas;
    String nomeGrupo;
    ArrayList<String> NomeGrupo = new ArrayList();
    String cliente_nome;  
    
    
    public AdicionarPassageiroGrupo() {
        initComponents();
        PreencherGrupos();        
        PreencherAgencia();
        preencherCadastro();  
        jRadioButtonPassageiro.setSelected(true);
    }  
   
    public void preencherCadastro(){
         if(jComboBoxGrupos.getSelectedItem() == null) {        
       }else{
             
        String nome = (String) jComboBoxGrupos.getSelectedItem();
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where nomemelhorado='"+ nome +"'");
           try {
               conex.rs.first();               
               jTextFieldValor.setText(String.valueOf(conex.rs.getDouble("preco_venda")));
               numeroVagas =(conex.rs.getInt("vagas"));
               nomeGrupo = (conex.rs.getString("nome"));               
           
           conex.executaSql("select * from "+nomeGrupo+" ");
        try {
            conex.rs.first();
            ArrayList<String> NomePax = new ArrayList();
            do {                
                NomePax.add(conex.rs.getString("embarque"));
            } while (conex.rs.next());
            numeroPax = NomePax.size();            
        } catch (SQLException ex) {
            numeroPax =0;
        }           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro1"+ex.getMessage());
           }  
           
           conex.Desconecta();
     }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jComboBoxPesquisa = new javax.swing.JComboBox<>();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxFormaPagamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldParcelas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmbarque = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonIndicacoes = new javax.swing.JRadioButton();
        jComboBoxIndicacoes = new javax.swing.JComboBox<>();
        jTextFieldValorComissao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jRadioButtonTripulação = new javax.swing.JRadioButton();
        jRadioButtonPassageiro = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        jComboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Nascimento", "CPF", "RG", "Telefone" }));
        jComboBoxPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxPesquisaMouseEntered(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonConfirmarMouseEntered(evt);
            }
        });
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Forma de pagamento");

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão" }));

        jLabel4.setText("Numero de parcelas");

        jLabel5.setText("Valor do pacote");

        jLabel6.setText("Local de embarque");

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
                    .addComponent(jTextFieldParcelas)
                    .addComponent(jTextFieldValor)
                    .addComponent(jTextFieldEmbarque)
                    .addComponent(jComboBoxFormaPagamento, 0, 130, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEmbarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setText("Informar gratificação pelo cliente?");

        jRadioButtonIndicacoes.setText("Sim");
        jRadioButtonIndicacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIndicacoesActionPerformed(evt);
            }
        });

        jComboBoxIndicacoes.setEnabled(false);

        jTextFieldValorComissao.setEnabled(false);

        jLabel8.setText("Valor da comissão");

        jComboBoxGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGruposActionPerformed(evt);
            }
        });

        jRadioButtonTripulação.setText("Tripulação");
        jRadioButtonTripulação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTripulaçãoActionPerformed(evt);
            }
        });

        jRadioButtonPassageiro.setText("Passageiro");
        jRadioButtonPassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPassageiroActionPerformed(evt);
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
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonIndicacoes)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxIndicacoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldValorComissao)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addComponent(jComboBoxGrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonPassageiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonTripulação))
                            .addComponent(jTextFieldPesquisa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTripulação)
                    .addComponent(jRadioButtonPassageiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxIndicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonIndicacoes)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConfirmar)
                            .addComponent(jButtonCancelar))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Adicionando passageiro ao grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(320, 320, 320))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
     codigo = (int) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);  
       
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        if(jComboBoxGrupos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "O sistema ainda não possui grupos");   
             
        }else{
             pesquisar();
        }
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
          if(codigo==0){
              JOptionPane.showMessageDialog(rootPane,"Selecione um passageiro");
          }else if(numeroPax > numeroVagas){
              JOptionPane.showMessageDialog(rootPane,"O grupo está completo não existem mais vagas");           
          }else{
           if(jRadioButtonTripulação.isSelected()){
           int posicao = jComboBoxGrupos.getSelectedIndex();
           String tabela = NomeGrupo.get(posicao);         
            grupos.setCodigo(codigo);
            grupos.setFormaPagamento("Colaboração");
            grupos.setNumeroParcelas(0);
            grupos.setParcelasPagas(0);
            grupos.setValor(0);
            grupos.setEmbarque("Agência");
            grupos.setTipoPassageiro("Tripulação");
            control.Salvar(grupos, tabela);  
            /*jButtonConfirmar.setEnabled(false);           
            jComboBoxFormaPagamento.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jTextFieldEmbarque.setEnabled(false);      
            jComboBoxIndicacoes.setEnabled(false);
            jRadioButtonIndicacoes.setEnabled(false);
            jRadioButtonIndicacoes.setSelected(false);
            jRadioButtonTripulação.setSelected(false);
            jRadioButtonPassageiro.setSelected(false);
            jRadioButtonTripulação.setEnabled(true);
            jRadioButtonPassageiro.setEnabled(true); */       
            jTextFieldParcelas.setText("");
            jTextFieldValor.setText("");
            jTextFieldEmbarque.setText("");
            preencherVazia();
            codigo=0;
     }else{             
          int posicao = jComboBoxGrupos.getSelectedIndex();
          String tabela = NomeGrupo.get(posicao);        
         if (jTextFieldParcelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo numero de parcelas não pode estar vazio");
            jTextFieldParcelas.requestFocus();
        } else if (jTextFieldValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O campo valor não pode estar vazio");
            jTextFieldValor.requestFocus();
        }else if(jTextFieldEmbarque.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "O local de embarque precisa ser preenchido");
            jTextFieldEmbarque.requestFocus();
        }else if(jRadioButtonIndicacoes.isSelected()){
              if(jTextFieldValorComissao.getText().isEmpty()){
                  JOptionPane.showMessageDialog(rootPane,"Preencha o campo comissionamento"); 
                  jTextFieldValorComissao.requestFocus();
              }else{
                 agencia.setNome((String) jComboBoxIndicacoes.getSelectedItem());
                 agencia.setComissionamento(Double.parseDouble(jTextFieldValorComissao.getText()));
                 agencia.setGrupo((String) jComboBoxGrupos.getSelectedItem());
                 agencia.setCliente(codigo);
                 agencia.setSituacaoCliente("Confirmado");
                 agencia.setSituacaoPagamento("Aberto");      
                 control2.SalvarComissao(agencia);
                 grupos.setCodigo(codigo);
                 grupos.setFormaPagamento((String) jComboBoxFormaPagamento.getSelectedItem());
                 grupos.setNumeroParcelas(Integer.parseInt(jTextFieldParcelas.getText()));
                 grupos.setParcelasPagas(0);
                 grupos.setValor(Double.parseDouble(jTextFieldValor.getText()));
                 grupos.setEmbarque(jTextFieldEmbarque.getText());
                 grupos.setTipoPassageiro("Passageiro");
                 control.Salvar(grupos, tabela);
                 /*jButtonConfirmar.setEnabled(false);           
            jComboBoxFormaPagamento.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jTextFieldValorComissao.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jTextFieldEmbarque.setEnabled(false);      
            jComboBoxIndicacoes.setEnabled(false);
            jRadioButtonIndicacoes.setEnabled(false);
            jRadioButtonIndicacoes.setSelected(false);
            jRadioButtonTripulação.setSelected(false);
            jRadioButtonPassageiro.setSelected(false);
            jRadioButtonTripulação.setEnabled(true);
            jRadioButtonPassageiro.setEnabled(true);  */      
            jTextFieldParcelas.setText("");
            jTextFieldValor.setText("");
            jTextFieldEmbarque.setText("");
            jTextFieldValorComissao.setText("");
            pesquisar();
            codigo=0;
             preencherVazia();
              } 
        }else{
            grupos.setCodigo(codigo);
            grupos.setFormaPagamento((String) jComboBoxFormaPagamento.getSelectedItem());
            grupos.setNumeroParcelas(Integer.parseInt(jTextFieldParcelas.getText()));
            grupos.setParcelasPagas(0);
            grupos.setValor(Double.parseDouble(jTextFieldValor.getText()));
            grupos.setEmbarque(jTextFieldEmbarque.getText());
            grupos.setTipoPassageiro("Passageiro");
            control.Salvar(grupos, tabela);      
            
           /* jButtonConfirmar.setEnabled(false);           
            jComboBoxFormaPagamento.setEnabled(false);
            jTextFieldParcelas.setEnabled(false);
            jTextFieldValor.setEnabled(false);
            jTextFieldValorComissao.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jTextFieldEmbarque.setEnabled(false);      
            jComboBoxIndicacoes.setEnabled(false);
            jRadioButtonIndicacoes.setSelected(false);*/
                              
            jTextFieldParcelas.setText("");
            jTextFieldValor.setText("");
            jTextFieldEmbarque.setText("");
            jTextFieldValorComissao.setText("");
            preencherVazia();
            codigo=0;
                 
        }     
     }
          }             
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonConfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseEntered
         try {
            Integer.parseInt(jTextFieldParcelas.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldParcelas.getText())) {
                JOptionPane.showMessageDialog(null, "O campo parcelas somente pode receber numeros inteiros ex: 50");
                jTextFieldParcelas.setText("");
                jTextFieldParcelas.requestFocus();
            }
        }
         try {
            Double.parseDouble(jTextFieldValor.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValor.getText())) {
                JOptionPane.showMessageDialog(null, "O campo valor somente pode receber numeros reais ex: 50.31");
                jTextFieldValor.setText("");
                jTextFieldValor.requestFocus();
            }
        }
             try {
            Double.parseDouble(jTextFieldValorComissao.getText());
        } catch (NumberFormatException e) {
            if (!"".equals(jTextFieldValorComissao.getText())) {
                JOptionPane.showMessageDialog(null, "O campo comissão somente pode receber numeros reais ex: 50.31");
                jTextFieldValorComissao.setText("");
                jTextFieldValorComissao.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonConfirmarMouseEntered

    private void jComboBoxPesquisaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPesquisaMouseEntered
     
    }//GEN-LAST:event_jComboBoxPesquisaMouseEntered

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        jTextFieldParcelas.setText("");
        jTextFieldValor.setText("");
        jTextFieldEmbarque.setText("");
        jTextFieldValorComissao.setText("");
        preencherVazia();       
        codigo=0;
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonIndicacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIndicacoesActionPerformed
       if(jRadioButtonIndicacoes.isSelected()){
           if(jComboBoxIndicacoes.getSelectedItem() == null){
               JOptionPane.showMessageDialog(rootPane,"Não existem agencias cadastradas");
           }else{
        jComboBoxIndicacoes.setEnabled(true);
        jTextFieldValorComissao.setEnabled(true);           
       }
       }else{
           jComboBoxIndicacoes.setEnabled(false);
           jTextFieldValorComissao.setEnabled(false);
           jTextFieldValorComissao.setText("");
       }
    }//GEN-LAST:event_jRadioButtonIndicacoesActionPerformed

    private void jRadioButtonTripulaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTripulaçãoActionPerformed
 if(jComboBoxGrupos.getSelectedItem() == null) {
         JOptionPane.showMessageDialog(rootPane, "O sistema ainda não possui grupos"); 
         }else{
        jRadioButtonPassageiro.setSelected(false);
       if(!jRadioButtonTripulação.isSelected()){
         jRadioButtonTripulação.setSelected(true);
         
       }
        jButtonConfirmar.setEnabled(true);        
        jComboBoxFormaPagamento.setEnabled(false);
        jTextFieldParcelas.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jTextFieldEmbarque.setEnabled(false);       
        jRadioButtonIndicacoes.setEnabled(false);
         jTextFieldParcelas.setText("");
        jTextFieldValor.setText("");
        jTextFieldEmbarque.setText("");
        jTextFieldValorComissao.setText("");
 }
    }//GEN-LAST:event_jRadioButtonTripulaçãoActionPerformed

    private void jRadioButtonPassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPassageiroActionPerformed
        if(jComboBoxGrupos.getSelectedItem() == null) {
         JOptionPane.showMessageDialog(rootPane, "O sistema ainda não possui grupos"); 
         }else{
        jRadioButtonTripulação.setSelected(false);
        if(!jRadioButtonPassageiro.isSelected()){
         jRadioButtonPassageiro.setSelected(true);        
       }
        jButtonConfirmar.setEnabled(true);        
        jComboBoxFormaPagamento.setEnabled(true);
        jTextFieldParcelas.setEnabled(true);
        jTextFieldValor.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jTextFieldEmbarque.setEnabled(true);       
        jRadioButtonIndicacoes.setEnabled(true);
         preencherCadastro();
        }
    }//GEN-LAST:event_jRadioButtonPassageiroActionPerformed

    private void jComboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGruposActionPerformed
      if(corrigir==0){
          corrigir =1;
      }else{
        preencherCadastro();
       
      }
    }//GEN-LAST:event_jComboBoxGruposActionPerformed
    public void pesquisar(){
        clientes.setPesquisa(jTextFieldPesquisa.getText());
        if (jComboBoxPesquisa.getSelectedItem().equals("Nome")) {
            preencherTabela("select *from clientes where nome ilike'%" + clientes.getPesquisa() + "%' order by nome");
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Nascimento")) {
            preencherTabela("select *from clientes where nascimento ilike'%" + clientes.getPesquisa() + "%' order by nascimento");
        } else if (jComboBoxPesquisa.getSelectedItem().equals("RG")) {
            preencherTabela("select *from clientes where rg ilike'%" + clientes.getPesquisa() + "%' order by rg");
        } else if (jComboBoxPesquisa.getSelectedItem().equals("CPF")) {
            preencherTabela("select *from clientes where cpf ilike'%" + clientes.getPesquisa() + "%' order by cpf");
        } else if (jComboBoxPesquisa.getSelectedItem().equals("Telefone")) {
            preencherTabela("select *from clientes where telefone ilike'%" + clientes.getPesquisa() + "%' order by telefone");
        }
    }
    public void PreencherGrupos() {
          BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
          UIResource.setHorizontalAlignment(SwingConstants.CENTER);
          jComboBoxGrupos.setRenderer(UIResource);           
          jComboBoxGrupos.setBackground(Color.ORANGE); //Altera a cor do combobox
          jComboBoxGrupos.setForeground(Color.BLUE);
          
        conex.Conexao();
        conex.executaSql("select * from grupos_excursoes where situacao='Aberto' order by nomemelhorado");
        try {
            conex.rs.first();
            jComboBoxGrupos.removeAllItems();  
            NomeGrupo = new ArrayList();
            do {
                jComboBoxGrupos.addItem(conex.rs.getString("nomemelhorado"));
                NomeGrupo.add(conex.rs.getString("nome"));
                
            } while (conex.rs.next());
           
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }

    public void PreencherAgencia(){
        conex.Conexao();
        conex.executaSql("select * from agencias order by nome");
        try {
            conex.rs.first();
            jComboBoxIndicacoes.removeAllItems();           
            do {
                jComboBoxIndicacoes.addItem(conex.rs.getString("nome"));                
            } while (conex.rs.next());
           
        } catch (SQLException ex) {

        }
        conex.Desconecta();
    }
    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Nome", "Telefone", "RG", "CPF", "Nascimento"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("codigo"), conex.rs.getString("nome"), conex.rs.getString("telefone"), conex.rs.getString("rg"), conex.rs.getString("cpf"), conex.rs.getString("nascimento")});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(130);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(125);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //    jTableClientes.setSelectionBackground(Color.RED);
        conex.Desconecta();
    }

    public void preencherVazia() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Nome", "Telefone", "RG", "CPF", "Nascimento"};
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(130);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(125);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //    jTableClientes.setSelectionBackground(Color.RED);
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
            java.util.logging.Logger.getLogger(AdicionarPassageiroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarPassageiroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarPassageiroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarPassageiroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarPassageiroGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JComboBox<String> jComboBoxIndicacoes;
    private javax.swing.JComboBox<String> jComboBoxPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonIndicacoes;
    private javax.swing.JRadioButton jRadioButtonPassageiro;
    private javax.swing.JRadioButton jRadioButtonTripulação;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldEmbarque;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorComissao;
    // End of variables declaration//GEN-END:variables
}
