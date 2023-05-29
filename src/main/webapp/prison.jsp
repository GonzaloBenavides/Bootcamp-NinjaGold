<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div class="container p-2">
		<h1>Bienvenido a Ninja Prison</h1>

		<c:if test="${oro >= 0}">
			<h2 class="positivo">Tu oro: ${oro}</h2>
		</c:if>
		<c:if test="${oro < 0}">
			<h2 class="negativo">Tu oro: ${oro}</h2>
		</c:if>
		<a href="/Gold/reset" style="text-decoration: none; color: black">
			<button class="btn btn-danger" type="button" name="action">
				RESET!</button>
		</a>
	</div>
	<br>
	<div class="container p-2">
		<div class="row">
			<div class="card border-0 col mx-2 ">
				<table class="table border rounded table-hover table-fixed">
					<tbody>
						<c:forEach items="${mensajes}" var="m">
							<tr>
								<td>${m.msg}</td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>



</body>
</html>