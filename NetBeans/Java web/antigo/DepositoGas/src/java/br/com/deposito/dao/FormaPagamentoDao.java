package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormaPagamentoDao {

    public void Salvar(FormaPagamento forma) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into forma_pagamento(posicao,tipo,desconto,deposito) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            switch (forma.getTipo()) {
                case "Dinheiro":
                    comando.setInt(1, 1);
                    break;
                case "Cartão de credito":
                    comando.setInt(1, 2);
                    break;
                case "Cartão de debito":
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
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(FormaPagamento forma) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from forma_pagamento ");
        sql.append("where codigo_forma= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, forma.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(FormaPagamento forma) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update forma_pagamento set tipo=?, desconto=? where codigo_forma=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, forma.getTipo());
            comando.setDouble(2, forma.getDesconto());
            comando.setInt(3, forma.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<FormaPagamento> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from forma_pagamento inner join deposito on deposito = codigo_deposito where deposito = ").append(codigo).append(" order by posicao");
        ArrayList<FormaPagamento> lista;
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
                FormaPagamento produto = new FormaPagamento();
                produto.setCodigo(resultado.getInt("codigo_forma"));
                produto.setTipo(resultado.getString("tipo"));
                produto.setDesconto(resultado.getDouble("desconto"));
                produto.setDeposito(deposito);
                lista.add(produto);
            }
            conexao.close();
        }
        return lista;
    }

    public FormaPagamento buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from forma_pagamento inner join deposito on deposito = codigo_deposito ");
        sql.append("where codigo_forma=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
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
                FormaPagamento produto = new FormaPagamento();
                produto.setCodigo(resultado.getInt("codigo_forma"));
                produto.setTipo(resultado.getString("tipo"));
                produto.setDesconto(resultado.getDouble("desconto"));
                produto.setDeposito(deposito);
                return produto;
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
