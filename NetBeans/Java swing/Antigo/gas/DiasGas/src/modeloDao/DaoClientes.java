package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansClientes;
import modeloConection.ConexaoBD;


public class DaoClientes {
    ConexaoBD conex = new ConexaoBD();
    BeansClientes mod = new BeansClientes();
    
    public void Salvar(BeansClientes mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into clientes(cliente_nome,cliente_fone,cliente_rua,cliente_numero,cliente_bairro) values (?,?,?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getFone());
            pst.setString(3,mod.getRua());
            pst.setString(4,mod.getNumero());
            pst.setString(5,mod.getBairro());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
        
    }
    
    public void Excluir(BeansClientes mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from clientes where cliente_codigo=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    public void Editar(BeansClientes mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update clientes set cliente_nome=?,cliente_fone=?,cliente_rua=?,cliente_numero=?,cliente_bairro=? where cliente_codigo=?");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getFone());
            pst.setString(3,mod.getRua());
            pst.setString(4,mod.getNumero());
            pst.setString(5,mod.getBairro());           
            pst.setInt(6,mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
    public BeansClientes buscaCliente (BeansClientes mod){        
        try {
            conex.Conexao();
            conex.executaSql("select *from clientes where cliente_nome like'%" + mod.getPesquisa()+"%'");
            conex.rs.first();
            mod.setNome (conex.rs.getString("cliente_nome"));
            mod.setFone(conex.rs.getString("cliente_fone"));
            mod.setRua(conex.rs.getString("cliente_rua"));
            mod.setNumero(conex.rs.getString("cliente_numero"));
            mod.setBairro(conex.rs.getString("cliente_bairro"));
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Clientes não encontrado");
        }
        
        conex.Desconecta();
        return mod;
        
    }
}
