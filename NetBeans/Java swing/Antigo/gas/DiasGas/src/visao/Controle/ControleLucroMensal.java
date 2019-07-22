package visao.Controle;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansBaixa;
import modeloBeans.BeansCartoes;
import modeloBeans.BeansGastos;
import modeloBeans.BeansVendas;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;
import modeloDao.DaoGastos;

public class ControleLucroMensal extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    BeansVendas mod = new BeansVendas();
    BeansBaixa modBaixa = new BeansBaixa();
    BeansGastos moda = new BeansGastos();
    BeansCartoes Cartoes = new BeansCartoes();
    DaoGastos controlg = new DaoGastos();
    GregorianCalendar calendar = new GregorianCalendar();
    DecimalFormat df = new DecimalFormat("###,###,##0.00");//

    public ControleLucroMensal() {
        initComponents();
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextFieldData.setText(dtHoje);
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGastos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonSomaGastos = new javax.swing.JButton();
        jButtonSomaApurado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonApuradoParcial = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableBaixas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButtonSomarBaixas = new javax.swing.JButton();
        jButtonGastoDiario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonCalcularLucro = new javax.swing.JButton();
        jFormattedTextFieldData = new javax.swing.JTextField();

        jTextFieldNome.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableVendas);

        jTableGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableGastos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tabela de gastos");

        jButtonSomaGastos.setText("Somar gastos");
        jButtonSomaGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSomaGastos.setEnabled(false);
        jButtonSomaGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomaGastosActionPerformed(evt);
            }
        });

        jButtonSomaApurado.setText("Calcular lucro diário");
        jButtonSomaApurado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSomaApurado.setEnabled(false);
        jButtonSomaApurado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomaApuradoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tabela de vendas");

        jButtonApuradoParcial.setText("Somar lucro parcial");
        jButtonApuradoParcial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonApuradoParcial.setEnabled(false);
        jButtonApuradoParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApuradoParcialActionPerformed(evt);
            }
        });

        jTableBaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableBaixas);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tabela de baixas");

        jButtonSomarBaixas.setText("Somar Baixas");
        jButtonSomarBaixas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSomarBaixas.setEnabled(false);
        jButtonSomarBaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomarBaixasActionPerformed(evt);
            }
        });

        jButtonGastoDiario.setText("Calcular gasto diario");
        jButtonGastoDiario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGastoDiario.setEnabled(false);
        jButtonGastoDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastoDiarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel4)
                .addGap(256, 256, 256)
                .addComponent(jLabel2)
                .addGap(202, 202, 202)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButtonSomarBaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSomaGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGastoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApuradoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSomaApurado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(460, 460, 460))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSomaApurado)
                    .addComponent(jButtonSomaGastos)
                    .addComponent(jButtonApuradoParcial)
                    .addComponent(jButtonSomarBaixas)
                    .addComponent(jButtonGastoDiario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de lucratividade mensal");

        jLabel6.setText("Data");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButton1.setText("Ver lucro diário");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonCalcularLucro.setText("Calcular lucro");
        jButtonCalcularLucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCalcularLucro.setEnabled(false);
        jButtonCalcularLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularLucroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCalcularLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(366, 366, 366))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButton1)
                    .addComponent(jButtonCalcularLucro)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        setSize(new java.awt.Dimension(1043, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSomaApuradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomaApuradoActionPerformed
        List<String> Dias;
        Dias = new ArrayList<String>();

        for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
            Dias.add(jTableVendas.getValueAt(i, 0).toString());
        }
        Set<String> semRepeticao = new LinkedHashSet<String>();
        for (String valor : Dias) {
            semRepeticao.add(valor);
        }
        int DiasTrabalhados = semRepeticao.size();

        double count = 0;
        for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTableVendas.getValueAt(i, 3).toString());
        }
        if (count == 0 || DiasTrabalhados == 0) {
            JOptionPane.showMessageDialog(null, "não existem vendas");
        } else {
            double resultado = count / DiasTrabalhados;

            String dx = df.format(resultado);
            JOptionPane.showMessageDialog(null, "A media de lucro por dia é de R$ " + dx + " reais em um perido de " + DiasTrabalhados + " dias trabalhados");
        }
    }//GEN-LAST:event_jButtonSomaApuradoActionPerformed

    private void jButtonSomaGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomaGastosActionPerformed

        double count = 0;
        for (int i = 0; i <= jTableGastos.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTableGastos.getValueAt(i, 1).toString());
        }
        String dx = df.format(count);
        JOptionPane.showMessageDialog(null, "O valor das despesas é R$ " + dx + " reais");

    }//GEN-LAST:event_jButtonSomaGastosActionPerformed

    private void jButtonCalcularLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularLucroActionPerformed
        double countLucroParcial = 0;
        for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
            countLucroParcial += Double.parseDouble(jTableVendas.getValueAt(i, 3).toString());
        }
        double countBaixa = 0;
        for (int i = 0; i <= jTableBaixas.getRowCount() - 1; i++) {
            countBaixa += Double.parseDouble(jTableBaixas.getValueAt(i, 2).toString());
        }
        double countGasto = 0;
        for (int i = 0; i <= jTableGastos.getRowCount() - 1; i++) {
            countGasto += Double.parseDouble(jTableGastos.getValueAt(i, 1).toString());
        }
        double resulta = (countLucroParcial - countGasto) - countBaixa;

        String dx = df.format(resulta);
        JOptionPane.showMessageDialog(null, "O lucro é de " + dx + " reais");


    }//GEN-LAST:event_jButtonCalcularLucroActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       
        if (jFormattedTextFieldData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira uma data");
            jFormattedTextFieldData.requestFocus();
        }else {
            moda.setPesquisarGasto(jFormattedTextFieldData.getText());
            preencherTabelaGastos("select *from gastos where data_gasto like'%" + moda.getPesquisarGasto() + "%'order by data_gasto");
            jButtonSomaGastos.setEnabled(true);

            mod.setPesquisar(jFormattedTextFieldData.getText());
            preencherTabelaVendas("select *from vendas where data_venda like'%" + mod.getPesquisar() + "%' order by codigo_venda");

            modBaixa.setPesquisar(jFormattedTextFieldData.getText());
            preencherTabela("select *from baixas where data_baixa like'%" + modBaixa.getPesquisar() + "%' order by data_baixa");

            jButtonApuradoParcial.setEnabled(true);
            jButtonSomaApurado.setEnabled(true);
            jButtonCalcularLucro.setEnabled(true);
            jButtonSomarBaixas.setEnabled(true);
            jButtonGastoDiario.setEnabled(true);

        
       }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonApuradoParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApuradoParcialActionPerformed
        double countLucroParcial = 0;
        for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
            countLucroParcial += Double.parseDouble(jTableVendas.getValueAt(i, 3).toString());
        }
        String dx = df.format(countLucroParcial);
        JOptionPane.showMessageDialog(null, "O lucro parcial é de R$ " + dx + " reais");
    }//GEN-LAST:event_jButtonApuradoParcialActionPerformed

    private void jButtonSomarBaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomarBaixasActionPerformed
        double count = 0;
        for (int i = 0; i <= jTableBaixas.getRowCount() - 1; i++) {
            count += Double.parseDouble(jTableBaixas.getValueAt(i, 2).toString());
        }
        String dx = df.format(count);
        JOptionPane.showMessageDialog(null, "O valor em baixas é R$ " + dx + " reais");
    }//GEN-LAST:event_jButtonSomarBaixasActionPerformed

    private void jButtonGastoDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGastoDiarioActionPerformed
        List<String> Dias;
        Dias = new ArrayList<String>();

        for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
            Dias.add(jTableVendas.getValueAt(i, 0).toString());
        }
        Set<String> semRepeticao = new LinkedHashSet<String>();
        for (String valor : Dias) {
            semRepeticao.add(valor);
        }
        int DiasTrabalhados = semRepeticao.size();

        double gastos = 0;
        for (int i = 0; i <= jTableGastos.getRowCount() - 1; i++) {
            gastos += Double.parseDouble(jTableGastos.getValueAt(i, 1).toString());
        }
        if (gastos == 0 || DiasTrabalhados == 0) {
            JOptionPane.showMessageDialog(null, "Ainda não há gastos este més ou ainda não foi feito nenhuma venda");
        } else {
            double resultado = gastos / DiasTrabalhados;

            String dx = df.format(resultado);
            JOptionPane.showMessageDialog(null, "O gasto diário da empresa é de R$ " + dx + " reais, em um periodo de " + DiasTrabalhados + " dias trabalhados");
        }
    }//GEN-LAST:event_jButtonGastoDiarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int tamanh = jFormattedTextFieldData.getText().length();
       
       if(tamanh < 7){
          JOptionPane.showMessageDialog(rootPane,"Insira uma data valida");
          Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.format(d);
        String dtHoje;
        dtHoje = dateFormat.format(d);
        jFormattedTextFieldData.setText(dtHoje);
       }else{             
      ArrayList<String> Cartoes = new ArrayList();
        try {
            conex.Conexao();
            mod.setPesquisar(jFormattedTextFieldData.getText());
            conex.executaSql("SELECT DISTINCT data_venda FROM vendas WHERE data_venda like'%" + mod.getPesquisar() + "%' order by data_venda");
            conex.rs.first();
            do {
                Cartoes.add(conex.rs.getString("data_venda"));
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        conex.Desconecta();    
        int index =0;
        int tamanho = Cartoes.size();
        String[] Data = new String[tamanho];
       
        for (String dados : Cartoes) {
            mod.setPesquisar(dados);
            preencherTabelaVendas("select *from vendas where data_venda like'%" + mod.getPesquisar() + "%' order by codigo_venda");
           double Lucro = 0;
           for (int i = 0; i <= jTableVendas.getRowCount() - 1; i++) {
              Lucro += Double.parseDouble(jTableVendas.getValueAt(i, 3).toString());
        }
          String dx = df.format(Lucro);
          Data[index]="Data: "+ dados +"      Valor: "+dx;           
          index++;          
        }  
        moda.setPesquisarGasto(jFormattedTextFieldData.getText());           
           preencherTabelaGastos("select *from gastos where data_gasto like'%" + moda.getPesquisarGasto() + "%'order by data_gasto");
            jButtonSomaGastos.setEnabled(true);

            mod.setPesquisar(jFormattedTextFieldData.getText());
            preencherTabelaVendas("select *from vendas where data_venda like'%" + mod.getPesquisar() + "%' order by codigo_venda");

            modBaixa.setPesquisar(jFormattedTextFieldData.getText());
            preencherTabela("select *from baixas where data_baixa like'%" + modBaixa.getPesquisar() + "%' order by data_baixa");

            jButtonApuradoParcial.setEnabled(true);
            jButtonSomaApurado.setEnabled(true);
            jButtonCalcularLucro.setEnabled(true);
            jButtonSomarBaixas.setEnabled(true);
            jButtonGastoDiario.setEnabled(true);
         
            String pagamento = String.valueOf(JOptionPane.showInputDialog(null,
            "Veja aqui os valores lucrados durante o mês","",JOptionPane.INFORMATION_MESSAGE,null,Data,Data[0]));
     
       }
    }//GEN-LAST:event_jButton1ActionPerformed
      public void preencherTabelaGastos(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Descrição do gasto", "Valor", "Data"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("descricao_gasto"), conex.rs.getDouble("valor_gasto"), conex.rs.getString("data_gasto")});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableGastos.setModel(modelo);
        jTableGastos.getColumnModel().getColumn(0).setPreferredWidth(140);
        jTableGastos.getColumnModel().getColumn(0).setResizable(false);
        jTableGastos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableGastos.getColumnModel().getColumn(1).setResizable(false);
        jTableGastos.getColumnModel().getColumn(2).setPreferredWidth(73);
        jTableGastos.getColumnModel().getColumn(2).setResizable(false);

        jTableGastos.getTableHeader().setReorderingAllowed(false);
        jTableGastos.setAutoResizeMode(jTableGastos.AUTO_RESIZE_OFF);
        jTableGastos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    public void preencherTabelaVendas(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Data", "Venda", "Custo", "Lucro"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                double Lucro = conex.rs.getDouble("valor_vendac") - conex.rs.getDouble("valor_custo");
                DecimalFormat fmt = new DecimalFormat("0.00");
                String string = fmt.format(Lucro);
                String[] part = string.split("[,]");
                String string2 = part[0] + "." + part[1];
                double preco = Double.parseDouble(string2);

                dados.add(new Object[]{conex.rs.getString("data_venda"), conex.rs.getDouble("valor_vendac"), conex.rs.getDouble("valor_custo"), preco});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableVendas.setModel(modelo);
        jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(73);
        jTableVendas.getColumnModel().getColumn(0).setResizable(false);
        jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(75);
        jTableVendas.getColumnModel().getColumn(1).setResizable(false);
        jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(72);
        jTableVendas.getColumnModel().getColumn(2).setResizable(false);
        jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTableVendas.getColumnModel().getColumn(3).setResizable(false);
        jTableVendas.getTableHeader().setReorderingAllowed(false);
        jTableVendas.setAutoResizeMode(jTableVendas.AUTO_RESIZE_OFF);
        jTableVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.Desconecta();
    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Motivo","Qtd", "Valor", "Data"};
        conex.Conexao();
        conex.executaSql(sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getString("motivo_baixa"),conex.rs.getString("quatidade_baixa"), conex.rs.getDouble("valor"), conex.rs.getString("data_baixa")});
            } while (conex.rs.next());
        } catch (SQLException ex) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableBaixas.setModel(modelo);
        jTableBaixas.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTableBaixas.getColumnModel().getColumn(0).setResizable(false);
        jTableBaixas.getColumnModel().getColumn(1).setPreferredWidth(45);
        jTableBaixas.getColumnModel().getColumn(1).setResizable(false);
        jTableBaixas.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTableBaixas.getColumnModel().getColumn(2).setResizable(false);
        jTableBaixas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableBaixas.getColumnModel().getColumn(3).setResizable(false);
        jTableBaixas.getTableHeader().setReorderingAllowed(false);
        jTableBaixas.setAutoResizeMode(jTableBaixas.AUTO_RESIZE_OFF);
        jTableBaixas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            java.util.logging.Logger.getLogger(ControleLucroMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLucroMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLucroMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLucroMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleLucroMensal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonApuradoParcial;
    private javax.swing.JButton jButtonCalcularLucro;
    private javax.swing.JButton jButtonGastoDiario;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSomaApurado;
    private javax.swing.JButton jButtonSomaGastos;
    private javax.swing.JButton jButtonSomarBaixas;
    private javax.swing.JTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableBaixas;
    private javax.swing.JTable jTableGastos;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
