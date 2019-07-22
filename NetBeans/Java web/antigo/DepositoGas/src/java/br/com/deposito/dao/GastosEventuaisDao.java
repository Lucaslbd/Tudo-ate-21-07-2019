package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.GastosEventuais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class GastosEventuaisDao {
    
     public void Salvar(GastosEventuais gastos) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into gastos_eventuais(descricao,valor,data,deposito) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gastos.getDescricao());
            comando.setDouble(2, gastos.getValor());
            java.util.Date dt = gastos.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);            
            comando.setInt(4, gastos.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
     
      public void Alterar(GastosEventuais gastos) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update gastos_eventuais set descricao=?,valor=?,data=? where codigo_gasto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gastos.getDescricao());
            comando.setDouble(2, gastos.getValor());
            java.util.Date dt = gastos.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);
            comando.setInt(4, gastos.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(GastosEventuais gastos) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from gastos_eventuais ");
        sql.append("where codigo_gasto= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, gastos.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<GastosEventuais> Listar(int codigo, Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gastos_eventuais inner join deposito on deposito = codigo_deposito where data between '").append(data1).append("' and '").append(data2).append("' and deposito = ").append(codigo).append(" order by data");
        ArrayList<GastosEventuais> lista;
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
                GastosEventuais gasto = new GastosEventuais();
                gasto.setCodigo(resultado.getInt("codigo_gasto"));
                gasto.setData(resultado.getDate("data"));
                gasto.setDescricao(resultado.getString("descricao"));
                gasto.setValor(resultado.getDouble("valor"));               
                gasto.setDeposito(deposito);
                lista.add(gasto);
            }
            conexao.close();
        }
        return lista;
    }
}
