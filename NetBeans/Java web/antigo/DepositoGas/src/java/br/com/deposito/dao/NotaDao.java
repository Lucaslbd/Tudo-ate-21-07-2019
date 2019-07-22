package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.ItemNota;
import br.com.deposito.domain.Nota;
import br.com.deposito.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class NotaDao {

    public void Salvar(Nota nota) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into nota(descricao,chegada,vencimento,valor,deposito,situacao_nota) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, nota.getDescricao());
            java.util.Date dt = nota.getChegada();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(2, d);
            java.util.Date dtr = nota.getVencimento();
            java.sql.Date dr = new java.sql.Date(dtr.getTime());
            comando.setDate(3, dr);
            comando.setDouble(4, nota.getValor());
            comando.setInt(5, nota.getDeposito().getCodigo());
            comando.setString(6, "Aberta");
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void SalvarItemNota(ItemNota item) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into item_nota(produto,quantidade,custo_item,utilizados,nota,casco) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, item.getProduto().getCodigo());
            comando.setInt(2, item.getQuantidade());
            comando.setDouble(3, item.getValor());
            comando.setInt(4, item.getUtilizados());
            comando.setInt(5, item.getNota().getCodigo());
            comando.setString(6, item.getCasco());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Nota nota) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from nota ");
        sql.append("where codigo_nota= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, nota.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Nota> ListarNota(int codigo, Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from nota inner join deposito on deposito = codigo_deposito where chegada between '").append(data1).append("' and '").append(data2).append("' and deposito = ").append(codigo).append(" order by chegada, codigo_nota");
        ArrayList<Nota> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
                Nota nota = new Nota();
                nota.setCodigo(resultado.getInt("codigo_nota"));
                nota.setChegada(resultado.getDate("chegada"));
                nota.setVencimento(resultado.getDate("vencimento"));
                nota.setDescricao(resultado.getString("descricao"));
                nota.setValor(resultado.getDouble("valor"));
                nota.setSituacao(resultado.getString("situacao_nota"));
                nota.setDeposito(deposito);
                lista.add(nota);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<ItemNota> ListarItensNota(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item_nota inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join nota inner join deposito on deposito = codigo_deposito on nota = codigo_nota where codigo_nota = ").append(codigo).append(" order by codigo_item");
        ArrayList<ItemNota> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
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
                produto.setValorPrazo(resultado.getDouble("valor_prazo"));
                produto.setFornecedor(fornecedor);
                Nota nota = new Nota();
                nota.setCodigo(resultado.getInt("codigo_nota"));
                nota.setChegada(resultado.getDate("chegada"));
                nota.setVencimento(resultado.getDate("vencimento"));
                nota.setDescricao(resultado.getString("descricao"));
                nota.setValor(resultado.getDouble("valor"));
                nota.setSituacao(resultado.getString("situacao_nota"));
                nota.setDeposito(deposito);
                ItemNota item = new ItemNota();
                item.setCasco(resultado.getString("casco"));
                item.setCodigo(resultado.getInt("codigo_item"));
                item.setNota(nota);
                item.setProduto(produto);
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setUtilizados(resultado.getInt("utilizados"));
                item.setValor(resultado.getDouble("custo_item"));
                lista.add(item);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<ItemNota> ListarItens(int codigo, Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from item_nota inner join produto inner join fornecedor on fornecedor = codigo_fornecedor on produto = codigo_produto inner join nota inner join deposito on deposito = codigo_deposito on nota = codigo_nota where chegada between '").append(data1).append("' and '").append(data2).append("' and codigo_deposito = ").append(codigo).append(" order by chegada, codigo_item");
        ArrayList<ItemNota> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
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
                produto.setValorPrazo(resultado.getDouble("valor_prazo"));
                produto.setFornecedor(fornecedor);
                Nota nota = new Nota();
                nota.setCodigo(resultado.getInt("codigo_nota"));
                nota.setChegada(resultado.getDate("chegada"));
                nota.setVencimento(resultado.getDate("vencimento"));
                nota.setDescricao(resultado.getString("descricao"));
                nota.setValor(resultado.getDouble("valor"));
                nota.setSituacao(resultado.getString("situacao_nota"));
                nota.setDeposito(deposito);
                ItemNota item = new ItemNota();
                item.setCasco(resultado.getString("casco"));
                item.setCodigo(resultado.getInt("codigo_item"));
                item.setNota(nota);
                item.setProduto(produto);
                item.setQuantidade(resultado.getInt("quantidade"));
                item.setUtilizados(resultado.getInt("utilizados"));
                item.setValor(resultado.getDouble("custo_item"));
                lista.add(item);
            }
            conexao.close();
        }
        return lista;
    }

    public Nota Ultimoregistro(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from nota inner join deposito on deposito = codigo_deposito where deposito=").append(codigo).append(" order by codigo_nota DESC LIMIT 1");
        Connection conexao;
        conexao = ConexaoBD.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        if (resultado.next()) {
            Deposito deposito = new Deposito();
            deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
            deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
            Nota nota = new Nota();
            nota.setCodigo(resultado.getInt("codigo_nota"));
            nota.setChegada(resultado.getDate("chegada"));
            nota.setVencimento(resultado.getDate("vencimento"));
            nota.setDescricao(resultado.getString("descricao"));
            nota.setValor(resultado.getDouble("valor"));
            nota.setSituacao(resultado.getString("situacao_nota"));
            nota.setDeposito(deposito);
            return nota;
        }
        conexao.close();
        return null;
    }

    public void mudaEstoque(ItemNota item) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscarCodigo(item.getProduto().getCodigo());
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set estoque_cheio=?, estoque_vazio=? where codigo_produto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (item.getCasco().equals("Sem casco")) {
                comando.setInt(1, produto.getEstoqueCheio() + item.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio() - item.getQuantidade());
            } else {
                comando.setInt(1, produto.getEstoqueCheio() + item.getQuantidade());
                comando.setInt(2, produto.getEstoqueVazio());
            }
            comando.setInt(3, item.getProduto().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void RegistraPagamento(Nota nota) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update nota set situacao_nota=? where codigo_nota=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (nota.getSituacao().equals("Aberta")) {
                comando.setString(1, "Fechada");
            } else {
                comando.setString(1, "Aberta");
            }
            comando.setInt(2, nota.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
}
