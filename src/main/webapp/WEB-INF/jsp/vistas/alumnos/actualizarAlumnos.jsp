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
	<h1>Actualizacion de de alumnos</h1>
	<%@include file="/menu.html"%>



	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioactualizaralumnos"
				method="post">
				<label for="id">Id Alumno</label>
				 <input type="text" id="id" name="id"> 
				 <label for="nombre">Nombre Alumno</label> 
				 <input type="text" id="nombre" name="nombre"><br> 
				 <input type="submit" value="Enviar">
			</form>
		</div>
		<c:if test="${empty lista}">
			<h3>No hay datillos</h3>
		</c:if>
		<c:if test="${not empty lista }">
				
				<c:forEach items="${lista}" var="alumno">
					<div class="form">
						<form action="http://localhost:8080/colegio/actualizaralumno" method="post" >
						 	 <input class="hidden" name="idOld" type="text" value="${alumno.id }">
							 <label for="id">Id Alumno</label>
							 <input type="text" id="id" name="id" value="${alumno.id}"> 
							 <label for="nombre">Nombre Alumno</label> 
							 <input type="text" id="nombre" name="nombre" value="${alumno.nombre}"><br> 
							 <select name="municipios"  >
							 	<c:forEach items="${comboMunicipio}" var="municipio" >
							 		<option value="${municipio.id }" >${municipio.descripcion }</option>
							 	</c:forEach>
							 		<option value="${alumno.idMunicipio }"  selected> ${alumno.municipio }</option>
							 </select>
							 <label for="familia" >Familia Numerosa</label>
							 <c:if test="${alumno.familiaNumerosa == 0}">
							 	<input name="familia" type="checkbox"  value= 0 >
							 </c:if>
							  <c:if test="${alumno.familiaNumerosa == 1}">
							 	<input name="familia" type="checkbox"  value= 1 checked>
							 </c:if>
							 <input type="submit" value="Enviar">
						
						</form>
					</div>
				</c:forEach>
		</c:if>
	</div>
</body>
</html>