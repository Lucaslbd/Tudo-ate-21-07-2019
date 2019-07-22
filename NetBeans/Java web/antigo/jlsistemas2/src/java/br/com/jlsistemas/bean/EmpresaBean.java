package br.com.jlsistemas.bean;

import br.com.jlsistemas.autenticacao.BeanAutenticar;
import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.dao.SistemaDao;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBEmpresa")
@ViewScoped
public class EmpresaBean {

    private Empresa empresa;
    private ArrayList<Empresa> lista;
    private ArrayList<Empresa> listaFiltrada;
    private ArrayList<Sistema> listaSistemas;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
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

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Sistema> getListaSistemas() {
        return listaSistemas;
    }

    public void setListaSistemas(ArrayList<Sistema> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Empresa> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Empresa> lista) {
        this.lista = lista;
    }

    public ArrayList<Empresa> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Empresa> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    //Aqui começa a implementação-----------------------------------------------------------------------
    public void listar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar empresas ");
        }
    }

    public void salvar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            empresa.setDataCadastro(new Date());
            dao.Salvar(empresa);
            JSFUtil.mensagemSucesso("Empresa registrada com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Empresa.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao registrar empresa");
        }
    }

    public void alterar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Alterar(empresa);
            JSFUtil.mensagemSucesso("Empresa alterada com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Empresa.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao alterar empresa " + ex);
        }
    }

    public void excluir() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.excluir(empresa);
            JSFUtil.mensagemSucesso("Empresa removida com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Empresa.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover empresa ");
        }
    }

    //carrega o cadastro para alterar ou excluir
    public void carregarCadastro() {
        try {
            if (acao.equals("novo")) {
                empresa = new Empresa();
            } else {
                EmpresaDao dao = new EmpresaDao();
                empresa = dao.listarPorCodigo(codigo);               
            }
            SistemaDao dao = new SistemaDao();
            listaSistemas = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar sistema por codigo " + ex);
        }
    }

    /*public void preencheEmpresa() {
        empresa = MBAutenticacao.getEmpresa();
    }*/
}
