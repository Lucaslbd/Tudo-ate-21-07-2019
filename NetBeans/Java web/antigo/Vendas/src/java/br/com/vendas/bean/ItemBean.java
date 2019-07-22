package br.com.vendas.bean;

import br.com.vendas.dao.FabricanteDao;
import br.com.vendas.dao.ItemDao;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.domain.Item;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBItem")
@ViewScoped
public class ItemBean {

    private ArrayList<Item> ListaItem;
    private Date data1;
    private Date data2;
    private ArrayList<Item> ListaItemFiltrado;
    private ArrayList<Fabricante> ListaFabricante;
    private Item item;

    public Item getItem() {
        if (item == null) {
            item = new Item();
        }
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<Fabricante> getListaFabricante() {
        return ListaFabricante;
    }

    public void setListaFabricante(ArrayList<Fabricante> ListaFabricante) {
        this.ListaFabricante = ListaFabricante;
    }

    public ArrayList<Item> getListaItemFiltrado() {
        return ListaItemFiltrado;
    }

    public void setListaItemFiltrado(ArrayList<Item> ListaItemFiltrado) {
        this.ListaItemFiltrado = ListaItemFiltrado;
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

    public ArrayList<Item> getListaItem() {
        return ListaItem;
    }

    public void setListaItem(ArrayList<Item> ListaItem) {
        this.ListaItem = ListaItem;
    }
    
    public void preencherFabricante(){
        FabricanteDao dao = new FabricanteDao();
        try {
            ListaFabricante = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fabricantes " + ex);
        }
    }

    public void listarPorData() {
        if (data1 == null || data2 == null) {
            JSFUtil.mensagemErro("Digite a data de inicio e fina da pesquisa");
        } else {
            ItemDao dao = new ItemDao();
            try {
                ListaItem = dao.ListarPorData(data1, data2);
                preencherFabricante();
                JSFUtil.mensagemSucesso("Pesquisa realizada com sucesso");
            } catch (SQLException ex) {
                JSFUtil.mensagemErro("Erro ao listar Itens " + ex);
            }
        }
    }

    public void listaPorVenda(int codigo) {
        ItemDao dao = new ItemDao();
        try {
            ListaItem = dao.ListarPorVenda(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }
    
}
