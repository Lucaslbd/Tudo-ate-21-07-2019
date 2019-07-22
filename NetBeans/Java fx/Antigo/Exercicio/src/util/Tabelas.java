package util;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Tabelas {
    
  /*  public static void main(String[]args){
        Tabelas tab = new Tabelas();
        tab.TabelaCliente();
    }*/
    
    public void TabelaCliente() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table cliente(codigo_cliente serial not null PRIMARY KEY, nome character varying(60) not null, cpf character varying(15) not null, telefone character varying(20) not null)");
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.execute();
            System.out.println("Tabela de cliente criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar tabela de cliente" + ex.getMessage());
        }
    }
}
