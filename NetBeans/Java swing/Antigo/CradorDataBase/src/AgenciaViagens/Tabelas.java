package AgenciaViagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tabelas {

    public static void main(String[] args) {
        Tabelas tab = new Tabelas();
        
    }

    public void TabelaToken() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table token(codigo serial not null PRIMARY KEY, token character varying(200) not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de token criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de token" + ex.getMessage());
        }
    }

    public void TabelaCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table cliente(codigo_cliente serial not null PRIMARY KEY, nome character varying(60) not null, cpf character varying(15) not null, rg character varying(20) not null, cliente_telefone character varying(60) not null,cliente_email character varying(60) not null,cliente_estado character varying(60) not null, cliente_cidade character varying(60) not null, cliente_bairro character varying(60) not null, cliente_rua character varying(60) not null, cliente_numero character varying(10) not null, aniversario date not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de cliente" + ex.getMessage());
        }
    }

    public void TabelaLembretes() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table lembretes(codigo serial not null PRIMARY KEY, descricao character varying(100) not null, data date not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de lembretes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de lembretes" + ex.getMessage());
        }
    }

    public void TabelaFuncionario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table funcionario(codigo_funcionario serial not null PRIMARY KEY, nome_funcionario character varying(60) not null, cpf_funcionario character varying(15) not null, rg_funcionario character varying(20) not null, cargo character varying(60) not null, telefone_funcionario character varying(20) not null,situacao_funcionario character varying(60) not null,salario double precision not null,comissionamento double precision not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela funcionario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela funcionario" + ex.getMessage());
        }
    }

    public void TabelaFornecedor() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table fornecedor(codigo_fornecedor serial not null PRIMARY KEY, nome_fornecedor character varying(60) not null, telefone_fornecedor character varying(20) not null, email_fornecedor character varying(60) not null,tempo_pagamento integer not null, porcentagem_pagamento double precision not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fornecedor criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de fornecedor" + ex.getMessage());
        }
    }

    public void TabelaVenda() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table venda(codigo_venda serial not null PRIMARY KEY, valor_venda double precision not null, valor_comissao double precision not null,descricao character varying(50) not null, data_venda date not null,data_comissao date not null,status character varying(10) not null,comissao_func double precision not null,taxas double precision not null,data_checkin date not null,hora_checkin character varying(5) not null,referencia character varying(20) not null,funcionario integer not null,cliente integer not null,fornecedor integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario) ON UPDATE CASCADE ON DELETE CASCADE,FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (fornecedor) REFERENCES fornecedor(codigo_fornecedor) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela venda criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de venda " + ex.getMessage());
        }
    }

    public void TabelaGasto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table gasto(codigo_gasto serial not null PRIMARY KEY, valor double precision not null, descricao character varying(60) not null, data date not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela gasto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de gasto " + ex.getMessage());
        }
    }   

    public void TabelaGrupo() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table grupo(codigo_grupo serial not null PRIMARY KEY,valor_fixo double precision not null,valor_relativo double precision not null,nome_grupo character varying(60) not null,numero_pax integer not null,status_grupo character varying(15) not null,valor_venda double precision not null,atividades character varying(400) not null,tripulacao integer not null,data_grupo date not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela grupo criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela grupo " + ex.getMessage());
        }
    }

    public void TabelaPassageiro() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table passageiro(codigo_passageiro serial not null PRIMARY KEY, valor_total double precision not null,local_embarque character varying(60) not null,titular integer not null,status character varying(60) not null,grupo integer not null,cliente integer not null, FOREIGN KEY (grupo) REFERENCES grupo(codigo_grupo) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela passageiro criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de passageiro " + ex.getMessage());
        }
    }

    public void TabelaBoleto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table boleto(codigo_boleto character varying(200) not null PRIMARY KEY, valor double precision not null,desconto double precision not null, criacao date not null,vencimento date not null,status character varying(60) not null, link character varying(200) not null, parcela integer not null,descricao character varying(100) not null,total_parcelas integer not null,cliente integer not null, FOREIGN KEY (cliente) REFERENCES cliente(codigo_cliente) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela boleto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de boleto " + ex.getMessage());
        }
    }

    public void TabelaTransacao() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table transacao(codigo serial not null PRIMARY KEY, valor double precision not null,desconto double precision not null, data date not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela transacao criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de transacao " + ex.getMessage());
        }
    }

    public void SalvarToken() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into token(token) values (?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "0000000000");
            comando.executeUpdate();
            conexao.close();
            System.out.println("certo");
        } catch (SQLException ex) {
            System.out.println("erro " + ex);
        }
    }
}

/*public void alterarTabela() {
        StringBuilder sql = new StringBuilder();
        sql.append("ALTER TABLE venda ADD CONSTRAINT funcionario FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela venda alterada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar tabela" + ex.getMessage());
        }
    }*/
//codigo de como alterar uma tabela

/*public void teste(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("ALTER TABLE venda ADD CONSTRAINT funcionario FOREIGN KEY (funcionario) REFERENCES funcionario(codigo_funcionario)");
        try {
            Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela empresa criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela empresa" + ex.getMessage());
        }
    }*/
