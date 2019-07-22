package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class LoginDao {

	private Connection connection;

	public LoginDao() {
		connection = SingleConnection.getConnection();
	}

	public boolean logar(String email, String senha) throws SQLException {
		String sql = "select * from usuario where email = '" + email + "' and senha = '" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}
}
