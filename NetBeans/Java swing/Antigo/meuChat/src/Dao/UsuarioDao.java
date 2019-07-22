package Dao;

import Conexao.ConexaoBD;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDao {
    
     public void Salvar(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(nome,rg,cpf,telefone,email,cidade,bairro,rua,numero) values (?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setBytes(1, usuario.getFoto());
            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "cliente adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cliente fornecedor\n" + ex);
        }
    }
}
