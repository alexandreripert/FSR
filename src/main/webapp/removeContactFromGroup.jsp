<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retirer contact d'un groupe</title>
</head>
<form method="post" action="RemoveContactFromGroupServlet">
		<table>
			<tr>
				<th><h2>Retirer contact d'un groupe</h2></th>
				<tr>
					<td><i>id du contact: <input type="text" name="contactId" size="25"></i></td>
				</tr>
				<tr>
					<td><i>id du groupe: <input type="text" name="groupId" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</html>