
package Dao;

import Beans.BeansClientes;
import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoClientes {
 BeansClientes clientes = new BeansClientes();
 ConexaoBD conex = new ConexaoBD();
 
 public void Salvar(BeansClientes clientes){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into clientes(nome,nascimento,cpf,rg,telefone) values (?,?,?,?,?)");
            pst.setString(1,clientes.getNome());
            pst.setString(2,clientes.getNascimento());
            pst.setString(3,clientes.getCpf());
            pst.setString(4,clientes.getRg());
            pst.setString(5,clientes.getTelefone());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir clietes\n" + ex);
        }
         conex.Desconecta();        
    }
 public void Editar(BeansClientes clientes){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update clientes set nome=?,nascimento=?,cpf=?,rg=?,telefone=? where codigo=?");
            pst.setString(1,clientes.getNome());
            pst.setString(2,clientes.getNascimento());
            pst.setString(3,clientes.getCpf());
            pst.setString(4,clientes.getRg());
            pst.setString(5,clientes.getTelefone());          
            pst.setInt(6,clientes.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
 public void Excluir(BeansClientes clientes){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from clientes where codigo=?");
            pst.setInt(1, clientes.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Clientes excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"O cliente não pode ser excluido pois ele está vinculado a algum grupo");
        }
        
        conex.Desconecta();
    }
}
