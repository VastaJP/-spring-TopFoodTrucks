<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesi�n</title>
</head>
<body>
	<div align="center" style="padding: 5%;">
		<h2>Iniciar sesi�n</h2>
		<p>
			Ingrese nombre de usario y contrase�a para iniciar sesi�n
		</p>
		<form action="Login" method="get">
			<label id="userName" for="userName">Nombre de usuario</label><br>
			<input type="text" name="userName" id="userName">
			<br><br>
			<label id="password" for="password">Contrase�a</label><br>
			<input type="password" name="password" id="password">
			<br><br>
			<button type="submit">continuar</button>
		</form>
	</div>
	
</body>
</html>