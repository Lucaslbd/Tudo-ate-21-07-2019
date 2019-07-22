
package Dao;
   
import Beans.BeansVenda;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloConection.ConexaoBD;


public class DaoVenda {
    ConexaoBD conex = new ConexaoBD();
    BeansVenda mod = new BeansVenda();
    
     public void SalvarVenda(BeansVenda mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into caixa1(cod_produto,nome_produto,quantidade_venda,valor_venda,fornecedor_produto,categoria_produto) values (?,?,?,?,?,?)");
            pst.setString(1,mod.getCodProduto());
            pst.setString(2,mod.getNomeProduto());
            pst.setInt(3,mod.getQtdVenda());
            pst.setDouble(4,mod.getValorVenda());
            pst.setString(5,mod.getFornecedor());
            pst.setString(6,mod.getCategoria());
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
        
    }
      public void Excluir(BeansVenda mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from caixa1 where cod_venda=?");
            pst.setInt(1, mod.getCodVenda());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
      public void ExcluirTudo(BeansVenda mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("truncate table caixa1");
            pst.execute();
             JOptionPane.showMessageDialog(null,"Excluido com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
       public void Cancelar(BeansVenda mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("truncate table caixa1");
            pst.execute();
             JOptionPane.showMessageDialog(null,"Venda cancelada com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
      public void TransferirDados(BeansVenda mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO vendas (cod_produto, nome_produto, quantidade_venda, valor_venda, fornecedor_produto,categoria_produto) SELECT cod_produto, nome_produto, quantidade_venda, valor_venda, fornecedor_produto,categoria_produto FROM caixa1");
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Transferidos com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
      public BeansVenda PesquisarNome (BeansVenda mod){
       conex.Conexao();
        conex.executaSql("select *from caixa1 where cod_venda like'%" + mod.getPesquisarcod()+"%'");
        try {
            conex.rs.first();
            mod.setCodVenda(conex.rs.getInt("cod_venda"));
            
        } catch (SQLException ex) {
              
        }
        
        conex.Desconecta();
        return mod;
        
    }
      
          
      }
    
    

