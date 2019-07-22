package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.Crediario;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.PagamentoCartao;
import br.com.deposito.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PagamentoDao {

    //parte cartao----------------------------------------------------------------------------------------------
    public void SalvarPagamentoCartao(PagamentoCartao pag) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cartao(descricao,situacao,venda) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, pag.getDescricao());
            comando.setString(2, pag.getSituacao());
            comando.setInt(3, pag.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registra pagamento com cartão" + ex);
        }
    }

    public PagamentoCartao ListarCartao(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cartao inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda where codigo_cartao = ").append(codigo).append("");
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
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setEntrega(resultado.getString("tipo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setDeposito(deposito);
                PagamentoCartao pag = new PagamentoCartao();
                pag.setCodigo(resultado.getInt("codigo_cartao"));
                pag.setDescricao(resultado.getString("descricao"));
                pag.setSituacao(resultado.getString("situacao"));
                pag.setVenda(venda);
                return pag;
            }
            conexao.close();
            JOptionPane.showMessageDialog(null, "listagem de pagamentos em cartão realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pagemtos em cartão" + ex);
        }
        return null;
    }

    public void registrarRecebimento(int codigo) {
        PagamentoDao dao = new PagamentoDao();
        PagamentoCartao pag = dao.ListarCartao(codigo);
        StringBuilder sql = new StringBuilder();
        sql.append("update cartao set situacao=? where codigo_cartao=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (pag.getSituacao().equals("Recebido")) {
                comando.setString(1, "A receber");
            } else {
                comando.setString(1, "Recebido");
            }
            comando.setInt(2, pag.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Recebimento do cartão registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar recebimento de cartão" + ex);
        }
    }

    public void excluirCartao(PagamentoCartao pag) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cartao ");
        sql.append("where codigo_cartao= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, pag.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Pagamento em cartão removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover pagamento em cartão" + ex);
        }
    }

    // parte crediario --------------------------------------------------------------------------------
    public void SalvarCrediario(Crediario crediario) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into crediario(cliente,venda,data_pagamento,situacao_crediario) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, crediario.getCliente().getCodigo());
            comando.setInt(2, crediario.getVenda().getCodigo());
            java.util.Date dt = crediario.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);
            comando.setString(4, crediario.getSituacao());
            comando.executeUpdate();
            conexao.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar crediário" + ex);
        }
    }

    public Crediario BuscarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from crediario inner join venda inner join empresa on empresa = codigo_empresa on venda = codigo_venda inner join cliente on cliente = codigo_cliente where codigo_crediario = ").append(codigo).append("");
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
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setEntrega(resultado.getString("tipo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setDeposito(deposito);
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setDeposito(deposito);
                Crediario crediario = new Crediario();
                crediario.setData(resultado.getDate("data_pagamento"));
                crediario.setCodigo(resultado.getInt("codigo_crediario"));
                crediario.setSituacao(resultado.getString("situacao_crediario"));
                crediario.setCliente(cliente);
                crediario.setVenda(venda);
                return crediario;
            }
            conexao.close();
            JOptionPane.showMessageDialog(null, "Pesquisa de crediário realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar pesquisa de crediário" + ex);
        }
        return null;
    }

    public void InformarRecebimento(int codigo) {
        PagamentoDao pag = new PagamentoDao();
        Crediario crediario = pag.BuscarPorCodigo(codigo);
        StringBuilder sql = new StringBuilder();
        sql.append("update crediario set situacao_crediario=? where codigo_crediario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (crediario.getSituacao().equals("Recebido")) {
                comando.setString(1, "A receber");
            } else {
                comando.setString(1, "Recebido");
            }
            comando.setInt(2, crediario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Pagamento do crediário registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar pagamento do crediário" + ex);
        }
    }

    public void excluirCrediario(Crediario crediario) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from crediario ");
        sql.append("where codigo_crediario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, crediario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Crediário removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover crediário" + ex);
        }
    }
}
