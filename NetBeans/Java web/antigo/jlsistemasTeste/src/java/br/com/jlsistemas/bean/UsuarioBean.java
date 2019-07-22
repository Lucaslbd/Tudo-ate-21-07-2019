package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.UsuarioDao;
import br.com.jlsistemas.domain.Usuario;
import br.com.jlsistemas.util.BeanAutenticar;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
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

    public void atualizarObjeto() {
        usuario = new Usuario();
    }

    public void salvar() {
        UsuarioDao dao = new UsuarioDao();
        try {
            usuario.setEmpresa(MBAutenticacao.getEmpresa());
            dao.salvar(usuario);
            JSFUtil.mensagemSucesso("Usuário registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Este cpf já pertence a um usuário existente");
        }
    }
}
