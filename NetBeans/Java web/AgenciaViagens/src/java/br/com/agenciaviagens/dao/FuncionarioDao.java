package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDao {

    private final String numBanco;

    public FuncionarioDao(String i) {
        numBanco = i;
    }

    public void Salvar(Funcionario funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome_funcionario,cpf_funcionario,cargo,situacao_funcionario,salario,telefone_funcionario,comissionamento,rg_funcionario) values (?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setString(6, funcionario.getTelefone());
            comando.setDouble(7, funcionario.getComissao());
            comando.setString(8, funcionario.getRg());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Funcionario funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update funcionario set nome_funcionario=?,cpf_funcionario=?,cargo=?,situacao_funcionario=?,salario=?,telefone_funcionario=?,comissionamento=?,rg_funcionario=? where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setString(6, funcionario.getTelefone());
            comando.setDouble(7, funcionario.getComissao());
            comando.setString(8, funcionario.getRg());
            comando.setInt(9, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario=? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Funcionario> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from funcionario order by nome_funcionario");
        ArrayList<Funcionario> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                lista.add(funcionario);
            }
            conexao.close();
        }
        return lista;
    }

    public Funcionario buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from funcionario where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                return funcionario;
            }
            conexao.close();
        }
        return null;
    }
}
