<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*,entities.Producto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">

<title>Lista de productos</title>
</head>


<body>
	
	<header>
	<div class="card text-center">
	<h1>Lista de productos</h1>
	</div>
	</header>
	<br>
	<div class="container">
	<section class=main">
	<div>
		<input class="btn btn-primary" type="button" value="Insertar Registro" 
		onclick="window.location.href='inserta_producto.jsp'"/>
	</div>
	<br>
	<table class="table table-sm table-dark">
		<thead class="thead-light">
			<tr>
				<th>Código artículo</th>
				<th>Sección</th>
				<th>Nombre artículo</th>
				<th>Fecha</th>
				<th>Precio</th>
				<th>Importado</th>
				<th>Pais de origen</th>
			</tr>
		</thead>
		<c:forEach var="e" items="${listaProductos}">
		<!-- Link para cada producto con su codigo -->
		<c:url var="linkTemp" value="ControladorProductos">
		<c:param name="instruccion" value="cargar"></c:param>
		<c:param name="CArticulo" value="${e.codArticulo}"></c:param>
		</c:url>
		
			<tr>
				<td>${e.codArticulo}</td>
				<td>${e.seccion}</td>
				<td>${e.nomArticulo}</td>
				<td>${e.precio}</td>
				<td>${e.fecha}</td>
				<td>${e.importado}</td>
				<td>${e.paisOrigen}</td>
				<td><a href="${linkTemp}">Modificar</a></td>
			</tr>
		</c:forEach>
	</table>
	</section>
	</div>
	


	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>