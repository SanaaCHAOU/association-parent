<%-- 
    Document   : init-db
    Created on : 26 févr. 2020, 01:04:31
    Author     : moham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Init database</title>
    </head>
    <body>
        <h1>Initialisation de la base de données</h1>
        <form method="POST" action="/association-parent/init-db">
            <input type="submit" value="Initialiser" />
        </form>
        
        <form method="POST" action="/association-parent/init-db">
            <input type="text" hidden="true" value="true" name="drop"/>
            <input type="submit" value="Remplacer" />
        </form>
    </body>
</html>
