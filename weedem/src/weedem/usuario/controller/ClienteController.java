package weedem.usuario.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;
import weedem.utils.conexao.FabricaConexao;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet({"/inserir", "/listar", "/buscar", "/detalhes", "/editar", "/excluir" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
	private FabricaConexao fabricaConexao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();
		 
	        try {
	            switch (action) {
	            case "/novo":
	                novoClienteForm(request, response);
	                break;
	            case "/inserir":
	                inserirCliente(request, response);
	                break;
	            case "/excluir":
	                excluirCliente(request, response);
	                break;
	            case "/detalhes":
	                detalheCliente(request, response);
	                break;
	            case "/editar":
	                atualizar(request, response);
	                break;
	            default:
	                listarClientes(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Cliente> listaClientes = clienteDAO.listarTodos();
		request.setAttribute("listaCliente", listaClientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListaClientes");
		dispatcher.forward(request, response);
		
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		//String email = request.getParameter("email");
		//String cpf = request.getParameter("cpf");
		//String endereco = request.getParameter("endereco");
		
		Cliente cliente = new Cliente();
		clienteDAO.atualizar(cliente);
		response.sendRedirect("list");
		
	}

	private void detalheCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente clienteExistente = clienteDAO.buscarPorId(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DetalheCliente.jsf");
		request.setAttribute("cliente", clienteExistente);
		dispatcher.forward(request, response);
		
	}

	private void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		clienteDAO.excluir(id);
		response.sendRedirect("list");
		
	}

	private void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		//String email = request.getParameter("email");
		//String cpf = request.getParameter("cpf");
		//String endereco = request.getParameter("endereco");
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(nome);
		clienteDAO.inserir(novoCliente);
		response.sendRedirect("list");
		
		
		
	}

	private void novoClienteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("NovoClienteForm.jsf");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
