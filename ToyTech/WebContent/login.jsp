<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function validarLogin() {
		if (document.formLogin.username.value == "") {
			alert("Usuário não informado. Tente novamente");
			return false;
		}
		if (document.formLogin.senha.value == "") {
			alert("Senha não informada. Tente novamente");
			return false;
		}
		document.formLogin.submit();
	}
</script>

<meta charset="UTF-8">
<title>Toytech</title>
</head>
<body>

	<h3>${message}</h3>

	<form action="ServletLogin?cmd=logar" method="post" name="formLogin">
		Usuário:<input type="text" name="username" required><br>
		Senha:<input type="password" name="senha" required><br> 
		<input type="submit" value="Entrar" onclick="validarLogin()"> 
		<a href="index.jsp">Voltar</a>
	</form>

</body>
</html>



