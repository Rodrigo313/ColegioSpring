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
	<%@include file="../../menu.html"%>
	<div class="container">
		<h3>Borrado de Alumnos</h3>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioborraralumnos"
				method="post">
				<label for="id">Id Alumno</label>
				 <input type="text" id="id" name="id"> 
				 <label for="nombre">Nombre Alumno</label> 
				 <input type="text" id="nombre" name="nombre"><br> 
				 <input type="submit" value="Enviar">
				 
			</form>
				<c:forEach items="${lista}" var="alumno">
					<div class="form">
						<form action="http://localhost:8080/colegio/borraalumnos" method="post" >
							 <label for="id">Id Alumno</label>
							 <input readonly type="text" id="id" name="id" value="${alumno.id}"> 
							 <label for="nombre">Nombre Alumno</label> 
							 <input readonly type="text" id="nombre" name="nombre" value="${alumno.nombre}"><br> 
							 <label for="municipio">Municipio</label>
							 <input readonly type="text" id="municipio" name="municipio" value="${alumno.municipio }"><br>
							 <input type="submit" value="Borrar">
						</form>
					</div>
			</c:forEach>
			<c:if test="${resultado == 1 }">
				<p>Alumno borrada con exito</p>
				</c:if>
		</div>
	</div>
</body>
</html>