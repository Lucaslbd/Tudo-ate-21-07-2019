package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FabricanteDAO {

    public void Salvar(Fabricante fabricante) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public List<Fabricante> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        // Query consulta = null;
        List<Fabricante> fabricantes = null;
        try {
            org.hibernate.Query consulta = sessao.getNamedQuery("Fabricante.listar");
            fabricantes = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return fabricantes;
    }

    public Fabricante buscarPorCodigo(int codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Fabricante fabricante = null;
        try {
            org.hibernate.Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
            consulta.setInteger("codigo", codigo);
            fabricante = (Fabricante) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return fabricante;
    }

    public void Excluir(Fabricante fabricante) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    /*public void Excluir2(int codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
           transacao = sessao.beginTransaction();
           Fabricante fabricante = buscarPorCodigo(codigo);
           sessao.delete(fabricante);
           transacao.commit();  
         }catch(RuntimeException ex){
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }*/

    public void Editar(Fabricante fabricante) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            //Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
            //fabricanteEditar.setDescricao(fabricante.getDescricao());
            sessao.update(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    //Metodo Editar teste
    /* public static void main(String[]args){
        FabricanteDAO dao = new FabricanteDAO();
        Fabricante f1 = dao.buscarPorCodigo(0);        
        f1.setDescricao("Descriçaox");
        
        try {
            dao.Editar(f1);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }*/
    //Metodo excluir2
    /* public static void main(String[]args){
      FabricanteDAO dao = new FabricanteDAO();            
      dao.Excluir2(2);
            }  */
    //Metodo excluir
    /* public static void main(String[]args){
      FabricanteDAO dao = new FabricanteDAO();
      Fabricante f1 = dao.buscarPorCodigo(1);
        try {           
            dao.Excluir(f1);            
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
      }*/
    //Buscar por codigo
    /*public static void main(String[] args) {
        FabricanteDAO control = new FabricanteDAO();        
        
           Fabricante fabricante = control.buscarPorCodigo(3);
           System.out.println(fabricante);
            }   */
    //Metodo Listar
    /*public static void main(String[] args) {
        FabricanteDAO control = new FabricanteDAO();
        
        try{
           List<Fabricante> fabricantes =  control.listar();
            for (Fabricante f : fabricantes) {
                System.out.println(f);
            }
        }catch(Exception ex){
            System.out.println("Erro" + ex.getMessage());
        }        
    }*/
    //Metodo salvar teste
    /* public static void main(String[]args){
        Fabricante f1 = new Fabricante();
        f1.setDescricao("Descriçao1");
        FabricanteDAO dao = new FabricanteDAO();
        try {
            dao.Salvar(f1);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
    }*/
}
