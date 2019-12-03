CREATE DATABASE toytech

CREATE TABLE usuario
(
	idUsuario INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	PRIMARY KEY (idUsuario)
);


CREATE TABLE categoria
(
	idCategoria INT NOT NULL AUTO_INCREMENT,
	nomeCategoria VARCHAR(50) NOT NULL,
	PRIMARY KEY (idCategoria)
);


CREATE TABLE produto
(
	idProduto INT NOT NULL AUTO_INCREMENT,
	idCategoria INT NOT NULL,
	nomeProduto VARCHAR(50) NOT NULL,
	precoUnitario DECIMAL(10,2) NOT NULL,
    imgProduto VARCHAR(50) NOT NULL,
	descricao TEXT NOT NULL,
	PRIMARY KEY (idProduto),
	FOREIGN KEY (idCategoria) REFERENCES categoria (idCategoria)
);





[Create]
[Read]
[Update]
[Delete]


5 - Vitrine (R)
6 - Produto (R)

9 - Logar e Cadastrar(C, R)
10 - Cadastrar Cliente (C)

11 - Meus Pedidos (R)
12 - Alterar Dados (U)
12 - Excluir Conta (D)
13 - Carrinho ()

