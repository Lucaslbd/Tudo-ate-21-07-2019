
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansBaixa;
import modeloConection.ConexaoBD;


public class DaoBaixa {
     ConexaoBD conex = new ConexaoBD();
     BeansBaixa mod = new BeansBaixa();
     
     public void Salvar(BeansBaixa mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into baixas(motivo_baixa, quatidade_baixa, data_baixa, produto_baixa, casco, valor) values (?,?,?,?,?,?)");
            pst.setString(1,mod.getMotivo());
            pst.setInt(2,mod.getQuantidade());
            pst.setString(3,mod.getData());
            pst.setString(4,mod.getProduto());
            pst.setString(5, mod.getCasco());
            pst.setDouble(6, mod.getValor());
           pst.execute();
            JOptionPane.showMessageDialog(null,"Baixa de mercadoria efetuda com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
    }
     public void Excluir(BeansBaixa mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from baixas where id_baixa=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"baixa de mercadoria desfeita com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao desfazer baixa" + ex);
        }
        
        conex.Desconecta();
    }
     public void Editar(BeansBaixa mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update baixas set motivo_baixa=?,data_baixa=? where id_baixa=?");
              pst.setString(1, mod.getMotivo());
              pst.setString(2,mod.getData());
              pst.setInt(3,mod.getCodigo());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Baixa alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar baixa\n" + ex);
        }
        
        conex.Desconecta();
     }
}
