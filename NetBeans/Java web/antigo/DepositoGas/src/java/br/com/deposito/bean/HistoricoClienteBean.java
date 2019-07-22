package br.com.deposito.bean;

import br.com.deposito.dao.ClienteDao;
import br.com.deposito.domain.HistoricoCliente;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBHistorico")
@ViewScoped
public class HistoricoClienteBean {

    private ArrayList<HistoricoCliente> lista;
    private ArrayList<HistoricoCliente> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private Date data1;
    private Date data2;

    public ArrayList<HistoricoCliente> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<HistoricoCliente> lista) {
        this.lista = lista;
    }

    public ArrayList<HistoricoCliente> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<HistoricoCliente> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
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
    //aqui começa a iplementação----------------------------------------------------------------------------------

    public void listarPorVenda(int codigo) {
        ClienteDao dao = new ClienteDao();
        try {
            lista = dao.ListarHistoricoPorVenda(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }

    public void listarPorData() {
        ClienteDao dao = new ClienteDao();
        try {
            lista = dao.ListarHistoricoPorData(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }

    public void somarItens() {
        if (listaFiltrada.isEmpty()) {
            int i = lista.size();
            JSFUtil.mensagemSucesso("Numero de registros = " + i);
        } else {
            int i = listaFiltrada.size();
            JSFUtil.mensagemSucesso("Numero de registros = " + i);
        }
    }
}
