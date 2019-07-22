package br.com.deposito.bean;

import br.com.deposito.dao.GastosEventuaisDao;
import br.com.deposito.domain.GastosEventuais;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBGastosEventuais")
@ViewScoped
public class GastosEventuaisBean {

    private GastosEventuais gasto;
    private ArrayList<GastosEventuais> lista;
    private ArrayList<GastosEventuais> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private Date data1;
    private Date data2;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");

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

    public GastosEventuais getGasto() {
        return gasto;
    }

    public void setGasto(GastosEventuais gasto) {
        this.gasto = gasto;
    }

    public ArrayList<GastosEventuais> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<GastosEventuais> lista) {
        this.lista = lista;
    }

    public ArrayList<GastosEventuais> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<GastosEventuais> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public void listar() {
        GastosEventuaisDao dao = new GastosEventuaisDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar gastos " + ex);
        }
    }

    public void atualizarObjeto() {
        gasto = new GastosEventuais();
    }

    public void salvar() {
        GastosEventuaisDao dao = new GastosEventuaisDao();
        try {
            gasto.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(gasto);
            JSFUtil.mensagemSucesso("Gasto registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar gasto" + ex);
        }
    }

    public void alterar() {
        GastosEventuaisDao dao = new GastosEventuaisDao();
        try {
            dao.Alterar(gasto);
            JSFUtil.mensagemSucesso("Gasto alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar gasto " + ex);
        }
    }

    public void excluir() {
        GastosEventuaisDao dao = new GastosEventuaisDao();
        try {
            dao.excluir(gasto);
            JSFUtil.mensagemSucesso("Gasto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir gasto " + ex);
        }
    }

    public void somarValor() {
        double valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (GastosEventuais g : lista) {
                valor += g.getValor();
            }
            String t = df.format(valor);
            JSFUtil.mensagemSucesso("Total de gastos R$ " + t);
        } else {
            for (GastosEventuais g : listaFiltrada) {
                valor += g.getValor();
            }
            String t = df.format(valor);
            JSFUtil.mensagemSucesso("Total de gastos R$ " + t);
        }
    }
}
