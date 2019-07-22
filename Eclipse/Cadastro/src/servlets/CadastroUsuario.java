package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDao;
import domain.Usuario;

@WebServlet("/salvarUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final UsuarioDao dao = new UsuarioDao();

	public CadastroUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("redirect") != null) {
				int redirect = Integer.parseInt(request.getParameter("redirect"));
				if (redirect == 1) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_usuario.jsp");
					request.setAttribute("usuario",dao.buscarPorCodigo(Integer.parseInt(request.getParameter("codigo"))));
					dispatcher.forward(request, response);
				} else if (redirect == 2) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("acesso_liberado.jsp");
					request.setAttribute("usuarios", dao.listar());
					dispatcher.forward(request, response);
				}
			} else {
				int crud = Integer.parseInt(request.getParameter("crud"));
				if (crud == 1) {
					if (dao.validarInsert(request.getParameter("email"))) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_usuario.jsp?crud=1");
						request.setAttribute("msg", "Este email j� pertence a um usu�rio!!!");
						dispatcher.forward(request, response);
					} else {
						Usuario usuario = new Usuario();
						usuario.setNome(request.getParameter("nome"));
						usuario.setTelefone(request.getParameter("telefone"));
						usuario.setEmail(request.getParameter("email"));
						usuario.setSenha(request.getParameter("senha"));
						dao.salvar(usuario);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
				} else if (crud == 2) {
					if (dao.validarUpdate(request.getParameter("email"), Integer.parseInt(request.getParameter("codigo")))) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_usuario.jsp?crud=2");
						request.setAttribute("msg", "Este email j� pertence a um usu�rio!!!");
						request.setAttribute("usuario",dao.buscarPorCodigo(Integer.parseInt(request.getParameter("codigo"))));
						dispatcher.forward(request, response);
					} else {
						Usuario usuario = new Usuario();
						usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
						usuario.setNome(request.getParameter("nome"));
						usuario.setTelefone(request.getParameter("telefone"));
						usuario.setEmail(request.getParameter("email"));
						usuario.setSenha(request.getParameter("senha"));
						dao.alterar(usuario);
						RequestDispatcher dispatcher = request.getRequestDispatcher("acesso_liberado.jsp");
						request.setAttribute("usuarios", dao.listar());
						dispatcher.forward(request, response);
					}
				} else if (crud == 3) {
					int codigo = Integer.parseInt(request.getParameter("codigo"));
					dao.excluir(codigo);
					RequestDispatcher dispatcher = request.getRequestDispatcher("acesso_liberado.jsp");
					request.setAttribute("usuarios", dao.listar());
					dispatcher.forward(request, response);
				} else if (crud == 4) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("acesso_liberado.jsp");
					request.setAttribute("usuarios", dao.pesquisar(request.getParameter("pesquisa")));
					request.setAttribute("pesq", request.getParameter("pesquisa"));
					dispatcher.forward(request, response);
				}else if(crud == 5) {
					if (dao.logar(request.getParameter("email"), request.getParameter("senha"))) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");				
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						request.setAttribute("msg", "Senha ou usu�rio invalido!!!");
						dispatcher.forward(request, response);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
