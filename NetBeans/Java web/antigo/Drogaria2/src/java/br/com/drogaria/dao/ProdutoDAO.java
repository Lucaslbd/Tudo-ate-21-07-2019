
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produtos;
import br.com.drogaria.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProdutoDAO {
 
    public void Salvar(Produtos produto){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.save(produto);
           transacao.commit();  
         }catch(RuntimeException ex){
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }    
     public List<Produtos> listar(){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         List<Produtos> produtos = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Produtos.listar");
           produtos = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return produtos;
    }
     
     public Produtos buscarPorCodigo(int codigo){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         Produtos produtos = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Produtos.buscarPorCodigo");
           consulta.setInteger("codigo", codigo);
           produtos = (Produtos) consulta.uniqueResult();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return produtos;
    }
     
     public void Excluir(Produtos produto){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.delete(produto);
           transacao.commit();  
         }catch(RuntimeException ex){
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    } 
     
     public void Editar(Produtos produto){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.update(produto);
           transacao.commit();  
         }catch(RuntimeException ex){
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }     
     
        
        //Alterar
    /* public static void main(String[]args){
        ProdutoDAO dao = new ProdutoDAO();
        Produtos produto = dao.buscarPorCodigo(2);        
        FabricanteDAO fDao = new FabricanteDAO();
        Fabricante fabricante = fDao.buscarPorCodigo(3);  
        produto.setDescricao("Descriçao3");
        produto.setPreco(new BigDecimal(4.99));
        produto.setQuantidade(10);
        produto.setFabricante(fabricante);       
        try {
            dao.Editar(produto);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
     }*/
     //Excluir
    /* public static void main(String[]args){
      ProdutoDAO dao = new ProdutoDAO();
      Produtos produto = dao.buscarPorCodigo(1);
        try {           
            dao.Excluir(produto);            
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
     }*/
     //Buscar por codigo
   /*  public static void main(String[] args) {
        ProdutoDAO control = new ProdutoDAO();        
        
           Produtos produtos = control.buscarPorCodigo(1);
           System.out.println(produtos);
            }   */     
     
    //Listar
    /*public static void main(String[] args) {
        ProdutoDAO control = new ProdutoDAO();
        
        try{
           List<Produtos> produtos =  control.listar();
            for (Produtos f : produtos) {
                System.out.println(f);
            }
        }catch(Exception ex){
            System.out.println("Erro" + ex.getMessage());
        }    
    }*/
    //Salvar
   /* public static void main(String[]args){
        FabricanteDAO fDao = new FabricanteDAO();
        Fabricante fabricante = fDao.buscarPorCodigo(3);
        Produtos produto = new Produtos();
        produto.setDescricao("Descriçao2");
        produto.setPreco(new BigDecimal(2.99));
        produto.setQuantidade(10);
        produto.setFabricante(fabricante);
        ProdutoDAO dao = new ProdutoDAO();
        try {
            dao.Salvar(produto);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }*/
}
