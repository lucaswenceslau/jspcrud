package br.com.toytech.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.toytech.bean.Categoria;
import br.com.toytech.bean.Produto;
import br.com.toytech.util.ConnectionFactory;

public class CategoriaDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Categoria categoria;

	public CategoriaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Categoria categoria) throws Exception {
		
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			
			String SQL = "INSERT INTO categoria (nomeCategoria) values (?)";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, categoria.getNomeCategoria());
			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "UPDATE categoria SET nomeCategoria = ? WHERE idCategoria = ?";						
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, categoria.getIdCategoria());
			ps.setString(2, categoria.getNomeCategoria());			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "DELETE FROM categoria WHERE idCategoria = ?";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, categoria.getIdCategoria());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}	

	public Categoria procurarCategoria(String idCategoria) throws Exception {
		try {
			String SQL = "SELECT * FROM categoria WHERE idCategoria = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, idCategoria);
			rs = ps.executeQuery();
			
			
			if (rs.next()) {				
				int idCategoria_ms = rs.getInt("idCategoria");
				String nomeCategoria = rs.getString("nomeCategoria");	
				categoria = new Categoria(idCategoria_ms, nomeCategoria);
			}
			
			return categoria;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	// listar todos os produtos
	public List todasCategorias() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM categoria");
			rs = ps.executeQuery();
			List<Categoria> list = new ArrayList<Categoria>();
			
			while (rs.next()) {
				int idCategoria = rs.getInt("idCategoria");
				String nomeCategoria = rs.getString("nomeCategoria");
				list.add(new Categoria(idCategoria, nomeCategoria));
			}			
			return list;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
}
