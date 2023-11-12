<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des Contacts</title>
</head>
<body>
    <h2>Liste des Contacts du Groupe</h2>
    <c:if test="${not empty contacts}">
        <ul>
            <c:forEach items="${contacts}" var="contact">
                <li>${contact.firstName} ${contact.lastName}</li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty contacts}">
        <p>Pas de contacts dans ce groupe.</p>
    </c:if>
    
    	<br>
	<a href="menuGroup.jsp"><h1>Retour</h1></a>
</body>
</html>
