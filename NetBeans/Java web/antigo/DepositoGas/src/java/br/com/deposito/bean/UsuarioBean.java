package br.com.deposito.bean;

import br.com.deposito.dao.UsuarioDao;
import br.com.deposito.domain.Usuario;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Usuario> listaUsuarioFiltrada;    
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public ArrayList<Usuario> getListaUsuarioFiltrada() {
        return listaUsuarioFiltrada;
    }

    public void setListaUsuarioFiltrada(ArrayList<Usuario> listaUsuarioFiltrada) {
        this.listaUsuarioFiltrada = listaUsuarioFiltrada;
    }

    // Aqui começa toda a implementação--------------------------------------------------------------
    public void listar() {
        UsuarioDao dao = new UsuarioDao();
        try {
            listaUsuario = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar usuarios " + ex);
        }
    }

    public void atualizarObjeto() {
        usuario = new Usuario();
    }

    public void salvar() {
        UsuarioDao dao = new UsuarioDao();
        try {
            usuario.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(usuario);
            JSFUtil.mensagemSucesso("Usuário registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar usuário" + ex);
        }
    }

    public void alterar() {
        UsuarioDao dao = new UsuarioDao();
        try {            
            dao.Alterar(usuario);
            JSFUtil.mensagemSucesso("Usuário alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar Usuário " + ex);
        }
    }

    public void excluir() {
        UsuarioDao dao = new UsuarioDao();
        try {
            dao.excluir(usuario);
            JSFUtil.mensagemSucesso("Usuario removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir usuário " + ex);
        }
    }
}
