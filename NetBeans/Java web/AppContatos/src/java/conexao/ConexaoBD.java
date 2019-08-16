package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String USUARIO = "";
    private static final String SENHA = "";
    private static final String URL = "";

    public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }

    // private static final String USUARIO = "jlsistemasdege";
    //  private static final String SENHA = "14811409lbd";
    //  private static final String URL = "jdbc:mysql://mysql.jlsistemasdegestao.com.br/jlsistemasdege";

    /*public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);        
        return conexao;
    }*/
}
