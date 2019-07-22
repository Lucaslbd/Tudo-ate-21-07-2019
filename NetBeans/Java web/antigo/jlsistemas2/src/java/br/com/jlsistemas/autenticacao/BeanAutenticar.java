package br.com.jlsistemas.autenticacao;

import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    //aqui começa a implementação------------------------------------------------------------------------------
    
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
                return "Principal.xhtml?faces-redirect=true";
            } else {                 
                listaSistema = new ArrayList<>();
                listaSistema.add(empresa.getSistema());
                JSFUtil.mensagemSucesso("Olá " + empresa.getNome() + " seu acesso foi autenticado com sucesso");
                return "PrincipalCliente.xhtml?faces-redirect=true";
            }
        }      
    }    

    public String sair() {
        empresa = null;
        email = "";
        senha = "";
        return "index.xhtml?faces-redirect=true";
    }  
}
