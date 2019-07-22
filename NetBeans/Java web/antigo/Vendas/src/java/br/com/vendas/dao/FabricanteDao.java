package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Fabricante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FabricanteDao {
       
    public void Salvar(Fabricante fabricante) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fabricante(nome,cnpj,telefone,responsavel) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setString(1, fabricante.getNome());
            comando.setString(2, fabricante.getCnpj());
            comando.setString(3, fabricante.getTelefone());
            comando.setString(4, fabricante.getEmail());
            comando.executeUpdate();
            conexao.close();
        }
    }
    
    public void excluir(Fabricante fabricante) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fabricante ");
        sql.append("where codigo_fabricante= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, fabricante.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
    public void Alterar(Fabricante fabricante) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update fabricante set nome=?,cnpj=?,telefone=?,responsavel=? where codigo_fabricante=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setString(1, fabricante.getNome());
            comando.setString(2, fabricante.getCnpj());
            comando.setString(3, fabricante.getTelefone());
            comando.setString(4, fabricante.getEmail());
            comando.setInt(5,fabricante.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Fabricante> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fabricante order by nome");
        ArrayList<Fabricante> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo_fabricante"));
                fabricante.setNome(resultado.getString("nome"));
                fabricante.setCnpj(resultado.getString("cnpj"));
                fabricante.setTelefone(resultado.getString("telefone"));
                fabricante.setEmail(resultado.getString("responsavel"));
                lista.add(fabricante);
            }
            conexao.close();
        }
        return lista;
    }   
    
   
}
