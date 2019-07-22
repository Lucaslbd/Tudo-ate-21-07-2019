package br.com.drogaria.dao;

import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produtos;
import br.com.drogaria.domain.Vendas;
import br.com.drogaria.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ItemDao {
    
    public void Salvar(Item item){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.save(item);
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
    
    public List<Item> listar(){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         List<Item> item = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Item.listar");
           item = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return item;
    }
    
    public Item buscarPorCodigo(int codigo){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         Item item = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Item.buscarPorCodigo");
           consulta.setInteger("codigo", codigo);
           item = (Item) consulta.uniqueResult();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return item;
    }
    public List<Item> listarVendas(int codigo){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         List<Item> item = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Item.buscarVenda");
           consulta.setInteger("vendas", codigo);
           item = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return item;
    }
    
     public void Editar(Item item){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.update(item);
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
      public void Excluir(Item item){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.delete(item);
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
      
      //Excluir
   /*  public static void main(String[]args){
      ItemDao dao = new ItemDao();
      Item item = dao.buscarPorCodigo(1);
        try {           
            dao.Excluir(item);            
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
     }*/
    //Alterar
   /* public static void main(String[]args){
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        VendasDao dao = new VendasDao();
        Vendas venda = dao.buscarPorCodigo(1);        
        FuncionarioDAO fDao = new FuncionarioDAO();
        Funcionarios funcionario = fDao.buscarPorCodigo(3);  
        venda.setHorario(d);
        venda.setValor(new BigDecimal(2.99));
        venda.setFuncionarios(funcionario);            
        try {
            dao.Editar(venda);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }/*
    //Buscar por codigo
    /* public static void main(String[] args) {
        ItemDao control = new ItemDao();        
        
           Item item = control.buscarPorCodigo(1);
           System.out.println(item);
            } */  
    
    //Listar
   /* public static void main(String[] args) {
        ItemDao control = new ItemDao();
        
        try{
           List<Item> item =  control.listar();
            for (Item f : item) {
                System.out.println(f);
            }
        }catch(Exception ex){
            System.out.println("Erro" + ex.getMessage());
        } 
    }*/
    //Salvar
   /* public static void main(String[]args){        
        Item item = new Item();
        ItemDao Idao = new ItemDao();
        item.setQuantidade(1);
        item.setValor(new BigDecimal(2.99));
        
        ProdutoDAO Pdao =  new ProdutoDAO();
        Produtos produto = Pdao.buscarPorCodigo(2);
        item.setProdutos(produto);
        
        VendasDao Vdao = new VendasDao();
        Vendas venda = Vdao.buscarPorCodigo(2);
        item.setVendas(venda);        
        
        try {
            Idao.Salvar(item);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }*/
}
