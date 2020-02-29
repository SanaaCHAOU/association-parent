<%-- 
    Document   : login_form
    Created on : 25 févr. 2020, 22:42:31
    Author     : moham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <style>
            .login {
                width : 300px;
                height: 500px;
                margin: 100px auto;
                box-shadow: 0 1px 1px gray;
            }
        </style>
    </head>
    <body>
        <div class="login">
            <form method="POST" action="/association-parent/login">
                <div>
                    <label>Email</label> <br>
                    <input type="text" required name="email"/>
                </div>
                <div>
                    <label>Mot de passe</label><br>
                    <input type="password" required name="mdp"/>
                </div>
                <input type="submit" value="Connecter"/>
            </form>
            <a href="/association-parent/inscription">Inscription</a>
        </div>
    </body>
</html>
