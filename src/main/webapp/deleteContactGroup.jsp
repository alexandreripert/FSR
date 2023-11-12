<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supprimer un groupe</title>
</head>
<form method="post" action="DeleteContactGroupServlet">
		<table>
			<tr>
				<th><h2>Supprimer un groupe</h2></th>
				<tr>
					<td><i>id du groupe: <input type="text" name="id" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</html>