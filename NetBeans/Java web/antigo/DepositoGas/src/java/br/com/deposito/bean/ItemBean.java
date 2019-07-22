package br.com.deposito.bean;

import br.com.deposito.dao.ItemDao;
import br.com.deposito.domain.Item;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBItem")
@ViewScoped
public class ItemBean {

    private Item item;
    private ArrayList<Item> listaItem;
    private ArrayList<Item> listaItemFiltrado;
    private Date data1;
    private Date data2;
    double valor;
    double custo;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private double valorComDesconto;

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public ArrayList<Item> getListaItemFiltrado() {
        return listaItemFiltrado;
    }

    public void setListaItemFiltrado(ArrayList<Item> listaItemFiltrado) {
        this.listaItemFiltrado = listaItemFiltrado;
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

    //Aqui começa a implementação-------------------------------------------------------------------
    public void listarPorVenda(int codigo) {
        ItemDao dao = new ItemDao();
        try {
            listaItem = dao.ListarPorVenda(codigo);
            somarApurado();
            somarCusto();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }

    public void listar() {
        ItemDao dao = new ItemDao();
        try {
            listaItem = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }

    public void somarApurado() {
        valor = 0;
        valorComDesconto = 0;
        for (Item v : listaItem) {           
            double diminuir = v.getValor() * (v.getVenda().getDesconto() / 100);
            valor += v.getValor();
            valorComDesconto += v.getValor() - diminuir;
        }
    }

    public void somarCusto() {
        custo = 0;
        for (Item v : listaItem) {
            custo += v.getCusto();
        }
    }

    public void somarApurado2() {
        double valor2 = 0;
        if (listaItemFiltrado.isEmpty()) {
            for (Item g : listaItem) {
                valor2 += g.getValor();
            }
        } else {
            for (Item v : listaItemFiltrado) {
                valor2 += v.getValor();
            }
        }
        String v = df.format(valor2);
        JSFUtil.mensagemSucesso("Apurado total R$ " + v);
    }

    public void somarCusto2() {
        double valor2 = 0;
        if (listaItemFiltrado.isEmpty()) {
            for (Item g : listaItem) {
                valor2 += g.getCusto();
            }
        } else {
            for (Item v : listaItemFiltrado) {
                valor2 += v.getCusto();
            }
        }
        String v = df.format(valor2);
        JSFUtil.mensagemSucesso("Custo total R$ " + v);
    }

    public void somarLucro() {
        double valor2 = 0;
        if (listaItemFiltrado.isEmpty()) {
            for (Item g : listaItem) {                
                double diminuir = g.getValor() * (g.getVenda().getDesconto() / 100);
                valor2 += g.getValor() - g.getCusto()  - diminuir;
            }
        } else {
            for (Item v : listaItemFiltrado) {               
                double diminuir = v.getValor() * (v.getVenda().getDesconto() / 100);
                valor2 += v.getValor() - v.getCusto() - diminuir;
            }
        }
        String v = df.format(valor2);
        JSFUtil.mensagemSucesso("Lucro total R$ " + v);
    }

    public void porcentagem() {
        if (listaItem == null) {
            listaItem = new ArrayList<>();
        }
        double valor2 = 0;
        double custo2 = 0;
        double valorComDescont = 0;
        if (listaItemFiltrado.isEmpty()) {
            for (Item g : listaItem) {                
                double diminuir = g.getValor() * (g.getVenda().getDesconto() / 100);
                valorComDescont += g.getValor() - diminuir;
                valor2 += g.getValor();
                custo2 += g.getCusto();
            }
        } else {
            for (Item v : listaItemFiltrado) {             
                double diminuir = v.getValor() * (v.getVenda().getDesconto() / 100);
                valorComDescont += v.getValor() - diminuir;
                valor2 += v.getValor();
                custo2 += v.getCusto();
            }
        }
        double lucro = valorComDescont - custo2;
        double porcentagem = (lucro / valor2) * 100;
        String v = df.format(porcentagem);
        JSFUtil.mensagemSucesso("Porcentagem de lucro " + v + " %");
    }

    public void somarItens() {
        int valor2 = 0;
        if (listaItemFiltrado.isEmpty()) {
            for (Item g : listaItem) {                      
                valor2 += g.getQuantdade();
            }
        } else {
            for (Item v : listaItemFiltrado) {               
                valor2 += v.getQuantdade();
            }
        }        
        JSFUtil.mensagemSucesso("Quantidade de itens = " + valor2);    
    }

    public String paginaVenda() {
        JSFUtil.mensagemSucesso("Modo de visualização 'Venda' ");
        return "ConsultaVenda.xhtml?faces-redirect=true";
    }
}
