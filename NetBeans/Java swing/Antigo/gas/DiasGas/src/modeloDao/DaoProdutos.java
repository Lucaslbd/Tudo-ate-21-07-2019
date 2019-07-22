package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansProdutos;
import modeloConection.ConexaoBD;


public class DaoProdutos {
     ConexaoBD conex = new ConexaoBD();
     BeansProdutos mod = new BeansProdutos();
     
     
     public void Salvar(BeansProdutos mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into produtos(nome_produto,valor_produtoc,cheio,vazio,valor_casco,valor_tele,preco_custo, custo_casco) values (?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNomeProduto());
            pst.setDouble(2,mod.getPrecoProduto());
            pst.setInt(3,mod.getCheo());
            pst.setInt(4,mod.getVazio());
            pst.setString(5,mod.getValorCasco());
            pst.setDouble(6,mod.getValorTele());
            pst.setDouble(7,mod.getPrecocusto());
            pst.setDouble(8, mod.getCustoCasco());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n" + ex);
        }
         conex.Desconecta();
    }
     public BeansProdutos PesquisarProduto (BeansProdutos mod){
        conex.Conexao();
        conex.executaSql("select *from produtos where nome_produto like'%" + mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodProduto(conex.rs.getInt("cod_produto"));
            mod.setNomeProduto(conex.rs.getString("nome_produto"));
            mod.setPrecoProduto(conex.rs.getDouble("valor_produtoc"));
            mod.setCheo(conex.rs.getInt("cheio"));
            mod.setVazio(conex.rs.getInt("vazio"));
            mod.setValorCasco(("valor_casco"));
            mod.setValorTele(conex.rs.getDouble("valor_tele"));
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Produto não encontrado");
        }
        
        conex.Desconecta();
        return mod;
        
    }
     public void Excluir(BeansProdutos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from produtos where cod_produto=?");
            pst.setInt(1, mod.getCodProduto());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Produto excluido com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
     public void Editar(BeansProdutos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produtos set nome_produto=?,valor_produtoc=?,cheio=?,vazio=?, valor_casco=?, valor_tele=?, preco_custo=?, custo_casco=? where cod_Produto=?");
              pst.setString(1, mod.getNomeProduto());
              pst.setDouble(2,mod.getPrecoProduto());
              pst.setInt(3,mod.getCheo());
              pst.setInt(4,mod.getVazio());
              pst.setString(5,mod.getValorCasco());
               pst.setDouble(6,mod.getValorTele());
               pst.setDouble(7,mod.getPrecocusto());
               pst.setDouble(8,mod.getCustoCasco());
              pst.setInt(9,mod.getCodProduto());
             
              pst.execute();
              JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
      public void EditarQ(BeansProdutos mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produtos set cheio=?,vazio=? where cod_Produto=?");
              pst.setInt(1,mod.getCheo());
              pst.setInt(2,mod.getVazio());
              pst.setInt(3,mod.getCodProduto());
              pst.execute();
              
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao alterar estoque");
        }
        
        conex.Desconecta();
     }
     
     
}
