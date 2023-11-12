<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Création d'un groupe</title>
</head>
<form method="post" action="AddContactGroupServlet">
		<table>
			<tr>
				<th><h2>Créer un nouveau groupe</h2></th>
				<tr>
					<td><i>Nom du groupe: <input type="text" name="groupname" size="25"></i></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
		</table>
	</form>
</html>