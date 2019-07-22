package dao;

import conexao.ConexaoBD;
import domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDao {
    
    public void Salvar(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,cpf,telefone) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getTelefone());           
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente ");
        sql.append("where codigo_cliente= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set nome=?,cpf=?,telefone=? where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getTelefone());           
            comando.setInt(4, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Cliente> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente order by nome");
        ArrayList<Cliente> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {              
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));                
                lista.add(cliente);
            }
            conexao.close();
        }
        return lista;
    }
}
