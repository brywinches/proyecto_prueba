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

<title>Actualizacion de producto</title>
</head>
<body>
	<header>
	<div class="card text-center">
		<h1>Actualizacion de producto</h1>
	</div>
	</header>
	<br>
	<div class="container">
		<section class=main">
		<form name="formIngresoProductos" action="ControladorProductos"
			method="get">
			<input type="hidden" name="instruccion" value="actualizarBBDD">
			<input type="hidden" name="codigo" value="${productoActualizar.codArticulo}">
			<!--  <div class="form-group row">
				<label for="codArt" class="col-sm-2 col-form-label">Codigo	artículo</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="codArt" name="codigo"	required>
				</div>
			</div> -->
			<div class="form-group row">
				<label for="seccion" class="col-sm-2 col-form-label">Sección</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="seccion" 
					name="seccion"	required value="${productoActualizar.seccion}">
				</div>
			</div>
			<div class="form-group row">
				<label for="nomArt" class="col-sm-2 col-form-label">Nombre
					artículo</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="nomArt"
						name="nomArticulo" required value="${productoActualizar.nomArticulo}">
				</div>
			</div>
			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="precio" name="precio"
						required value="${productoActualizar.precio}">
				</div>
			</div>
			<div class="form-group row">
				<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
				<div class="form-group mx-sm-3">
					<input type="date" class="form-control" id="fecha" name="fecha"
						required value="${productoActualizar.fecha}">
				</div>
			</div>
			<div class="form-group row">
				<label for="imnportado" class="col-sm-2 col-form-label">Importado</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="imnportado" name="imnportado"	required 
					value="${productoActualizar.importado}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="pOrigen" class="col-sm-2 col-form-label">Pais de origen</label>
				<div class="form-group mx-sm-3">
					<input type="text" class="form-control" id="pOrigen" name="pOrigen"	required 
					value="${productoActualizar.paisOrigen}"/>
				</div>
			</div>
			<div class="form-group mx-sm-3">
				<input class="btn btn-outline-success" name="enviar" type="submit"
					value="Enviar" /> <input class="btn btn-outline-danger"
					name="reestablecer" type="reset" value="Reestablecer" />
			</div>
		</form>
		</section>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>