package visao;

import visao.Controle.ControleCartoes;
import visao.Controle.ControleLucroMensal;
import visao.Consulta.ConsultaBaixas;
import visao.Consulta.ConsultaDeClientes;
import visao.Controle.ControleGastos;
import visao.Consulta.ConsulaEstoque;
import visao.Consulta.ConsultaDeVendas;
import visao.Consulta.ConsultaNotas;
import visao.Cadastros.CadastroDeUsuarios;
import visao.Cadastros.CadastroDeMercadoria;
import visao.Cadastros.CadastroDeCliente;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modeloConection.ConexaoBD;
import visao.Cadastros.CadastroVeiculos;
import visao.Consulta.ConsultaAutonomia;
import visao.Consulta.ConsultaGastos;
import visao.Consulta.ConsultaTransferencia;
import visao.Controle.ControleLucroDiario;
import visao.Controle.EditarExcluir;
import visao.Controle.taxasCartoes;

public class TelaPrincipal extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    CadastroDeCliente telaClientes = new CadastroDeCliente();
    CadastroDeUsuarios telaUsuario = new CadastroDeUsuarios();
    CadastroDeMercadoria telaProduto = new CadastroDeMercadoria();
    ConsultaDeClientes telaConsultaCliente = new ConsultaDeClientes();
    ConsultaDeVendas telaConsultaDeVendas = new ConsultaDeVendas();
    Gastos telaGastos = new Gastos();
    ConsultaGastos telaConsultaGastos = new ConsultaGastos();
    ControleLucroMensal telaLucro = new ControleLucroMensal();
    ConsulaEstoque telaestoque = new ConsulaEstoque();
    ChegadaMercadoria tela12 = new ChegadaMercadoria();
    Baixa tela13 = new Baixa();
    ConsultaBaixas tela14 = new ConsultaBaixas();
    ConsultaNotas tela15 = new ConsultaNotas();
    transferencia tela16 = new transferencia();
    FrenteCaixa recebeTexto;
    PagarNotas tela18 = new PagarNotas();
    ConsultaAutonomia tela19 = new ConsultaAutonomia();
    EditarExcluir tela20 = new EditarExcluir();
    Autonomia tela21 = new Autonomia();
    ConsultaAutonomia tela22 = new ConsultaAutonomia();
    CadastroVeiculos tela23 = new CadastroVeiculos();
    ControleCartoes tela24 = new ControleCartoes();
    ConsultaTransferencia tela25 = new ConsultaTransferencia();
    ControleLucroDiario tela26 = new ControleLucroDiario();
    taxasCartoes tela27 = new taxasCartoes();
    Ligacoes tela28 = new Ligacoes();
    Calculadora tela29 = new Calculadora();
    Fechamento tela30 = new Fechamento();
    Historico tela31 = new Historico();

    public TelaPrincipal(String usuario) {
        initComponents();
        conex.Conexao();
        jLabelUsuario.setText(usuario);
        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        int seg = data.get(Calendar.SECOND);
        if (hora >= 06 && hora <= 12) {
            jLabelBom.setText("Bom dia");
        } else if (hora >= 13 && hora <= 18) {
            jLabelBom.setText("Boa tarde");
        } else {
            jLabelBom.setText("Boa noite");
        }
        controledeacesso();
    }

    private TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void controledeacesso() {
        String usuario = jLabelUsuario.getText();
        try {
            conex.executaSql("select * from usuarios where usuario_nome='" + usuario + "'");
            conex.rs.first();
            jTextFieldControle.setText(conex.rs.getString("usuario_tipo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar itens\n" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldControle = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelBom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBarra = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadastroDeCliente = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemCadastroDeProdutos = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuGastos = new javax.swing.JMenu();
        jMenuItemGastos = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNotas = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemConsultaClientes = new javax.swing.JMenuItem();
        jMenuItemConsultaGastos = new javax.swing.JMenuItem();
        jMenuItemConsultaBaixas = new javax.swing.JMenuItem();
        jMenuItemConsultaNotas = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItemEstoque = new javax.swing.JMenuItem();
        jMenuItemConsultaVendas = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        EditarExcluir = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItemLucros = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTextFieldControle.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Bem vindo ao System GLH2");
        jInternalFrame1.setVisible(true);

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos.png"))); // NOI18N
        jButton2.setToolTipText("Cadastrar produto");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios.png"))); // NOI18N
        jButton3.setToolTipText("cadastrar usuário");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gasto.png"))); // NOI18N
        jButton6.setToolTipText("Registrar gasto");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/registrar nota.png"))); // NOI18N
        jButton7.setToolTipText("Registrar nota");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar nota.png"))); // NOI18N
        jButton8.setToolTipText("Informar pagamento de nota");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste.png"))); // NOI18N
        jButton1.setToolTipText("Cadastrar cliente");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/baixa de mercadoria.png"))); // NOI18N
        jButton9.setToolTipText("Registrar baixa");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa de baixa.png"))); // NOI18N
        jButton13.setToolTipText("Consulta de baixas");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa nota.png"))); // NOI18N
        jButton14.setToolTipText("Consulta de notas");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        jButton16.setToolTipText("Sair");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consultaestoque_1.png"))); // NOI18N
        jButton17.setToolTipText("Consulta de estoque");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Consulta gastos.png"))); // NOI18N
        jButton11.setToolTipText("Consulta de gastos");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho de compras.png"))); // NOI18N
        jButton18.setToolTipText("Registrar venda");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisarAutonomia.png"))); // NOI18N
        jButton15.setToolTipText("Consulta de autonomia");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consultaVendas.png"))); // NOI18N
        jButton19.setToolTipText("Consulta de vendas");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/veiculos.png"))); // NOI18N
        jButton10.setToolTipText("Cadastro de veiculos");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscaCliente.png"))); // NOI18N
        jButton12.setToolTipText("Consulta de clientes");
        jButton12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addGap(8, 8, 8)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Olá");

        jLabelUsuario.setFont(new java.awt.Font("Century Gothic", 0, 28)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("jLabel1");

        jLabelBom.setFont(new java.awt.Font("Century Gothic", 0, 28)); // NOI18N
        jLabelBom.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBom.setText("jLabel2");

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Direitos reservados - JL Desenvolvimento de sistemas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBom)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelBom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Sistema de gerenciamento");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuCadastros.setText("Cadastros");

        jMenuItemCadastroDeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste.png"))); // NOI18N
        jMenuItemCadastroDeCliente.setText("Cadastro de clientes");
        jMenuItemCadastroDeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeClienteActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroDeCliente);

        jMenuItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios.png"))); // NOI18N
        jMenuItemUsuarios.setText("Cadastro de usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemUsuarios);

        jMenuItemCadastroDeProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos.png"))); // NOI18N
        jMenuItemCadastroDeProdutos.setText("Cadastro de produtos");
        jMenuItemCadastroDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeProdutosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroDeProdutos);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/veiculos.png"))); // NOI18N
        jMenuItem10.setText("Cadastro de veiculos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItem10);

        jMenuBarra.add(jMenuCadastros);

        jMenuVendas.setText("Vendas");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho de compras.png"))); // NOI18N
        jMenuItem4.setText("Registrar venda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItem4);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechamento.png"))); // NOI18N
        jMenuItem16.setText("Fechamento de caixa");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItem16);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/previsao.png"))); // NOI18N
        jMenuItem17.setText("Historico e previsões");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItem17);

        jMenuBarra.add(jMenuVendas);

        jMenu7.setText("Ligações");

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/chamada.png"))); // NOI18N
        jMenuItem14.setText("Verificar ligação");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuBarra.add(jMenu7);

        jMenuGastos.setText("Despesas");
        jMenuGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGastosActionPerformed(evt);
            }
        });

        jMenuItemGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gasto.png"))); // NOI18N
        jMenuItemGastos.setText("Registrar gasto");
        jMenuItemGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGastosActionPerformed(evt);
            }
        });
        jMenuGastos.add(jMenuItemGastos);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/combustivel.png"))); // NOI18N
        jMenuItem8.setText("Combustivel");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuGastos.add(jMenuItem8);

        jMenuBarra.add(jMenuGastos);

        jMenu1.setText("Notas");

        jMenuItemNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/registrar nota.png"))); // NOI18N
        jMenuItemNotas.setText("Registrar nota");
        jMenuItemNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNotasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNotas);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar nota.png"))); // NOI18N
        jMenuItem5.setText("Registrar pagamento");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transferencia.png"))); // NOI18N
        jMenuItem6.setText("Registrar transferência");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBarra.add(jMenu1);

        jMenu3.setText("Baixas");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/baixa de mercadoria.png"))); // NOI18N
        jMenuItem3.setText("Registrar Baixa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBarra.add(jMenu3);

        jMenuConsultas.setText("Consultas");

        jMenuItemConsultaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscaCliente.png"))); // NOI18N
        jMenuItemConsultaClientes.setText("Consulta de clientes");
        jMenuItemConsultaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaClientesActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaClientes);

        jMenuItemConsultaGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Consulta gastos.png"))); // NOI18N
        jMenuItemConsultaGastos.setText("Consulta de gastos");
        jMenuItemConsultaGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaGastosActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaGastos);

        jMenuItemConsultaBaixas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa de baixa.png"))); // NOI18N
        jMenuItemConsultaBaixas.setText("Consulta de baixas");
        jMenuItemConsultaBaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaBaixasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaBaixas);

        jMenuItemConsultaNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa nota.png"))); // NOI18N
        jMenuItemConsultaNotas.setText("Consulta Notas");
        jMenuItemConsultaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaNotasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaNotas);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisarAutonomia.png"))); // NOI18N
        jMenuItem7.setText("Consulta Autonomia");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItem7);

        jMenuItemEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consultaestoque_1.png"))); // NOI18N
        jMenuItemEstoque.setText("Consulta de estoque");
        jMenuItemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemEstoque);

        jMenuItemConsultaVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consultaVendas.png"))); // NOI18N
        jMenuItemConsultaVendas.setText("Consulta de vendas");
        jMenuItemConsultaVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaVendasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaVendas);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consultaTransferencia.png"))); // NOI18N
        jMenuItem9.setText("Consulta de transferência");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItem9);

        jMenuBarra.add(jMenuConsultas);

        jMenu4.setText("Controle");

        EditarExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lixeira.png"))); // NOI18N
        EditarExcluir.setText("Editar/Excluir");
        EditarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarExcluirActionPerformed(evt);
            }
        });
        jMenu4.add(EditarExcluir);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lucros.png"))); // NOI18N
        jMenu5.setText("Lucratividade");

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lucros.png"))); // NOI18N
        jMenuItem12.setText("Lucratividade diária");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItemLucros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lucros.png"))); // NOI18N
        jMenuItemLucros.setText("Lucratividade mensal");
        jMenuItemLucros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLucrosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemLucros);

        jMenu4.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/controleCartoes.png"))); // NOI18N
        jMenu6.setText("Controle de cartões");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/controleCartoes.png"))); // NOI18N
        jMenuItem13.setText("Taxas de juros");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/controleCartoes.png"))); // NOI18N
        jMenuItem11.setText("Controle de vendas aprovadas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenu4.add(jMenu6);

        jMenuBarra.add(jMenu4);

        jMenu2.setText("Ferramentas");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ferramentas.png"))); // NOI18N
        jMenuItem2.setText("Chamar tela de bem vindo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calculator.png"))); // NOI18N
        jMenuItem15.setText("Calculadora");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuBarra.add(jMenu2);

        jMenuSair.setText("Sair");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItem1);

        jMenuBarra.add(jMenuSair);

        setJMenuBar(jMenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItemCadastroDeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeClienteActionPerformed
        if (telaClientes == null) {
            telaClientes = new CadastroDeCliente();
            telaClientes.setVisible(true);
            telaClientes.setResizable(false);
        } else {
            telaClientes.setVisible(true);
            telaClientes.setResizable(false);
        }

    }//GEN-LAST:event_jMenuItemCadastroDeClienteActionPerformed

    private void jMenuItemConsultaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaClientesActionPerformed
        if (telaConsultaCliente == null) {
            telaConsultaCliente = new ConsultaDeClientes();
            telaConsultaCliente.setVisible(true);
            telaConsultaCliente.setResizable(false);
        } else {
            telaConsultaCliente.setVisible(true);
            telaConsultaCliente.setResizable(false);
        }

    }//GEN-LAST:event_jMenuItemConsultaClientesActionPerformed

    private void jMenuItemConsultaVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaVendasActionPerformed
        if (telaConsultaDeVendas == null) {
            telaConsultaDeVendas = new ConsultaDeVendas();
            telaConsultaDeVendas.setVisible(true);
            telaConsultaDeVendas.setResizable(false);
        } else {
            telaConsultaDeVendas.setVisible(true);
            telaConsultaDeVendas.setResizable(false);
        }

    }//GEN-LAST:event_jMenuItemConsultaVendasActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {
            if (telaUsuario == null) {
                telaUsuario = new CadastroDeUsuarios();
                telaUsuario.setVisible(true);
                telaUsuario.setResizable(false);
            } else {
                telaUsuario.setVisible(true);
                telaUsuario.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemCadastroDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeProdutosActionPerformed
        if (telaProduto == null) {
            telaProduto = new CadastroDeMercadoria();
            telaProduto.setVisible(true);
            telaProduto.setResizable(false);
        } else {
            telaProduto.setVisible(true);
            telaProduto.setResizable(false);
        }

    }//GEN-LAST:event_jMenuItemCadastroDeProdutosActionPerformed

    private void jMenuGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGastosActionPerformed

    }//GEN-LAST:event_jMenuGastosActionPerformed

    private void jMenuItemGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGastosActionPerformed
        if (telaGastos == null) {
            telaGastos = new Gastos();
            telaGastos.setVisible(true);
            telaGastos.setResizable(false);
        } else {
            telaGastos.setVisible(true);
            telaGastos.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemGastosActionPerformed
    private void jMenuItemConsultaGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaGastosActionPerformed
        if (telaConsultaGastos == null) {
            telaConsultaGastos = new ConsultaGastos();
            telaConsultaGastos.setVisible(true);
            telaConsultaGastos.setResizable(false);
        } else {
            telaConsultaGastos.setVisible(true);
            telaConsultaGastos.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemConsultaGastosActionPerformed

    private void jMenuItemLucrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLucrosActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {

            if (telaLucro == null) {
                telaLucro = new ControleLucroMensal();
                telaLucro.setVisible(true);
                telaLucro.setResizable(false);
            } else {
                telaLucro.setVisible(true);
                telaLucro.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jMenuItemLucrosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente sair do sistema?");
        switch (resposta) {
            case JOptionPane.NO_OPTION:

                break;
            case JOptionPane.CANCEL_OPTION:

                break;
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNotasActionPerformed
        if (tela12 == null) {
            tela12 = new ChegadaMercadoria();
            tela12.setVisible(true);
            tela12.setResizable(false);
        } else {
            tela12.setVisible(true);
            tela12.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemNotasActionPerformed

    private void jMenuItemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueActionPerformed
        if (telaestoque == null) {
            telaestoque = new ConsulaEstoque();
            telaestoque.setVisible(true);
            telaestoque.setResizable(false);
        } else {
            telaestoque.setVisible(true);
            telaestoque.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemEstoqueActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (tela13 == null) {
            tela13 = new Baixa();
            tela13.setVisible(true);
            tela13.setResizable(false);
        } else {
            tela13.setVisible(true);
            tela13.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemConsultaBaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaBaixasActionPerformed
        if (tela14 == null) {
            tela14 = new ConsultaBaixas();
            tela14.setVisible(true);
            tela14.setResizable(false);
        } else {
            tela14.setVisible(true);
            tela14.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemConsultaBaixasActionPerformed

    private void jMenuItemConsultaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaNotasActionPerformed
        if (tela15 == null) {
            tela15 = new ConsultaNotas();
            tela15.setVisible(true);
            tela15.setResizable(false);
        } else {
            tela15.setVisible(true);
            tela15.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemConsultaNotasActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        int seg = data.get(Calendar.SECOND);
        if (hora >= 06 && hora <= 12) {
            jLabelBom.setText("Bom dia");
        } else if (hora >= 13 && hora <= 18) {
            jLabelBom.setText("Boa tarde");
        } else {
            jLabelBom.setText("Boa noite");
        }
    }//GEN-LAST:event_formMouseEntered

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String user = jLabelUsuario.getText();
        if (recebeTexto == null) {
            recebeTexto = new FrenteCaixa();
            recebeTexto.setVisible(true);
            recebeTexto.recebendo(user);
        } else {
            recebeTexto.setVisible(true);
            recebeTexto.recebendo(String.valueOf(user));
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {
            if (tela18 == null) {
                tela18 = new PagarNotas();
                tela18.setVisible(true);
                tela18.setResizable(false);
            } else {
                tela18.setVisible(true);
                tela18.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jInternalFrame1.setVisible(true);
        jInternalFrame1.requestFocus();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (tela19 == null) {
            tela19 = new ConsultaAutonomia();
            tela19.setVisible(true);
            tela19.setResizable(false);
        } else {
            tela19.setVisible(true);
            tela19.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (tela16 == null) {
            tela16 = new transferencia();
            tela16.setVisible(true);
            tela16.setResizable(false);
        } else {
            tela16.setVisible(true);
            tela16.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void EditarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarExcluirActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {

            if (tela20 == null) {
                tela20 = new EditarExcluir();
                tela20.setVisible(true);
                tela20.setResizable(false);
            } else {
                tela20.setVisible(true);
                tela20.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }

    }//GEN-LAST:event_EditarExcluirActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (tela21 == null) {
            tela21 = new Autonomia();
            tela21.setVisible(true);
            tela21.setResizable(false);
        } else {
            tela21.setVisible(true);
            tela21.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if (tela25 == null) {
            tela25 = new ConsultaTransferencia();
            tela25.setVisible(true);
            tela25.setResizable(false);
        } else {
            tela25.setVisible(true);
            tela25.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (tela23 == null) {
            tela23 = new CadastroVeiculos();
            tela23.setVisible(true);
            tela23.setResizable(false);
        } else {
            tela23.setVisible(true);
            tela23.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {

            if (tela24 == null) {
                tela24 = new ControleCartoes();
                tela24.setVisible(true);
                tela24.setResizable(false);
            } else {
                tela24.setVisible(true);
                tela24.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {

            if (tela26 == null) {
                tela26 = new ControleLucroDiario();
                tela26.setVisible(true);
                tela26.setResizable(false);
            } else {
                tela26.setVisible(true);
                tela26.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {

            if (tela27 == null) {
                tela27 = new taxasCartoes();
                tela27.setVisible(true);
                tela27.setResizable(false);
            } else {
                tela27.setVisible(true);
                tela27.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if (tela28 == null) {
            tela28 = new Ligacoes();
            tela28.setVisible(true);
            tela28.setResizable(false);
        } else {
            tela28.setVisible(true);
            tela28.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (tela29 == null) {
            tela29 = new Calculadora();
            tela29.setVisible(true);
            tela29.setResizable(false);
        } else {
            tela29.setVisible(true);
            tela29.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        if (tela30 == null) {
            tela30 = new Fechamento();
            tela30.setVisible(true);
            tela30.setResizable(false);
        } else {
            tela30.setVisible(true);
            tela30.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if (tela31 == null) {
            tela31 = new Historico();
            tela31.setVisible(true);
            tela31.setResizable(false);
        } else {
            tela31.setVisible(true);
            tela31.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (telaConsultaCliente == null) {
            telaConsultaCliente = new ConsultaDeClientes();
            telaConsultaCliente.setVisible(true);
            telaConsultaCliente.setResizable(false);
        } else {
            telaConsultaCliente.setVisible(true);
            telaConsultaCliente.setResizable(false);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (tela23 == null) {
            tela23 = new CadastroVeiculos();
            tela23.setVisible(true);
            tela23.setResizable(false);
        } else {
            tela23.setVisible(true);
            tela23.setResizable(false);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (telaConsultaDeVendas == null) {
            telaConsultaDeVendas = new ConsultaDeVendas();
            telaConsultaDeVendas.setVisible(true);
            telaConsultaDeVendas.setResizable(false);
        } else {
            telaConsultaDeVendas.setVisible(true);
            telaConsultaDeVendas.setResizable(false);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (tela19 == null) {
            tela19 = new ConsultaAutonomia();
            tela19.setVisible(true);
            tela19.setResizable(false);
        } else {
            tela19.setVisible(true);
            tela19.setResizable(false);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String user = jLabelUsuario.getText();
        if (recebeTexto == null) {
            recebeTexto = new FrenteCaixa();
            recebeTexto.setVisible(true);
            recebeTexto.recebendo(user);
        } else {
            recebeTexto.setVisible(true);
            recebeTexto.recebendo(String.valueOf(user));
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (telaConsultaGastos == null) {
            telaConsultaGastos = new ConsultaGastos();
            telaConsultaGastos.setVisible(true);
            telaConsultaGastos.setResizable(false);
        } else {
            telaConsultaGastos.setVisible(true);
            telaConsultaGastos.setResizable(false);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (telaestoque == null) {
            telaestoque = new ConsulaEstoque();
            telaestoque.setVisible(true);
            telaestoque.setResizable(false);
        } else {
            telaestoque.setVisible(true);
            telaestoque.setResizable(false);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente sair do sistema?");
        switch (resposta) {
            case JOptionPane.NO_OPTION:

                break;
            case JOptionPane.CANCEL_OPTION:

                break;
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (tela15 == null) {
            tela15 = new ConsultaNotas();
            tela15.setVisible(true);
            tela15.setResizable(false);
        } else {
            tela15.setVisible(true);
            tela15.setResizable(false);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (tela14 == null) {
            tela14 = new ConsultaBaixas();
            tela14.setVisible(true);
            tela14.setResizable(false);
        } else {
            tela14.setVisible(true);
            tela14.setResizable(false);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (tela13 == null) {
            tela13 = new Baixa();
            tela13.setVisible(true);
            tela13.setResizable(false);
        } else {
            tela13.setVisible(true);
            tela13.setResizable(false);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (telaClientes == null) {
            telaClientes = new CadastroDeCliente();
            telaClientes.setVisible(true);
            telaClientes.setResizable(false);
        } else {
            telaClientes.setVisible(true);
            telaClientes.setResizable(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {
            if (tela18 == null) {
                tela18 = new PagarNotas();
                tela18.setVisible(true);
                tela18.setResizable(false);
            } else {
                tela18.setVisible(true);
                tela18.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (tela12 == null) {
            tela12 = new ChegadaMercadoria();
            tela12.setVisible(true);
            tela12.setResizable(false);
        } else {
            tela12.setVisible(true);
            tela12.setResizable(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (telaGastos == null) {
            telaGastos = new Gastos();
            telaGastos.setVisible(true);
            telaGastos.setResizable(false);
        } else {
            telaGastos.setVisible(true);
            telaGastos.setResizable(false);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTextFieldControle.getText().equals("Administrador")) {
            if (telaUsuario == null) {
                telaUsuario = new CadastroDeUsuarios();
                telaUsuario.setVisible(true);
                telaUsuario.setResizable(false);
            } else {
                telaUsuario.setVisible(true);
                telaUsuario.setResizable(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, jLabelUsuario.getText() + " Desculpe pelo incomodo porem somente o administrador pode acessar esta pagina");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (telaProduto == null) {
            telaProduto = new CadastroDeMercadoria();
            telaProduto.setVisible(true);
            telaProduto.setResizable(false);
        } else {
            telaProduto.setVisible(true);
            telaProduto.setResizable(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EditarExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBom;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBarra;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuGastos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCadastroDeCliente;
    private javax.swing.JMenuItem jMenuItemCadastroDeProdutos;
    private javax.swing.JMenuItem jMenuItemConsultaBaixas;
    private javax.swing.JMenuItem jMenuItemConsultaClientes;
    private javax.swing.JMenuItem jMenuItemConsultaGastos;
    private javax.swing.JMenuItem jMenuItemConsultaNotas;
    private javax.swing.JMenuItem jMenuItemConsultaVendas;
    private javax.swing.JMenuItem jMenuItemEstoque;
    private javax.swing.JMenuItem jMenuItemGastos;
    private javax.swing.JMenuItem jMenuItemLucros;
    private javax.swing.JMenuItem jMenuItemNotas;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldControle;
    // End of variables declaration//GEN-END:variables
}
