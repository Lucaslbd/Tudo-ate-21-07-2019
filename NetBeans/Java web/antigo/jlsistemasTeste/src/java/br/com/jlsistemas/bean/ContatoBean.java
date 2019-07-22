package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.ContatoDao;
import br.com.jlsistemas.domain.Contato;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBContato")
@ViewScoped
public class ContatoBean {
    
    private Contato contato = new Contato();
    private ArrayList<Contato> lista;
    private ArrayList<Contato> listaFiltrada;
    ContatoDao dao = new ContatoDao();

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

    public void alterar() {        
        try {           
            dao.Alterar(contato);
            JSFUtil.mensagemSucesso("Contato alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar contato " + ex);
        }
    }

    public void excluir() {       
        try {
            dao.excluir(contato);          
            JSFUtil.mensagemSucesso("Contato removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir contato " + ex);
        }
    }   
    
}
