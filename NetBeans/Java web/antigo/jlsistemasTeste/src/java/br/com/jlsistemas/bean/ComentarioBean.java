package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.ComentarioDao;
import br.com.jlsistemas.domain.Comentario;
import br.com.jlsistemas.util.BeanAutenticar;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBComentario")
@ViewScoped
public class ComentarioBean {

    private Comentario comentario;   
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }    

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }
    
     public void atualizarObjeto() {
        comentario = new Comentario();
    }
    
    public void salvar() {
        ComentarioDao dao = new ComentarioDao();
        try {
            comentario.setEmpresa(MBAutenticacao.getEmpresa());
            comentario.setData(new Date());
            dao.Salvar(comentario);
            JSFUtil.mensagemSucesso("Comentário registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar comentário");
        }
    }
    
    public void alterar() {
        ComentarioDao dao = new ComentarioDao();
        try {            
            dao.Alterar(comentario);
            JSFUtil.mensagemSucesso("Comentário alterardo com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar comentário");
        }
    }  
    
    public void excluir() {
        ComentarioDao dao = new ComentarioDao();
        try {            
            dao.excluir(comentario);
            JSFUtil.mensagemSucesso("Comentário removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover comentário");
        }
    }  
}
