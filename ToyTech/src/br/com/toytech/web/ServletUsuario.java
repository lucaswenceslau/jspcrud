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

import br.com.toytech.bean.Usuario;
import br.com.toytech.dao.UsuarioDAO;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");		
		UsuarioDAO dao;
		Usuario usuario = new Usuario();
						
		try {
			dao = new UsuarioDAO();
			RequestDispatcher rd = null;
			
			if (cmd.equalsIgnoreCase("mostrar")) {
				List<Usuario> usuarioList = dao.todosUsuarios();
				request.setAttribute("usuarioList", usuarioList);
				rd = request.getRequestDispatcher("/listUsuario.jsp");
			}
						
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(usuario);
				rd = request.getRequestDispatcher("ServletUsuario?cmd=mostrar");
			} 
				
			else if (cmd.equalsIgnoreCase("exc")) {
				usuario = dao.procurarUsuario(Integer.toString(usuario.getIdUsuario()));
				HttpSession session = request.getSession(true);
				session.setAttribute("usuario", usuario);
				rd = request.getRequestDispatcher("/excUsuario.jsp");
			}
			
			else if (cmd.equalsIgnoreCase("excluir")) {	
				dao.excluir(usuario);
				rd = request.getRequestDispatcher("/listUsuario.jsp");
				
			} 
			
			else if (cmd.equalsIgnoreCase("atu")) {
				usuario = dao.procurarUsuario(Integer.toString(usuario.getIdUsuario()));
				HttpSession session = request.getSession(true);
				session.setAttribute("usuario", usuario);
				rd = request.getRequestDispatcher("/altUsuario.jsp");
				
			} 
			
			else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(usuario);
				rd = request.getRequestDispatcher("/listUsuario.jsp");
				
			} 
			
						
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
