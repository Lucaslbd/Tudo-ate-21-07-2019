package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.webService.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {

    public void Salvar(Cliente cliente,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,cpf,rg,cliente_cidade,cliente_bairro,cliente_rua,cliente_numero,cliente_email,cliente_telefone,cliente_estado) values (?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
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
            JOptionPane.showMessageDialog(null, "Cliente registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar cliente" + ex);
        }
    }

    public void excluir(int codigo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente ");
        sql.append("where codigo_cliente= ? ");

        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente" + ex);
        }
    }

    public void Alterar(Cliente cliente,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set nome=?,cpf=?,rg=?,cliente_cidade=?,cliente_bairro=?,cliente_rua=?,cliente_numero=?,cliente_email=?,cliente_telefone=?,cliente_estado=? where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
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
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente" + ex);
        }
    }

    public Cliente buscarCodigo(int codigo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente ");
        sql.append("where codigo_cliente=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return null;
    }

    public ArrayList<Cliente> listar(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente order by nome");
        Connection conexao;
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }    
    
     public ArrayList<Cliente> listarResulindo(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente order by nome");
        Connection conexao;
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());            
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {               
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));                              
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }    
}
