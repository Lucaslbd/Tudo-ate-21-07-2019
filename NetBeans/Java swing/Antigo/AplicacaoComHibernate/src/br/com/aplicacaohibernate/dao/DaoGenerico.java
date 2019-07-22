package br.com.aplicacaohibernate.dao;

import br.com.aplicacaocomhibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DaoGenerico<T> {

    public void salvar(T entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.save(entidade);
            sessao.getTransaction().commit();
        } catch (RuntimeException ex) {
            sessao.getTransaction().rollback();
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void alterar(T entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.update(entidade);
            sessao.getTransaction().commit();            
        } catch (RuntimeException ex) {            
            sessao.getTransaction().rollback();
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void excluir(T entidade){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(entidade);
            sessao.getTransaction().commit();            
        } catch (RuntimeException ex) {            
            sessao.getTransaction().rollback();
            throw ex;
        } finally {
            sessao.close();
        }
    }
    
    public List<T> listar(String name) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            lista = consulta.list();
        } catch (RuntimeException ex) {            
            sessao.getTransaction().rollback();
            throw ex;
        } finally {
            sessao.close();
        }
        return lista;
    }
}
