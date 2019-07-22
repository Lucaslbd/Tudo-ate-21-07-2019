package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao {

    private final String numBanco;
    UtilitarioDao util = new UtilitarioDao();

    public ClienteDao(String i) {
        numBanco = i;
    }

    public void Salvar(Cliente cliente) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,cpf,rg,cliente_cidade,cliente_bairro,cliente_rua,cliente_numero,cliente_email,cliente_telefone,cliente_estado,aniversario) values (?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
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
            comando.setDate(11, util.dateUtilXsqlDate(cliente.getNascimento()));
            comando.executeUpdate();
            conexao.close();
        }

    }

    public void Alterar(Cliente cliente) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set nome=?,cpf=?,rg=?,cliente_cidade=?,cliente_bairro=?,cliente_rua=?,cliente_numero=?,cliente_email=?,cliente_telefone=?,cliente_estado=?,aniversario=? where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
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
            comando.setDate(11, util.dateUtilXsqlDate(cliente.getNascimento()));
            comando.setInt(12, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente ");
        sql.append("where codigo_cliente= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Cliente> Listar() throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente order by nome");
        ArrayList<Cliente> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                lista.add(cliente);
            }
            conexao.close();
        }
        return lista;
    }

    public Cliente buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                return cliente;
            }
            conexao.close();
        }
        return null;
    }

    public ArrayList<Cliente> buscaAniversario() throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente where Extract(Month From aniversario) = Extract(Month From Now()) and Extract(day From aniversario) = Extract(day From Now()) order by nome");
        ArrayList<Cliente> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                lista.add(cliente);
            }
            conexao.close();
        }
        return lista;
    }
}
