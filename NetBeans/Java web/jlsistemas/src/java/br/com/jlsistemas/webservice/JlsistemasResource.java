package br.com.jlsistemas.webservice;

import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.Empresa;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("generic")
public class JlsistemasResource {

    @Context
    private UriInfo context;

    
    public JlsistemasResource() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("empresa/get/{login}/{senha}")
    public String getUsuario(@PathParam("login") String login, @PathParam("senha") String senha) {
        EmpresaDao dao = new EmpresaDao();
        try {
            Empresa empresa = dao.autenticar(login, senha);
            Gson g = new Gson();
            return g.toJson(empresa);
        } catch (SQLException ex) {
            return "Erro:" + ex;
        }
    }  
    
    
    
    /*@POST
    @Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("empresa/inserir2")
    public String inserir2(String content) {
        Gson g = new Gson();
        Comentario u = (Comentario) g.fromJson(content, Comentario.class);
        ComentarioDao dao = new ComentarioDao();
        try {             
            dao.Salvar(u);
            return "Inserido com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Erro ao inserir:" + ex;
        }
    }
    
    /*@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("empresa/alterar")
    public String putJson(String content) {
        Gson g = new Gson();
        Empresa u = (Empresa) g.fromJson(content, Empresa.class);
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Alterar2(u);
            return "Alterado com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Erro ao alterar:" + ex;
        }
    }*/
}
