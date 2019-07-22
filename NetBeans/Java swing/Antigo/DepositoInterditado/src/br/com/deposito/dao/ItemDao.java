package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Item;
import br.com.deposito.domain.ItemNota;
import br.com.deposito.domain.Nota;
import br.com.deposito.domain.Produto;
import br.com.deposito.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemDao {

    public void Salvar(Item item) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into item(valor_item,custo_item,casco,quantidade,produto,venda) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, item.getValor());
            comando.setDouble(2, item.getCusto());
            comando.setString(3, item.getCasco());
            comando.setInt(4, item.getQuantdade());
            comando.setInt(5, item.getProduto().getCodigo());
            comando.setInt(6, item.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();
            DiminuirEstoque(item);
            AlteraUtilizar(item);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar item" + ex);
        }
    }

    public ArrayList<Item> ListarPorVenda(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where codigo_venda = ").append(codigo).append(" order by codigo_item");
        ArrayList<Item> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));           
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setEntrega(resultado.getString("tipo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setFormaPagamento(resultado.getString("forma_pagamento"));
                venda.setDeposito(deposito);
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(deposito);
                Produto produto = new Produto();
                produto.setCodigo(resultado.getInt("codigo_produto"));
                produto.setNome(resultado.getString("nome_produto"));
                produto.setValorPortaria(resultado.getDouble("valor_portaria"));
                produto.setValorCasco(resultado.getDouble("valor_casco"));
                produto.setCustoProduto(resultado.getDouble("custo_produto"));
                produto.setCustoCasco(resultado.getDouble("custo_casco"));
                produto.setEstoqueCheio(resultado.getInt("estoque_cheio"));
                produto.setEstoqueVazio(resultado.getInt("estoque_vazio"));
                produto.setValorEntrega(resultado.getDouble("valor_entrega"));               
                produto.setFornecedor(fornecedor);
                Item item = new Item();
                item.setCodigo(resultado.getInt("codigo_item"));
                item.setValor(resultado.getDouble("valor_item"));
                item.setCusto(resultado.getDouble("custo_item"));
                item.setQuantdade(resultado.getInt("quantidade"));
                item.setCasco(resultado.getString("casco"));
                item.setProduto(produto);
                item.setVenda(venda);
                lista.add(item);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar item por venda" + ex);
        }
        return null;
    }

    public void DiminuirEstoque(Item item) {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(item.getProduto().getCodigo());
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque_cheio=?, estoque_vazio=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (item.getCasco().equals("Sem casco")) {
                comando.setInt(1, produto.getEstoqueCheio() - item.getQuantdade());
                comando.setInt(2, produto.getEstoqueVazio() + item.getQuantdade());
            } else {
                comando.setInt(1, produto.getEstoqueCheio() - item.getQuantdade());
                comando.setInt(2, produto.getEstoqueVazio());
            }
            comando.setInt(3, item.getProduto().getCodigo());
            comando.executeUpdate();
            conexao.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar baixa no estoque" + ex);
        }
    }
    
    public void AumentaEstoque(Item item) {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(item.getProduto().getCodigo());
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque_cheio=?, estoque_vazio=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (item.getCasco().equals("Sem casco")) {
                comando.setInt(1, produto.getEstoqueCheio() + item.getQuantdade());
                comando.setInt(2, produto.getEstoqueVazio() - item.getQuantdade());
            } else {
                comando.setInt(1, produto.getEstoqueCheio() + item.getQuantdade());
                comando.setInt(2, produto.getEstoqueVazio());
            }
            comando.setInt(3, item.getProduto().getCodigo());
            comando.executeUpdate();
            conexao.close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar baixa no estoque" + ex);
        }
    }

    public void AlteraUtilizar(Item item) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item_nota inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join nota inner join empresa on empresa = codigo_empresa on nota = codigo_nota where codigo_produto = ").append(item.getProduto().getCodigo()).append(" and utilizados + ").append(item.getQuantdade()).append(" <= quantidade order by codigo_item LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));               
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(deposito);
                Produto produto = new Produto();
                produto.setCodigo(resultado.getInt("codigo_produto"));
                produto.setNome(resultado.getString("nome_produto"));
                produto.setValorPortaria(resultado.getDouble("valor_portaria"));
                produto.setValorCasco(resultado.getDouble("valor_casco"));
                produto.setCustoProduto(resultado.getDouble("custo_produto"));
                produto.setCustoCasco(resultado.getDouble("custo_casco"));
                produto.setEstoqueCheio(resultado.getInt("estoque_cheio"));
                produto.setEstoqueVazio(resultado.getInt("estoque_vazio"));
                produto.setValorEntrega(resultado.getDouble("valor_entrega"));                
                produto.setFornecedor(fornecedor);
                Nota nota = new Nota();
                nota.setCodigo(resultado.getInt("codigo_nota"));
                nota.setChegada(resultado.getDate("chegada"));
                nota.setVencimento(resultado.getDate("vencimento"));
                nota.setDescricao(resultado.getString("descricao"));
                nota.setValor(resultado.getDouble("valor"));
                nota.setSituacao(resultado.getString("situacao_nota"));
                nota.setDeposito(deposito);
                ItemNota itemNota = new ItemNota();
                itemNota.setCasco(resultado.getString("casco"));
                itemNota.setCodigo(resultado.getInt("codigo_item"));
                itemNota.setNota(nota);
                itemNota.setProduto(produto);
                itemNota.setQuantidade(resultado.getInt("quantidade"));
                itemNota.setUtilizados(resultado.getInt("utilizados"));
                itemNota.setValor(resultado.getDouble("custo_item"));
                itemNota.setUtilizados(itemNota.getUtilizados() + item.getQuantdade());
                AlterarUtilizados(itemNota);               
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao encontrar utilizar da nota" + ex);
        }        
    }   
    
    public void AlterarUtilizados(ItemNota iNota) {
        StringBuilder sql = new StringBuilder();
        sql.append("update item_nota set utilizados=? where codigo_item=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, iNota.getUtilizados());
            comando.setInt(2, iNota.getCodigo());
            comando.executeUpdate();
            conexao.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar utlizados da nota" + ex);
        }
    }
}
