package br.com.deposito.util;

import br.com.deposito.conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tabelas {

    public static void main(String[] args) {
        Tabelas tab = new Tabelas();
        tab.TabelaDeposito();
        tab.TabelaUsuario();
        tab.TabelaCliente();
        tab.TabelaFornecedor();
        tab.TabelaProduto();
        tab.TabelaVeiculo();
        tab.TabelaFormaPagamento();
        tab.TabelaGastoVeiculo();
        tab.TabelaAutonomiaVeiculo();
        tab.TabelaVenda();
        tab.TabelaItem();
        tab.TabelaCartao();
        tab.TabelaCrediario();
        tab.TabelaNota();
        tab.TabelaItemNota();
        tab.TabelaHistoricoCliente();
        tab.TabelaFuncionario();
        tab.TabelaPagamentoFuncionario();
        tab.TabelaBaixa();
        tab.TabelaGastosEventuais();
        tab.TabelaFechamantoCaixa();       
        tab.TabelaInss();
        tab.TabelaIrrf();
        tab.TabelaHoras();
    }

    public void TabelaDeposito() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table empresa(codigo_empresa integer not null PRIMARY KEY, razao_social character varying(40) not null, estado character varying(60) not null, cidade character varying(40) not null,bairro character varying(40) not null, rua character varying(60) not null, numero character varying(60) not null, email character varying(60) not null, telefone character varying(60) not null, cnpj character varying(20) not null, cep character varying(10) not null, situacao character varying(10) not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela deposito criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela deposito" + ex.getMessage());
        }
    }

    public void TabelaHoras() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table ponto(codigo_hora serial not null PRIMARY KEY, data_hora timestamp with time zone not null, descricao character varying(60) not null, funcionario integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de ponto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de ponto" + ex.getMessage());
        }
    }

    public void TabelaUsuario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table usuario(codigo_usuario serial not null PRIMARY KEY, nome character varying(60) not null, cpf character varying(15) not null unique, tipo character varying(20) not null, senha character varying(60) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de usuario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de usuario" + ex.getMessage());
        }
    }

    public void TabelaFuncionario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table funcionario(codigo_funcionario serial not null PRIMARY KEY, nome character varying(60) not null, cpf character varying(15) not null unique, cargo character varying(20) not null, situacao_funcionario character varying(60) not null,salario double precision not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de funcionario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de funcionario" + ex.getMessage());
        }
    }

    public void TabelaPagamentoFuncionario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table pagamento_funcionario(codigo_pagamento serial not null PRIMARY KEY, funcionario integer not null, data date not null, descricao character varying(40) not null, valor double precision not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de pagamento funcionario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de pagamento usuario" + ex.getMessage());
        }
    }

    public void TabelaCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table cliente(codigo_cliente serial not null PRIMARY KEY, nome character varying(60) not null, cpf character varying(15) not null unique, rg character varying(20) not null, cliente_telefone character varying(60) not null,cliente_email character varying(60) not null, cliente_cidade character varying(60) not null, cliente_bairro character varying(60) not null, cliente_rua character varying(60) not null, cliente_numero character varying(10) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de cliente" + ex.getMessage());
        }
    }

    public void TabelaFornecedor() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table fornecedor(codigo_fornecedor serial not null PRIMARY KEY, nome character varying(60) not null, telefone character varying(20) not null, email character varying(60) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de cliente" + ex.getMessage());
        }
    }

    public void TabelaProduto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table produto(codigo_produto serial not null PRIMARY KEY, nome_produto character varying(60) not null, valor_portaria double precision not null, valor_entrega double precision not null, valor_casco double precision not null, custo_produto double precision not null, custo_casco double precision not null, estoque_cheio integer not null, estoque_vazio integer not null, fornecedor integer not null, FOREIGN KEY (fornecedor) REFERENCES fornecedor(codigo_fornecedor) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de produto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de produto" + ex.getMessage());
        }
    }

    public void TabelaVeiculo() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table veiculo(codigo_veiculo serial not null PRIMARY KEY, placa character varying(15) not null, marca character varying(15) not null, categoria character varying(15) not null, modelo character varying(15) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de veiculo com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de veiculo" + ex.getMessage());
        }
    }

    public void TabelaFormaPagamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table forma_pagamento(codigo_forma serial not null PRIMARY KEY, tipo character varying(20) not null, desconto double precision not null,posicao integer not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela forma de pagamento criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de forma de pagamento " + ex.getMessage());
        }
    }

    public void TabelaGastoVeiculo() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table gasto_veiculo(codigo_gastov serial not null PRIMARY KEY, tipo character varying(20) not null,descricao character varying(30) not null, valor double precision not null, data date not null, veiculo integer not null, FOREIGN KEY (veiculo) REFERENCES veiculo(codigo_veiculo) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela gasto veiculo criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de gasto veiculo " + ex.getMessage());
        }
    }

    public void TabelaAutonomiaVeiculo() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table autonomia(codigo_autonomia serial not null PRIMARY KEY, km double precision not null,litros double precision not null, entregas integer not null, gasto_veiculo integer not null, FOREIGN KEY (gasto_veiculo) REFERENCES gasto_veiculo(codigo_gastov) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela autonomia veiculo criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de autonomia veiculo " + ex.getMessage());
        }
    }

    public void TabelaVenda() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table venda(codigo_venda serial not null PRIMARY KEY, valor double precision not null, desconto double precision not null, custo double precision not null, tipo character varying(11) not null, forma_pagamento character varying(20) not null, data timestamp with time zone not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela venda criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de venda " + ex.getMessage());
        }
    }

    public void TabelaItem() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table item(codigo_item serial not null PRIMARY KEY, valor_item double precision not null, custo_item double precision not null, casco character varying(11) not null, quantidade integer not null, produto integer not null, venda integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela item criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela item " + ex.getMessage());
        }
    }

    public void TabelaCartao() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table cartao(codigo_cartao serial not null PRIMARY KEY, descricao character varying(20) not null, situacao character varying(10) not null, venda integer not null, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela cartao criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela cartao " + ex.getMessage());
        }
    }

    public void TabelaCrediario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table crediario(codigo_crediario serial not null PRIMARY KEY, venda integer not null,cliente integer not null, data_pagamento date not null, situacao_crediario character varying(10) not null, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela crediario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela crediario " + ex.getMessage());
        }
    }

    public void TabelaNota() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table nota(codigo_nota serial not null PRIMARY KEY, valor double precision not null, descricao character varying(20) not null, chegada date not null, vencimento date not null,situacao_nota character varying(7) not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela nota criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de nota " + ex.getMessage());
        }
    }

    public void TabelaItemNota() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table item_nota(codigo_item serial not null PRIMARY KEY, custo_item double precision not null, casco character varying(11) not null, quantidade integer not null,utilizados integer not null, produto integer not null, nota integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (nota) REFERENCES nota(codigo_nota) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela item da nota criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela item da nota " + ex.getMessage());
        }
    }

    public void TabelaHistoricoCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table historico_cliente(codigo_historico serial not null PRIMARY KEY, cliente integer not null, venda integer not null, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (venda) REFERENCES venda(codigo_venda) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela historico do cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela historico do cliente" + ex.getMessage());
        }
    }

    public void TabelaBaixa() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table baixa(codigo_baixa serial not null PRIMARY KEY, produto integer not null, data date not null, descricao character varying(60) not null, casco character varying(10) not null, valor double precision not null, quantidade integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo_produto) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela baixa criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela baixa" + ex.getMessage());
        }
    }

    public void TabelaGastosEventuais() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table gastos_eventuais(codigo_gasto serial not null PRIMARY KEY, empresa integer not null, data date not null, descricao character varying(60) not null, valor double precision not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela gastos eventuais criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela gastos eventuais" + ex.getMessage());
        }
    }

    public void TabelaFechamantoCaixa() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table fechamento_caixa(empresa integer not null PRIMARY KEY, troco double precision not null, dinheiro double precision not null, cartao double precision not null, cheque double precision not null, qtd_cartao integer not null, crediario double precision not null,cancelamento integer not null, valor double precision not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fechamento criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de fechamento" + ex.getMessage());
        }
    }   

    public void TabelaInss() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table inss(codigo serial not null PRIMARY KEY, valor_inicial double precision NOT NULL, valor_final double precision NOT NULL, porcentagem double precision NOT NULL)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de inss criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de inss" + ex.getMessage());
        }
    }

    public void TabelaIrrf() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table irrf(codigo serial not null PRIMARY KEY, valor_inicial double precision NOT NULL, valor_final double precision NOT NULL, porcentagem double precision NOT NULL, devolver double precision NOT NULL)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de irrf criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de irrf" + ex.getMessage());
        }
    }
}
