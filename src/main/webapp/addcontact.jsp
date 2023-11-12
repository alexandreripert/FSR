<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form method="post" action="AddContactServlet">
		<table>
			<tr>
				<th><h2>Voici un premier exemple de composant web avec un servlet</h2></th>
				<tr>
					<td><i>first name: <input type="text" name="fname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>last name: <input type="text" name="lname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>email: <input type="text" name="email" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Country: <input type="text" name="country" size="25"></i></td>
				</tr>
				<tr>
					<td><i>City: <input type="text" name="city" size="25"></i></td>
				</tr>
				<tr>
					<td><i>zip: <input type="text" name="zip" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Street: <input type="text" name="street" size="25"></i></td>
				</tr>
				<tr>
					<td><i>phoneKind: <input type="text" name="phoneKind" size="25"></i></td>
				</tr>
				<tr>
					<td><i>phoneNumber: <input type="text" name="phoneNumber" size="25"></i></td>
				</tr>
								<tr>
					<td><i>phoneKind2: <input type="text" name="phoneKind2" size="25"></i></td>
				</tr>
				<tr>
					<td><i>phoneNumber2: <input type="text" name="phoneNumber2" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</html>