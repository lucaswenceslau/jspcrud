package br.com.toytech.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toytech.bean.Categoria;
import br.com.toytech.dao.CategoriaDAO;

@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		CategoriaDAO dao;
		Categoria categoria = new Categoria();
				
		try {
			dao = new CategoriaDAO();
			RequestDispatcher rd = null;
			 
			if (cmd.equalsIgnoreCase("mostrar")) {
				List<Categoria> categoriaList = dao.todasCategorias();
				request.setAttribute("categoriaList", categoriaList);
				rd = request.getRequestDispatcher("/listCategoria.jsp");
			}
						
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(categoria);
				rd = request.getRequestDispatcher("ServletCategoria?cmd=listar");
			} 
				
			else if (cmd.equalsIgnoreCase("exc")) {
				categoria = dao.procurarCategoria(Integer.toString(categoria.getIdCategoria()));
				HttpSession session = request.getSession(true);
				session.setAttribute("categoria", categoria);
				rd = request.getRequestDispatcher("/excCategoria.jsp");
			} 
			
			else if (cmd.equalsIgnoreCase("excluir")) {	
				dao.excluir(categoria);
				rd = request.getRequestDispatcher("listCategoria.jsp");
				
			} 
			
			else if (cmd.equalsIgnoreCase("atu")) {
				categoria = dao.procurarCategoria(Integer.toString(categoria.getIdCategoria()));
				HttpSession session = request.getSession(true);
				session.setAttribute("categoria", categoria);
				rd = request.getRequestDispatcher("/altCategoria.jsp");
				
			} 
			
			else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(categoria);
				rd = request.getRequestDispatcher("listCategoria.jsp");
				
			} 
						
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
