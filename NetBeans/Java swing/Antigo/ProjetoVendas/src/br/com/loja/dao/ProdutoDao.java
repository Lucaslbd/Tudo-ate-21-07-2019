package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Fornecedor;
import br.com.loja.domain.Produto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoDao {

    public void Salvar(Produto produto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into produto(codigo_produto,descricao,estoque,preco,preco_custo,fornecedor) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getCodigo());
            comando.setString(2, produto.getDescricao());
            comando.setInt(3, produto.getEstoque());
            comando.setDouble(4, produto.getValor());
            comando.setDouble(5, produto.getValorCusto());
            comando.setInt(6, produto.getFornecedor().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O codigo já esta cadastrado");
        }
    }

    public void Alterar(Produto produto) {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set descricao=?,estoque=?,preco=?,preco_custo=?,fornecedor=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getDescricao());
            comando.setInt(2, produto.getEstoque());
            comando.setDouble(3, produto.getValor());
            comando.setDouble(4, produto.getValorCusto());
            comando.setInt(5, produto.getFornecedor().getCodigo());
            comando.setString(6, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "produto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto\n" + ex);
        }
    }

    public void excluir(Produto produto) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from produto ");
        sql.append("where codigo_produto= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, produto.getCodigo());
            comando.executeUpdate();
            conexao.close();
            Path arquivo = Paths.get("C:\\Users\\Lucas\\Desktop\\projetos em java\\ProjetoVendas\\src\\uploads\\" + produto.getCodigo() + ".jpg");
            try {
                Files.deleteIfExists(arquivo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir imagem");
            }
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O produto não pode ser removido pois exitem informações a ele relacionado");
        }
    }

    public Produto buscarCodigo(String f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from produto inner join fornecedor on fornecedor = codigo_fornecedor ");
        sql.append("where codigo_produto=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, f);
            ResultSet resultado = comando.executeQuery();
            Produto produto = null;
            if (resultado.next()) {
                Fornecedor fabricante = new Fornecedor();
                fabricante.setCodigo(resultado.getInt("codigo_fornecedor"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setEmail(resultado.getString("email"));
                fabricante.setTelefone(resultado.getString("telefone"));
                produto = new Produto();
                produto.setCodigo(resultado.getString("codigo_produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setValor(resultado.getDouble("preco"));
                produto.setValorCusto(resultado.getDouble("preco_custo"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setFornecedor(fabricante);
            }
            conexao.close();
            return produto;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
