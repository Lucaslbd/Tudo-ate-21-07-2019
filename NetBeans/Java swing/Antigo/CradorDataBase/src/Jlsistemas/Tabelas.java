package Jlsistemas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tabelas {

    public static void main(String[] args) {
        Tabelas tab = new Tabelas();                
        tab.TabelaToken();             
        tab.SalvarToken();
        tab.TabelaBoleto();
        tab.TabelaTransacao();       
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

    public void TabelaBoleto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table boleto(codigo_boleto character varying(200) not null PRIMARY KEY, valor double precision not null,desconto double precision not null, criacao date not null,vencimento date not null,status character varying(60) not null, link character varying(200) not null, parcela integer not null,descricao character varying(100) not null,total_parcelas integer not null,empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
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
    
    public void TabelaEmpresa() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table empresa(codigo_empresa serial not null PRIMARY KEY, razao_social character varying(60) not null, estado character varying(60) not null, cidade character varying(40) not null,bairro character varying(40) not null, rua character varying(60) not null, numero character varying(60) not null, email character varying(60) not null unique, telefone character varying(60) not null, cnpj character varying(20) not null unique, cep character varying(10) not null, situacao character varying(10) not null, mensalidade double precision not null,senha_empresa character varying(30) not null,data_cadastro date not null, data_mensalidade date not null, caminho character varying(60) not null,banco character varying(60) not null, senha_banco character varying(20) not null, sistema integer not null, FOREIGN KEY (sistema) REFERENCES sistema(codigo_sistema) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela empresa criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela empresa" + ex.getMessage());
        }
    }
}