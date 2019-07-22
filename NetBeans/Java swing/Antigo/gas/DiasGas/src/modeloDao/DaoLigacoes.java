package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansLigacoes;
import modeloConection.ConexaoBD;


public class DaoLigacoes {
    
    ConexaoBD conex = new ConexaoBD();
    
    public void Salvar(BeansLigacoes mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into ligacoes(telefone,decisao,data,hora) values (?,?,?,?)");
            pst.setString(1,mod.getTelefone());
            pst.setString(2,mod.getDecisao());
            pst.setString(3,mod.getData());
            pst.setString(4,mod.getHora());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
        
    }
    public void Excluir(BeansLigacoes mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from ligacoes where telefone=?");
            pst.setString(1, mod.getTelefone());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    
}
