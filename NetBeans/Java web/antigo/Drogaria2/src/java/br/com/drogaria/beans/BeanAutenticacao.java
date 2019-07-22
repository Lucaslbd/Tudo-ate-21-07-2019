package br.com.drogaria.beans;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionarios;
import br.com.drogaria.util.JSFUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class BeanAutenticacao {
    
    private Funcionarios funcionarioLogado; 
    
    public Funcionarios getFuncionarioLogado() {
        if(funcionarioLogado == null){
            funcionarioLogado = new Funcionarios();
        }
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionarios funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public String entrar(){       
            FuncionarioDAO dao = new FuncionarioDAO();
            funcionarioLogado = dao.autenticar(funcionarioLogado.getCpf(),funcionarioLogado.getSenha());
            if(funcionarioLogado == null){
            JSFUtil.mensagemErro("Cpf e/ou senha invalidos");
            return null;
            }else{
             JSFUtil.mensagemSucesso("Olá "+funcionarioLogado.getNome() +" seu acesso foi autenticado com sucesso");
             return "Principal.xhtml?faces-redirect=true";           
            }           
    }
    
    public String sair(){
        funcionarioLogado= null;
        return "index.xhtml?faces-redirect=true";
    }
}
