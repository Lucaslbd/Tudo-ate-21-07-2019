package br.com.drogaria.dao;

import br.com.drogaria.domain.Funcionarios;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FuncionarioDAO {
    
    public void Salvar(Funcionarios funcionarios){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.save(funcionarios);
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
    
    public List<Funcionarios> listar(){
         Session sessao = HibernateUtil.getSessionFactory().openSession();
        
         List<Funcionarios> funcionarios = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Funcionarios.listar");
           funcionarios = consulta.list();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return funcionarios;
    }
      
    public Funcionarios buscarPorCodigo(int codigo){
         Session sessao = HibernateUtil.getSessionFactory().openSession();
        
         Funcionarios funcionarios = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Funcionarios.buscarPorCodigo");
           consulta.setInteger("codigo", codigo);
           funcionarios = (Funcionarios) consulta.uniqueResult();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return funcionarios;
    }
    
   public void Excluir(Funcionarios funcionarios){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           sessao.delete(funcionarios);
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
   
   public void Editar(Funcionarios funcionarios){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();           
           sessao.update(funcionarios);
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
   
   public Funcionarios autenticar(String cpf, String senha){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
        
         Funcionarios funcionarios = null;
         try{
           org.hibernate.Query consulta =  sessao.getNamedQuery("Funcionarios.autenticar");
           consulta.setString("cpf", cpf);
           consulta.setString("senha",senha);
           funcionarios = (Funcionarios) consulta.uniqueResult();
         }catch(RuntimeException ex){
            throw ex;                 
             }
         finally{
             sessao.close();
         }
         return funcionarios;
    
   }
   
}
