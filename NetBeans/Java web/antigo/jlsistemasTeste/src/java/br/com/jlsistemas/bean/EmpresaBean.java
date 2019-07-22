package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.dao.SistemaDao;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.util.BeanAutenticar;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBEmpresa")
@ViewScoped
public class EmpresaBean {

    private Empresa empresa;
    private ArrayList<Empresa> lista;
    private ArrayList<Empresa> listaFiltrada;
    private ArrayList<Sistema> listaSistemas;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

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

    public void listar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            listarSistemas();
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar empresas ");
        }
    }

    public void alterarStatus() {
        EmpresaDao dao = new EmpresaDao();
        try {
            if (empresa.getSituacao().equals("Regular")) {
                empresa.setSituacao("Irregular");
            } else {
                empresa.setSituacao("Regular");
            }
            dao.AlterarStatus(empresa);
            JSFUtil.mensagemSucesso("Status da empresa alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar empresa ");
        }
    }

    public void atualizarObjeto() {
        empresa = new Empresa();
    }

    public void salvar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Salvar(empresa);
            JSFUtil.mensagemSucesso("Empresa registrada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar empresa");
        }
    }

    public void alterar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Alterar(empresa);
            JSFUtil.mensagemSucesso("Empresa alterada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar empresa ");
        }
    }

    public void alterar2() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Alterar2(empresa);
            JSFUtil.mensagemSucesso("Empresa alterada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar empresa ");
        }
        MBAutenticacao.renovarEmpresa();
    }

    public void excluir() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.excluir(empresa);
            JSFUtil.mensagemSucesso("Empresa removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover empresa ");
        }
    }

    public void listarSistemas() {
        SistemaDao dao = new SistemaDao();
        try {
            listaSistemas = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar sistemas ");
        }
    }

    public void preencheEmpresa() {
        empresa = MBAutenticacao.getEmpresa();
    }

}
