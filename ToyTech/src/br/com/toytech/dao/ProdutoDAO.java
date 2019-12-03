package br.com.toytech.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.toytech.bean.Produto;
import br.com.toytech.util.ConnectionFactory;
public class ProdutoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Produto produto;

	public ProdutoDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Produto produto) throws Exception {
		
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			
			String SQL = "INSERT INTO produto (idProduto,idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) values (?, ?, ?, ?, ?, ?)";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getIdProduto());
			ps.setInt(2, produto.getIdCategoria());
			ps.setString(3, produto.getNomeProduto());
			ps.setDouble(4, produto.getPrecoUnitario());
			ps.setString(5, produto.getImgProduto());
			ps.setString(6, produto.getDescricao());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE produto set idCategoria=?, nomeProduto=?, precoUnitario=?, imgProduto=?, descricao=? WHERE idProduto = ?";						
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, produto.getIdCategoria());
			ps.setString(2, produto.getNomeProduto());
			ps.setDouble(3, produto.getPrecoUnitario());
			ps.setString(4, produto.getImgProduto());
			ps.setString(5, produto.getDescricao());
			ps.setInt(6, produto.getIdProduto());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM produto WHERE idProduto = ?";
			conn = this.conn;			
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, produto.getIdProduto());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar produto
	public Produto procurarProduto(int idProduto) throws Exception {
		try {
			String SQL = "SELECT * FROM produto WHERE idProduto=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idProduto);
			rs = ps.executeQuery();
			
			
			if (rs.next()) {				
				int idProduto_ms = rs.getInt("idProduto");
				int idCategoria = rs.getInt("idCategoria");
				String nomeProduto = rs.getString("nomeProduto");
				double precoUnitario = rs.getDouble("precoUnitario");
				String imgProduto = rs.getString("imgProduto");
				String descricao = rs.getString("descricao");			
				produto = new Produto(idProduto_ms, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao);
			}
			
			return produto;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os produtos
	public List todosProdutos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM produto");
			rs = ps.executeQuery();
			List<Produto> list = new ArrayList<Produto>();
			
			while (rs.next()) {
				int idProduto = rs.getInt("idProduto");
				int idCategoria = rs.getInt("idCategoria");
				String nomeProduto = rs.getString("nomeProduto");
				double precoUnitario = rs.getDouble("precoUnitario");
				String imgProduto = rs.getString("imgProduto");
				String descricao = rs.getString("descricao");
				list.add(new Produto(idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao));
			}			
			return list;
			
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	// listar todos os produtos de determinadas categorias
		public List listarProdutosCategoriaX(int idCategoria) throws Exception {
			try {
				String SQL = "SELECT * FROM produto WHERE idCategoria = ?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, idCategoria);
				rs = ps.executeQuery();
				List<Produto> list = new ArrayList<Produto>();
				
				while (rs.next()) {
					int idProduto = rs.getInt("idProduto");
					int idCategoria_ms = rs.getInt("idCategoria");
					String nomeProduto = rs.getString("nomeProduto");
					double precoUnitario = rs.getDouble("precoUnitario");
					String imgProduto = rs.getString("imgProduto");
					String descricao = rs.getString("descricao");
					list.add(new Produto(idProduto, idCategoria_ms, nomeProduto, precoUnitario, imgProduto, descricao));
				}
				
				return list;
				
			} catch (SQLException sqle) {
				throw new Exception(sqle);
				
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
}
