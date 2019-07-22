package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDao {

    public void Salvar(Produto produto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into produto(nome_produto,valor_portaria,valor_casco,custo_produto,custo_casco, estoque_cheio,estoque_vazio,fornecedor,valor_entrega) values (?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getNome());
            comando.setDouble(2, produto.getValorPortaria());
            comando.setDouble(3, produto.getValorCasco());
            comando.setDouble(4, produto.getCustoProduto());
            comando.setDouble(5, produto.getCustoCasco());
            comando.setInt(6, produto.getEstoqueCheio());
            comando.setInt(7, produto.getEstoqueVazio());
            comando.setInt(8, produto.getFornecedor().getCodigo());
            comando.setDouble(9, produto.getValorEntrega());       
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Produto registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar produto" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from produto ");
        sql.append("where codigo_produto= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover produto" + ex);
        }
    }

    public void Alterar(Produto produto) {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set nome_produto=?, valor_portaria=?, valor_casco=?,custo_produto=?, custo_casco=?, estoque_cheio=?, estoque_vazio=?, fornecedor=?, valor_entrega=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getNome());
            comando.setDouble(2, produto.getValorPortaria());
            comando.setDouble(3, produto.getValorCasco());
            comando.setDouble(4, produto.getCustoProduto());
            comando.setDouble(5, produto.getCustoCasco());
            comando.setInt(6, produto.getEstoqueCheio());
            comando.setInt(7, produto.getEstoqueVazio());
            comando.setInt(8, produto.getFornecedor().getCodigo());
            comando.setDouble(9, produto.getValorEntrega());           
            comando.setInt(10, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto" + ex);
        }
    }    

    public Produto buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor ");
        sql.append("where codigo_produto=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
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
                return produto;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"" +ex);
        }
        return null;
    }   
}
