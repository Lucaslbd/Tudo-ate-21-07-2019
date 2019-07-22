package ws;

import Domain.Contatos;
import com.google.gson.Gson;
import dao.ContatosDao;
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

@Path("generic")
public class App {

    @Context
    private UriInfo context;

    public App() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Contatos/list")
    public String ListUsuario() {
        ContatosDao dao = new ContatosDao();
        Gson g = new Gson();
        try {
            ArrayList<Contatos> lista = dao.Listar();
            return g.toJson(lista);
        } catch (SQLException ex) {
            return g.toJson("Erro:" + ex);
        }
    }

    @GET//pesquisa
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Contatos/get/{nome}")
    public String getUsuario(@PathParam("nome") String nome) {
        ContatosDao dao = new ContatosDao();
        Gson g = new Gson();
        System.out.println(nome);
        try {
            ArrayList<Contatos> lista = dao.buscar(nome);
            return g.toJson(lista);
        } catch (SQLException ex) {
            return g.toJson("Erro:" + ex);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Contatos/inserir")
    public String inserir(String content) {
        Gson g = new Gson();
        Contatos u = (Contatos) g.fromJson(content, Contatos.class);
        ContatosDao dao = new ContatosDao();
        try {
            dao.Salvar(u);
            return g.toJson("Inserido com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
            return g.toJson("Erro ao inserir:" + ex);
        }
    }

    @PUT//alterar
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Contatos/alterar")
    public String putJson(String content) {
        Gson g = new Gson();
        Contatos u = (Contatos) g.fromJson(content, Contatos.class);
        ContatosDao dao = new ContatosDao();
        try {
            dao.Alterar(u);
            return g.toJson("Alterado com sucesso");
        } catch (SQLException ex) {
            System.out.println(ex);
            return g.toJson("Erro ao alterar:" + ex);
        }
    }

    @DELETE//deletar
    @Path("Contatos/excluir/{codigo}")
    public String excluir(@PathParam("codigo") int codigo) {
        ContatosDao dao = new ContatosDao();
        Gson g = new Gson();
        try {
            dao.excluir(codigo);
            return g.toJson("Removido com sucesso");
        } catch (SQLException ex) {
            return g.toJson("Erro: " + ex);
        }
    }
}
