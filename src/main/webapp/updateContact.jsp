<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mettre à jour un contact</title>
</head>
<form method="post" action="UpdateContactServlet">
		<table>
			<tr>
				<th><h2>Mettre à jour un contact</h2></th>
				<tr>
					<td><i>id du contact: <input type="text" name="id" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Prénom: <input type="text" name="fname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Nom: <input type="text" name="lname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Email: <input type="text" name="email" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Pays: <input type="text" name="country" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Ville: <input type="text" name="city" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Code postal: <input type="text" name="zip" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Rue: <input type="text" name="street" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Premier téléphone: <input type="text" name="phoneKind" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Premier numéro de téléphone: <input type="text" name="phoneNumber" size="25"></i></td>
				</tr>
								<tr>
					<td><i>Deuxième téléphone: <input type="text" name="phoneKind2" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Deuxième numéro de téléphone: <input type="text" name="phoneNumber2" size="25"></i></td>
				</tr>
				
				<tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
	    <br>
	<a href="menuContact.jsp"><h1>Retour</h1></a>
</html>