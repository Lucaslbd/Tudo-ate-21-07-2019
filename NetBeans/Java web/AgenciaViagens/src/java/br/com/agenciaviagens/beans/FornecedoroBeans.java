package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.FornecedorDao;
import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.domain.Fornecedor;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBFornecedor")
@ViewScoped
public class FornecedoroBeans {

    private int codigo;
    private int acao;
    private Fornecedor fornecedor;
    private ArrayList<Fornecedor> lista;
    private ArrayList<Fornecedor> listaFiltrada;
    private Date data1;
    private Date data2;
    private ArrayList<Venda> listaVenda;
    private double valor;
    private double comissao;
    private double total;
    private double taxas;
    private Venda venda;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTaxas() {
        return taxas;
    }

    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<Fornecedor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Fornecedor> lista) {
        this.lista = lista;
    }

    public ArrayList<Fornecedor> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Fornecedor> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
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
        FornecedorDao dao = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(fornecedor);
            JSFUtil.mensagemSucesso("Fornecedor registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("fornecedor.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar fornecedor" + ex);
        }
    }

    public void alterar() {
        FornecedorDao dao = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(fornecedor);
            JSFUtil.mensagemSucesso("Fornecedor alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("fornecedor.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar fornecedor" + ex);
        }
    }

    public void excluir(int c) {
        FornecedorDao dao = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            JSFUtil.mensagemSucesso("Fornecedor removido com sucesso");            
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir funcionário" + ex);
        }
    }

    public void listar() {
        FornecedorDao dao = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar fornecedor" + ex);
        }
    }

    public void carregarCadastro() {
        FornecedorDao dao = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                fornecedor = new Fornecedor();
            } else {
                fornecedor = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar fornecedor por codigo " + ex);
        }
    }

    public void buscarVendas() {
        VendaDao daov = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaVenda = daov.buscarFornecedor(codigo, data1, data2);
            somar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
        }
    }

    public void somar() {
        comissao = 0;
        valor = 0;
        total = 0;
        taxas = 0;
        int index = 0;
        for (Venda g : listaVenda) {
            comissao += g.getValorReceber();
            valor += g.getValorPacote();
            total += g.getValorPacote() + g.getTaxas();
            taxas += g.getTaxas();
            index++;
        }
        JSFUtil.mensagemSucesso("Foram encontrados " + index + " registros");
    }
}
