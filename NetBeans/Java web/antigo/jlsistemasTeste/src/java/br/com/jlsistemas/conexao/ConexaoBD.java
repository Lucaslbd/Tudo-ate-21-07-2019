package br.com.jlsistemas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String USUARIO ="lucasdias3";
    private static final String SENHA ="14811409lbd";
    private static final String URL ="jdbc:postgresql://pgsql.lucasdias.kinghost.net/lucasdias3";
    
    public static Connection conectar() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;        
    }
    
}
