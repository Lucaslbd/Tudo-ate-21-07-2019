
package br.com.deposito.bean;

import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.domain.PagamentoCartao;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBCartao")
@ViewScoped
public class CartaoBean {
    
    private ArrayList<PagamentoCartao> listaCartao;
    private ArrayList<PagamentoCartao> listaCartaoFiltrada;
    private PagamentoCartao cartao;
    private Date data1;
    private Date data2;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
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

    public ArrayList<PagamentoCartao> getListaCartao() {
        if (listaCartao == null) {
            listaCartao = new ArrayList<>();
        }
        return listaCartao;
    }

    public void setListaCartao(ArrayList<PagamentoCartao> listaCartao) {
        this.listaCartao = listaCartao;
    }

    public ArrayList<PagamentoCartao> getListaCartaoFiltrada() {
        if (listaCartaoFiltrada == null) {
            listaCartaoFiltrada = new ArrayList<>();
        }
        return listaCartaoFiltrada;
    }

    public void setListaCartaoFiltrada(ArrayList<PagamentoCartao> listaCartaoFiltrada) {
        this.listaCartaoFiltrada = listaCartaoFiltrada;
    }

    public PagamentoCartao getCartao() {
        return cartao;
    }

    public void setCartao(PagamentoCartao cartao) {
        this.cartao = cartao;
    }
    
    //implementação--------------------------------------------------------------------------------
    
    public void listarCartoes() {
        PagamentoDao dao = new PagamentoDao();
        try {
            listaCartao = dao.ListarCartao(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar pagamentos em cartão " + ex);
        }
    }

    public void registrarRecebimento() {
        PagamentoDao dao = new PagamentoDao();
        try {            
            dao.registrarRecebimento(cartao);
            listarCartoes();
            JSFUtil.mensagemSucesso("Atualização realizada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro na alterção " + ex);
        }
    }

    public void excluirCartao() {
        PagamentoDao dao = new PagamentoDao();
        try {
            dao.excluirCartao(cartao);
            listarCartoes();
            JSFUtil.mensagemSucesso("Registro de cartão removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir cartao " + ex);
        }
    }

    public void somarVenda() {
        double valor = 0;
        if (listaCartaoFiltrada.isEmpty()) {
            for (PagamentoCartao g : listaCartao) {
                valor += g.getVenda().getValor();
            }
        } else {
            for (PagamentoCartao v : listaCartaoFiltrada) {
                valor += v.getVenda().getValor();
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Valor total sem descontos R$ " + v);
    }

    public void somarAreceber() {
        double valor = 0;
        if (listaCartaoFiltrada.isEmpty()) {
            for (PagamentoCartao g : listaCartao) {
                double diminuir = g.getVenda().getValor() * (g.getVenda().getDesconto() / 100);
                valor += g.getVenda().getValor() - diminuir;
            }
        } else {
            for (PagamentoCartao g : listaCartaoFiltrada) {
                double diminuir = g.getVenda().getValor() * (g.getVenda().getDesconto() / 100);
                valor += g.getVenda().getValor() - diminuir;
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Valor total a receber R$ " + v);
    }

    public void somarDesconto() {
        double valor = 0;
        if (listaCartaoFiltrada.isEmpty()) {
            for (PagamentoCartao g : listaCartao) {
                double diminuir = g.getVenda().getValor() * (g.getVenda().getDesconto() / 100);
                valor += diminuir;
            }
        } else {
            for (PagamentoCartao g : listaCartaoFiltrada) {
                double diminuir = g.getVenda().getValor() * (g.getVenda().getDesconto() / 100);
                valor += diminuir;
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Valor total de desconto R$ " + v);
    }

    public void somarRegistros() {
        if (listaCartaoFiltrada.isEmpty()) {
            int i = listaCartao.size();
            JSFUtil.mensagemSucesso("Numero de registros " + i);
        } else {
            int i = listaCartaoFiltrada.size();
            JSFUtil.mensagemSucesso("Numero de registros " + i);
        }
    }
}
