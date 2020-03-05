<%-- 
    Document   : confirm_souscription
    Created on : 2 mars 2020, 23:39:17
    Author     : moham
--%>

<%@page import="business.Enfant"%>
<%@page import="business.CalculatriceSouscription"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/sign-in/">

        <!-- Bootstrap core CSS -->
        <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
        .validation {
                width: 50%;
                margin: 20px auto;
            }    
        </style>
        
    </head>
    <body>
        <jsp:useBean id="enfants" type="List<Enfant>"  scope="session"/>
        <jsp:useBean id="calculatrice" type="CalculatriceSouscription"  class="business.CalculatriceSouscription" scope="application"/>
        <div class="validation">
            <h1>Récap des souscriptions</h1>
            <table class="table">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Niveau</th>
                    <th>Type d'Assurance</th>
                    <th>Prix</th>
                </tr>
                <% 
                    //CalculatriceSouscription calculatrice = new CalculatriceSouscription();
                    for(Enfant enfant: enfants) { %>
                <tr>
                    <td><%=enfant.getNom()%></td>
                    <td><%=enfant.getPrenom()%></td>
                    <td><%=enfant.getNiveau()%></td>
                    <td><%=enfant.getSouscription().getTypeSouscription()%></td>
                    <td><%=calculatrice.getPrix(enfant)%></td>
                </tr>
                <% } %>
                <tr>
                    <td colspan="4">Total</td>
                    <td><%=calculatrice.getPrixTotal(enfants)%></td>
                </tr>
            </table>
            <form method="POST" action="/association-parent/validation">
            <input type="submit" value="Valider" class="btn btn-success"/>
            <a href="/association-parent/souscription" class="btn btn-primary"> Retour </a>
        </form>
        </div>
        
    </body>
</html>
