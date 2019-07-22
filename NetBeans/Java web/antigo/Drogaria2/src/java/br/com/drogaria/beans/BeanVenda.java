package br.com.drogaria.beans;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.ItemDao;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendasDao;
import br.com.drogaria.domain.Funcionarios;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produtos;
import br.com.drogaria.domain.Vendas;
import br.com.drogaria.filter.VendaFilter;
import br.com.drogaria.util.JSFUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBVenda")
@ViewScoped
public class BeanVenda {

    private List<Produtos> ListaProdutos;
    private List<Produtos> ListaProdutosFiltrados;
    private List<Item> ListaItens;
    private Vendas venda;
    private Produtos produto;
    private VendaFilter filtro;
    private List<Vendas> ListaVendasFiltradas;
    private List<Vendas> ListaVendas;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticacao MBAutenticacao;

    public List<Vendas> getListaVendas() {
        return ListaVendas;
    }

    public void setListaVendas(List<Vendas> ListaVendas) {
        this.ListaVendas = ListaVendas;
    }

    public List<Vendas> getListaVendasFiltradas() {
        return ListaVendasFiltradas;
    }

    public void setListaVendasFiltradas(List<Vendas> ListaVendasFiltradas) {
        this.ListaVendasFiltradas = ListaVendasFiltradas;
    }

    public VendaFilter getFiltro() {
        if(filtro == null){
            filtro = new VendaFilter();
        }
        return filtro;
    }

    public void setFiltro(VendaFilter filtro) {
        this.filtro = filtro;
    }
    
   

    public BeanAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }
    

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Vendas getVenda() {
        if (venda == null) {
            venda = new Vendas();
            venda.setValor(new BigDecimal("0.00"));
            venda.setQuantidade(0);
        }
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public List<Item> getListaItens() {
        if (ListaItens == null) {
            ListaItens = new ArrayList<>();
        }
        return ListaItens;
    }

    public void setListaItens(List<Item> ListaItens) {
        this.ListaItens = ListaItens;
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

    public void carregarProdutos() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ListaProdutos = dao.listar();

        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao carregar produtos" + ex.getMessage());
        }
    }

    public void adicionar(Produtos produto) {
        int PosicaoEncontrada = -1;
        for (int i = 0; i < ListaItens.size() && PosicaoEncontrada < 0; i++) {
            Item novaLista = ListaItens.get(i);
            if (novaLista.getProdutos().equals(produto)) {
                PosicaoEncontrada = i;
            }
        }
        Item item = new Item();
        item.setProdutos(produto);
        if (PosicaoEncontrada < 0) {
            item.setQuantidade(1);
            item.setValor(produto.getPreco());
            ListaItens.add(item);
        }else {
            Item itemTemp = ListaItens.get(PosicaoEncontrada);
            item.setQuantidade(itemTemp.getQuantidade() + 1);
            item.setValor(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
            ListaItens.set(PosicaoEncontrada,item);
        }
        venda.setValor(venda.getValor().add(produto.getPreco()));
        venda.setQuantidade(venda.getQuantidade()+1);
        
    }

    public void remover(Item item){
         int PosicaoEncontrada = -1;
        for (int i = 0; i < ListaItens.size() && PosicaoEncontrada < 0; i++) {
            Item novaLista = ListaItens.get(i);
            if (novaLista.getProdutos().equals(item.getProdutos())) {
                PosicaoEncontrada = i;
            }
        }
        if(PosicaoEncontrada >-1){
        ListaItens.remove(PosicaoEncontrada);
        venda.setValor(venda.getValor().subtract(item.getValor()));
        venda.setQuantidade(venda.getQuantidade() - item.getQuantidade());
        }
    }
    
    public void carregarDadosVenda(){              
        venda.setHorario(new Date());
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionarios funcionario = dao.buscarPorCodigo(MBAutenticacao.getFuncionarioLogado().getCodigo());
        venda.setFuncionarios(funcionario);
    }  
    
    public void salvar(){        
        try{
            VendasDao dao = new VendasDao();
            int codigoVenda = dao.Salvar(venda); 
            Vendas vendafk = dao.buscarPorCodigo(codigoVenda);
            
            for(Item item: ListaItens ){
                item.setVendas(vendafk);
                ItemDao itemdao = new ItemDao();
                itemdao.Salvar(item);
            }
           
            venda = new Vendas();
            venda.setValor(new BigDecimal("0.00"));
            ListaItens = new ArrayList<>();
            JSFUtil.mensagemSucesso("Venda realizada com sucesso");
        }catch(RuntimeException ex){
            JSFUtil.mensagemErro("Erro" + ex);
        }
    }
    public void buscar(){
       try{ 
        VendasDao dao = new VendasDao();
        ListaVendasFiltradas = dao.buscarData(filtro);
        
       }catch(RuntimeException ex){
            JSFUtil.mensagemErro("Erro" + ex);
}
    }
    
    public void carregar(){
        try{
            VendasDao dao = new VendasDao();
            ListaVendas = dao.listar();
        }catch(RuntimeException ex){
             JSFUtil.mensagemErro("Erro ao carregar produtos" + ex.getMessage());
        }
    }
}