CREATE TABLE usuario
(
	idUsuario INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(50) NOT NULL,
	PRIMARY KEY (idUsuario)
);

INSERT INTO usuario (nome, username, senha) VALUES ("Maria", "maria123", "123");