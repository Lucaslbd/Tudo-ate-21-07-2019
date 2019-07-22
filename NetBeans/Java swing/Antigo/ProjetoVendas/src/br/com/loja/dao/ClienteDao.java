package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao {

    public void Salvar(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,rg,cpf,telefone,email,cidade,bairro,rua,numero) values (?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRg());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getCidade());
            comando.setString(7, cliente.getBairro());
            comando.setString(8, cliente.getRua());
            comando.setString(9, cliente.getNumero());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "cliente adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cliente fornecedor\n" + ex);
        }
    }

    public void Alterar(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set nome=?,rg=?,cpf=?,telefone=?,email=?,cidade=?,bairro=?,rua=?,numero=? where codigo_cliente=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRg());
            comando.setString(3, cliente.getCpf());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getCidade());
            comando.setString(7, cliente.getBairro());
            comando.setString(8, cliente.getRua());
            comando.setString(9, cliente.getNumero());
            comando.setInt(10, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "cliente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente\n" + ex);
        }
    }

    public void excluir(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente ");
        sql.append("where codigo_cliente= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, cliente.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "cliente removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O cliente não pode ser removido pois exitem informações a ele relacionado");
        }
    }
}
