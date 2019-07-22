package br.com.deposito.bean;

import br.com.deposito.dao.AutonomiaDao;
import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.domain.Autonomia;
import br.com.deposito.domain.Veiculos;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBAutonomia")
@ViewScoped
public class AutonomiaBean {

    private Autonomia autonomia;
    private ArrayList<Autonomia> lista;
    private ArrayList<Autonomia> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private Date data1;
    private Date data2;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private ArrayList<Veiculos> listaVeiculo;
    private Veiculos veiculo;

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public ArrayList<Veiculos> getListaVeiculo() {
        return listaVeiculo;
    }

    public void setListaVeiculo(ArrayList<Veiculos> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
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

    public Autonomia getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Autonomia autonomia) {
        this.autonomia = autonomia;
    }

    public ArrayList<Autonomia> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<Autonomia> lista) {
        this.lista = lista;
    }

    public ArrayList<Autonomia> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Autonomia> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }
    //--------------------------------------------------------------------------------------------------

    public void listar() {
        AutonomiaDao dao = new AutonomiaDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2, veiculo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar autonomia " + ex);
        }
    }

    public void somarLitros() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            double valor = 0;
            for (Autonomia a : lista) {
                valor += a.getLitros();
            }
            String dx = df.format(valor);
            JSFUtil.mensagemSucesso(dx + " litros");
        }
    }

    public void somarEntregas() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            int valor = 0;
            for (Autonomia a : lista) {
                valor += a.getEntregas();
            }
            JSFUtil.mensagemSucesso(valor + " entregas");
        }
    }

    public void kMpercorridos() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            int i = lista.size();
            double km1 = lista.get(0).getKm();
            double km2 = lista.get(i - 1).getKm();
            double resultado = km2 - km1;

            String dx = df.format(resultado);
            JSFUtil.mensagemSucesso("Foi percorrido " + dx + " km neste periodo de tempo");
        }
    }

    public void entregaPorLitros() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            int entregas = 0;
            for (Autonomia a : lista) {
                entregas += a.getEntregas();
            }
            double litros = 0;
            for (Autonomia a : lista) {
                litros += a.getLitros();
            }
            double resultado = entregas / litros;
            String dx = df.format(resultado);
            JSFUtil.mensagemSucesso("A media de entrega é " + dx + " entregas por litro");
        }
    }

    public void kmPorLitros() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            int i = lista.size();
            double km1 = lista.get(0).getKm();
            double km2 = lista.get(i - 1).getKm();
            double km = km2 - km1;
            double litros = 0;
            for (int j = 0; j < i - 1; j++) {
                litros += lista.get(j).getLitros();
            }
            double resultado = km / litros;
            String dx = df.format(resultado);
            JSFUtil.mensagemSucesso("A media do veiculo é " + dx + " km por litro");
        }
    }

    public void gastoPorEntrega() {
        if (lista.isEmpty() || lista == null) {
            JSFUtil.mensagemErro("Não existem itens a serem somados");
        } else {
            int entregas = 0;
            for (Autonomia a : lista) {
                entregas += a.getEntregas();
            }
            double valor = 0;
            for (Autonomia a : lista) {
                valor += a.getGasto().getValor();
            }
            double resultado = valor / entregas;
            String dx = df.format(resultado);
            JSFUtil.mensagemSucesso("A media de gasto por entrega é R$ " + dx);
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
}
