package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.dao.FornecedorDao;
import br.com.agenciaviagens.dao.FuncionarioDao;
import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Fornecedor;
import br.com.agenciaviagens.domain.Funcionario;
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

@ManagedBean(name = "MBVenda")
@ViewScoped
public class VendaBeans {

    private int codigo;
    private int acao;
    private Venda venda;
    private ArrayList<Venda> lista;
    private ArrayList<Venda> listaFiltrada;
    private ArrayList<Cliente> listaCliente;
    private ArrayList<Fornecedor> listaFornecedor;    
    private Date data1;
    private Date data2;    
    private double lucro;
    private int pesquisa = 1;
    private String referencia;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;     
    
    private double comissaoFunc;
    private double total;
    private double comissao;
    private double porFornecedor;
    private double porFunc;

    public double getPorFunc() {
        return porFunc;
    }

    public void setPorFunc(double porFunc) {
        this.porFunc = porFunc;
    }

    public double getPorFornecedor() {
        return porFornecedor;
    }

    public void setPorFornecedor(double porFornecedor) {
        this.porFornecedor = porFornecedor;
    }

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(int pesquisa) {
        this.pesquisa = pesquisa;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getComissaoFunc() {
        return comissaoFunc;
    }

    public void setComissaoFunc(double comissaoFunc) {
        this.comissaoFunc = comissaoFunc;
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

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(ArrayList<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    private ArrayList<Funcionario> listaFuncionario;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ArrayList<Venda> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Venda> lista) {
        this.lista = lista;
    }

    public ArrayList<Venda> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Venda> listaFiltrada) {
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
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());      
        try {           
            dao.Salvar(venda);
            JSFUtil.mensagemSucesso("Venda registrada com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("venda.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar venda" + ex);
        }
    }

    public void alterar() {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(venda);
            JSFUtil.mensagemSucesso("Venda alterada com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("venda.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar venda" + ex);
        }
    }

    public void excluir(int c) {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Venda removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir venda" + ex);
        }
    }

    public void listar() {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (pesquisa == 1) {
                lista = dao.Listar(data1, data2);
            } else {
                lista = dao.Listar2(referencia);
            }
            somar();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar vendas" + ex);
        }
    }

    public void listarCheckins() {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.buscaCheckin2();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar proximos checkins" + ex);
        }
    }

    public void listarAreceber() {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.ListarPagamentoAreceber();
            somar2();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar pagamentos a receber" + ex);
        }
    }

    public void carregarCadastro() {
        VendaDao dao = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        ClienteDao daoCliente = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        FornecedorDao daoFornecedor = new FornecedorDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        FuncionarioDao daoFuncionario = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaCliente = daoCliente.Listar();
            listaFornecedor = daoFornecedor.Listar();
            listaFuncionario = daoFuncionario.Listar();
            if (acao == 1) {
                venda = new Venda();
            } else {
                venda = dao.buscarPorCodigo(codigo);
                calcular();
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar venda por codigo " + ex);
        }
    }

    public void somar() {
        total = 0;
        comissao = 0;
        comissaoFunc = 0;
        lucro = 0;
        int registros = 0;
        for (Venda g : lista) {
            total += g.getValorPacote() + g.getTaxas();
            comissao += g.getValorReceber();
            comissaoFunc += g.getComissaoFunc();
            lucro += g.getValorReceber() - g.getComissaoFunc();
            registros++;
        }
        JSFUtil.mensagemSucesso("" + registros + " registros encontrados");
    }

    public void somar2() {
        total = 0;
        comissao = 0;
        comissaoFunc = 0;
        lucro = 0;
        for (Venda g : lista) {
            total += g.getValorPacote() + g.getTaxas();
            comissao += g.getValorReceber();
            comissaoFunc += g.getTaxas();
            lucro += g.getValorPacote();
        }
    } 
    
    public void calcular(){
        porFornecedor = venda.getFornecedor().getPorcentagemPagamento();
        total = venda.getValorPacote();
        comissao = total * (porFornecedor / 100);
        porFunc = venda.getFuncionario().getComissao();
        comissaoFunc = total * (porFunc / 100);
    }
}
