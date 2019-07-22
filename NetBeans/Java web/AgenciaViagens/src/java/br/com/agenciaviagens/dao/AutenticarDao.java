package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBDAutenticar;
import br.com.agenciaviagens.domain.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticarDao {
    
    public Empresa autenticar(String cpf, String senha) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empresa ");
        sql.append("where email=? and senha_empresa=?");        
        try (Connection conexao = ConexaoBDAutenticar.conectar()) {            
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, cpf);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Empresa empresa = new Empresa();
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setNomeEmpresa(resultado.getString("razao_social"));
                empresa.setNomeProprietario(resultado.getString("nome_proprietario"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setNumeroBanco(resultado.getString("numero_banco"));
                empresa.setNomeSistema(resultado.getString("sistema"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                return empresa;
            }
            conexao.close();
        }        
        return null;
    }
    
    public void online(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set online=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBDAutenticar.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "Online");
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }
    
    public void offline(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set online=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBDAutenticar.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "Offline");
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }
}
