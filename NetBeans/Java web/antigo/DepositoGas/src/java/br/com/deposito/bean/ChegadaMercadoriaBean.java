package br.com.deposito.bean;

import br.com.deposito.dao.NotaDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.ItemNota;
import br.com.deposito.domain.Nota;
import br.com.deposito.domain.Produto;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBChegadaMercadoria")
@ViewScoped
public class ChegadaMercadoriaBean {

    
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<ItemNota> listaItem;
    private Date data1;
    private Date data2;
    private ArrayList<Produto> listaProduto;
    private Produto produto;
    private int quantidade = 1;
    private String casco;
    private String valorTotal = "00,00";
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private boolean finaliza = true;
    private int indexAlterar;
    private ItemNota itemAlterar;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorAlterar() {
        return valorAlterar;
    }

    public void setValorAlterar(double valorAlterar) {
        this.valorAlterar = valorAlterar;
    }
    private double valorAlterar;

    public int getIndexAlterar() {
        return indexAlterar;
    }

    public void setIndexAlterar(int indexAlterar) {
        this.indexAlterar = indexAlterar;
    }

    public ItemNota getItemAlterar() {
        return itemAlterar;
    }

    public void setItemAlterar(ItemNota itemAlterar) {
        this.itemAlterar = itemAlterar;
    }

    public boolean isFinaliza() {
        return finaliza;
    }

    public void setFinaliza(boolean finaliza) {
        this.finaliza = finaliza;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<ItemNota> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<ItemNota> listaItem) {
        this.listaItem = listaItem;
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

    //aqui começa a implementação------------------------------------------------------------------------------
    public void preencherObjetos() {
        ProdutoDao dao = new ProdutoDao();

        try {
            listaProduto = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar " + ex);
        }
    }

    public void adicionar() {
        if (listaItem == null) {
            listaItem = new ArrayList<>();
        }
        int estoque = 0;
        for (ItemNota l : listaItem) {
            if (produto.equals(l.getProduto())) {
                estoque += l.getQuantidade();
            }
        }
        if (casco.equals("Sem casco") && produto.getEstoqueVazio() < quantidade + estoque) {
            JSFUtil.mensagemErro("Não existe estoque suficiente");
        } else {
            ItemNota item = new ItemNota();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            if (casco.equals("Sem casco")) {
                item.setValor(produto.getCustoProduto());
                item.setCasco("Sem casco");
            } else {
                item.setValor((produto.getCustoProduto() + produto.getCustoCasco()) * quantidade);
                item.setCasco("Com casco");
            }
            listaItem.add(item);
            double valor = 0;
            for (ItemNota i : listaItem) {
                valor += i.getValor() * i.getQuantidade();
            }
            valorTotal = df.format(valor);
            quantidade = 1;
        }
    }

    public void finalizaLista() {
        if (listaItem == null || listaItem.isEmpty()) {
            JSFUtil.mensagemErro("Não existem itens para finalizar");
        } else {
            finaliza = false;
        }
    }

    public void cancelar() {
        finaliza = true;
        valorTotal = "00,00";
        casco = "";
        descricao = "";
        listaItem = new ArrayList<>();
        produto = new Produto();
    }

    public void finalizar() {
        NotaDao dao = new NotaDao();
        Nota nota = new Nota();
        nota.setChegada(data1);
        nota.setVencimento(data2);
        nota.setDescricao(descricao);
        nota.setDeposito(MBAutenticacao.getUsuario().getDeposito());
        double custo = 0;
        for (ItemNota t : listaItem) {
            custo += t.getValor() * t.getQuantidade();
        }
        nota.setValor(custo);
        try {
            dao.Salvar(nota);
            Nota UltimoRegistro = dao.Ultimoregistro(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            for (ItemNota t : listaItem) {
                t.setNota(UltimoRegistro);
                t.setUtilizados(0);
                dao.SalvarItemNota(t);
                dao.mudaEstoque(t);                 
            }
            JSFUtil.mensagemSucesso("Nota registrada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao salvar nota " + ex);           
        }
        cancelar();
    }

    public void remover(int index) {
        listaItem.remove(index);
        double valor = 0;
        for (ItemNota i : listaItem) {
            valor += i.getValor() * i.getQuantidade();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
        JSFUtil.mensagemSucesso("Item removido com sucesso");
    }

    public void recebe(ItemNota item, int index) {
        indexAlterar = index;
        itemAlterar = item;
    }

    public void alterar() {
        itemAlterar.setValor(valorAlterar);
        listaItem.set(indexAlterar, itemAlterar);
        valorAlterar = 0;
        double valor = 0;
        for (ItemNota i : listaItem) {
            valor += i.getValor();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
        JSFUtil.mensagemSucesso("Item alterado com sucesso");
    }
}
