package br.com.deposito.dao;

import br.com.deposito.domain.Usuario;
import br.com.deposito.util.DaoGenerico;
import br.com.deposito.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDao extends DaoGenerico<Usuario> {

    public Usuario Autenticar(String email, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        try {
            Query consulta = sessao.getNamedQuery("Usuario.autenticar");
            consulta.setString("email", email);
            consulta.setString("senha", senha);
            usuario = (Usuario) consulta.uniqueResult();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return usuario;
    }
}
