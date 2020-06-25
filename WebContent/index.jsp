<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loggin - Crear factura</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!--  <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css">  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css" >
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
		
		    <%
		    String msgError = (String) request.getAttribute("_msgError_");
		    if( msgError != null) {
		    	String mensajeError = "<div class='alert alert-danger' role='alert'>"
		    			+ msgError 
		    	        + "</div>";
		    	        out.println( mensajeError );
		    }
		    
		    String msgInfo = (String) request.getAttribute("_msgInfo_");
		    if( msgInfo != null) {
		    	String mensaje = "<div class='alert alert-primary' role='alert'>"
		    			+ msgInfo
		    	        + "</div>";
		    	        out.println( mensaje );
		    }
		    %>

			<div class="fadeIn first">
				<img src="https://image.flaticon.com/icons/svg/1548/1548286.svg"
					id="icon" alt="User Icon" />
			</div>

			<form action="procesaLogin" method="POST">
				<input type="text" id="login" class="fadeIn second" name="login" placeholder="login" required>
				<input type="password" id="password" class="fadeIn second" name="pass" placeholder="password" required>
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<div id="formFooter">
				<a class="underlineHover" href="#">Olvido la clave?</a>
			</div>

		</div>
	</div>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>