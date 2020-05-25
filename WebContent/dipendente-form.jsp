<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendente Managment Application</title>
</head>
<body>
	<h1 align="center">Dipendente Managment</h1>
	<h2 align="center">
		<a href="new">Aggiungi un nuovo dipendente</a> &nbsp;&nbsp;&nbsp; <a
			href="list">Lista di tutti i dipendenti</a>
	</h2>

	<div align="center">
		<c:if test="${dipendente != null}">
			<form action="update" method="post">
		</c:if>

		<c:if test="${dipendente == null }">
			<form action="insert" method="post">
		</c:if>

		<table border=1>
			<caption>
				<c:if test="${dipendente != null }">
					Edit Dipendente
				</c:if>

				<c:if test="${dipendente == null }">
					Aggiungi nuovo dipendente
				</c:if>
			</caption>

			<c:if test="${dipendente != null}">
				<input type="hidden" name="id" value="<c:out value='${dipendente.id}' />" />
			</c:if>
			<tr>
			<c:if test="${dipendente == null }">
				<th>ID:</th>
				<td><input type="text" name="id" 
					value="<c:out value='${dipendente.id }' />" /></td>
			</c:if>
				<th>Nome:</th>
				<td><input type="text" name="nome" size="45"
					value="<c:out value='${dipendente.nome}' />" /></td>
			</tr>
			<tr>
				<th>Cognome</th>
				<td><input type="text" name="cognome" size="45"
					value="<c:out value='${dipendente.cognome}' />" /></td>
			</tr>
			<tr>
				<th>Codice fiscale</th>
				<td><input type="text" name="cod_fiscale" size="15"
					value="<c:out value='${dipendente.cod_fiscale}' />" /></td>
			</tr>
			<tr>
				<th>Telefono</th>
				<td><input type="text" name="telefono" size="15"
					value="<c:out value='${dipendente.telefono}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>