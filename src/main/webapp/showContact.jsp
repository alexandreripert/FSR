<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails du contact</title>
</head>
<body>
    <h2>Détails du contact</h2>
    <p>ID: ${contact.idContact}</p>
    <p>Prénom et nom: ${contact.firstName} ${contact.lastName}</p>
    <p>Email: ${contact.email}</p>
    <c:if test="${not empty contact.address}">
        <p>Adresse: ${contact.address.street}, ${contact.address.city}, ${contact.address.zip}, ${contact.address.country}</p>
    </c:if>
    
    <br>
	<a href="menuContact.jsp"><h1>Retour</h1></a>
</body>
</html>
