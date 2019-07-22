package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static final String BANCO = "jdbc:postgresql://pgsql.jlsistemasdegestao.com.br/jlsistemasdegestao";
	private static final String PASSWORD = "14811409lbd";
	private static final String USER = "jlsistemasdegestao";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection(){
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(BANCO,USER,PASSWORD);
				connection.setAutoCommit(false);
			}
		}catch (Exception e) {
			throw new RuntimeException("Erro ao se conectar com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
