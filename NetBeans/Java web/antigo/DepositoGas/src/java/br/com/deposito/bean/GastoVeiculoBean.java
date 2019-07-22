package br.com.deposito.bean;

import br.com.deposito.dao.AutonomiaDao;
import br.com.deposito.dao.GastoVeiculoDao;
import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.domain.Autonomia;
import br.com.deposito.domain.GastoVeiculo;
import br.com.deposito.domain.Veiculos;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBGastoVeiculo")
@ViewScoped
public class GastoVeiculoBean {

    private GastoVeiculo gasto;
    private ArrayList<GastoVeiculo> lista;
    private ArrayList<GastoVeiculo> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<Veiculos> listaVeiculo;
    private Date data1;
    private Date data2;
    private double valor;
    private boolean veKm = true;
    private Autonomia autonomia;

    public Autonomia getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Autonomia autonomia) {
        this.autonomia = autonomia;
    }

    public boolean isVeKm() {
        return veKm;
    }

    public void setVeKm(boolean veKm) {
        this.veKm = veKm;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public GastoVeiculo getGasto() {
        return gasto;
    }

    public void setGasto(GastoVeiculo gasto) {
        this.gasto = gasto;
    }

    public ArrayList<GastoVeiculo> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<GastoVeiculo> lista) {
        this.lista = lista;
    }

    public ArrayList<GastoVeiculo> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<GastoVeiculo> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Veiculos> getListaVeiculo() {
        return listaVeiculo;
    }

    public void setListaVeiculo(ArrayList<Veiculos> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    //Aqui começa a implementação-----------------------------------------------------------------
    public void listar() {
        if (data1 == null || data2 == null) {

        } else {
            listaFiltrada = new ArrayList<>();
            GastoVeiculoDao dao = new GastoVeiculoDao();
            try {
                lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            } catch (SQLException ex) {
                JSFUtil.mensagemErro("Erro ao listar gastos " + ex);
            }
        }
    }

    public void atualizarObjeto() {
        gasto = new GastoVeiculo();
        autonomia = new Autonomia();
        listarVeiculo();
        veKm = true;
    }

    public void salvar() {
        GastoVeiculoDao dao = new GastoVeiculoDao();;
        try {
            dao.Salvar(gasto);
            if (gasto.getTipo().equals("Combustivel")) {
                AutonomiaDao d = new AutonomiaDao();
                GastoVeiculo temp = dao.Ultimoregistro(MBAutenticacao.getUsuario().getDeposito().getCodigo());
                autonomia.setGasto(temp);
                autonomia.setEntregas(0);
                d.Salvar(autonomia);
                JSFUtil.mensagemSucesso("Autonomia registrada com sucesso");
            }
            veKm = true;
            listar();
            JSFUtil.mensagemSucesso("Gasto registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar gasto" + ex);
        }
    }

    public void alterar() {
        GastoVeiculoDao dao = new GastoVeiculoDao();
        try {
            dao.Alterar(gasto);
            listar();
            JSFUtil.mensagemSucesso("Gasto alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar gasto " + ex);
        }
    }

    public void excluir() {
        GastoVeiculoDao dao = new GastoVeiculoDao();
        try {
            dao.excluir(gasto);
            listar();
            JSFUtil.mensagemSucesso("Gasto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir gasto " + ex);
        }
    }

    public void listarVeiculo() {
        VeiculoDao dao = new VeiculoDao();
        try {
            listaVeiculo = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fornecedores " + ex);
        }
    }

    public void somar() {
        valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (GastoVeiculo g : lista) {
                valor += g.getValor();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        } else {
            for (GastoVeiculo g : listaFiltrada) {
                valor += g.getValor();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        }
    }

    public void verKm() {
        veKm = gasto.getTipo().equals("Combustivel");
    }

}
