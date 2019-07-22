package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProdutoDao;
import domain.Produto;

@WebServlet("/CadastroProduto")
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoDao dao = new ProdutoDao();

	public CadastroProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("redirect") != null) {
				int redirect = Integer.parseInt(request.getParameter("redirect"));
				if (redirect == 1) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_produto.jsp");
					request.setAttribute("produto",dao.buscarPorCodigo(Integer.parseInt(request.getParameter("id"))));
					dispatcher.forward(request, response);
				} else if (redirect == 2) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("tela_produto.jsp");
					request.setAttribute("produtos", dao.listar());
					dispatcher.forward(request, response);
				}
			} else {
				int crud = Integer.parseInt(request.getParameter("crud"));
				if (crud == 1) {
					if (dao.validarInsert(request.getParameter("codigo"))) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_produto.jsp?crud=1");
						request.setAttribute("msg", "Este codigo já pertence a um produto!!!");
						dispatcher.forward(request, response);
					} else {
						/*char[]v = request.getParameter("valor").toCharArray();
						String valor ="";
						for(int i = 2;i<v.length;i++) {
							valor += v[i];
						}*/
						Produto produto = new Produto();						
						produto.setCodigo(request.getParameter("codigo"));
						produto.setNome(request.getParameter("nome"));
						produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
						produto.setValor(Double.parseDouble(request.getParameter("valor")));
						dao.salvar(produto);
						RequestDispatcher dispatcher = request.getRequestDispatcher("tela_produto.jsp");
						request.setAttribute("produtos", dao.listar());
						dispatcher.forward(request, response);
					}
				} else if (crud == 2) {
					if (dao.validarUpdate(request.getParameter("codigo"), Integer.parseInt(request.getParameter("id")))) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro_produto.jsp?crud=2");
						request.setAttribute("msg", "Este codigo já pertence a um produto!!!");
						request.setAttribute("produto",dao.buscarPorCodigo(Integer.parseInt(request.getParameter("id"))));
						dispatcher.forward(request, response);
					} else {
						/*char[]v = request.getParameter("valor").toCharArray();
						String valor ="";
						for(int i = 2;i<v.length;i++) {
							valor += v[i];
						}*/
						Produto produto = new Produto();						
						produto.setCodigo(request.getParameter("codigo"));
						produto.setNome(request.getParameter("nome"));
						produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
						produto.setValor(Double.parseDouble(request.getParameter("valor")));
						produto.setId(Integer.parseInt(request.getParameter("id")));						
						dao.alterar(produto);
						RequestDispatcher dispatcher = request.getRequestDispatcher("tela_produto.jsp");
						request.setAttribute("produtos", dao.listar());
						dispatcher.forward(request, response);
					}
				} else if (crud == 3) {
					int codigo = Integer.parseInt(request.getParameter("id"));
					dao.excluir(codigo);
					RequestDispatcher dispatcher = request.getRequestDispatcher("tela_produto.jsp");
					request.setAttribute("produtos", dao.listar());
					dispatcher.forward(request, response);
				} else if (crud == 4) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("tela_produto.jsp");
					request.setAttribute("produtos", dao.pesquisar(request.getParameter("pesquisa")));
					request.setAttribute("pesq", request.getParameter("pesquisa"));
					dispatcher.forward(request, response);
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
