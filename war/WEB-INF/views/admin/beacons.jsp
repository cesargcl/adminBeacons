<!DOCTYPE html>
<html>
	<head>
		<title>Admin Beacons</title>
		<jsp:include page="_admin_includes.jsp"></jsp:include>
		<script src="/resources/js/beacon_crud.js"></script>
	
	</head>
	
	<body>
		<div class="wrapper">
	
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"> BOXBLUE </a>
						<p class="navbar-text">Administración de pantallas</p>
					</div>
	
					<jsp:include page="_admin_dropdown.jsp"></jsp:include>
	
				</div>
			</nav>
	
			<h4>Administrador de Beacons</h4>
			<div id="grid"></div>
		</div>
	</body>
</html>