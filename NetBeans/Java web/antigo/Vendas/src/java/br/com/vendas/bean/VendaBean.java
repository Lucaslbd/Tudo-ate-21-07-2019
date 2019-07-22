package br.com.vendas.bean;

import br.com.vendas.dao.FechamentoDao;
import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.dao.ItemDao;
import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.dao.VendasDao;
import br.com.vendas.domain.Fechamento;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Venda;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBVenda")
@ViewScoped
public class VendaBean {

    private ArrayList<Venda> ListaVenda;
    private ArrayList<Venda> ListaVendaFiltrada;
    private ArrayList<Item> ListaItens;
    private ArrayList<Funcionario> ListaFuncionario;
    private String codigoProduto;
    private int quantidade = 1;
    private Produto produto;
    private Venda venda;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticacao MBAutenticacao;
    private double ValorPagar;
    private int flag = 0;
    private Double valorPago;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private Date data;
    private Date data2;
    private Fechamento fechamento;
    private ArrayList<Fechamento> ListaFechamento;
    private String formaPagamento;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Fechamento> getListaFechamento() {

        return ListaFechamento;
    }

    public void setListaFechamento(ArrayList<Fechamento> ListaFechamento) {
        this.ListaFechamento = ListaFechamento;
    }

    public Fechamento getFechamento() {
        if (fechamento == null) {
            fechamento = new Fechamento();
        }
        return fechamento;
    }

