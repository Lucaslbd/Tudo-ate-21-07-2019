package br.com.jlsistemas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBDSistemas {   
    
    public static Connection conectar(String URL, String USUARIO, String SENHA) throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;        
    }
    
}
