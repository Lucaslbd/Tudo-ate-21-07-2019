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
        sql.append("insert into sistema(nome,descricao,ramo,versao) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, sistema.getNome());
            comando.setString(2, sistema.getDescricao());
            comando.setString(3, sistema.getRamo());
            comando.setString(4, sistema.getVersao());
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
        sql.append("update sistema set nome=?,descricao=?,ramo=?,versao=? where codigo_sistema=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, sistema.getNome());
            comando.setString(2, sistema.getDescricao());
            comando.setString(3, sistema.getRamo());
            comando.setString(4, sistema.getVersao());
            comando.setInt(5, sistema.getCodigo());
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
                sistema.setVersao(resultado.getString("versao"));
                lista.add(sistema);
            }
            conexao.close();
        }
        return lista;
    }

    public Sistema Ultimoregistro() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sistema order by codigo_sistema DESC LIMIT 1");
        Sistema sistema = new Sistema();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
            }
            conexao.close();
        }
        return sistema;
    }

    public Sistema BuscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sistema where codigo_sistema=?");
        Sistema sistema = new Sistema();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));

            }
            conexao.close();
        }
        return sistema;
    }

}