    public void setFechamento(Fechamento fechamento) {
        this.fechamento = fechamento;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return ListaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorPagar() {
        return ValorPagar;
    }

    public void setValorPagar(double ValorPagar) {
        this.ValorPagar = ValorPagar;
    }

    public int getControlador() {
        return flag;
    }

    public void setControlador(int flag) {
        this.flag = flag;
    }

    public ArrayList<Venda> getListaVenda() {
        return ListaVenda;
    }

    public void setListaVenda(ArrayList<Venda> ListaVenda) {
        this.ListaVenda = ListaVenda;
    }

    public ArrayList<Venda> getListaVendaFiltrada() {
        return ListaVendaFiltrada;
    }

    public void setListaVendaFiltrada(ArrayList<Venda> ListaVendaFiltrada) {
        this.ListaVendaFiltrada = ListaVendaFiltrada;
    }

    public BeanAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public Venda getVenda() {
        if (venda == null) {
            venda = new Venda();
        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public ArrayList<Item> getListaItens() {
        return ListaItens;
    }

    public void setListaItens(ArrayList<Item> ListaItens) {
        this.ListaItens = ListaItens;
    }

    /*--------------------------------------------------------------------------------------*/
    public void cancelarVenda() {
        ListaItens = new ArrayList<>();
        ListaFechamento = new ArrayList<>();
        ValorPagar = 0;
        flag = 0;
        venda = new Venda();
        produto = new Produto();
         JSFUtil.mensagemSucesso("Venda cancelada com sucesso");
    }

    public void addItem() {
        if (ValorPagar > 0) {
            codigoProduto = "";
            JSFUtil.mensagemErro("Finalize a venda");
        } else {
            if (ListaItens == null) {
                ListaItens = new ArrayList<>();
            }
            if (venda == null) {
                venda = new Venda();
                venda.setValor(0);
            }
            ProdutoDao daoProduto = new ProdutoDao();

            produto = daoProduto.buscarCodigo(codigoProduto);

            if (produto == null) {
                JSFUtil.mensagemErro("Produto não cadastrado");
                codigoProduto = "";
                quantidade = 1;
            } else if (produto.getEstoque() - quantidade < 0) {
                JSFUtil.mensagemErro("Exite somente " + produto.getEstoque() + " unidades não é possivel proseguir");
                codigoProduto = "";
                quantidade = 1;
            } else {
                int PosicaoEncontrada = -1;
                for (int i = 0; i < ListaItens.size() && PosicaoEncontrada < 0; i++) {
                    Item comparacao = ListaItens.get(i);

                    if (comparacao.getProduto().getCodigo().equals(produto.getCodigo())) {
                        PosicaoEncontrada = i;
                    }
                }
                Item item = new Item();
                item.setProduto(produto);
                if (PosicaoEncontrada < 0) {
                    item.setQuantidade(quantidade);
                    item.setValor(produto.getPreco() * quantidade);
                    ListaItens.add(0, item);
                    venda.setValor(venda.getValor() + (produto.getPreco() * quantidade));
                } else {
                    Item itemTemp = ListaItens.get(PosicaoEncontrada);
                    if (produto.getEstoque() - (itemTemp.getQuantidade() + quantidade) < 0) {
                        JSFUtil.mensagemErro("Não existe mais estoque");
                    } else {
                        item.setQuantidade(itemTemp.getQuantidade() + quantidade);
                        item.setValor(itemTemp.getValor() + (produto.getPreco() * quantidade));
                        ListaItens.set(PosicaoEncontrada, item);
                        venda.setValor(venda.getValor() + (produto.getPreco() * quantidade));
                    }
                }
                quantidade = 1;
                codigoProduto = "";
            }
        }
    }

    /*--------------------------------------------------------------------------------------*/
    public void remover(Item remover){
        int PosicaoEncontrada = -1;
        for (int i = 0; i < ListaItens.size() && PosicaoEncontrada < 0; i++) {
            Item novaLista = ListaItens.get(i);
            if (novaLista.getProduto().equals(remover.getProduto())) {
                PosicaoEncontrada = i;
            }
        }
        if (PosicaoEncontrada > -1) {
            ListaItens.remove(PosicaoEncontrada);
            venda.setValor(venda.getValor() - remover.getValor());
            JSFUtil.mensagemSucesso("Item removido com sucesso");
        }
    }

    public void atribuiValor() {
        if (flag == 0) {
            ValorPagar = venda.getValor();
        }
    }

    public double teste() {
        ValorPagar -= valorPago;
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(ValorPagar);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double Final = Double.parseDouble(string2);
        flag = 1;
        valorPago = null;
        return Final;
    }

    public double ArrumaDouble(double d) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(d);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double Final = Double.parseDouble(string2);
        return Final;
    }

    public void salvar() {
        if (venda.getValor() == 0) {
            JSFUtil.mensagemSucesso("Não existem itens para finalizar");
            valorPago = null;

        } else {
            fechamento = new Fechamento();
            if (valorPago >= ValorPagar) {
                double salvar = ArrumaDouble(ValorPagar);
                fechamento.setValor_fechamento(salvar);
            } else {
                double salvar = ArrumaDouble(valorPago);
                fechamento.setValor_fechamento(salvar);
            }
            fechamento.setSituacao("Aberto");
            fechamento.setPagamento(formaPagamento);

            if (ListaFechamento == null) {
                ListaFechamento = new ArrayList<>();
            }
            ListaFechamento.add(fechamento);
            double continua = teste();
            String dx = df.format(continua);

            if (continua <= 0) {
                JSFUtil.mensagemSucesso("Troco para o cliente R$ " + dx);
                VendasDao dao = new VendasDao();
                venda.setData(new Date());
                venda.setFuncionario(MBAutenticacao.getFuncionarioLogado());
                try {
                    dao.Salvar(venda);
                    Venda vendafk = dao.Ultimoregistro();
                    for (Item item : ListaItens) {
                        item.setVenda(vendafk);
                        ItemDao itemdao = new ItemDao();
                        itemdao.Salvar(item);
                        String codigoP = item.getProduto().getCodigo();
                        ProdutoDao d = new ProdutoDao();
                        Produto p = d.buscarCodigo(codigoP);
                        p.setEstoque(p.getEstoque() - item.getQuantidade());
                        d.DarBaixa(p);
                    }
                    for (Fechamento f : ListaFechamento) {
                        f.setVenda(vendafk);
                        FechamentoDao fDao = new FechamentoDao();
                        fDao.Salvar(f);
                    }
                    ListaFechamento = new ArrayList<>();
                    ListaItens = new ArrayList<>();
                    venda = new Venda();
                    flag = 0;
                    valorPago = null;
                    ValorPagar = 0;
                    produto.setDescricao("");
                    JSFUtil.mensagemSucesso("Venda finalizada com sucesso");

                } catch (SQLException ex) {
                    JSFUtil.mensagemErro("Erro ao finalizar venda" + ex);
                }
            } else {
                JSFUtil.mensagemErro("Ainda falta pagar R$ " + dx);

            }
        }
    }

    public void excluirItem() {
        ItemDao dao = new ItemDao();
        try {
            dao.excluir(venda);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("erro ao remover itens");
        }
    }

    public void excluir() {
        VendasDao dao = new VendasDao();
        try {
            excluirItem();
            dao.excluir(venda);
            listarPorData2();
            JSFUtil.mensagemSucesso("Venda removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("A venda não pode ser removida antes remova seus itens");
        }
    }

    public void listarFuncionario() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            ListaFuncionario = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar funcionarios " + ex);
        }
    }

    public void listarPorData() {
        if (data == null || data2 == null) {
            JSFUtil.mensagemErro("Digite a data de inicio e fina da pesquisa");
        } else {

            ValorPagar = 0;
            VendasDao dao = new VendasDao();
            try {
                ListaVenda = dao.ListarPorData(data, data2);
                for (Venda v : ListaVenda) {
                    ValorPagar += v.getValor();
                }
                listarFuncionario();
                JSFUtil.mensagemSucesso("Pesquisa efetuada com sucesso");
            } catch (SQLException ex) {
                JSFUtil.mensagemErro("Erro ao listar" + ex);
            }
        }
    }

    public void listarPorData2() {
        if (data == null || data2 == null) {
            JSFUtil.mensagemErro("Digite a data de inicio e fina da pesquisa");
        } else {

            ValorPagar = 0;
            VendasDao dao = new VendasDao();
            try {
                ListaVenda = dao.ListarPorData(data, data2);
                for (Venda v : ListaVenda) {
                    ValorPagar += v.getValor();
                }
                listarFuncionario();
            } catch (SQLException ex) {
                JSFUtil.mensagemErro("Erro ao listar" + ex);
            }
        }
    }

    public void valorFiltrado() {
        ValorPagar = 0;
        for (Venda v : ListaVendaFiltrada) {
            ValorPagar += v.getValor();
        }
    }

    /*public static void main(String[]args){
        VendaBean bean = new VendaBean();
        bean.listarPorData();
    }*/
}
