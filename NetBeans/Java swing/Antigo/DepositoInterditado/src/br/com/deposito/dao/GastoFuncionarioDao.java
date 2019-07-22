package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.domain.GastoFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class GastoFuncionarioDao {

    public void Salvar(GastoFuncionario gasto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into pagamento_funcionario(descricao,valor,data,funcionario) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gasto.getDescricao());
            comando.setDouble(2, gasto.getValor());
            java.util.Date dt = gasto.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);
            comando.setInt(4, gasto.getFuncionario().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "gasto com funcionário registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registra gasto com funcionário" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from  pagamento_funcionario ");
        sql.append("where codigo_pagamento= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto com funcionário removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover gasto com funcionário" + ex);
        }
    }

    public void Alterar(GastoFuncionario gasto) {
        StringBuilder sql = new StringBuilder();
        sql.append("update pagamento_funcionario set descricao=?,valor=?,data=?,funcionario=? where codigo_pagamento=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, gasto.getDescricao());
            comando.setDouble(2, gasto.getValor());
            java.util.Date dt = gasto.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(3, d);
            comando.setInt(4, gasto.getFuncionario().getCodigo());
            comando.setInt(5, gasto.getCodigoPagamento());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Gasto com funcionário alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar gasto com funcionário" + ex);
        }
    }

    public ArrayList<GastoFuncionario> Listar(int codigo, Date data1, Date data2) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from pagamento_funcionario inner join funcionario inner join empresa on empresa = codigo_empresa on funcionario = codigo_funcionario where data between '").append(data1).append("' and '").append(data2).append("' and empresa = ").append(codigo).append(" order by data");
        ArrayList<GastoFuncionario> lista;
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
                Funcionario usuario = new Funcionario();
                usuario.setCodigo(resultado.getInt("codigo_funcionario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCargo(resultado.getString("cargo"));
                usuario.setSalario(resultado.getDouble("salario"));
                usuario.setSituacao(resultado.getString("situacao_funcionario"));
                usuario.setDeposito(deposito);
                GastoFuncionario fun = new GastoFuncionario();
                fun.setCodigoPagamento(resultado.getInt("codigo_pagamento"));
                fun.setData(resultado.getDate("data"));
                fun.setDescricao(resultado.getString("descricao"));
                fun.setValor(resultado.getDouble("valor"));
                fun.setFuncionario(usuario);
                lista.add(fun);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar gasto com funcionário" + ex);
        }
        return null;
    }   
}
