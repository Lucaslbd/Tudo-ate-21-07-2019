package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.ComentarioDao;
import br.com.jlsistemas.domain.Comentario;
import br.com.jlsistemas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBComentarioListar")
@ViewScoped
public class ComentarioListar {
    
    private ArrayList<Comentario> lista;

    public ArrayList<Comentario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Comentario> lista) {
        this.lista = lista;
    }
    
    public void listar(){
        ComentarioDao dao = new ComentarioDao();
        try {
            lista = dao.Listar();            
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar comentário");
        }
    }
}
