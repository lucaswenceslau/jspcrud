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


/* bonecas */
INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1001,
    1,
    "Boneca Unicornio",
    95.00,
    "img/boneca1.jpg",
    "Com a Boneca Unicornio, a hora de brincar ficará ainda mais real e divertida! Com um rostinho delicado e dobrinhas pelo corpo, esta bonequinha dá a sensação de cuidar de um bebê de verdade. Acompanha acessórios para deixar a brincadeira ainda mais real e divertida"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1002,
    5,
    "Blocos Construção",
    40.00,
    "img/bloco2.jpg",
    "Combine as peças grandes para construir a casa de brincar, esta é a introdução perfeita às habilidades básicas de construção. "
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1003,
    4,
    "Banco Imobiliário",
    60.00,
    "img/tabuleiro1.jpg",
    "O Banco Imobiliário é o mais moderno jogo de compra e venda de propriedades! Todas as transações agora serão feitas pelo cartão de crédito e as ações das companhias do jogo são reais!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1004,
    3,
    "Caminhão Cegonha",
    40.00,
    "img/carro2.jpg",
    "O Caminhão Cegonha transporta carros que acabaram de nascer (ops, que acabaram de serem fabricados). Além do caminhão, também acompanha 6 carrinhos dentro dele!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1005,
    1,
    "Boneca Padrão",
    30.00,
    "img/boneca2.jpg",
    "A Boneca Padrão é perfeita para tornar-se a primeira melhor amiga de uma menina. As bonecas vestem elegantes conjuntos projetados para combinar e complementar com acessórios como vistosos sapatos, acessórios para o cabelo e ornamentos divertidos. Inclui uma escova."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1006,
    3,
    "Caminhonete Amarela",
    35.00,
    "img/carro1.jpg",
    "Com a Caminhonete Amarela a imaginação percorre caminhos incríveis! É uma miniatura fabricada em metal com detalhes em plástico. Além de linda, a miniatura possui escala 1:43."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1007,
    5,
    "Blocos Primeira Fase",
    32.00,
    "img/bloco1.jpg",
    "Blocos Primeira Fase são ótimas ferramentas no aprendizado dos pequenos, além de estimular a imaginação das crianças desde cedo também são blocos macios e super fofinhos para crianças pequenas."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1008,
    4,
    "Quarto",
    30.00,
    "img/tabuleiro4.jpg",
    "O Quarto distingue-se por ser um jogo em que apenas existe um conjunto de peças para os dois jogadores em vez de um conjunto separado para cada jogador."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1009,
    1,
    "Boneca Laninha",
    50.00,
    "img/boneca3.jpg",
    "A Boneca Laninha é perfeita para tornar-se a primeira melhor amiga de uma menina. As bonecas vestem elegantes conjuntos projetados para combinar e complementar com acessórios como vistosos sapatos, acessórios para o cabelo e ornamentos divertidos. Inclui uma escova."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1010,
    3,
    "Trator Vermelho",
    25.00,
    "img/carro4.jpg",
    "Os pequenos adoradores de carros e caminhões vão se divertir muito com o Trator Vermelho! São diversas possibilidades de brincadeiras para a criançada!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1011,
    2,
    "Pelucia Simba",
    30.00,
    "img/pelucia1.jpg",
    "Pelúcia Simba do Filme O Rei Leão, super fofinha e gostosa de abraçar! Ele mede aproximadamente 25 cm de altura, e é confeccionado em pelúcia macia de alta qualidade e hipoalergênica, para garantir a segurança dos pequeninos na hora de brincar!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1012,
    2,
    "Pelucia Snorlax",
    50.00,
    "img/pelucia3.jpg",
    "Leve os Pokémons para a sua casa! Com a linha de Pelúcias Pokémon - 30 cm a diversão vai ser garantida! São pelúcias oficiais e licenciadas, inspiradas nos personagens do anime Pokémon e dos jogos da Nintendo!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1013,
    4,
    "WAR",
    90.00,
    "img/tabuleiro3.jpg",
    "O melhor jogo de estratégia de todos os tempos. Com War, uma batalha nunca é igual a outra, e cada jogador precisa usar toda sua inteligência e astúcia para derrotar seus adversários e conquistar territórios e continentes. Ideial para jogar com grupos de amigos lendários ;)"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1014,
    5,
    "Blocos Lego",
    80.00,
    "img/bloco3.jpg",
    "Descubra novas maneiras imaginativas de usar as janelas e portas na sua construção com o conjunto LEGO Classic."
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1015,
    4,
    "Xadrez",
    40.00,
    "img/tabuleiro2.jpg",
    "Tabuleiro de Xadrez + Peças, acompanha livro com instrucões de como jogar"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1016,
    3,
    "Helicoptero Elétrico",
    90.00,
    "img/carro3.jpg",
    "Os meninos vão adorar o Helicoptero Elétrico! O sortimento traz veículos com movimentos, figura e acessório!"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1017,
    2,
    "Pelucia Lulu",
    66.60,
    "img/pelucia4.jpg",
    "Baphomet fofinho de pelúcia! Todo feito a mão, com espuma e tecido de pelúcia! (23cm)"
);

INSERT INTO produto (idProduto, idCategoria, nomeProduto, precoUnitario, imgProduto, descricao) VALUES (
    1018,
    2,
    "Urso de Pelucia",
    25.00,
    "img/pelucia2.jpg",
    "O Urso de Pelúcia é super fofo e colorido, possui chocalho na barriguinha e cores vibrantes que vão estimular a sensibilidade visual e sonora dos pequenos, ajudando-os no desenvolvimento do seu aprendizado. É ideal para presentear!"
);