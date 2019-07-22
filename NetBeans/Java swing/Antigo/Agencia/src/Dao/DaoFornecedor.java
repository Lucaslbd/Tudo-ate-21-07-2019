package Dao;


import Beans.BeansFornecedores;
import Beans.BeansVendasFornecedores;
import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoFornecedor {
    ConexaoBD conex = new ConexaoBD();
    BeansFornecedores fornecedor = new BeansFornecedores();
    BeansVendasFornecedores vendasFor = new BeansVendasFornecedores();
    
    public void Salvar(BeansFornecedores fornecedor){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into fornecedores(nome,cnpj,fone,cidade,email,responsavel,banco,agencia,conta,obs) values (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,fornecedor.getNome());
            pst.setString(2,fornecedor.getCpfcnpj());
            pst.setString(3,fornecedor.getFone());
            pst.setString(4,fornecedor.getCidade());
            pst.setString(5,fornecedor.getEmail());
            pst.setString(6,fornecedor.getResponsavel());
            pst.setString(7,fornecedor.getBanco());
            pst.setString(8,fornecedor.getAgencia());
            pst.setString(9,fornecedor.getConta());
            pst.setString(10,fornecedor.getObs());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Fornecedor adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir clietes\n" + ex);
        }
         conex.Desconecta();        
    }
    public void Editar(BeansFornecedores fornecedor){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("update fornecedores set nome=?,cnpj=?,fone=?,cidade=?,email=?,responsavel=?,banco=?,agencia=?,conta=?,obs=? where codigo=?");
            pst.setString(1,fornecedor.getNome());
            pst.setString(2,fornecedor.getCpfcnpj());
            pst.setString(3,fornecedor.getFone());
            pst.setString(4,fornecedor.getCidade());
            pst.setString(5,fornecedor.getEmail());
            pst.setString(6,fornecedor.getResponsavel());
            pst.setString(7,fornecedor.getBanco());
            pst.setString(8,fornecedor.getAgencia());
            pst.setString(9,fornecedor.getConta());
            pst.setString(10,fornecedor.getObs());
            pst.setInt(11,fornecedor.getCodigo());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração clietes\n" + ex);
        }
         conex.Desconecta();        
    }
     public void Excluir(BeansFornecedores fornecedor){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from fornecedores where codigo=?");
            pst.setInt(1, fornecedor.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Fornecedor excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"O fornecedor não pode ser excluido pois ele está vinculada a alguma comissão");
        }
        
        conex.Desconecta();
    }
      public void SalvarVendas(BeansVendasFornecedores vendasFor){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into vendas_fornecedores(cliente,fornecedor,valor_total,valor_comissao,servico,data_venda,data_comissao,situacao,destino) values (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,vendasFor.getCliente());
            pst.setString(2,vendasFor.getFornecedor());
            pst.setDouble(3,vendasFor.getValorTotal());
            pst.setDouble(4,vendasFor.getValorComissao());
            pst.setString(5,vendasFor.getServico());
            pst.setString(6,vendasFor.getDataVenda());
            pst.setString(7,vendasFor.getDataComissao());
            pst.setString(8,vendasFor.getSituacao());    
            pst.setString(9,vendasFor.getDestino());    
            pst.execute();
            JOptionPane.showMessageDialog(null,"Venda realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir clietes\n" + ex);
        }
         conex.Desconecta();        
    }
      public void EditarVenda(BeansVendasFornecedores vendasFor){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("update vendas_fornecedores set valor_total=?,valor_comissao=? where codigo_venda=?");
            pst.setDouble(1,vendasFor.getValorTotal());
            pst.setDouble(2,vendasFor.getValorComissao());             
            pst.setInt(3,vendasFor.getCodigoVenda());
            pst.execute();           
            JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração clietes\n" + ex);
        }
         conex.Desconecta();        
    }
      public void ExcluirVendas(BeansVendasFornecedores vendasFor){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from vendas_fornecedores where codigo_venda=?");
            pst.setInt(1, vendasFor.getCodigoVenda());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Venda excluida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"");
        }
        
        conex.Desconecta();
    }
}
