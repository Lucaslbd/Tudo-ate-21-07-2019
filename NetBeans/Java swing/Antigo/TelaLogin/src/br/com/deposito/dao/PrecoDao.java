package br.com.deposito.dao;

import br.com.deposito.domain.Preco;
import br.com.deposito.util.DaoGenerico;
import br.com.deposito.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class PrecoDao extends DaoGenerico<Preco> {
    
    public void salvarSemMensagem(Preco preco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();        
        try {
            sessao.beginTransaction();
            sessao.save(preco);
            sessao.getTransaction().commit();           
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }     
    }   
    
    public void excluirSemMensagem(Preco preco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(preco);
            sessao.getTransaction().commit();            
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }   
}
