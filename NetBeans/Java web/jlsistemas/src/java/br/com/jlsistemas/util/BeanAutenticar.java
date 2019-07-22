package br.com.jlsistemas.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class BeanAutenticar {

    private String email;
    private String senha;
    private boolean travar = false;

    public boolean isTravar() {
        return travar;
    }

    public void setTravar(boolean travar) {
        this.travar = travar;
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

    //aqui começa a implementação------------------------------------------------------------------------------
    public String entrar() {
        if (email.equals("jlsistemasgestao@gmail.com") && senha.equals("14811409lbd")) {
            JSFUtil.mensagemSucesso("Olá Lucas seu acesso foi autenticado com sucesso");
            travar = true;
            return "Principal.xhtml?faces-redirect=true";
        } else {
            JSFUtil.mensagemAviso("Acesso negado");
            return null;
        }
    }

    public String sair() {
        email = "";
        senha = "";
        travar = false;
        return "index.xhtml?faces-redirect=true";
    }
}
