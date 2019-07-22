package br.com.deposito.bean;

import br.com.deposito.dao.NotaDao;
import br.com.deposito.domain.ItemNota;
import br.com.deposito.domain.Nota;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBNota")
@ViewScoped
public class NotaBean {

    private Nota nota;
    private ArrayList<Nota> lista;
    private ArrayList<Nota> listaFiltrada;
    private ArrayList<ItemNota> listaItem;
    private Date data1;
    private Date data2;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<ItemNota> listaItemFiltrada;

    public ArrayList<ItemNota> getListaItemFiltrada() {
        if (listaItemFiltrada == null) {
            listaItemFiltrada = new ArrayList<>();
        }
        return listaItemFiltrada;
    }

    public void setListaItemFiltrada(ArrayList<ItemNota> listaItemFiltrada) {
        this.listaItemFiltrada = listaItemFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public ArrayList<Nota> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<Nota> lista) {
        this.lista = lista;
    }

    public ArrayList<Nota> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Nota> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public ArrayList<ItemNota> getListaItem() {
        if (listaItem == null) {
            listaItem= new ArrayList<>();
        }
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

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    //Aqui começa a implementação-----------------------------------------------------------------------------
    public void listar() {
        NotaDao dao = new NotaDao();
        try {
            lista = dao.ListarNota(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar notas " + ex);
        }
    }

    public void listarItens() {
        NotaDao dao = new NotaDao();
        try {
            listaItem = dao.ListarItens(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens da notas " + ex);
        }
    }

    public void listarItensNota(int codigo) {
        NotaDao dao = new NotaDao();
        try {
            listaItem = dao.ListarItensNota(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar notas " + ex);
        }
    }

    public void excluir() {
        NotaDao dao = new NotaDao();
        try {
            dao.excluir(nota);
            listar();
            JSFUtil.mensagemSucesso("Nota removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover nota " + ex);
        }
    }

    public void somarNota() {
        double valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (Nota g : lista) {
                valor += g.getValor();
            }
        } else {
            for (Nota v : listaFiltrada) {
                valor += v.getValor();
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Total em notas R$ " + v);
    }

    public void somarItens() {
        double valor = 0;        
        if (listaItemFiltrada.isEmpty()) {
            for (ItemNota g : listaItem) {
                valor += g.getValor() * g.getQuantidade();
            }
        } else {
            for (ItemNota v : listaItemFiltrada) {
                valor += v.getValor() * v.getQuantidade();
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Total em notas R$ " + v);
    }

    public void registraPagamento() {
        NotaDao dao = new NotaDao();
        try {
            dao.RegistraPagamento(nota);
            listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar pagamento " + ex);
        }
    }

    public String paginaNota() {
        JSFUtil.mensagemSucesso("Modo de visualização 'Nota' ");
        return "ControleNota.xhtml?faces-redirect=true";
    }

    public String paginaItem() {
        JSFUtil.mensagemSucesso("Modo de visualização 'Item da "
                + "nota' ");
        return "ControleNotaItem.xhtml?faces-redirect=true";
    }
}
