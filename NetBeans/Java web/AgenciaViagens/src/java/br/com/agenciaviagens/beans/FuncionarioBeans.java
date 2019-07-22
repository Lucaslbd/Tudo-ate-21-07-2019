package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.FuncionarioDao;
import br.com.agenciaviagens.dao.VendaDao;
import br.com.agenciaviagens.domain.Funcionario;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.ralatorio.FolhaPagamento;
import br.com.agenciaviagens.ralatorio.FolhaPagamentoDao;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBeans {

    private int codigo;
    private int acao;
    private Funcionario funcionario;
    private ArrayList<Funcionario> lista;
    private ArrayList<Funcionario> listaFiltrada;
    private ArrayList<Venda> listaVenda;
    private double valor;
    private double comissao;
    private double total;
    private double taxas;
    private Venda venda;
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double getTaxas() {
        return taxas;
    }

    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public ArrayList<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Funcionario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Funcionario> lista) {
        this.lista = lista;
    }

    public ArrayList<Funcionario> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Funcionario> listaFiltrada) {
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
        FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(funcionario);
            JSFUtil.mensagemSucesso("Funcionário registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarios.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao registrar funcionário" + ex);
        }
    }

    public void alterar() {
        FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(funcionario);
            JSFUtil.mensagemSucesso("Funcionário alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarios.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemSucesso("Erro ao alterar funcionário" + ex);
        }
    }

    public void excluir(int c) {
        FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Funcionário removido com sucesso");          
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao excluir funcionário" + ex);
        }
    }

    public void listar() {
        FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar funcionário" + ex);
        }
    }

    public void buscarVendas() {
        VendaDao daov = new VendaDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaVenda = daov.buscarFuncionario(codigo, data1, data2);
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
            comissao += g.getComissaoFunc();
            valor += g.getValorPacote();
            total += g.getValorPacote() + g.getTaxas();
            taxas += g.getTaxas();
            index++;
        }
        JSFUtil.mensagemSucesso("Foram encontrados " + index + " registros");
    }

    public void carregarCadastro() {
        FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                funcionario = new Funcionario();
            } else {
                funcionario = dao.buscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar funcionário por codigo " + ex);
        }
    }

    public void imprimirFolhaPagamento() {
        if (listaVenda == null) {
            listaVenda = new ArrayList<>();
        }
        UtilitarioDao util = new UtilitarioDao();
        FolhaPagamento folha = new FolhaPagamento();
        double comissaoFunc = 0;
        double salario = funcionario.getSalario();
        double porcentagemInss = 0;
        double inss = 0;
        double irrf = 0;
        double porcentagemIrrf = 0;
        double baseIrrf;
        for (Venda v : listaVenda) {
            comissaoFunc += v.getComissaoFunc();
        }
        double salarioTotal = comissaoFunc + salario;
        double baseInss = 0;
        //calculo do inss        
        if (salarioTotal < 1693.72) {
            porcentagemInss = 8;
            inss = salarioTotal * (8. / 100.);
            baseInss = comissaoFunc + salario;
        } else if (salarioTotal > 1693.72 && salarioTotal < 2822.90) {
            porcentagemInss = 9;
            inss = salarioTotal * (9. / 100.);
            baseInss = comissaoFunc + salario;
        } else if (salarioTotal > 2822.90 && salarioTotal < 5645.80) {
            porcentagemInss = 11;
            inss = salarioTotal * (11. / 100.);
            baseInss = comissaoFunc + salario;
        } else if (salarioTotal > 5645.80) {
            porcentagemInss = 11;
            inss = 5645.80 * (11. / 100.);
            baseInss = 5645.80;
        }
        //fim do calculo do inss
        //calculo irrf
        baseIrrf = salarioTotal - inss;
        if (baseIrrf < 1903.98) {
            irrf = 0;
            porcentagemIrrf = 0;
        } else if (baseIrrf > 1903.98 && baseIrrf < 2826.65) {
            irrf = (baseIrrf * (7.5 / 100.)) - 142.80;
            porcentagemIrrf = 7.5;
        } else if (baseIrrf > 2826.65 && baseIrrf < 3751.05) {
            irrf = (baseIrrf * (15. / 100.)) - 354.80;
            porcentagemIrrf = 15;
        } else if (baseIrrf > 3751.05 && baseIrrf < 4664.68) {
            irrf = (baseIrrf * (22.5 / 100.)) - 636.13;
            porcentagemIrrf = 22.5;
        } else if (baseIrrf > 4664.68) {
            irrf = (baseIrrf * (27.5 / 100.)) - 869.36;
            porcentagemIrrf = 27.5;
        }
        //fim co calculo  de irrf;
        ArrayList<FolhaPagamento> listaFolha = new ArrayList<>();
        folha.setBasefgts(salarioTotal);
        folha.setBaseinss(baseInss);
        folha.setBaseirrf(baseIrrf);
        folha.setComissao(comissaoFunc);
        folha.setFgts(salarioTotal * (8. / 100.));
        folha.setFuncao("Função: " + funcionario.getCargo());
        folha.setInss(inss);
        folha.setIrrf(irrf);
        folha.setNome(funcionario.getNome());
        folha.setPorfgts(8);
        folha.setPorinss(porcentagemInss);
        folha.setPorirrf(porcentagemIrrf);
        folha.setPagamento(salario);
        folha.setTotal(salarioTotal - inss - irrf);
        folha.setCnpj(MBAutenticacao.getEmpresa().getCnpj());
        folha.setEmpresa(MBAutenticacao.getEmpresa().getNomeEmpresa());
        folha.setImpressao(util.dateXstring(new Date()));
        folha.setTelefone(MBAutenticacao.getEmpresa().getTelefone());
        folha.setCpf("Cpf: " + funcionario.getCpf());
        folha.setSoma(salarioTotal);
        if (data1 == null || data2 == null) {
            folha.setData1("Data não especificada");
        } else {
            folha.setData1(util.dateXstring(data1) + " a " + util.dateXstring(data2));
        }
        listaFolha.add(folha);
        FolhaPagamentoDao d = new FolhaPagamentoDao();
        try {
            d.Imprimir(listaFolha);
        } catch (IOException | JRException ex) {
            JSFUtil.mensagemErro("Erro ao gerar folha de pagamento " + ex);
        }
    }
}
