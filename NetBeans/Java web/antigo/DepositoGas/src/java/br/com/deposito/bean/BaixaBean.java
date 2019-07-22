package br.com.deposito.bean;

import br.com.deposito.dao.BaixaDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Baixa;
import br.com.deposito.domain.Produto;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBBaixa")
@ViewScoped
public class BaixaBean {
    
    private Baixa baixa;
    private ArrayList<Baixa> lista;
    private ArrayList<Baixa> listaFiltrada;
    private Date data1;
    private Date data2;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<Produto> listaProduto;
    
    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }
    
    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public Baixa getBaixa() {
        return baixa;
    }
    
    public void setBaixa(Baixa baixa) {
        this.baixa = baixa;
    }
    
    public ArrayList<Baixa> getLista() {
        if(lista == null){
            lista = new ArrayList<>();
        }
        return lista;
    }
    
    public void setLista(ArrayList<Baixa> lista) {
        this.lista = lista;
    }
    
    public ArrayList<Baixa> getListaFiltrada() {
        if(listaFiltrada == null){
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }
    
    public void setListaFiltrada(ArrayList<Baixa> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    public Date getData1() {
        return data1;
    }
    
    public void setData1(Date data1) {
        this.data1 = data1;
    }
    
    public Date getData2() {
        return data2;
    }
    
    public void setData2(Date data2) {
        this.data2 = data2;
    }
    
    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }
    
    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    //Aqui começa a implementação-------------------------------------------------------------------------------
    public void listar() {
        BaixaDao dao = new BaixaDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar baixas " + ex);
        }
    }
    
    public void atualizarObjeto() {
        baixa = new Baixa();
    }
    
    public void salvar() {
        BaixaDao dao = new BaixaDao();
        try {
            if (baixa.getCasco().equals("Sem casco")) {
                baixa.setValor(baixa.getPreoduto().getCustoProduto());
            } else {
                baixa.setValor(baixa.getPreoduto().getCustoProduto() + baixa.getPreoduto().getCustoCasco());
            }
            dao.Salvar(baixa);
            dao.baixaEstoque(baixa);        
            JSFUtil.mensagemSucesso("Baixa registrada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar baixa" + ex);
        }
    }
    
    public void excluir() {
        BaixaDao dao = new BaixaDao();
        try {
            dao.excluir(baixa);
            listar();
            JSFUtil.mensagemSucesso("Baixa removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir baixa " + ex);
        }
    }
    
    public void somarValor() {
        double valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (Baixa g : lista) {
                valor += g.getValor() * g.getQuantidade();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        } else {
            for (Baixa g : listaFiltrada) {
                valor += g.getValor() * g.getQuantidade();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        }
    }    
    
    
    public void somarQuantidade() {
        int valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (Baixa g : lista) {
                valor += g.getQuantidade();
            }
            JSFUtil.mensagemSucesso("Total de baixas " + valor);
        } else {
            for (Baixa g : listaFiltrada) {
                valor += g.getQuantidade();
            }
            JSFUtil.mensagemSucesso("Total de baixas " + valor);
        }
    }
    
    public void listarProdutos() {
        ProdutoDao dao = new ProdutoDao();
        try {
            listaProduto = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar produtos " + ex);
        }
    }
}
