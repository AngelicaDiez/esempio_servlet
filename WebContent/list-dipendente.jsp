<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendente Management Application</title>
</head>
<body>
	<h1 align="center">Dipendente Management</h1>
	<h2 align="center">
		<a href="new">Aggiungi un dipendente</a> &nbsp;&nbsp;&nbsp; <a href="list">Lista dei dipendenti</a>
	</h2>

	<div align="center">
		<table border="1">
			<caption>Lista dei dipendenti</caption>
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Cognome</td>
				<td>Codice fiscale</td>
				<td>Telefono</td>
			</tr>
			<c:forEach var="dipendente" items="${listDipendente}">
				<tr>
					<td><c:out value="${dipendente.id}" /></td>
					<td><c:out value="${dipendente.nome}" /></td>
					<td><c:out value="${dipendente.cognome}" /></td>
					<td><c:out value="${dipendente.cod_fiscale}" /></td>
					<td><c:out value="${dipendente.telefono}" /></td>
					<td><a href="edit?id=<c:out value='${dipendente.id}' />">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>