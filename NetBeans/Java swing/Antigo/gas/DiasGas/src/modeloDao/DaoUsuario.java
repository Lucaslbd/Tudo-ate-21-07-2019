package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansUsuario;
import modeloConection.ConexaoBD;


public class DaoUsuario {
     ConexaoBD conex = new ConexaoBD();
     BeansUsuario mod = new BeansUsuario();

 public void Salvar(BeansUsuario mod){
        conex.Conexao();
     
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuarios(usuario_nome,usuario_senha,usuario_tipo) values (?,?,?)");
            pst.setString(1,mod.getUsuNome());
            pst.setString(2,mod.getUsuSenha());
            pst.setString(3,mod.getUsuTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Usuário enserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir usuário\n" + ex);
        }
        conex.Desconecta();
    }

 public BeansUsuario buscaUsuario (BeansUsuario mod){
        conex.Conexao();
        conex.executaSql("select *from usuarios where usuario_nome like'%" + mod.getUsupesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setUsuCod(conex.rs.getInt("usuario_cod"));
            mod.setUsuNome(conex.rs.getString("usuario_nome"));
            mod.setUsuTipo(conex.rs.getString("usuario_tipo"));
            mod.setUsuSenha(conex.rs.getString("usuario_senha"));
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Usuario não cadastrado");
        }
        
        conex.Desconecta();
        return mod;
}
 
  public void Editar(BeansUsuario mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuarios set usuario_nome=?,usuario_senha=?,usuario_tipo=? where usuario_cod=?");
              pst.setString(1, mod.getUsuNome());
              pst.setString(2,mod.getUsuSenha());
              pst.setString(3,mod.getUsuTipo());
              pst.setInt(4,mod.getUsuCod());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
  public void Excluir(BeansUsuario mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where usuario_cod=?");
            pst.setInt(1, mod.getUsuCod());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
}
