package br.com.deposito.bean;

import br.com.deposito.dao.PagamentoDao;
import br.com.deposito.domain.Crediario;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBCrediario")
@ViewScoped
public class CrediarioBean {
    
    private ArrayList<Crediario> listaCrediario;
    private ArrayList<Crediario> listaCrediarioFiltrado;
    private Crediario crediario;
    private Date data1;
    private Date data2;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

    public ArrayList<Crediario> getListaCrediario() {
        if(listaCrediario == null){
            listaCrediario = new ArrayList<>();
        }
        return listaCrediario;
    }

    public void setListaCrediario(ArrayList<Crediario> listaCrediario) {
        this.listaCrediario = listaCrediario;
    }

    public ArrayList<Crediario> getListaCrediarioFiltrado() {
        if(listaCrediarioFiltrado == null){
            listaCrediarioFiltrado = new ArrayList<>();
        }
        return listaCrediarioFiltrado;
    }

    public void setListaCrediarioFiltrado(ArrayList<Crediario> listaCrediarioFiltrado) {
        this.listaCrediarioFiltrado = listaCrediarioFiltrado;
    }   

    public Crediario getCrediario() {
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
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
    
    //implementação--------------------------------------------------------------------------------
    
    public void listarCrediario() {
        PagamentoDao dao = new PagamentoDao();
        try {
            listaCrediario = dao.ListarCrediario(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar crediario " + ex);
        }
    }

    public void registrarRecebimento() {
        PagamentoDao dao = new PagamentoDao();
        try {
            crediario.setSituacao("Recebido");
            dao.InformarRecebimento(crediario);
            listarCrediario();
            JSFUtil.mensagemSucesso("Atualização realizada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro na alterção " + ex);
        }
    }

    public void excluir() {
        PagamentoDao dao = new PagamentoDao();
        try {
            dao.excluirCrediario(crediario);
            listarCrediario();
            JSFUtil.mensagemSucesso("Registro de crediario removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir cartao " + ex);
        }
    }

    public void somarQuantidade() {
        int valor = 0;
        if (listaCrediarioFiltrado.isEmpty()) {
            valor = listaCrediario.size();
        } else {
            valor = listaCrediarioFiltrado.size();
        }      
        JSFUtil.mensagemSucesso("Quantidade de crediários " + valor);
    }   
    
     public void somarAreceber() {     
        double venda = 0;
        if (listaCrediarioFiltrado.isEmpty()) {
            for (Crediario g : listaCrediario) {               
                venda += g.getVenda().getValor();
            }
        } else {
            for (Crediario v : listaCrediarioFiltrado) {             
               venda += v.getVenda().getValor();
            }
        }       
        String v = df.format(venda);
        JSFUtil.mensagemSucesso("Valor total R$ " + v);
    } 
}
