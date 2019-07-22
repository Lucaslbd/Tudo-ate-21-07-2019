package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Fechamento;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FechamentoDao {
    
    public void Salvar(Fechamento fechamento) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fechamento(pagamento,valor_fechamento,situacao,venda) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, fechamento.getPagamento());
            comando.setDouble(2, fechamento.getValor_fechamento());
            comando.setString(3, fechamento.getSituacao());
            comando.setInt(4, fechamento.getVenda().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
    public ArrayList<Fechamento> ListarPorVenda(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fechamento inner join venda inner join funcionario on funcionario = codigo_funcionario on venda = codigo_venda where venda=").append(codigo).append(" order by codigo_fechamento");
        ArrayList<Fechamento> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {              
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));                
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setFuncionario(funcionario);                
                Fechamento fechamento= new Fechamento();
                fechamento.setCodigo_fechamento(resultado.getInt("codigo_fechamento"));
                fechamento.setPagamento(resultado.getString("pagamento"));
                fechamento.setValor_fechamento(resultado.getDouble("valor_fechamento"));
                fechamento.setVenda(venda);                
                lista.add(fechamento);
            }
            conexao.close();
        }
        return lista;
    }
    
}
