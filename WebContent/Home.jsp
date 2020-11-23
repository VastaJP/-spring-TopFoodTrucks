<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesión</title>
</head>
<body>
	<div align="center" style="padding: 5%;">
		<h2>Iniciar sesión</h2>
		<p>
			Ingrese nombre de usario y contraseña para iniciar sesión
		</p>
		<form action="Login" method="get">
			<label id="userName" for="userName">Nombre de usuario</label><br>
			<input type="text" name="userName" id="userName">
			<br><br>
			<label id="password" for="password">Contraseña</label><br>
			<input type="password" name="password" id="password">
			<br><br>
			<button type="submit">continuar</button>
		</form>
	</div>
	
</body>
</html>