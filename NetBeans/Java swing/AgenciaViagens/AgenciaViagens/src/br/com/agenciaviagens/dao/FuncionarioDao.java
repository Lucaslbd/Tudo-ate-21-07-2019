package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Funcionario;
import br.com.agenciaviagens.webService.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    public void Salvar(Funcionario funcionario, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome_funcionario,cpf,cargo,situacao_funcionario,salario,telefone,comissionamento) values (?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setString(6, funcionario.getTelefone());
            comando.setDouble(7, funcionario.getComissao());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registra funcionário" + ex);
        }
    }

    public void excluir(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario= ? ");

        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover funcionário" + ex);
        }
    }

    public void Alterar(Funcionario funcionario, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update funcionario set nome_funcionario=?,cpf=?,cargo=?,situacao_funcionario=?,salario=?,telefone=?,comissionamento=? where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setString(6, funcionario.getTelefone());
             comando.setDouble(7, funcionario.getComissao());
            comando.setInt(8, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar funcionário" + ex);
        }
    }

    public Funcionario buscarCodigo(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where codigo_funcionario=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Funcionario usuario = new Funcionario();
                usuario.setCodigo(resultado.getInt("codigo_funcionario"));
                usuario.setNome(resultado.getString("nome_funcionario"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCargo(resultado.getString("cargo"));
                usuario.setSalario(resultado.getDouble("salario"));
                usuario.setSituacao(resultado.getString("situacao_funcionario"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setComissao(resultado.getDouble("comissionamento"));
                return usuario;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário por codigo" + ex);
        }
        return null;
    }

    public ArrayList<Funcionario> listar(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where situacao_funcionario = 'Contrato ativo'");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            ArrayList<Funcionario> lista = new ArrayList<>();
            while (resultado.next()) {
                Funcionario usuario = new Funcionario();
                usuario.setCodigo(resultado.getInt("codigo_funcionario"));
                usuario.setNome(resultado.getString("nome_funcionario"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCargo(resultado.getString("cargo"));
                usuario.setSalario(resultado.getDouble("salario"));
                usuario.setSituacao(resultado.getString("situacao_funcionario"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setComissao(resultado.getDouble("comissionamento"));
                lista.add(usuario);
            }
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário por codigo" + ex);
        }
        return null;
    }
    
    public ArrayList<Funcionario> listarResumido(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where situacao_funcionario = 'Contrato ativo'");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            ArrayList<Funcionario> lista = new ArrayList<>();
            while (resultado.next()) {
                Funcionario usuario = new Funcionario();
                usuario.setCodigo(resultado.getInt("codigo_funcionario"));
                usuario.setNome(resultado.getString("nome_funcionario"));               
                usuario.setComissao(resultado.getDouble("comissionamento"));
                lista.add(usuario);
            }
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário por codigo" + ex);
        }
        return null;
    }
}
