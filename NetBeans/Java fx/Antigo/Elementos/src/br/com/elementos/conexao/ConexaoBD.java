package br.com.elementos.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String USUARIO ="jlsistemasdegestao";
    private static final String SENHA ="14811409lbd";
    private static final String URL ="jdbc:postgresql://pgsql.jlsistemasdegestao.com.br/jlsistemasdegestao";
    
    public static Connection conectar() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;        
    }
    
}
