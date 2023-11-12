<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rechercher un contact</title>
</head>
<form method="post" action="SearchByIdServelt">
<table>
			<tr>
				<th><h2>Rechercher un contact</h2></th>
				<tr>
					<td><i>id du contact: <input type="text" name="id" size="25"></i></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
</table>
	<br>
	<a href="menuContact.jsp"><h1>Retour</h1></a>
</html>