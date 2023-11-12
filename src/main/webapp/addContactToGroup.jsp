<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form method="post" action="AddContactToGroupServlet">
		<table>
			<tr>
				<th><h2>Voici un premier exemple de composant web avec un servlet</h2></th>
				<tr>
					<td><i>idContact: <input type="text" name="contactId" size="25"></i></td>
				</tr>
				<tr>
					<td><i>idGroup: <input type="text" name="groupId" size="25"></i></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
		</table>
	</form>
</html>