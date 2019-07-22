package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.LembretesDao;
import br.com.agenciaviagens.domain.Lembretes;
import br.com.agenciaviagens.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBLembretes")
@ViewScoped
public class LembretesBeans {

    private int codigo;
    private int acao;
    private Lembretes lembrete;
    private ArrayList<Lembretes> lista;
    private ArrayList<Lembretes> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public Lembretes getLembtete() {
        return lembrete;
    }

    public void setLembtete(Lembretes lembtete) {
        this.lembrete = lembtete;
    }

    public ArrayList<Lembretes> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Lembretes> lista) {
        this.lista = lista;
    }

    public ArrayList<Lembretes> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Lembretes> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    /*----------------------------------Codigo--------------------------------------------------------------------*/
    
    public void salvar() {
        LembretesDao dao = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(lembrete);
            JSFUtil.mensagemSucesso("Lembrete registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("lembretes.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar lembrete" + ex);
        }
    }

    public void alterar() {
        LembretesDao dao = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(lembrete);
            JSFUtil.mensagemSucesso("Lembrete alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("lembretes.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar lembrete" + ex);
        }
    }

    public void excluir(int c) {
        LembretesDao dao = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("lembrete excluido com sucesso");            
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir lembrete" + ex);
        }
    }

    public void listar() {
        LembretesDao dao = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar();           
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar lembretes" + ex);
        }
    }

    public void carregarCadastro() {
        LembretesDao dao = new LembretesDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                lembrete = new Lembretes();
            } else {
                lembrete = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar lembrete por codigo " + ex);
        }
    }    
}
