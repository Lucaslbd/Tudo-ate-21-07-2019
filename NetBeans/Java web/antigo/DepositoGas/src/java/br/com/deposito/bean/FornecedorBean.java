package br.com.deposito.bean;

import br.com.deposito.dao.FornecedorDao;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "MBFornecedor")
@ViewScoped
public class FornecedorBean {

    private Fornecedor fornecedor;
    private ArrayList<Fornecedor> listaFornecedor;
    private ArrayList<Fornecedor> listaFornecedorFiltrado;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private String senha;
    private String conteudo;
    private String assunto;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(ArrayList<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public ArrayList<Fornecedor> getListaFornecedorFiltrado() {
        return listaFornecedorFiltrado;
    }

    public void setListaFornecedorFiltrado(ArrayList<Fornecedor> listaFornecedorFiltrado) {
        this.listaFornecedorFiltrado = listaFornecedorFiltrado;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    //Aqui começa a implementação----------------------------------------------------------------------------
    public void listar() {
        FornecedorDao dao = new FornecedorDao();
        try {
            listaFornecedor = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fornecedores " + ex);
        }
    }

    public void atualizarObjeto() {
        fornecedor = new Fornecedor();
    }

    public void salvar() {
        FornecedorDao dao = new FornecedorDao();
        try {
            fornecedor.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(fornecedor);
            JSFUtil.mensagemSucesso("Fornecedor registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar fornecedor" + ex);
        }
    }

    public void alterar() {
        FornecedorDao dao = new FornecedorDao();
        try {
            dao.Alterar(fornecedor);
            JSFUtil.mensagemSucesso("Fornecedor alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar fornecedor " + ex);
        }
    }

    public void excluir() {
        FornecedorDao dao = new FornecedorDao();
        try {
            dao.excluir(fornecedor);
            JSFUtil.mensagemSucesso("fornecedor removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir fornecedor " + ex);
        }
    }

    public void enviarEmail() {
        try {
            SimpleEmail emai = new SimpleEmail();
            emai.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            emai.addTo(fornecedor.getEmail()); //destinatário
            emai.setFrom(MBAutenticacao.getUsuario().getDeposito().getEmail()); // remetente
            emai.setSubject(assunto);  // assunto do e-mail
            emai.setMsg(conteudo); //conteudo do e-mail
            emai.setAuthentication(MBAutenticacao.getUsuario().getDeposito().getEmail(), senha);
            emai.setSmtpPort(587);  //465 ou 587                   
            emai.setTLS(true);
            emai.send();
            JSFUtil.mensagemSucesso("Email enviado com sucesso");
            limparEmail();
        } catch (EmailException ex) {
            JSFUtil.mensagemErro("Erro ao enviar email " + ex);
        }
    }
    
     public void limparEmail() {
        assunto = "";
        conteudo = "";
        senha = "";
    }
}
