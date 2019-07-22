package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Gastos;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GastoDao {

    private final String numBanco;

    public GastoDao(String i) {
        numBanco = i;
    }

    public void Salvar(Gastos gastos) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into gasto(descricao,data,valor) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gastos.getDescricao());
            comando.setDate(2, util.dateUtilXsqlDate(gastos.getData()));
            comando.setDouble(3, gastos.getValor());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Gastos gastos) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("update gasto set descricao=?,data=?,valor=? where codigo_gasto=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gastos.getDescricao());
            comando.setDate(2, util.dateUtilXsqlDate(gastos.getData()));
            comando.setDouble(3, gastos.getValor());
            comando.setInt(4, gastos.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from gasto ");
        sql.append("where codigo_gasto= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Gastos> Listar(Date data1, Date data2) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto where data between '").append(data1).append("' and '").append(data2).append("' order by descricao");
        ArrayList<Gastos> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Gastos gastos = new Gastos();
                gastos.setCodigo(resultado.getInt("codigo_gasto"));
                gastos.setData(resultado.getDate("data"));
                gastos.setDescricao(resultado.getString("descricao"));
                gastos.setValor(resultado.getDouble("valor"));
                gastos.setDataFormatada(util.dateXstring(resultado.getDate("data")));
                lista.add(gastos);
            }
            conexao.close();
        }
        return lista;
    }

    public Gastos buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto where codigo_gasto=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Gastos gastos = new Gastos();
                gastos.setCodigo(resultado.getInt("codigo_gasto"));
                gastos.setData(resultado.getDate("data"));
                gastos.setDescricao(resultado.getString("descricao"));
                gastos.setValor(resultado.getDouble("valor"));
                return gastos;
            }
            conexao.close();
        }
        return null;
    }

}
