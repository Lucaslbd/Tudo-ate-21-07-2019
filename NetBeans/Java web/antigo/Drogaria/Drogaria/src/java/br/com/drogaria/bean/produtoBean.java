package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.util.JSFUtil;
import br.com.drograria.domain.Fabricante;
import br.com.drograria.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class produtoBean {

    private Produto proeduto;
    private ArrayList<Produto> itens;
    private ArrayList<Produto> itensFiltrados;
    private ArrayList<Fabricante> comboFabricantes;

    public ArrayList<Fabricante> getComboFabricantes() {
        return comboFabricantes;
    }

    public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
        this.comboFabricantes = comboFabricantes;
    }

    public Produto getProeduto() {
        return proeduto;
    }

    public void setProeduto(Produto proeduto) {
        this.proeduto = proeduto;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public ArrayList<Produto> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    @PostConstruct
    public void prepararPesquisa() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            itens = dao.listarTudo();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }

    public void prepararnovo() {
        proeduto = new Produto();
         FabricanteDAO dao = new FabricanteDAO();
        try {
            comboFabricantes = dao.listarTudo();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }
    public void novo() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.salvar(proeduto);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Produto salvo com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());

        }
    }
    public void excluir() {        
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.excluir(proeduto);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Produto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    } 
    public void prepararEditar(){
        FabricanteDAO dao = new FabricanteDAO();
        try {
            comboFabricantes = dao.listarTudo();
        } catch (SQLException ex) {
           JSFUtil.mensagemErro(ex.getMessage());
        }
    }
    public void editar() {        
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.editar(proeduto);
            itens = dao.listarTudo();
            JSFUtil.mensagemSucesso("Produto alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro(ex.getMessage());
        }
    }

}
