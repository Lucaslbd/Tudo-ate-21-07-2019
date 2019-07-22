package br.com.jlsistemas.webservice;

import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.Empresa;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("meuws")
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

    /**
     * PUT method for updating or creating an instance of JlsistemasResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
