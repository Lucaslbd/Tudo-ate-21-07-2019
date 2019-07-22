package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SistemaDao {

    public void Salvar(Sistema sistema) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into sistema(nome,descricao,ramo,caminho,banco,senha,versao) values (?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, sistema.getNome());
            comando.setString(2, sistema.getDescricao());
            comando.setString(3, sistema.getRamo());
            comando.setString(4, sistema.getCaminho());
            comando.setString(5, sistema.getBanco());
            comando.setString(6, sistema.getSenha());
            comando.setString(7, sistema.getVersao());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Sistema sistema) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from sistema ");
        sql.append("where codigo_sistema= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, sistema.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Sistema sistema) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update sistema set nome=?,descricao=?,ramo=?,caminho=?,banco=?,senha=?,versao=? where codigo_sistema=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, sistema.getNome());
            comando.setString(2, sistema.getDescricao());
            comando.setString(3, sistema.getRamo());
            comando.setString(4, sistema.getCaminho());
            comando.setString(5, sistema.getBanco());
            comando.setString(6, sistema.getSenha());
            comando.setString(7, sistema.getVersao());
            comando.setInt(8, sistema.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Sistema> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sistema where nome != 'JL sistemas' order by nome");
        ArrayList<Sistema> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                lista.add(sistema);
            }
            conexao.close();
        }
        return lista;
    } 

    public Sistema Ultimoregistro() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sistema order by codigo_sistema DESC LIMIT 1");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                return sistema;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
    
    public Sistema BuscarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sistema where codigo_sistema=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                return sistema;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
