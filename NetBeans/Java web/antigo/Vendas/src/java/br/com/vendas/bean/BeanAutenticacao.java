package br.com.vendas.bean;


import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.domain.Empresa;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class BeanAutenticacao {
    
    private Funcionario funcionarioLogado; 
    private Empresa empresa;

    public Empresa getEmpresa() {
        if(empresa == null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public Funcionario getFuncionarioLogado() {
        if(funcionarioLogado == null){
            funcionarioLogado = new Funcionario();
        }
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public String entrar(){       
            FuncionarioDao dao = new FuncionarioDao();
            funcionarioLogado = dao.autenticar(funcionarioLogado);
            if(funcionarioLogado == null){
            JSFUtil.mensagemErro("Cpf e/ou senha invalidos");
            return null;
            }else{
             empresa = dao.chamaEmpresa();
             JSFUtil.mensagemSucesso("Olá "+funcionarioLogado.getNome() +" seu acesso foi autenticado com sucesso");
             return "Principal.xhtml?faces-redirect=true";           
            }           
    }
    
    public String sair(){
        funcionarioLogado= null;
        return "index.xhtml?faces-redirect=true";
    }
    public void alterarEmpresa() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.AlteraEmpresa(empresa);
            JSFUtil.mensagemSucesso("Empresa alterada com sucesso");            
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar empresa " + ex);
        }
    }
    public void verificar(){
        JSFUtil.mensagemSucesso(""+empresa); 
    }
}
