CREATE TABLE categoria
(
	idCategoria INT NOT NULL AUTO_INCREMENT,
	nomeCategoria VARCHAR(50) NOT NULL,
	PRIMARY KEY (idCategoria)
);

INSERT INTO categoria (nomeCategoria) VALUES ("bonecas");
INSERT INTO categoria (nomeCategoria) VALUES ("pelucias");
INSERT INTO categoria (nomeCategoria) VALUES ("carrinhos");
INSERT INTO categoria (nomeCategoria) VALUES ("tabuleiros");
INSERT INTO categoria (nomeCategoria) VALUES ("blocos");