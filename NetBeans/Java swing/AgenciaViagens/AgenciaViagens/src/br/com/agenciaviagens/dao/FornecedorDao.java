package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedorDao {

    public void Salvar(Fornecedor fornecedor, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fornecedor(nome_fornecedor,telefone_fornecedor,email_fornecedor) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar fornecedor" + ex);
        }
    }

    public void excluir(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fornecedor ");
        sql.append("where codigo_fornecedor= ? ");

        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fornecedor" + ex);
        }
    }

    public void Alterar(Fornecedor fornecedor, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fornecedor set nome_fornecedor=?,telefone_fornecedor=?,email_fornecedor=? where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.setInt(4, fornecedor.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar fornecedor" + ex);
        }
    }

    public Fornecedor buscarCodigo(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fornecedor ");
        sql.append("where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                return fornecedor;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao buscar fornecedor por codigo" + ex);
        }
        return null;
    }

    public ArrayList<Fornecedor> listar(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fornecedor order by nome_fornecedor");
        Connection conexao;
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                lista.add(fornecedor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao buscar fornecedor por codigo" + ex);
        }
        return lista;
    }

    public ArrayList<Fornecedor> listarResumido(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fornecedor order by nome_fornecedor");
        Connection conexao;
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                lista.add(fornecedor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao buscar fornecedor por codigo" + ex);
        }
        return lista;
    }
}
