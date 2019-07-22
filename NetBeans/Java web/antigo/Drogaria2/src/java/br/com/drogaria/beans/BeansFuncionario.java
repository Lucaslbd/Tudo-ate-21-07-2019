package br.com.drogaria.beans;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionarios;
import br.com.drogaria.util.JSFUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class BeansFuncionario {
    
    private Funcionarios funcionario;
    private List <Funcionarios> ListaFuncionarios;
    private List <Funcionarios> ListaFuncionariosFiltrados;

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionarios> getListaFuncionarios() {
        return ListaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionarios> ListaFuncionarios) {
        this.ListaFuncionarios = ListaFuncionarios;
    }

    public List<Funcionarios> getListaFuncionariosFiltrados() {
        return ListaFuncionariosFiltrados;
    }

    public void setListaFuncionariosFiltrados(List<Funcionarios> ListaFuncionariosFiltrados) {
        this.ListaFuncionariosFiltrados = ListaFuncionariosFiltrados;
    }
    
    public void renovarObjeto(){
    funcionario = new Funcionarios();
    }
    public void salvar() {
        try {
             FuncionarioDAO dao = new FuncionarioDAO();
             dao.Salvar(funcionario);
            JSFUtil.mensagemSucesso("Funcionario adicionado com sucesso");
            funcionario = new Funcionarios();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Não foi possivel registrar o funcionario pois ele ja esta cadastrado");
        }
    }
    
    public void carregar(){
        try{
            FuncionarioDAO dao = new FuncionarioDAO();
            ListaFuncionarios = dao.listar();
        }catch(RuntimeException ex){
             JSFUtil.mensagemErro("Erro ao carregar funcionarios" + ex.getMessage());
        }
    }
    public void excluir() {
        try {
             FuncionarioDAO dao = new FuncionarioDAO();
             dao.Excluir(funcionario);
             JSFUtil.mensagemSucesso("Funcionario excluido com sucesso");
             funcionario = new Funcionarios();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("O funcionario não pode ser excluido pois existem vendas a ele relacionados");
        }
    }
    public void alterar() {
        try {
             FuncionarioDAO dao = new FuncionarioDAO();
             dao.Editar(funcionario);
             JSFUtil.mensagemSucesso("Funcionario alterado com sucesso");
             funcionario = new Funcionarios();
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao tentar alterar funcionario" + ex.getMessage());
        }
    }
}
