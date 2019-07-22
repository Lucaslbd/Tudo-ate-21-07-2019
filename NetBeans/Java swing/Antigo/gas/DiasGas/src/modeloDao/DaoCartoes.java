package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansCartoes;
import modeloConection.ConexaoBD;


public class DaoCartoes {
    BeansCartoes cart = new BeansCartoes();
     ConexaoBD conex = new ConexaoBD();
    
    public void Salvar(BeansCartoes cart){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into cartoes(valor,data,hora,situacao,tipo,receber) values (?,?,?,?,?,?)");
            pst.setDouble(1,cart.getValor());
            pst.setString(2,cart.getData());
            pst.setString(3,cart.getHora());
            pst.setString(4,cart.getSituacao());
            pst.setString(5,cart.getTipoCartao());
            pst.setDouble(6, cart.getReceber());
            
        pst.execute();
    
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados do cartão\n"+ex);
        }
         conex.Desconecta();        
    }
    public void Editarsituacao(BeansCartoes mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update cartoes set situacao=? where codigo=?");
              pst.setString(1, mod.getSituacao());              
              pst.setInt(2,mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Recebimento de cartão efetuado com sucesso");
      }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar pagamento \n" + ex);
        }
        
        conex.Desconecta();
     }
     public void Excluir(BeansCartoes mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from cartoes where codigo=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Registro de cartão excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir registro" + ex);
        }
        
        conex.Desconecta();
    }
}
