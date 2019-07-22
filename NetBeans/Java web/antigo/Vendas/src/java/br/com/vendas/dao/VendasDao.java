package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class VendasDao {

    public void Salvar(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(valor,data,funcionario) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setDouble(1, venda.getValor());
            comando.setTimestamp(2, new Timestamp(venda.getData().getTime()));
            comando.setInt(3, venda.getFuncionario().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Venda venda) throws SQLException {         
        StringBuilder sql1 = new StringBuilder();
        sql1.append("delete from venda ");
        sql1.append("where codigo_venda=? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql1.toString());
            comando.setInt(1, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update produto set valor=?,funcionario=? where codigo_venda=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setDouble(1, venda.getValor());
            comando.setInt(2, venda.getFuncionario().getCodigo());
            comando.setInt(3, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

   /* public ArrayList<Venda> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join funcionario on funcionario = codigo_funcionario order by codigo_venda");
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        ArrayList<Venda> lista = new ArrayList();

        while (resultado.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setCpf(resultado.getString("cpf"));
            funcionario.setEmail(resultado.getString("email"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setFuncao(resultado.getString("funcao"));
            funcionario.setSenha(resultado.getString("senha"));
            Venda venda = new Venda();
            venda.setCodigo(resultado.getInt("codigo_venda"));
            venda.setValor(resultado.getDouble("valor"));
            venda.setData(resultado.getDate("data"));
            venda.setFuncionario(funcionario);
            lista.add(venda);
        }
        return lista;
    }*/

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
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setFuncionario(funcionario);
                return venda;
            }
           conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);            
        }
        return null;
    }
    
    public ArrayList<Venda> ListarPorData(Date data1,Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join funcionario on funcionario = codigo_funcionario where data  between '").append(data1).append("' and '").append(data2).append("' order by codigo_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getTimestamp("data"));
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }
   
}
