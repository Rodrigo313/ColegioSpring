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

<h1>Insercion de alumnos</h1>
<%@include file="../../menu.html" %>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarAlumnos" method="post">
				 <label for="id">DNI Alumno</label> 
				 <input type="text" id="id"name="id"> 
				 <label for="nombre">Nombre Alumno</label>
				 <input type="text" id="nombre" name="nombre"><br> 
				 <select name="municipios"   >
				 	<c:forEach items="${comboMunicipio}" var="municipio" >
				 		<option value="${municipio.id }">${municipio.descripcion }</option>
				 	</c:forEach>
				 </select>
				 <label for="familia">Familia Numerosa</label>
				 <input name="familia" type="checkbox" value=1>
				 <input type="submit" value="Enviar">
			</form>
			</div>
			<c:if test="${resultado == 1 }">
				<p>Alumno insertado con exito</p>
			</c:if>
	</div>
</body>
</html>
