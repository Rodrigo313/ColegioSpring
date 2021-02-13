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

<h1>Insercion de notas</h1>
<%@include file="/menu.html" %>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarnotas" method="post">
				 <label for="nota">Nota</label> 
				 <input type="text" id="nota" name="nota"><br> 
				 <label for="fecha">Fecha</label> 
				 <input type="date" id="fecha" name="fecha"><br>
				 <label for="alumnos">Alumnos</label>
				 <select name="alumnos"  >
				 	<c:forEach items="${comboAlumnos}" var="alumnos" >
				 		<option value="${alumnos.id }">${alumnos.id } - ${alumnos.descripcion }</option>
				 	</c:forEach>
				 </select>
				 <label for="asignaturas">Asignaturas</label>
				  <select name="asignaturas"   >
				 	<c:forEach items="${comboAsignaturas}" var="asignaturas" >
				 		<option value="${asignaturas.id }">${asignaturas.id } - ${asignaturas.descripcion }</option>
				 	</c:forEach>
				 </select>
				 <input type="submit" value="Enviar">
			</form>
			<c:if test="${resultado == 1 }">
				<p>Nota insertado con exito</p>
			</c:if>
				
			</div>
	</div>
</body>
</html>