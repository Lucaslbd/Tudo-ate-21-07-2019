package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modeloBeans.BeansFrenteCaixa;
import modeloConection.ConexaoBD;


public class DaoFrenteCaixa {
    ConexaoBD conex = new ConexaoBD();
    BeansFrenteCaixa mod = new BeansFrenteCaixa();
    
    public void Salvar(BeansFrenteCaixa venda){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into caixa1(descricao_venda,valor_vendac,quantidade_venda,data_venda,metodo,casco,hora,usuario,turno,valor_custo) values (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,venda.getDescricaoVenda());
            pst.setDouble(2,venda.getValorVenda());
            pst.setString(3,venda.getQuantidadeVenda());
            pst.setString(4,venda.getDataVenda());
            pst.setString(5,venda.getMetodoVenda());
            pst.setString(6,venda.getCasco());
            pst.setString(7,venda.getHora());
            pst.setString(8, venda.getUsuario());
            pst.setString(9, venda.getTurno());
            pst.setDouble(10,venda.getCusto());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Pre venda realizada com sucesso");
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n"+ex.getMessage());
        }
         conex.Desconecta();       
    }
    public void Cancelar(BeansFrenteCaixa venda){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("truncate table caixa1 RESTART IDENTITY");
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    public void TransferirDados(BeansFrenteCaixa mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO vendas (descricao_venda, quantidade_venda,data_venda, valor_vendac, metodo, casco, hora,usuario,turno,valor_custo,valor_cobrado) SELECT descricao_venda, quantidade_venda, data_venda, valor_vendac, metodo, casco, hora, usuario, turno, valor_custo, valor_cobrado FROM caixa1");
            pst.execute();
              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Transferir dados dados\n" + ex);
        }
        
        conex.Desconecta();
    }
      public void Excluir(BeansFrenteCaixa venda){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from caixa1 where cod_venda=?");
            pst.setInt(1, venda.getCodVenda());
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n");
        }
        
        conex.Desconecta();
    }
       public void Editar(BeansFrenteCaixa mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update caixa1 set valor_cobrado=?, valor_vendac=? where cod_venda=?");
            pst.setDouble(1, mod.getValor_cobrado());
            pst.setDouble(2,mod.getValorVenda());           
            pst.setInt(3,mod.getCodVenda());
            pst.execute();
              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
       public void Editar2(BeansFrenteCaixa mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update caixa1 set valor_cobrado=? where cod_venda=?");
            pst.setDouble(1, mod.getValor_cobrado());
            pst.setInt(2,mod.getCodVenda());
            pst.execute();
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n Verificar editar2 DaoFre" + ex);
        }
        
        conex.Desconecta();
     }
         public void fechamento(BeansFrenteCaixa mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into fechamento(pagamento,valor,situacao) values (?,?,?)");
            pst.setString(1,mod.getPagamento());
            pst.setDouble(2,mod.getValorTotal());
            pst.setString(3,mod.getTipoPagamento());
            pst.execute();
           // JOptionPane.showMessageDialog(null,"Pre venda realizada com sucesso");
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n"+ex.getMessage());
        }
         conex.Desconecta();       
    }
         public void CancelarFechamento(BeansFrenteCaixa venda){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("truncate table fechamento RESTART IDENTITY");
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
        
         }
       
       
           
       
       
       
     

