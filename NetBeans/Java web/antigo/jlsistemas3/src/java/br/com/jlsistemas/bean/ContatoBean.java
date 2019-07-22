package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.ContatoDao;
import br.com.jlsistemas.domain.Contato;
import br.com.jlsistemas.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBContato")
@ViewScoped
public class ContatoBean {
    
    private Contato contato = new Contato();
    private ArrayList<Contato> lista;
    private ArrayList<Contato> listaFiltrada;
    ContatoDao dao = new ContatoDao();
    private String acao;
    private int codigo;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public ArrayList<Contato> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Contato> lista) {
        this.lista = lista;
    }

    public ArrayList<Contato> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Contato> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
   
    
 //-----------------------------------------------------------------------------------------
    
 public void listar() {       
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar contatos " + ex);
        }
    }

    public void atualizarObjeto() {
        contato = new Contato();
    }

    public void salvar() {        
        try {            
            dao.Salvar(contato); 
            atualizarObjeto();
            JSFUtil.mensagemSucesso("Seu pedido de contato foi registrado com sucesso, aguarde o retorno de nossos atendentes");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar pedido de contato" + ex);
        }
    }    

    public void excluir() {       
        try {
            dao.excluir(contato);          
            JSFUtil.mensagemSucesso("Contato removido com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Contato.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao excluir contato " + ex);
        }
    }   
    
    public void carregarCadastro() {
        try {            
           contato = dao.buscarPorCodigo(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar comentário por codigo " + ex);
        }
    }
    
}
