package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Fornecedor;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Item;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemDao {
 
    public ArrayList<Item> ListarPorProdutos(String data1, String data2,String codigo){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where data between '").append(data1).append("' and '").append(data2).append("' and codigo_produto='").append(codigo).append("' order by data");
        ArrayList<Item> lista = new ArrayList();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();           
            while(resultado.next()) {
                Fornecedor fabricante = new Fornecedor();
                fabricante.setCodigo(resultado.getInt("codigo_fornecedor"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("email"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo_produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setValor(resultado.getDouble("preco"));
                produto.setValorCusto(resultado.getDouble("preco_custo"));
                produto.setFornecedor(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));                
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setSalario(resultado.getDouble("salario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor_venda"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                Item item = new Item();
              //item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValorTotal(resultado.getDouble("valor_total"));
                item.setValorUnitario(resultado.getDouble("valor_unitario"));
                item.setCusto(resultado.getDouble("valor_custo"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro"+ex);
        }
        return lista;
    }
    public ArrayList<Item> ListarPorFornecedor(String data1, String data2,String codigo){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where data between '").append(data1).append("' and '").append(data2).append("' and cnpj='").append(codigo).append("' order by data");
        ArrayList<Item> lista = new ArrayList();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();           
            while(resultado.next()) {
                Fornecedor fabricante = new Fornecedor();
                fabricante.setCodigo(resultado.getInt("codigo_fornecedor"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("email"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo_produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setValor(resultado.getDouble("preco"));
                produto.setValorCusto(resultado.getDouble("preco_custo"));
                produto.setFornecedor(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));                
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setSalario(resultado.getDouble("salario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor_venda"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                Item item = new Item();
              //item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValorTotal(resultado.getDouble("valor_total"));
                item.setValorUnitario(resultado.getDouble("valor_unitario"));
                item.setCusto(resultado.getDouble("valor_custo"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro"+ex);
        }
        return lista;
    }
    public ArrayList<Item> ListarPorData(String data1, String data2){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where data between '").append(data1).append("' and '").append(data2).append("'");
        ArrayList<Item> lista = new ArrayList();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();           
            while(resultado.next()) {
                Fornecedor fabricante = new Fornecedor();
                fabricante.setCodigo(resultado.getInt("codigo_fornecedor"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("email"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo_produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setValor(resultado.getDouble("preco"));
                produto.setValorCusto(resultado.getDouble("preco_custo"));
                produto.setFornecedor(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));                
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setSalario(resultado.getDouble("salario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor_venda"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                Item item = new Item();
              //item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValorTotal(resultado.getDouble("valor_total"));
                item.setValorUnitario(resultado.getDouble("valor_unitario"));
                item.setCusto(resultado.getDouble("valor_custo"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro"+ex);
        }
        return lista;
    }
    public ArrayList<Item> ListarPorVenda(int codigo){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where venda=").append(codigo).append("");
        ArrayList<Item> lista = new ArrayList();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();           
            while(resultado.next()) {
                Fornecedor fabricante = new Fornecedor();
                fabricante.setCodigo(resultado.getInt("codigo_fornecedor"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("email"));
                fabricante.setTelefone(resultado.getString("telefone"));
                Produto produto = new Produto();
                produto.setCodigo(resultado.getString("codigo_produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setValor(resultado.getDouble("preco"));
                produto.setValorCusto(resultado.getDouble("preco_custo"));
                produto.setFornecedor(fabricante);
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));                
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setSalario(resultado.getDouble("salario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor_venda"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                Item item = new Item();
              //item.setCodigo(resultado.getInt("codigo_item"));
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setValorTotal(resultado.getDouble("valor_total"));
                item.setValorUnitario(resultado.getDouble("valor_unitario"));
                item.setCusto(resultado.getDouble("valor_custo"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro"+ex);
        }
        return lista;
    }
   
    public void SalvarItem(Item item) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into item(quantidade,valor_custo,valor_unitario,valor_total,venda,produto) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, item.getQuantidade());
            comando.setDouble(2, item.getCusto());
            comando.setDouble(3, item.getValorUnitario());
            comando.setDouble(4, item.getValorTotal());
            comando.setInt(5, item.getVenda().getCodigo());
            comando.setString(6, item.getProduto().getCodigo());
            comando.executeUpdate();
            conexao.close();
          //  JOptionPane.showMessageDialog(null, "Itens salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar itens\n" + ex);
        }
    }
}
