package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Gastos;
import br.com.agenciaviagens.util.UtilitarioDao;
import br.com.agenciaviagens.webService.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GastosDao {

    public void Salvar(Gastos gasto, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        UtilitarioDao util = new UtilitarioDao();
        sql.append("insert into gasto(descricao,data,valor) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gasto.getDescricao());
            comando.setDate(2, util.dateUtilXsqlDate(gasto.getData()));
            comando.setDouble(3, gasto.getValor());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar gasto" + ex);
        }
    }

    public void excluir(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from gasto ");
        sql.append("where codigo_gasto= ? ");

        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover gasto" + ex);
        }
    }

    public void Alterar(Gastos gasto, Empresa empresa) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("update gasto set descricao=?,data=?,valor=? where codigo_gasto=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gasto.getDescricao());
            comando.setDate(2, util.dateUtilXsqlDate(gasto.getData()));
            comando.setDouble(3, gasto.getValor());
            comando.setInt(4, gasto.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar gasto" + ex);
        }
    }

    public Gastos buscarCodigo(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from gasto ");
        sql.append("where codigo_gasto=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Gastos gasto = new Gastos();
                gasto.setCodigo(resultado.getInt("codigo_gasto"));
                gasto.setDescricao(resultado.getString("descricao"));
                gasto.setData(resultado.getDate("data"));
                gasto.setValor(resultado.getDouble("valor"));                
                return gasto;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar gasto por codigo" + ex);
        }
        return null;
    }    
}
