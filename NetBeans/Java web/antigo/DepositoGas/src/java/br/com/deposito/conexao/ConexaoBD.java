package br.com.deposito.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String USUARIO ="lucasdias2";
    private static final String SENHA ="14811409lbd";
    private static final String URL ="jdbc:postgresql://pgsql.lucasdias.kinghost.net/lucasdias2";
    
    public static Connection conectar() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;        
    }
    
}
