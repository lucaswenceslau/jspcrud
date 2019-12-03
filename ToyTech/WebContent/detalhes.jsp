<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.toytech.bean.Produto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Tech</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">
<link href="js/bootstrap.js" rel="javascript" media="screen">
<link href="js/bootstrap.min.js" rel="javascript" media="screen">

<style type="text/css">
body {
	padding-top: 60px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

footer {
	background-color: coral;
	height: 50px;
	text-align: center;
	padding: 30px;
	margin-top: 80px;
}
</style>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="index.jsp">Toy Tech</a>
				<div class="nav-collapse collapse">
				
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">Username</a>
					</p>

				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<jsp:useBean id="produto" scope="session"
		class="br.com.toytech.bean.Produto" />

	<div class="container-fluid" style="padding-top: 15px;">

		<div class="row-fluid">
			<div class="span3">
				<div>
					<center>
						<h2><%=produto.getNomeProduto()%></h2>
						<br/>
						<p>
							<img src="<%=produto.getImgProduto()%>" style="width: 300px;">
						</p>
					</center>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->


			<div class="span9">
				<div class="container-fluid">
					<div>
						<br>
						<table
							style="border-collapse: separate; border-spacing: 0 20px; margin-top: -8px;">
							<tr>
								<td style="font-weight: bold;">ID:</td>
								<td><%=produto.getIdProduto()%></td>
							</tr>

							<tr>
								<td style="font-weight: bold;">Preço:</td>
								<td><%=produto.getPrecoUnitario()%></td>
							</tr>

							<tr>
								<td style="font-weight: bold;">Categoria:</td>
								<td><%=produto.getIdCategoria()%></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
						</table>

						<h5>Descrição:</h5>
						<p><%=produto.getDescricao()%></p>
						<br />

						<p>
							<a class="btn" style="width: 90px;"
								href="http://localhost:8080/ToyTech/index.jsp">Voltar</a>
						</p>

					</div>
				</div>
			</div>

			<hr>

		</div>

		<footer>
			<p>&copy; Company 2013</p>
		</footer>
</body>
</html>