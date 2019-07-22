package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.ControleFolhaPagamento;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Ponto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    public Funcionario autenticar(String cpf, String senha) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where cpf=? and senha=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            Funcionario funcionario = null;
            if (resultado.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setFgts(resultado.getInt("fgts"));                             
            }
            return funcionario;
        } catch (SQLException ex) {
        }
        return null;
    }
     public Funcionario buscarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where codigo_funcionario=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);            
            ResultSet resultado = comando.executeQuery();
            Funcionario funcionario = null;
            if (resultado.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setFgts(resultado.getInt("fgts"));                         
            }
            return funcionario;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void Salvar(Funcionario funcionario) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome,salario,senha,cpf,funcao,telefone,situacao,fgts) values (?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setDouble(2, funcionario.getSalario());
            comando.setString(3, funcionario.getSenha());
            comando.setString(4, funcionario.getCpf());
            comando.setString(5, funcionario.getFuncao());
            comando.setString(6, funcionario.getTelefone());
            comando.setString(7, funcionario.getSituacao());
            comando.setInt(8, funcionario.getFgts());                   
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionario adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar funcionario\n" + ex);
        }
    }

    public void Alterar(Funcionario funcionario) {
        StringBuilder sql = new StringBuilder();
        sql.append("update funcionario set nome=?,salario=?,senha=?,cpf=?,funcao=?,telefone=?,situacao=?,fgts=? where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setDouble(2, funcionario.getSalario());
            comando.setString(3, funcionario.getSenha());
            comando.setString(4, funcionario.getCpf());
            comando.setString(5, funcionario.getFuncao());
            comando.setString(6, funcionario.getTelefone());
            comando.setString(7, funcionario.getSituacao());
            comando.setInt(8, funcionario.getFgts());                    
            comando.setInt(9, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario\n" + ex);
        }
    }

    public void excluir(Funcionario funcionario) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O funcionario não pode ser removido pois exitem informações a ele relacionado");
        }
    }

    public void BaterPonto(Ponto ponto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ponto(descricao,data_hora,funcionario) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, ponto.getDescricao());
            comando.setTimestamp(2, new Timestamp(ponto.getData_hora().getTime()));
            comando.setInt(3, ponto.getFuncionario().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro de ponto efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar ponto\n" + ex);
        }
    }

    public Ponto VerificaUltimoPonto(String cpf, String senha) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from ponto inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where cpf=? and senha=? order by codigo_hora DESC LIMIT 1");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            Ponto utimoPonto = null;
            Funcionario funcionario = null;
            if (resultado.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setFgts(resultado.getInt("fgts"));                         
                utimoPonto = new Ponto();
                utimoPonto.setCodigo(resultado.getInt("codigo_hora"));
                utimoPonto.setData_hora(resultado.getTimestamp("data_hora"));
                utimoPonto.setDescricao(resultado.getString("descricao"));
                utimoPonto.setFuncionario(funcionario);
            }
            return utimoPonto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public ArrayList<Ponto> ListaPontos(String data1, String data2, String nome) {
        ArrayList<Ponto> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from ponto inner join funcionario on funcionario = codigo_funcionario where data_hora between '").append(data1).append("' and '").append(data2).append("' and nome='").append(nome).append("' order by data_hora");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            Ponto Ponto = null;
            Funcionario funcionario = null;
            while (resultado.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao"));
                funcionario.setFgts(resultado.getInt("fgts"));                               
                Ponto = new Ponto();
                Ponto.setCodigo(resultado.getInt("codigo_hora"));
                Ponto.setData_hora(resultado.getTimestamp("data_hora"));
                Ponto.setDescricao(resultado.getString("descricao"));
                Ponto.setFuncionario(funcionario);
                lista.add(Ponto);
            }
            return lista;
        } catch (SQLException ex) {
        }
        return null;
    }
    
     public void RegistrarPagamento(ControleFolhaPagamento folha) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into folha_pagamento(data,valor_salario,descricao,funcionario) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, folha.getData());
            comando.setDouble(2, folha.getValor());
            comando.setString(3, folha.getDescricao());
            comando.setInt(4, folha.getFuncionario().getCodigo());            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar registro\n" + ex);
        }
    }
     public void AlterarRegistroPagamento(ControleFolhaPagamento folha) {
        StringBuilder sql = new StringBuilder();
        sql.append("update folha_pagamento set data=?,valor_salario=?,descricao=? where codigo_salario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, folha.getData());
            comando.setDouble(2, folha.getValor());
            comando.setString(3, folha.getDescricao());
            comando.setInt(4, folha.getCodigo());            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Regitro alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar registro\n" + ex);
        }
    }
     public void excluirPagamento(ControleFolhaPagamento folha) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from folha_pagamento ");
        sql.append("where codigo_salario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, folha.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }

}
