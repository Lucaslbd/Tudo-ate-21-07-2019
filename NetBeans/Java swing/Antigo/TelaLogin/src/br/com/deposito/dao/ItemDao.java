package br.com.deposito.dao;

import br.com.deposito.domain.Item;
import br.com.deposito.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;


public class ItemDao {
    
     public void salvarSemMensagem(Item item) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();       
        try {
            sessao.beginTransaction();
            sessao.save(item);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }        
    }
}
