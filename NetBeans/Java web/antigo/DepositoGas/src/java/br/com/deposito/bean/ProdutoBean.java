package br.com.deposito.bean;

import br.com.deposito.dao.FornecedorDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Fornecedor;
import br.com.deposito.domain.Produto;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

    private Produto produto;
    private ArrayList<Produto> listaProduto;
    private ArrayList<Produto> listaProdutoFiltrado;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<Fornecedor> listaFornecedor;

    public ArrayList<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(ArrayList<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ArrayList<Produto> getListaProdutoFiltrado() {
        return listaProdutoFiltrado;
    }

    public void setListaProdutoFiltrado(ArrayList<Produto> listaProdutoFiltrado) {
        this.listaProdutoFiltrado = listaProdutoFiltrado;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    //Aqui começa a implementação-----------------------------------------------------------------
    
    public void listar() {
        ProdutoDao dao = new ProdutoDao();
        try {
            listaProduto = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar produtos " + ex);
        }
    }

    public void atualizarObjeto() {
        produto = new Produto();
        listarFornecedor();
    }

    public void salvar() {
        ProdutoDao dao = new ProdutoDao();
        try {
            dao.Salvar(produto);
            JSFUtil.mensagemSucesso("produto registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar produto" + ex);
        }
    }

    public void alterar() {
        ProdutoDao dao = new ProdutoDao();       
        try {
            dao.Alterar(produto);
            JSFUtil.mensagemSucesso("produto alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar produto " + ex);
        }
    }

    public void excluir() {
        ProdutoDao dao = new ProdutoDao();
        try {
            dao.excluir(produto);
            JSFUtil.mensagemSucesso("produto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir produto " + ex);
        }
    }
    
    public void listarFornecedor() {
        FornecedorDao dao = new FornecedorDao();
        try {
            listaFornecedor = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fornecedores " + ex);
        }
    }

}
