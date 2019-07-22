package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.util.JSFUtil;
import br.com.drograria.domain.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class fabricanteBean {

    private Fabricante fabri;
    private ArrayList<Fabricante> itens;
    private ArrayList<Fabricante> itensFiltrados;

    public ArrayList<Fabricante> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Fabricante> itens) {
        this.itens = itens;
    }

    public ArrayList<Fabricante> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    public Fabricante getFabri() {
        return fabri;
    }

    public void setFabri(Fabricante fabri) {
        this.fabri = fabri;
    }

    
    @PostConstruct
    public void prepararPesquisa() {
        try {
            FabricanteDAO dao = new FabricanteDAO();
            itens = dao.listarTudo();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }

    public void prepararnovo() {
        fabri = new Fabricante();
    }

    public void novo() {        
        FabricanteDAO dao = new FabricanteDAO();
        try {
            dao.salvar(fabri);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Fabricante salvo com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }
   
    public void excluir() {        
        try {
            FabricanteDAO dao = new FabricanteDAO();
            dao.excluir(fabri);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Fabricante removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }    
    public void editar() {        
        try {
            FabricanteDAO dao = new FabricanteDAO();
            dao.editar(fabri);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Fabricante alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }
}
