package dao;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioDao {

    public void Salvar(Usuario usuario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into usuario(login,senha,email,perfil) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getLogin());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getPerfil());
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
        sql.append("update usuario set login=?,senha=?,email=?,perfil=? where codigo_usuario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getLogin());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getPerfil());
            comando.setInt(5, usuario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Usuario> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from usuario");
        ArrayList<Usuario> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt("codigo_usuario"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setPerfil(resultado.getString("perfil"));
                lista.add(usuario);
            }
            conexao.close();
        }
        return lista;
    }

    public Usuario buscar(String login, String senha) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from usuario where login =? and senha=?");
        Usuario usuario = new Usuario();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                usuario.setCodigo(resultado.getInt("codigo_usuario"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setPerfil(resultado.getString("perfil"));
            }
            conexao.close();
        }
        return usuario;
    }    
}
