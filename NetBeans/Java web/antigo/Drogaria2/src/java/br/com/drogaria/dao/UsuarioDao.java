package br.com.drogaria.dao;

import br.com.aplicacaocomhibernate.domain.Usuario;
import br.com.aplicacaocomhibernate.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDao {

    public void salvar(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.save(usuario);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public void alterar(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.update(usuario);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public void excluir(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(usuario);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public List<Usuario> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> lista = null;
        try {
            Query consulta = sessao.getNamedQuery("Usuario.listar");
            lista = consulta.list();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
        return lista;
    }
}
