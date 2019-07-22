package br.com.deposito.bean;

import br.com.deposito.dao.FormaPagamentoDao;
import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.domain.FormaPagamento;
import br.com.deposito.domain.PagamentoCartao;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFormaPagamento")
@ViewScoped
public class FormaPagamentoBean {

    private FormaPagamento forma;
    private ArrayList<FormaPagamento> lista;
    private ArrayList<FormaPagamento> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;   

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }

    public ArrayList<FormaPagamento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<FormaPagamento> lista) {
        this.lista = lista;
    }

    public ArrayList<FormaPagamento> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<FormaPagamento> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    //Aqui começa a implementação ---------------------------------------------------------------
    //Parte forma de pagamento----------------------------------------------------------------------------------
    public void listar() {
        FormaPagamentoDao dao = new FormaPagamentoDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar formas de pagamento " + ex);
        }
    }

    public void atualizarObjeto() {
        forma = new FormaPagamento();
    }

    public void salvar() {
        FormaPagamentoDao dao = new FormaPagamentoDao();
        try {
            forma.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(forma);
            JSFUtil.mensagemSucesso("Forma de pagamento registrada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar forma de pagamento" + ex);
        }
    }

    public void alterar() {
        FormaPagamentoDao dao = new FormaPagamentoDao();
        try {
            dao.Alterar(forma);
            JSFUtil.mensagemSucesso("Forma de pagamento alterada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar forma de pagamento " + ex);
        }
    }

    public void excluir() {
        FormaPagamentoDao dao = new FormaPagamentoDao();
        try {
            dao.excluir(forma);
            JSFUtil.mensagemSucesso("Forma de pagamento removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir forma ce pagamento " + ex);
        }
    }   
}
