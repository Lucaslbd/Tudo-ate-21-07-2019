package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.GastoDao;
import br.com.agenciaviagens.domain.Gastos;
import br.com.agenciaviagens.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBGastos")
@ViewScoped
public class GastosBeans {

    private int codigo;
    private int acao;
    private Gastos gastos;
    private ArrayList<Gastos> lista;
    private double total = 0;
    private Date data1;
    private Date data2;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }

    public ArrayList<Gastos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Gastos> lista) {
        this.lista = lista;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    /*----------------------------------Codigo--------------------------------------------------------------------*/
    public void salvar() {
        GastoDao dao = new GastoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(gastos);
            JSFUtil.mensagemSucesso("Gasto registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("gastos.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar gasto" + ex);
        }
    }

    public void alterar() {
        GastoDao dao = new GastoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(gastos);
            JSFUtil.mensagemSucesso("Gasto alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("gastos.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar gasto" + ex);
        }
    }

    public void excluir(int c) {
        GastoDao dao = new GastoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Gasto excluido com sucesso");            
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir gasto" + ex);
        }
    }
    

    public void listar() {
        GastoDao dao = new GastoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar(data1, data2);
            somar();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar gastos" + ex);
        }
    }

    public void carregarCadastro() {
        GastoDao dao = new GastoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                gastos = new Gastos();
            } else {
                gastos = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar gasto por codigo " + ex);
        }
    }

    public void somar() {
        total = 0;
        int registros = 0;
        for (Gastos g : lista) {
            total += g.getValor();
            registros++;
        }
        JSFUtil.mensagemSucesso("" + registros + " registros encontrados");
    }
}
