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
	<h1>Actualizacion de notas</h1>
	<%@include file="/menu.html"%>



	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/formulariomodificarnotas"
				method="post">
				<label for="nombre">Nombre Alumno</label> <input type="text"
					id="nombre" name="nombre"><br> <label for="nombre">Asignatura</label>
				<input type="text" id="asignatura" name="asignatura"><br>
				<label for="nombre">Fecha</label> <input type="date" id="fecha"
					name="fecha"><br> <input type="submit" value="Enviar">
			</form>
		</div>

		<c:forEach items="${lista}" var="notas">
			<div class="form">
				<form action="http://localhost:8080/colegio/modificarnotas"method="post">
					<input class="hidden" name="id" type="text" value="${notas.id }">
					<label for="nota">Nota</label> 
					<input type="text" id="nota" name="nota" value=${notas.nota }><br>
					<label for="fecha">Fecha</label> 
					<input type="date" id="fecha"name="fecha" value=${notas.fecha }><br> 
					<label for="alumnos">Alumnos</label> <select name="alumnos">
						<c:forEach items="${comboAlumnos}" var="alumnos">
							<option value="${alumnos.id }">${alumnos.id } - ${alumnos.descripcion }</option>
						</c:forEach>
						<option value="${notas.idAlumno }" selected>${notas.idAlumno } - ${notas.nombreAlumno }</option>
					</select> 
					<label for="asignaturas">Asignaturas</label> 
					<select name="asignaturas">
						<c:forEach items="${comboAsignaturas}" var="asignaturas">
							<option value="${asignaturas.id }">${asignaturas.id } - ${asignaturas.descripcion }</option>
						</c:forEach>
						<option value="${notas.idAsignatura }" selected>${notas.idAsignatura } - ${notas.nombreAsignatura }</option>
					</select> <input type="submit" value="Modificar">

				</form>

			</div>
		</c:forEach>
		<c:if test="${resultado == 1 }">
			<p>Asignatura modificada con exito</p>
		</c:if>

	</div>
</body>
</html>