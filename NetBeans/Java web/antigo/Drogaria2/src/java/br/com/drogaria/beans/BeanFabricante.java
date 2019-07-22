package br.com.drogaria.beans;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class BeanFabricante {

    private Fabricante fabricante;
    private List <Fabricante> ListaFabricantes;
    private List <Fabricante> ListaFabricantesFiltrados;

    public List<Fabricante> getListaFabricantes() {
        return ListaFabricantes;
    }

    public void setListaFabricantes(List<Fabricante> ListaFabricantes) {
        this.ListaFabricantes = ListaFabricantes;
    }

    public List<Fabricante> getListaFabricantesFiltrados() {
        return ListaFabricantesFiltrados;
    }

    public void setListaFabricantesFiltrados(List<Fabricante> ListaFabricantesFiltrados) {
        this.ListaFabricantesFiltrados = ListaFabricantesFiltrados;
    }

    public Fabricante getFabricante() {
       /* if (fabricante == null) {
            fabricante = new Fabricante();
        }*/
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    public void renovarObjeto(){
    fabricante = new Fabricante();
    }
    public void salvar() {
        try {
             FabricanteDAO dao = new FabricanteDAO();
             dao.Salvar(fabricante);
            JSFUtil.mensagemSucesso("Fabricante adicionado com sucesso");
            fabricante = new Fabricante();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao tentar salvar fabricante" + ex.getMessage());
        }
    }
    
    public void carregar(){
        try{
            FabricanteDAO dao = new FabricanteDAO();
            ListaFabricantes = dao.listar();
        }catch(RuntimeException ex){
             JSFUtil.mensagemErro("Erro ao carregar fabricante" + ex.getMessage());
        }
    }
    public void excluir() {
        try {
             FabricanteDAO dao = new FabricanteDAO();
             dao.Excluir(fabricante);
             JSFUtil.mensagemSucesso("Fabricante excluido com sucesso");
             fabricante = new Fabricante();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("O fabricante não pode ser excluido pois existem produtos a ele relacionados");
        }
    }
    public void alterar() {
        try {
             FabricanteDAO dao = new FabricanteDAO();
             dao.Editar(fabricante);
             JSFUtil.mensagemSucesso("Fabricante alterado com sucesso");
             fabricante = new Fabricante();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao tentar alterar fabricante" + ex.getMessage());
        }
    }
}
