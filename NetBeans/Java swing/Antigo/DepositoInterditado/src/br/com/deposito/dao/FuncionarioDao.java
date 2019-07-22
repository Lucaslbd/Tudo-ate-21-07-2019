package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.domain.Inss;
import br.com.deposito.domain.Irrf;
import br.com.deposito.domain.Ponto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    public void Salvar(Funcionario funcionario) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome,cpf,cargo,situacao_funcionario,salario,empresa) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setInt(6, funcionario.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registra funcionário" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover funcionário" + ex);
        }
    }

    public void Alterar(Funcionario funcionario) {
        StringBuilder sql = new StringBuilder();
        sql.append("update funcionario set nome=?,cpf=?,cargo=?,situacao_funcionario=?,salario=? where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getCargo());
            comando.setString(4, funcionario.getSituacao());
            comando.setDouble(5, funcionario.getSalario());
            comando.setInt(6, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar funcionário" + ex);
        }
    }

    public Funcionario buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_funcionario=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
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
                return usuario;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário por codigo" + ex);
        }
        return null;
    }

    public void BaterPonto(int codigo) {
        Ponto ultimoPonto = VerificaUltimoPonto(codigo);
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ponto(descricao,data_hora,funcionario) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (ultimoPonto == null) {
                ultimoPonto = new Ponto();
                ultimoPonto.setDescricao("Saida");
            }
            if (ultimoPonto.getDescricao().equals("Chegada")) {
                comando.setString(1, "Saida");
            } else {
                comando.setString(1, "Chegada");
            }
            comando.setTimestamp(2, new Timestamp(new Date().getTime()));
            comando.setInt(3, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro de ponto efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar ponto\n" + ex);
        }
    }
    
    public void excluirPonto(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from ponto ");
        sql.append("where codigo_hora= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro de ponto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover registro de ponto" + ex);
        }
    }
    
    public void AlterarPonto(Date data, int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("update ponto set data_hora=? where codigo_hora=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setTimestamp(1, new Timestamp(data.getTime()));
            comando.setInt(2, codigo);            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Horário alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar horário" + ex);
        }
    }

    public Ponto VerificaUltimoPonto(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from ponto inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where codigo_funcionario=? order by codigo_hora DESC LIMIT 1");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setCargo(resultado.getString("cargo"));
                Ponto utimoPonto = new Ponto();
                utimoPonto.setCodigo(resultado.getInt("codigo_hora"));
                utimoPonto.setData_hora(resultado.getTimestamp("data_hora"));
                utimoPonto.setDescricao(resultado.getString("descricao"));
                utimoPonto.setFuncionario(funcionario);
                return utimoPonto;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public ArrayList<Inss> listarInss() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from inss order by valor_inicial");
        ArrayList<Inss> lista = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Inss inss = new Inss();
                inss.setValorInicial(resultado.getDouble("valor_inicial"));
                inss.setValorFinal(resultado.getDouble("valor_final"));
                inss.setPorcentagem(resultado.getDouble("porcentagem"));
                lista.add(inss);
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return lista;
    }

    public ArrayList<Irrf> listarIrrf() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from irrf order by valor_inicial");
        ArrayList<Irrf> lista = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Irrf irrf = new Irrf();
                irrf.setValorInicial(resultado.getDouble("valor_inicial"));
                irrf.setValorFinal(resultado.getDouble("valor_final"));
                irrf.setPorcentagem(resultado.getDouble("porcentagem"));
                irrf.setDevolver(resultado.getDouble("devolver"));
                lista.add(irrf);
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return lista;
    }
}
