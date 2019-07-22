package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansAutonomia;
import modeloConection.ConexaoBD;


public class DaoAutonomia {
    ConexaoBD conex = new ConexaoBD();
    BeansAutonomia auto = new BeansAutonomia();
    
    public void Salvar(BeansAutonomia auto){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into autonomia(veiculo,km,litros,valor,data,entregas) values (?,?,?,?,?,?)");
            pst.setString(1,auto.getVeiculo());
            pst.setString(2,auto.getKm());
            pst.setDouble(3,auto.getLitros());
            pst.setDouble(4,auto.getValor());
            pst.setString(5,auto.getData());
            pst.setInt(6, auto.getEntregas());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Autonomia salva com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();       
    }
    public void aumentarEntrega(BeansAutonomia auto){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update autonomia set entregas=? where codigo=?");
              pst.setInt(1,auto.getEntregas());              
              pst.setInt(2,auto.getCodigo());
              pst.execute();
              
      }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar procedimento \n" + ex);
        }        
        conex.Desconecta();
     }  
    public void Excluir(BeansAutonomia auto){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from autonomia where codigo=?");
            pst.setInt(1, auto.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Registro de autonomia desfeito com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao desfazer autonomia" + ex);
        }
        
        conex.Desconecta();
    }
}
