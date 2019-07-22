package desafioSefaz;

import AgenciaViagens.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TabelasDesafio {
    
    public static void main(String[]args){
        TabelasDesafio t =  new TabelasDesafio();
        t.TabelaUser();
    }

    public void TabelaUsuario() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table usuario(codigo_usuario serial not null PRIMARY KEY, nome_usuario character varying(60) not null,email_usuario character varying(60) not null,senha_usuario character varying(60) not null)");
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de usuário criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de usuário" + ex.getMessage());
        }
    }
    
    public void TabelaTelefone() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table telefone(codigo_telefone serial not null PRIMARY KEY, ddd integer not null,numero character varying(10) not null,tipo character varying(11) not null,usuario integer not null, FOREIGN KEY (usuario) REFERENCES usuario(codigo_usuario) ON UPDATE CASCADE ON DELETE CASCADE)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela passageiro criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de passageiro " + ex.getMessage());
        }
    }
    
    public void TabelaUser() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table usuario(codigo_usuario serial not null PRIMARY KEY, email character varying(60) not null,senha character varying(60) not null)");
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de usuário criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de usuário" + ex.getMessage());
        }
    }
}
