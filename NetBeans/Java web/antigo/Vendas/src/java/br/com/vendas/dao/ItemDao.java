package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ItemDao {

    public void Salvar(Item item) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into item(quantidade,valor,produto,venda) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setInt(1, item.getQuantidade());
            comando.setDouble(2, item.getValor());
            comando.setString(3, item.getProduto().getCodigo());
            comando.setInt(4, item.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Item> ListarPorData(Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fabricante on fabricante = codigo_fabricante on produto = codigo inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where data between '").append(data1).append("' and '").append(data2).append("' order by data");
        ArrayList<Item> lista;
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
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setFabricante(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                Item item = new Item();
                item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValor(resultado.getDouble("valor"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Item> ListarPorVenda(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fabricante on fabricante = codigo_fabricante on produto = codigo inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where venda=").append(codigo).append(" order by codigo_item");
        ArrayList<Item> lista;
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
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setFabricante(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setFuncionario(funcionario);
                
                Item item = new Item();
                item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValor(resultado.getDouble("valor"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        }
        return lista;
    }

    public void excluir(Venda venda) throws SQLException {
        StringBuilder sql1 = new StringBuilder();
        sql1.append("delete from item ");
        sql1.append("where venda=? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql1.toString());
            comando.setInt(1, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    /* public static void main(String[]args){
        ItemDao dao = new ItemDao();
        ArrayList<Item> listas = new ArrayList();
        try {
            listas = dao.Listar();
            for(Item f:listas){
                System.out.println(f);
            }
        } catch (SQLException ex) {
            System.out.println("erro"+ex);
        }
    }*/
}
