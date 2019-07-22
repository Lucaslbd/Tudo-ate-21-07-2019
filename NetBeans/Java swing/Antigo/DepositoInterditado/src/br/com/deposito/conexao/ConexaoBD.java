package br.com.deposito.conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static String USUARIO;
    private static String SENHA;
    private static String URL;

    public static Connection conectar() throws SQLException {
        ConexaoBD conex = new ConexaoBD();
        SENHA = conex.senha();
        USUARIO = conex.usuario();
        URL = conex.url();
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }

    public String senha() {
        String s = null;
        for (int i = 1; i < 12; i++) {
            InputStream fonte = ConexaoBD.class.getResourceAsStream(i + ".txt");
            InputStreamReader isr = new InputStreamReader(fonte);
            BufferedReader br = new BufferedReader(isr);
            try {
                if (s == null) {
                    s = br.readLine();
                } else {
                    s += br.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Erro " + ex);
            }
        }
        return s;
    }

    public String url() {
        String s = null;
        for (int i = 1; i < 58; i++) {
            InputStream fonte = ConexaoBD.class.getResourceAsStream(i + "b.txt");
            InputStreamReader isr = new InputStreamReader(fonte);
            BufferedReader br = new BufferedReader(isr);
            try {
                if (s == null) {
                    s = br.readLine();
                } else {
                    s += br.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Erro " + ex);
            }
        }
        return s;
    }

    public String usuario() {
        String s = null;
        for (int i = 1; i < 11; i++) {
            InputStream fonte = ConexaoBD.class.getResourceAsStream(i + "a.txt");
            InputStreamReader isr = new InputStreamReader(fonte);
            BufferedReader br = new BufferedReader(isr);
            try {
                if (s == null) {
                    s = br.readLine();
                } else {
                    s += br.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Erro " + ex);
            }
        }
        return s;
    }    
}
