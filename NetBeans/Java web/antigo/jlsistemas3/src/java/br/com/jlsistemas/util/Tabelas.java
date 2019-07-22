package br.com.jlsistemas.util;

import br.com.jlsistemas.conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tabelas {

    /*public static void main(String[] args) {
        Tabelas tab = new Tabelas();
        //tab.TabelaSistema();
        //tab.TabelaEmpresa();
        //tab.TabelaBoleto();        
        //tab.TabelaOpniao();
        //tab.TabelaContato();   
        //tab.TabelaTransacao();
    }*/

    public void TabelaSistema() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table sistema(codigo_sistema serial not null PRIMARY KEY, nome character varying(60) not null, descricao character varying(200) not null, ramo character varying(30) not null,versao character varying(30) not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela sistema criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela sistema" + ex.getMessage());
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
    
    public void TabelaContato() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table contato(codigo_contato serial not null PRIMARY KEY, nome character varying(60) not null, fone character varying(20) not null, email character varying(60) not null,motivo character varying(200) not null, data timestamp with time zone not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela contato criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela contato" + ex.getMessage());
        }
    }

    public void TabelaBoleto() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table boleto(codigo_boleto character varying(100) not null PRIMARY KEY,link character varying(200) not null,status character varying(40) not null,valor double precision not null, desconto double precision not null,criacao date not null, vencimento date not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela boleto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela boleto" + ex.getMessage());
        }
    }  
    
    public void TabelaTransacao() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table transacao(codigo_transacao serial not null PRIMARY KEY,data date not null,valor double precision not null, desconto double precision not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela transação criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela transação" + ex.getMessage());
        }
    }  

    public void TabelaOpniao() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table comentario(codigo_comentario serial not null PRIMARY KEY, mensagem character varying(200) not null, data timestamp with time zone not null, empresa integer not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela opniao criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de opniao " + ex.getMessage());
        }
    }
}
