package br.com.deposito.bean;

import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.domain.Veiculos;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBVeiculo")
@ViewScoped
public class VeiculoBean {
    
    Veiculos veiculo;
    ArrayList<Veiculos> lista;
    ArrayList<Veiculos> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao; 

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public ArrayList<Veiculos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Veiculos> lista) {
        this.lista = lista;
    }

    public ArrayList<Veiculos> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Veiculos> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }
    
    //Aqui começa a implementação---------------------------------------------------------
    
    public void listar() {
        VeiculoDao dao = new VeiculoDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar veiculos " + ex);
        }
    }

    public void atualizarObjeto() {
        veiculo = new Veiculos();        
    }

    public void salvar() {
         VeiculoDao dao = new VeiculoDao();
        try {
            veiculo.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(veiculo);
            JSFUtil.mensagemSucesso("Veiculo registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar veiculo" + ex);
        }
    }

    public void alterar() {
           VeiculoDao dao = new VeiculoDao();    
        try {
            dao.Alterar(veiculo);
            JSFUtil.mensagemSucesso("veiculo alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar veiculo " + ex);
        }
    }

    public void excluir() {
          VeiculoDao dao = new VeiculoDao();
        try {
            dao.excluir(veiculo);
            JSFUtil.mensagemSucesso("veiculo removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir veiculo " + ex);
        }
    }
}
