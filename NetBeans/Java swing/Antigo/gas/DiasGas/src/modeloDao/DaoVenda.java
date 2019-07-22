package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansVendas;
import modeloConection.ConexaoBD;


public class DaoVenda {
    BeansVendas venda = new BeansVendas();
    ConexaoBD conex = new ConexaoBD();
    
    public void Salvar(BeansVendas venda){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into vendas(descricao_venda,valor_vendac,quantidade_venda,data_venda,metodo,casco,hora) values (?,?,?,?,?,?,?)");
            pst.setString(1,venda.getDescricaoVenda());
            pst.setDouble(2,venda.getValorVenda());
            pst.setString(3,venda.getQuantidadeVenda());
            pst.setString(4,venda.getDataVenda());
            pst.setString(5,venda.getMetodoVenda());
            pst.setString(6,venda.getCasco());
            pst.setString(7,venda.getHora());
            pst.execute();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n");
        }
         conex.Desconecta();        
    }
    public void SalvarVendaCliente(BeansVendas venda){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into vendacliente(nome_cliente, rua_cliente, bairro_cliente, numero_cliente, fone_cliente,produto,data_venda) values (?,?,?,?,?,?,?)");
            pst.setString(1,venda.getClienteVenda());
            pst.setString(2,venda.getRuaVenda());
            pst.setString(3,venda.getBairroVenda());
            pst.setString(4,venda.getNumero());
            pst.setString(5,venda.getFone());
            pst.setString(6,venda.getDescricaoVenda());
            pst.setString(7,venda.getDataVenda());
            pst.execute();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n"+ex.getMessage());
        }
         conex.Desconecta(); 
    }
    
     public BeansVendas PesquisarNome (BeansVendas mod){
        conex.Conexao();
        conex.executaSql("select *from vendas where cliente_venda like'%" + mod.getPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setCodVenda(conex.rs.getInt("codigo_venda"));
            mod.setClienteVenda(conex.rs.getString("cliente_venda"));
            mod.setDescricaoVenda(conex.rs.getString("descricao_venda"));
            mod.setMetodoVenda(conex.rs.getString("metodo"));
            mod.setValorVenda(conex.rs.getDouble("valor_vendac"));
            mod.setQuantidadeVenda(conex.rs.getString("quantidade_venda"));
            mod.setDataVenda(conex.rs.getString("data_venda"));
            mod.setRuaVenda(conex.rs.getString("rua_venda"));
            mod.setBairroVenda(conex.rs.getString("bairro_venda"));
        } catch (SQLException ex) {
            
        }
        
        conex.Desconecta();
        return mod;
        
    }
     public BeansVendas PesquisarBairro (BeansVendas mod){
        conex.Conexao();
        conex.executaSql("select *from vendas where bairro_venda like'%" + mod.getPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setCodVenda(conex.rs.getInt("codigo_venda"));
            mod.setClienteVenda(conex.rs.getString("cliente_venda"));
            mod.setDescricaoVenda(conex.rs.getString("descricao_venda"));
            mod.setMetodoVenda(conex.rs.getString("metodo"));
            mod.setValorVenda(conex.rs.getDouble("valor_vendac"));
            mod.setQuantidadeVenda(conex.rs.getString("quantidade_venda"));
            mod.setDataVenda(conex.rs.getString("data_venda"));
            mod.setRuaVenda(conex.rs.getString("rua_venda"));
            mod.setBairroVenda(conex.rs.getString("bairro_venda"));
        } catch (SQLException ex) {
           
        }
        
        conex.Desconecta();
        return mod;
        
    }
      public BeansVendas PesquisarRua (BeansVendas mod){
        conex.Conexao();
        conex.executaSql("select *from vendas where rua_venda like'%" + mod.getPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setCodVenda(conex.rs.getInt("codigo_venda"));
            mod.setClienteVenda(conex.rs.getString("cliente_venda"));
            mod.setDescricaoVenda(conex.rs.getString("descricao_venda"));
            mod.setMetodoVenda(conex.rs.getString("metodo"));
            mod.setValorVenda(conex.rs.getDouble("valor_vendac"));
            mod.setQuantidadeVenda(conex.rs.getString("quantidade_venda"));
            mod.setDataVenda(conex.rs.getString("data_venda"));
            mod.setRuaVenda(conex.rs.getString("rua_venda"));
            mod.setBairroVenda(conex.rs.getString("bairro_venda"));
        } catch (SQLException ex) {
             
        }
        
        conex.Desconecta();
        return mod;
        
    }
       public BeansVendas PesquisarData (BeansVendas mod){
        conex.Conexao();
        conex.executaSql("select *from vendas where data_venda like'%" + mod.getPesquisar()+"%'");
        try {
            conex.rs.first();
            mod.setCodVenda(conex.rs.getInt("codigo_venda"));
            mod.setClienteVenda(conex.rs.getString("cliente_venda"));
            mod.setDescricaoVenda(conex.rs.getString("descricao_venda"));
            mod.setMetodoVenda(conex.rs.getString("metodo"));
            mod.setValorVenda(conex.rs.getDouble("valor_vendac"));
            mod.setQuantidadeVenda(conex.rs.getString("quantidade_venda"));
            mod.setDataVenda(conex.rs.getString("data_venda"));
            mod.setRuaVenda(conex.rs.getString("rua_venda"));
            mod.setBairroVenda(conex.rs.getString("bairro_venda"));
        } catch (SQLException ex) {
           
        }
        
        conex.Desconecta();
        return mod;
        
    }
       public void Excluir(BeansVendas venda){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from vendas where codigo_venda=?");
            pst.setInt(1, venda.getCodVenda());
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir dados\n");
        }
        
        conex.Desconecta();
    }
        public void Editar(BeansVendas mod){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update vendas set metodo=?,valor_vendac=?,data_venda=?,hora=?,usuario=? where codigo_venda=?");
            pst.setString(1,mod.getMetodoVenda());
            pst.setDouble(2,mod.getValorVenda());
            pst.setString(3,mod.getDataVenda());
            pst.setString(4,mod.getHora());
            pst.setString(5,mod.getUsuario());
            pst.setInt(6,mod.getCodVenda());
            pst.execute();
              JOptionPane.showMessageDialog(null,"Venda alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\n" + ex);
        }
        
        conex.Desconecta();
     }
        public void ExcluirTudo(BeansVendas mod){
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
        
    
}
