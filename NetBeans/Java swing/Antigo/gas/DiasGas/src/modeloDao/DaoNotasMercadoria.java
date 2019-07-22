package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansNotasMercadoria;
import modeloConection.ConexaoBD;


public class DaoNotasMercadoria {
    ConexaoBD conex = new ConexaoBD();
    BeansNotasMercadoria mod = new BeansNotasMercadoria();
    
    public void Salvar(BeansNotasMercadoria mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into notasmercadoria(produto,data,valor,quantidade,vencimento,situacao,descricao_nota, casco) values (?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getProduto());
            pst.setString(2,mod.getData());
            pst.setDouble(3,mod.getValor());
            pst.setInt(4,mod.getQuantidade());
            pst.setString(5,mod.getVencimento());
            pst.setString(6,mod.getSituacao());
            pst.setString(7,mod.getDescricaoNota());
            pst.setString(8, mod.getCasco());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Nota cadastrada com sucesso e estoque atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar nota dados\n" + ex);
        }
         conex.Desconecta();
}
     public void Editarsituacao(BeansNotasMercadoria mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update notasmercadoria set situacao=? where codigo=?");
              pst.setString(1, mod.getSituacao());              
              pst.setInt(2,mod.getCodigoNota());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Pagamento da nota efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar pagamento \n" + ex);
        }
        
        conex.Desconecta();
     }
     public void Excluir(BeansNotasMercadoria mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from notasmercadoria where codigo=?");
            pst.setInt(1, mod.getCodigoNota());
            pst.execute();
             JOptionPane.showMessageDialog(null,"nota excluida com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir nota\n" + ex);
        }
        
        conex.Desconecta();
    }
      public void Editar(BeansNotasMercadoria mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update notasmercadoria set descricao_nota=?,data=?,vencimento=?,valor=?,situacao=? where codigo=?");
            pst.setString(1,mod.getDescricaoNota());
            pst.setString(2,mod.getData());
            pst.setString(3,mod.getVencimento());
            pst.setDouble(4,mod.getValor());
            pst.setString(5,mod.getSituacao());
            pst.setInt(6,mod.getCodigoNota());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Nota alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar nota \n" + ex);
        }
        
        conex.Desconecta();
     }
}
