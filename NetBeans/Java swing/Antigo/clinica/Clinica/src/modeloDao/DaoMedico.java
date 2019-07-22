package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;
public class DaoMedico {
    
    ConexaoBD conex = new ConexaoBD();
    BeansMedico mod = new BeansMedico();
    
    public void Salvar(BeansMedico mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos(nome_medico,especialidade_medico,crm_medico) values (?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEspecialidade());
            pst.setInt(3,mod.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
        conex.Desconecta();
    }
    
    public void Editar(BeansMedico mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?,especialidade_medico=?,crm_medico=? where cod_medico=?");
              pst.setString(1, mod.getNome());
              pst.setString(2,mod.getEspecialidade());
              pst.setInt(3, mod.getCrm());
              pst.setInt(4, mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
    public void Excluir(BeansMedico mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    
    
    public BeansMedico buscaMedico (BeansMedico mod){
        conex.Conexao();
        conex.executaSql("select *from medicos where nome_medico like'%" + mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome (conex.rs.getString("nome_medico"));
            mod.setEspecialidade (conex.rs.getString("especialidade_medico"));
            mod.setCrm (conex.rs.getInt("Crm_medico"));
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao buscar medico\n Verifique se o medico existe ou se o capsLock está ligado\n");
        }
        
        conex.Desconecta();
        return mod;
        
    }
}
