package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDao {

    public void Salvar(Produto produto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into produto(codigo,descricao,preco,estoque,fabricante) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getCodigo());
            comando.setString(2, produto.getDescricao());
            comando.setDouble(3, produto.getPreco());
            comando.setInt(4, produto.getEstoque());
            comando.setInt(5, produto.getFabricante().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Produto produto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from produto ");
        sql.append("where codigo=? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Produto produto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set descricao=?,preco=?,estoque=?,fabricante=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, produto.getDescricao());
            comando.setDouble(2, produto.getPreco());
            comando.setInt(3, produto.getEstoque());
            comando.setInt(4, produto.getFabricante().getCodigo());
            comando.setString(5, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void DarBaixa(Produto produto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, produto.getEstoque());
            comando.setString(2, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }

    }

    /*public ArrayList<Produto> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from produto inner join fabricante on fabricante = codigo_fabricante order by descricao");
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        ArrayList<Produto> lista = new ArrayList();

        while (resultado.next()) {
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
            fabricante.setNome(resultado.getString("nome"));
            fabricante.setCnpj(resultado.getString("cnpj"));
            fabricante.setEmail(resultado.getString("responsavel"));
            fabricante.setTelefone(resultado.getString("telefone"));
            Produto produto = new Produto();
            produto.setCodigo(resultado.getString("codigo"));
            produto.setDescricao(resultado.getString("descricao"));
            produto.setPreco(resultado.getDouble("preco"));
            produto.setEstoque(resultado.getInt("estoque"));
            produto.setFabricante(fabricante);
            lista.add(produto);
        }

        return lista;
    }*/
    public Produto buscarCodigo(String f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto inner join fabricante on fabricante = codigo_fabricante ");
        sql.append("where codigo=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, f);
            ResultSet resultado = comando.executeQuery();
            Produto produto = null;
            if (resultado.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("responsavel"));
                fabricante.setTelefone(resultado.getString("telefone"));
                produto = new Produto();
                produto.setCodigo(resultado.getString("codigo"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setFabricante(fabricante);
            }
            conexao.close();
            return produto;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }

    public ArrayList<Produto> buscarCodigo2(String f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto inner join fabricante on fabricante = codigo_fabricante ");
        sql.append("where codigo like'%").append(f).append("%' order by descricao");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            ArrayList<Produto> lista = new ArrayList();
            while (resultado.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("responsavel"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setFabricante(fabricante);
                lista.add(produto);
            }
            conexao.close();            
            return lista;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }

    public ArrayList<Produto> ListarPorFabricante(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from produto inner join fabricante on fabricante = codigo_fabricante where fabricante=").append(codigo).append(" order by descricao");
        ArrayList<Produto> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("responsavel"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setFabricante(fabricante);
                lista.add(produto);
            }
             conexao.close();
        }
        return lista;
    }
    public Produto Ultimoregistro() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from produto inner join fabricante on fabricante = codigo_fabricante order by codigo DESC LIMIT 1");
        
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());            
            ResultSet resultado = comando.executeQuery();           
            if (resultado.next()) {                
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("responsavel"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setFabricante(fabricante);
                return produto;
            }
           conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);            
        }
        return null;
    }

    /*public static void main(String[]args){
        ProdutoDao dao = new ProdutoDao();
        Produto p;
        p =dao.Ultimoregistro();
        System.out.println(p);
    }*/
}
