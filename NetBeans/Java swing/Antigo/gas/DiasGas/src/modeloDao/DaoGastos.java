package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansGastos;
import modeloConection.ConexaoBD;


public class DaoGastos {
    ConexaoBD conex = new ConexaoBD();
    BeansGastos mod = new BeansGastos();
    
    public void Salvar(BeansGastos mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into gastos(descricao_gasto,valor_gasto,data_gasto,referente) values (?,?,?,?)");
            pst.setString(1,mod.getDescricaoGasto());
            pst.setDouble(2,mod.getValorGasto());
            pst.setString(3,mod.getDataGasto());
            pst.setString(4,mod.getReferencia());
           pst.execute();
            JOptionPane.showMessageDialog(null,"gasto salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
        
    }
     public BeansGastos PesquisarData (BeansGastos mod){
        conex.Conexao();
        conex.executaSql("select *from gastos where data_gasto like'%" + mod.getPesquisarGasto()+"%'");
        try {
            conex.rs.first();
            mod.setCodigoGasto(conex.rs.getInt("codigo_gasto"));
            mod.setDescricaoGasto(conex.rs.getString("descricao_gasto"));
            mod.setValorGasto(conex.rs.getDouble("valor_gasto"));
            mod.setDataGasto(conex.rs.getString("data_gasto"));
          } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao buscar clientes\n Verifique se o medico existe ou se o capsLock está ligado\n");
        }
        
        conex.Desconecta();
        return mod;
    
}
     public void Excluir(BeansGastos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from gastos where codigo_gasto=?");
            pst.setInt(1, mod.getCodigoGasto());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Gasto excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
     public void Editar(BeansGastos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update gastos set descricao_gasto=?,valor_gasto=?,data_gasto=?, referente=? where codigo_gasto=?");
              pst.setString(1, mod.getDescricaoGasto());
              pst.setDouble(2,mod.getValorGasto());
              pst.setString(3, mod.getDataGasto());
              pst.setString(4,mod.getReferencia());
              pst.setInt(5,mod.getCodigoGasto());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
}
