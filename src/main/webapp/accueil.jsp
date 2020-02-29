<%-- 
    Document   : accueil
    Created on : 25 févr. 2020, 23:09:29
    Author     : moham
--%>

<%@page import="business.Parent"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <jsp:useBean id="user" type="Parent"  scope="session"/>
        <h1>Vous être connecté</h1>
        <h4>User : <%=user.getNom() + " " + user.getPrenom()%></h4>
        <a href="/association-parent/souscription">Souscription</a>
    </body>
</html>
