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
import javax.swing.JOptionPane;

public class GastosEventuaisDao {

    public void Salvar(GastosEventuais gastos) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into gastos_eventuais(descricao,valor,data,empresa) values (?,?,?,?)");
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
            JOptionPane.showMessageDialog(null, "Gasto eventual registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar gasto eventual" + ex);
        }
    }

    public void Alterar(GastosEventuais gastos) {
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
            JOptionPane.showMessageDialog(null, "Gasto eventual alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar gasto eventual" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from gastos_eventuais ");
        sql.append("where codigo_gasto= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto eventual removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover gasto eventual" + ex);
        }
    }

    public ArrayList<GastosEventuais> Listar(int codigo, Date data1, Date data2) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gastos_eventuais inner join empresa on empresa = codigo_empresa where data between '").append(data1).append("' and '").append(data2).append("' and empresa = ").append(codigo).append(" order by data");
        ArrayList<GastosEventuais> lista;
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
                GastosEventuais gasto = new GastosEventuais();
                gasto.setCodigo(resultado.getInt("codigo_gasto"));
                gasto.setData(resultado.getDate("data"));
                gasto.setDescricao(resultado.getString("descricao"));
                gasto.setValor(resultado.getDouble("valor"));
                gasto.setDeposito(deposito);
                lista.add(gasto);
            }
            conexao.close();            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar gastos" + ex);
        }
        return null;
    }
}
