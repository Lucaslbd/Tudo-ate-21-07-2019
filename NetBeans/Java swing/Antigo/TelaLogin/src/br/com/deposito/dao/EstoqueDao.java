package br.com.deposito.dao;

import br.com.deposito.domain.Estoque;
import br.com.deposito.util.DaoGenerico;
import br.com.deposito.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class EstoqueDao extends DaoGenerico<Estoque> {   

    public void excluirDiferente(Estoque estoque) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            sessao.delete(estoque);
            sessao.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Estoque removido com sucesso: " , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "O estoque não pode ser removido pois exitem produtos a ele relacionado ", "Aviso", JOptionPane.WARNING_MESSAGE);
        } finally {
            sessao.close();
        }
    }

    public int salvarSemMensagem(Estoque estoque) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        int cd = 0;
        try {
            sessao.beginTransaction();
            cd = (int) sessao.save(estoque);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return cd;
    }
}
