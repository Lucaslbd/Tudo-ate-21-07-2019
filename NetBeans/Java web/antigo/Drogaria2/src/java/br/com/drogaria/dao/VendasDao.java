package br.com.drogaria.dao;


import br.com.drogaria.domain.Vendas;
import br.com.drogaria.filter.VendaFilter;
import br.com.drogaria.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class VendasDao {
    
    
    public int Salvar(Vendas venda){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        int codigo;
        try{
           transacao = sessao.beginTransaction();
         codigo = (int) sessao.save(venda);
           transacao.commit();  
         }catch(RuntimeException ex){
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
        return codigo;
    }    
    
    public List<Vendas> listar(){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         List<Vendas> venda = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Vendas.listar");
           venda = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return venda;
    }
    
    public Vendas buscarPorCodigo(int codigo){
         Session sessao = HibernateUtil.getSessionFactory().openSession();        
         Vendas venda = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Vendas.buscarPorCodigo");
           consulta.setInteger("codigo", codigo);
           venda = (Vendas) consulta.uniqueResult();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return venda;
    }
     public void Editar(Vendas venda){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.update(venda);
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
      public void Excluir(Vendas venda){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.delete(venda);
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
        public List<Vendas> buscarData(VendaFilter filter){
            List<Vendas> vendas = null;
            StringBuilder sql = new StringBuilder();
            sql.append("select vendas FROM Vendas vendas ");
            if(filter.getDataInicial()!=null && filter.getDataFinal()!=null){
            sql.append("where vendas.horario between :dataInicial and :dataFinal ");
            }
            sql.append("order by vendas.horario ");
            Session sessao = HibernateUtil.getSessionFactory().openSession();            
         try{
           Query consulta = sessao.createQuery(sql.toString());
           if(filter.getDataInicial()!=null && filter.getDataFinal()!=null){
           consulta.setDate("dataInicial", filter.getDataInicial());
           consulta.setDate("dataFinal", filter.getDataFinal());  
           }
           vendas = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return vendas;
    }    
    
      //Excluir
     /*public static void main(String[]args){
      VendasDao dao = new VendasDao();
      Vendas venda = dao.buscarPorCodigo(1);
        try {           
            dao.Excluir(venda);            
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
    }*/
    //Buscar por codigo
    /* public static void main(String[] args) {
        VendasDao control = new VendasDao();        
        
           Vendas vendas = control.buscarPorCodigo(1);
           System.out.println(vendas);
            } */   
    
    //Listar
    /*public static void main(String[] args) {
        VendasDao control = new VendasDao();
        
        try{
           List<Vendas> vendas =  control.listar();
            for (Vendas f : vendas) {
                System.out.println(f);
            }
        }catch(Exception ex){
            System.out.println("Erro" + ex.getMessage());
        } 
    }*/
    //Salvar
   /* public static void main(String[]args){
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        FuncionarioDAO fDao = new FuncionarioDAO();
        Funcionarios funcionario = fDao.buscarPorCodigo(1);
        Vendas vendas = new Vendas();
        vendas.setHorario(d);
        vendas.setValor(new BigDecimal(2.99));
        vendas.setFuncionarios(funcionario);
       
        VendasDao dao = new VendasDao();
        try {
            dao.Salvar(vendas);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }*/
}
