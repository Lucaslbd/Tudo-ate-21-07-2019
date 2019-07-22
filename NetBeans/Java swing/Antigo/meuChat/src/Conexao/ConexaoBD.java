package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String USUARIO ="jlsistemasdegestao2";
    private static final String SENHA ="14811409lbd";
    private static final String URL ="jdbc:postgresql://pgsql.jlsistemasdegestao.com.br/jlsistemasdegestao2";
    
    public static Connection conectar() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;        
    }   
}
