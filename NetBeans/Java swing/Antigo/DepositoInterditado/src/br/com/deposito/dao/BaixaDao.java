package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Baixa;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class BaixaDao {

    public void Salvar(Baixa baixa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into baixa(descricao,valor,data,quantidade,casco,produto) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, baixa.getDescricao());
            comando.setDouble(2, baixa.getValor());
            java.util.Date dt = baixa.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);
            comando.setInt(4, baixa.getQuantidade());
            comando.setString(5, baixa.getCasco());
            comando.setInt(6, baixa.getPreoduto().getCodigo());
            comando.executeUpdate();
            conexao.close();
            baixaEstoque(baixa);
            JOptionPane.showMessageDialog(null, "Baixa registrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar baixa" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from  baixa ");
        sql.append("where codigo_baixa= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Baixa removida com sucesso com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover baixa" + ex);
        }
    }

    public ArrayList<Baixa> Listar(int codigo, Date data1, Date data2) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from baixa inner join produto inner join fornecedor inner join empresa on empresa = codigo_empresa on fornecedor = codigo_fornecedor on produto = codigo_produto where data between '").append(data1).append("' and '").append(data2).append("' and empresa = ").append(codigo).append(" order by data");
        ArrayList<Baixa> lista;
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
                Baixa baixa = new Baixa();
                baixa.setCodigo(resultado.getInt("codigo_baixa"));
                baixa.setData(resultado.getDate("data"));
                baixa.setDescricao(resultado.getString("descricao"));
                baixa.setValor(resultado.getDouble("valor"));
                baixa.setQuantidade(resultado.getInt("quantidade"));
                baixa.setCasco(resultado.getString("casco"));
                baixa.setPreoduto(produto);
                lista.add(baixa);                
            }
            conexao.close();            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar baixa" + ex);
        }
        return null;
    }

    public void baixaEstoque(Baixa baixa) {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(baixa.getPreoduto().getCodigo());
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque_cheio=?, estoque_vazio=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (baixa.getCasco().equals("Sem casco")) {
                comando.setInt(1, produto.getEstoqueCheio() - baixa.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio() + baixa.getQuantidade());
            } else {
                comando.setInt(1, produto.getEstoqueCheio() - baixa.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio());
            }
            comando.setInt(3, baixa.getPreoduto().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque estoque" + ex);
        }
    }
    
    public void recuperaBaixa(Baixa baixa){
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(baixa.getPreoduto().getCodigo());
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque_cheio=?, estoque_vazio=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (baixa.getCasco().equals("Sem casco")) {
                comando.setInt(1, produto.getEstoqueCheio() + baixa.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio() - baixa.getQuantidade());
            } else {
                comando.setInt(1, produto.getEstoqueCheio() + baixa.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio());
            }
            comando.setInt(3, baixa.getPreoduto().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque" + ex);
        }
    }
}
