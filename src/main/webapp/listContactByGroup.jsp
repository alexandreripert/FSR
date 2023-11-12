<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rechercher contacts d'un groupe</title>
</head>
<form method="post" action="ListContactsByGroupServlet">
<table>
			<tr>
				<th><h2>Rechercher contacts d'un groupe</h2></th>
				<tr>
					<td><i>id du groupe: <input type="text" name="groupId" size="25"></i></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
				
</table>
</form>
	<br>
	<a href="menuGroup.jsp"><h1>Retour</h1></a>
</html>