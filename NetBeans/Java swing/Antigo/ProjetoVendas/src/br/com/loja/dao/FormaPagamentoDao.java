package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.FormaPagamento;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FormaPagamentoDao {
    
     public void SalvarPagamento(FormaPagamento pag) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into pagamento(forma_pagamento,valor_pagamento,venda) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, pag.getFormaPagamento());
            comando.setDouble(2, pag.getValorPagamento());
            comando.setInt(3, pag.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();
            // JOptionPane.showMessageDialog(null, "Pagamento salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar pagamento\n" + ex);
        }
    }
     
     public ArrayList<FormaPagamento> BuscaPagamento(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from pagamento inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where venda =").append(codigo).append(" order by codigo_pagamento");
        Connection conexao;
        ArrayList<FormaPagamento> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor_venda"));
                venda.setData(resultado.getDate("data"));
                venda.setLucro(resultado.getDouble("lucro"));
                venda.setFuncionario(funcionario);
                FormaPagamento pagamento = new FormaPagamento();
                pagamento.setFormaPagamento(resultado.getString("forma_pagamento"));
                pagamento.setValorPagamento(resultado.getDouble("valor_pagamento"));
                pagamento.setVenda(venda);
                lista.add(pagamento);

            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return lista;
    }
}
