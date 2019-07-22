package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansTaxas;
import modeloConection.ConexaoBD;


public class DaoTaxas {
    
    ConexaoBD conex = new ConexaoBD();
    BeansTaxas mod = new BeansTaxas();
    
    public void Excluir(BeansTaxas mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from taxa_cartoes where codigo=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"taxa desfeita com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
       }
    public void Salvar(BeansTaxas mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into taxa_cartoes(tipo,taxa) values (?,?)");
            pst.setString(1,mod.getModalidade());
            pst.setDouble(2,mod.getTaxa());
           pst.execute();
            JOptionPane.showMessageDialog(null,"Nova taxa adicionada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
    }
    public void Editar(BeansTaxas mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update taxa_cartoes set taxa=? where codigo=?");
            pst.setDouble(1,mod.getTaxa());
            pst.setInt(2,mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Informações atualizadas com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
}
