package br.com.deposito.bean;

import br.com.deposito.dao.AutonomiaDao;
import br.com.deposito.dao.ClienteDao;
import br.com.deposito.dao.FechamentoCaixaDao;
import br.com.deposito.dao.FormaPagamentoDao;
import br.com.deposito.dao.ItemDao;
import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.dao.VendaDao;
import br.com.deposito.domain.Autonomia;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.Crediario;
import br.com.deposito.domain.FormaPagamento;
import br.com.deposito.domain.HistoricoCliente;
import br.com.deposito.domain.Item;
import br.com.deposito.domain.ItemNota;
import br.com.deposito.domain.PagamentoCartao;
import br.com.deposito.domain.Produto;
import br.com.deposito.domain.Veiculos;
import br.com.deposito.domain.Venda;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFrenteCaixa")
@ViewScoped
public class FrenteCaixaBean {

    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private ArrayList<Produto> listaProduto;
    private ArrayList<Item> listaItem;
    private ArrayList<Veiculos> listaVeiculo;
    private ArrayList<FormaPagamento> listaFormaPagamento;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private Produto produto;
    private int quantidade = 1;
    private String casco;
    private String valorTotal = "00,00";
    private boolean finaliza = true;
    private FormaPagamento pagamento;
    private boolean controlaEntrega = false;
    private String entrega;
    private double valorAlterar;
    private int indexAlterar;
    private Item itemAlterar;
    private boolean crediario = false;
    private ArrayList<Cliente> listaCliente;
    private Cliente cliente;
    private Date data;
    private Veiculos veiculo;

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public boolean isCrediario() {
        return crediario;
    }

    public void setCrediario(boolean crediario) {
        this.crediario = crediario;
    }

    public int getIndexAlterar() {
        return indexAlterar;
    }

    public void setIndexAlterar(int indexAlterar) {
        this.indexAlterar = indexAlterar;
    }

    public Item getItemAlterar() {
        return itemAlterar;
    }

    public void setItemAlterar(Item itemAlterar) {
        this.itemAlterar = itemAlterar;
    }

    public double getValorAlterar() {
        return valorAlterar;
    }

