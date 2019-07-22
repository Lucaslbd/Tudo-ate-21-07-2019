package br.com.vendas.bean;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBean {
    
    private ArrayList<Funcionario> ListaFuncionario;
    private ArrayList<Funcionario> ListaFuncionarioFiltrados;
    private Funcionario funcionario;

    public ArrayList<Funcionario> getListaFuncionario() {
        return ListaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }

    public ArrayList<Funcionario> getListaFuncionarioFiltrados() {
        return ListaFuncionarioFiltrados;
    }

    public void setListaFuncionarioFiltrados(ArrayList<Funcionario> ListaFuncionarioFiltrados) {
        this.ListaFuncionarioFiltrados = ListaFuncionarioFiltrados;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void atualizarObjeto() {
        funcionario = new Funcionario();
    }
    public void listar() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            ListaFuncionario = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar funcionarios " + ex);
        }
    }
    

    public void salvar() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.Salvar(funcionario);
            JSFUtil.mensagemSucesso("Funcionario salvo com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Cpf ja existente");
        }
    }
    public void alterar() {
         FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.Alterar(funcionario);
            JSFUtil.mensagemSucesso("Funcionario alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Cpf ja existente");
        }
    }
    
     public void excluir() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.excluir(funcionario);
            JSFUtil.mensagemSucesso("Funcionario removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover funcionario " + ex);
        }
    }
}
