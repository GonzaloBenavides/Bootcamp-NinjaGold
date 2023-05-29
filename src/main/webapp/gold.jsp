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

	<div class="container p-2 center">
		<h1>Bienvenido a Ninja Gold</h1>

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
	<div class="container p-2">
		<div class=row>
			<div class="card col mx-2 ">
				<form action="/Gold/granja" method="POST">
					<h2 class="text-center">GRANJA</h2>
					<p>(gana 10~20 oro)</p>
					<input type="hidden" name="action" value="granja" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Buscar
						oro!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/Gold/cueva" method="POST">
					<h2 class="text-center">CUEVA</h2>
					<p>(gana 5~10 oro)</p>
					<input type="hidden" name="action" value="cueva" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Buscar
						oro!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/Gold/casa" method="POST">
					<h2 class="text-center">CASA</h2>
					<p>(gana 2~5 oro)</p>
					<input type="hidden" name="action" value="casa" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Buscar
						oro!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/Gold/casino" method="POST">
					<h2 class="text-center">CASINO</h2>
					<p>(gana/pierde 0~50 oro)</p>
					<input type="hidden" name="action" value="casino" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Buscar
						oro!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/Gold/spa" method="POST">
					<h2 class="text-center">SPA</h2>
					<p>(pierde 5~20 oro)</p>
					<input type="hidden" name="action" value="spa" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Buscar
						oro!</button>
				</form>
			</div>

		</div>
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