package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Lembretes;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LembretesDao {

    private final String numBanco;
    UtilitarioDao util = new UtilitarioDao();

    public LembretesDao(String i) {
        numBanco = i;
    }

    public void Salvar(Lembretes lembretes) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into lembretes(descricao,data) values (?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, lembretes.getTexto());
            comando.setDate(2, util.dateUtilXsqlDate(lembretes.getData()));
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Lembretes lembretes) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("update lembretes set descricao=?,data=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, lembretes.getTexto());
            comando.setDate(2, util.dateUtilXsqlDate(lembretes.getData()));
            comando.setInt(3, lembretes.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from lembretes ");
        sql.append("where codigo= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Lembretes> Listar() throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("select * from lembretes order by data desc");
        ArrayList<Lembretes> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Lembretes lembretes = new Lembretes();
                lembretes.setCodigo(resultado.getInt("codigo"));
                lembretes.setData(resultado.getDate("data"));
                lembretes.setTexto(resultado.getString("descricao"));
                lembretes.setDataFormatada(util.dateXstring(resultado.getDate("data")));
                lista.add(lembretes);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Lembretes> ListarDoDia() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from lembretes where data = '").append(new Date()).append("' order by data");
        ArrayList<Lembretes> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Lembretes lembretes = new Lembretes();
                lembretes.setCodigo(resultado.getInt("codigo"));
                lembretes.setData(resultado.getDate("data"));
                lembretes.setTexto(resultado.getString("descricao"));
                lista.add(lembretes);
            }
            conexao.close();
        }
        return lista;
    }

    public Lembretes buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from lembretes where codigo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Lembretes lembretes = new Lembretes();
                lembretes.setCodigo(resultado.getInt("codigo"));
                lembretes.setData(resultado.getDate("data"));
                lembretes.setTexto(resultado.getString("descricao"));
                return lembretes;
            }
            conexao.close();
        }
        return null;
    }

}
