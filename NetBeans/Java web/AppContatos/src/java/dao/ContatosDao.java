package dao;

import Domain.Contatos;
import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatosDao {

    public void Salvar(Contatos contato) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into contatos(nome,telefone,email,foto) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, contato.getNome());
            comando.setString(2, contato.getTelefone());
            comando.setString(3, contato.getEmail());
            comando.setBytes(4, contato.getFoto());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from contatos ");
        sql.append("where codigo= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Contatos contato) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update contatos set nome=?,telefone=?,email=?,foto=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, contato.getNome());
            comando.setString(2, contato.getTelefone());
            comando.setString(3, contato.getEmail());
            comando.setBytes(4, contato.getFoto());
            comando.setInt(5, contato.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Contatos> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contatos");
        ArrayList<Contatos> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Contatos contato = new Contatos();
                contato.setCodigo(resultado.getInt("codigo"));
                contato.setEmail(resultado.getString("email"));
                contato.setNome(resultado.getString("nome"));
                contato.setTelefone(resultado.getString("telefone"));
                contato.setFoto(resultado.getBytes("foto"));
                lista.add(contato);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Contatos> buscar(String nome) throws SQLException {
        StringBuilder sql = new StringBuilder();       
        sql.append("select * from contatos where nome ilike'%").append(nome).append("%' order by nome");
        ArrayList<Contatos> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Contatos contato = new Contatos();
                contato.setCodigo(resultado.getInt("codigo"));
                contato.setEmail(resultado.getString("email"));
                contato.setNome(resultado.getString("nome"));
                contato.setTelefone(resultado.getString("telefone"));
                contato.setFoto(resultado.getBytes("foto"));
                lista.add(contato);
            }
            conexao.close();
        }
        return lista;
    }
}
