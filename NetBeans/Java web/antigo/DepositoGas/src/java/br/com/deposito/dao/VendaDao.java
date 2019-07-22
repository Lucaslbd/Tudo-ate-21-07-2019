package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VendaDao {

    public void Salvar(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(data,valor,deposito,custo,tipo,desconto,forma_pagamento) values (?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setTimestamp(1, new Timestamp(venda.getData().getTime()));
            comando.setDouble(2, venda.getValor());
            comando.setInt(3, venda.getDeposito().getCodigo());
            comando.setDouble(4, venda.getCusto());
            comando.setString(5, venda.getEntrega());
            comando.setDouble(6, venda.getDesconto());
            comando.setString(7, venda.getFormaPagamento());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public Venda Ultimoregistro(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join deposito on deposito = codigo_deposito where deposito=").append(codigo).append(" order by codigo_venda DESC LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
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
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setFormaPagamento(resultado.getString("forma_pagamento"));
                venda.setDeposito(deposito);
                venda.setEntrega("tipo");
                return venda;
            }
            conexao.close();
        }
        return null;
    }

    public ArrayList<Venda> Listar(int codigo, Date data1, Date data2) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data2);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date data3 = calendar.getTime();

        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join deposito on deposito = codigo_deposito where data between '").append(data1).append("' and '").append(data3).append("' and deposito = ").append(codigo).append(" order by data");
        ArrayList<Venda> lista;
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
                venda.setFormaPagamento(resultado.getString("forma_pagamento"));
                venda.setDeposito(deposito);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public void excluir(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from venda ");
        sql.append("where codigo_venda= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
}
