package br.com.agenciaviagens.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {

    public static Connection conectar(String caminho, String banco, String senha) {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conexao = DriverManager.getConnection(caminho, banco, senha);
            return conexao;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao se comunicar com o banco de dados!!!\n"
                    + "Causas possiveis: Sem internet."
                    + "O sistema será fechado");
            System.exit(0);
        }
        return null;
    }
}
