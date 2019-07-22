package br.com.deposito.bean;

import br.com.deposito.dao.FechamentoCaixaDao;
import br.com.deposito.domain.FechamentoCaixa;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFechamentoCaixa")
@ViewScoped
public class FechamentoCaixaBean {

    private FechamentoCaixa fechamento;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<FechamentoCaixa> lista;
    private double troco;

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public ArrayList<FechamentoCaixa> getLista() {
        return lista;
    }

    public void setLista(ArrayList<FechamentoCaixa> lista) {
        this.lista = lista;
    }

    public FechamentoCaixa getFechamento() {
        return fechamento;
    }

    public void setFechamento(FechamentoCaixa fechamento) {
        this.fechamento = fechamento;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public void listar() {
        lista = new ArrayList<>();
        FechamentoCaixaDao dao = new FechamentoCaixaDao();
        fechamento = dao.buscarCodigo(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        lista.add(fechamento);
    }

    public void reiniciar() {
        FechamentoCaixaDao dao = new FechamentoCaixaDao();
        try {
            dao.Reiniciar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
            listar();
        } catch (SQLException ex) {
           JSFUtil.mensagemErro("Erro ao reiniciar " + ex);
        }
    }
    
    public void mudaTroco(){
       FechamentoCaixaDao dao = new FechamentoCaixaDao();
        try {
            dao.troco(troco,MBAutenticacao.getUsuario().getDeposito().getCodigo());
            listar();
            troco = 0;
        } catch (SQLException ex) {
           JSFUtil.mensagemErro("Erro ao alterar troco " + ex);
        } 
    }
}
