package Dao;

import Beans.BeansAgencia;
import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoAgencia {
     ConexaoBD conex = new ConexaoBD();
    
    public void Salvar(BeansAgencia agencia){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agencias(nome,cpfcnpj,fone,cidade,email,responsavel,banco,agencia,conta,obs) values (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,agencia.getNome());
            pst.setString(2,agencia.getCpfcnpj());
            pst.setString(3,agencia.getFone());
            pst.setString(4,agencia.getCidade());
            pst.setString(5,agencia.getEmail());
            pst.setString(6,agencia.getResponsavel());
            pst.setString(7,agencia.getBanco());
            pst.setString(8,agencia.getAgencia());
            pst.setString(9,agencia.getConta());
            pst.setString(10,agencia.getObs());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Agencia de viagens adicionada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir clietes\n" + ex);
        }
         conex.Desconecta();        
    }
    public void Editar(BeansAgencia agencia){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("update agencias set nome=?,cpfcnpj=?,fone=?,cidade=?,email=?,responsavel=?,banco=?,agencia=?,conta=?,obs=? where codigo=?");
            pst.setString(1,agencia.getNome());
            pst.setString(2,agencia.getCpfcnpj());
            pst.setString(3,agencia.getFone());
            pst.setString(4,agencia.getCidade());
            pst.setString(5,agencia.getEmail());
            pst.setString(6,agencia.getResponsavel());
            pst.setString(7,agencia.getBanco());
            pst.setString(8,agencia.getAgencia());
            pst.setString(9,agencia.getConta());
            pst.setString(10,agencia.getObs());
            pst.setInt(11,agencia.getCodigo());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Alteração efetuada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração clietes\n" + ex);
        }
         conex.Desconecta();        
    }
    public void Excluir(BeansAgencia Agencia){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from agencias where codigo=?");
            pst.setInt(1, Agencia.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Agencia excluida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A agencia não pode ser excluida pois ele está vinculada a alguma comissão");
        }
        
        conex.Desconecta();
    }
     public void SalvarComissao(BeansAgencia agencia){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("insert into comissionamento_pagar(nome_agencia,valor,referencia,cod_cliente,situacao_cliente,situacao_pagamento) values (?,?,?,?,?,?)");
            pst.setString(1,agencia.getNome());
            pst.setDouble(2,agencia.getComissionamento());
            pst.setString(3,agencia.getGrupo());  
            pst.setInt(4,agencia.getCliente());
            pst.setString(5,agencia.getSituacaoCliente());
            pst.setString(6,agencia.getSituacaoPagamento());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Comissão adicionada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir comissão\n" + ex);
        }
         conex.Desconecta();        
    }
     public void PagarComissao(BeansAgencia agencia){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("update comissionamento_pagar set situacao_pagamento=? where codigo=?");
            pst.setString(1,agencia.getSituacaoPagamento());                    
            pst.setInt(2,agencia.getCodigo());
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração clietes\n" + ex);
        }
         conex.Desconecta();        
    }
     public void cancelarPax(int codigo){
         conex.Conexao();
         try {
            PreparedStatement pst = conex.con.prepareStatement("update comissionamento_pagar set situacao_cliente='Cancelado' where cod_cliente="+codigo+"");            
            pst.execute();
           //JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração clietes\n" + ex);
        }
         conex.Desconecta();        
    }
      public void ExcluirComissao(BeansAgencia Agencia){
        conex.Conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from comissionamento_pagar where codigo=?");
            pst.setInt(1, Agencia.getCodigo());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Comissão excluida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A comissão não pode ser excluida");
        }
        
        conex.Desconecta();
    }
    
}
