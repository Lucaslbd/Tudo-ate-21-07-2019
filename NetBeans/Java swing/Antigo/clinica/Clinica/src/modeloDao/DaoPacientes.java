package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansPaciente;
import modeloConection.ConexaoBD;




public class DaoPacientes {
    ConexaoBD conex = new ConexaoBD();
    BeansPaciente mod = new BeansPaciente();
    
     public void Salvar(BeansPaciente mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes(pac_nome,pac_rg,pac_fone,pac_cidade,pac_bairro,pac_rua,pac_numero,pac_nascimento) values (?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNomePac());
            pst.setString(2,mod.getRg());
            pst.setString(3,mod.getTelefone());
            pst.setString(4,mod.getCidade());
            pst.setString(5,mod.getBairro());
            pst.setString(6,mod.getRua());
            pst.setString(7,mod.getNumero());
            pst.setString(8,mod.getNascimento());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex.getMessage());
        }
        conex.Desconecta();
    }
   public BeansPaciente buscaPaciente (BeansPaciente mod){
        conex.Conexao();
        conex.executaSql("select *from pacientes where pac_nome like'%" + mod.getPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setCodPac(conex.rs.getInt("pac_cod"));
            mod.setNomePac(conex.rs.getString("pac_nome"));
            mod.setNascimento(conex.rs.getString("pac_nascimento"));
            mod.setRg(conex.rs.getString("pac_rg"));
            mod.setTelefone(conex.rs.getString("pac_fone"));
            mod.setCidade(conex.rs.getString("pac_cidade"));
            mod.setBairro(conex.rs.getString("pac_bairro"));
            mod.setRua(conex.rs.getString("pac_rua"));
            mod.setNumero(conex.rs.getString("pac_numero"));
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao buscar paciente\n Verifique se o medico existe ou se o capsLock está ligado\n" +ex.getMessage());
        }
        
        conex.Desconecta();
        return mod;
     }
   public void Excluir(BeansPaciente mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from Pacientes where pac_cod=?");
            pst.setInt(1, mod.getCodPac());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    public void Editar(BeansPaciente mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update pacientes set pac_nome=?,pac_rg=?,pac_fone=?,pac_cidade=?,pac_bairro=?,pac_rua=?,pac_numero=?,pac_nascimento=? where pac_cod=?");
            pst.setString(1,mod.getNomePac());
            pst.setString(2,mod.getRg());
            pst.setString(3,mod.getTelefone());
            pst.setString(4,mod.getCidade());
            pst.setString(5,mod.getBairro());
            pst.setString(6,mod.getRua());
            pst.setString(7,mod.getNumero());
            pst.setString(8,mod.getNascimento());
            pst.setInt(9,mod.getCodPac());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex.getMessage());
        }
        conex.Desconecta();
    }
    
  
}

