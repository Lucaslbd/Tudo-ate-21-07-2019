package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.domain.Inss;
import br.com.deposito.domain.Irrf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDao {

    public void Salvar(Funcionario funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome,cpf,cargo,situacao_funcionario,salario,deposito) values (?,?,?,?,?,?)");
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
        }
    }

    public void excluir(Funcionario funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Funcionario funcionario) throws SQLException {
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
        }
    }

    public ArrayList<Funcionario> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from funcionario inner join deposito on deposito = codigo_deposito where codigo_deposito = ").append(codigo).append(" order by nome");
        ArrayList<Funcionario> lista;
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
                Funcionario usuario = new Funcionario();
                usuario.setCodigo(resultado.getInt("codigo_funcionario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCargo(resultado.getString("cargo"));
                usuario.setSalario(resultado.getDouble("salario"));
                usuario.setSituacao(resultado.getString("situacao_funcionario"));
                usuario.setDeposito(deposito);
                lista.add(usuario);
            }
            conexao.close();
        }
        return lista;
    }

    public Funcionario buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario inner join deposito on deposito = codigo_deposito ");
        sql.append("where codigo_funcionario=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
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
            System.out.println("Ocorreu um erro" + ex);
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
