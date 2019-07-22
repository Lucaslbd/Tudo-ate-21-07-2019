package br.com.elementos.dao;

import br.com.elementos.conexao.ConexaoBD;
import br.com.elementos.domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {

    public void Salvar(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,cpf,rg,cliente_cidade,cliente_bairro,cliente_rua,cliente_numero,cliente_email,cliente_telefone,cliente_estado) values (?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getRg());
            comando.setString(4, cliente.getCidade());
            comando.setString(5, cliente.getBairro());
            comando.setString(6, cliente.getRua());
            comando.setString(7, cliente.getNumero());
            comando.setString(8, cliente.getEmail());
            comando.setString(9, cliente.getTelefone());           
            comando.setString(10, cliente.getEstado());
            comando.executeUpdate();
            conexao.close();           
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente ");
        sql.append("where codigo_cliente= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();           
        }
    }

    public void Alterar(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set nome=?,cpf=?,rg=?,cliente_cidade=?,cliente_bairro=?,cliente_rua=?,cliente_numero=?,cliente_email=?,cliente_telefone=?,cliente_estado=? where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getRg());
            comando.setString(4, cliente.getCidade());
            comando.setString(5, cliente.getBairro());
            comando.setString(6, cliente.getRua());
            comando.setString(7, cliente.getNumero());
            comando.setString(8, cliente.getEmail());
            comando.setString(9, cliente.getTelefone());
            comando.setString(10, cliente.getEstado());
            comando.setInt(11, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();           
        }
    }

    public Cliente buscarCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente ");
        sql.append("where codigo_cliente=?");
      try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {                
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setEstado(resultado.getString("cliente_estado"));                
                return cliente;
            } 
             conexao.close();           
        }
        
        return null;
    }

    public ArrayList<Cliente> listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente order by nome");       
        ArrayList<Cliente> lista = new ArrayList<>();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());            
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {               
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setEstado(resultado.getString("cliente_estado"));               
                lista.add(cliente);
            }        
        }
        return lista;
    }        
    
}
