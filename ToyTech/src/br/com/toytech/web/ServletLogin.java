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

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");		
		UsuarioDAO dao;
		Usuario usuario = new Usuario();
						
		try {
			dao = new UsuarioDAO();
			if (cmd.equalsIgnoreCase("logar")) {
				String username = request.getParameter("username");
				String senha = request.getParameter("senha");				
				usuario = dao.verificaUsuario(username);
								
				if ((usuario == null) || (!usuario.getSenha().toString().equals(senha))){
					request.setAttribute("message", "Usuário ou senha incorretos, tente novamente!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				} else if ((usuario.getUsername().toString().equals(username)) && (usuario.getSenha().toString().equals(senha))) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);		
					request.getRequestDispatcher("ServletProduto?cmd=listar").forward(request, response);
				}
			} 
			
			else if (cmd.equalsIgnoreCase("logout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				request.getRequestDispatcher("ServletProduto?cmd=listar").forward(request, response);
				
			} 
						
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
        
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
