<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/formularios.css">
	<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
<header>
<h2>Gestión de Colegio</h2>
</header>

<h1>Insercion de asignaturas</h1>
<%@include file="../../menu.html" %>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarasignaturas" method="post">
				 <label for="id">ID asignatura</label> 
				 <input type="text" id="id"name="id"> 
				 <label for="nombre">Nombre Asignatura</label>
				 <input type="text" id="nombre" name="nombre">
				 <label for="curso">Curso</label> 
				 <input type="text" id="curso" name="curso"><br>
				 <label for="tasa">Tasa</label> 
				 <input type="text" id="tasa" name="tasa">
				 <input type="submit" value="Insertar Asignatura">
			</form>
			<c:if test="${resultado == 1 }">
				<p>Asignatura insertada con exito</p>
			</c:if>
				
			</div>
	</div>
</body>
</html>