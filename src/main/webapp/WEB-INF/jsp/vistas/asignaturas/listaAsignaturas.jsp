<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de asignaturas</h1>
	<%@include file="../../menu.html"%>



	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/listarasignaturas" method="post">
				<label for="id">Id Asignatura</label> 
				<input type="text" id="id"name="id">
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre"><br>
				<label for="curso">Curso</label> 
				<input type="text" id="curso" name="curso"><br> 
				<label for="tasa">Tasa</label>
				<input type="text" id="tasa" name="tasa" >
				<input type="submit" value="Enviar">
			</form>
		</div>
			<table>
				<tr>
					<td>ID</td>
					<td>NOMBRE</td>
					<td>CURSO</td>
					<td>TASA</td>
				</tr>
				<c:forEach items="${listaAsignatura}" var="asignatura">
					<tr>
						<td>${asignatura.id}</td>
						<td>${asignatura.nombre}</td>
						<td>${asignatura.curso}</td>
						<td>${asignatura.tasa }</td>
					</tr>
				</c:forEach>
			</table>

	</div>

</body>
</html>