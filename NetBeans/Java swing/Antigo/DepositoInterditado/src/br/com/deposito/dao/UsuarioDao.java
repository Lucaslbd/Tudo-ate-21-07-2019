package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDao {

    public void Salvar(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into usuario(nome,cpf,senha,tipo,empresa) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipo());
            comando.setInt(5, usuario.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel registrar o usuário pois ela já está cadastrado em nosso banco de dados");
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from usuario ");
        sql.append("where codigo_usuario= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1,codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário" + ex);
        }
    }

    public void Alterar(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("update usuario set nome=?,cpf=?,senha=?,tipo=? where codigo_usuario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipo());
            comando.setInt(5, usuario.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário");
        }
    }
   
    public Usuario autenticar(String cpf, String senha) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from usuario inner join empresa on empresa = codigo_empresa ");
        sql.append("where cpf=? and senha=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
            comando.setString(2, senha);
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
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt("codigo_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setTipo(resultado.getString("tipo"));
                usuario.setDeposito(deposito);
                return usuario;
            }
            conexao.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar" + ex);
        }
        return null;
    }    

    public Usuario buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from usuario inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_usuario=?");
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
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt("codigo_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setTipo(resultado.getString("tipo"));
                usuario.setDeposito(deposito);
                return usuario;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario por codigo" + ex);
        }
        return null;
    }
}
