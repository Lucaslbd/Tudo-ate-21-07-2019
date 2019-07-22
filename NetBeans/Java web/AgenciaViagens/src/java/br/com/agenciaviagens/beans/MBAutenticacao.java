package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.AutenticarDao;
import br.com.agenciaviagens.domain.Empresa;
import br.com.agenciaviagens.util.JSFUtil;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class MBAutenticacao {

    public static Empresa empresa;
    private String email;
    private String senha;

    public Empresa getEmpresa() {
        return empresa;
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

    /*------------------------------------------------------------------------------------*/
    public String entrar() {
        AutenticarDao dao = new AutenticarDao();
        try {
            empresa = dao.autenticar(email, senha);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao autenticar " + ex);
        }
        if (empresa == null) {
            JSFUtil.mensagemErro("E-mail e/ou senha invalidos");
            return null;
        } else {
            if (empresa.getSituacao().equals("Irregular")) {
                JSFUtil.mensagemAviso("Situação irregular entre em contato com a JL sistemas (051) 9 9582-3546 e regularize seu plano");
                empresa = null;
                return null;
            } else if (empresa.getSituacao().equals("Aguardar")) {
                JSFUtil.mensagemAviso("Aguarde a liberação de seu plano");
                empresa = null;
                return null;
            } else if (!empresa.getNomeSistema().equals("Gestour")) {
                JSFUtil.mensagemAviso("Esse sistema não faz parte de seu plano");
                empresa = null;
                return null;
            } else {
                try {
                    dao.online(empresa.getCodigo());
                } catch (SQLException ex) {
                    JSFUtil.mensagemErro("Erro ao ficar online " + ex);
                }
                JSFUtil.mensagemSucesso("Olá " + empresa.getNomeEmpresa() + " seu acesso foi autenticado com sucesso");
                return "principal.xhtml?faces-redirect=true";
            }
        }
    }

    public String sair() {
        AutenticarDao dao = new AutenticarDao();
        try {
            dao.offline(empresa.getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao ficar offline " + ex);
        }
        empresa = null;
        email = "";
        senha = "";
        return "index.xhtml?faces-redirect=true";
    }
}
