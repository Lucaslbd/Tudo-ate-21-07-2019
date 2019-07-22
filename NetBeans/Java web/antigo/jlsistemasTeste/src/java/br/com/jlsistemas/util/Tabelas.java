package br.com.jlsistemas.util;

import br.com.jlsistemas.conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Tabelas {

    /*public static void main(String[] args) {
        Tabelas tab = new Tabelas();
        //tab.TabelaSistema();
        //tab.TabelaEmpresa();
        //tab.TabelaBoleto();
        //tab.criarSistemaMaster();
        //tab.criarEmpresaMaster();
        //tab.TabelaOpniao();
        //tab.TabelaContato();
        tab.TabelaPagamento();
    }*/

    public void TabelaSistema() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table sistema(codigo_sistema serial not null PRIMARY KEY, nome character varying(60) not null, descricao character varying(200) not null, caminho character varying(100) not null, banco character varying(30) not null, senha character varying(30) not null, ramo character varying(30) not null,versao character varying(30) not null)");
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
        sql.append("create table empresa(codigo_empresa serial not null PRIMARY KEY, razao_social character varying(60) not null, estado character varying(60) not null, cidade character varying(40) not null,bairro character varying(40) not null, rua character varying(60) not null, numero character varying(60) not null, email character varying(60) not null unique, telefone character varying(60) not null, cnpj character varying(20) not null unique, cep character varying(10) not null, situacao character varying(10) not null, mensalidade double precision not null,senha_empresa character varying(30) not null,data_cadastro timestamp with time zone not null, sistema integer not null, FOREIGN KEY (sistema) REFERENCES sistema(codigo_sistema) ON UPDATE CASCADE ON DELETE CASCADE)");
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
        sql.append("create table contato(codigo_contato serial not null PRIMARY KEY, nome character varying(60) not null,situacao character varying(10) not null, fone character varying(20) not null, email character varying(60) not null,motivo character varying(200) not null, data timestamp with time zone not null)");
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
        sql.append("create table boleto(codigo_boleto serial not null PRIMARY KEY, vencimento date not null, valor double precision not null, situacao_boleto character varying(40) not null,empresa integer not null, numero_documento character varying(11) not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela boleto criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela boleto" + ex.getMessage());
        }
    }
    
    public void TabelaPagamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table pagamento(codigo_pagamento serial not null PRIMARY KEY, referencia date not null, valor double precision not null, situacao_pagamento character varying(40) not null,empresa integer not null, valor_receber double precision not null, FOREIGN KEY (empresa) REFERENCES empresa(codigo_empresa) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela pagamento criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela pagamento" + ex.getMessage());
        }
    }

    public void criarSistemaMaster() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into sistema(nome,descricao,caminho,banco,senha,ramo,versao) values ('JL sistemas','Master','Master','Master','Master','Master','Master')");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Sistema adicionado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar sistema" + ex.getMessage());
        }
    }

    public void criarEmpresaMaster() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,estado,cidade,bairro,rua,numero,email,telefone,cnpj,cep,situacao,mensalidade,senha_empresa,sistema,data_cadastro) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "JL sistemas");
            comando.setString(2, "Master");
            comando.setString(3, "Master");
            comando.setString(4, "Master");
            comando.setString(5, "Master");
            comando.setString(6, "jlsistemasgestao@gmail.com");
            comando.setString(7, "Master");
            comando.setString(8, "Master");
            comando.setString(9, "00.000.000/0000-00");
            comando.setString(10, "Master");
            comando.setString(11, "Master");
            comando.setDouble(12, 0.0);
            comando.setString(13, "14811409lbd");
            comando.setInt(14, 1);
            comando.setTimestamp(15, new Timestamp(new Date().getTime()));
            comando.execute();
            System.out.println("empresa adicionada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar empresa" + ex.getMessage());
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
