package br.com.vendas.bean;

import br.com.vendas.dao.FabricanteDao;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

    private ArrayList<Fabricante> ListaFabricantes;
    private ArrayList<Fabricante> ListaFabricantesFiltrados;
    private Fabricante fabricante;    
    private String Email;
    private String Assunto;
    @ManagedProperty(value= "#{MBAutenticacao}")
    private BeanAutenticacao autenticacao;
    private int progresso;

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }   

    public BeanAutenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(BeanAutenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }
    
    
    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String Assunto) {
        this.Assunto = Assunto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }   
    
    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public ArrayList<Fabricante> getListaFabricantesFiltrados() {
        return ListaFabricantesFiltrados;
    }

    public void setListaFabricantesFiltrados(ArrayList<Fabricante> ListaFabricantesFiltrados) {
        this.ListaFabricantesFiltrados = ListaFabricantesFiltrados;
    }

    public ArrayList<Fabricante> getListaFabricantes() {
        return ListaFabricantes;
    }

    public void setListaFabricantes(ArrayList<Fabricante> ListaFabricantes) {
        this.ListaFabricantes = ListaFabricantes;
    }

    public void listar() {
        FabricanteDao dao = new FabricanteDao();
        try {
            ListaFabricantes = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fabricantes " + ex);
        }
    }

    public void atualizarObjeto() {
        fabricante = new Fabricante();
    }

    public void salvar() {
        FabricanteDao dao = new FabricanteDao();
        try {
            dao.Salvar(fabricante);
            JSFUtil.mensagemSucesso("Fabricante salvo com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fabricantes " + ex);
        }
    }
    public void alterar() {
        FabricanteDao dao = new FabricanteDao();
        try {
            dao.Alterar(fabricante);
            JSFUtil.mensagemSucesso("Fabricante alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar fabricantes " + ex);
        }
    }
    
     public void excluir() {
        FabricanteDao dao = new FabricanteDao();
        try {
            dao.excluir(fabricante);
            JSFUtil.mensagemSucesso("Fabricante removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("O fabricante não pode ser removido pois existem produtos a ele vinculado ");
        }
    }
     
     public void enviarEmail(){         
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
            email.setSmtpPort(587);  //465 ou 587          
            email.setFrom("jlsistemasgestao@gmail.com",autenticacao.getFuncionarioLogado().getNome()); // remetente 
            email.addTo(fabricante.getEmail()); //destinatário            
            email.setSubject(Assunto);  // assunto do e-mail          
            email.setMsg(Email);       //conteudo do e-mail 
            email.setTLS(true);  
          //email.setSSL(true);
            email.setAuthentication("jlsistemasgestao@gmail.com","14811409lbd");            
            email.send();            
            JSFUtil.mensagemSucesso("Mensagem enviada com sucesso");
        } catch (EmailException ex) {
            JSFUtil.mensagemErro("Erro ao enviar email " + ex);           
        }
        Assunto = "";
        Email= "";
     }     
     /*public static void main(String[]args){
         FabricanteBean bean = new FabricanteBean();
         bean.enviarEmail();
     }*/
}
