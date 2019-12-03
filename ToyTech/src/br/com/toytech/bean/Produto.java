package br.com.toytech.bean;

public class Produto {
	private int idProduto;
	private int idCategoria;
	private String nomeProduto;
	private double precoUnitario;
	private String imgProduto;
	private String descricao;
	
	public Produto(int idProduto, int idCategoria, String nomeProduto, double precoUnitario, String imgProduto, String descricao) {
		this.idProduto = idProduto;
		this.idCategoria = idCategoria;
		this.nomeProduto = nomeProduto;
		this.precoUnitario = precoUnitario;
		this.imgProduto = imgProduto;
		this.descricao = descricao;
	}
	
	public Produto () {
		
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getImgProduto() {
		return imgProduto;
	}

	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	
}
