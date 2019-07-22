package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansVeiculos;
import modeloConection.ConexaoBD;


public class DaoVeiculos {
    ConexaoBD conex = new ConexaoBD();
     BeansVeiculos mod = new BeansVeiculos();
     
      public void Salvar(BeansVeiculos mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into veiculos(placa) values (?)");
            pst.setString(1,mod.getPlaca());
           pst.execute();
            JOptionPane.showMessageDialog(null,"Novo veiculo adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
    }
      public void Editar(BeansVeiculos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update veiculos set placa=? where codigo=?");
            pst.setString(1,mod.getPlaca());
            pst.setInt(2,mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Informações atualizadas com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
       public void Excluir(BeansVeiculos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from veiculos where codigo=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Veiculo excluido com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
       }
}
