package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Comentario;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class ComentarioDao {
    
    public void Salvar(Comentario comentario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into comentario(mensagem,data,empresa) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, comentario.getMensagem());
            comando.setTimestamp(2, new Timestamp(comentario.getData().getTime()));
            comando.setInt(3, comentario.getEmpresa().getCodigo());           
            comando.executeUpdate();
            conexao.close();           
        }
    }
    
    public void Alterar(Comentario comentario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update comentario set mensagem=? where codigo_comentario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, comentario.getMensagem());            
            comando.setInt(2, comentario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
    
     public void excluir(Comentario comentario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from comentario ");
        sql.append("where codigo_comentario= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, comentario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
    
    public ArrayList<Comentario> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from comentario inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa order by data");
        ArrayList<Comentario> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSistema(sistema);
                Comentario comentario = new Comentario();
                comentario.setCodigo(resultado.getInt("codigo_comentario"));
                comentario.setData(resultado.getTimestamp("data"));
                comentario.setMensagem(resultado.getString("mensagem"));
                comentario.setEmpresa(empresa);
                lista.add(comentario);
            }
            conexao.close();
        }
        return lista;
    }
}
