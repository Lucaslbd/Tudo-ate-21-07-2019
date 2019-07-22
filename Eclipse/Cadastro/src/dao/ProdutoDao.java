package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.SingleConnection;
import domain.Produto;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Produto produto) {
		String sql = "insert into produto (codigo,nome,estoque,valor) values (?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getCodigo());
			statement.setString(2, produto.getNome());
			statement.setInt(3, produto.getEstoque());
			statement.setDouble(4, produto.getValor());
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void alterar(Produto produto) {
		String sql = "update produto set codigo=?,nome=?,estoque=?,valor=? where id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getCodigo());
			statement.setString(2, produto.getNome());
			statement.setInt(3, produto.getEstoque());
			statement.setDouble(4, produto.getValor());
			statement.setInt(5, produto.getId());
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void excluir(int codigo) {
		try {
			String sql = "delete from produto where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.execute();
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Produto buscarPorCodigo(int codigo) throws SQLException {
		String sql = "select * from produto where id = " + codigo + "";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
		    Produto produto = new Produto();
			produto.setCodigo(resultSet.getString("codigo"));
			produto.setNome(resultSet.getString("nome"));
			produto.setEstoque(resultSet.getInt("estoque"));
			produto.setValor(resultSet.getDouble("valor"));
			produto.setId(resultSet.getInt("id"));
			return produto;
		} else {
			return null;
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> lista = new ArrayList<>();
		String sql = "select * from produto order by nome";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultSet.getString("codigo"));
			produto.setNome(resultSet.getString("nome"));
			produto.setEstoque(resultSet.getInt("estoque"));
			produto.setValor(resultSet.getDouble("valor"));
			produto.setId(resultSet.getInt("id"));
			lista.add(produto);
		}
		return lista;
	}

	public List<Produto> pesquisar(String pesquisa) throws SQLException {
		List<Produto> lista = new ArrayList<>();
		String sql = "select * from produto where nome ilike'%" + pesquisa + "%' order by nome";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultSet.getString("codigo"));
			produto.setNome(resultSet.getString("nome"));
			produto.setEstoque(resultSet.getInt("estoque"));
			produto.setValor(resultSet.getDouble("valor"));
			produto.setId(resultSet.getInt("id"));
			lista.add(produto);
		}
		return lista;
	}
	
	public boolean validarInsert(String codigo) throws SQLException {
		String sql = "select count(1) as qtd from produto where codigo = '" + codigo + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		int reg = 0;
		if (resultSet.next()) {
			reg = resultSet.getInt("qtd");
		}		
		if (reg > 0) {
			return true;
		} else {
			return false;
		}		
	}
	
	public boolean validarUpdate(String codigo,int id) throws SQLException {
		String sql = "select count(1) as qtd from produto where codigo = '" + codigo + "' and id != " + id + "";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		int reg = 0;
		if (resultSet.next()) {
			reg = resultSet.getInt("qtd");
		}		
		if (reg > 0) {
			return true;
		} else {
			return false;
		}		
	}
}
