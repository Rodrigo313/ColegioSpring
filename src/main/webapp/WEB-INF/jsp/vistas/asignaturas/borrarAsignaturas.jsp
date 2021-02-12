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
		<h3>Borrado de Asignaturas</h3>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioborrarasignaturas"
				method="post">
				 <label for="id">ID asignatura</label> 
				 <input type="text" id="id"name="id"> 
				 <label for="nombre">Nombre Asignatura</label>
				 <input type="text" id="nombre" name="nombre">
				 <label for="curso">Curso</label> 
				 <input type="text" id="curso" name="curso"><br>
				 <label for="tasa">Tasa</label> 
				 <input type="text" id="tasa" name="tasa">
				 <input type="submit" value="Enviar">
				 
			</form>
				<c:forEach items="${lista}" var="asignatura">
					<div class="form">
						<form action="http://localhost:8080/colegio/borrarasignaturas" method="post" >
							 <label for="id">ID asignatura</label> 
							 <input readonly type="text" id="id"name="id" value="${asignatura.id }"> 
							 <label for="nombre">Nombre Asignatura</label>
							 <input readonly type="text" id="nombre" name="nombre" value="${asignatura.nombre }">
							 <label for="curso">Curso</label> 
							 <input readonly type="text" id="curso" name="curso" value="${asignatura.curso }"><br>
							 <label for="tasa">Tasa</label> 
				 			 <input readonly type="text" id="tasa" name="tasa" value="${asignatura.tasa }">
							 <input type="submit" value="Borrar">
						</form>
					</div>
			</c:forEach>
			<c:if test="${resultado == 1 }">
				<p>Asignatura borrada con exito</p>
				</c:if>
		</div>
	</div>
</body>
</html>