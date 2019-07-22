package br.com.deposito.bean;

import br.com.deposito.dao.BaixaDao;
import br.com.deposito.dao.GastoFuncionarioDao;
import br.com.deposito.dao.GastoVeiculoDao;
import br.com.deposito.dao.GastosEventuaisDao;
import br.com.deposito.domain.Baixa;
import br.com.deposito.domain.Gasto;
import br.com.deposito.domain.GastoFuncionario;
import br.com.deposito.domain.GastoVeiculo;
import br.com.deposito.domain.GastosEventuais;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBGasto")
@ViewScoped
public class GastoBean {
    
    private ArrayList<GastoVeiculo> listaVeiculo;
    private ArrayList<GastoFuncionario> listaFuncionario;
    private ArrayList<Baixa> listaBaixa;
    private ArrayList<GastosEventuais> listaEventuais;
    private ArrayList<Gasto> lista;
    private Date data1;
    private Date data2;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<Gasto> listaFiltrada;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    
    public ArrayList<Gasto> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }
    
    public void setListaFiltrada(ArrayList<Gasto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    public ArrayList<GastoVeiculo> getListaVeiculo() {
        return listaVeiculo;
    }
    
    public void setListaVeiculo(ArrayList<GastoVeiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }
    
    public ArrayList<GastoFuncionario> getListaFuncionario() {
        return listaFuncionario;
    }
    
    public void setListaFuncionario(ArrayList<GastoFuncionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    
    public ArrayList<Baixa> getListaBaixa() {
        return listaBaixa;
    }
    
    public void setListaBaixa(ArrayList<Baixa> listaBaixa) {
        this.listaBaixa = listaBaixa;
    }
    
    public ArrayList<GastosEventuais> getListaEventuais() {
        return listaEventuais;
    }
    
    public void setListaEventuais(ArrayList<GastosEventuais> listaEventuais) {
        this.listaEventuais = listaEventuais;
    }
    
    public ArrayList<Gasto> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }
    
    public void setLista(ArrayList<Gasto> lista) {
        this.lista = lista;
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
    
    public void pesquisar() {
        BaixaDao daoBaixa = new BaixaDao();
        GastoFuncionarioDao daoFuncionario = new GastoFuncionarioDao();
        GastoVeiculoDao daoVeiculo = new GastoVeiculoDao();
        GastosEventuaisDao daoEventuais = new GastosEventuaisDao();
        try {
            listaBaixa = daoBaixa.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            listaFuncionario = daoFuncionario.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            listaVeiculo = daoVeiculo.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            listaEventuais = daoEventuais.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            preencherGasto();
            Collections.sort(lista);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar " + ex);
        }
    }
    
    public void preencherGasto() {
        lista = new ArrayList<>();
        for (Baixa b : listaBaixa) {
            Gasto gasto = new Gasto();
            gasto.setData(b.getData());
            gasto.setDescricao(b.getDescricao());
            gasto.setValor(b.getValor() * b.getQuantidade());
            gasto.setResponsavel("Baixa");
            lista.add(gasto);
        }
        for (GastoFuncionario b : listaFuncionario) {
            Gasto gasto = new Gasto();
            gasto.setData(b.getData());
            gasto.setDescricao(b.getDescricao());
            gasto.setValor(b.getValor());
            gasto.setResponsavel("Funcionario");
            lista.add(gasto);
        }
        for (GastoVeiculo b : listaVeiculo) {
            Gasto gasto = new Gasto();
            gasto.setData(b.getData());
            gasto.setDescricao(b.getDescricao());
            gasto.setValor(b.getValor());
            gasto.setResponsavel("Veiculo");
            lista.add(gasto);
        }
        for (GastosEventuais b : listaEventuais) {
            Gasto gasto = new Gasto();
            gasto.setData(b.getData());
            gasto.setDescricao(b.getDescricao());
            gasto.setValor(b.getValor());
            gasto.setResponsavel("Eventuais");
            lista.add(gasto);
        }
    }
    
    public void somarValor() {
        double valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (Gasto g : lista) {
                valor += g.getValor();
            }
            String t = df.format(valor);
            JSFUtil.mensagemSucesso("Total de gastos R$ " + t);
        } else {
            for (Gasto g : listaFiltrada) {
                valor += g.getValor();
            }
            String t = df.format(valor);
            JSFUtil.mensagemSucesso("Total de gastos R$ " + t);
        }
    }
}
