package br.com.drogaria.dao;

import br.com.aplicacaocomhibernate.domain.Endereco;
import br.com.aplicacaocomhibernate.domain.Usuario;
import br.com.aplicacaocomhibernate.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;


public class EnderecoDao {
    
     public void salvar(Endereco endereco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.save(endereco);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Endereço inserido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar endereço: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public void alterar(Endereco endereco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.update(endereco);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Endereco alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar endereco: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public void excluir(Endereco endereco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(endereco);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Endereço removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover endereço: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
    }

    public List<Usuario> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> lista = null;
        try {
            Query consulta = sessao.getNamedQuery("Endereco.listar");
            lista = consulta.list();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar enderecos: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            sessao.getTransaction().rollback();
        } finally {
            sessao.close();
        }
        return lista;
    }
}
