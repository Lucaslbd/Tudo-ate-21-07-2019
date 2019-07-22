package br.com.deposito.util;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

public class DaoGenerico<T> {

    public int salvar(T entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        int cd = 0;
        try {
            sessao.beginTransaction();
            cd = (int) sessao.save(entidade);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return cd;
    }

    public void alterar(T entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.update(entidade);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }

    public void excluir(T entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(entidade);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }

    public List<T> listar(String name, String campo, String pesquisa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            consulta.setString(campo, "%" + pesquisa.toLowerCase() + "%");
            lista = consulta.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }

    public List<T> listarComWhere(String name, String campo, String pesquisa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            consulta.setString(campo, pesquisa);
            lista = consulta.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }

    public List<T> listarPorCodigo(String name, String campo, int codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            consulta.setInteger(campo, codigo);
            lista = consulta.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }
    
    public T buscarPorCodigo(String name, String campo, int codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        T lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            consulta.setInteger(campo, codigo);
            lista = (T) consulta.uniqueResult();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }
    
    public T buscarCampo(String name, String campo, String c) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        T lista = null;
        try {
            Query consulta = sessao.getNamedQuery(name);
            consulta.setString(campo, c);
            lista = (T) consulta.uniqueResult();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }
}
