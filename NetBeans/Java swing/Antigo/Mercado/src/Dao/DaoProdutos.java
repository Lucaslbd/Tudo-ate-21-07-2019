package Dao;

import Beans.BeansProduto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloConection.ConexaoBD;


public class DaoProdutos {
    ConexaoBD conex = new ConexaoBD();
    BeansProduto mod = new BeansProduto();
    
    public void Salvar(BeansProduto mod){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into produtos(produto_codigo,nome_produto,fornecedor_produto,valor_produto,estoque_produto,categoria) values (?,?,?,?,?,?)");
            pst.setString(1,mod.getCodProduto());
            pst.setString(2,mod.getNomeProduto());
            pst.setString(3,mod.getFornecedorProduto());
            pst.setDouble(4,mod.getValorProduto());
            pst.setInt(5,mod.getEstoqueProduto());
            pst.setString(6,mod.getCategoriaProduto());
           pst.execute();
           JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso");
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"O codigo do produto ja existe");
        }
         conex.Desconecta();
    }
    public void Editar(BeansProduto mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produtos set nome_produto=?,fornecedor_produto=?,valor_produto=?,estoque_produto=?,categoria=? where produto_codigo=?");
            pst.setString(1,mod.getNomeProduto());
            pst.setString(2,mod.getFornecedorProduto());
            pst.setDouble(3,mod.getValorProduto());
            pst.setInt(4,mod.getEstoqueProduto());
            pst.setString(5,mod.getCategoriaProduto());
            pst.setString(6,mod.getCodProduto());
              pst.execute();
              JOptionPane.showMessageDialog(null,"Produto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
    public void Excluir(BeansProduto mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from produtos where produto_codigo=?");
            pst.setString(1, mod.getCodProduto());
            pst.execute();
             JOptionPane.showMessageDialog(null,"produto excluido com sucesso\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n" + ex);
        }
        
        conex.Desconecta();
    }
    
    
}