    public void setValorAlterar(double valorAlterar) {
        this.valorAlterar = valorAlterar;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public boolean isControlaEntrega() {
        return controlaEntrega;
    }

    public void setControlaEntrega(boolean controlaEntrega) {
        this.controlaEntrega = controlaEntrega;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public boolean isFinaliza() {
        return finaliza;
    }

    public void setFinaliza(boolean finaliza) {
        this.finaliza = finaliza;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ArrayList<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public ArrayList<Veiculos> getListaVeiculo() {
        return listaVeiculo;
    }

    public void setListaVeiculo(ArrayList<Veiculos> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    public ArrayList<FormaPagamento> getListaFormaPagamento() {
        return listaFormaPagamento;
    }

    public void setListaFormaPagamento(ArrayList<FormaPagamento> listaFormaPagamento) {
        this.listaFormaPagamento = listaFormaPagamento;
    }
    //aqui começa a implementação------------------------------------------------------------------

    public void preencherObjetos() {
        ProdutoDao dao1 = new ProdutoDao();
        VeiculoDao dao2 = new VeiculoDao();
        FormaPagamentoDao dao3 = new FormaPagamentoDao();
        ClienteDao dao4 = new ClienteDao();
        try {
            listaProduto = dao1.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            listaVeiculo = dao2.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            listaFormaPagamento = dao3.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            listaCliente = dao4.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar " + ex);
        }
    }

    public void adicionar() {
        if (listaItem == null) {
            listaItem = new ArrayList<>();
        }
        int estoque = 0;
        for (Item l : listaItem) {
            if (produto.equals(l.getProduto())) {
                estoque += l.getQuantdade();
            }
        }
        if (produto.getEstoqueCheio() - estoque - quantidade < 0) {
            JSFUtil.mensagemErro("Não existem mais estoque desse produto");
        } else {
            Item item = new Item();
            item.setProduto(produto);
            item.setQuantdade(quantidade);
            if (casco.equals("Sem casco")) {
                item.setValor(produto.getValorPortaria() * quantidade);
                item.setCusto(produto.getCustoProduto() * quantidade);
                item.setCasco("Sem casco");
            } else {
                item.setValor((produto.getValorPortaria() + produto.getValorCasco()) * quantidade);
                item.setCusto((produto.getCustoProduto() + produto.getCustoCasco()) * quantidade);
                item.setCasco("Com casco");
            }
            listaItem.add(item);
            double valor = 0;
            for (Item i : listaItem) {
                valor += i.getValor();
            }
            valorTotal = df.format(valor);
            quantidade = 1;
        }
    }

    public void finalizaLista() {
        if (listaItem == null || listaItem.isEmpty()) {
            JSFUtil.mensagemErro("Não existem itens para finalizar");
        } else {
            finaliza = false;
        }
    }

    public void verEntrega() {
        controlaEntrega = entrega.equals("Com entrega");
        addEntrega();
    }

    public void cancelar() {
        finaliza = true;
        controlaEntrega = false;
        crediario = false;
        valorTotal = "00,00";
        entrega = "";
        casco = "";
        listaItem = new ArrayList<>();
        pagamento = new FormaPagamento();
        produto = new Produto();
        cliente = new Cliente();
        data = null;
    }

    public void finalizar() {
        VendaDao daoVenda = new VendaDao();
        ItemDao daoItem = new ItemDao();
        Venda venda = new Venda();
        venda.setData(new Date());
        venda.setDeposito(MBAutenticacao.getUsuario().getDeposito());
        venda.setEntrega(entrega);
        double valor = 0;
        double custo = 0;
        for (Item t : listaItem) {
            valor += t.getValor();
            custo += t.getCusto();
        }
        venda.setFormaPagamento(pagamento.getTipo());
        venda.setValor(valor);
        venda.setCusto(custo);
        venda.setDesconto(pagamento.getDesconto());
        try {
            daoVenda.Salvar(venda);
            FechamentoCaixaDao daoFecha = new FechamentoCaixaDao();
            Venda UltimoRegistro = daoVenda.Ultimoregistro(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            daoFecha.AlterarFechamento(UltimoRegistro);
            for (Item t : listaItem) {
                t.setVenda(UltimoRegistro);
                daoItem.Salvar(t);
                daoItem.baixaVenda(t);
                ItemNota itemNota = daoItem.PegaUtilizar(t);
                if (itemNota != null) {
                    itemNota.setUtilizados(itemNota.getUtilizados() + t.getQuantdade());
                    daoItem.AlterarUtilizados(itemNota);
                }
            }
            if (cliente != null) {
                HistoricoCliente historico = new HistoricoCliente();
                historico.setCliente(cliente);
                historico.setVenda(UltimoRegistro);
                ClienteDao dao = new ClienteDao();
                dao.SalvarHistorico(historico);
            }
            if (controlaEntrega) {
                AutonomiaDao autonomiaDao = new AutonomiaDao();
                Autonomia autonomia = autonomiaDao.Ultimoregistro(veiculo.getCodigo());
                if (autonomia == null) {
                    JSFUtil.mensagemErro("Não foi possivel registrar autonomia pois não existe abastecimentos para este veiculo");
                } else {
                    autonomia.setEntregas(autonomia.getEntregas() + 1);
                    autonomiaDao.fazerAutonomia(autonomia);
                }
            }
            gravaPagamento(UltimoRegistro);
            JSFUtil.mensagemSucesso("Venda finalizada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao salvar venda " + ex);
        }
        cancelar();
    }

    public void gravaPagamento(Venda venda) {
        PagamentoDao dao = new PagamentoDao();
        try {
            if (pagamento.getTipo().equals("Cartão de credito") || pagamento.getTipo().equals("Cartão de débito")) {
                PagamentoCartao cartao = new PagamentoCartao();
                cartao.setDescricao(pagamento.getTipo());
                cartao.setSituacao("A receber");
                cartao.setVenda(venda);
                dao.SalvarPagamentoCartao(cartao);
            } else if (pagamento.getTipo().equals("Crediário")) {
                Crediario credi = new Crediario();
                credi.setSituacao("A receber");
                credi.setCliente(cliente);
                credi.setVenda(venda);
                credi.setData(data);
                dao.SalvarCrediario(credi);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao salvar pagamento " + ex);
        }
    }

    public void remover(int index) {
        listaItem.remove(index);
        double valor = 0;
        for (Item i : listaItem) {
            valor += i.getValor();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
        JSFUtil.mensagemSucesso("Item removido com sucesso");
    }

    public void recebe(Item item, int index) {
        indexAlterar = index;
        itemAlterar = item;
    }

    public void alterar() {
        itemAlterar.setValor(valorAlterar);
        listaItem.set(indexAlterar, itemAlterar);
        valorAlterar = 0;
        double valor = 0;
        for (Item i : listaItem) {
            valor += i.getValor();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
        JSFUtil.mensagemSucesso("Item alterado com sucesso");
    }

    public void aceitaCrediario() {
        if (pagamento.getTipo().equals("Crediário")) {
            crediario = true;
            if (controlaEntrega) {
                for (int i = 0; i < listaItem.size(); i++) {
                    Item item = listaItem.get(i);
                    if (casco.equals("Com casco")) {
                        item.setValor((item.getProduto().getValorPortaria() + item.getProduto().getValorPrazo() + item.getProduto().getValorCasco()) * item.getQuantdade() + item.getProduto().getValorEntrega());
                    } else {
                        item.setValor((item.getProduto().getValorPortaria() + item.getProduto().getValorPrazo()) * item.getQuantdade() + item.getProduto().getValorEntrega());
                    }
                    listaItem.set(i, item);
                }
            } else {
                for (int i = 0; i < listaItem.size(); i++) {
                    Item item = listaItem.get(i);
                    if (casco.equals("Com casco")) {
                        item.setValor((item.getProduto().getValorPortaria() + item.getProduto().getValorPrazo() + item.getProduto().getValorCasco()) * item.getQuantdade());
                    } else {
                        item.setValor((item.getProduto().getValorPortaria() + item.getProduto().getValorPrazo()) * item.getQuantdade());
                    }
                    listaItem.set(i, item);
                }
            }
        } else {
            crediario = false;
            if (controlaEntrega) {
                for (int i = 0; i < listaItem.size(); i++) {
                    Item item = listaItem.get(i);
                    if (casco.equals("Com casco")) {
                        item.setValor((item.getProduto().getValorPortaria() + item.getProduto().getValorCasco()) * item.getQuantdade() + item.getProduto().getValorEntrega());
                    } else {
                        item.setValor((item.getProduto().getValorPortaria()) * item.getQuantdade() + item.getProduto().getValorEntrega());
                    }
                    listaItem.set(i, item);
                }
            } else {
                for (int i = 0; i < listaItem.size(); i++) {
                    Item item = listaItem.get(i);
                    if (casco.equals("Com casco")) {
                        item.setValor(item.getProduto().getValorPortaria() + item.getProduto().getValorCasco() * item.getQuantdade());
                    } else {
                        item.setValor(item.getProduto().getValorPortaria() * item.getQuantdade());
                    }
                    listaItem.set(i, item);
                }
            }
        }
        double valor = 0;
        for (Item i : listaItem) {
            valor += i.getValor();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
    }

    public void addEntrega() {
        if (controlaEntrega) {
            for (int i = 0; i < listaItem.size(); i++) {
                Item item = listaItem.get(i);
                item.setValor(item.getValor() + item.getProduto().getValorEntrega());
                listaItem.set(i, item);
            }
        } else {
            for (int i = 0; i < listaItem.size(); i++) {
                Item item = listaItem.get(i);
                item.setValor(item.getValor() - item.getProduto().getValorEntrega());
                listaItem.set(i, item);
            }
        }
        double valor = 0;
        for (Item i : listaItem) {
            valor += i.getValor();
        }
        valorTotal = df.format(valor);
        quantidade = 1;
    }

}
