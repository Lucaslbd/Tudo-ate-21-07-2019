package br.com.drogaria.beans;


import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produtos;
import br.com.drogaria.util.JSFUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class BeanProduto {
    
    private Produtos Produto;
    private List <Produtos> ListaProdutos;
    private List <Produtos> ListaProdutosFiltrados;
    private Fabricante fabricante;
    private List <Fabricante> ListaFabricantes;

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<Fabricante> getListaFabricantes() {
        return ListaFabricantes;
    }

    public void setListaFabricantes(List<Fabricante> ListaFabricantes) {
        this.ListaFabricantes = ListaFabricantes;
    }
    
    public Produtos getProduto() {
        return Produto;
    }

    public void setProduto(Produtos Produto) {
        this.Produto = Produto;
    }

    public List<Produtos> getListaProdutos() {
        return ListaProdutos;
    }

    public void setListaProdutos(List<Produtos> ListaProdutos) {
        this.ListaProdutos = ListaProdutos;
    }

    public List<Produtos> getListaProdutosFiltrados() {
        return ListaProdutosFiltrados;
    }

    public void setListaProdutosFiltrados(List<Produtos> ListaProdutosFiltrados) {
        this.ListaProdutosFiltrados = ListaProdutosFiltrados;
    }
    
    public void renovarObjeto(){
    FabricanteDAO f = new FabricanteDAO();
    Produto = new Produtos();
    ListaFabricantes = f.listar();
    }
    public void salvar() {
        try {
             ProdutoDAO dao = new ProdutoDAO();
             dao.Salvar(Produto);
            JSFUtil.mensagemSucesso("Produto adicionado com sucesso");
            Produto = new Produtos();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro" + ex);
        }
    }
    
    public void carregar(){
        try{
            ProdutoDAO dao = new ProdutoDAO();
            ListaProdutos = dao.listar();
        }catch(RuntimeException ex){
             JSFUtil.mensagemErro("Erro ao carregar produtos" + ex.getMessage());
        }
    }
    public void excluir() {
        try {
             ProdutoDAO dao = new ProdutoDAO();
             dao.Excluir(Produto);
             JSFUtil.mensagemSucesso("Produto excluido com sucesso");
              Produto = new Produtos();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("O produto não pode ser excluido");
        }
    }
    public void alterar() {
        try {
             ProdutoDAO dao = new ProdutoDAO();
             dao.Editar(Produto);
             JSFUtil.mensagemSucesso("Produto alterado com sucesso");
             Produto = new Produtos();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao tentar alterar produto" + ex.getMessage());
        }
    }
}
