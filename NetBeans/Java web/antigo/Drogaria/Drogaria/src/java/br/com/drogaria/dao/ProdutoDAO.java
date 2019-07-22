package br.com.drogaria.dao;

import br.com.drogaria.factory.ConexaoFactory;
import br.com.drograria.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public void salvar(Produto p) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into produto ");
        sql.append("(descricao,quantidade,preco,fabricante) ");
        sql.append("values (?,?,?,?) ");
        
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, p.getDescricao());
        comando.setInt(2, p.getQuantidade());
        comando.setDouble(3, p.getPreco());
        comando.setString(4, p.getFabricante());
        comando.executeUpdate();

    }
     public ArrayList<Produto> listarTudo() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto ");
        sql.append("order by descricao asc ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        ArrayList<Produto> lista = new ArrayList<>();

        while (resultado.next()) {
            Produto p = new Produto();
            p.setCodigo(resultado.getInt("codigo"));
            p.setDescricao(resultado.getString("descricao"));
            p.setQuantidade(resultado.getInt("quantidade"));
            p.setPreco(resultado.getDouble("preco"));
            p.setFabricante(resultado.getString("fabricante"));
            lista.add(p);
        }
        return lista;
    }
     public void excluir(Produto p) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from produto ");
        sql.append("where codigo= ? ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setInt(1, p.getCodigo());
        comando.executeUpdate();
    }
     
     public void editar(Produto p) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto ");
        sql.append("set descricao=?, quantidade=?, preco=?, fabricante=? ");
        sql.append("where codigo=? ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, p.getDescricao());
        comando.setInt(2, (int) p.getQuantidade());
        comando.setDouble(3, p.getPreco());
        comando.setString(4, p.getFabricante());
        comando.setInt(5, p.getCodigo());
        comando.executeUpdate();
    }
    /*public static void main(String[] args) {
        ProdutoDAO control = new ProdutoDAO();
        Produto p = new Produto();
        p.setDescricao("testando2");
        p.setQuantidade(3);
        p.setPreco(5.50);
        p.setFabricante("Pedro");
        
        try {
            control.salvar(p);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro");
        }
    }*/
     /*public static void main(String[] args) {
        ProdutoDAO control = new ProdutoDAO();
        try {
            ArrayList<Produto> lista = control.listarTudo();
            for (Produto f : lista) {
                System.out.println(f);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
    }*/
}
