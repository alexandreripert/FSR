<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<form method="post" action="UpdateContactServlet">
		<table>
			<tr>
				<th><h2>Voici un premier exemple de composant web avec un servlet</h2></th>
				<tr>
					<td><i>id: <input type="text" name="id" size="25"></i></td>
				</tr>
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
					<td><i>Phonekind: <input type="text" name="phonekind" size="25"></i></td>
				</tr>
				<tr>
					<td><i>PhoneNumber: <input type="text" name="phonenumber" size="25"></i></td>
				</tr>
				<tr>
					<td><i>PhoneKind2: <input type="text" name="phonekind2" size="25"></i></td>
				</tr>
				<tr>
					<td><i>PhoneNumber2: <input type="text" name="phonenumber2" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</html>