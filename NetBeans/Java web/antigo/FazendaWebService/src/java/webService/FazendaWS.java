package webService;

import com.google.gson.Gson;
import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

@Path("fazenda")
public class FazendaWS {

    @Context
    private UriInfo context;

    public FazendaWS() {
    }

    @GET//pesquisa
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/{login}/{senha}")
    public String getUsuario(@PathParam("login") String login, @PathParam("senha") String senha) {
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario;
        try {
            usuario = dao.buscar(login, senha);
            Gson g = new Gson();
            return g.toJson(usuario);
        } catch (SQLException ex) {
            return "Erro:" + ex;
        }
    }

    @GET//pesquisa
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/list")
    public String ListUsuario() {
        UsuarioDao dao = new UsuarioDao();
        try {
            ArrayList<Usuario> lista = dao.Listar();
            Gson g = new Gson();
            return g.toJson(lista);
        } catch (SQLException ex) {
            return "Erro:" + ex;
        }
    }

    @POST//inserir
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/inserir")
    public String inserir(String content) {
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDao dao = new UsuarioDao();
        try {
            dao.Salvar(u);
            return "Inserido com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Erro ao inserir:" + ex;
        }
    }

    @PUT//alterar
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/alterar")
    public String putJson(String content) {
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDao dao = new UsuarioDao();
        try {
            dao.Alterar(u);
            return "Alterado com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Erro ao alterar:" + ex;
        }
    }

    @DELETE//deletar
    @Path("Usuario/excluir/{login}/{senha}")
    public String excluir(@PathParam("login") String login, @PathParam("senha") String senha) {
        UsuarioDao dao = new UsuarioDao();
        try {
            Usuario u = dao.buscar(login, senha);
            dao.excluir(u);
            return "Excluido com sucesso";
        } catch (SQLException ex) {
            return "" + ex;
        }
    }
}
