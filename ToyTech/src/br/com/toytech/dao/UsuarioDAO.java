package br.com.toytech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toytech.bean.Categoria;
import br.com.toytech.bean.Produto;
import br.com.toytech.bean.Usuario;
import br.com.toytech.util.ConnectionFactory;

public class UsuarioDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Usuario usuario;
	
	public UsuarioDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
		
	public Usuario verificaUsuario(String username) throws Exception {

		try {
			String SQL = "SELECT * FROM usuario WHERE username = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if (rs.next()) {				
				int idUsuario = rs.getInt("idUsuario");
				String nome = rs.getString("nome");
				String username_ms = rs.getString("username");
				String senha = rs.getString("senha");			
				usuario = new Usuario(idUsuario, nome, username_ms, senha);
				return usuario;
			
			} else {
				return null;
			}
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	

	public void salvar(Usuario usuario) throws Exception {
		
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			
			String SQL = "INSERT INTO usuario (nome, username, senha) values (?, ?, ?)";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsername());
			ps.setString(3, usuario.getSenha());
			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "UPDATE usuario SET nome = ?, username = ?, senha = ? WHERE idUsuario = ?";						
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
						
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsername());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getIdUsuario());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "DELETE FROM usuario WHERE idUsuario = ?";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, usuario.getIdUsuario());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}	

	public Usuario procurarUsuario(String idUsuario) throws Exception {
		try {
			String SQL = "SELECT * FROM usuario WHERE idUsuario = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, idUsuario);
			rs = ps.executeQuery();
			
			
			if (rs.next()) {				
				int idUsuario_ms = rs.getInt("idUsuario");
				String nome = rs.getString("nome");
				String username = rs.getString("username");
				String senha = rs.getString("senha");
				usuario = new Usuario(idUsuario_ms, nome, username, senha);
			}
			
			return usuario;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	// listar todos os produtos
	public List<Usuario> todosUsuarios() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM usuario");
			rs = ps.executeQuery();
			List<Usuario> list = new ArrayList<Usuario>();
			
			while (rs.next()) {
				int idUsuario = rs.getInt("idUsuario");
				String nome = rs.getString("nome");
				String username = rs.getString("username");
				String senha = rs.getString("senha");
				list.add(new Usuario(idUsuario, nome, username, senha));
			}			
			return list;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
}
