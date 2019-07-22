
package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBDSistemas;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDao {
    
    public void salvar(Usuario usuario) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into usuario(nome,cpf,tipo,senha,empresa) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBDSistemas.conectar(usuario.getEmpresa().getSistema().getCaminho(), usuario.getEmpresa().getSistema().getBanco(), usuario.getEmpresa().getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setString(3, usuario.getTipo());
            comando.setString(4, usuario.getSenha());                      
            comando.setInt(5, usuario.getEmpresa().getCodigo());
            comando.executeUpdate();
            conexao.close();            
        }
    }    
}
