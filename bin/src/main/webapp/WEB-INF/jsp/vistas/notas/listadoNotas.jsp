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
	<h1>Lista de notas</h1>
	<%@include file="/menu.html"%>



	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/listadonotas"
				method="post">
				<label for="id">Id Alumno</label> 
				<input type="text" id="id" name="id"> 
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre" name="nombre"><br> 
				<label for="nombre">Asignatura</label> 
				<input type="text" id="asignatura" name="asignatura"><br> 
				<label for="nombre">Nota</label> 
				<input type="text" id="nota" name="nota"><br> 
				<label for="nombre">Fecha</label> 
				<input type="date" id="fecha" name="fecha"><br> 
				<input type="submit" value="Enviar">
			</form>
		</div>

			<table>
				<tr>
					<td>ID ALUMNO</td>
					<td>NOMBRE ALUMNO</td>
					<td>ASIGNATURA</td>
					<td>NOTA</td>
					<td>FECHA</td>
				</tr>
				<c:forEach items="${lista}" var="notas">
					<tr>
						<td>${notas.idAlumno}</td>
						<td>${notas.nombreAlumno}</td>
						<td>${notas.nombreAsignatura}</td>
						<td>${notas.nota}</td>
						<td>${notas.fecha}</td>
					</tr>
				</c:forEach>
			</table>
		

	</div>

</body>
</html>