package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormaPagamentoDao {

    public void Salvar(FormaPagamento forma) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into forma_pagamento(posicao,tipo,desconto,empresa,acrescimo) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            switch (forma.getTipo()) {
                case "Dinheiro":
                    comando.setInt(1, 1);
                    break;
                case "Cartão de crédito":
                    comando.setInt(1, 2);
                    break;
                case "Cartão de débito":
                    comando.setInt(1, 3);
                    break;
                case "Cheque":
                    comando.setInt(1, 4);
                    break;
                case "Crediário":
                    comando.setInt(1, 5);
                    break;
                default:
                    break;
            }
            comando.setString(2, forma.getTipo());
            comando.setDouble(3, forma.getDesconto());
            comando.setInt(4, forma.getDeposito().getCodigo());
            comando.setDouble(5, forma.getAcrescimo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Forma de pagamento registrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar forma de pagamento" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from forma_pagamento ");
        sql.append("where codigo_forma= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Forma de pagamento removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover forma de pagamento" + ex);
        }
    }

    public void Alterar(FormaPagamento forma) {
        StringBuilder sql = new StringBuilder();
        sql.append("update forma_pagamento set tipo=?, desconto=?,acrescimo=? where codigo_forma=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, forma.getTipo());
            comando.setDouble(2, forma.getDesconto());
            comando.setDouble(3, forma.getAcrescimo());
            comando.setInt(4, forma.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Forma de pagamento alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar forma de pagamento" + ex);
        }
    }

    public ArrayList<FormaPagamento> Listar(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from forma_pagamento inner join empresa on empresa = codigo_empresa where empresa = ").append(codigo).append(" order by posicao");
        ArrayList<FormaPagamento> lista;
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
                FormaPagamento forma = new FormaPagamento();
                forma.setCodigo(resultado.getInt("codigo_forma"));
                forma.setTipo(resultado.getString("tipo"));
                forma.setDesconto(resultado.getDouble("desconto"));
                forma.setAcrescimo(resultado.getDouble("acrescimo"));
                forma.setDeposito(deposito);
                lista.add(forma);
            }
            conexao.close();
            JOptionPane.showMessageDialog(null, "Pesquisa de forma de pagamento realizada com sucesso");
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar forma de pagamento" + ex);
        }
        return null;
    }

    public FormaPagamento buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from forma_pagamento inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_forma=?");
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
                FormaPagamento forma = new FormaPagamento();
                forma.setCodigo(resultado.getInt("codigo_forma"));
                forma.setTipo(resultado.getString("tipo"));
                forma.setDesconto(resultado.getDouble("desconto"));
                forma.setAcrescimo(resultado.getDouble("acrescimo"));
                forma.setDeposito(deposito);
                return forma;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar forma de pagamento" + ex);
        }
        return null;
    }
}
