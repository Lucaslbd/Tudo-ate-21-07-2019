package br.com.deposito.bean;

import br.com.deposito.dao.UsuarioDao;
import br.com.deposito.domain.Usuario;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class BeanAutenticar {

    private Usuario usuario;
    private String cpf;
    private String senha;
    private String cpfRecuperar;

    public String getCpfRecuperar() {
        return cpfRecuperar;
    }

    public void setCpfRecuperar(String cpfRecuperar) {
        this.cpfRecuperar = cpfRecuperar;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
        UsuarioDao dao = new UsuarioDao();
        try {
            usuario = dao.autenticar(cpf, senha);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao autenticar " + ex);
        }
        if (usuario == null) {
            JSFUtil.mensagemErro("Cpf e/ou senha invalidos");
            return null;
        } else {
            if (usuario.getDeposito().getSituacao().equals("Irregular")) {
                JSFUtil.mensagemErro("Situação irregular entre em contato com a JL sistemas (051) 9 9582-3546 e regularize sua empresa");
                return null;
            } else {
                JSFUtil.mensagemSucesso("Olá " + usuario.getNome() + " seu acesso foi autenticado com sucesso");
                return "Principal.xhtml?faces-redirect=true";
            }
        }
    }

    public String sair() {
        usuario = null;
        cpf = "";
        senha = "";
        return "index.xhtml?faces-redirect=true";
    }

    public void recuperarSenha() {
        UsuarioDao dao = new UsuarioDao();
        try {
            Usuario user = dao.listarPorCpf(cpfRecuperar);
            SimpleEmail emai = new SimpleEmail();
            emai.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            emai.addTo(user.getDeposito().getEmail()); //destinatário
            emai.setFrom("jlsistemasgestao@gmail.com"); // remetente
            emai.setSubject("Recuperação de senha");  // assunto do e-mail
            emai.setMsg("Usuário:" + user.getNome() + "\r\nSenha:" + user.getSenha()); //conteudo do e-mail
            emai.setAuthentication("jlsistemasgestao@gmail.com", "14811409lbd");
            emai.setSmtpPort(587);  //465 ou 587                   
            emai.setTLS(true);
            emai.send();
            JSFUtil.mensagemSucesso("Foi enviado um email de recuperação de senha para o email do deposito");
            cpfRecuperar = "";
        } catch (SQLException | EmailException ex) {
            JSFUtil.mensagemErro("Cpf invalido");
        }
    }

    public void limparCpf() {
        cpfRecuperar = "";
    }
}
