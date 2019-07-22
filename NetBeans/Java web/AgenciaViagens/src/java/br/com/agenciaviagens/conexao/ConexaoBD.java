package br.com.agenciaviagens.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String SENHA = "14811409lbd";
    private static final String URL = "jdbc:postgresql://pgsql.gestaotour.com.br/";

    public static Connection conectar(String usuario) throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL + usuario, usuario, SENHA);
        return conexao;
    }
}
