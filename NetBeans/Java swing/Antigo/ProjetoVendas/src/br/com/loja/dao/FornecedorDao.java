package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FornecedorDao {
    
    public void Salvar(Fornecedor fornecedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fornecedor(nome,email,telefone,cnpj) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getEmail());
            comando.setString(3, fornecedor.getTelefone());
            comando.setString(4, fornecedor.getCnpj());                       
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar fornecedor\n" + ex);
        }
    }
    public void Alterar(Fornecedor fornecedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fornecedor set nome=?,email=?,telefone=?,cnpj=? where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getEmail());
            comando.setString(3, fornecedor.getTelefone());
            comando.setString(4, fornecedor.getCnpj());
            comando.setInt(5, fornecedor.getCodigo());            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar fornecedor\n" + ex);
        }
    }

    public void excluir(Fornecedor fornecedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fornecedor ");
        sql.append("where codigo_fornecedor= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, fornecedor.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O fornecedor não pode ser removido pois exitem informações a ele relacionado");
        }
    }
}
