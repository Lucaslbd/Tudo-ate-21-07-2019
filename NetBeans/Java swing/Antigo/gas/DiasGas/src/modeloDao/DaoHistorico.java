package modeloDao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansHistorico;
import modeloConection.ConexaoBD;


public class DaoHistorico {
    BeansHistorico hist = new BeansHistorico();
    ConexaoBD conex = new ConexaoBD();
    
    public void Salvar(BeansHistorico hist){
        conex.Conexao();
     
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into historico(nome,data_compra,previsao,rua,numero,telefone,bairro,tempo) values (?,?,?,?,?,?,?,?)");
            pst.setString(1,hist.getNome());
            pst.setString(2,hist.getDataCompra());
            pst.setString(3,hist.getPrevisao());
            pst.setString(4, hist.getRua());
            pst.setString(5, hist.getNumero());
            pst.setString(6, hist.getTelefone());
            pst.setString(7,hist.getBairro());
            pst.setInt(8, hist.getTempo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Historico atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir usuário\n" + ex);
        }
        conex.Desconecta();
    }
}
