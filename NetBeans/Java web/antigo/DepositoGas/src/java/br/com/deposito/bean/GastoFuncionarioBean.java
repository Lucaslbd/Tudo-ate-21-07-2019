package br.com.deposito.bean;

import br.com.deposito.dao.FuncionarioDao;
import br.com.deposito.dao.GastoFuncionarioDao;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.domain.GastoFuncionario;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBPagamentoFuncionario")
@ViewScoped
public class GastoFuncionarioBean {

    private GastoFuncionario gasto;
    private ArrayList<GastoFuncionario> lista;
    private ArrayList<GastoFuncionario> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<Funcionario> listaFuncionario;
    private Date data1;
    private Date data2;

    public GastoFuncionario getGasto() {
        return gasto;
    }

    public void setGasto(GastoFuncionario gasto) {
        this.gasto = gasto;
    }

    public ArrayList<GastoFuncionario> getLista() {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public void setLista(ArrayList<GastoFuncionario> lista) {
        this.lista = lista;
    }

    public ArrayList<GastoFuncionario> getListaFiltrada() {
        if (listaFiltrada == null) {
            listaFiltrada = new ArrayList<>();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<GastoFuncionario> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
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

    public void listar() {
        GastoFuncionarioDao dao = new GastoFuncionarioDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar gastos " + ex);
        }
    }

    public void atualizarObjeto() {
        gasto = new GastoFuncionario();
    }

    public void salvar() {
        GastoFuncionarioDao dao = new GastoFuncionarioDao();
        try {
            dao.Salvar(gasto);
            listar();
            JSFUtil.mensagemSucesso("Pagamento registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar pagamento" + ex);
        }
    }

    public void alterar() {
        GastoFuncionarioDao dao = new GastoFuncionarioDao();
        try {
            dao.Alterar(gasto);
            listar();
            JSFUtil.mensagemSucesso("Pagamento alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar pagamento " + ex);
        }
    }

    public void excluir() {
        GastoFuncionarioDao dao = new GastoFuncionarioDao();
        try {
            dao.excluir(gasto);
            listar();
            JSFUtil.mensagemSucesso("Pagamento removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir pagamento " + ex);
        }
    }

    public void listarFuncionarios() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            listaFuncionario = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar funcionario " + ex);
        }
    }

    public void somar() {
        double valor = 0;
        if (listaFiltrada.isEmpty()) {
            for (GastoFuncionario g : lista) {
                valor += g.getValor();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        } else {
            for (GastoFuncionario g : listaFiltrada) {
                valor += g.getValor();
            }
            JSFUtil.mensagemSucesso("Total de gastos R$ " + valor);
        }
    }
}
