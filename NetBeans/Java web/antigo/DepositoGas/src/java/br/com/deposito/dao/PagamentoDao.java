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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PagamentoDao {

    //parte cartao----------------------------------------------------------------------------------------------
    public void SalvarPagamentoCartao(PagamentoCartao pag) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cartao(descricao,situacao,venda) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, pag.getDescricao());
            comando.setString(2, pag.getSituacao());
            comando.setInt(3, pag.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<PagamentoCartao> ListarCartao(int codigo, Date data1, Date data2) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data2);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date data3 = calendar.getTime();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cartao inner join venda inner join deposito on deposito = codigo_deposito on venda = codigo_venda where data between '").append(data1).append("' and '").append(data3).append("' and codigo_deposito = ").append(codigo).append(" order by data, codigo_cartao");
        ArrayList<PagamentoCartao> lista;
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
                lista.add(pag);
            }
            conexao.close();
        }
        return lista;
    }

    public void registrarRecebimento(PagamentoCartao pag) throws SQLException {
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
        }
    }

    public void excluirCartao(PagamentoCartao pag) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cartao ");
        sql.append("where codigo_cartao= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, pag.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    // parte crediario --------------------------------------------------------------------------------
    public void SalvarCrediario(Crediario crediario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into crediario(cliente,venda,data_pagamento,situacao) values (?,?,?,?)");
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
        }
    }

    public ArrayList<Crediario> ListarCrediario(int codigo, Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from crediario inner join venda inner join deposito on deposito = codigo_deposito on venda = codigo_venda inner join cliente on cliente = codigo_cliente where data_pagamento between '").append(data1).append("' and '").append(data2).append("' and codigo_deposito = ").append(codigo).append(" order by data_pagamento, codigo_crediario");
        ArrayList<Crediario> lista;
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
                crediario.setSituacao(resultado.getString("situacao"));
                crediario.setCliente(cliente);
                crediario.setVenda(venda);
                lista.add(crediario);
            }
            conexao.close();
        }
        return lista;
    }

    public void InformarRecebimento(Crediario crediario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update crediario set situacao=? where codigo_crediario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, crediario.getSituacao());
            comando.setInt(2, crediario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluirCrediario(Crediario crediario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from crediario ");
        sql.append("where codigo_crediario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, crediario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
}
