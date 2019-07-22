package br.com.jlsistemas.util;

import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class BeanAutenticar {

    private Empresa empresa = null;
    private String email;
    private String senha;
    private String EmailRecuperar;
    private ArrayList<Sistema> listaSistema;

    public ArrayList<Sistema> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(ArrayList<Sistema> listaSistema) {
        this.listaSistema = listaSistema;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmailRecuperar() {
        return EmailRecuperar;
    }

    public void setEmailRecuperar(String EmailRecuperar) {
        this.EmailRecuperar = EmailRecuperar;
    }

    public String entrar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            empresa = dao.autenticar(email, senha);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao autenticar " + ex);
        }
        if (empresa == null) {
            JSFUtil.mensagemErro("Email e/ou senha invalidos");
            return null;
        } else {
            if (empresa.getNome().equals("JL sistemas")) {
                JSFUtil.mensagemSucesso("Olá " + empresa.getNome() + " seu acesso foi autenticado com sucesso");
                return "PrincipalMaster.xhtml?faces-redirect=true";
            } else {
                listaSistema = new ArrayList<>();
                listaSistema.add(empresa.getSistema());
                JSFUtil.mensagemSucesso("Olá " + empresa.getNome() + " seu acesso foi autenticado com sucesso");
                return "PrincipalEmpresa.xhtml?faces-redirect=true";
            }
        }
    }

    public void renovarEmpresa() {
        EmpresaDao dao = new EmpresaDao();
        empresa = dao.listarPorCodigo(empresa.getCodigo());
    }

    public String sair() {
        empresa = null;
        email = "";
        senha = "";
        return "index.xhtml?faces-redirect=true";
    }

    public void recuperarSenha() {
        EmpresaDao dao = new EmpresaDao();
        try {
            Empresa user = dao.listarPorEmail(EmailRecuperar);
            if (user == null) {
                JSFUtil.mensagemErro("Este email não pertence a nenhuma empresa cadastrada");
            } else {
                SimpleEmail emai = new SimpleEmail();
                emai.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
                emai.addTo(user.getEmail()); //destinatário
                emai.setFrom("jlsistemasgestao@gmail.com"); // remetente
                emai.setSubject("Recuperação de senha");  // assunto do e-mail
                emai.setMsg("Usuário: " + user.getNome() + "\r\nEmail: " + user.getEmail() + "\r\nSenha: " + user.getSenha()); //conteudo do e-mail
                emai.setAuthentication("jlsistemasgestao@gmail.com", "14811409lbd");
                emai.setSmtpPort(587);  //465 ou 587                   
                emai.setTLS(true);
                emai.send();
                JSFUtil.mensagemSucesso("Foi enviado um email de recuperação de senha para o email da empresa");
            }
        } catch (EmailException ex) {
            JSFUtil.mensagemErro("" + ex);
        }
        EmailRecuperar = "";
    }

    public void limparEmail() {
        EmailRecuperar = "";
    }
}
