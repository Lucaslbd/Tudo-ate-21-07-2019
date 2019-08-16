package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ContatoDao {

    public void Salvar(Contato contato) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into contato(nome,fone,email,motivo,data) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, contato.getNome());
            comando.setString(2, contato.getFone());
            comando.setString(3, contato.getEmail());
            comando.setString(4, contato.getMotivo());         
            comando.setTimestamp(5, new Timestamp(new Date().getTime()));
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Contato contato) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from contato ");
        sql.append("where codigo_contato= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, contato.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }    

    public ArrayList<Contato> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contato order by data");
        ArrayList<Contato> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Contato contato = new Contato();
                contato.setCodigo(resultado.getInt("codigo_contato"));
                contato.setNome(resultado.getString("nome"));
                contato.setFone(resultado.getString("fone"));
                contato.setEmail(resultado.getString("email"));
                contato.setMotivo(resultado.getString("motivo"));
                contato.setData(resultado.getTimestamp("data"));                
                lista.add(contato);
            }
            conexao.close();
        }
        return lista;
    }

    public Contato buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contato where codigo_contato = ").append(codigo).append("");
        Contato contato = new Contato();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                contato.setCodigo(resultado.getInt("codigo_contato"));
                contato.setNome(resultado.getString("nome"));
                contato.setFone(resultado.getString("fone"));
                contato.setEmail(resultado.getString("email"));
                contato.setMotivo(resultado.getString("motivo"));
                contato.setData(resultado.getTimestamp("data"));              
            }
            conexao.close();
        }
        return contato;
    }
}