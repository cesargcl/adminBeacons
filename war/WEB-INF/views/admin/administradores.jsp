<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Administradores</title>
		<jsp:include page="_admin_includes.jsp"></jsp:include>
		<script src="/resources/js/usuarios_crud.js"></script>
	
	</head>
	
	<body>
		<div class="wrapper">
	
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"> BOXBLUE </a>
						<p class="navbar-text">Administración de Usuarios</p>
					</div>
	
					<jsp:include page="_admin_dropdown.jsp"></jsp:include>
				</div>
			</nav>
	
			<h4>Gestión de administradores</h4>
			
			<p>&nbsp;<a href="/admin/administradores?id=0" class="btn btn-default">Nuevo Administrador</a></p>
			
			<c:if test="${not empty mensajeError}">
			<p class="text-danger">${mensajeError}</p>
			</c:if>
			
			<c:if test="${not empty mensajeOk}">
			<p class="text-success">${mensajeOk}</p>
			</c:if>
			
			
			<table class="table table-hover">
  				<thead>
  					<tr>
  						<th>ID</th>
  						<th>Nombre</th>
  						<th>Usuario</th>
  						<th>Clave</th>
  						<th>&nbsp;</th>
  					</tr>
  				</thead>
  				
  				<tbody>
  					<c:choose>
  						<c:when test="${not empty lstAdministradores}">
	  						<c:forEach var="row" items="${lstAdministradores}">
			  					<tr>
			  						<td>${row.id}</td>
			  						<td>${row.nombre}</td>
			  						<td>${row.usuario}</td>
			  						<td>${row.clave}</td>
			  						<td><a href="/admin/administradores?id=${row.id}" class="btn btn-default">Editar</a>&nbsp;
			  							<a href="/admin/administradores?id=${row.id}&accion=e" class="btn btn-default">Eliminar</a>
			  						</td>
			  					</tr>
		  					</c:forEach>
  						</c:when>
  						<c:otherwise>
  							<tr><td colspan="4" >No hay usuarios de la aplicación</td></tr>
  						</c:otherwise>
  					</c:choose>

  				</tbody>
			</table>
			
			
			<c:if test="${not empty id}">
			
			<div class="innercontent">
			
			<form method="POST" action="">
			  
			  <input type="hidden" class="form-control" id="id" value="${administrador.id}">
			  
			  <div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="${administrador.nombre}" >
			  </div>
			  <div class="form-group">
			    <label for="usuario">Usuario</label>
			    <input class="form-control" id="usuario" name="usuario" placeholder="Usuario" value="${administrador.usuario}" >
			  </div>
			  <div class="form-group">
			    <label for="clave">Clave</label>
			    <input class="form-control" id="clave" name="clave" placeholder="clave" value="${administrador.clave}" >
			  </div>
			  
			  <button type="submit" class="btn btn-default">Guardar</button>
			  <button type="reset" class="btn btn-default">Limpiar</button>
			  <a href="/admin/administradores" class="btn btn-default">Cancelar</a>
			  
			  <input type="hidden" name="envio" value="1">
			  
			</form>
			
			</div>
				
			</c:if>
			
			
			
		</div>
	</body>
</html>