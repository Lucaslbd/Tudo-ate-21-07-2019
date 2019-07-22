package br.com.drogaria.dao;

import br.com.drogaria.factory.ConexaoFactory;
import br.com.drograria.domain.Fabricante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FabricanteDAO {

    public void salvar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fabricante ");
        sql.append("(descricao) ");
        sql.append("values (?)");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.executeUpdate();
    }

    public void excluir(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fabricante ");
        sql.append("where codigo=? ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setInt(1, f.getCodigo());
        comando.executeUpdate();
    }

    public void editar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fabricante ");
        sql.append("set descricao=? ");
        sql.append("where codigo=?");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.setInt(2, f.getCodigo());
        comando.executeUpdate();
    }

    public Fabricante buscarCodigo(Fabricante f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fabricante ");
        sql.append("where codigo=?");
        Connection conexao;
        try {
            conexao = ConexaoFactory.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, f.getCodigo());
            ResultSet resultado = comando.executeQuery();
            Fabricante retorno = null;
            if (resultado.next()) {
                retorno = new Fabricante();
                retorno.setCodigo(resultado.getInt("codigo"));
                retorno.setDescricao(resultado.getString("descricao"));
                System.out.println("Procedimento efetuado com sucesso");
            }
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }

    public ArrayList<Fabricante> listarTudo() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fabricante ");
        sql.append("order by descricao asc ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        ArrayList<Fabricante> lista = new ArrayList<>();

        while (resultado.next()) {
            Fabricante f = new Fabricante();
            f.setCodigo(resultado.getInt("codigo"));
            f.setDescricao(resultado.getString("descricao"));
            lista.add(f);
        }
        return lista;
    }

    public ArrayList<Fabricante> BuscarPorDescricao(Fabricante f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fabricante ");
        sql.append("where descricao like ? ");
        sql.append("order by descricao asc ");
        Connection conexao;
        try {
            conexao = ConexaoFactory.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "%" + f.getDescricao() + "%");
            ResultSet resultado = comando.executeQuery();

            ArrayList<Fabricante> lista = new ArrayList<>();

            while (resultado.next()) {
                Fabricante item = new Fabricante();
                item.setCodigo(resultado.getInt("codigo"));
                item.setDescricao(resultado.getString("descricao"));
                lista.add(item);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }

    /*public static void main(String[] args) {
        FabricanteDAO control = new FabricanteDAO();
        try {
            ArrayList<Fabricante> lista = control.listarTudo();
            for (Fabricante f : lista) {
                System.out.println(f);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
    }*/
}
