package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansTransferencia;
import modeloConection.ConexaoBD;


public class DaoTransferencia {
     ConexaoBD conex = new ConexaoBD();
     BeansTransferencia mod = new BeansTransferencia();
     
     public void Salvar(BeansTransferencia mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into transferencia(produto,destinatario,quantidade,valor,casco,data) values (?,?,?,?,?,?)");
            pst.setString(1,mod.getProduto());
            pst.setString(2,mod.getDestinatario());
            pst.setInt(3,mod.getQuantidade());
            pst.setDouble(4,mod.getValor());
            pst.setString(5,mod.getCasco());
            pst.setString(6,mod.getData());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
        
    }
}
