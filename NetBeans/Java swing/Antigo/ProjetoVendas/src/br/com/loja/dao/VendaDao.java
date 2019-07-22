package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDao {

    public void Salvar(Venda venda) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(data,valor_venda,funcionario,lucro) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setTimestamp(1, new Timestamp(venda.getData().getTime()));
            comando.setDouble(2, venda.getValor());
            comando.setInt(3, venda.getFuncionario().getCodigo());
            comando.setDouble(4,venda.getLucro());
            comando.executeUpdate();
            conexao.close();
            //  JOptionPane.showMessageDialog(null, "Venda salva com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar venda\n" + ex);
        }
    }   

    public Venda Ultimoregistro() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join funcionario on funcionario = codigo_funcionario order by codigo_venda DESC LIMIT 1");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
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
                return venda;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }   

    public ArrayList<Venda> BuscarPorData(String data1, String data2) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join funcionario on funcionario = codigo_funcionario where data between '").append(data1).append("' and '").append(data2).append("' order by data");
        ArrayList<Venda> lista = new ArrayList();
        Connection conexao;
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
                venda.setData(resultado.getTimestamp("data"));
                venda.setLucro(resultado.getDouble("lucro"));
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
}
