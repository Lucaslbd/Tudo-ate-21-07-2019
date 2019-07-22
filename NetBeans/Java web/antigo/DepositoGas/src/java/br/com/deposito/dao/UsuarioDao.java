package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    public void Salvar(Usuario usuario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into usuario(nome,cpf,senha,tipo,deposito) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipo());
            comando.setInt(5, usuario.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Usuario usuario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from usuario ");
        sql.append("where codigo_usuario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, usuario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Usuario usuario) throws SQLException {
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
        }
    }

    public ArrayList<Usuario> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from usuario inner join deposito on deposito = codigo_deposito where codigo_deposito = ").append(codigo).append(" order by nome");
        ArrayList<Usuario> lista;
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
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt("codigo_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setTipo(resultado.getString("tipo"));
                usuario.setDeposito(deposito);
                lista.add(usuario);
            }
            conexao.close();
        }
        return lista;
    }

    public Usuario autenticar(String cpf, String senha) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from usuario inner join deposito on deposito = codigo_deposito ");
        sql.append("where cpf=? and senha=?");      
        try (Connection conexao = ConexaoBD.conectar()) {            
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
            comando.setString(2, senha);
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
        } 
        return null;
    }

    public Usuario listarPorCpf(String cpf) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from usuario inner join deposito on deposito = codigo_deposito ");
        sql.append("where cpf=?");      
        try (Connection conexao = ConexaoBD.conectar()){           
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
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
        }
        return null;
    }

}
