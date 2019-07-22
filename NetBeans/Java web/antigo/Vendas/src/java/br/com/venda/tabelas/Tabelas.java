package br.com.venda.tabelas;

import br.com.vendas.conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Tabelas {
    ConexaoBD conex = new ConexaoBD();
    
    /*public static void main(String[]args){
        Tabelas tabela = new Tabelas();
        tabela.TabelaEmpresa();
    }*/
   
    public void TabelaFuncionarios() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table funcionario(codigo serial not null PRIMARY KEY, nome character varying(60) not null, email character varying(60) not null, senha character varying(60) not null, cpf character varying(15) not null unique, funcao character varying(30) not null)");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
           comando.execute();
            System.out.println("Tabela de funcionario criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaFabricantes() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table fabricante(codigo serial not null PRIMARY KEY, nome character varying(60) not null, cnpj character varying(20) not null, telefone character varying(15) not null, responsavel character varying(60) not null)");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fabricantes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaProdutos() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table produto(codigo character varying(60) not null PRIMARY KEY, descricao character varying(100) not null, preco double precision not null, estoque integer not null, fabricante integer not null, FOREIGN KEY (fabricante) REFERENCES fabricante(codigo))");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fabricantes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaVendas() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table venda(codigo serial not null PRIMARY KEY, valor double precision not null, data date not null, funcionario integer not null, FOREIGN KEY (funcionario) REFERENCES funcionario(codigo))");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fabricantes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaItens() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table item(codigo serial not null PRIMARY KEY, quantidade integer not null, valor double precision not null, produto character varying(60) not null, venda integer not null, FOREIGN KEY (produto) REFERENCES produto(codigo), FOREIGN KEY (venda) REFERENCES venda(codigo))");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fabricantes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaFechamento() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table fechamento(codigo_fechamento serial not null PRIMARY KEY, pagamento character varying(20) not null, valor double precision not null, situacao character varying(20) not null, venda integer not null, FOREIGN KEY (venda) REFERENCES venda(codigo_venda))");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de fabricantes criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void TabelaEmpresa() {       
        StringBuilder sql = new StringBuilder();
        sql.append("create table empresa(codigo integer not null PRIMARY KEY, cnpj character varying(30) not null, inscricao_estadual character varying(60) not null, crt character varying(60) not null, razao_social character varying(60) not null, nome_fantasia character varying(60) not null, cidade character varying(60) not null, bairro character varying(60) not null, rua character varying(60) not null, numero character varying(10) not null, cep character varying(60) not null)");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
           comando.execute();
            System.out.println("Tabela de empresa criada com sucesso");
            InseriPrimeiraEmpresa();
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela" + ex.getMessage());
        }        
    }
    public void InseriPrimeiraEmpresa() {       
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(codigo, cnpj, inscricao_estadual, crt, razao_social, nome_fantasia, cidade, bairro, rua, numero, cep) values (1,'00.000.000/0000-00','0000000000','00','razaão social','fantasia','cidade','bairro','rua','N°','00000-000')");      
        try {
           Connection conexao = ConexaoBD.conectar();
           PreparedStatement comando = conexao.prepareStatement(sql.toString());
           comando.execute();
            System.out.println("empresa adicionada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar empresa" + ex.getMessage());
        }        
    }
}
